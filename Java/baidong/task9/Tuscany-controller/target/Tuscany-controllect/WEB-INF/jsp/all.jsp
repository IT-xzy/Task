
<%@page contentType="text/html; charset=utf-8" pageEncoding="utf-8" isErrorPage="true" %>
<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<json:object>
    <json:property name="code" value="${code}"/>
    <json:property name="message">
        <spring:message code="${code}"/>
    </json:property>

    <json:array name="user" var="User" items="${data}">
        <json:object>
            <json:property name="id" value="${User.id}"/>
            <json:property name="name" value="${User.name}"/>
            <json:property name="career" value="${User.career}"/>
            <json:property name="email" value="${User.email}"/>
            <json:property name="createtime" value="${User.createtime}"/>

        </json:object>
    </json:array>
</json:object>
