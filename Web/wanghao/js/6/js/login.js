angular.module("myApp")
    .controller("loginController", function ($scope, $http,$state) {
        $scope.go = function () {
            $http({
                method: "POST",
                url: "../../carrots-admin-ajax/a/login",
                params: $scope.params,
                headers: {
                    'Content-Type': 'application/x-www-form-urlencoded'
                },
            }).then(function success(resp) { //响应成功时调用，resp是一个响应对象  
                if (resp.data.code == 0) { //接口返回0接口成功
                    $state.go("backstage");
                } else { //接口返回0以外的就是不通过
                    $scope.name = resp.data.message;
                }

            });
        };
        $scope.rest = function () { //设置rest方法，清楚文字；
            $scope.name = undefined;
        };
    });