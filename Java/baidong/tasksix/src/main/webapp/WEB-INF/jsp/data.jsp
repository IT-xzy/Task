<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="User" uri="http://www.atg.com/taglibs/User" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<User:object>
    <User:property name="code" value="${code}"/>
    <User:property name="message" >
        <spring:message code="${code}"/>
    </User:property>
</User:object>
