<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="java.util.*" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>
<json:object>
    <json:array name="user">
        <c:forEach items="${list}" var="item" varStatus="now">
            <json:object>
                <json:property name="id" value="${item.id}"/>
                <json:property name="name" value="${item.name}"/>
                <json:property name="type" value="${item.type}"/>
            </json:object>
        </c:forEach>
    </json:array>
</json:object>
