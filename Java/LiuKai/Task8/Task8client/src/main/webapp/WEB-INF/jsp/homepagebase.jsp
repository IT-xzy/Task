<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%--
  Created by IntelliJ IDEA.
  User: Liu Kai
  Date: 2018/8/2
  Time: 18:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>无标题文档</title>
</head>
<body>
<div><tiles:insertAttribute name="header"/></div>
<div><tiles:insertAttribute name="body"/></div>
<div><tiles:insertAttribute name="footer"/></div>
</body>

</html>
