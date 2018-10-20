<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@page isELIgnored="false" %>
<html>
<head>
    <title>修改数据</title>
</head>
<body>
<h1>修改数据</h1>
<form action="/student/${page}" name="student" method="POST">
    <input type="hidden" name="_method" value="PUT">
    <input type="hidden" name="page" value="${page}">
    <input type="hidden" name="id" value="${student.id}"><br>
    姓名:<input type="text" name="name" value="${student.name}"><br>
    QQ:<input type="text" name="QQ" value="${student.QQ}"><br>
    宣言:<input type="text" name="wish" value="${student.wish}"><br>
    <input type="hidden" name="createAt" value="${student.createAt}"><br>
    <input type="hidden" name="updateAt" value="${student.updateAt}"><br>
    <input type="submit" value="修改"><br>
</form>
</body>
</html>