<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isErrorPage="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<html>
<head>

</head>
<body>
<a href="/home" style="color: black;">返回首页</a><br>
<br><br>
<table border="5">
    <tr>
        <th>id</th>
        <th>创建时间</th>
        <th>更新时间</th>
        <th>姓名</th>
        <th>头像链接</th>
        <th>职位</th>
        <th>简介</th>
        <th>薪水</th>
        <th>是否优秀学员</th>
    </tr>
    <c:forEach var="student" items="${students}">
        <tr>
                <%--<td> 元素中的文本通常是普通的左对齐文本。--%>
            <td>${student.id}</td>
            <td>${student.creatTime}</td>
            <td>${student.updateTime}</td>
            <td>${student.name}</td>
            <td>${student.img}</td>
            <td>${student.position}</td>
            <td>${student.description}</td>
            <td>${student.salary}</td>
            <td>${student.ifExcellent}</td>

        </tr>
    </c:forEach>
</table>
</body>
</html>
