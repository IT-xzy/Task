<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<h2 style="color: cadetblue">Hello World!</h2>
<form action="login.html" method="post">
    <input type="submit" value="已有账号，点我跳转登录">
</form>
<form action="register.jsp" method="post">
    <input type="submit" value="没有账号，点我注册">
</form>

<form action="/students" method="post">
    <input type="submit" value="JSON取值">
</form>
</body>
</html>