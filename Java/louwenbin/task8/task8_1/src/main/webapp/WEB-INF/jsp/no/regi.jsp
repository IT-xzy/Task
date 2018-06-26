﻿﻿
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>注册界面</title>
    <link href="./Wopop_files/style_log.css" rel="stylesheet" type="text/css">
    <link rel="stylesheet" type="text/css" href="/css/style.css">
    <link rel="stylesheet" type="text/css" href="/css/userpanel.css">
    <link rel="stylesheet" type="text/css" href="/css/jquery.ui.all.css">
    <%--<link rel="stylesheet" type="text/css" href="/css/jquery.ui.notice.css">--%>
    <script>
        function send(){
            var phoneNum = document.getElementById("phone");
            console.log(phoneNum);
            $.ajax({
                methods:'GET',
                url:'/verify',
                data:{phoneNum:phoneNum.value},
                success:function (result) {
                    console.log(result)
                }
            });
        }
    </script>
</head>

<body class="login">
<div class="login_m">

    <div class="login_logo"><h1>注册界面</h1></div>


    ${返回通知}
    <div class="login_padding">
        <form action="/register" method="POST">
            <h1>账号</h1>
            <label>
                <input type="text" id="name" name="name" class="txt_input txt_input2">
            </label>
            <h1>密码</h1>
            <label>
                <input type="password" name="password" id="password" class="txt_input">
            </label>
            <h1>手机号</h1>
            <label>
                <input type="text" name="phone" id="phone" class="txt_input">
                <%--<input type="button" id="send" value="发送验证码" onclick="send()">--%>


            </label>
            <label>
                <h1>验证码</h1>
                <input type="text" name="code" id="code" class="txt_input" value="请输入验证码"
                       onfocus="javascript:if(this.value=='请输入验证码')this.value='';">
            </label>
            <h1>邮箱</h1>
            <label>
                <input type="text" name="email" id="email" class="txt_input">
            </label>
            <h1>头像</h1>
            <label>
                <img id="preview" width="200px" height="200px">
                <input type="file" name="photo" id="photo" onchange="imgPreview(this)"/>
            </label>

            <p class="forgot"><a> </a></p>

            <div class="rem_sub">
                <div class="rem_sub_2">
                    <label>
                        <a>
                            <input type="submit" class="sub_button" name="button" id="Registered"
                                   value="Registered">
                        </a>

                    </label>
                </div>
            </div>
        </form>
        <button onclick="send()">发送手机验证码</button><br>
    </div>

    <!--login_padding  Sign up end-->
</div><!--login_boder end-->
</div><!--login_m end-->
<br> <br>
<div class="login_logo"><h1>


</h1></div>

</body>
<script src="/js/jquery.notice.js"></script>
</html>