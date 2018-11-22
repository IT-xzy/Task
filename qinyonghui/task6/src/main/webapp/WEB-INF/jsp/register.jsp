<%--@elvariable id="contextPath" type=""--%>
<%--
  Created by IntelliJ IDEA.
  User: qyh
  Date: 2018/10/24
  Time: 18:43
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" isErrorPage="true" isELIgnored="false"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>注册页面</title>
</head>
<body>
<div style="text-align:center">
<form action="register" method="POST">
    用户名:  <input type="text" id = "name" name = "username" ><p>
    密  码:  <input type="password" id = "passsword" name = "password" ><p>
    <input type="submit" value="注册">
</form>
    <a href="/task6/login" class="btn">登陆</a>
</div>
</body>
</html>



