<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@page isELIgnored="false" %>
<html>
<head>
    <title>注册</title>
</head>
<body>
<h1>注册</h1>
<form action="/register" name="user" method="POST" >
    姓名:<input type="text" name="name" value="${user.name}"><br>
    密码:<input type="text" name="password" value="${user.password}"><br>
    <input type="submit" value="注册"><br>
</form>
</body>
</html>
