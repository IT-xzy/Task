<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>
<%--
  Created by IntelliJ IDEA.
  User: Dong
  Date: 2018/3/18
  Time: 23:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<json:object>
    <json:property name="id" value="${student.id}"/>
    <json:property name="创建时间" value="${student.createAt}"/>
    <json:property name="更新时间" value="${student.updateAt}"/>
    <json:property name="姓名" value="${student.name}"/>
    <json:property name="性别" value="${student.sex}"/>
    <json:property name="QQ" value="${student.qq}"/>
    <json:property name="主修" value="${student.major}"/>
    <json:property name="入学时间" value="${student.entryTime}"/>
    <json:property name="来自" value="${student.comeFrom}"/>
</json:object>

</body>
</html>
