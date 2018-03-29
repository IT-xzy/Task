<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 16/8/2017
  Time: 下午 12:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:if test="${i == 1}">
    <script language='javaScript' src="/a/home"> alert('登陆成功');</script>
</c:if>
<c:if test="${i == 0}">
    <script language='javaScript' src="/a/login"> alert('无此账户');</script>
</c:if>
<c:if test="${i == -1}">
    <script language='javaScript' src="/a/login"> alert('密码错误');</script>
</c:if>
<c:if test="${i == -2}">
    <script language='javaScript' src="/a/login"> alert("用户名和密码不能为空");</script>
</c:if>
</body>
</html>
