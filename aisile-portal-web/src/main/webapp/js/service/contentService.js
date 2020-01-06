/**
 * 
 */
app.service('contentService',function($http){

	this.findByCateId=function(id){
		return $http.post('../content/findByCateId.do?id='+id);
	}
	
})