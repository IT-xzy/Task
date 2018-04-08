<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Y
  Date: 18/4/3
  Time: 9:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>

<html>
<head>
    <title>Edit User Information</title>
</head>
<body>
<div style="text-align: center">
    <h2>修改用户</h2>
    <form action="${path}/user" method="post">
        <input type="hidden" name="_method" value="put"/>

        <p>name:<input type="text" name="name" value="${user.name}"/></p>
        <p>number:<input type="text" name="number" value="${user.number}"/></p>
        <p>qq:<input type="text" name="qq" value="${user.qq}"/></p>
        <p> type:<input type="text" name="type" value="${user.type}"/></p>
        <p>university:<input type="text" name="university" value="${user.university}"/></p>
        <p> time:<input type="text" name="time" value="${user.time}"/></p>
        <p>daily_link:<input type="text" name="daily_link" value="${user.daily_link}"/></p>
        <p> pledge:<input type="text" name="pledge" value="${user.pledge}"/></p>
        <p> senior:<input type="text" name="senior" value="${user.senior}"/></p>
        <p> locality:<input type="text" name="locality" value="${user.locality}"/></p>

        <input type="submit" value="modify user"/>
    </form>
</div>
</body>
</html>
