<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <title>登录页面</title>
    <link rel="stylesheet" href="static/css/bootstrap.min.css">
    <link rel="stylesheet" href="static/css/app.css">
</head>
<body id="particles-js">
<div class="container">
    <div class="col-md-4 col-md-offset-4">
        <div class="login-wrapper">
            <h1 class="login-title">登录页面</h1>
            <form action="${pageContext.request.contextPath}/login" method="post">
                <div class="form-group has-feedback">
                    <input id="username" type="text" name="username" class="form-control" placeholder="用户">
                    <span class="glyphicon glyphicon-envelope form-control-feedback"></span>
                </div>
                <div class="form-group has-feedback">
                    <input id="password" type="password" name="password" class="form-control" placeholder="密 码">
                    <span class="glyphicon glyphicon-lock form-control-feedback"></span>
                </div>
                <div class="row">
                    <div class="col-xs-12">
                        <button type="submit" class="btn btn-danger btn-block btn-flat">登  录</button>
                    </div>
                </div>
            </form>
            <br>
            <p class="text-right"><a href="${pageContext.request.contextPath }/registers" class="text-center">注册账号</a></p>
        </div>
    </div>
</div>

</body>
<script src="static/js/jquery.min.js"></script>
<script src="static/js/bootstrap.min.js"></script>
<script type="text/javascript" src="static/js/particles.js"></script>
<script src="static/js/demo.js"></script>