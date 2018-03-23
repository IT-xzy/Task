angular.module('App')
//退出登陆
.controller('userCtr',[ '$http', '$scope','$stateParams','$state',function ($http,$scope,$stateParams,$state) {
    $scope.logout=function () {
        $http({
            method:'Post',
            url:'/carrots-admin-ajax/a/logout' ,
            params:{}
        }).then(function(response){
            if(response.data.code===0){
                $state.go('login')
            }

        },function(response){
            //失败时执行
            console.log(response);
        });
    }

}])