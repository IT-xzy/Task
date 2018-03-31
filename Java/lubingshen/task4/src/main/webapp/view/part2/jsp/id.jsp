<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="java.util.*" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>详细信息</title>
</head>
<body>
<div style="width:1800px;margin:0px auto;text-align:center">
    <font color="blue" size="5" >详细信息</font><br/>
    <form method="POST" action="/u/task2/student"><!--指向的是路径名称-->
        <table align='center' border='1' cellspacing='0'>
            <tr>
                <th>姓名</th>
                <th><input type="text" name="name" value="${student.name}"/></th>
            </tr>
            <tr>
                <th>QQ</th>
                <th><input type="text" name="qq" value="${student.qq}"/></th>
            </tr>
            <tr>
                <th>修真类型</th>
                <th><input type="text" name="type" value="${student.type}"/></th>
            </tr>
            <tr>
                <th>预计入学时间</th>
                <th><input type="text" name="admissionTime" value="${student.admissionTime}"/></th>
            </tr>
            <tr>
                <th>毕业院校</th>
                <th><input type="text" name="school" value="${student.school}"/></th>
            </tr>
            <tr>
                <th>在线学号</th>
                <th><input type="text" name="num" value="${student.num}"/></th>
            </tr>
            <tr>
                <th>日报链接</th>
                <th><input type="text" name="daily" value="${student.daily}"/></th>
            </tr>
            <tr>
                <th>宣言</th>
                <th><input type="text" name="declaration" value="${student.declaration}"/></th>
            </tr>
            <tr>
                <th>辅导师兄</th>
                <th><input type="text" name="elder" value="${student.elder}"/></th>
            </tr>
            <tr>
                <th>从何处了解</th>
                <th><input type="text" name="knewFrom" value="${student.knewFrom}"/></th>
            </tr>
        </table>
        <input type="hidden" value="PUT" name="_method">
        <input type="hidden" value="${student.id}" name="id">
        <input type="submit" value="确定修改"/></form>

    <form action="/u/task2/student/list" method="GET">
        <input type="submit" value="返回主页"></form>
</div>
</body>
</html>
