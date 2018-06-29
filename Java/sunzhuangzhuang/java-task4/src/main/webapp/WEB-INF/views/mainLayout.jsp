<%--
  Created by IntelliJ IDEA.
  User: root
  Date: 2018/6/26
  Time: 11:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles-extras" prefix="tilesx" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<div>
    <tiles:insertAttribute name="a" />
    <tiles:insertAttribute name="c"/>
    <tiles:insertAttribute name="b" />
</div>
</body>
</html>
