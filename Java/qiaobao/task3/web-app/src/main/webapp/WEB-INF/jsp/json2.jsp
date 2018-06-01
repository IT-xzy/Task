<%--
  Created by IntelliJ IDEA.
  User: qiaobao
  Date: 2018/5/21
  Time: 2:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="json"  uri="http://www.atg.com/taglibs/json" %>

<json:object>
    <json:array name="students" items="${students}" var="student">
        <json:property name="id" value="${student.id}"/>
        <json:property name="name" value="${student.name}"/>
        <json:property name="type" value="${student.type}"/>
        <json:property name="qq" value="${student.qq}"/>
        <json:property name="entorTime" value="${student.entorTime}"/>
        <json:property name="graduateSchool" value="${student.graduateSchool}"/>
        <json:property name="dailyLink" value="${student.dailyLink}"/>
        <json:property name="netId" value="${student.netId}"/>
        <json:property name="senior" value="${student.senior}"/>
        <json:property name="wish" value="${student.wish}"/>
    </json:array>
</json:object>

