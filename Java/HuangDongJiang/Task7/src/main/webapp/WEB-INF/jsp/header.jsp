<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="ttf" uri="/WEB-INF/tag/timeFormat.tld/" %>
<head>
    <meta charset="utf-8">
    <title>职业</title>
    <meta content="width=device-width, initial-scale=1.0" name="viewport" charset="UTF-8">
    <link rel="stylesheet" href="http://apps.bdimg.com/libs/bootstrap/3.3.4/css/bootstrap.min.css">
    <script src="http://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
    <script src="http://apps.bdimg.com/libs/bootstrap/3.3.4/js/bootstrap.min.js"></script>
    <link href="${pageContext.request.contextPath}/images/t11.css" rel="stylesheet" type="text/css">
    <link href="${pageContext.request.contextPath}/images/base.css" rel="stylesheet" type="text/css">
</head>
<header>
    <div class="top container">
        <p class="hidden-xs">客服热线：010-594-78634</p>
        <img src="${pageContext.request.contextPath}/images/12321.gif">
        现在的时间是：${ttf:transformTimeFormat("yyyy-MM-dd hh:ss:mm")}
    </div>
    <div role="navigation" class="nav1 navbar navbar-default">
        <div class="container">
            <div class="header-logo">
                <div class="logo-middle"><img src="${pageContext.request.contextPath}/images/logo.png"></div>
            </div>
            <div class="navbar-header marginTop">
                <button data-target="#example-navbar-collapse" data-toggle="collapse" class="navbar-toggle" type="button">
                    <span class="sr-only">切换导航</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
            </div>

            <div id="example-navbar-collapse" class=" collapse navbar-collapse">
                <ul class="nav navbar-nav">
                    <a href="${pageContext.request.contextPath}/index"><li>首 页</li></a>
                    <a href="${pageContext.request.contextPath}/u/career">职业</a>
                    <a href=""><li>推 荐</li></a>
                    <a href=""><li>关 于</li></a>
                    <c:if test="${!cookie.containsKey('loginToken')}">
                        <a href="${pageContext.request.contextPath}/login/login.jsp"><li>请登录</li></a>
                    </c:if>
                    <c:if test="${cookie.containsKey('loginToken')}">
                        欢迎您，[${cookie.get('username').value}]
                        <a href="${pageContext.request.contextPath}/register/imformation.jsp">我的信息</a>
                    </c:if>
                </ul>
            </div>
        </div>
    </div>
</header>