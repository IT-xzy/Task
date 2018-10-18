<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <%--<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">--%>
    <%--<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />--%>
    <%--<meta name="viewport" content="width=device-width, initial-scale=1,minimum-scale=1.0,  maximum-scale=1">--%>
    <%--<link rel="stylesheet" type="text/css" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">--%>
    <%--<title>task9-1</title>--%>
    <%--<link type="text/css" rel="stylesheet" href="../static/css/task9-1.css">--%>
        <div class="container">
            <div class="row">
                <div class="col-md-6 col-sm-6 col-xs-6 header-left">客服热线：010-594-78634</div>
                <div class="col-md-6 col-sm-6 col-xs-6">
                    <div class="header-right">
                        <c:if test="${!empty username}">
                            <a href="/u/user">${username}</a>&emsp;欢迎您！
                        </c:if>
                        <a class="app" href="http://www.jnshu.com/download" target="_blank"><img src="http://jns.img.bucket.ks3-cn-beijing.ksyun.com/skill/skill_html/images/icon-nav-mobile.png"></a>
                        <a class="weixin" href="#">
                            <img src="http://jns.img.bucket.ks3-cn-beijing.ksyun.com/skill/skill_html/images/weixin.png">
                            <img class="extro-info1" style="z-index: 9999" src="http://jns.img.bucket.ks3-cn-beijing.ksyun.com/skill/skill_html/images/code2.jpg">
                        </a>
                        <a class="xinlang" href="https://weibo.com/u/5619279280" target="_blank"><img src="http://jns.img.bucket.ks3-cn-beijing.ksyun.com/skill/skill_html/images/weibo.png"></a>
                            <c:if test="${empty username}">
                                <a href="/login">登录</a>
                                <a href="/register">注册</a>
                            </c:if>
                            <c:if test="${!empty username}">
                                <a href="/exit">退出</a>
                            </c:if>
                    </div>
                </div>
            </div>
        </div>

    <div class="menu">
        <div class="container">
            <div class="row">
                <div class="col-md-12">

                    <nav class="navbar navbar-default" role="navigation">
                        <div class="container-fluid">
                            <img class="picture1" src="../../static/img/15.jpg">
                            <div class="navbar-header">

                                <button tupy="button" class="navbar-toggle" data-toggle="collapse" data-target="#example-navbar-collapse">

                                    <span class="sr-only">切换导航</span>
                                    <span class="icon-bar"></span>
                                    <span class="icon-bar"></span>
                                    <span class="icon-bar"></span>
                                    <span class="icon-bar"></span>
                                    <span class="icon-bar"></span>
                                    <%--<span class="icon-bar"></span>--%>
                                </button>
                            </div>
                            <div class="collapse navbar-collapse" id="example-navbar-collapse">
                                <ul class="nav navbar-nav">
                                    <li><a href="/home">首页</a></li>
                                    <li><a href="/profession">职业</a></li>
                                    <%--<c:if test="${empty username}">--%>
                                    <%--<li><a href="/register">注册</a> </li>--%>
                                    <%--</c:if>--%>
                                    <li><a href="/recommend">推荐</a></li>
                                    <li><a href="/u/students">学生</a> </li>
                                    <li><a href="/u/user">个人信息</a> </li>
                                    <%--<li><a href="#">关于</a></li>--%>
                                </ul>
                            </div>
                        </div>
                    </nav>
                </div>
            </div>
        </div>
    </div>


