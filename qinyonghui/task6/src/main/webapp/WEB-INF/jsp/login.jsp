<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/9/11
  Time: 22:47
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" isErrorPage="true" isELIgnored="false"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="date" uri="/tags" %>
<html>
<head>
    <title>登陆页面</title>
</head>
<body>

<div style="text-align:center">
<form action="login" method="POST">
    <input  type="hidden" id = "id" >
    用户名:  <input type="text" name = "username" ><p>
    密  码:  <input type="password" name = "password" ><p>
    <input type="submit" value="登录">
</form>
    <a href="/task6/register" class="btn">注册</a>
</div>
</body>
<html>
