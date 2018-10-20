<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" import="java.util.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>UWillNeverWalkAlone</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link  rel="stylesheet" type="text/css" href="../scss/headerfooter.css">
    <link  rel="stylesheet" type="text/css" href="../module/carousel/carousel.css">
    <link  rel="stylesheet" type="text/css" href="../scss/grid.css">
    <link  rel="stylesheet" type="text/css" href="../scss/css14.css">
</head>
<body>
<div id="header">
    <tiles:insertAttribute name="header"/>
</div>
<div id="body">
    <tiles:insertAttribute name="body"/>
</div>
<div id="footer">
    <tiles:insertAttribute name="footer"/>
</div>
</body>
</html>