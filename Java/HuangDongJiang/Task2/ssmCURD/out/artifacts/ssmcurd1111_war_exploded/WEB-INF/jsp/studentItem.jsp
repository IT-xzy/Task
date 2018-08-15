<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>
<html>
<body>
<h2>查询结果</h2>
<json:object>
    <json:property name="code" value="${code}"/>
    <json:property name="message" value="${message}"/>
    <%--Student部分信息--%>
    <json:property name="id" value="${student1.id}"/>
    <json:property name="name" value="${student1.name}"/>
    <json:property name="schllo" value="${student1.school}"/>
    <json:property name="qq" value="${student1.qq}"/>
    <json:property name="ocupation" value="${student1.sex}"/>
    <json:property name="admission_time" value="${student1.admission_time}"/>
    <json:property name="daily_link" value="${student1.daily_link}"/>
    <json:property name="flag" value="${student1.flag}"/>
    <json:property name="brother" value="${student1.brother}"/>
    <json:property name="where_know" value="${student1.where_know}"/>
    <%--列表部分--%>
    <json:array name="items" items="${studentList}" var="item">
        <json:object>
            <json:property name="id" value="${item.id}"/>
            <json:property name="name" value="${item.name}"/>
            <json:property name="schllo" value="${item.school}"/>
            <json:property name="qq" value="${item.qq}"/>
            <json:property name="ocupation" value="${item.ocupation}"/>
            <json:property name="admission_time" value="${item.admission_time}"/>
            <json:property name="daily_link" value="${item.daily_link}"/>
            <json:property name="flag" value="${item.flag}"/>
            <json:property name="brother" value="${item.brother}"/>
            <json:property name="where_know" value="${item.where_know}"/>
        </json:object>
    </json:array>
</json:object>
</body>
</html>
