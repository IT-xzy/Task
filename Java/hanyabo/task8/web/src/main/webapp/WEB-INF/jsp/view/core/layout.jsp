<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport"
          content="width=device-width, initial-scale=1.0, maximum-scale=1.0">

    <title><tiles:insertAttribute name="title" ignore="true" /></title>

    <tiles:insertAttribute name="cssresources" />

</head>
<body class="sticky-header">

<%--<div id="headerLayout">--%>
    <tiles:insertAttribute name="header" />
<%--</div>--%>
<%--<div id="middleLayout">--%>
    <%--<div id="menuLayout">--%>
        <tiles:insertAttribute name="menu" />
    <%--</div>--%>
    <%--<div id="bodyReal">--%>
        <tiles:insertAttribute name="body" />
    <%--</div>--%>
<%--</div>--%>
<%--<div id="footerLayout">--%>
    <tiles:insertAttribute name="footer" />
<%--</div>--%>

</body>

<tiles:insertAttribute name="jsresources" />
</html>
