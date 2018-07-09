<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: lucifer
  Date: 2018/3/15
  Time: 1:05
  To change this template use File | Settings | File Templates.
--%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="zh">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>登录</title>
    <link rel="stylesheet" type="text/css" href="${ctx}/static/css/styles.css">
</head>
<body>
<div class="htmleaf-container">
    <div class="wrapper">
        <div class="container">
            <form action="${ctx}/Login" class="form" method="post">
                <input type="text" placeholder="Username" name="user">
                <input type="password" placeholder="Password" name="pass">
                <button type="submit" id="login-button">Login</button>
            </form>
        </div>
    </div>
</div>
<script src="js/jquery-2.1.1.min.js" type="text/javascript"></script>
<script>
    $('#login-button').click(function (event) {
        event.preventDefault();
        $('form').fadeOut(500);
        $('.wrapper').addClass('form-success');
    });
</script>
<div style="text-align:center;margin:50px 0; font:normal 14px/24px 'MicroSoft YaHei';color:#000000">
    <h1 style="font-size: 48px;color: aquamarine;align-content: center;">欢迎来到修真院暴力拆卸机构！</h1>
</div>
</body>
</html>
