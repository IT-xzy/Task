angular.module("myApp")
    .controller("loginCtrl", function ($scope, $state, userService) {
        
        // 登陆请求函数
        $scope.login = function () {
            var params = {
                name: $scope.name,
                pwd: $scope.pwd
            }
            userService.login(params).then(function (res) { // 请求成功执行代码
                console.log(res.data);
                if (res.data.code == 0) { //如果登陆成功
                    localStorage.setItem('login', true);
                    $state.go('admin');
                } else {
                    $scope.tips = res.data.message;
                }
            })
        }

        // 登陆表单验证
        $scope.error = function () {
            if ($scope.form.user.$error.required || $scope.form.user.$error.minlength) {
                $scope.form.user.$dirty = true;
                return
            } else if ($scope.form.pwd.$error.required || $scope.form.pwd.$error.minlength) {
                $scope.form.pwd.$dirty = true;
                return
            } else {
                localStorage.login = 'true';
                console.log(localStorage.login);
                $scope.login();
            }
        }

    });