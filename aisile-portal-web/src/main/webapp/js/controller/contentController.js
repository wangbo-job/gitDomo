/**
 * 
 */
app.controller('contentController',function($scope,$controller,contentService,$location){
	$controller('baseController',{$scope:$scope});//继承	
	
	$scope.contentLis=[];//整个页面的集合
	$scope.q="sdadASdasdasdasdasdasdasdasfSADF";//整个页面的集合
	//查询
	$scope.findByCateId=function(id){
		//alert(id)
		contentService.findByCateId(id).then(
			  function(a){
				  console.log(a.data);
				  $scope.contentLis[id]=a.data;
			  }	
		  )
	}
	
	//加载查询字符串
	$scope.loadkeywords=function(){
		$scope.searchMap.keywords=  $location.search()['keywords'];
		$scope.search();
	}
	
	//搜索跳转
	$scope.search=function(){
		location.href="http://localhost:9104/search.html#?keywords="+$scope.keywords;
	}
	
})