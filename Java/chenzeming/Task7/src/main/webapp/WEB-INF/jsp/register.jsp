<%--
  Created by IntelliJ IDEA.
  User: LUCKY 铭
  Date: 2018/7/26
  Time: 21:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script src="https://cdn.bootcss.com/jquery/3.3.1/jquery.js"></script>
<html>
<head>
    <title>用户注册</title>
    <script>
        function sendSms() {
            var telephone = document.getElementById("telephone");
            console.log(telephone)
            $.ajax({
                methods: 'GET',
                url: '/code',
                data: {telephone: telephone.value},
                success: function (result) {
                    console.log(result)
//                    alert("验证码发送成功!");
//                    $("#code").val(result);
                }
            });
        }
    </script>

    <script>
        function sendMail() {
            var email = document.getElementById("email");
            console.log(email)
            $.ajax({
                methods: 'GET',
                url: '/emailcode',
                data: {email: email.value},
                success: function (result) {
                    console.log(result)

                }
            });
        }
    </script>
</head>
<body>
<form style="text-align:center;" action="${pageContext.request.contextPath}/register"  method="post">
    <%--<form action="FIND">--%>
    <h1>注册界面</h1>
    账  号 ：<input type="text" name="username" placeholder="账户名"><br/>
    密  码 ：<input type="password" name="password" placeholder="密码"><br/>
    手  机 : <input id="telephone" type="text" name="telephone" placeholder="手机号码"><br/>
    邮  箱 : <input id="email" type="text" name="email" placeholder="邮箱"><br/>
    手机验证码：<input type="text" name="phonecode" placeholder="手机验证码"><br/>
    邮箱验证码：<input type="text" name="emailcode" placeholder="邮箱验证码"><br/>
    <%--照片上传 :<input type="file" name="photo" ><br/>--%>
        <br/>
    <input id="submit" type="submit" value="注册">
</form>
<form style="text-align:center;">
    <button  onclick="sendSms()">发送手机验证码</button>
    <button onclick="sendMail()">发送邮箱验证码</button>
</form>
</body>
</html>
