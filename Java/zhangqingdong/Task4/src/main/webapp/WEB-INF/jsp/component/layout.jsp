<%--
  Created by IntelliJ IDEA.
  User: summerwaves
  Date: 2017/9/28
  Time: 11:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="tilesx" uri="http://tiles.apache.org/tags-tiles-extras" %>
<html>
<head>
</head>
<body>
    <tiles:insertAttribute name="header" />
    <tiles:insertAttribute name="body" />
    <tiles:insertAttribute name="footer"/>
</body>
</html>
