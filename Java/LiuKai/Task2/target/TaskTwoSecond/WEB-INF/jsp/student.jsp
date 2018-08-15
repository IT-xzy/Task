<%--
  Created by IntelliJ IDEA.
  User: Liu Kai
  Date: 2018/7/12
  Time: 21:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>学员</title>
</head>
<body>

<h2>Student Information</h2>
<table >
    <%--<tr>--%>
        <%--<td>编号：</td>--%>
        <%--<td>名字：</td>--%>
        <%--<td>课程：</td>--%>
    <%--</tr>--%>

    <%--<tr>--%>
        <%--<td> ${student.id}</td>--%>
        <%--<td> ${student.stuName}</td>--%>
        <%--<td> ${student.course}</td>--%>

    <%--</tr>--%>

    <table border=1>
        <tr>
            <td>id</td>
            <td>账号</td>
            <td>密码</td>
            <td>其他操作</td>
        </tr>

        <%--<c:forEach items="${list}" var="student">--%>
        <tr>
            <td>${student.id}</td>
            <td>${student.stuName}</td>
            <td>${student.course}</td>
                <%--<td><a href="delete?id=${item.id}">删除</a></td>--%>
                <%--<td><a href="update?id=${item.id }">更新</a>--%>
        </tr>
        <%--</c:forEach>--%>
    </table>

</table>
</body>
</html>