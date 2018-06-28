//登录请求
app.controller('myControl', function($scope, $http, $state){
    $scope.btn = function () {
        $http({
            method: 'POST',
            url: '/carrots-admin-ajax/a/login',
            headers: {'Content-Type': 'application/x-www-form-urlencoded'},
            params: {
                name: $scope.user,
                pwd: $scope.password
            }
        }).then(function success(resp) {
            if (resp.data.code === 0) {
                window.sessionStorage.setItem("token", "1");
                $state.go('backstage');
            } else {
                $scope.message = resp.data.message
            }
        })
    };
    //监听两个输入框，如果修改输入值，http错误提示消失
    $scope.$watch('user + password', function () {
        $scope.message = ''
    })
});


