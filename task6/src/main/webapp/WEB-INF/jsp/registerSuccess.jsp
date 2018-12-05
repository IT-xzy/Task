<%--
  Created by IntelliJ IDEA.
  User: qyh
  Date: 2018/10/30
  Time: 17:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isErrorPage="true" isELIgnored="false"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>注册成功</title>
</head>
<div  style="text-align:center">
<body>
<c:choose>
    <c:when test = "${message != null}">
        <p>"${message}"</p>
        请重新 <li><a href="/task6/register" class="btn">注册</a></li>
    </c:when>
    <c:otherwise>
        注册成功
        <a href="/task6/login" class="btn">登陆</a>
    </c:otherwise>
</c:choose>
</body>
</div>
</html>
