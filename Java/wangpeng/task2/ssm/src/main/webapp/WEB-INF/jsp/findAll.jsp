<%--
  Created by IntelliJ IDEA.
  User: 老王
  Date: 2019/4/26
  Time: 17:28
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html; charset=utf-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<head>
    <title>表格</title>
</head>

<body>
<table align="center" border="1" cellspacing="0">
    <tr>
        <td>id</td>
        <td>name</td>
        <td>qq</td>
        <td>type</td>
        <td>estimatedtime</td>
        <td>school</td>
        <td>manner</td>
        <td>number</td>
        <td>daily</td>
        <td>wish</td>
        <td>counselor</td>
        <td>source</td>
        <td>create_at</td>
        <td>update_at</td>
        <td>添加</td>
        <td>修改</td>
        <td>删除</td>
    </tr>
    <%--//接收controller给出的model数据--%>
    <%--c标签里封装了java循环语法--%>
    <c:forEach items="${students}" var="Student">
        <tr>
            <td>${Student.id}</td>
            <td>${Student.name}</td>
            <td>${Student.qq}</td>
            <td>${Student.type}</td>
            <td>${Student.estimatedtime}</td>
            <td>${Student.school}</td>
            <td>${Student.manner}</td>
            <td>${Student.number}</td>
            <td>${Student.daily}</td>
            <td>${Student.wish}</td>
            <td>${Student.counselor}</td>
            <td>${Student.source}</td>
            <td>${Student.create_at}</td>
            <td>${Student.update_at}</td>
            <td><a href="/add">添加</a></td>
            <td><a href="/student?id=${Student.id}">修改</a></td>
            <td><a href="/student/${Student.id}">删除</a></td>
        </tr>
    </c:forEach>
</table>

<a href="/table?number=1">首页</a>
<a href="/table?number=${prePage}">上一页</a>
<a href="/table?number=${nextPage}">下一页</a>
<a href="/table?number=${totalPages}">尾页</a>
当前第${number}页
总共${totalPages}页
<form action="/table">
    去<input type="text" name="pageNow">页
    <input type="submit" value="go">
</form>

</body>
</html>
