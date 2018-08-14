<%--
  Created by IntelliJ IDEA.
  User: Liu Kai
  Date: 2018/7/22
  Time: 10:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles-extras" prefix="tilesx" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div>
    <tiles:insertAttribute name="header"/>
    <tiles:insertAttribute name="hppart1"/>
    <tiles:insertAttribute name="hppart2"/>
    <tiles:insertAttribute name="footer"/>
</div>
</body>
</html>
