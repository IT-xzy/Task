angular.module("myApp")
    .controller("loginController", function ($scope, $state, deg) {
        console.log("shou");
        $scope.go = function () {
            deg.login($scope.params).then(function (resp) { //响应成功时调用，resp是一个响应对象  
                if (resp.data.code == 0) { //接口返回0接口成功
                    $state.go("u");
                } else { //接口返回0以外的就是不通过
                    $scope.name = resp.data.message;
                }
            });
        };
        $scope.rest = function () { //设置rest方法，清楚文字；
            $scope.name = undefined;
        };
    });