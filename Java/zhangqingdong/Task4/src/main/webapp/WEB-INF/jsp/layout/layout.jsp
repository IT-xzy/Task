<%--
  Created by IntelliJ IDEA.
  User: summerwaves
  Date: 2017/9/28
  Time: 10:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div id="header">
    <tiles:insertAttribute name="header" />
</div>
<div id="body">
    <tiles:insertAttribute name="body" />
</div>
<div id="menuLeft">
    <tiles:insertAttribute name="menuLeft" />
</div>
<div id="menuRight">
    <tiles:insertAttribute name="menuRight" />
</div>
<div id="footer">
    <tiles:insertAttribute name="footer"/>
</div>
</body>
</html>
