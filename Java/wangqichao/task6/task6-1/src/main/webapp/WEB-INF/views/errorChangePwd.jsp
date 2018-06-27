<%--
  Created by IntelliJ IDEA.
  User: thinkpad
  Date: 2018/5/12
  Time: 11:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改出错啦！</title>
</head>
<body>
<p style="text-align: center"> <font size="6" color="red"><strong>${errorMessage}</strong> </font></p>
<form method="get" action="${pageContext.request.contextPath}/goPassword">
    <p style="text-align:center"><input type="submit" value="返回修改页面"/><p/></form>
</body>
</html>
