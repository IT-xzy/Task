<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>显示信息进行修改</title>
</head>
<body align="center">
添加：
<br><form action="/register" method="post" <%--align="center"--%>>
    account:<input type="text" name="account" ><br>
    passowrd:<input type="text" name="password" ><br>
    <input type="submit" value="提交">
</form><br>
<a href="/welcome">返回主页</a>
</body>
</html>
