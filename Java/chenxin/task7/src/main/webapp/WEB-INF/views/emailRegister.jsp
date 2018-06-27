<%@page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" language="java"  isELIgnored="false" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="date" uri="test/dateTest" %>
<%--<jsp:useBean id="l" beanName="com.ptteng.model.Login"/>--%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8">
    <title>邮箱注册页面</title>
</head>
<a href="/registration/register">想用手机注册</a>
<body>
<form:form name="register" action="/emailMessage" method="post">
    <div>
        用户名：<input name="username" type="text" placeholder="用户名" ><br>
    </div>
    <div>
        邮箱：<input name="email" type="email" placeholder="邮箱"><br>
    </div>
    <div>
        <input id="bu" type="submit" value="获取验证码">
    </div>
</form:form>
</body>
</html>