<%--
  Created by IntelliJ IDEA.
  User: 孙若飞
  Date: 2019/2/15
  Time: 16:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>注册</title>
</head>
<body>
<h1>注册</h1>
<form action="/register" name="user" method="post">
用户名:<input type="text" name="name" >
密码:<input type="text" name="password">
    <input type="submit" value="注册"><br>
</form>
</body>
</html>
