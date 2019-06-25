<%--
  Created by IntelliJ IDEA.
  User: 老王
  Date: 2019/5/23
  Time: 12:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <meta charset="utf-8"/>
    <title>注册</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/register.css"/>
</head>

<body>
<div class="top">IT修真院&nbsp;·&nbsp;老大最帅！</div>
<form action="${pageContext.request.contextPath}/register" name="user" method="post">
    <div class="content">
        <div class="login">
            <div class="title">修真院注册</div>
            <div class="line">
                <img class="smallImg" src="${pageContext.request.contextPath}/static/images/icon1.png"/>
                <input placeholder="请输入用户名" type="text" name="name"/>
            </div>
            <div class="line">
                <img class="smallImg" src="${pageContext.request.contextPath}/static/images/icon2.png"/>
                <input placeholder="请输入密码" type="text" name="password"/>
            </div>
            <button type="submit" class="logBut">注&nbsp;&nbsp;册</button>
        </div>
    </div>
</form>
</body>

</html>

