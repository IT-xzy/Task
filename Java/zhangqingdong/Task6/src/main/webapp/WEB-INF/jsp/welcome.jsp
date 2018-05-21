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
<a href="${ctx}/jspcache">JSP有缓存</a><br>
<a href="${ctx}/jspnocache">JSP无缓存</a><br>
<a href="${ctx}/jsoncache">Json有缓存</a><br>
<a href="${ctx}/jsonnocache">Json无缓存</a><br>
<a href="${ctx}/student">创建用户接口</a>
</body>
</html>
