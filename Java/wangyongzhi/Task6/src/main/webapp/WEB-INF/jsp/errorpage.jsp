<!--注意isELIgnored是选择EL表达式是否输出-->
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="java.util.*" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<p style="text-align: center"> <font size="6" color="red"><strong>两次输入的密码有问题或者用户名重复，请确认后重新输入</strong> </font></p>
<form method="get" action="${pageContext.request.contextPath}/register">
    <p style="text-align:center"><input type="submit" value="返回注册页面"/><p/></form>
</body>
</html>
