<%--
  Created by IntelliJ IDEA.
  User: Shinelon
  Date: 2019/3/30
  Time: 6:43
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ page language="java" pageEncoding="UTF-8" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title><tiles:insertAttribute name="title" ignore="true"/></title>
</head>
<body>
    <tiles:insertAttribute name="head" />
    <tiles:insertAttribute name="body" />
    <tiles:insertAttribute name="foot" />
</body>
</html>
