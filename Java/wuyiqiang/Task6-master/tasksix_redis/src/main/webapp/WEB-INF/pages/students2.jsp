<%--
  Created by IntelliJ IDEA.
  User: yiqia
  Date: 2018/2/2 0002
  Time: 20:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>
<html>
<head>
    <title>students2</title>
</head>
<body>
<json:object>
    <json:array name="items" var="item" items="${list}">
        <json:object>
            <json:property name="name" value="${item.name}"/>
            <json:property name="qq" value="${item.qq}"/>
        </json:object>
    </json:array>
</json:object>
</body>
</html>
