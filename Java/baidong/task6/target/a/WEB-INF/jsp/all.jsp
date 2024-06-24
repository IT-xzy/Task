<%@page contentType="text/html; charset=utf-8" pageEncoding="utf-8" isErrorPage="true" %>
<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<json:object>

<json:property name="code" value="${code}"/>
    <json:property name="message">
        <spring:message code = "${code}"/>
    </json:property>

    <json:array name="lists" var="list" items="${data}">
        <json:object>
            <json:property name="id" value="${list.id}"/>
            <json:property name="name" value="${list.name}"/>
            <json:property name="qq" value="${list.qq}"/>
            <json:property name="phone" value="${list.phone}"/>
        </json:object>
    </json:array>


</json:object>
