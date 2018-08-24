<%@page pageEncoding="UTF-8" language="java" contentType="text/html; charest=UTF-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <title>重置密码页</title>
</head>
<body>
<p>欢迎进入重置密码页</p>
<p>请输入您要重置密码的账号</p>
<form action=${pageContext.request.contextPath}"/reset/account_check" method="post">
    <input type="text" name="account" placeholder="账号">
    <input type="submit" name="提交">
</form>
</body>

