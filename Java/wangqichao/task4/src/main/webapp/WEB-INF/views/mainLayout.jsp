<%@ page language="java" contentType="text/html; charset=UTF-8"

         pageEncoding="UTF-8" import="java.util.*" isELIgnored="false"  %>
<%--c标签--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--tiles标签--%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%--<!DOCTYPE html>--%>
<html>
<head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>技能树首页</title>
    <link rel="stylesheet/less" type="text/css" href="../../less/task15.less">
    <script src="../../less.js-2.5.3/dist/less.min.js" type="text/javascript"></script>
    <meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=no">
</head>
<body>
<%--这里的header和footer不能删，否则就只显示中间的body--%>
<header id="header">
    <tiles:insertAttribute name="header" />
</header>

<section id="site-content">
    <tiles:insertAttribute name="body" />
</section>

<footer id="footer">
    <tiles:insertAttribute name="footer1" />
</footer>
</body>

</html>
