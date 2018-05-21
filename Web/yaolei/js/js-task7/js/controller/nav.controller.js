angular.module('myApp').controller('nav',function ($scope) {
    $scope.a=[true,true,true,true,true,true,true];
    $scope.toggle = function (x) {
        $scope.a[x]=!$scope.a[x]
    }
});