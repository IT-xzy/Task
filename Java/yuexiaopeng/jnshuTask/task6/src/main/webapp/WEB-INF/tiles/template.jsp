<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles-extras" prefix="tilesx" %>
<head>
    <meta charset="UTF-8">
    <meta name="viewport", content="device-width,initial-scale=1.0, manimun-scale=1.0,user-scaleble=no" />
    <link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
    <script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <%--<title>spring task4</title>--%>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/js/style.css" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/js/job.css" />
       <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/js/company.css" />
<head>
    <title>
    <tiles:insertAttribute name="title"/>
    </title>
</head>


<header>
    <tiles:insertAttribute name="header" />
</header>

<main>
    <tiles:insertAttribute name="body" />
</main>

<footer>
    <tiles:insertAttribute name="footer"/>
</footer>







