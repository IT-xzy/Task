myApp.controller("list", function ($scope, $http, $state, $stateParams, $log) {
    $scope.oneAtatime = true;
    $scope.showMe=true;
    $scope.showMe1=true;
    $scope.showMe2=true;
    $scope.oops=function () {
        $scope.showMe=!$scope.showMe;
        $scope.showMe1=true;
        $scope.showMe2=true;
    };
    $scope.oops1=function () {
        $scope.showMe1=!$scope.showMe1;
        $scope.showMe=true;
        $scope.showMe2=true;
    };
    $scope.oops2=function () {
        $scope.showMe2=!$scope.showMe2;
        $scope.showMe1=true;
        $scope.showMe=true;
    }
});
myApp.controller("off", function ($scope, $http, $state, $stateParams, $log, request) {
    $scope.loginout = function () {
        request.articleOff().then(
            function(data){
                if(data.data.code===0){
                    window.location.href="index.html";
                }
            }
        )
        ;
    }
});