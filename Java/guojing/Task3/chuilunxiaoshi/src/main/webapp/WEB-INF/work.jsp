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

    <json:array name="data" items="${data}" var="work">
        <json:object>
            <json:property name="id" value="${work.id}"/>
            <json:property name="name" value="${work.name}"/>
            <json:property name="classifyId" value="${work.classifyId}"/>
            <json:property name="status" value="${work.status}"/>
            <json:property name="introduction" value="${work.introduction}"/>
            <json:property name="thumbnailUrl" value="${work.thumbnailUrl}"/>
            <json:property name="videoUrl" value="${work.videoUrl}"/>
            <json:property name="detailUrl" value="${work.detailUrl}"/>
            <json:property name="article" value="${work.article}"/>
            <json:property name="createAt" value="${work.createAt}"/>
            <json:property name="updateAt" value="${work.updateAt}"/>
            <json:property name="createBy" value="${work.createBy}"/>
            <json:property name="updateBy" value="${work.updateBy}"/>
            <json:property name="classifyName" value="${work.classifyName}"/>
            <json:property name="collectionName" value="${work.collectionName}"/>
        </json:object>
    </json:array>




</json:object>
