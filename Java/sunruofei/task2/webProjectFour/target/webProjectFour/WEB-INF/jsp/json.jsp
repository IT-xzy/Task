<%--
  Created by IntelliJ IDEA.
  User: 孙若飞
  Date: 2019/1/16
  Time: 16:23
  To change this template use File | Settings | File Templates.
--%>
<%--name是数组的名字,var是对象的名字--%>
<%@page contentType="text/html; charset=utf-8" pageEncoding="utf-8" isErrorPage="true" %>
<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<json:object>
    <json:property name="code" value="${code}"/>
    <%--在message.properties中,使mrssage等于200和201--%>
    <json:property name="message">
    <spring:message code="${code}"/>
</json:property>
    <%--<json:property name="message" value="${message}"/>--%>
<json:array name="students" var="student" items="${students}">
    <json:object>
        <json:property name="id" value="${student.id}"/>
        <json:property name="name" value="${student.name}"/>
        <json:property name="qq" value="${student.qq}"/>
        <json:property name="type" value="${student.type}"/>
        <json:property name="admission_date" value="${student.admission_date}"/>
        <json:property name="graducate_school" value="${student.graduate_school}"/>
        <json:property name="student_number" value="${student.student_number}"/>
        <json:property name="daily_link" value="${student.daily_link}"/>
        <json:property name="wish" value="${student.wish}"/>
        <json:property name="instructor" value="${student.instructor}"/>
        <json:property name="information_source" value="${student.information_source}"/>
    </json:object>
</json:array>
</json:object>
