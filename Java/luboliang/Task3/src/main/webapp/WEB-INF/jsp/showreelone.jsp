<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@page contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>


<json:object escapeXml="false">
    <json:array name="data" items="${data}" var="showreelone">
        <json:object>
            <json:property name="id" value="${showreelone.id}"/>
            <json:property name="name" value="${showreelone.showreel_name}"/>
        </json:object>
    </json:array>

    <json:property name="code" value="${code}"/>
    <json:property name="message">
        <spring:message code="${code}"/>
    </json:property>
</json:object>
