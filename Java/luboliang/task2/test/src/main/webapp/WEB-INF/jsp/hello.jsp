<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" isErrorPage="true" %>
<html>
<head>

    <title>show</title>

</head>
<body>
<form action="/student" name="student" method="post">
    <%--<input type="hidden" name="_method" value="PUT">--%>
    <%--<input type="hidden" name="id" /> <br>--%>
    姓名：<input type="text" name="name" /> <br>
    更新时间：<input type="text" name="update_at"/> <br>
    QQ:<input type="text" name="qq"/> <br>
    课程类型:<input type="text" name="course_type" /> <br>
    入学时间:<input type="text" name="entrance_time"/> <br>
    毕业学校:<input type="text" name="graduate_school"/> <br>
    线上学号:<input type="text" name="wish"/> <br>
    日报:<input type="text" name="daily_link"/> <br>
    愿望:<input type="text" name="set_to" /> <br>
    师兄:<input type="text" name="brother"/> <br>
    何处了解:<input type="text" name="learn"/> <br>
    <input type="submit" value="添加"><br>
    <%--<td><a href="/students">返回页面</a></td>--%>
</form>

<table align="center" border="1" cellspacing="0">

    <tr>

        <td>id</td>
        <td>name</td>
        <td>create_at</td>
        <td>update_at</td>
        <td>qq</td>
        <td>course_type</td>
        <td>entrance_time</td>
        <td>graduate_school</td>
        <td>wish</td>
        <td>daily_link</td>
        <td>set_to</td>
        <td>brother</td>
        <td>learn</td>
        <td>edit</td>
        <td>delete</td>
        <%--<td>查找</td>--%>
    </tr>
    <c:forEach items="${students}" var="Student">
        <tr>
            <td>${Student.id}</td>
            <td>${Student.name}</td>
            <td>${Student.create_at}</td>
            <td>${Student.update_at}</td>
            <td>${Student.qq}</td>
            <td>${Student.course_type}</td>
            <td>${Student.entrance_time}</td>
            <td>${Student.graduate_school}</td>
            <td>${Student.wish}</td>
            <td>${Student.daily_link}</td>
            <td>${Student.set_to}</td>
            <td>${Student.brother}</td>
            <td>${Student.learn}</td>
            <td><a href="/student/${Student.id}">修改</a></td>
            <td><a href="/students/${Student.id}">删除</a></td>
            <%--<td><a href="/add?id=${Student.id}">添加数据</a></td>--%>
            <%--<td><a href="/find?id=${Student}">查找</a></td>--%>
        </tr>

    </c:forEach>
</table>


<h2>操作成功</h2>
<td><a href="/students">点击返回表单</a></td>
<td><a href="/home/1">点击返回分页</a></td>

</body>
</html>
