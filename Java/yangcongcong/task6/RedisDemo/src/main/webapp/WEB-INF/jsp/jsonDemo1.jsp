<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<json:object>
    <json:array name="学员信息" var="user" items="${userList}">
        <json:object>
            <json:property name="id" value="${user.id}"/>
            <json:property name="name" value="${user.name}"/>
            <json:property name="number" value="${user.number}"/>
            <json:property name="qq" value="${user.qq}"/>
            <json:property name="type" value="${user.type}"/>
            <json:property name="university" value="${user.university}"/>
            <json:property name="time" value="${user.time}"/>
            <json:property name="link" value="${user.daily_link}"/>
            <json:property name="pledge" value="${user.pledge}"/>
            <json:property name="senior" value="${user.senior}"/>
            <json:property name="locality" value="${user.senior}"/>
            <json:property name="locality" value="${user.create_at}"/>
            <json:property name="locality" value="${user.update_at}"/>
        </json:object>
    </json:array>
</json:object>