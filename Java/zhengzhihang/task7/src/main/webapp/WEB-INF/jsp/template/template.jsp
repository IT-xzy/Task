<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles-extras" prefix="tilesx" %>
<!DOCTYPE html>
<html>
<head>
    <tiles:insertAttribute name="title" ignore="true"/>
</head>
<body>
    <tiles:insertAttribute name="head" ignore="ture" />
    <tiles:insertAttribute name="body"  ignore="true"/>
    <tiles:insertAttribute name="foot"  ignore="true"/>

</body>
</html>
