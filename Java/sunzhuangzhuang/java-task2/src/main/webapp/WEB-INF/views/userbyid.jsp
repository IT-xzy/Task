<%--
  Created by IntelliJ IDEA.
  User: root
  Date: 2018/6/20
  Time: 13:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table align="center" border="1" style="border-collapse: collapse" width="80%">
    <tr>
        <th>ID</th>
        <th>姓名</th>
        <th>年龄</th>
        <th>创建时间</th>
        <th>更新时间</th>
        <th>操作</th>
    </tr>
    <tr>
        <td>${users.id}</td>
        <td>${users.name}</td>
        <td>${users.age}</td>
        <td>${users.createdate}</td>
        <td>${users.up}</td>
        <td>
            <form action="/users?id=${users.id}" method="post">
                <input type="hidden" name="_method" value="delete">
                <input type="submit" value="删除">
            </form>
        </td>
    </tr>
</table>
<div align="center">
<a href="/users">返回</a>
</div>
</body>
</html>
