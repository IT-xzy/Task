<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="date" uri="/tag" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Title</title>
    <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <link href="static/css/task8.1.css" type="text/css" rel="stylesheet"/>
    <link href="static/css/task8.2.css" type="text/css" rel="stylesheet"/>
    <link href="static/css/task8.3.css" type="text/css" rel="stylesheet"/>
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<header>
    <div><span>客服电话：010-594-78634</span></div>
    <div class="headico-box">
        <div class="headico1"></div>
        <div class="headico2"></div>
        <div class="headico3"></div>
        <c:choose>
            <c:when test="${name == null || name == ''}">
                <li><a class="a-style" href="/goLogin"> <input type="button"  value="登录"></a></li>
                <li><a class="a-style" href="/goRegister"><input type="button" value="注册"></a></li>
            </c:when>
            <c:otherwise>
                <c:out value="欢迎! ${name}"/>
                <li><a class="a-style" href="/logout"><input type="button" value="注销"> </a></li>
            </c:otherwise>
        </c:choose>
        <%--<li><a class="a-style" href="/u/register"><input type="button" value="注册"></a></li>--%>
        <%--<li><a class="a-style" href="/u/login"> <input type="button"  value="登录"></a></li>--%>
        <%--<li><a class="a-style" href="/logout"><input type="button" value="注销"> </a></li>--%>
    </div>
</header>


<nav class="navbar navbar-default nav-style" role="navigation">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse"
                    data-target="#example-navbar-collapse">
                <span class="sr-only">切换导航</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
        </div>
        <div class="collapse navbar-collapse li-box" id="example-navbar-collapse">
            <ul class="nav navbar-nav ul-box">
                <li><a href="/">系统时间：<date:date value="<%=System.currentTimeMillis()%>"/></a></li>
                <li class="active li-border"><a class="a-active" href="/">首页</a></li>
                <li><a class="a-style" href="/u/job">职业</a></li>
                <li><a class="a-style" href="/">推荐</a></li>
                <li><a class="a-style" href="/">关于</a></li>

            </ul>
        </div>
    </div>
</nav>
