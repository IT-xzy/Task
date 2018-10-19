<%@page pageEncoding="UTF-8" language="java" contentType="text/html; charest=UTF-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <title>邮箱验证重置密码</title>
</head>
<body>
<p>这个是邮箱验证重置密码</p>
<p>请输出您的账号，新密码和手机验证码信息</p>
<form action=${pageContext.request.contextPath}"/reset/mail_check" method="post">
    <input type="text" name="account" placeholder="账号">
    <input type="password" name="password" placeholder="new pwd">
    <input type="text" name="mail_check_core" placeholder="邮箱验证码">
    <input type="submit" value="重置">
</form>
<form action=${pageContext.request.contextPath}"/reset/get_mail_core" method="post">
    <input type="text" name="mail">
    <input type="submit" value="获取验证码">
</form>

</body>