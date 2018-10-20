<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="false" isELIgnored="false" %>

<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>loginByPhone</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap.min.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/nav.css"/>
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
    <h2 class="form-head">使用手机登录</h2>
</div>

<div class="container">
    <!--row代表行内容-->
    <div class="row">
        <!--此div占四列-->
        <div class="col-md-4"></div>
        <div class="col-md-4">
            <form action="${pageContext.request.contextPath}/u/loginByPhoneSubmit" method="post">
                <div class="form-group">
                    <label for="phone">手机号</label> &nbsp;&nbsp;<span id="phone-tip"></span>
                    <input type="tel" name="phone" id="phone" class="form-control" placeholder="请输入手机号" required maxlength="11" minlength="11">
                </div>
                <div class="form-group">
                    <label for="password">密码</label>
                    <input type="password" name="password" id="password" class="form-control" placeholder="请输入密码" required maxlength="16">
                </div>
                <div class="form-group">
                    <button type="submit" class="btn btn-success" id="btn-submit">登录</button>
                    <button type="reset" class="btn btn-success" id="btn-reset">重置</button>
                    <a class="btn btn-success" href="${pageContext.request.contextPath}/u/login" role="button">用户名登录</a>
                    <a class="btn btn-success" href="${pageContext.request.contextPath}/u/loginByEmail" role="button">使用邮箱登录</a>
                </div>
            </form>
        </div>
        <div class="col-md-4"></div>
    </div>
</div>

<!--jQuery(Bootstrap的JavaScript插件需要引入jQuery)-->
<script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<!--包括所以已编译的插件-->
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
</body>
</html>