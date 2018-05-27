<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>
<%@ page contentType="text/html; charset=utf-8"%>
<json:object>
    <json:array name="student" var="student" items="${student}">
    <json:object>
        <json:property name="id" value="${student.id}"/>
        <json:property name="qq" value="${student.qq}"/>
        <json:property name="name" value="${student.name}"/>
        <json:property name="course" value="${student.course}"/>
        <json:property name="school" value="${student.school}"/>
        <json:property name="old_brother" value="${student.old_brother}"/>
        <json:property name="target" value="${student.target}"/>
        <json:property name="url" value="${student.url}"/>
        <json:property name="update_at" value="${student.update_at}"/>
        <json:property name="create_at" value="${student.create_at}"/>
        <json:property name="from_where" value="${student.from_where}"/>

    </json:object>
    </json:array>
</json:object>

