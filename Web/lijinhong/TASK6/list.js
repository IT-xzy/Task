
angular.module('app').controller( 'listCtrl', function($scope,$http,$state,$stateParams) {
	$scope.data=$stateParams;
	console.log($scope.data);

// formatDateTime(inputTime); 
$scope.selcet= function(){
		// console.log($scope.data.startAt);
		// 	$scope.data.startAt=new Date(parseInt($scope.data.startAt));
		// 	$scope.data.endAt=new Date(parseInt($scope.data.endAt));
		// 	console.log($scope.data.startAt);
		// 			var params={
		// 	page:$scope.data.page,
		// 	size:$scope.data.size,
		// 	status:$scope.data.status,
		// 	type:$scope.data.type

		
		// console.warn($scope.data.startAt);
	// params.startAt = (new Date($scope.data.startAt)).getTime();
	
	$http({
			method: 'GET',    //请求方式
			url:" /carrots-admin-ajax/a/article/search",    //请求地址
			headers:{"Content-type": "application/x-www-form-urlencoded;charset=UTF-8"},
			params:$scope.data
		}).then(function(a) {

			console.log(a);
			$scope.names = a.data.data.articleList;
			$scope.lastPage=Math.ceil(a.data.data.total/a.data.data.size);
			$scope.arr = [];
			for(var i = 0;i < $scope.lastPage;i++){
				$scope.arr[i]=i;
			}


		});  
	};

	 $scope.selcet();      //自执行获取全部数据
	 $scope.search = function(){
	 	var params={
	 		status:$scope.data.status,
	 		type:$scope.data.type

	 	};
	// 	console.warn($scope.data.startAt);
	// params.startAt = (new Date($scope.data.startAt)).getTime();
	// params.endAt = (new Date($scope.data.endAt)).getTime();
		$state.go("page.list",$scope.data,{reload:true});   //点击搜索传参跳转页面
		console.log("success");

	};
	$scope.eliminate = function(){
		var eliminateData={
			type:'',
			status:'',
			startAt:'',
			endAt:'',
			page:1,
			size:10,
		}
			
		
		$state.go("page.list",eliminateData,{reload:true});  //为清空按钮添加点击事件；
		
	

	};
	$scope.go= function(){
		$state.go("page.list",{'size':$scope.data.size, 'page':$scope.data.page},{reload:true}); 
	};
		$scope.lastPage=function(){           //末页

				$state.go("page.list",{ 'page':9},{reload:true}); 

			};
			$scope.firstPage=function(){        //首页

				$state.go("page.list",{ 'page':1},{reload:true}); 

			}












	// 页面删除


	$scope.eradicate= function(id){
		
		$http({
			method:'delete',    //请求方式
			url:"/carrots-admin-ajax/a/u/article/"+id, //请求地址
		}).then(function(b) {
		console.log(b);       //打印返回的数据
		if (b.data.code === 0) {
			alert("确定要删除吗？");
		location.reload(); // 刷新当前页面
	}
	
});  
	}

	//上下线功能


	$scope.change= function(id,status){
		var newStatus = status==1?2:1;
		$http({
			method:'PUT',    //请求方式
			url:"/carrots-admin-ajax/a/u/article/status", //请求地址
			params:{id:id,status:newStatus},
		}).then(function(c) {
		console.log(c.config.params);       //打印返回的数据
		// if (c.data.code==0) {
		// 	alert("确定要下线吗？");
		// }
		if (newStatus == 1) {
			alert("您确定要下线吗？");
			c.config.params.status=2;
			
		}else if (newStatus == 2) {
			alert("您确定要上线吗？");
			c.config.params.status=1;
		}
		location.reload(); 
	});  
	}

	// 编辑功能
	
	$scope.edit= function(){
		$state.go('page.list.new',{
			id : this.x.id
		},{
			reload:true
		}
		)


	}; 	 
	if($stateParams.id){
		$scope.pageTitle = '编辑Article';
		$http({
			method: 'get',
			url:'/carrots-admin-ajax/a/article/' + $stateParams.id
		}).then(function (res) {
			console.log(res);
			$scope.title= res.data.data.article.title;
			console.log($scope.title);
			$scope.type= res.data.data.article.type+"";
			$scope.content= res.data.data.article.content;
			$scope.url= res.data.data.article.url;
			$scope.img= res.data.data.article.img;
			console.log($scope.img);



		})
	}else {
		$scope.pageTitle = '新增Article';
	}	
	
	
});




