var myApp = angular.module('app');
myApp.controller('myCtrl', function($scope,$state,serviceHTTP) {
   var data = {};
    $scope.submit= function (){ 
    		data.name=$scope.name;
    	    data.pwd=$scope.uname;
    	

	 serviceHTTP.loginHTTP(data).then(function (response) {
		console.log(response);      
		if (response.data.code === 0) {      
			   $state.go('page.list'); 
		}
			
		});  

    	
    };
    

});