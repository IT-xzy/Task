/*
 * @Author: 汤镇铭Michael 
 * @Date: 2018-01-22 16:07:01 
 * @Last Modified by: 汤镇铭Michael
 * @Last Modified time: 2018-01-23 18:16:36
 */

// --------------------------------------------------------------原生JS实现 

// var button = document.getElementsByTagName("button")[0];
// // console.log(button);

// var text = document.getElementsByName("name")[0];
// var password = document.getElementsByName("pwd")[0];
// // console.log(text);
// // console.log(password);

// var span = document.getElementsByTagName("span");
// // console.log(span[0]);
// // console.log(span[1]);

// button.onclick = function () {
//     var name = text.value;
//     var pwd = password.value;
//     console.log(name);
//     console.log(typeof name);
//     console.log(pwd);
//     console.log(typeof pwd);
    
//     console.log(name.length);
//     console.log(pwd.length);

//     var sendData = "name=" + name + "&pwd=" + pwd;// 发送的数据
//     console.log(sendData);
    
//     if (name.length == 5 && pwd.length == 6/*  && (typeof name) === "string" */) {
//         var xmlhttp;
//         if (window.XMLHttpRequest) {// 兼容IE
//             xmlhttp = new XMLHttpRequest();// XHR object 。 readystate 0
//         } else {
//             xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
//         }
        
//         xmlhttp.open("POST", "/carrots-admin-ajax/a/login", true);// readystate 1 2 
//         xmlhttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded"); // readystate 3 
//         xmlhttp.send(sendData);// readystate 3
//         xmlhttp.onreadystatechange = function () {
//             if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {// readystate 3 4
//                 // return responseText
//                 // console.log(xmlhttp.responseText);字符串
//                 // console.log(JSON.parse(xmlhttp.responseText));
//                 var responseText = JSON.parse(xmlhttp.responseText);
//                 console.log(responseText);
//                 if (responseText.code === 0) {
//                     window.open('./system.html');
//                 } else {
//                     alert("帐号或密码错误，请重新输入");
//                 }
//             }
//         }
//     } else if (name.length !== 5 && pwd.length !== 6) {
//         span[0].innerHTML = "请输入5位数帐户名";
//         span[1].innerHTML = "请输入6位数密码";
//     }
//     if (name.length !== 5) {
//         span[0].innerHTML = "请输入5位数帐户名";
//     } else {
//         span[0].innerHTML = "";
//     }
//     if (pwd.length !== 6) {
//         span[1].innerHTML = "请输入6位数密码";
//     } else {
//         span[1].innerHTML = "";
//     }
// }

// ------------------------------------------------------------------------JQ实现

function runAjax(type, url, data) {// 带形参的封装的函数
    var type = type.toUpperCase();// 把传入的类型转化为大写
    $.ajax ({
        async: true,
        cache: true,
        type: type,
        url: url,
        data: data,
        dataType: "JSON",
        contentType: "application/x-www-form-urlencoded",
        success: function good(getDate) {
            console.log(getDate);
            if (getDate.code === 0) {
                window.open('./system.html');
            } else {
                alert("帐号或密码错误，请重新输入");
            }
        }
    })
}

$(document).ready(function () {
    $("button").click(function () {// 点击事件
        var name = document.getElementsByName("name")[0];
        var pwd = document.getElementsByName("pwd")[0];
        var span = document.getElementsByTagName("span");
        
        if (name.value.length == 5 && pwd.value.length == 6) {
            var data = $("form").serialize();
            console.log(data);
            runAjax("post", "/carrots-admin-ajax/a/login", data);
        } else if (name.value.length !== 5 && pwd.value.length !== 6) {
            span[0].innerHTML = "请输入5位数帐户名";
            span[1].innerHTML = "请输入6位数密码";
        }
        if (name.value.length !== 5) {
            span[0].innerHTML = "请输入5位数帐户名";
        } else {
            span[0].innerHTML = "";
        }
        if (pwd.value.length !== 6) {
            span[1].innerHTML = "请输入6位数密码";
        } else {
            span[1].innerHTML = "";
        }
    })
})