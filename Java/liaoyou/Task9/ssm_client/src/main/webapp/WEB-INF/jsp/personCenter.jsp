<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="false" isELIgnored="false" %>

<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>personCenter</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap.min.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/nav.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/personCenter.css">
</head>
<body>

<nav class="navbar navbar-default">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="${pageContext.request.contextPath}/home">HOME</a>
        </div>
        <div class="navbar-header navbar-right">
            <a class="navbar-brand" href="${pageContext.request.contextPath}/u/register">REGISTER</a>
        </div>
    </div>
</nav>

<div align="center">
    <h2 class="form-head">个人中心</h2><br><br>
</div>

<div class="container">
    <!--row代表行内容-->
    <div class="row">
        <!--此div占四列-->
        <div class="col-md-4">
            <div class="user_div">
                <img src="${student5.image}" class="round_icon">
            </div>
            <br>
            <div class="user_div">
                <label>用户ID：</label>
                <span>${student5.id}</span>
            </div>
            <div class="user_div">
                <label>用户名：</label>
                <span>${student5.name}</span>
            </div>
            <div class="user_div">
                <label>手机号：</label>
                <span>${student5.phone}</span>
            </div>
            <div class="user_div">
                <label>邮箱：</label>
                <span>${student5.email}</span>
            </div>
        </div>

        <div class="col-md-2"></div>

        <div class="col-md-6">
            <form action="${pageContext.request.contextPath}/u/imageSubmit2T" method="post" enctype="multipart/form-data" class="img_form" >
                <div class="form-group">
                    <%--<label for="ImageFile" class="btn btn-default">上传头像</label>--%>
                    <input type="file" name="ImageFile" id="ImageFile" accept="image/*">
                    <input type="hidden" name="id" value="${student5.id}">
                </div>
                <button type="submit" class="btn btn-info">提交</button>
            </form>
        </div>
    </div>
</div>

<!--jQuery(Bootstrap的JavaScript插件需要引入jQuery)-->
<script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<!--包括所以已编译的插件-->
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
</body>
</html>