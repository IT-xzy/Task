<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/8/14
  Time: 15:14
  To change this template use File | Settings | File Templates.
--%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<json:object name="result">
    <json:property name="message" value="${result.msg}"/>
</json:object>

<json:object name="people">
    <json:property name="name" value="${people.name}"/>
    <json:property name="info" value="${people.info}"/>
    <json:property name="creatTime" value="${people.creatTime}"/>
    <json:property name="type" value="${people.type}"/>
</json:object>

