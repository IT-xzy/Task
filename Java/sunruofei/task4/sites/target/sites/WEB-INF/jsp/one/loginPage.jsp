<%--
  Created by IntelliJ IDEA.
  User: 孙若飞
  Date: 2019/2/15
  Time: 17:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
</head>
<body>
<h1>登录</h1>
<form action="/login" name="user" method="get">
用户名:<input type="text" name="name">
密码:<input type="text" name="password" >
    <input type="submit" value="登录">
</form>
</body>
</html>
