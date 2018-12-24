<%@ page language="java" pageEncoding="UTF-8" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<body>
<a href="/home" style="color: black;">返回首页</a>
<br>
<a href="/toRegister" style="color: black;">使用邮箱注册</a>
<br><br>
<div align="center">
    <form action="/register" method="post">
        <p>用户名：<input type="text" name="name"></p>
        <p>密码：<input type="password" name="pwd"></p>
        <p>电话：<input type="text" name="phone"></p>
        <input type="submit" value="注册">
    </form>
</div>
</body>
</html>