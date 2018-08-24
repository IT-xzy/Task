<%--
  Created by IntelliJ IDEA.
  User: LUCKY 铭
  Date: 2018/7/21
  Time: 9:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="utils" uri="/WEB-INF/taglib/time.tld" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>IT修真院</title>
    <link href="/css/bootstrap.min.css" rel="stylesheet" type="text/css">
    <link href="../bootstrap-3.3.5-dist/css/bootstrap.css">
    <link href="/css/Untitled-3.css" rel="stylesheet" type="text/css">
    <link href="/css/Untitled-1base.css" rel="stylesheet" type="text/css">

</head>
<body>
<div class="container  hidden-xs">
    <div class="row header-top">
        <p class="col-xs-12 col-sm-6 col-md-6 col-lg-6">${utils:dateTag(time,"yyyy-MM-dd HH:mm:ss")}
            客服电话:010-594-78634</p>
            当前用户：${username}
        <c:if test="${username!=null}">
            <a href="${pageContext.request.contextPath}/logout">退出 </a>
        </c:if>
        <div class="col-xs-12 col-sm-6 col-md-6 col-lg-6 text-right">
            <div>
                <a href="#" target="_blank"> <img alt=""  src="${pageContext.request.contextPath}/imges/54537.png"></a>
                <a href="#" target="_blank"><img alt=""  src="/imges/45678678.png"></a>
                <a href="#" target="_blank"> <img alt=""  src="/imges/54375483543.png"></a>
            </div>
        </div>
    </div>
</div>

<nav class="navbar navbar-default">
    <div class="container">
        <div class="navbar-header">
            <a href="#" class="navbar-brand">
                <img src="/imges/logo.png" alt="Brand" class="img-responsive">
            </a>
            <button data-target="#open-nav" data-toggle="collapse" class="navbar-toggle btn-primary collapsed" aria-expanded="false">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
        </div>
        <div id="open-nav" class="navbar-collapse collapse" aria-expanded="false" style="height: 1px;">
            <ul class="nav navbar-nav navbar-right text-center list-inline">
                <li><a href="/a">首页</a></li>
                <li><a href="/u/tll">职业</a></li>
                <li><a href="">推荐</a></li>
                <li><a href="">关于</a></li>
                <li><a href="/u/oss">个人信息</a></li>
            </ul>
        </div>

    </div>
</nav>
<script src="/js/jquery.min.js"></script>
<script  src="/js/bootstrap.min.js"></script>
</body>
</html>