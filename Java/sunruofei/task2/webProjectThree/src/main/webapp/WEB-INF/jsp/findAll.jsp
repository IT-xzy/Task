<%--
  Created by IntelliJ IDEA.
  User: 孙若飞
  Date: 2019/1/15
  Time: 21:19
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--c标签需要它--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>

<html>
<head>
    <title>表格</title>
</head>
<body>
<table align="center" border="1" cellspacing="0">
    <tr>
        <td>id</td>
        <td>name</td>
        <td>qq</td>
        <td>type</td>
        <td>admission_date</td>
        <td>graduate_school</td>
        <td>student_number</td>
        <td>daily_link</td>
        <td>wish</td>
        <td>instructor</td>
        <td>information_source</td>
        <td>添加</td>
        <td>修改</td>
        <td>删除</td>
        <%--c标签里封装了java循环语法--%>
        <c:forEach items="${students}" var="Student">
    <tr>
        <td>${Student.id}</td>
        <td>${Student.name}</td>
        <td>${Student.qq}</td>
        <td>${Student.type}</td>
        <td>${Student.admission_date}</td>
        <td>${Student.graduate_school}</td>
        <td>${Student.student_number}</td>
        <td>${Student.daily_link}</td>
        <td>${Student.wish}</td>
        <td>${Student.instructor}</td>
        <td>${Student.information_source}</td>
        <td><a href="/add">添加</a></td>
        <td><a href="/student?id=${Student.id}">修改</a></td>
        <td><a href="/student/${Student.id}">删除</a></td>
    </tr>

    </c:forEach>
</table>
    <td><a href="/page?pageNow=1">首页</a></td>
    <td><a href="/page?pageNow=${prePage}">上一页</a></td>
    <td><a href="/page?pageNow=${nextPage}">下一页</a></td>
    <td><a href="/page?pageNow=${totalPage}">尾页</a></td>
    <td>当前第${pageNow}页</td>
    <td>总共${totalPage}页</td>
    <br>
    <form action="/page">
        去<input type="text" name="pageNow">页
        <input type="submit" value="go">
    </form>
</body>
</html>
