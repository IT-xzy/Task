angular.module('myApp').controller('myCtrl',function ($scope,$http,$state) {
    $scope.user = {};
    $scope.submit1 = function () {
        $http({
            method : 'POST',
            url    : '/carrots-admin-ajax/a/login',
            params : $scope.user
        }).then(function successCallback(admin) {
            if(admin.data.code===0){
                $state.go('houtai')
            }else {
                alert("账密不正确！")
            }
        });
    };
});