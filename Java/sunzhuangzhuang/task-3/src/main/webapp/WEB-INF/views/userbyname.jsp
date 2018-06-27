<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: root
  Date: 2018/6/20
  Time: 13:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table border="1" align="center" width="80%" style="collapse: collapse" >
    <tr>
        <th>ID</th>
        <th>姓名</th>
        <th>年龄</th>
        <th>创建时间</th>
        <th>修改时间</th>
        <th>操作</th>
    </tr>
    <c:forEach items="${users}" var="user">
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
<div align="center">
<a href="/users">返回</a>
</div>
</body>
</html>
