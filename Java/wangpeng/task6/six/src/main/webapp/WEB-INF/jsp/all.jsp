<%--
  Created by IntelliJ IDEA.
  User: 老王
  Date: 2019/6/1
  Time: 9:43
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" isErrorPage="true" %>
<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<json:object>
<json:property name="code" value="${code}"/>
<json:property name="message">
<spring:message code="${code}"/>
</json:property>

<json:array name="jsons" var="Json" items="${jsons}">
<json:object>
<json:property name="id" value="${Json.id}"/>
<json:property name="name" value="${Json.name}"/>
<json:property name="qq" value="${Json.qq}"/>
</json:object>
</json:array>
</json:object>

