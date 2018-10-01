<%@page pageEncoding="UTF-8" language="java" contentType="text/html; charest=UTF-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <title>注册页</title>
</head>
<body>
<p>欢迎注册，请输入用户名和密码</p>
<form method="post" action=${pageContext.request.contextPath}"/add"><!--这里不能和jsp同名，要注意 -->
    <p><input type="text" name="account" size="10" placeholder="账号" style="margin:0; padding:0; width:100px; height:20px" ></p>
    <p><input type="password" name="password" size="10" placeholder="密码" style="margin:0; padding:0; width:100px; height:20px" ></p>
    <input type="submit" value="确定">
</form>

<form method="get" action=${pageContext.request.contextPath}"/h1">
    <input type="submit" value="取消">
</form>
</body>

