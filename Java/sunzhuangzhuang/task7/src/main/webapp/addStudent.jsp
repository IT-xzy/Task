<%@ page import="utils.Token" %>
<%@ page import="utils.CookieUtil" %><%--
  Created by IntelliJ IDEA.
  User: root
  Date: 2018/7/13
  Time: 13:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page pageEncoding="utf-8" contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
</head>
<body>

<div align="center">
    <form action="/telephone">
        <br/>
        <br/>
        <br/>
        <br/>
        <br/>
        <input  name="telephone" placeholder="请输入手机号" maxlength="20"><br>
        <input type="submit" value="获取验证码完成注册">
    </form>
</div>

</body>
</html>
