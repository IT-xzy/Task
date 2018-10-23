<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@page contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>


<json:object escapeXml="false">

    <json:property name="code" value="${code}"/>
    <json:property name="message">
        <spring:message code="${code}"/>
    </json:property>
    <json:property name="mxmx" value="mxmx"/>

    <json:object name="student">
        <json:property name="id" value="${date.id}"/>
        <json:property name="name" value="${date.name}"/>
        <json:object name="page">
            <json:property name="currentPage" value="${page.currentPage}"/>
            <json:property name="NextPage" value="${page.nextPage}"/>
        </json:object>
    </json:object>
    <json:property name="message" value="${message}"/>
    <json:property name="code" value="${code}"/>
</json:object>
