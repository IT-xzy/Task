<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 8/8/2017
  Time: 上午 9:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" import="java.util.*" language="java" %>

<%@ taglib uri="/WEB-INF/tld/datetag.tld" prefix="date"%>

<html>


<head>
    <meta charset="utf-8">
    <title>首页</title>
</head>
<body>
    <tiles:insertDefinition name="task4-head" />
    <tiles:insertDefinition name="task4-left" />



    <tiles:insertDefinition name="task4-footer" />
</body>

<date:date  name="入学时间" value ="${122332123}"  />
</html>
