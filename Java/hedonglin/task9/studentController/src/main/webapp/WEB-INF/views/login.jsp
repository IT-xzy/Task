<%--
  Created by IntelliJ IDEA.
  User: Dong
  Date: 2018/2/4
  Time: 10:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath }/login" method="post">
    账号:
    <br>
    <input type="text" name="account">
    <br>
    密码:
    <br>
    <input type="text" name="password">
    <br>
    <br>
    <input type="submit" value="登陆">
</form>
<form action="${pageContext.request.contextPath }/registered" method="get">
    <input type="submit" value="注册">
</form>


</body>
</html>
