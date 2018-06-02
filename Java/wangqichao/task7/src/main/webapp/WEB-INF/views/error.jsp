<%--
  Created by IntelliJ IDEA.
  User: thinkpad
  Date: 2018/5/23
  Time: 12:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>错误页面</title>
</head>
<body>
<p style="text-align: center"> <font size="6" color="red"><strong>${message}</strong> </font></p>
<p align="center"><button style="text-align:center"><a href="${pageContext.request.contextPath}/login.jsp">返回修真院首页</a></button></p>
<form method="get" action="${pageContext.request.contextPath}/u/goPassword">
    <p style="text-align:center"><input type="submit" value="返回修改页面"/><p/></form>
<form method="get" action="${pageContext.request.contextPath}/register">
    <p style="text-align:center"><input type="submit" value="返回注册页面"/><p/></form>
<form method="get" action="${pageContext.request.contextPath}/u/showInfo">
    <p style="text-align:center"><input type="submit" value="返回个人信息页"/><p/></form>
</body>
</html>
