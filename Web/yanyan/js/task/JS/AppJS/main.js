/**
 * Created by MACHENIKE on 2017/8/3.
 */
angular.module('myApp')
    .controller('manageCtrl',['$scope','$rootScope','$http','$state',function ($scope, $rootScope, $http, $state) {
    // 侧边栏刷新保留高亮
    $rootScope.state=$state;
        console.log($rootScope.state);

    // 退出登录
    $scope.quit = function () {
        $scope.quitConfirm = confirm("确认退出？");
        if($scope.quitConfirm === true){
            $http({
                method:'POST',
                url:'/carrots-admin-ajax/a/logout',
                headers: {"Content-Type": "application/x-www-form-urlencoded"}
            }).then(function(response){
                if(response.data.code !== 0) {
                    alert(response.data.message)
                }
                else{
                    $state.go("login",{});
                    alert("退出成果！")
                }
            });
        }
    }
}]);