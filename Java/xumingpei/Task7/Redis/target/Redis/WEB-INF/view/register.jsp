<%--
  Created by IntelliJ IDEA.
  User: Shinelon
  Date: 2019/4/3
  Time: 2:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <meta http-equiv="Content-Type" content="multipart/form-data; charset=utf-8"/>
</head>
<link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
<script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script type="text/javascript">
    function checkPhone()
    {
        var phone =document.getElementById('phone').value;
        console.log("手机号码 = "+phone)
        var partten = /^1[3,5,6,7,8]\d{9}$/;
        if(partten.test(phone))
        {
            return true;
        }
        else
        {
            alert('请使用手机号码');
        }
    }
    function checkEmail()
    {
        var email =document.getElementById('email').value;
        console.log("邮箱 = "+email)
        var partten = /^[A-Za-z\d]+([-_.][A-Za-z\d]+)*@([A-Za-z\d]+[-.])+[A-Za-z\d]{2,4}$/;
        if(partten.test(email))
        {
            return true;
        }
        else
        {
            alert('邮箱格式不对');
        }
    }
    function sendPhone() {
        var phone =document.getElementById('phone').value;
        console.log("sendPhone: phone = " +phone);
        $.ajax({
            url: 'phone',
            type: 'post',
            data: {
                'phone':phone,
            },
            dataType: 'text',
            success: function (data) {
                alert(data);
                console.log("sendCaptcha ==> success: data = " + (data));
            },
            error: function (data) {
                console.log("sendCaptcha ==> error: data = " + (data));
            }
        });
    }
    function sendEmail() {
        var email =document.getElementById('email').value;
        console.log("sendEmail: email = " + email);
        $.ajax({
            url: 'email',
            type: 'post',
            data: {
                'email':email,
            },
            dataType: 'text',
            success: function (data) {
                alert(data);
            },
            error: function (XMLHttpRequest, textStatus, errorThrown) {
                // 状态码
                console.log(XMLHttpRequest.status);
                // 状态
                console.log(XMLHttpRequest.readyState);
                // 错误信息
                console.log(textStatus);
                console.log(errorThrown);
            }
        });
    }
</script>

<html>
<head>
    <title>注册</title>
</head>
<body>
<h1>注册</h1>
<div>
    <ul>
        <li class="active">
            <a href="#emailPage" data-toggle="tab">邮箱注册</a></li>
        <li><a href="#phonePage" data-toggle="tab">手机注册</a></li>
    </ul>
    <form action="/register" name="user" method="post" id="phonePage">
        用户名:<input type="text" name="name" ><br>
        手机号:<input type="text" name="phone" onchange="checkPhone()" id="phone">
        <button type="button" onclick="sendPhone()" >获取手机验证码</button><br>
        验证码:<input type="text" name="msgCode"  value="" placeholder="请输入手机验证码"><br>
        密  码:<input type="password" name="password"><br>
        <input type="submit" value="注册">
        <a class="a-style" href="/goLogin"> <input type="button"  value="已有账号？去登录"></a>
    </form>

    <form action="/register/email" name="user" method="post" id="emailPage">
        用户名:<input type="text" name="name" ><br>
        邮  箱:<input type="text" name="email" onchange="checkEmail()" id="email">
        <button type="button" onclick="sendEmail()" >获取邮箱验证码</button><br>
        验证码:<input type="text" name="msgCode"  value="" placeholder="请输入邮箱验证码"><br>
        密  码:<input type="password" name="password"><br>
        <input type="submit" value="注册">
        <a class="a-style" href="/goLogin"> <input type="button"  value="已有账号？去登录"></a>
    </form>
</div>
</body>
</html>
