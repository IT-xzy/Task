<%--
  Created by IntelliJ IDEA.
  User: x1c
  Date: 2018/7/5
  Time: 10:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<json:object>
    <json:property name="id" value="${studentList.id}"/>
    <json:property name="name" value="${studentList.name}"/>
    <json:property name="qq" value="${studentList.qq}"/>
    <json:property name="type" value="${studentList.type}"/>
    <json:property name="enrolmenttime" value="${studentList.enrolmenttime}"/>
    <json:property name="graduate" value="${studentList.graduated}"/>
    <json:property name="number" value="${studentList.number}"/>
    <json:property name="daily" value="${studentList.daily}"/>
    <json:property name="ambition" value="${studentList.ambition}"/>
    <json:property name="responsible" value="${studentList.responsible}"/>
    <json:property name="wfrom" value="${studentList.wfrom}"/>
    <json:property name="telipone" value="${studentList.telipone}"/>
    <json:property name="email" value="${studentList.email}"/>
    <json:property name="portrait" value="${studentList.portrait}"/>
    <json:property name="createtime" value="${studentList.createAt}"/>
    <json:property name="updatetime" value="${studentList.updateAt}"/>

</json:object>
