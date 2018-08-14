<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<%--
  Created by IntelliJ IDEA.
  User: ljl
  Date: 2018/7/17
  Time: 19:45
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<json:object >
        <json:property name="ID"        value="${user.id}"/>
        <json:property name="姓名"       value="${user.name}"/>
        <json:property name="QQ"        value="${user.qq} "/>
        <json:property name="修真类型"   value="${user.studyType}"/>
        <json:property name="入学时间"   value="${user.enrollment}"/>
        <json:property name="毕业学校"   value="${user.graduateSchool}"/>
        <json:property name="线上学号"   value="${user.studentNum}"/>
        <json:property name="日报链接"   value="${user.dailyLink}"/>
        <json:property name="立愿"       value="${user.wish}"/>
        <json:property name="审核师兄"   value="${user.checkBro}"/>
        <json:property name="了解途径"   value="${user.knowWay}"/>
</json:object>
</body>
</html>
