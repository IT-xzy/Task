myApp.controller("login", function ($scope, $http, $state) {
    $scope.submit = function () {
        $http({
            method: 'post',
            url: '/carrots-admin-ajax/a/login',
            params: {
                name: $scope.user,
                pwd: $scope.pwd
            },
            headers: {
                'Content-Type': 'application/x-www-form-urlencoded'
            },
        }).then(function (xhr) {
            // console.log(xhr.data);
            if (xhr.data.code === 0) {
                $state.go("backstage");
                console.log(xhr.data);
            } else {
                $scope.info = xhr.data.message;
            }
        })
    }
})