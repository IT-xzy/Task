//接口数据“类型”过滤器

angular.module('app').filter('typeFilter',function(){   
	return function(type){
		for(var i = 0; i < 3; i++){
			if (type===0) {
				type="首页Banner";
			}else if (type===1) {
				type="找职位Banner";
			}else if (type===2) {
				type="找精英banner"
			}else if (type===3) {
				type="行业大图";
			}

		}
		return type;
	} 
});


//上线下线过滤器

angular.module('app').filter('upDown',function(){
	return function(status){
		for(var i = 1; i < 2; i++){
			if (status==1) {
				status="上线";
			}else {
				status="下线";
			}
		}
		return status;
	}
});

//接口数据“状态”过滤器

angular.module('app').filter('statusFilter',function(){    
	return function(status){
		for(var i = 1; i < 2; i++){
			if (status==1) {
				status="草稿";
			}else {
				status="上线";
			}
		}
		return status;
	}
});