<%@page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <title>注册页面</title>
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8">
</head>
<body>
<form:form name="registration" action="/registration/registerProcess" method="post">
        用户名：<input name="username" type="text" ><br>
        密码：<input name="password" type="text" ><br>
        名：<input name="firstname" type="text" ><br>
        姓：<input  type="text" name="lastname"><br>
        邮箱：<input type="email" name="email"><br>
        地址：<input type="text" name="address"><br>
        电话：<input type="text" name="phone"><br>
    <input type="submit" value="登录">
</form:form>
</body>
</html>