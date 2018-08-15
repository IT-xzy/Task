<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2018/7/2
  Time: 19:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录页面</title>
</head>
<body>
<br>
<%--<center>--%>
<form action="${pageContext.request.contextPath}/login" method="post" >
    <br>用户：<input type="text" name="username">
    <br>密码：<input type="password" name="password">
    <br><input type="submit" value="登录">
</form>
<form action="${pageContext.request.contextPath}/loginFormShow">
   <input type="submit" value="注册">
</form>
<form action="${pageContext.request.contextPath}/loginReset">
   <input type="submit" value="重置">
</form>
</body>
</html>
