<%--
  Created by IntelliJ IDEA.
  User: lichu
  Date: 2018-5-23
  Time: 11:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="/css/bootstrap.min.css" rel="stylesheet" type="text/css">
    <link href="/css/base.css" rel="stylesheet" type="text/css">
    <link href="/css/body.css" rel="stylesheet" type="text/css">
    <title>ptteng</title>
</head>
<body>
<div class="container  hidden-xs" >
    <div class="row header-top">
        <p class="col-xs-12 col-sm-6 col-md-6 col-lg-6">客服电话:010-594-78634</p>
        <div class="col-xs-12 col-sm-6 col-md-6 col-lg-6 text-right">
            <div>
                <a href="#" target="_blank"> <img alt="qq"  src="../images/qq.png"></a>
                <a href="#" target="_blank"><img alt="wechat"  src="../images/wechat.png"></a>
                <a href="#" target="_blank"> <img alt="weibo"  src="../images/weibo.png"></a>
            </div>
        </div>
    </div>
</div>

<nav class="navbar navbar-default">
    <div class="container">
        <div class="navbar-header">
            <a href="#" class="navbar-brand">
                <img src="../images/logo.png" alt="Brand" class="img-responsive">
            </a>
            <button data-target="#open-nav" data-toggle="collapse" class="navbar-toggle btn-primary collapsed" aria-expanded="false">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
        </div>
        <div id="open-nav" class="navbar-collapse collapse" aria-expanded="false" style="height: 1px;">
            <ul class="nav navbar-nav navbar-right text-center list-inline">
                <li><a href="/register">注册</a></li>
                <li><a href="/login">登录</a></li>
                <li><a href="/home">首页</a></li>
                <li><a href="/career">职业</a></li>
                <li><a href="">推荐</a></li>
                <li><a href="">关于</a></li>
                <li><a href="/logout">退出</a></li>
            </ul>
        </div>
    </div>
</nav>
</body>
</html>
