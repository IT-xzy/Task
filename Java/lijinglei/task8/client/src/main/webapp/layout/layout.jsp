<%--
  Created by IntelliJ IDEA.
  User: ljl
  Date: 2018/7/30
  Time: 16:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<!DOCTYPE html>
<html>
<head>
    <tiles:insertAttribute name="meta"/>
    <title><tiles:insertAttribute name="title"/></title>
    <tiles:insertAttribute name="script"/>
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
