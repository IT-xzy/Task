<%--
  Created by IntelliJ IDEA.
  User: 老王
  Date: 2019/4/29
  Time: 9:30
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" %>
<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>

<json:object>
    <json:property name="code" value="${code}"/>
    <json:property name="message" value="${message}"/>
    <json:array name="students" var="Student" items="${students}">
        <json:object>
            <json:property name="id" value="${Student.id}"/>
            <json:property name="name" value="${Student.name}"/>
            <json:property name="qq" value="${Student.qq}"/>
            <json:property name="type" value="${Student.type}"/>
            <json:property name="estimatedtime" value="${Student.estimatedtime}"/>
            <json:property name="school" value="${Student.school}"/>
            <json:property name="manner" value="${Student.manner}"/>
            <json:property name="number" value="${Student.number}"/>
            <json:property name="daily" value="${Student.daily}"/>
            <json:property name="wish" value="${Student.wish}"/>
            <json:property name="counselor" value="${Student.counselor}"/>
            <json:property name="source" value="${Student.source}"/>
            <json:property name="create_at" value="${Student.create_at}"/>
            <json:property name="update_at" value="${Student.update_at}"/>
        </json:object>
    </json:array>
</json:object>
