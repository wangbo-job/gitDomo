/**
 * 
 */
app.controller('brandController',function($scope,$controller,brandService,typetemplateService){
	$controller('baseController',{$scope:$scope});//继承	
	
	//点击删除进行删除
	$scope.deletePs=function(){
		brandService.deletePs($scope.ids).success(
      			  function(a){
          			  if(a.flag){
          				  $scope.reloadList();
          				  $scope.ids=[];
          			  }else{
          				  alert("删除失败")
          			  }
          		  }	  
      	  )
	}
	
	
	//查询一个
	$scope.findBrandList=function(){
		brandService.findBrandList().success(
   			  function(a){
       			  $scope.brandList=a;
       		  }	  
   	  )
	}
	

	
	//分页
	$scope.findPage=function(page,rows){	
		brandService.findPage(page,rows).success(
				function(response){
					$scope.brandListPage=response.rows;	
					$scope.paginationConf.totalItems=response.total;//更新总记录数
				}			
		);
	}

	//修改的数据回现
	$scope.findOne=function(id){
		brandService.findOne(id).success(
				function(a){
					$scope.brand=a;
				}			
		);
	}
	

	//添加或者修改
	$scope.addAndUpdate =function(){
		var and=brandService.add($scope.brand);
		if($scope.brand.id!=null){
			and=brandService.update($scope.brand);;
		}
		and.success(
				function(a){ 
					if(a.flag){
						$scope.reloadList();
						typetemplateService.realUpdate().success(
							 	function(a){
							 		if(a){
							 			alert(a.magess);
							 		}else{
							 			alert(a.magess);
							 		}
							 	}
						  )
					} 
				}			
		);
	}
	
})