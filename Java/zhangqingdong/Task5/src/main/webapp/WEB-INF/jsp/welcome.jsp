<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/10/4
  Time: 15:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="${ctx}/login">登录页面</a><br>
<a href="${ctx}/user">注册页面</a><br>
<a href="${ctx}/u/position">拦截页面</a><br>
<a href="${ctx}/home">不拦截页面</a>
</body>
</html>
