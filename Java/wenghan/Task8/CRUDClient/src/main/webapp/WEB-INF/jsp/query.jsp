<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/6/11
  Time: 22:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>
<html>
<head>
    <title>查询页面</title>
</head>
<body>
<div style="text-align:center">
    <p>JSON:</p>
    <json:object>
        <json:property name="name" value="${object.name}"/>
        <json:property name="id" value="${object.id}"/>
        <json:property name="qq" value="${object.qq}"/>
    </json:object>
</div>
</body>
</html>
