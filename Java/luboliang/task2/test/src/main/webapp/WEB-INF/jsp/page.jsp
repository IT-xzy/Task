<%@page contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<html>
<head>
    <title>分页</title>
</head>
<body>
<h2>学员信息：</h2>

<table frame="box" rules="all">
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
    <c:if test="${list!= null || fn:length(list) != 0}">
        <c:forEach items="${list}" var="Student" begin="0" end="${fn:length(list) }">
            <tr>
            <tr>
                <td>${Student.id}</td>
                <td>${Student.name}</td>
                <jsp:useBean id="create_at" class="java.util.Date"/>
                <jsp:setProperty name="create_at" property="time" value="${Student.create_at}"/>
                <td><fmt:formatDate value="${create_at}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                <jsp:useBean id="update_at" class="java.util.Date"/>
                <jsp:setProperty name="update_at" property="time" value="${Student.update_at}"/>
                <td><fmt:formatDate value="${update_at}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
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
                    <%--<td>${user.create_at}</td>--%>
                    <%--<td>${user.update_at}</td>--%>

            </tr>
        </c:forEach>
    </c:if>
</table>
当前页<td>${page.currentPage}</td> /<td>${page.totalPages}</td>总页
<td><a href="/home/1">首页</a></td>
<td><a href="/home/${page.nextPage}">下一页</a></td>
<td><a href="/home/${page.prefPage}">上一页</a></td>
<td><a href="/home/${page.totalPages}">尾页</a></td>
<form name="" action="/homes">
    到:<input type="text" name="page" /> 页<br>
    <input type="submit" value="gou">
</form>