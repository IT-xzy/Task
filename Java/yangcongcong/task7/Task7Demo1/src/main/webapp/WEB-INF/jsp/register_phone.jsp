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
    <title>手机注册</title>
    <script>
        function sendSms(){
            var phoneNum = document.getElementById("phoneNum");
            console.log(phoneNum)
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
<body>
    <div style="text-align: center">

        <form action="/register/cellphone" method="post">
            用户名：<input type="text" name="username"/><br>
            密  码：<input type="password" name="password"/><br>
            手机号：<input id="phoneNum" type="text" name="phoneNum"/><br>
            短信验证码：<input type="text" name="verifyCode"/><br>
            <input type="submit" value="注册"/>
        </form>

        <button onclick="sendSms()">发送手机验证码</button><br>

    </div>
</body>
</html>
