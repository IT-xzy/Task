<%--
  Created by IntelliJ IDEA.
  User: Y
  Date: 18/5/8
  Time: 11:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script src="https://cdn.bootcss.com/jquery/3.3.1/jquery.js"></script>

<html>
<head>
    <title>邮箱注册</title>
    <script>
        function sendSms(){
            var e_email = document.getElementById("e_email");
            console.log(e_email)
            $.ajax({
                methods:'GET',
                url:'/verifyEmail',
                data:{e_email:e_email.value},
                success:function (result) {
                    console.log(result)
                }
            });
        }
    </script>
</head>
<body>
<div style="text-align: center">

    <form action="/register/email" method="post">
        用户名：<input type="text" name="e_name"/><br>
        密  码：<input type="password" name="e_password"/><br>
        邮  箱：<input id="e_email" type="text" name="e_email"/><br>
        验证码：<input type="text" name="emailCode"/><br>
        <input type="submit" value="注册"/>
    </form>

    <button onclick="sendSms()">发送邮箱验证码</button><br>

</div>
</body>
</html>
