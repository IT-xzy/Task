<%--
  Created by IntelliJ IDEA.
  User: yiqia
  Date: 2018/2/2 0002
  Time: 20:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>
<html>
<head>
    <title>students2id</title>
</head>
<body>
    <json:object>
        <json:property name="name" value="${student.name}"/>
        <json:property name="qq" value="${student.qq}"/>
    </json:object>
</body>
</html>
