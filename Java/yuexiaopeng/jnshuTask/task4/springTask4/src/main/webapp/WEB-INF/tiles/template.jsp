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
    <link rel="stylesheet" type="text/css" href="js/style.css" />
    <link rel="stylesheet" type="text/css" href="js/job.css" />
    <link rel="stylesheet" type="text/css" href="js/company.css" />
    <script src="https://cdn.bootcss.com/canvas-nest.js/1.0.1/canvas-nest.js"></script>
    <canvas id="c_n19" width="420" height="2140" style="position: fixed; top: 0px; left: 0px; z-index: -1; opacity: 0.5;"></canvas>
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







