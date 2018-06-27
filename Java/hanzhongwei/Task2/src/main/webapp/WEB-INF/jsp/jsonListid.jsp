<%--
  Created by IntelliJ IDEA.
  User: 指缝de阳光
  Date: 2018/4/29
  Time: 17:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<json:object>
    <json:property name="id" value="${s.stuId}" />
    <json:property name="name" value="${s.stuName}"/>
    <json:property name="QQ" value="${s.stuQQ}"/>
    <json:property name="类型" value="${s.stuType}" />
    <json:property name="学号" value="${s.stuNum}" />
</json:object>
</body>
</html>
