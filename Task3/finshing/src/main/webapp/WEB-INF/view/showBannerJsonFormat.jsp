<%--
  Created by IntelliJ IDEA.
  User: qyh
  Date: 2018/10/15
  Time: 18:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isErrorPage="true" isELIgnored="false"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<json:object escapeXml="false">
    <json:property name="code" value="${code}"> </json:property>
    <%--键值对，知道key值后，在jsp中获取value值--%>
    <json:property name="message">
        <spring:message code="${code}"/>
    </json:property>
    <%-- <json:property name="message" value="${message}"></json:property>--%>
    <json:array name="data" items="${banner}" var="banner">
        <json:object>
            <json:property name="id" value="${banner.id}"/>
            <json:property name="url" value="${banner.url}"/>
            <json:property name="img" value="${banner.img}"/>
            <json:property name="status" value="${banner.status}"/>
            <json:property name="sort" value="${banner.sort}"/>
            <json:property name="type" value="${banner.type}"/>
        </json:object>
    </json:array>
</json:object>
