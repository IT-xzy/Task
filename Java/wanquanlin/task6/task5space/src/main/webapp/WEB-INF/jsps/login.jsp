<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <style>
        .error{color:red}
    </style>
</head>
<body>
<br>
<br>
<br>
<form:form action="${pageContext.request.contextPath}/clientLogin"  align="center" modelAttribute="signIn">
           <h5 style="color:red"> ${errorlogin} </h5>
    账号:<form:input path="account"/>
    <br>
    <form:errors path="account" cssClass="error"></form:errors>
    <br>
    <br>
    密码:<form:input type="password" path="password"/>
    <br>
    <form:errors path="password" cssClass="error"></form:errors><br>
    <br>
    <br>
    <input type="submit" value="登陆">
</form:form>
</body>
</html>