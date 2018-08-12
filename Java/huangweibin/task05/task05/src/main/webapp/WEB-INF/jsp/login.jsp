<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/8/2
  Time: 22:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.sql.*" language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<%--<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>--%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>登录界面</title>
</head>
<body>
<center>
    <h1 style="color:#9531ff">登录</h1>
    ${后端通知}
    <%--<form id="indexform" name="indexForm" action="logincheck.jsp" method="post">--%>
    <form id="login" name="login" action="tologin" method="post">
        <table border="0">
            <tr>
                <td>账号：</td>
                <td><input type="text" id="name" name="name"></td>
            </tr>
            <tr>
                <td>密码：</td>
                <td><input type="password" id="password" name="password">
                </td>
            </tr>
        </table>
        <br>
        <input type="submit" value="登录" style="color:#439bbc">
    </form>

    <form id="register1" name="register1" action="register" method="GET">
        <input type="submit" value="注册" style="color:#67bc49">
    </form>
</center>
</body>
</html>