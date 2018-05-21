<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>
<%--
  Created by IntelliJ IDEA.
  User: Y
  Date: 18/4/3
  Time: 11:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<c:set var="path" value="${pageContext.request.contextPath}"/>

<html>
<head>
    <title>Add User Information</title>
</head>
<body>
<div style="text-align: center">
    <h2>新增用户</h2>

    <form action="${path}/user" method="post">
        <p>name:<input type="text" name="name"/></p>
        <p>number:<input type="text" name="number"/></p>
        <p>qq:<input type="text" name="qq"/></p>
        <p> type:<input type="text" name="type"/></p>
        <p> university:<input type="text" name="university"/></p>
        <p> time:<input type="text" name="time"/></p>
        <p>daily_link:<input type="text" name="daily_link"/></p>
        <p>pledge:<input type="text" name="pledge"/></p>
        <p>senior:<input type="text" name="senior"/></p>
        <p>locality:<input type="text" name="locality"/></p>

        <input type="submit" value="add user"/>
    </form>
</div>

</body>
</html>
