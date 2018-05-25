<%--
  Created by IntelliJ IDEA.
  User: thinkpad
  Date: 2018/5/7
  Time: 22:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>错误</title>
</head>
<body>
<p style="text-align: center"> <font size="6" color="red"><strong>注册用户名重复，请确认后重新输入</strong> </font></p>
<form method="get" action="${pageContext.request.contextPath}/register">
    <p style="text-align:center"><input type="submit" value="返回注册页面"/><p/></form>
</body>
</html>
