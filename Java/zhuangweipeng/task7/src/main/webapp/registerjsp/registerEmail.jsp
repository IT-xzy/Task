<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script src="https://cdn.bootcss.com/jquery/3.3.1/jquery.js"></script>
<html>
<head>
    <title>邮箱注册</title>
</head>
<body>
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
<script>
    function volidate() {

        if (document.getElementById("name").value == "" || document.getElementById("name").value == " ") {
            alert("姓名不能为空或者空格")
            document.getElementById("name").focus();
            return false;
        } else if (document.getElementById("password").value == "" || document.getElementById("password").value == " ") {
            alert("密码不能为空或者空格")
            document.getElementById("password").focus();
            return false;
        } else if (document.getElementById("password").value != document.getElementById("psq").value) {
            alert("前后两次输入密码不相等")
            document.getElementById("password").focus();
            return false;
        }
        return true;
    }
</script>
<%--<form style="text-align:center;" action="${pageContext.request.contextPath}/registration" method="post">--%>
<form style="text-align:center;" name="registerEmail" action="${pageContext.request.contextPath}/registrationEmail" method="post">
    <h1>邮箱注册界面</h1>
    账 号 ：<input type="text" name="name" placeholder="账户名" autocomplete="on"><br/>
    密 码 ：<input type="password" name="password" placeholder="密码" autocomplete="on"><br/>
    再次输入密码 ：<input type="password" name="psd" placeholder="密码" autocomplete="on"><br/>
    邮箱 : <input id="email" type="text" name="email" placeholder="邮箱号码" autocomplete="on"><br/>
    邮箱验证码：<input type="text" name="emailcode" placeholder="邮箱验证码" autocomplete="on"><br/>
    <br/>
    <input id="bu" type="submit" value="注册" onsubmit="volidate()">
</form>
<form style="text-align:center;">
    <button onclick="sendMail()">发送邮箱验证码</button>
</form>
</body>
</html>