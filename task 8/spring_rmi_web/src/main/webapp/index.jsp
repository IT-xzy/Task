<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script src="https://cdn.bootcss.com/jquery/3.3.1/jquery.js"></script>
<html>
<head>
    <title>注册</title>
    <script>
        function sendSms() {
            var phoneNum = document.getElementById("phoneNum");
            console.log(phoneNum)
            $.ajax({
                methods: 'GET',
                url: '/verify',
                data: {phoneNum: phoneNum.value},
                success: function (result) {
                    console.log(result)
                }
            });
        }
    </script>
</head>
<body>
<div style="text-align: center">
    <fieldset style="width: 300px;margin: 80px 500px ">
        <legend>注册账号</legend>
        <form action="${pageContext.request.contextPath}/register" method="post"
              enctype="multipart/form-data">
            用户名：<input type="text" name="userName"/><br>
            密 码：<input type="password" name="password"/><br>
            手机号：<input id="phoneNum" type="text" name="phone"/><br>
            短信验证码：<input type="text" name="verifyCode"/><br>
            选择一张图片作为头像（七牛云）:<input type="file" name="photo" value="上传图片"/><br>
            <input type="submit" value="注册"/>
        </form>
        <button onclick="sendSms()">发送验证码</button>
    </fieldset>
    <fieldset style="width: 300px;margin: 60px 500px ">
        <legend>上传图片</legend>
        <form method="post" action="${pageContext.request.contextPath}/fileUpload" enctype="multipart/form-data">
            选择一张图片作为头像（阿里云）:
            <input type="file" name="photo"/>
            <input type="submit" value="上传"/>
        </form>
    </fieldset>
    <fieldset style="width: 300px;margin: 60px 500px ">
        <legend>验证邮箱</legend>
        <form action="${pageContext.request.contextPath}/email" method="post">
            您的名字：<input type="text" name="userName"/><br>
            邮箱：<input type="text" name="email"/><br>
            <input type="submit" value="验证邮箱"/>
        </form>
    </fieldset>
</div>
</body>
</html>
