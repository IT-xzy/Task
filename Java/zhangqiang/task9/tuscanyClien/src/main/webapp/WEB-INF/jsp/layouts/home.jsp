<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles-extras" prefix="tilesx" %>
<%--核心标签 支持 c:--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--json标签 支持<json:object>--%>
<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>
<%--page 支持EL表达式 ${name}--%>
<%@ page isELIgnored="false" %>
<html lang="en">
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1" charset="UTF-8">
    <title>Title</title>
    <%--<link rel="stylesheet" href="${pageContext.request.contextPath}/stat/../css-reset.css">--%>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/stat/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/stat/css/module.css">
</head>
<body>
<div>
    <tiles:insertAttribute name="header" />
    <tiles:insertAttribute name="body" />
    <tiles:insertAttribute name="footer" />
</div>

<script src="${pageContext.request.contextPath}/stat/css/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/stat/css/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/stat/js/layer/layer.js"></script>
</body>
</html>
