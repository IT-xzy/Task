<%--
  Created by IntelliJ IDEA.
  User: root
  Date: 2018/6/21
  Time: 21:16
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<json:array items="${list}" var="user">
    <json:object>
        <json:property name="id" value="${user.id}"/>
        <json:property name="name" value="${user.name}"/>
        <json:property name="age" value="${user.age}"/>
        <json:property name="createdate" value="${user.createdate}"/>
        <json:property name="up" value="${user.up}"/>
    </json:object>
</json:array>
</body>
</html>
