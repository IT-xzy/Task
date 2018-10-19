<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/7/31
  Time: 20:03
  To change this template use File | Settings | File Templates.
--%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isErrorPage="true" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <link rel="stylesheet" href="css/task5-js.css">
    <link rel="stylesheet" href="css/hover.css">
    <link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script src="js/jquery-3.3.1.js"></script>
    <script src="js/task5.js"></script>
    <script src="lib/angular-ui-router.js"></script>
    <script src="js/app.js"></script>
    <title>Document</title>
    <base action="${pageContext.request.contextPath}/">
</head>
<body>
<main>

<h1>${message}</h1>
    <form action="login" method="post" name="test">
        <p>用户<input name="name" type="text"></p><br/>
        <p>密码<input name="password" type="text"></p>
        <input type="submit" value="登录">
    </form>
</main>
</body>
</html>
