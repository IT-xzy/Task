<%--
  Created by IntelliJ IDEA.
  User: Blue
  Date: 2018/1/9
  Time: 17:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>
    <json:object>
        <json:property name="name" value="${student.name}"/>
        <json:property name="id" value="${student.id}"/>
        <json:property name="qq" value="${student.qq}"/>
    </json:object>
<table border="1">
    <tr>
        <th>ID</th>
        <th>${student.id}</th>
    </tr>
    <tr>
        <th>名字</th>
        <th>${student.name}</th>
    </tr>
    <tr>
        <th>QQ</th>
        <th>${student.qq}</th>
    </tr>
    <tr>
        <th>毕业学校</th>
        <th>${student.graduate_school}</th>
    </tr>
    <tr>
        <th>学号</th>
        <th>${student.oline_number}</th>
    </tr>
    <tr>
        <th>日报链接</th>
        <th><a href=${student.link}>${student.link}</a></th>
    </tr>
    <tr>
        <th>誓言</th>
        <th>${student.wish}</th>
    </tr>
    <tr>
        <th>师兄</th>
        <th>${student.brother_id}</th>
    </tr>
</table>
</body>
</html>
