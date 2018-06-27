routerApp.controller('MyController', function($scope, $state) {
    $scope.abc = "nice";//需要传的参数值
    $scope.def = 10;//需要传的参数值
    $scope.pwd=82545156;
    $scope.toResult = function(){
        $state.go('result',{id: $scope.abc,number: $scope.def,pwd:$scope.pwd});
    }
});