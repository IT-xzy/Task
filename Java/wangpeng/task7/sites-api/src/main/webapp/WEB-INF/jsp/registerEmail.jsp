<%--
  Created by IntelliJ IDEA.
  User: 老王
  Date: 2019/6/13
  Time: 17:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>邮箱注册</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/registerByMail" name="user" method="post">
    用户名:<input type="text" name="name">
    密码:<input type="text" name="password">
    邮箱:<input type="text" name="mail">
    验证码:<input type="text" name="code">
    手机号:<input type="text" name="phone">
    <input type="submit" value="注册"><br>
</form>
</body>
</html>
