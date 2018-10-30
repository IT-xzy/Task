<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@page contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>



<json:object escapeXml="false">
    <json:array name="student" items="${students}" var="student" >
        <json:object>
            <json:property name="name" value="${student.name}"/>
            <json:property name="qq" value="${student.qq}"/>
        </json:object>
    </json:array>

    <json:property name="code" value="${code}"/>
    <json:property name="message">
        <spring:message code="${code}"/>
    </json:property>
        </json:object>