<%@ page language="java" pageEncoding="UTF-8" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>用户登录</title>
</head>
<body>
<center>
    <form action="/login" method="get">
        <p>ID：<input type="number" name="id"></p>
        <p>姓名：<input type="text" name="name"></p>
        <input type="submit" value="登录">
    </form>
</center>
</body>
</html>