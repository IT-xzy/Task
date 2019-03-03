<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/11/24
  Time: 20:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<json:object>
    <json:array name="user" var="users" items="${userList}">
        <json:object>
            <json:property name="id" value="${users.id}"/>
            <json:property name="img" value="${users.img}"/>
            <json:property name="position" value="${users.position}"/>
            <json:property name="name" value="${users.name}"/>
            <json:property name="description" value="${users.description}"/>
            <json:property name="salary" value="${users.salary}"/>
        </json:object>
    </json:array>
    <json:array name="profession" var="profe" items="${professionList}">
        <json:object>
            <json:property name="id" value="${profe.id}"/>
            <json:property name="img" value="${profe.img}"/>
            <json:property name="development_directior" value="${profe.developmentDirectior}"/>
            <json:property name="profession_name" value="${profe.professionName}"/>
            <json:property name="description" value="${profe.description}"/>
        </json:object>
    </json:array>

    <json:array name="set" var="set" items="${set}">
        <json:object>
            <json:property name="development_directior" value="${set.developmentDirectior}"/>
        </json:object>
    </json:array>

    <json:array name="login" >
        <json:object>
            <json:property name="name" value="${login.name}"/>
            <json:property name="pwd" value="${login.pwd}"/>
        </json:object>
    </json:array>

</json:object>
</body>
</html>
