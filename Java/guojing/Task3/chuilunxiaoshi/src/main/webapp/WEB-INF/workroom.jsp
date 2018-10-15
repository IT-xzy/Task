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

    <json:array name="data" items="${data}" var="workroom">
        <json:object>
            <json:property name="id" value="${workroom.id}"/>
            <json:property name="type" value="${workroom.type}"/>
            <json:property name="text" value="${workroom.text}"/>
            <json:property name="pictureUrl" value="${workroom.pictureUrl}"/>
            <json:property name="createAt" value="${workroom.createAt}"/>
            <json:property name="updateAt" value="${workroom.updateAt}"/>
            <json:property name="createBy" value="${workroom.createBy}"/>
            <json:property name="updateBy" value="${workroom.updateBy}"/>
        </json:object>
    </json:array>




</json:object>
