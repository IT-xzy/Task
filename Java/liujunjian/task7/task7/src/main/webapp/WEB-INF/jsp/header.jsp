<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<html>
<head>
    <link rel="stylesheet" href="../css/header.css">
    <title>页眉</title>
</head>
<body>
<header>
    <div class="container">
        <div class="row">
            <div class="col-xs-6 hidden-xs">
                <span class="">客服热线：<a href="tel:010-594-78634">010-594-78634</a></span>
            </div>
            <div class="col-xs-4 hidden-xs">
                <a href=""><img src="../images/wechat.png" alt=""></a>
                <a href=""><img src="../images/qq.png" alt=""></a>
                <a href=""><img src="../images/sina.png" alt=""></a>
            </div>
            <div class="col-xs-2 hidden-xs">
                <a href="${pageContext.request.contextPath}/login">登录</a>
                <a href="">|</a>
                <a href="${pageContext.request.contextPath}/cancellation">注销</a>
                <a href="">|</a>
                <a href="${pageContext.request.contextPath}/personalInformation">个人信息</a>
            </div>
        </div>
    </div>
</header>
<!--content-->
<nav class="navbar navbar-default" role="navigation">
    <div class="container">
        <div class="row">
            <div class="navbar-header">
                <a class="navbar-brand" href=""><img src="../images/home-logo.png" alt="" class="img-re"></a>
                <button type="button" class="navbar-toggle" data-toggle="collapse"
                        data-target="#navbar-collapse">
                    <i class="glyphicon glyphicon-menu-hamburger"></i>
                </button>
            </div> <!-- navbar-header -->
            <div class="collapse navbar-collapse navbar-right" id="navbar-collapse">
                <ul class="nav navbar-nav navbar-right text-center">
                    <li><a href="${pageContext.request.contextPath}/homePage">首&nbsp;页</a></li>
                    <li><a href="${pageContext.request.contextPath}/profession">职&nbsp;业</a></li>
                    <li><a href="${pageContext.request.contextPath}/u">推&nbsp;荐</a></li>
                    <li><a href="#">关&nbsp;于</a></li>
                </ul>
            </div>
        </div>  <!-- nav-row -->
    </div>  <!-- nav-container -->
</nav>
</body>
</html>
