<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isErrorPage="true"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>操作结果</title>
</head>
<body>
<c:if test="${rs==1}"><c:out value="注册成功，请返回首页登录"/></c:if>
<c:if test="${rs==0}"><c:out value="注册失败"/></c:if>
<a href="/home">返回首页</a>
</body>
</html>