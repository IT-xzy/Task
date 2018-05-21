<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/10/11
  Time: 14:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>TPS</title>
</head>
<body>
<table border="1">
    <th>学员名</th>
    <th>QQ</th>
    <th>类型</th>
    <th>入学时间</th>
    <th>毕业学校</th>
    <th>立愿</th>
    <th>学号</th>
    <th>日报链接</th>
    <th>辅助师兄</th>
    <th>推荐师兄</th>
    <th>来源</th>
<c:forEach items="${studentList}" var="student">
    <tr>
        <td>${student.name}</td>
        <td>${student.QQ}</td>
        <td>${student.type}</td>
        <td>${student.appointment}</td>
        <td>${student.school}</td>
        <td>${student.oath}</td>
        <td>${student.number}</td>
        <td>${student.link}</td>
        <td>${student.supportSenior}</td>
        <td>${student.referrer}</td>
        <td>${student.QQ}</td>
    </tr>
</c:forEach>
</table>
</body>
</html>
