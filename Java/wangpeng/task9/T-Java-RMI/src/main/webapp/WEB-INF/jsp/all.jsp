<%--
  Created by IntelliJ IDEA.
  User: WP
  Date: 2019/6/19
  Time: 19:19
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html; charset=utf-8" pageEncoding="utf-8" isErrorPage="true" %>
<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<json:object>
    <json:property name="code" value="${code}"/>
    <json:property name="message">
        <spring:message code="${code}"/>
    </json:property>

    <json:array name="student" var="students" items="${data}">
        <json:object>
            <json:property name="id" value="${students.id}"/>
            <json:property name="name" value="${students.name}"/>
            <json:property name="qq" value="${students.qq}"/>
            <json:property name="type" value="${students.type}"/>
            <json:property name="estimatedtime" value="${students.estimatedtime}"/>
            <json:property name="school" value="${students.school}"/>
            <json:property name="manner" value="${students.manner}"/>
            <json:property name="number" value="${students.number}"/>
            <json:property name="daily" value="${students.daily}"/>
            <json:property name="wish" value="${students.wish}"/>
            <json:property name="counselor" value="${students.counselor}"/>
            <json:property name="source" value="${students.source}"/>
            <json:property name="create_at" value="${students.create_at}"/>
            <json:property name="update_at" value="${students.update_at}"/>
        </json:object>
    </json:array>
</json:object>