package com.aisile.portal.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aisile.content.service.ContentService;
import com.aisile.pojo.PageResult;
import com.aisile.pojo.TbContent;
import com.aisile.pojo.TbContentCategory;
import com.aisile.pojo.TbItemCat;
import com.aisile.pojo.entity.Resoult;
import com.alibaba.dubbo.config.annotation.Reference;

@RestController
@RequestMapping("/content")
public class CotentController {

	@Reference
	ContentService contentService;
	
	@RequestMapping("/findByPage")
	public PageResult findByPage(@RequestBody TbContent content,Integer page,Integer size){
		return contentService.findByPage(content, page, size);
	}
	
	@RequestMapping("/add")
	public Resoult add(@RequestBody TbContent content){
		try {
			contentService.add(content);
			return new Resoult(true, "添加成功");
		} catch (Exception e) {
			// TODO: handle exception
		}
		return new Resoult(false, "添加失败");
	}
	@RequestMapping("/update")
	public Resoult update(@RequestBody TbContent content){
		try {
			contentService.update(content);
			return new Resoult(true, "修改成功");
		} catch (Exception e) {
			// TODO: handle exception
		}
		return new Resoult(false, "修改失败");
	}
	
	@RequestMapping("/dels")
	public Resoult dels(@RequestBody Long [] ids){
		try {
			contentService.dels(ids);
			return new Resoult(true, "删除成功");
		} catch (Exception e) {
			// TODO: handle exception
		}
		return new Resoult(false, "删除失败");
	}
	
	@RequestMapping("/findOne")
	public TbContent findOne(Long id){
		return contentService.findOne(id);
	}
	
	@RequestMapping("/findByCateId")
	public List<TbContent> findByCateId(Long id){
		return contentService.findByCateId(id);
	}
	
	@RequestMapping("/findItemCatAll")
	public List<TbItemCat> findItemCatAll(){
		return contentService.findItemCatAll();
	}
	
}
