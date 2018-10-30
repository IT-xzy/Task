<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/8/14
  Time: 12:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/json;charset=UTF-8" language="java" isErrorPage="true" %>
<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<json:object>
    <json:property name="message" value="${result.msg}"/>
</json:object>

</body>
</html>
