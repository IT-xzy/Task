<%--
  Created by IntelliJ IDEA.
  User: qyh
  Date: 2018/9/16
  Time: 17:37
  To change this template use File | Settings | File Templates.
--%>
<%--><%--下边为json-taglib的头，必须有才能使用json-taglib标签isELIgnored解决el表达式不显示的问题--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isErrorPage="true" isELIgnored="false"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<json:object escapeXml="false">
    <json:property name="code" value="${code}"></json:property>
    <%--键值对，知道key值后，在jsp中获取value值--%>
    <json:property name="message">
        <spring:message code="${code}"/>
    </json:property>
    <%-- <json:property name="message" value="${message}"></json:property>--%>
    <json:array name="data" items="${student}" var="student">
        <json:object>
            <json:property name="name" value="${student.name}"/>
            <json:property name="id" value="${student.id}"/>
            <json:property name="qq" value="${student.qq}"/>
        </json:object>
    </json:array>
</json:object>


