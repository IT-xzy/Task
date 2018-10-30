<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isErrorPage="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<html>
<head>
    <title>学生信息表</title>
</head>
<body>
<a href="/info/infoInsert">新增学生信息</a><br>
<a href="/info/infoSelect">查询信息</a><br>
<table border="5">
    <%--<table> 标签用来定义 HTML 表格--%>
    <tr>
        <th>id</th>
        <th>创建时间</th>
        <th>更新时间</th>
        <th>姓名</th>
        <th>QQ</th>
        <th>修真类型</th>
        <th>预计入学时间</th>
        <th>线上学号</th>
        <th>更新</th>
        <th>删除</th>
    </tr>
    <c:forEach var="student" items="${students}">
        <tr>
                <%--<td> 元素中的文本通常是普通的左对齐文本。--%>
            <td>${student.id}</td>
            <td>${student.createAt}</td>
            <td>${student.updateAt}</td>
            <td>${student.studentName}</td>
            <td>${student.qq}</td>
            <td>${student.profession}</td>
            <td>${student.admissionDate}</td>
            <td>${student.studentId}</td>
                <%--<td>${student.approach}</td>--%>
            <td> <form action="/info/infoUpdate/${student.id}" method="GET">
                <%--<input type="hidden" name="id" value=${student.id} checked><br>--%>
                <br><br>
                <input type="submit" value="更新">
            </form></td>
            <td> <form action="/students/${student.id}" method="POST">
                <input type="hidden" name="_method" value="DELETE" /><br>
                <input type="submit" value="确定删除">
            </form></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
