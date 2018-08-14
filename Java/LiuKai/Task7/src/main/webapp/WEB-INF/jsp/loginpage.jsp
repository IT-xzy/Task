<%--
  Created by IntelliJ IDEA.
  User: Liu Kai
  Date: 2018/8/3
  Time: 13:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="/signBegin">注册</a><br><br><br>

登陆
<form action="/student" method="get">
    姓名：<input name="stuName" type="text" required="required">
    密码：<input name="passWord" type="password" required="required">
    <input type="submit">
</form>

</body>
</html>
