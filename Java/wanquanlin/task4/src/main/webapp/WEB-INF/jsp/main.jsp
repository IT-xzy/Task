<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/4/4
  Time: 17:25
  To change this template use File | Settings | File Templates.
--%>
<%--模板文件--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div id="wrapper">
    <div id="tilesBody" style="margin-top: 50px">
        <%--  // 插入属性(其实就是放入参数)，可以不设置值--%>
        <tiles:insertAttribute name="header" ignore="true"/>
        <tiles:insertAttribute name="body" ignore="true"/>
        <tiles:insertAttribute name="footer" ignore="true"/>
    </div>
</div>
</body>
</body>
</html>
