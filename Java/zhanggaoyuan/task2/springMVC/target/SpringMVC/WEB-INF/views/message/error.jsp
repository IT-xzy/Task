<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isErrorPage="true"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<head>
    <title>操作失败</title>
</head>
<body>
<c:choose>
    <c:when test="${error==0}">
        <spring:message code="id"/><br>
    </c:when>
    <c:when test="${error==1}">
        <spring:message code="database"/><<br>
    </c:when>
    <c:when test="${error==21}">
        <spring:message code="insertError"/><br>
    </c:when>
    <c:when test="${error==23}">
        <spring:message code="updateError"/><br>
    </c:when>
    <c:otherwise>
        <spring:message code="unknown"/>
    </c:otherwise>
</c:choose>
<a href="/info/paging">进入操作界面</a>
</body>
</html>
