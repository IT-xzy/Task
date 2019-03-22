<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="t"%>
<%@ page session="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>无标题文档</title>
    <link href="${pageContext.request.contextPath}/static/css/bootstrap.min.css" rel="stylesheet" type="text/css">
    <link href="${pageContext.request.contextPath}/static/css/Untitled-3.css" rel="stylesheet" type="text/css">
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/static/css/Untitled-1base.css" rel="stylesheet" type="text/css">
    <link href="${pageContext.request.contextPath}/static/css/t11.css" rel="stylesheet" type="text/css">
    <link href="${pageContext.request.contextPath}/static/css/base.css" rel="stylesheet" type="text/css">


</head>
<body >
<div id="header">
    <t:insertAttribute name="header"/>
</div>
<div id="body">
    <t:insertAttribute name="body"/>
</div>
<div id="footer">
    <t:insertAttribute name="footer"/>
</div>
</body>
<script src="${pageContext.request.contextPath}/static/js/jquery.min.js"></script>
<script  src=" ${pageContext.request.contextPath}/static/js/bootstrap.min.js"></script>
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</html>
