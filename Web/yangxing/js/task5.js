// $(document).ready(function () {
//
//     $('#username').blur(function () {
//         var username = $('#username').val();//获取用户框的输入值；
//         regExp = /[\da-zA-Z]{5,13}/;  // 用户名为英文和数字组合
//         if (username.length < 5) {
//             $('.userverify').text('用户名不能少于五位');
//         } else if (!regExp.test(username)) {
//             $('.userverify').text('账号错误');
//         } else {
//             $('.userverify').text('');
//         }
//     });
//
//     $('#password').blur(function () {
//         var pwd = $('#password').val();//获取密码框的输入值；
//         regExp = /[\da-zA-Z]{6,16}/;  // 密码为数字
//         if (pwd.length < 5) {
//             $('.passwordverify').text('密码不能少于六位');
//         } else if (!regExp.test(pwd)) {
//             $('.passwordverify').text('密码错误');
//         } else {
//             $('.passwordverify').text('');
//         }
//     });
//
//     $('.btn').click(function () {
//         var username = $('#username').val();//获取用户框的输入值；
//         var pwd = $('#password').val();//获取密码框的输入值；
//         console.log(username);
//         console.log(pwd)
//         $.ajax({
//             type: 'POST',
//             url: '/carrots-admin-ajax/a/login',
//             data: {'name': username, 'pwd': pwd},
//             dateType: 'json',
//             success: function (date) {
//                 $('.userverify').text(date.message);
//             }
//         })
//
//     });
// });

//
// var username = document.getElementById('username');//获取用户框
// var pwd = document.getElementById('password');//获取密码框
//
// var userverify = document.getElementsByClassName('userverify');//获取用户框提示
// var passwordverify = document.getElementsByClassName('passwordverify');//获取密码框提示
//
// function login() {
//     console.log(username.value);
//     console.log(pwd.value);
//     var xhr = new XMLHttpRequest();
//     xhr.open('post', '/carrots-admin-ajax/a/login', true);
//     xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
//     xhr.send('name=' + username.value + '&pwd=' + pwd.value);
//     xhr.onreadystatechange = function () {
//
//         if (xhr.readyState == 4) {
//             if ((xhr.status >= 200 && xhr.status < 300) || xhr.status == 304) {
//                 if(JSON.parse(xhr.responseText).code==0){
//                     window.location.href = 'task6.html';
//                 }else {
//                     alert('账号密码不正确');
//                 }
//
//             }
//         }
//     }
// }

var app = angular.module('admin', []);
app.controller('loginCtr1', function ($scope, $http) {
    $scope.loginInit = function () {
        var name=$scope.username;
        var pwd=$scope.password;
        var promise = $http({
            method: 'POST',
            url: '/carrots-admin-ajax/a/login',
            headers: {
                'Content-Type': 'application/x-www-form-urlencoded; charset=UTF-8',
                'Accept': '*/*'
            },
            params: {'name':name , 'pwd':pwd }
        });
        console.log($scope.username);
        promise.then(function (res) {
            if (res.data.message == 'success') {
               location.href='/task/homepage.html';
            }else {
                alert(res.data.message);
            }
        });
    };
});








