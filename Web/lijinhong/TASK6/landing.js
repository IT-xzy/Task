var myApp = angular.module('app');
myApp.controller('myCtrl', function($scope,$http,$state) {

    $scope.submit= function (){          //为button创建一个ng-click函数
    	$http({
		method: 'POST',
		url:" /carrots-admin-ajax/a/login", 
		params:{name:$scope.name,pwd:$scope.uname},  // 向后台传递的双向绑定都的数据。
		headers:{'Content-Type':'application/x-www-form-urlencoded'},


	}).then(function successCallback(response) {
		console.log(response);       //打印返回的数据
		if (response.data.code === 0) {      //判断返回的数据如果code等于0则请求成功。
			   $state.go('page.list'); //跳转页面
		}
			
		});  

    	
    };
    

});