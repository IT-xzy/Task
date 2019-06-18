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
    <title>登录</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/login.css"/>
</head>

<body>
<div class="top">修真院&nbsp;·&nbsp;老大最帅！</div>
<form action="${pageContext.request.contextPath}/login" name="user" method="post">

    <div class="content">
        <div class="login">
            <div class="title">修真院&nbsp;·&nbsp;登录</div>
            <div class="line">
                <img class="smallImg" src="${pageContext.request.contextPath}/static/images/icon-4.png"/>
                <input placeholder="请输入用户名" type="text" name="name"/>
            </div>
            <div class="line">
                <img class="smallImg" src="${pageContext.request.contextPath}/static/images/icon-5.png"/>
                <input placeholder="请输入密码" type="password" name="password"/>
            </div>
            <button type="submit" class="logBut">登&nbsp;&nbsp;录</button>
        </div>
    </div>
</form>
</body>

</html>
