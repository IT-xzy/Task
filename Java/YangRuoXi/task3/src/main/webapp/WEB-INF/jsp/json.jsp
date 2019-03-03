<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/11/20
  Time: 11:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<json:object>
    <json:property name="code" value="${code}"/>
    <json:property name="message" value="${message}"/>
    <json:array name="userList" var="users" items="${userList}">
        <json:object>
            <json:property name="userId" value="${users.userId}"/>
            <json:property name="userName" value="${users.userName}"/>
            <json:property name="userPassword" value="${users.password}"/>
            <json:property name="userRole" value="${users.userRole}"/>
            <json:property name="create_time" value="${users.createTime}"/>
            <json:property name="create_id" value="${users.createId}"/>
            <json:property name="privileges" value="${users.privileges}"/>
        </json:object>
    </json:array>

    <json:array name="user" var="user">
        <json:object>
            <json:property name="userId" value="${user.userId}"/>
            <json:property name="userName" value="${user.userName}"/>
            <json:property name="userPassword" value="${user.password}"/>
            <json:property name="userRole" value="${user.userRole}"/>
            <json:property name="create_time" value="${user.createTime}"/>
            <json:property name="create_id" value="${user.createId}"/>
            <json:property name="privileges" value="${user.privileges}"/>
        </json:object>
    </json:array>
</json:object>
</body>
</html>
