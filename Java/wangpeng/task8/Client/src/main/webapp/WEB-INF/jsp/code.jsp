<%--
  Created by IntelliJ IDEA.
  User: 老王
  Date: 2019/6/14
  Time: 9:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>验证码</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/a/getPhone" name="user" method="post">
    手机号:<input type="text" name="phone">
    <input type="submit" value="获取验证码"><br>
</form>
</body>
</html>
