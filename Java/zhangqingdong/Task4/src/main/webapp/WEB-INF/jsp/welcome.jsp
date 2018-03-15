<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: summerwaves
  Date: 2017/9/19
  Time: 19:23
  To change this template use File | Settings | File Templates.
--%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>欢迎页面</title>
</head>
<body>
<a href="${ctx}/tiles">Tiles</a><br>
<a href="${ctx}/t10">t10页面动态化</a><br>
<a href="${ctx}/t11">t11页面动态化</a><br>
</body>
</html>
