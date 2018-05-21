<%--
  Created by IntelliJ IDEA.
  User: LL
  Date: 2018/4/21
  Time: 16:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="java.util.*"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>注册</title>
</head>
<body>
<h3 align="center">注册界面</h3>
<form action="register" method="post" name="User">
<table align="center">
    <tr>
        <td>账号:</td>
        <td><input type="text" name="name"></td>
        <td>${ERR_name}</td>
    </tr>
    <tr>
        <td>密码:</td>
        <td><input type="text" name="password"></td>
        <td>${ERR_password}</td>
    </tr>
    <tr>
        <td><input type="reset" value="重置"></td>
        <td><input type="submit" value="登陆"></td>
    </tr>
</table>
</form>
</body>
</html>
