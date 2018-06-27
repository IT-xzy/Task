<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<html>
<head>
    <title>姓名查询</title>
</head>
<body>
<table border="1" cellpadding="10" cellspacing="0" class="table1">
    <thead>姓名查询学员信息</thead>
    <tr>
        <td>学员ID</td>
        <td>姓名</td>
        <td>性别</td>
        <td>年龄</td>
        <td>QQ</td>
        <td>修真类型</td>
        <td>加入时间</td>
        <td>学校</td>
        <td>线上学号</td>
        <td>日报链接</td>
        <td>立愿</td>
        <td>辅导师兄</td>
    </tr>
    <c:forEach items="${studentByName}" var="student">
        <tr>
            <td>${student.id}</td>
            <td>${student.name}</td>
            <td>${student.gender}</td>
            <td>${student.age}</td>
            <td>${student.qq}</td>
            <td>${student.occupation}</td>
            <td>${student.joinDate}</td>
            <td>${student.school}</td>
            <td>${student.number}</td>
            <td>${student.dailyUrl}</td>
            <td>${student.declaration}</td>
            <td>${student.consoler}</td>
        </tr>
    </c:forEach>
</table>
<form action="${pageContext.request.contextPath}/student/list" method="GET">
    <input type="submit" value="返回主页">
</form>
</body>
</html>