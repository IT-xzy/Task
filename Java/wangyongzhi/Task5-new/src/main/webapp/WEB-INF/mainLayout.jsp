<!--注意isELIgnored是选择EL表达式是否输出-->
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="java.util.*" isELIgnored="false" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles-extras" prefix="tilesx" %>
<%--<%@ taglib uri="/tags" prefix="date"%>--%>
<html>
<head>
    <tiles:insertAttribute name="head"/>
</head>
<header>
    <tiles:insertAttribute name="header"/>
</header>
<body>
<tiles:insertAttribute name="body"/>
</body>
<footer>
    <tiles:insertAttribute name="footer"/>
</footer>
</html>