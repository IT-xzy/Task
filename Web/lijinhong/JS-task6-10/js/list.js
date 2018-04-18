
angular.module('app').controller( 'listCtrl', function($scope,$state,$stateParams,serviceHTTP) {
	// $scope.data=$stateParams;
	console.log($stateParams);
	$scope.ctrlScope = $scope;


	$scope.ctrlScope.type =$stateParams.type;
	$scope.ctrlScope.status =$stateParams.status;
	$scope.ctrlScope.page =$stateParams.page;
	$scope.ctrlScope.size =$stateParams.size;

	console.log($stateParams.endAt);
	var a =Number($stateParams.endAt);
	var b =Number($stateParams.startAt);
	console.log(a);
	function timestampToTime(timestamp) {
        var date = new Date(timestamp);
        Y = date.getFullYear() + '-';
        M = (date.getMonth()+1 < 10 ? '0'+(date.getMonth()+1) : date.getMonth()+1) + '-';
        D = date.getDate() + ' ';
        return Y+M+D;
    }
    var time= timestampToTime(a);
    var time2 =timestampToTime(b);
    if (isNaN(a) ===true || isNaN(b) ===true ) {
       $scope.ctrlScope.endTime = undefined ;
       $scope.ctrlScope.startTime = undefined;
    } ;
    if (isNaN(a) ===false){
    	$scope.ctrlScope.endTime = time;
        $scope.ctrlScope.startTime = undefined;

    };
     if (isNaN(b) === false) {
    	$scope.ctrlScope.endTime = undefined;
        $scope.ctrlScope.startTime = time2;
    };
    if (isNaN(a) ===false && isNaN(b) === false) {
    	$scope.ctrlScope.endTime = time;
        $scope.ctrlScope.startTime = time2;
    }
  
 
  

	
	//渲染初始列表
serviceHTTP.searchHTTP($stateParams).then(function(a) {
			$scope.names = a.data.data.articleList;
			var lastPage=Math.ceil(a.data.data.total/a.data.data.size); //计算分页总数
			$scope.lastPage= lastPage;

			$scope.arr = [];	
			for(var i = 0;i < $scope.lastPage;i++){
				$scope.arr[i]=i;
			}

			$scope.last=function(){           //点击跳转末页
				$state.go("page.list",{ page:$scope.lastPage}); 

			}
		    $scope.firstPage=function(){        //点击跳转首页

			$state.go("page.list",{ page:1},{reload:true}); 

		}
			$scope.eliminate = function(){      //点击清空
				var eliminateData={
					type:'',
					status:'',
					startAt:'',
					endAt:'',
					page:1,
					size:10,
				}
				$state.go("page.list",eliminateData,{reload:true});  
			};

		})  
 
	
		$scope.search = function(params){
		
			myData={
				type:$scope.ctrlScope.type,
				status:$scope.ctrlScope.status,
				endAt: new Date($scope.ctrlScope.endTime).getTime() || undefined,
				startAt:new Date($scope.ctrlScope.startTime).getTime() || undefined
			}

		 $state.go("page.list",myData,{reload:true});   //点击搜索传参跳转页面
		

	};
	var fyParmas={};
	$scope.go= function(){
		
			fyParmas.size=$scope.ctrlScope.size;
			fyParmas.page=$scope.ctrlScope.page;
		$state.go("page.list",fyParmas,{reload:true}); 
	};

	// 页面删除


	$scope.eradicate= function(id){
		var id =id;
		serviceHTTP.deleteHTTP(id).then(function(b) {
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
		var status={
			id:id,
			status:newStatus
		};
serviceHTTP.statusHTTP(status).then(function(c) {
		console.log(c.config.params);       
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
			id : this.x.id      //将ID值传入URL
		},{
			reload:true
		}
		)
	}; 	 
	
	// if($stateParams.id){
	// 	$scope.editPage = true;
	// 	$http({
	// 		method: 'get',
	// 		url:'/carrots-admin-ajax/a/article/' + $stateParams.id
	// 	}).then(function (res) {
	// 		console.log(res);
	// 		$scope.title= res.data.data.article.title;
	// 		console.log($scope.title);
	// 		$scope.type= res.data.data.article.type+"";
	// 		$scope.content= res.data.data.article.content;
	// 		$scope.url= res.data.data.article.url;
	// 		$scope.img= res.data.data.article.img;
	// 		console.log($scope.img);




	// 	});
	// }else{
	// 	$scope.newPage = true;
	// }
	
	
});




