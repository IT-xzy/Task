<%@ page language="java" pageEncoding="UTF-8" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<body>
<a href="/home">返回首页</a>
<br><br>
<div align="center">
    <form action="/login" method="post">
        <p>用户名：<input type="text" name="name"></p>
        <p>密码：<input type="password" name="pwd"></p>
        <input type="submit" value="登录">
    </form>
</div>
</body>
</html>