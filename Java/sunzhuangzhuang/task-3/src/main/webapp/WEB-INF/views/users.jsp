<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: root
  Date: 2018/6/17
  Time: 21:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <title>Title</title>
    <style>
    </style>
</head>
<body>

<table border="1" align="center"  width="80%" style="collapse:collapse">
    <tr>
        <th>ID</th>
        <th>姓名</th>
        <th>年龄</th>
        <th>创建时间</th>
        <th>修改时间</th>
        <th>操作</th>
    </tr>
    <c:forEach items="${list}" var="user">
        <tr>
            <td>${user.id}</td>
            <td>${user.name}</td>
            <td>${user.age }</td>
            <td>${user.createdate}</td>
            <td>${user.up}</td>
            <td>
            <form action="/users?id=${user.id}" method="post">
                <input type="hidden" name="_method" value="delete">
                <input type="submit" value="删除">
            </form>
            </td>

        </tr>
    </c:forEach>
</table>


<div style="text-align:center" >
    <a href="?start=0">首  页</a>
    <c:if test="${page.start-page.count<0}">
        <a href="javascript:void (0)"></a>
    </c:if>
    <c:if test="${page.start-page.count>=0}">
        <a href="?start=${page.start-page.count}">上一页</a>
    </c:if>
    <c:if test="${page.start+page.count<=page.last}">
        <a href="?start=${page.start+page.count}">下一页</a>
    </c:if>
    <c:if test="${page.start+page.count>page.last}">
        <a href="javascript:void (0)"></a>
    </c:if>
    <a href="?start=${page.last}">末  页</a>
</div>
<div align="center">
    <a href="/users/add">添加</a>
    <a href="/users/reuser">修改</a>
    <a href="http://localhost:8080/">返回主页</a>
</div>

<form action="/users/id">
    请输入要查询的ID：<input name="id">
    <input type="submit" value="查询">
</form>
<form action="/users/name">
    请输入要查询的姓名：<input name="name">
    <input type="submit" value="查询">
</form>

</body>
</html>
