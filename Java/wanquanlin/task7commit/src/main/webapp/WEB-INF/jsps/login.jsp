<%--
  Created by IntelliJ IDEA.
  User: caoyue
  Date: 2018/4/27
  Time: 下午3:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>登录</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/login.css">
</head>
<body>
<div class="header wide">
    <a href="" class="left middle">关闭</a>
    <a href="/register" class="right middle"  >注册</a>
    <span class="middle">登陆</span>
</div>
<form:form method="post" action="${pageContext.request.contextPath}/clientLogin" modelAttribute="signIn">
    <h5 style="color:red"> ${errorlogin} </h5>
    <div class="main">
        <b><img src="images/iphone.png" alt=""></b>
        <form:input name="username" id="username" type="text" placeholder="输入手机号码" class="wide text" path="account"/>
        <br><form:errors path="account" cssClass="error"></form:errors>
        <b><img src="images/locked 2.png" alt=""></b>
+        <form:input name="password" id="password" type="password" placeholder="输入密码" class="wide text" path="password"/>
        <br>
        <form:errors path="password" cssClass="error"></form:errors>
        <input type="submit" class="wide backgroundcolor middle"/>
        <a href="">忘记密码?</a>
    </div>
</form:form>
</body>
</html>
