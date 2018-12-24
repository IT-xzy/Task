<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isErrorPage="true"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>操作结果</title>
</head>
<body>
<c:if test="${rs==1}"><c:out value="删除成功，请返回列表"/></c:if>
<c:if test="${rs==0}"><c:out value="删除失败"/></c:if>

<c:if test="${rs1==1}"><c:out value="新增成功，请返回列表"/></c:if>
<c:if test="${rs1==0}"><c:out value="删除失败"/></c:if>

<c:if test="${rs2==1}"><c:out value="更新成功，请返回列表"/></c:if>
<c:if test="${rs2==0}"><c:out value="更新失败"/></c:if>

<a href="/u/list">返回列表</a>
</body>
</html>