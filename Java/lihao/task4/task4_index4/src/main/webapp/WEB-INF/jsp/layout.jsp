<%@ page contentType="text/html;charset=UTF-8" language="java"
         pageEncoding="UTF-8" import="java.util.*" %>

<%@ include file="../includes/includes.jsp" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>技能树首页</title>
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
    <%--<script src="https://cdn.bootcss.com/jquery/3.3.1/jquery.min.js"></script>--%>
    <%--<script src="https://cdn.bootcss.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>--%>

    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/base.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/head-foot.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/main-1.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/main-2.css">

</head>

<body>
    <tiles:insertAttribute name="header" />
    <tiles:insertAttribute name="main" />
    <tiles:insertAttribute name="profession" />
    <tiles:insertAttribute name="recommend" />
    <tiles:insertAttribute name="footer" />
</body>
</html>