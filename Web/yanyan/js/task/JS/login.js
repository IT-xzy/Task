angular.module('myApp',[])
    .controller('siteCtrl',['$scope','$http','$state',function($scope,$http,$state) {
        $scope.login=function () {
            $http({
                method:"POST",
                url: "/carrots-admin-ajax/a/login",
                headers: {"Content-Type": "application/x-www-form-urlencoded"},
                params: {name: $scope.names, pwd: $scope.pwd}
            })
                .then(function (response) {
                    if (response.data.code!==0){
                        $scope.errorNote=response.data.message;
                    }
                    else {
                        $state.go("main.welcome",{});
                    }
                })
        }
    }]);
