<%--
  Created by IntelliJ IDEA.
  User: Blue
  Date: 2018/1/18
  Time: 19:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="t"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>page</title>
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <link href="css/carousel.css" rel="stylesheet">
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body style="text-align: center;margin: auto;">
<div id="header">
    <t:insertAttribute name="header"/>
</div>
<div id="content">
    <t:insertAttribute name="body"/>
</div>
<div id="footer">
    <t:insertAttribute name="footer"/>
</div>
</body>
</html>