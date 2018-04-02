<%--
  Created by IntelliJ IDEA.
  User: G510
  Date: 2018/3/29
  Time: 10:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<html>
<head>
    <title>List</title>
</head>
<body>
 <h1>修真人员</h1>
<table border="1" width="100%">
    <tr>
        <th>id</th>
        <th>name</th>
        <th>age</th>
    </tr>
    <c:forEach items="${category}" var="c" varStatus="st">
        <tr>
            <td>${c.id}</td>
            <td>${c.name}</td>
            <td>${c.age}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
