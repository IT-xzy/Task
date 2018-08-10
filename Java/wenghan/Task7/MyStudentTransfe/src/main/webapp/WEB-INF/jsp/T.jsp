
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<html>
<head>
    <tiles:insertAttribute name="head" ignore="true"/>
    <title><tiles:insertAttribute name="title" ignore="true"/></title>
</head>
<body>
    <tiles:insertAttribute name="body1" ignore="true"/>
    <tiles:insertAttribute name="body2" ignore="true"/>
    <tiles:insertAttribute name="body3" ignore="true"/>
    <tiles:insertAttribute name="body4" ignore="true"/>
    <tiles:insertAttribute name="body5" ignore="true"/>
    <tiles:insertAttribute name="tail" ignore="true"/>
    <tiles:insertAttribute name="script" ignore="true"/>
</body>
</html>
