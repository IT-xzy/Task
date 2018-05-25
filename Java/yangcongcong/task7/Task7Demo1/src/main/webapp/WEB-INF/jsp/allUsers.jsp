<%--
  Created by IntelliJ IDEA.
  User: Y
  Date: 18/4/3
  Time: 9:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="path" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>User Info</title>
</head>
<body>
<div style="text-align: center">
    <h3>啦啦啦啦啦</h3>
</div>

<%--新增--%>
<div style="text-align: center">
    <%--<form action="${path}/u/user" method="get">--%>
    <form action="${path}/u/photo" method="get">
        <input type="submit" value="新增"/>
    </form>
</div>
<%--所有用户--%>
<div style="text-align: center">
    <table align='center' border='1' cellspacing='0'>
        <tr>
            <td>id</td>
            <td>name</td>
            <td>number</td>
            <td>qq</td>
            <td>type</td>
            <td>university</td>
            <td>time</td>
            <td>daily_link</td>
            <td>pledge</td>
            <td>senior</td>
            <td>locality</td>
            <td>cellphone</td>
            <td>email</td>
            <td>picture</td>
            <td>create_at</td>
            <td>update_at</td>
            <td colspan="3">操作</td>
        </tr>
        <c:forEach var="u" items="${pageInfo}">
            <tr>
                <td>${u.id}</td>
                <td>${u.name}</td>
                <td>${u.number}</td>
                <td>${u.qq}</td>
                <td>${u.type}</td>
                <td>${u.university}</td>
                <td>${u.time}</td>
                <td>${u.daily_link}</td>
                <td>${u.pledge}</td>
                <td>${u.senior}</td>
                <td>${u.locality}</td>
                <td>${u.cellphone}</td>
                <td>${u.email}</td>
                <td>${u.picture}</td>
                <td>${u.create_at}</td>
                <td>${u.update_at}</td>
                    <%--修改&删除--%>
                <td>
                    <form action="/u/users/${u.id}" method="get">
                        <input type="submit" value="修改"/>
                    </form>
                </td>
                <td>
                    <form action="/users/${u.id}" method="post">
                        <input type="hidden" name="_method" value="delete"/>
                        <input type="submit" value="删除"/>
                    </form>
                </td>
                <td>
                    <form action="/u/users/${u.id}" method="post">
                        <input type="submit" value="详细资料"/>
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
