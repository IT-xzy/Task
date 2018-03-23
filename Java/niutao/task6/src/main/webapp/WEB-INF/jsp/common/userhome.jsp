<%--
  Created by IntelliJ IDEA.
  User: Blue
  Date: 2018/1/21
  Time: 13:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户信息</title>
</head>
<body>
<h3>你好${student.userName}</h3>
<form action="/u/home" method="post">
    <table>
        <tr><td>名字</td><td><input type="text" name="name" value="${student.name}"/></td></tr>
        <tr><td>分数</td><td><input type="text" name="score" value="${student.score}"/></td></tr>
        <tr><td>状态</td><td><input type="text" name="status" value="${student.status}"/></td></tr>
        <tr><td>修真类型</td><td><input type="text" name="classId" value="${student.classId}"/></td></tr>
        <tr><td colspan="2"><input type="submit" value="更改"></td></tr>
    </table>

</body>
</html>
