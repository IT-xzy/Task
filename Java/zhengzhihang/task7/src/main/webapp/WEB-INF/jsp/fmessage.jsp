<%@page pageEncoding="UTF-8" language="java" contentType="text/html; charest=UTF-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <title>短信验证重置密码</title>
</head>
<body>
<p>这个是短信验证重置密码</p>
<p>请输出您的账号，新密码和手机验证码信息</p>
<form action=${pageContext.request.contextPath}"/reset/message_check" method="post">
    <input type="text" name="account" placeholder="账号">
    <input type="password" name="password" placeholder="new pwd">
    <input type="text" name="messageCore" placeholder="短信验证码">
    <input type="submit" value="重置">
</form>
<form action=${pageContext.request.contextPath}"/reset/get_message_core" method="post">
    <input type="text" name="phoneNumber" placeholder="电话号码">
    <input type="submit" value="发送短信验证码">
</form>

</body>