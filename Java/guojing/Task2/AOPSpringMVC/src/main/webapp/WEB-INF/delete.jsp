<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@page isELIgnored="false" %>
<html>
<head>
    <title>删除数据</title>

</head>
<body>
<h1>删除数据</h1>
<form action="/student/${student.id}" name="student" method="POST">
    <input type="hidden" name="_method" value="DELETE">
    <input type="hidden" name="id" value="${id}"><br>
    姓名:<input type="text" name="name" value="${student.name}"><br>
    QQ:<input type="text" name="QQ" value="${student.QQ}"><br>
    宣言:<input type="text" name="wish" value="${student.wish}"><br>
    创建时间<input type="text" name="createAt" value="${student.createAt}"><br>
    更新时间<input type="text" name="updateAt" value="${student.updateAt}"><br>
    <input type="submit" value="删除"><br>
</form>
</body>
</html>