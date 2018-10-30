<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isErrorPage="true"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>操作成功</title>
</head>
<body>
<c:choose>
    <c:when test="${message==11}">
        <spring:message code="insert"/><br>
    </c:when>
    <c:when test="${message==12}">
        <spring:message code="delect"/><<br>
    </c:when>
    <c:when test="${message==13}">
        <spring:message code="update"/><<br>
    </c:when><c:when test="${message==14}">
    <spring:message code="select"/><<br>
</c:when>
    <c:otherwise>
        <spring:message code="unknown"/>
    </c:otherwise>
</c:choose>
<a href="/info/paging">返回操作界面</a>
</body>
</html>
