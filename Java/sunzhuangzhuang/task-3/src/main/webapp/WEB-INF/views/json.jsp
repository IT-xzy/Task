<%--
  Created by IntelliJ IDEA.
  User: root
  Date: 2018/6/21
  Time: 19:35
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>
<%@ page pageEncoding="utf-8" contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<json:object>
    <json:property name="id" value="${users.id}"/>
    <json:property name="name" value="${users.name}"/>
    <json:property name="age" value="${users.age}"/>
    <json:property name="createdate" value="${users.createdate}"/>
    <json:property name="up" value="${users.up}"/>
</json:object>
</body>
</html>
