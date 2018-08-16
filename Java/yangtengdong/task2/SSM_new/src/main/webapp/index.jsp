<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <title>Index.jsp</title>
<body>

<h2>欢迎登陆</h2>

<form action="login" method="post">
    用户名:<input type="text" name="userName"/><br>
    密&nbsp;&nbsp;码:<input type="password" name="password"/><br>
    <input type="submit" value="登录"/>
</form>

</body>
</html>
