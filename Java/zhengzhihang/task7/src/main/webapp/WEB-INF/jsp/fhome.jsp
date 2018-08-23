<%--
  Created by IntelliJ IDEA.
  User: a1
  Date: 2018/7/23
  Time: 下午8:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Task5 home page</title>
</head>
<body>
<h1>请登录或者注册</h1>

<form action=${pageContext.request.contextPath}"/pass" method="post">
<p><input type="text" name="account" size="10" placeholder="账号"></p>
<p><input type="password" name="password" size="10" placeholder="密码"></p>
<input type="submit" value="登录">
</form>
<form action=${pageContext.request.contextPath}"/login" method="get">
    <input type="submit" value="注册">
</form>
<form action=${pageContext.request.contextPath}"/reset/home" method="get">
    <input type="submit" value="忘记密码" >
</form>

</body>
</html>
