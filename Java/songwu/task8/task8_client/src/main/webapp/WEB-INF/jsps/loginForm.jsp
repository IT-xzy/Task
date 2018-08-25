<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2018/7/2
  Time: 20:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册页面</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/loginForm" method="post">
    <br> 用户：<input type="text" name="username">
    <br> 昵称格式：限16个字符，支持中英文、数字、减号或下划线
    <br> 密码：<input type="text" name="password">
    <br>密码格式：6-20 位，字母、数字、字符
    <br> <input type="submit" value="确定">
</form>
<form action="${pageContext.request.contextPath}/logout">
    <input type="submit" value="返回">
</form>
</body>
</html>
