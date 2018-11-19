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
    <form action="http://localhost:8080/task9_Web/registration" method="post">
        姓名：<label>
        <input type="text" name="userName"/>
    </label><br/>
        年龄：<label>
        <input type="number" name="age"/>
    </label><br/>
        账号：<label>
        <input type="text" name="adminCode"/>
    </label><br/>
        密码：<label>
        <input type="password" name="password"/>
    </label><br/>
        手机号：<label>
        <input type="text" name="telephone"/>
    </label><br/>
        邮箱：<label>
        <input type="text" name="emailaccount"/>
    </label><br/>
        <input type="submit" value="注册">
    </form>
    已注册，请<a href="logging">登录</a>
</div>
<!--footer-->
</body>
</html>