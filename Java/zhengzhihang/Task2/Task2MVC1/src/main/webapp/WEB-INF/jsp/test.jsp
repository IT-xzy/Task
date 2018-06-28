<%@page language="java" import="java.util.*" pageEncoding="utf-8" %>>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE HTML PUBLIC "-//W#C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <!-- jsp文件名-->
    <title>test</title>
</head>
<body>
<from action="findStudent.action" method="post">
    用户姓名：<input type="text" name="name"/></br>
    <input type="submit" value="查询">
</from>
<table width="300px;" border="1">
    <tr>
        <td>id</td>
        <td>age</td>
        <td>sex</td>
        <td>school</td>
        <td>name</td>
    </tr>
    <c:forEach items="${studentList}" var="student" varStatus="status">
        <tr>
            <td>${status.index+1}</td><td>${student.name}</td>
            <td>${student.age}</td><td>${student.sex}</td><td>${student.school}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>