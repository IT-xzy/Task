<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ page language="java" pageEncoding="UTF-8" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <title><tiles:insertAttribute name="title" ignore="true"/></title>
</head>

<bodys>
<tiles:insertAttribute name="head"/>
<tiles:insertAttribute name="body"/>
<tiles:insertAttribute name="foot"/>
</bodys>

</html>