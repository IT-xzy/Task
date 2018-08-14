<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isErrorPage="true" %>
<%@taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>

<json:object>
    <json:property name="code" value="${result.code}"/>
    <json:property name="message" value="${result.msg}"/>
</json:object>

<json:object>
    <%--<json:property name="a" value="${a}"/>--%>
    <json:property name="id" value="${user.id}"/>
    <json:property name="name" value="${user.name}"/>
    <json:property name="type" value="${user.type}"/>
</json:object>



