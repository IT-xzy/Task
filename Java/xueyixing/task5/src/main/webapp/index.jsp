<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="title" uri="http://tiles.apache.org/tags-tiles" %>

<html>
<head>
    <title>Hello Word!!</title>
    <link href="${pageContext.request.contextPath }/data/newUser/css/style.css" rel='stylesheet' type='text/css' />
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
    <meta name="keywords" content="Flat Dark Web Login Form Responsive Templates, Iphone Widget Template, Smartphone login forms,Login form, Widget Template, Responsive Templates, a Ipad 404 Templates, Flat Responsive Templates" />
</head>
<body>
<script>$(document).ready(function(c) {
    $('.close').on('click', function(c){
        $('.login-form').fadeOut('slow', function(c){
            $('.login-form').remove();
        });
    });
});
</script>
<h1>欢迎来到刘欢小站！！</h1>
<div class="login-form">
    <form action="${pageContext.request.contextPath }/lock" method="post">
    <div class="close" >
        <a href="${pageContext.request.contextPath }/home">
            <img src="${pageContext.request.contextPath }/data/newUser/images/close.png"/>
        </a>
    </div>
    <div class="head-info">
        <label class="lbl-1"> </label>
        <label class="lbl-2"> </label>
        <label class="lbl-3"> </label>
    </div>
    <div class="clear"> </div>
    <div class="avtar">
        <img src="${pageContext.request.contextPath }/data/newUser/images/avtar.png" />
    </div>
        <input type="text" class="text" placeholder="账号" name="userName">
        <div class="key">
            <input type="password" placeholder="password" name="password"  >
        </div>
        <div class="form-group">
                <a style="color: white" href="${pageContext.request.contextPath }/new">注册账号</a>
        </div>
    <div class="signin" >
        <input type="submit" value="登陆" >
    </div>
    </form>
</div>
<div class="copy-rights">
    <p>Copyright &copy; YixingXue All rights reserved </p>
</div>

<%--<fieldset style="width: 300px;margin: 150px 500px ">
    <legend>登陆</legend>
    <form action="${pageContext.request.contextPath }/lock" method="post">
        <div class="form-group">
            <label for="inputText3" class="col-sm-2 control-label">账号</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="inputText3"  name="userName">
            </div>
        </div>
        <div class="form-group">
            <label for="inputPassword3" class="col-sm-2 control-label">密码</label>
            <div class="col-sm-10">
                <input type="password" class="form-control" id="inputPassword3" name="password">
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <div class="checkbox">
                    <label>
                        <input type="checkbox"> Remember me
                    </label>
                </div>
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <a href="${pageContext.request.contextPath }/new">注册账号</a>
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <a href="${pageContext.request.contextPath }/home">主页</a>
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" class="btn btn-default">提交</button>
            </div>
        </div>
    </form>
</fieldset>--%>
</body>
</html>