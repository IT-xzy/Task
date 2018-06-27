<%--
  Created by IntelliJ IDEA.
  User: thinkpad
  Date: 2018/5/7
  Time: 22:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>错误</title>
</head>
<body>
<p style="text-align: center"> <font size="6" color="red"><strong>输入的用户名或者密码格式错误，请确认后按照要求格式重新输入</strong> </font></p>
<form method="get" action="${pageContext.request.contextPath}/register">
    <p style="text-align:center"><input type="submit" value="返回注册页面"/><p/></form>
</body>
</html>
