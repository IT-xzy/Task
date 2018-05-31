<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>
<%--
  Created by IntelliJ IDEA.
  User: Y
  Date: 18/4/4
  Time: 18:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<json:object>
    <json:property name="id" value="${user.id}"/>
    <json:property name="name" value="${user.name}"/>
    <json:property name="number" value="${user.number}"/>
    <json:property name="type" value="${user.type}"/>
    <json:property name="university" value="${user.university}"/>
    <json:property name="pledge" value="${user.pledge}"/>
    <json:property name="link" value="${user.daily_link}"/>
</json:object>