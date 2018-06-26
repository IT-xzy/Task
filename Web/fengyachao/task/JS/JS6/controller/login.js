//登录页面控制器
angular.module('App')
    .controller('logCtrl', function ($scope, $state, $http, ArticleManagementService) {
        sessionStorage.clear();
        $scope.param = {};
        $scope.myLogin = function () {
            //请求登录
            ArticleManagementService.myLogin($scope.param)
                .then(function (response) {
                    if(response.data.code === 0){
                        $state.go('list');
                        sessionStorage.setItem('log-in', 1);
                    }else {
                        $scope._test = response.data.message;
                    }
                })
        };
    });
