<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/4/28
  Time: 16:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>查询数据</title>
</head>
<body>
<table width="100%" border=1>
    <thead>
    <tr>
        <td>ID</td>
        <td>用户名</td>
        <td>QQ</td>
        <td>入学时间</td>
        <td>学习类型</td>
        <td>学号</td>
        <td>立愿</td>
        <td>删除</td>
        <td>修改</td>
    </tr>
    </thead>
    <tbody>
    <tr>
        <td> ${student.id}</td>
        <td>${student.name }</td>
        <td>${student.qq}</td>
        <td>${student.enrolment_time}</td>
        <td>${student.learning_type}</td>
        <td>${student.number}</td>
        <td>${student.desire}</td>
        <td><a href="/deleteStu?id=${student.id}">delete</a> </td>
        <td><a href="/editStu?id=${student.id}">edit</a> </td>
    </tr>
    </tbody>
</table>
</body>
</html>
