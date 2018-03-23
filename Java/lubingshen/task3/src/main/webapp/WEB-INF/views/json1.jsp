<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>json-taglib</title>
</head>
<body>
<json:object>
    <json:property name="123" value="${list}"/>
</json:object>
<form action="/task2/student/list" method="GET">
    <input type="submit" value="返回主页"></form>
</body>
</html>