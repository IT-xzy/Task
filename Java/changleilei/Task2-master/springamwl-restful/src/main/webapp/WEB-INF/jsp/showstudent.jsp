<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>丹徒</title>
</head>
<body>
<h1>
    <json:object escapeXml="false">
        <json:property name="id" value="${student.id}"/>
        <json:property name="name" value="${student.name}"/>
        <json:property name="sex" value="${student.sex}"/>
        <json:property name="qq" value="${student.qq}"/>
        <json:property name="graduate" value="${student.graduate}"/>
        <json:property name="number" value="${student.number}"/>
        <json:property name="autograph" value="${student.autograph}"/>
        <json:property name="createtime" value="${student.createtime}"/>
        <json:property name="updatetime" value="${student.updatetime}"/>
    </json:object>
</body>
</html>
