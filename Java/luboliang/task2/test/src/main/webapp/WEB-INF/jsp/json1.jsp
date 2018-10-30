<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>
<%@page contentType="text/html/; charset=utf-8" pageEncoding="utf-8" isErrorPage="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<json:object escapeXml="false">


    <json:property name="code" value="${code}"/>
<json:property name="message">
        <spring:message code="${code}"/>
</json:property>
</json:object>