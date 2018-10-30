<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1,minimum-scale=1.0,  maximum-scale=1">
    <link rel="stylesheet" type="text/css" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link type="text/css" rel="stylesheet" href="../../static/css/task9-3.css">
    <title>注册</title>
</head>
<body>
<div style="text-align: center;height: auto;">
    <h2>欢迎注册</h2>
    ${message}<br/>
    <form action="/registerResult" method="post">
        请输入账号：<input type="text" name="userName"><br/>
        请输入密码：<input type="password" name="password"><br/>
        <input type="submit" value="注册">
    </form>
    <span style="color: red; font-size: x-small;"></span>
</div>
</body>
</html>
