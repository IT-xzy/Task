angular.module("myApp")
    .controller("loginCtrl",function ($scope, $http, $state) {
    $scope.login = function () {
        $scope.loginMess = ""; // 每次点击之前清除提示信息
        $http({
            method: "POST",
            url: "/carrots-admin-ajax/a/login",
            params: {
                name: $scope.userName,
                pwd: $scope.password
            },
            headers: {
                "Content-Type": "application/x-www-form-urlencoded"
            }
        }).then(function (response) {
            if (response.data.code == 0) {
                $state.go("home");
            } else if (response.data.code < 0){
                $scope.loginMess = response.data.message;
            }
        })
    }
})
