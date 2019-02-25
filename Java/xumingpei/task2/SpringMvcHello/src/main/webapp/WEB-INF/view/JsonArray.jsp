<%--
  Created by IntelliJ IDEA.
  User: Shinelon
  Date: 2019/1/16
  Time: 11:04
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>
<json:object>
    <json:array name="JsonArray" var="student" items="${studentList}">
<json:object>
    <json:property name="id" value="${student.id}"/>
    <json:property name="name" value="${student.name}"/>
    <json:property name="qq" value="${student.qq}"/>
    <json:property name="type" value="${student.type}"/>
    <json:property name="enrolmentTime" value="${student.enrolmentTime}"/>
    <json:property name="school" value="${student.school}"/>
    <json:property name="onlineId" value="${student.onlineId}"/>
    <json:property name="dailyUrl" value="${student.dailyUrl}"/>
    <json:property name="wish" value="${student.wish}"/>
    <json:property name="brother" value="${student.brother}"/>
    <json:property name="whereToKnowJnshu" value="${student.whereToKnowJnshu}"/>
    <json:property name="createAt" value="${student.getcreateAt()}"/>
    <json:property name="updateAt" value="${student.getupdateAt()}"/>
</json:object>
    </json:array>
</json:object>