<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="java.util.*" %>
<html>
<head>
    <title>姓名搜索结果</title>
</head>
<body>
<div style="width:1800px;margin:0px auto;text-align:center">
    <font color="blue" size="5" >姓名查找结果</font><br/>
    <table align='center' border='1' cellspacing='0'>
        <tr>
            <td>姓名</td>
            <td>QQ</td>
            <td>修真类型</td>
            <td>预计入学时间</td>
            <td>毕业院校</td>
            <td>在线学号</td>
            <td>日报链接</td>
            <td>宣言</td>
            <td>辅导师兄</td>
            <td>从何处了解</td>
        </tr>
        <c:forEach items="${students}" var="student">
            <tr>
                <td>${student.name}</td>
                <td>${student.qq}</td>
                <td>${student.type}</td>
                <td>${student.admissionTime}</td>
                <td>${student.school}</td>
                <td>${student.num}</td>
                <td>${student.daily}</td>
                <td>${student.declaration}</td>
                <td>${student.elder}</td>
                <td>${student.knewFrom}</td>
            </tr>
        </c:forEach>
    </table>
    <form action="/u/task2/student/list" method="GET">
        <input type="submit" value="返回主页"></form>
</div>
</body>
</html>
