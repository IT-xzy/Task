<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2018/7/13
  Time: 15:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>重置密码页面</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/reset">
    <br>用户名:<input type="text" name="username">
    <br>原密码:<input type="password" name="password">
    <br>新密码:<input type="password" name="password2">
    <br>确认密码<input type="password"name="repassword2">
    <br>密码格式：6-20 位，字母、数字、字符
    <br><input type="submit" value="确定">
</form>
<form action="${pageContext.request.contextPath}/logout">
    <input type="submit" value="返回">
</form>
</body>
</html>
