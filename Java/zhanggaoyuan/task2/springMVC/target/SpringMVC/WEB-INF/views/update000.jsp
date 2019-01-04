<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isErrorPage="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/students" method="POST">
    请输入更新学员的信息:<br>
    <input type="hidden" name="_method" value="PUT" /><br>
    <%--创建时间 :<input type="text" name="createAt" value="">--%>
    <%--<br>--%>
    要更新的id:<input type="readonly" name="id" value="${student.id}" readonly>
    <br>
    姓名 :<input type="text" name="studentName" value="${student.studentName}">
    <br>
    QQ :<input type="text" name="qq" value="${student.qq}">
    <br>
    修真类型 :<input type="text" name="profession" value="${student.profession}">
    <br>
    预计入学时间 :<input type="text" name="admissionDate" value="${student.admissionDate}">
    <br>
    毕业院校 :<input type="text" name="graduatedFrom" value="${student.graduatedFrom}">
    <br>
    线上学号 :<input type="text" name="studentId" value="${student.studentId}">
    <br>
    日报链接 :<input type="text" name="dailyLink" value="${student.dailyLink}">
    <br>
    立愿  :<input type="text" name="makeWishes" value="${student.makeWishes}">
    <br>
    辅导师兄 :<input type="text" name="coachingSenior" value="${student.coachingSenior}">
    <br>
    从何处了解到修真院 :<input type="text" name="approach" value="${student.approach}">
    <br>
    <br>
    <input type="submit" value="提交">
</form>
</body>
</html>
