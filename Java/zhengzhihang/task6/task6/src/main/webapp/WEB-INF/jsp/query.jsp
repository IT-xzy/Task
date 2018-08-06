<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/6/11
  Time: 22:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>
    <json:object>
        <json:property name="id" value="${object.id}"/>
        <json:property name="age" value="${object.age}"/>
        <json:property name="name" value="${object.name}"/>
        <json:property name="sex" value="${object.sex}"/>
        <json:property name="school" value="${object.school}"/>
    </json:object>
