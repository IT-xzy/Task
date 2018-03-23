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
<img src="${url}" width="50" height="50">
<a href="/up/file">更改头像</a>

<form action="/u/home" method="post">
    <table>
        <input type="hidden" name="headPicture" value="${student.headPicture}"/>
        <tr><td>名字</td><td><input type="text" name="name" value="${student.name}"/></td></tr>
        <tr><td>QQ</td><td><input type="text" name="qq" value="${student.qq}"/></td><td>${ERR_qq}</td></tr>
        <tr><td>手机号</td><td><input type="text" name="phoneNumber" value="${student.phoneNumber}"/></td><td>${ERR_phoneNumber}</td></tr>
        <tr><td>分数</td><td><input type="text" name="score" value="${student.score}" placeholder="0-100"/></td></tr>
        <tr><td>状态</td><td><input type="text" name="status" value="${student.status}" placeholder="0:在学  1已工作"/></td></tr>
        <tr><td>修真类型</td><td><input type="text" name="classId" value="${student.classId}" placeholder="1:前端  2:PM  3:后端"/></td></tr>
        <tr><td colspan="2"><input type="submit" value="更改"></td></tr>
    </table>
</form>
<a href="/">不更改返回</a>

</body>
</html>
