<%--
  Created by IntelliJ IDEA.
  User: Dong
  Date: 2018/2/5
  Time: 14:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册页面</title>
</head>
<body>
用户注册
<form action="${pageContext.request.contextPath }/registered/u" method="post">
    <br>账号<input type="text" name="account">
    <br>密码<input type="text" name="password">
    <input type="submit" name="注册">
</form>
</body>
</html>
