app.controller('loginCtrl', function ($scope, $http, $state) {
    $scope.tohome = function (){
        $http({
            // 请求的方式
            method: 'POST',

            // 请求的地址
            url: '/carrots-admin-ajax/a/login',

            // 提交的数据
            params: {
                name: $scope.user,
                pwd: $scope.pass
            },

            // 告诉服务端请求头信息是以什么格式进行传递的
            // 下面的代码告诉服务端消息主体是序列化后的 JSON 字符串
            headers: {
                'Content-Type': 'application/json'
            }
        }).then (function (response) {
            if (response.data.code == 0) {
                sessionStorage.setItem('name', $scope.user);
                $state.go("home");
            } else if (response.data.code < 0){
                $scope.tips = response.data.message;
            }
        });
    };
});