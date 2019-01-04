<%@ page language="java" pageEncoding="UTF-8" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <script src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.8.0.js">
    </script>
    <script type="text/javascript">
        function emailCode() {
            var email = $("#email0").val();
            $.ajax({
                type: "post",
                url: "/email",
                data: "email=" + email,
                success: function (data) {
                    if (data == 1) {
                        alert("邮箱验证码发送成功");
                    } else if (data == 0) {
                        alert("邮箱验证码发送失败");
                    }else if (data == 2) {
                        alert("操作过于频繁");
                    }
                }
            });
        }
    </script>
</head>
<body>
<a href="/home">返回首页</a>
<br>
<a href="/phone">使用手机号码注册</a>
<br><br>
<div align="center">
    <form action="/emailRegister" method="post">
        <p>用户名：<input type="text" name="name"></p>
        <p>密码：<input type="password" name="pwd"></p>
        <p>邮箱：<input type="text" id="email0" name="email" value=""></p>
        <p>验证码：<input  type="text" name="code"></p>
        <input type="submit" value="注册">
    </form>
    <button type="button" onclick="emailCode()">发送邮箱验证码</button></p>

</div>
</body>
</html>