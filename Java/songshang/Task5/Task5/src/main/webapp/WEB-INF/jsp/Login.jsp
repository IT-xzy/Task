<%--
  Created by IntelliJ IDEA.
  User: lucifer
  Date: 2018/2/6
  Time: 14:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>登陆界面</title>
</head>
<body>
<form action="${ctx}/Login" method="post">
    账户：<input type="text" name="user"/><br/><br/>
    密码：<input type="text" name="pass"/><br/><br/>
    <input type="submit" name="登录" value="登录">
</form>
<a href="${ctx}/user">注册新用户</a><br/>
</body>
</html>
