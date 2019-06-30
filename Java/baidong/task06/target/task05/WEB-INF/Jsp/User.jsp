<%@page contentType="text/html; charset=utf-8" pageEncoding="utf-8" isErrorPage="true" %>
<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<json:object>
     <json:property name="code" value="${code}"/>
    <json:property name = "message" value="${message}"/>
    <json:array name = "user" var="user" items="${user}">


        <json:object>
            <json:property name="id" value="${user.id}"/>
            <json:property name="name" value="${user.name}"/>
            <json:property name="career" value="${user.career}"/>
            <json:property name="email" value="${user.email}"/>
            <json:property name="createTime" value="${user.createTime}"/>

        </json:object>
    </json:array>


</json:object>
