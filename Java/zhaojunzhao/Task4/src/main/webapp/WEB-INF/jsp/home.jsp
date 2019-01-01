<%@ include file="../include/include.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" isErrorPage="true" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>无标题文档</title>
    <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet" type="text/css">
    <link href="${pageContext.request.contextPath}/css/Untitled-3.css" rel="stylesheet" type="text/css">
    <link href="${pageContext.request.contextPath}/css/base.css" rel="stylesheet" type="text/css">
    <link href="${pageContext.request.contextPath}/css/t11.css" rel="stylesheet" type="text/css">
</head>
<body>
    <tiles:insertAttribute name="header" />
    <tiles:insertAttribute name="body"/>
    <tiles:insertAttribute name="footer" />
</body>
<script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<script  src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
</html>


