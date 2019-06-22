<%--
  Created by IntelliJ IDEA.
  User: 老王
  Date: 2019/6/13
  Time: 17:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>验证码</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/a/gatMail" name="user" method="post">
    邮箱:<input type="text" name="mail">
    <input type="submit" value="获取验证码"><br>
</form>
</body>
</html>
