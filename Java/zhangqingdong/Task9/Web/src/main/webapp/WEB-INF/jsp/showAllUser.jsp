<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/10/26
  Time: 10:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table border="1">
    <tr>
        <td>用户名</td>
        <td>编辑用户</td>
    </tr>
    <c:forEach var="user" items="${users}">
        <tr class="users" id="${user.id}">
            <td>${user.username}</td>
            <td>
                <form action="${ctx}/user/${user.id}" method="get">
                    <input type="submit" value="编辑">
                </form>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
<script src="${ctx}/static/jquery-3.2.1.js"></script>

</html>
