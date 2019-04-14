<%--
  Created by IntelliJ IDEA.
  User: 孙若飞
  Date: 2019/3/21
  Time: 22:01
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
            <json:property name="admission_date" value="${students.admission_date}"/>
            <json:property name="graducate_school" value="${students.graduate_school}"/>
            <json:property name="student_number" value="${students.student_number}"/>
            <json:property name="daily_link" value="${students.daily_link}"/>
            <json:property name="wish" value="${students.wish}"/>
            <json:property name="instructor" value="${students.instructor}"/>
            <json:property name="information_source" value="${students.information_source}"/>
        </json:object>
    </json:array>
</json:object>
