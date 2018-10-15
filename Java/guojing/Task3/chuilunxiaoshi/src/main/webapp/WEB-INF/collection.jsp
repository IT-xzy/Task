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

    <json:property name="allPage" value="${allPage}"/>

    <json:array name="data" items="${data}" var="collection">
        <json:object>
            <json:property name="id" value="${collection.id}"/>
            <json:property name="name" value="${collection.name}"/>
            <json:property name="status" value="${collection.status}"/>
            <json:property name="createAt" value="${collection.createAt}"/>
            <json:property name="updateAt" value="${collection.updateAt}"/>
            <json:property name="createBy" value="${collection.createBy}"/>
            <json:property name="updateBy" value="${collection.updateBy}"/>
        </json:object>
    </json:array>


</json:object>
