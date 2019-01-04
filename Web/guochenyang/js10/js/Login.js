//创建控制器并注入，$scope,$http,$state服务
myApp.controller('LoginController', function ($scope, $http, $state, $timeout) {

    if (window.sessionStorage.getItem("retreat") == undefined) {
        history.pushState(null, null, document.URL);
        window.addEventListener('popstate', function () {
            history.pushState(null, null, document.URL);
        });
    }

    
    //登陆点击事件
    $scope.LoginKey = function () {
        //angular请求写法
        $http({
            method: 'POST',
            url: '/carrots-admin-ajax/a/login',
            params: {
                name: $scope.nameNb,
                pwd: $scope.pwdNb
            }
            //then第一个函数为请求成功
        }).then(function (res) {
            console.log(res);
            var asking = res.data;
            //全部正确则跳转
            if (asking.code === 0) {
                retreat = 1
                sessionStorage.setItem("retreat", retreat)
                $state.go("organ.text")
            } else {
                if (asking.code === -5003) {
                    $scope.nametext = asking.message;
                    $timeout(function () {
                        $scope.nametext = ""
                    }, 1000)
                } else if (asking.code === -5004) {
                    $scope.pwdtext = asking.message;
                    $timeout(function () {
                        $scope.pwdtext = ""
                    }, 1000)
                }
            }
        },  //第二个为请求失败的函数
            function (res) {
                alert("请求失败")
            })
    }
})
