<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="java.util.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>我的信息</title>
    <meta charset="utf-8" name="viewport" content="width=device-width"
          initial-scale=1 maximum-scale=1 minimum-scale=1 user-scalable=no>
    <link rel="stylesheet" href="/views/two.css">
    <link href="/js/bootstrap.min.css"
          rel="stylesheet">
</head>
<body>

<div class="header-end"></div>
<!--main-->
<main>
    <!--main-top-->
    <div class="main-top">
        <p class="main-top-left">
            <a href="/home">首页< </a>
        </p>
        <p class="main-top-right">我的信息</p>
    </div>
    <!--main-left-->
    <div class="main">
        <div class="main-left">
            <p>功能一览</p>
            <div class="main-left-link">
                <a href="#">模块一</a>
                <a href="#">模块二</a>
                <a href="#">模块三</a>
                <a href="#">模块四</a>
                <a href="#">模块五</a>
            </div>
        </div>
        <!--main-right-->
        <div class="right-fix">
            <div class="main-right-top">
                <div class="tudou-logo">
                    <img src="${user.avatar}">
                    <br/><br/>
                    <font color="blue" size="2">&emsp;&emsp;&emsp;&emsp;&emsp;<a href="${pageContext.request.contextPath}/u/uploadPhoto">更换头像</a></font>
                </div>
            </div>
            <div class="main-right-other">
                <p>姓名：${user.name}</p>
                <p>QQ：${user.QQ}</p>
                <p>在学状态：${user.status}</p>
                <p>绑定手机：<c:if test="${user.phone != null}">${user.phone}</c:if>
                    <c:if test="${user.phone == null}">暂未绑定&nbsp;&nbsp;<a href="${pageContext.request.contextPath}/u/phone">绑定手机</a></c:if></p>
                <p>绑定邮箱：<c:if test="${user.email != null}">${user.email}</c:if>
                    <c:if test="${user.email == null}">暂未绑定&nbsp;&nbsp;<a href="${pageContext.request.contextPath}/u/email">绑定邮箱</a></c:if></p>
            </div>
        </div>
    </div>
</main>
<!--footer-->


</body>
</html>