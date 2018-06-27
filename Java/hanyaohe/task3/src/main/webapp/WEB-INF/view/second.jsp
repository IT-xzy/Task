<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/4/7/007
  Time: 14:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/test/third" method="get">
    <input type="text" value="${student.id}">
    <input type="text" value="${student.name}">
    <input type="text" value="${student.qq}">
    <input type="text" value="${student.major}">
</form>


</body>
</html>
