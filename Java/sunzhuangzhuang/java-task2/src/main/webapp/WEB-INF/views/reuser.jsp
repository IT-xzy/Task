<%--
  Created by IntelliJ IDEA.
  User: root
  Date: 2018/6/20
  Time: 14:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form id="更新" action="/users" method="post">
    <input type="hidden" name="_method" value="put">
    <table>
        <tr>
            <td>更新： </td>
        </tr>
        <tr>
            <td>姓名：</td>
            <td><input name="name"></td>
        </tr>
        <tr>
            <td>年龄：</td>
            <td><input name="age"></td>
        </tr>
        <tr>
            <td>ID：</td>
            <td><input name="id"></td>
        </tr>
        <tr>
            <td><input type="submit" value="确认更新"></td>
        </tr>
    </table>
</form>
</body>
</html>
