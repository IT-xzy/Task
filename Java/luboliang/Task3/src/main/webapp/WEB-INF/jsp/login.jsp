<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@page contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>


<json:object escapeXml="false">
    <json:array name="data" items="${data}" var="lonin">
        <json:object>
            <json:property name="qq" value="${lonin.id}"/>
            <json:property name="name" value="${lonin.editor}"/>
        </json:object>
    </json:array>

    <json:property name="code" value="${code}"/>
    <json:property name="message">
        <spring:message code="${code}"/>
    </json:property>
</json:object>
