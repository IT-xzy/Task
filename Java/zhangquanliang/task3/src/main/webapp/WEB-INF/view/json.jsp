<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isErrorPage="true"%>
<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>
<json:object>
            <json:property name="code" value="${code}"/>
            <json:property name="message" value="${message}"/>
</json:object>