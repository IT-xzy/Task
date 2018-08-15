<%--
  Created by IntelliJ IDEA.
  User: root
  Date: 2018/7/4
  Time: 10:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登陆注册</title>
</head>
<body>
<style type="text/css">
    body{
        background-image: url(imges/001.jpg);
        background-size:cover;
    }
</style>


<form action="/login" method="get">

    <div align="center">
        用户：<input name="username" placeholder="请输入账号"><br /><br />
        密码：<input type="password" name="userpassword" placeholder="请输入密码"><br />
        <input type="submit" value="登陆">
    </div>
</form>
<form action="/register" method="post">
    <div align="center">
        用户：<input type="text" name="username" maxlength="15" placeholder="字母开头不低于5位"><br /><br />
        密码：<input type="password" name="userpassword" maxlength="15" placeholder="字母开头不低于5位"><br />
        <input type="submit" value="注册">
    </div>
</form>
</body>
</html>
