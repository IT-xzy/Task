<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/9/15
  Time: 0:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/9/12
  Time: 23:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" isErrorPage="true"%>
<html>
<head>
    <title>studenttable</title>
</head>
<body>
<h1>学生表</h1>
<table align="center" border="1" cellspacing="0">
    <tr>
        <td>id</td>
        <td>name</td>
        <td>QQ</td>
        <td>wish</td>
        <td>createAt</td>
        <td>updateAt</td>
        <td>insert</td>
        <td>edit</td>
        <td>delete</td>
    </tr>

    <%--item代表输入的数据，User代表防止的地方--%>
    <c:forEach items="${students}" var="Student">
        <tr>
            <td>${Student.id}</td>
            <td>${Student.name}</td>
            <td>${Student.QQ}</td>
            <td>${Student.wish}</td>
            <td>${Student.createAt}</td>
            <td>${Student.updateAt}</td>
            <td><a href="/student/add">插入</a></td>
            <td><a href="/student/up/${Student.id}">修改</a></td>
            <td><a href="/student/down/${Student.id}">删除</a></td>

        </tr>
    </c:forEach>

</table>
</body>

</html>

<head>
    <title>Title</title>
</head>
<body>
</body>
</html>
