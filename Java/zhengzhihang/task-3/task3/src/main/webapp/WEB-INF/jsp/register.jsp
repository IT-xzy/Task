<%@page pageEncoding="UTF-8" language="java" contentType="text/html; charest=UTF-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <title>注册页</title>
</head>
<body>
<p>欢迎注册，请输入用户名和密码</p>
<form method="post" action="/"><!--这里同名了，要注意 -->
    <p><input type="text" name="name" size="10" placeholder="姓名" style="margin:0; padding:0; width:100px; height:20px" ></p>
    <p><input type="password" name="password" size="10" placeholder="密码" style="margin:0; padding:0; width:100px; height:20px" ></p>
    <p><input type="submit" value="确定">
        <input type="reset" value="取消"></p>
</form>
</body>

<%--<form method="get" action="/student/${s.id}">--%>
    <%--<input type="hidden" name="id" value="${s.id}">--%>
    <%--<input type="hidden" name="name" value="${s.name}">--%>
    <%--<input type="submit" value="查询">--%>
<%--</form>--%>
</html>



