// $(function () {
//     $("#login").on("click", function () { //登录按钮点击事件
//         $.post("/carrots-admin-ajax/a/login", { //请求的 URL
//                 //请求发送的数据
//                 name: $("#account").val(), //账号
//                 pwd: $("#password").val() //密码
//             },
//             function (data, status) { //请求成功后所执行的函数
//                 var jsons = JSON.parse(data); //返回文本字符串转换为json对象
//                 if ($("#account").val() === "" || $("#password").val() === "") { //如果用户名或者密码没输，则提示
//                     $(".red-word").text("请输入账号和密码");
//                 } else { //如果输入了
//                     if (jsons.message === "success") { //如果返回成功，提示成功
//                         $(".red-word").text(jsons.message);
//                     } else { //如果返回失败，提示无此用户
//                         $(".red-word").text(jsons.message);
//                     };
//                 };
//             });
//     });
// });



angular.module("myApp")
.controller("loginController", function ($scope, $http, $state) {
    $scope.change = function () {
        $scope.tip = "";
    };
    $scope.go = function () {
        $http({
            method: "POST",
            url: "/carrots-admin-ajax/a/login",
            params: $scope.params,
            headers: {
                'Content-Type': 'application/x-www-form-urlencoded'
            },
        }).then(function successCallback(response) {
            if (response.data.code === 0) { //如果正确，跳转
                $state.go('list.welcome');
            } else if (response.data.code !== 0) { //如果账号密码错误，提示文本：用户不存在
                $scope.tip = response.data.message;
            };
        });
    };
});
