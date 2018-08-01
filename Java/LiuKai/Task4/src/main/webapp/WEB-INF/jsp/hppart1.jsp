<%--
  Created by IntelliJ IDEA.
  User: Liu Kai
  Date: 2018/7/22
  Time: 10:54
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
    <link href="<%=basePath%>/css/bootstrap-3.3.5-dist/css/bootstrap.css">
    <link href="<%=basePath%>/css/Untitled-3.css" rel="stylesheet" type="text/css">
    <link href="<%=basePath%>/css/Untitled-1base.css" rel="stylesheet" type="text/css">
</head>
<body>
<div id="myCarousel" class="carousel slide">
    <ol class="carousel-indicators">
        <li class="active" data-slide-to="0" data-target="#myCarousel"></li>
        <li data-slide-to="1" data-target="#myCarousel"></li>
        <li data-slide-to="2" data-target="#myCarousel"></li>
        <li data-slide-to="3" data-target="#myCarousel"></li>
    </ol>
    <div class="carousel-inner">
        <div class="item active">
            <img alt="First slide" src="imges/547567.jpg">
        </div>
        <div class="item">
            <img alt="Second slide" src="imges/547567.jpg">
        </div>
        <div class="item">
            <img alt="Third slide" src="imges/547567.jpg">
        </div>
        <div class="item">
            <img alt="Third slide" src="imges/547567.jpg">
        </div>
        <a data-slide="prev" href="#myCarousel" class="carousel-control left">
            <i class="icon-left"><img src="imges/54354.png"></i>
        </a>
        <a data-slide="next" href="#myCarousel" class="carousel-control right">
            <i class="icon-right"><img src="imges/4525424.png"></i>
        </a>
    </div>
</div>
</body>
<script src="<%=basePath%>/js/jquery.min.js"></script>
<script  src="<%=basePath%>/js/bootstrap.min.js"></script>
</html>
