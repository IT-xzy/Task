// 登录页控制器
angular.module("myApp")
    .controller("login", function ($scope, $state, beg, $location, locals, $timeout, $compile) {
        // 当用户名输入框和密码输入框获得焦点时清除报错提示
        $scope.value = function () {
            $scope.hint = ""; //清除报错提示
        }
        // 点击登录按钮
        $scope.login = function () {
            // 当未输入账号和密码时报错提示
            if ($scope.name == undefined || $scope.name == "" || $scope.password == undefined || $scope.password == "") {
                $scope.hint = "请输入账号密码";
            } else if ($scope.name != "" && $scope.password != "") {
                // 输入账号和密码时发起POST请求
                $scope.params = {}; //创建登录请求数据
                $scope.params.name = $scope.name; //用户名
                $scope.params.pwd = $scope.password; //密码
                beg.postLogin($scope.params).then(function (response) { //调用登录请求
                    console.log(response)
                    if (response.data.code == "-5003") {
                        $scope.hint = response.data.message; //提示用户名错误
                    } else if (response.data.code == "-5004") {
                        $scope.hint = response.data.message; //提示密码错误
                    } else if (response.data.code == "0") {
                        $scope.hint = "登录成功"; //提示登录成功
                        $scope.username = response.data.data.role.name; //获取登录用户名
                        // locals.set("$scope.username", $scope.username); //调用本地存储服务存储登录用户名
                        localStorage.setItem("$scope.username", JSON.stringify($scope.username)); //保存登录用户名
                        let ifLoginTrue="true";//定义登录状态
                        localStorage.setItem("ifLoginTrue", JSON.stringify(ifLoginTrue));//保存登录状态
                        $state.go('home'); //路由跳转到主页
                    }
                }, function (response) { //发起请求失败
                    console.log(response);
                    location.href = "404"; //跳转到404
                })







                // $http({
                //     method: "POST", //定义POST请求
                //     url: '/carrots-admin-ajax/a/login', //请求地址
                //     params: { //params可以把$scope的对象序列化成键值对形式
                //         name: $scope.name,
                //         pwd: $scope.password,
                //     },
                //     headers: {
                //         'Content-Type': 'application/x-www-form-urlencoded'
                //     }
                // }).then(function (response) { //发起请求成功
                //     // console.log(response);
                //     // console.log(response.data);
                //     if (response.data.code == "-5003") {
                //         $scope.hint = response.data.message; //提示用户名错误
                //     } else if (response.data.code == "-5004") {
                //         $scope.hint = response.data.message; //提示密码错误
                //     } else if (response.data.code == "0") {
                //         $scope.hint = "登录成功"; //提示登录成功
                //         $state.go('home'); //路由跳转到主页
                //     }
                // }, function (response) { //发起请求失败
                //     console.log(response);
                //     location.href = "404"; //跳转到404
                // })
            }
        }
    })