<%@page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" language="java"  isELIgnored="false" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="date" uri="test/dateTest" %>
<%--<jsp:useBean id="l" beanName="com.ptteng.model.Login"/>--%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8">
    <title>注册页面</title>
</head>
<a href="/registration/emailRegister">想用邮箱注册</a>
<body>
<form:form name="register" action="/shortMessage" method="post">
    <div>
        用户名：<input name="username" type="text" placeholder="用户名" ><br>
    </div>
    <div>
        手机号：<input name="phone" type="text" placeholder="手机号"><br>
    </div>
    <div>
        <input id="bu" type="submit" value="获取验证码">
    </div>
</form:form>
</body>
</html>