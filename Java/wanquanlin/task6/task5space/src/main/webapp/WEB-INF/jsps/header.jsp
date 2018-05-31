<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/4/4
  Time: 16:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
</head>
<body>
<nav>
    <div class="kefu">客服热线：010-594-78634</div>
    <div class="pic">
        <a href class="wechat"></a>
        <a href class="qq"></a>
        <a href class="weibo"></a>
    </div>
</nav>
<div class="header">
    <div class="jnshu"></div>
    <div class="right">
        <a href="${pageContext.request.contextPath}/welcome">首页</a>

        <a href="${pageContext.request.contextPath}/u/jobs">职业</a>
        <a href="${pageContext.request.contextPath}/register " methods="GET">注册</a>
        <a href="${pageContext.request.contextPath}/signout">登出</a>
    </div>
</div>
</body>
</html>