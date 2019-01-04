<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@page isELIgnored="false" %>
<html>
<head>
    <title>登录</title>
</head>
<body>
<h1>登录</h1>
<form action="/login" name="user" method="POST">
    姓名:<input type="text" name="name" value="${user.name}"><br>
    密码:<input type="text" name="password" value="${user.password}"><br>
    <input type="submit" value="登录"><br>
</form>
</body>
</html>
