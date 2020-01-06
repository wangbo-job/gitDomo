/**
 * 
 */
app.controller('baseController',function($scope){
	
	$scope.ids=[];   //封装的批删id的集合
	//复选框选中状态封装成一个数组传到后台进行批量删除
    $scope.updateChecked=function($event,id){
		if($event.target.checked){
			$scope.ids.push(id);
		}else{
			$scope.ids.splice($scope.ids.indexOf(id),1);
		}
		/*if($event.target.checked){
			$scope.ids.push(id);
		} else{
			var idx=$scope.ids.indexOf(id);
			$scope.ids.splice(idx,1);
		}*/
		
	}  
    
  //分页控件配置 
	$scope.paginationConf = {
	 currentPage: 1,
	 totalItems: 10,
	 itemsPerPage: 5,
	 perPageOptions: [5, 10, 15, 20, 25],
	 onChange: function(){
	        	 $scope.reloadList();//重新加载
	 }
  }; 
	
	//重新加载列表 数据
	$scope.reloadList=function(){
		 //切换页码  
	$scope.findPage($scope.paginationConf.currentPage, $scope.paginationConf.itemsPerPage);
	}
	
	
})