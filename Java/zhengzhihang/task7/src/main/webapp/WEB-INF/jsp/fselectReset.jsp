<%@page pageEncoding="UTF-8" language="java" contentType="text/html; charest=UTF-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <title>验证方式</title>
</head>
<body>
<p></p>
<p>选择重置密码的方式</p>
<form action=${pageContext.request.contextPath}"/reset/way_verify" method="post">
    <input type="hidden" name="mail" value="mail">
    <input type="submit" value="邮箱验证">
</form>
<form action=${pageContext.request.contextPath}"/reset/way_verify" method="post">
<input type="submit" value="短信验证">
</form>
</body>