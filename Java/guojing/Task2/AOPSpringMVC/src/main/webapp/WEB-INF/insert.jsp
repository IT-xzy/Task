<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@page isELIgnored="false" %>
<html>
<head>
    <title>插入数据</title>
</head>
<body>
<h1>插入数据</h1>
<form action="/student" name="student" method="POST">
    <%--<input type="hidden" name="_method" value="POST">--%>
    姓名:<input type="text" name="name" value="${student.name}"><br>
    QQ:<input type="text" name="QQ" value="${student.QQ}"><br>
    宣言:<input type="text" name="wish" value="${student.wish}"><br>
    <input type="hidden" name="createAt" value="${student.createAt}"><br>
    <input type="hidden" name="updateAt" value="${student.updateAt}"><br>
    <input type="submit" value="添加"><br>
</form>
</body>
</html>