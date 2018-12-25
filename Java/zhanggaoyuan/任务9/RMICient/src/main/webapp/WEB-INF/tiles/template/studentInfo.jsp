<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isErrorPage="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<html>
<head>
    <title>学员信息表</title>
        <meta charset="utf-8">
        <title>无标题文档</title>
        <meta content="width=device-width, initial-scale=1.0" name="viewport" charset="UTF-8">
        <link rel="stylesheet" href="http://apps.bdimg.com/libs/bootstrap/3.3.4/css/bootstrap.min.css">
        <script src="http://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
        <script src="http://apps.bdimg.com/libs/bootstrap/3.3.4/js/bootstrap.min.js"></script>
        <link href="${pageContext.request.contextPath}/static/other/t11.css" rel="stylesheet" type="text/css">
        <link href="${pageContext.request.contextPath}/static/other/Untitled-1base.css" rel="stylesheet" type="text/css">
</head>
<body>
<a href="/u/toInsert" style="color: black;">新增学生信息</a><br>
<%--<br><br>--%>
<%--<c:out value="请输入查找学员的名字" />--%>
<%--<td> <form action="/selectName" method="GET">--%>
    <%--<input type="text" name="name" value="苏正荣">--%>
    <%--<input type="submit" value="查询">--%>
<%--</form></td>--%>
<br><br>
<%--<a href="/info/infoSelect">查询信息</a><br>--%>
<table border="5">
    <%--<table> 标签用来定义 HTML 表格--%>
    <tr>
        <th>id</th>
        <th>创建时间</th>
        <th>更新时间</th>
        <th>姓名</th>
        <th>头像链接</th>
        <th>职位</th>
        <th>薪水</th>
        <th>是否优秀学员</th>
        <th>更新</th>
        <th>删除</th>
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
            <td>${student.salary}</td>
            <td>${student.ifExcellent}</td>
            <td> <form action="/u/toUpdate/${student.id}" method="GET">
                <br><br>
                <input type="submit" value="更新">
            </form></td>
            <td> <form action="/u/students/${student.id}" method="POST">
                <input type="hidden" name="_method" value="DELETE" /><br>
                <input type="submit" value="确定删除">
            </form></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
