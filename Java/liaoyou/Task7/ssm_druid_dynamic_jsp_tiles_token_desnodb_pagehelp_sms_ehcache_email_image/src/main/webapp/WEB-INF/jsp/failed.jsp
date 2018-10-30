<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="false" %>

<html>
<head>
    <title>register failed</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap.min.css"/>
</head>
<body>
<header>
    <div class="row">
        <div class="col-md-12">
            <br>
            <br>
            <h1 align="center">登录or注册失败</h1>
            <br>
            <br>
        </div>
    </div>
</header>
<div class="container">
    <div align="center">
        <a href="${pageContext.request.contextPath}/home" role="button" class="btn btn-info btn-lg">HOME</a>
        <a href="${pageContext.request.contextPath}/u/login" role="button" class="btn btn-info btn-lg">LOGIN</a>
        <a href="${pageContext.request.contextPath}/u/register" role="button" class="btn btn-info btn-lg">REGISTER</a>
    </div>
</div>
</body>
<!--jQuery(Bootstrap的JavaScript插件需要引入jQuery)-->
<script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<!--包括所以已编译的插件-->
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
</html>