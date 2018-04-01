<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>


<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/3/20
  Time: 20:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<json:object>
    <json:property  name="ID" value="${student.ID}"/>
    <json:property  name="姓名" value="${student.name}"/>
    <json:property  name="QQ" value="${student.QQ}"/>
    <json:property  name="入学时间" value="${student.time_of_enrollment}"/>
</json:object>
</body>
</html>
