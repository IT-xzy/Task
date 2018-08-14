<%--
  Created by IntelliJ IDEA.
  User: Liu Kai
  Date: 2018/8/2
  Time: 20:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<p>输入手机号</p><br>
<form action="/phoneCode" method="post">
    <input name="phoneNum" type="text" required="required" >
    <input type="submit">
</form>
<p>${exception}</p>
</body>
</html>
