// var username = document.getElementsByTagName('input')[0];
// var password = document.getElementsByTagName('input')[1];
// var warm = document.getElementsByClassName('warm')[0];
// var nameType = false;
// var pwdType = false;
// username.onfocus = function () {
//
// };
// password.onfocus = function () {
//
// };
// username.onblur = function () {
//
// };
// password.onblur = function () {
//
// };
// username.oninput = function () {
//     var game = this.value;
//     var judge = /^[a-zA-Z0-9]{4,16}$/;
//     if(game === ''){
//     warm.innerHTML = "请输入用户名";
//     warm.className = 'hint';
//     nameType =false;
//     }else {
//         if(judge.test(game)===true){
//             warm.innerHTML = "输入正确";
//             warm.className = "hint-true";
//             nameType = true;
//         }else{
//             warm.innerHTML = '用户名不合法';
//             warm.className = 'hint';
//             nameType = false;
//         }
//     }
// };
// password.oninput = function () {
//     var name = this.value;
//     var judge1 = /^(\w){6,20}$/;
//     if(name === ''){
//         warm.innerHTML = "请输入密码";
//         warm.className = 'hint';
//         pwdType = false;
//     }else {
//         if(judge1.test(name)===true){
//             warm.innerHTML = '密码格式正确';
//             warm.className = 'hint-true';
//             pwdType = true;
//         }else {
//             warm.innerHTML = '密码长度在4-16位之间';
//             warm.className = 'hint';
//             pwdType = false;
//         }
//     }
// };

// btn = $('button');
// btn.click(function() {
//     console.log("用户名：" + username.value + nameType);
//     console.log("密码：" + password.value + pwdType);
//     if (nameType === true && pwdType === true) {
//         $.ajax({
//             type: "POST",										//干什么--寄快递
//             url: "/carrots-admin-ajax/a/login",					//寄到哪里
//             data: {"name": username.value, "pwd": password.value},	//快递内容
//             dataType: "json",									//怎么包装
//             success: function (data) {							//快递信息反馈
//                 if (data.message === "success") {					//送到了
//                     warm.innerHTML = "登录成功";
//                     warm.className = "hint-true";
//                 } else {
//                     warm.innerHTML = data.message;
//                     warm.className = "hint";
//                     alert(data.message);                    //出了什么事
//                 }
//             }
//         });
//     } else {
//         alert('账号密码不正确!')
//     }
// });



// btn = document.getElementsByClassName('submit')[0];
// $('.submit').click(function () {
//     var ajax = new XMLHttpRequest();
//     ajax.open("POST","/carrots-admin-ajax/a/login",true);
//     var data = {"name=": username.value , "&pwd=":password.value};
//     ajax.send(data.message);
//     if(data.message === 'success'){
//         warm.innerHTML = "登陆成功"
//     }
// });

// //
// var app = angular.module("myApp",[]);
// app.controller('myCtrl',function ($scope,$http) {
//     $scope.user = {};
//
//
//     $scope.submit1 = function () {
//         $http({
//             method : 'POST',
//             url    : '/carrots-admin-ajax/a/login',
//             data   : $.param($scope.user)
//         }).then(function successCallback(manager) {
//             console.log(manager.id)
//         },function errorCallback(data) {
//             alert(data)
//         });
//
//     };
// });
