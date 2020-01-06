package com.aisile.portal.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aisile.content.service.ContentCategoryService;
import com.aisile.content.service.ContentService;
import com.aisile.pojo.PageResult;
import com.aisile.pojo.TbContent;
import com.aisile.pojo.TbContentCategory;
import com.aisile.pojo.entity.Resoult;
import com.alibaba.dubbo.config.annotation.Reference;

@RestController
@RequestMapping("/category")
public class CotentCategoryController {

	@Reference
	ContentCategoryService categoryService;
	
	@RequestMapping("/findByPage")
	public PageResult findByPage(@RequestBody TbContentCategory category,Integer page,Integer size){
		return categoryService.findByPage(category, page, size);
	}
	
	@RequestMapping("/add")
	public Resoult add(@RequestBody TbContentCategory category){
		try {
			categoryService.add(category);
			return new Resoult(true, "添加成功");
		} catch (Exception e) {
			// TODO: handle exception
		}
		return new Resoult(false, "添加失败");
	}
	@RequestMapping("/update")
	public Resoult update(@RequestBody TbContentCategory category){
		try {
			categoryService.update(category);
			return new Resoult(true, "修改成功");
		} catch (Exception e) {
			// TODO: handle exception
		}
		return new Resoult(false, "修改失败");
	}
	@RequestMapping("/dels")
	public Resoult dels(@RequestBody Long [] ids){
		try {
			categoryService.dels(ids);
			return new Resoult(true, "删除成功");
		} catch (Exception e) {
			// TODO: handle exception
		}
		return new Resoult(false, "删除失败");
	}
	
	@RequestMapping("/findAll")
	public List<TbContentCategory> findAll(){
		
		return categoryService.findAll();
	}
		
	@RequestMapping("/findOne")
	public TbContentCategory findOne(Long id){
		return categoryService.findOne(id);
	}
	
	
}
