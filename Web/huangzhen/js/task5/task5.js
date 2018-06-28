"use strict"

// 原生JavaScript

// document.getElementById("login").addEventListener("click", function () {
//     //创建对象
//     // 利用FormData对象,我们可以通过JavaScript用一些键值对来模拟一系列表单控件,
//     // 我们还可以使用XMLHttpRequest的send()方法来异步的提交这个"表单"
//     var formData = new FormData();
//     // 获取输出框的值
//     var username = document.getElementById("username").value;
//     var password = document.getElementById("password").value;
//     // console.log(username);
//     // console.log(password);
//     formData.append('name', username);
//     formData.append('pwd', password);
//     // console.log(formData);
//     // （1）创建异步对象
//     //创建XHR对象
//     function createXHR() {
//         //对IE7及其更高版本
//         if (window.XMLHttpRequest) {
//             return new XMLHttpRequest();
//         }
//         //以下为对IE7之前版本兼容
//         else {
//             return new ActiveXObject("Microsoft.XMLHTTP");
//         }
//     }
//     var xhr = createXHR();
//     // 这里是为了判断是否需要兼容ie7所以没有采取下面原生的直接定义
//     // var xhr = new XMLHttpRequest();
//     // （2）设置请求的参数。包括：请求的方法、请求的url。
//     xhr.open('POST', "/carrots-admin-ajax/a/login", true);
//     // method：请求的类型；GET 或 POST
//     // 在以下情况中，请使用 POST 请求：
//     // 与 POST 相比，GET 更简单也更快，并且在大部分情况下都能用。
//     //  1、无法使用缓存文件（更新服务器上的文件或数据库）
//     //  2、向服务器发送大量数据（POST 没有数据量限制） 
//     //  3、发送包含未知字符的用户输入时，POST 比 GET 更稳定也更可靠
//     // url：文件在服务器上的位置
//     // async：true（异步）或 false（同步）

//     // （3）发送请求
//     xhr.send(formData);
//     // 将请求发送到服务器。

//     // （4）注册事件。 onreadystatechange事件，状态改变时就会调用。
//     //如果要在数据完整请求回来的时候才调用，我们需要手动写一些判断的逻辑。
//     // 通信成功时值为4
//     xhr.onreadystatechange = function () {
//         //   这么坑的表单验证哈哈哈
//         if (password === '' && username === '') {
//             document.getElementsByClassName("info")[0].innerHTML = "用户名、密码不能为空";
//         } else
//         if (username === '') {
//             document.getElementsByClassName("info")[0].innerHTML = "请输入用户名";
//         } else
//             // 为了保证 数据 完整返回，我们一般会判断 两个值
//             if (xhr.readyState == 4 && xhr.status == 200) {
//                 // 如果能够进到这个判断 说明 数据 完美的回来了,并且请求的页面是存在的
//                 // （5）.在注册的事件中 获取 返回的 内容 并修改页面的显示
//                 var text = JSON.parse(xhr.responseText);
//                 if (text.message == "success") {
//                     console.log("success");
//                     window.location.href = "http://dev.admin.carrots.ptteng.com/";
//                 } else {
//                     document.getElementsByClassName("info")[0].innerHTML = text.message;
//                 }
//             } else {
//                 // console.log("error" + xhr.status);
//             }
//     }
// })

// jQuery

// $(document).ready(function () {
//     $("#login").on("click", function () {
//         $.post("/carrots-admin-ajax/a/login", {
//                 name: $("#username").val(),
//                 pwd: $("#password").val()
//             },
//             function (data) {
//                 var data = JSON.parse(data);
//                 if (data.message == "success") {
//                     window.location.href = "http://dev.admin.carrots.ptteng.com/";
//                 } else {
//                     $(".info").text(data.message);
//                 }
//             });
//     });
// });


// $(".inside").click(function () {
//     var idcar = $(".idcar").val();
//     console.log(idcar);
//     var pass = $(".pass").val();
//     console.log(pass)
// $.post("/carrots-admin-ajax/a/login",
// //  {
// //         name: idcar,
// //         pwd: pass
// //     },
//     function (data, status) {
//         console.log(status);
//         console.log(data)
//     }
// )
$(document).ready(function () {
    $(".inside").on("click", function () {
        var idcar = $(".idcar").val();
        console.log(idcar);
        var pass = $(".pass").val();
        console.log(pass);
        $.post("/carrots-admin-ajax/a/login", {
                name: idcar,
                pwd: pass
            },
            function (data) {
                var data = JSON.parse(data);
                if (data.message == "success") {
                    window.location.href = "http://dev.admin.carrots.ptteng.com/";
                } else {
                    $(".info").text(data.message);
                }
            });
    });
})