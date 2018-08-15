myApp.controller('login', function ($scope,$http,$state,$log) {
    $scope.user = '登录名';
    $scope.code = '*****';
    $scope.login = function () {
        $http({
            url: '/carrots-admin-ajax/a/login',
            method: 'POST',
            params: {'name':$scope.user,'pwd':$scope.code},
            header: {'Content-Type': 'application/x-www-form-urlencoded'}//表头
        }).then(function (response) {
            if (response.data.message == "success") {
                window.location.href = "task6main.html";
            } else {
                $(".text-danger").text(response.data.message);
            }
        })
    }
});
