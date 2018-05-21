<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: summerwaves
  Date: 2017/9/21
  Time: 20:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<html>
<head>
    <title>json输出数据</title>
</head>
<span>${head}</span>
<body>
<json:object>
    <json:property name="age" value="${student.id}"/>
    <json:property name="sex" value="${student.name}"/>
    <json:property name="name" value="${student.sex}"/>
    <json:property name="name" value="${student.qq}"/>
    <json:property name="name" value="${student.graduate}"/>
    <json:property name="name" value="${student.number}"/>
    <json:property name="name" value="${student.autograph}"/>
    <json:property name="name" value="${student.createtime}"/>
    <json:property name="name" value="${student.updatetime}"/>
    <json:array name="userList">
        <c:forEach items="${studentlist}" var="astudent">
            <json:object>
                <json:property name="age" value="${astudent.id}"/>
                <json:property name="sex" value="${astudent.name}"/>
                <json:property name="name" value="${astudent.sex}"/>
                <json:property name="name" value="${astudent.qq}"/>
                <json:property name="name" value="${astudent.graduate}"/>
                <json:property name="name" value="${astudent.number}"/>
                <json:property name="name" value="${astudent.autograph}"/>
                <json:property name="name" value="${astudent.createtime}"/>
                <json:property name="name" value="${astudent.updatetime}"/>
            </json:object>
        </c:forEach>
    </json:array>
</json:object>
</body>
</html>
