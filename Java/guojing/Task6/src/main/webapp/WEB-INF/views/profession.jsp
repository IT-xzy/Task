<%@ page contentType="text/html;charset=UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%--<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>--%>
<%@ page isELIgnored="false" isErrorPage="true"%>
<%--上边为json-taglib的头，必须有才能使用json-taglib标签--%>

<%--打印程序中jsp执行时间，最后面还有一行--%>
<% long start=System.currentTimeMillis(); %>
<%--escapeXML意思是是否过滤xml文档，为false时将其中的xml、html解析出来--%>
<json:object escapeXml="false">
    <json:property name="code" value="${code}"/>
    <%--这个很有意思，可以记一下，键值对，知道key值后，在jsp中获取value值--%>
    <json:property name="message" >
    <spring:message code="${code}"/>
    </json:property>

    <json:array name="profession" items="${profession}" var="profession">
        <json:object>
            <json:property name="id" value="${profession.id}"/>
            <json:property name="direction" value="${profession.direction}"/>
            <json:property name="classify" value="${profession.classify}"/>
            <json:property name="duty" value="${profession.duty}"/>
            <json:property name="strip" value="${profession.strip}"/>
            <json:property name="difficultyLevel" value="${profession.difficultyLevel}"/>
            <json:property name="growthCycle" value="${profession.growthCycle}"/>
            <json:property name="scarcityDegree" value="${profession.scarcityDegree}"/>
            <json:property name="firstSalary" value="${profession.firstSalary}"/>
            <json:property name="secondSalary" value="${profession.secondSalary}"/>
            <json:property name="thirdSalary" value="${profession.thirdSalary}"/>
            <json:property name="basicKnowledge" value="${profession.basicKnowledge}"/>
            <json:property name="engineer" value="${profession.engineer}"/>
            <json:property name="engineerIntro" value="${profession.engineerIntro}"/>
            <json:property name="createAt" value="${profession.createAt}"/>
            <json:property name="updateAt" value="${profession.updateAt}"/>
            <json:property name="createBy" value="${profession.createBy}"/>
            <json:property name="updateBy" value="${profession.updateBy}"/>
        </json:object>
    </json:array>


</json:object>
<%=System.currentTimeMillis()-start%>