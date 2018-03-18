/*
// 原生ajax方法
var userName = document.getElementById("userName"),
    password = document.getElementById("password"),
    loginBtn = document.getElementById("loginBtn"),
    loginMess = document.getElementById("loginMess");
function ajax() {
    // 获取输入框数据
    var userValue = userName.value,
        passwordValue = password.value,
        // 把输入框的值进行encodeURIComponent编译
        value = "name=" + encodeURIComponent(userValue) + "&pwd=" + encodeURIComponent(passwordValue),
        // Ajax请求
        xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function () {
        if (xhr.readyState == 4) {
            if ((xhr.status >= 200 && xhr.status < 300) || xhr.status == 304) {
                var data = xhr.responseText,
                    odata = JSON.parse(data);
                // 根据返回的数据显示不同的提示信息
                if (odata.message == "success") {
                    loginMess.innerHTML = "登陆成功";
                } else {
                    loginMess.innerHTML = odata.message;
                }
            } else {
                alert("Request was unsuccessful: " + xhr.status);
            }
        }
    }
    xhr.open("post","/carrots-admin-ajax/a/login",true);
    xhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
    xhr.send(value);
}
// 为登录按钮添加事件
loginBtn.onclick = ajax;
*/

// jQuery方法
$(function () {
    var $userName = $("#userName"),
        $password = $("#password"),
        $loginBtn = $("#loginBtn"),
        $loginMess = $("#loginMess"),
        $body = $("body");
    function ajax() {
        $.ajax({
            type: "POST",
            url: "/carrots-admin-ajax/a/login",
            data: {
                name: $userName.val(),
                pwd: $password.val()
            },
            dataType: "json",
            success: function (data) {
                if (data.message == "success") {
                    alert("登陆成功");
                } else {
                    $loginMess.text(data.message);
                }
            }
        })
    }
    // 为登录按钮添加点击事件
    $loginBtn.on("click",ajax)
    // 添加键盘事件
    $body.on("keyup",function (event) {
        if (event.keyCode == 13) {
            $loginBtn.click();
        }
    })
})