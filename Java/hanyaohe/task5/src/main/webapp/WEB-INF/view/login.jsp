<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>

<%--<html>--%>
<%--<head>--%>
    <%--<title>添加</title>--%>
<%--</head>--%>
<%--<body style="text-align: center">--%>
<%--<h2 style="text-align: center">登录</h2>--%>
<%--<form action="${pageContext.request.contextPath}/login" method="post">--%>
    <%--<br>用户 <input type="text" name="user" >--%>
    <%--<br>密码 <input type="text" name="pass" >--%>
    <%--<input type="submit" value="登录">--%>
<%--</form>--%>

<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<html>
<head>
    <title>登陆页面</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/login" method="post">
    <br>用户：<input type=“text” name="user" > <br>
    <br>密码：<input type=“text” name="pass" > <br>
    <br>保存时间<select name="savetime">
    <option value="7">一  周</option>
    <option value="30">一个月</option>
</select><br>
    <input type="submit" value="登陆">
</form>
</body>
</html>



