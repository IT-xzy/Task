<%--
  Created by IntelliJ IDEA.
  User: Shinelon
  Date: 2019/4/3
  Time: 2:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
</head>
<body>
<h1>登录</h1>
<form action="/login" name="user" method="post">
    用户名:<input type="text" name="name">
    密码:<input type="password" name="password" >
    <input type="submit" value="登录">
</form>
</body>
</html>
