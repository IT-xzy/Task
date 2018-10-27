<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isErrorPage="true"
        isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0;">
    <meta name="format-detection" content="telephone=no">
    <title>无标题</title>
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="css/base.css">
    <link rel="stylesheet" href="css/task-93.css">
    <script src="https://cdn.bootcss.com/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>

<body>
<!-- 头部 -->
<header>
    <div class="top w">
        <div class="num">
            客服热线：010-594-78634
        </div>
        <div class="logos">
            <img src="images/wx.png" alt="">
            <img src="images/qq.png" alt="">
            <img src="images/xl.jpg" alt="">
        </div>
    </div>

    <div class="top1" style="display: block;!important;">
        <a href="/login.jsp">登陆</a><span>|</span><a href="/register.jsp">注册</a>|</span><a
            href="${pageContext.request.contextPath}/exit">注销</a>
    </div>

    <nav>
        <ul class=" nav1 w">
            <img src="images/logo.png" alt="">
            <%--${pageContext.request.contextPath}这个标签的意思,加路径--%>
            <li><a href="${pageContext.request.contextPath}/student">首页</a></li>
            <li><a href="${pageContext.request.contextPath}/u/profession">职业</a></li>
            <li><a href="${pageContext.request.contextPath}/u/company">推荐</a></li>
            <li><a href="">关于</a></li>
        </ul>
        <div class="dropdown">
            <img class="ji" src="images/logo.png" alt="">
            <button class="btn dropdown-toggle clearfix" type="button" id="dropdownMenu1" data-toggle="dropdown"
                    aria-haspopup="true" aria-expanded="true">
                    <span>
                        <img src="images/btn1.png" alt="">
                    </span>
            </button>
            <ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
                <li><a href="${pageContext.request.contextPath}/student">首页</a></li>
                <li><a href="${pageContext.request.contextPath}/profession">职业</a></li>
                <li><a href="#">推荐</a></li>
                <li><a href="#">关于</a></li>
            </ul>
        </div>
    </nav>
</header>

</body>

</html>