<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>
<%--
  Created by IntelliJ IDEA.
  User: yyj
  Date: 2017/12/21
  Time: 19:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<json:object name="123">
    <json:property name="123" value="${list}"/>
    <json:property name="234" value="${list1}"/>
    <json:array name="222">
        <json:object>
            <json:property name="123" value="${list}"/>
        </json:object>
    </json:array>
</json:object>
</body>
</html>
