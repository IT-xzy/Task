<%@ page import="org.apache.log4j.Logger" %><%--
  Created by IntelliJ IDEA.
  User: qyh
  Date: 2018/10/15
  Time: 17:00
  To change this template use File | Settings | File Templates.
--%>
<%--><%--下边为json-taglib的头，必须有才能使用json-taglib标签isELIgnored解决el表达式不显示的问题--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isErrorPage="true" isELIgnored="false"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<% Logger logger = Logger.getLogger(Object.class);%>
<%  long start = System.currentTimeMillis();%>
<json:object escapeXml="false">
    <json:property name="code" value="${code}"> </json:property>
    <%--键值对，知道key值后，在jsp中获取value值--%>
    <json:property name="message">
        <spring:message code="${code}"/>
    </json:property>
    <%-- <json:property name="message" value="${message}"></json:property>--%>
    <json:array name="data" items="${art}" var="art">
        <json:object>
            <json:property name="id" value="${art.id}"/>
            <json:property name="name" value="${art.name}"/>
            <json:property name="author" value="${art.author}"/>
            <json:property name="state" value="${art.state}"/>
            <json:property name="firstId" value="${art.firstId}"/>
            <json:property name="secondId" value="${art.secondId}"/>
            <json:property name="isLink" value="${art.isLink}"/>
        </json:object>
    </json:array>
</json:object>
<%  long end = System.currentTimeMillis();%>
<% logger.info("model通过jsp转json耗时：" + (end-start)+"毫秒");%>


