<%--
  Created by IntelliJ IDEA.
  User: lihoo
  Date: 2018/8/13
  Time: 20:53
  To change this template use File | Settings | File Templates.
--%>
<%--使用@taglib指令添加json的标签库json-taglib--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"
         pageEncoding="UTF-8" import="java.util.*" %>


<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>


<c:forEach items="${stus}" var="s" varStatus="st">
    <json:object>
        <json:property name="id" value="${s.id}"/>
        <json:property name="username" value="${s.username}"/>
        <json:property name="qq_num" value="${s.qq_num}"/>
        <json:property name="study_type" value="${s.study_type}"/>
        <json:property name="study_time" value="${s.study_time}"/>
        <json:property name="school" value="${s.school}"/>
        <json:property name="study_id" value="${s.study_id}"/>
        <json:property name="daily_link" value="${s.daily_link}"/>
        <json:property name="promise" value="${s.promise}"/>
        <json:property name="teach_bro" value="${s.teach_bro}"/>
        <json:property name="know_us_from" value="${s.know_us_from}"/>
        <json:property name="create_at" value="${s.create_at}"/>
        <json:property name="update_at" value="${s.update_at}"/>
    </json:object>
</c:forEach>