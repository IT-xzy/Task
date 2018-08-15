<%--
  Created by IntelliJ IDEA.
  User: Liu Kai
  Date: 2018/7/21
  Time: 18:44
  To change this template use File | Settings | File Templates.
--%>
<!doctype html>
<%@ page language="java" contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
%>
<html>
<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>无标题文档</title>
    <link href="<%=basePath%>/css/bootstrap.min.css" rel="stylesheet" type="text/css">
    <link href="<%=basePath%>/css/bootstrap.css">
    <link href="<%=basePath%>/css/Untitled-3.css" rel="stylesheet" type="text/css">
    <link href="<%=basePath%>/css/Untitled-1base.css" rel="stylesheet" type="text/css">
</head>
<body>
<div class="container  hidden-xs">
    <div class="row header-top">
        <p class="col-xs-12 col-sm-6 col-md-6 col-lg-6">客服电话:010-594-78634</p>
        <div class="col-xs-12 col-sm-6 col-md-6 col-lg-6 text-right">
            <div>
                <a href="#" target="_blank"> <img alt=""  src="imges/54537.png"></a>
                <a href="#" target="_blank"><img alt=""  src="imges/45678678.png"></a>
                <a href="#" target="_blank"> <img alt=""  src="imges/54375483543.png"></a>
            </div>
        </div>
    </div>
</div>
<nav class="navbar navbar-default">
    <div class="container">
        <div class="navbar-header">
            <a href="#" class="navbar-brand">
                <img src="imges/logo.png" alt="Brand" class="img-responsive">
            </a>
            <button data-target="#open-nav" data-toggle="collapse" class="navbar-toggle btn-primary collapsed" aria-expanded="false">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
        </div>
        <div id="open-nav" class="navbar-collapse collapse" aria-expanded="false" style="height: 1px;">
            <ul class="nav navbar-nav navbar-right text-center list-inline">
                <li><a href="/homepage">首页</a></li>
                <li><a href="/course">职业</a></li>
                <li><a href="">推荐</a></li>
                <li><a href="">关于</a></li>
            </ul>
        </div>

    </div>
</nav>

</div>
</body>
<script src="<%=basePath%>/js/jquery.min.js"></script>
<script  src="<%=basePath%>/js/bootstrap.min.js"></script>
</html>