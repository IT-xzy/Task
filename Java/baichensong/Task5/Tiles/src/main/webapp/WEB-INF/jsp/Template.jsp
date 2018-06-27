<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Home</title>
    <link href="${pageContext.request.contextPath}/conf/bootstrap.min.css" rel="stylesheet" type="text/css">
    <link href="${pageContext.request.contextPath}../bootstrap-3.3.5-dist/css/bootstrap.css">
    <link href="${pageContext.request.contextPath}/conf/Untitled-3.css" rel="stylesheet" type="text/css">
    <link href="${pageContext.request.contextPath}/conf/Untitled-1base.css" rel="stylesheet" type="text/css">


</head>
<body>

<tiles:insertAttribute name="header"/>

<tiles:insertAttribute name="body"/>
<div class="footer">
    <tiles:insertAttribute name="footer"/>
</div>
</body>
<script src="${pageContext.request.contextPath}/conf/jquery.min.js"></script>
<script  src="${pageContext.request.contextPath}/conf/bootstrap.min.js"></script>
</html>
