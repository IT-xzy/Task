angular.module('App')
.controller('logCtr',function ($scope,$state,$http) {
   
    $(document).keypress(function(e) {
        // 回车键事件
        if(e.which == 13) {
            jQuery("#submit").click();
        }
    });

    $scope.params={};
    
//登陆
    $scope.submit = function () {
        $http({
            method: 'POST',
            url: '/carrots-admin-ajax/a/login',
            params:$scope.params

        })
            .then(function (response) {
            if (response.data.code === 0) {
                $state.go('backstage')
            } else {
                $scope.message = response.data.message;
            }

        }, function (response) {
            //失败时执行
            console.log(response);
        });
    }
})
