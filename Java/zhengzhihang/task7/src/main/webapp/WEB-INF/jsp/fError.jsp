<%--
  Created by IntelliJ IDEA.
  User: a1
  Date: 2018/7/23
  Time: 下午8:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>错误页面</title>
</head>
<body>
<h1>${a}</h1>
<p>${o}</p>
<form method="get" action=${pageContext.request.contextPath}"/h1">
    <input type="submit" value="登录页面" size="10">
</form>
<form method="get" action=${pageContext.request.contextPath}"/login">
    <input type="submit" value="注册页面" size="10">
</form>
</body>
</html>
