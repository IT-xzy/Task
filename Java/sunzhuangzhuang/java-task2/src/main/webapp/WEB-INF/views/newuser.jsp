<%--
  Created by IntelliJ IDEA.
  User: root
  Date: 2018/6/20
  Time: 14:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form id="添加" action="/users" method="post">
    <table>
        <tr>
            <td>姓名：</td>
            <td><input id="name" name="name"></td>
        </tr>
        <tr>
            <td>年龄:</td>
            <td><input id="age" name="age"></td>
        </tr>
        <tr>
            <td><input type="submit" value="添加"></tr></td>
        </tr>
    </table>
</form>

</body>
</html>
