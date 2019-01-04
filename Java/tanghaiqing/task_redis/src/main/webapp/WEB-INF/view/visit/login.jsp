<%@ page pageEncoding="UTF-8" isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta content="width=device-width, initial-scale=1.0" name="viewport">
</head>
<body>
<div>
    <form action="" method="post">
        账号：<label>
        <input type="text" name="adminCode"/>
    </label><br/>
        密码：<label>
        <input type="password" name="password"/>
    </label><br/>
        <input type="submit" value="登录"/><a href="registration">注册</a>
    </form>
</div>
<!--footer-->
</body>
</html>