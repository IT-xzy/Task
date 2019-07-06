<%@page contentType="text/html; charset=utf-8" pageEncoding="utf-8" isErrorPage="true" %>
<%@ taglib prefix="User" uri="http://www.atg.com/taglibs/User" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<User:object>

<User:property name="code" value="${code}"/>
    <User:property name="message">
        <spring:message code = "${code}"/>
    </User:property>

    <User:array name="lists" var="list" items="${data}">
        <User:object>
            <User:property name="id" value="${list.id}"/>
            <User:property name="name" value="${list.name}"/>
            <User:property name="qq" value="${list.qq}"/>
            <User:property name="phone" value="${list.phone}"/>
        </User:object>
    </User:array>


</User:object>
