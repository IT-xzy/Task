<%@ page contentType="text/html;charset=UTF-8"  %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%--<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>--%>
<%@ page isELIgnored="false" isErrorPage="true" %>
<%--上边为json-taglib的头，必须有才能使用json-taglib标签--%>

<%--escapeXML意思是是否过滤xml文档，为false时将其中的xml、html解析出来--%>
<json:object escapeXml="false">
    <json:property name="code" value="${code}"/>
    <%--这个很有意思，可以记一下，键值对，知道key值后，在jsp中获取value值--%>
    <json:property name="message" >
        <spring:message code="${code}"/>
    </json:property>

    <json:property name="page" value="${page}"/>

    <json:property name="total" value="${total}"/>

    <json:array name="data" items="${data}" var="classify">
        <json:object>
            <json:property name="id" value="${classify.id}"/>
            <json:property name="name" value="${classify.name}"/>
            <json:property name="collectionId" value="${classify.collectionId}"/>
            <json:property name="status" value="${classify.status}"/>
            <json:property name="createAt" value="${classify.createAt}"/>
            <json:property name="updateAt" value="${classify.updateAt}"/>
            <json:property name="createBy" value="${classify.createBy}"/>
            <json:property name="updateBy" value="${classify.updateBy}"/>
            <json:property name="collectionName" value="${classify.collectionName}"/>
        </json:object>
    </json:array>




</json:object>
