<%--
  Created by IntelliJ IDEA.
  User: 孙若飞
  Date: 2019/3/11
  Time: 20:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/getMail" name="user" method="post">
    邮箱:<input type="text" name="mail">
    <input type="submit" value="获取验证码"><br>
</form>
</body>
</html>
