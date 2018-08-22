<%@page pageEncoding="UTF-8" language="java" contentType="text/html; charest=UTF-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<meta http-equiv="refresh" content="3;url=/h1">
<!DOCTYPE html>
<html>
<head>
    <title>重置密码成功</title>
</head>
<body>
<p>重置密码成功</p>
<p>页面3秒后自动跳转主页</p>
<p>或者点击下面按钮自动跳转</p>
<form action=${pageContext.request.contextPath}"/h1" method="get">
    <input type="submit" value="登录页面">
</form>

</body>