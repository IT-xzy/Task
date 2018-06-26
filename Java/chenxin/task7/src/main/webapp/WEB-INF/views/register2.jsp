<%@page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" language="java"  isELIgnored="false" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="date" uri="test/dateTest" %>
<%--<jsp:useBean id="l" beanName="com.ptteng.model.Login"/>--%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8">
    <title>注册页面2</title>
</head>
<body>
<form:form name="register" action="/shortMessageCaptche" method="post">
    <div>
        密码：<input name="password" type="text" placeholder="密码" ><br>
    </div>
    <div>
        验证码：<input name="image" type="text" placeholder="验证码"><br>
    </div>
    <div>
        <input id="bu" type="submit" value="验证">
    </div>
</form:form>
</body>
</html>