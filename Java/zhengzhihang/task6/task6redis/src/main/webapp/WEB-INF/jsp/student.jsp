<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/6/4
  Time: 19:04
  To change this template use File | Settings | File Templates.
--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>--%>
<%@page pageEncoding="UTF-8" language="java" contentType="text/html; charest=UTF-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>测试页面</title>
</head>
<body>
<h1>测试：query1</h1>
<table align='center' border='1' cellspacing='0'>
    <tr>
        <td>id</td>
        <td>name</td>
        <td>school</td>
        <td>age</td>
        <td>sex</td>
        <td>create_at</td>
        <td>update_at</td>
        <td>查询jsp</td>
        <td>查询json</td>
        <td>编辑</td>
        <td>删除</td>
    </tr>
    <c:forEach items="${students}" var="s" varStatus="st">
        <tr>
            <td>${s.id}</td>
            <td>${s.name}</td>
            <td>${s.school}</td>
            <td>${s.age}</td>
            <td>${s.sex}</td>
            <td>${s.create_at}</td>
            <td>${s.update_at}</td>
            <td>
                <form method="get" action="/student/${s.id}">
                    <input type="hidden" name="id" value="${s.id}">
                    <input type="hidden" name="name" value="${s.name}">
                    <input type="hidden" name="age" value="${s.age}">
                    <input type="submit" value="查询jsp">
                </form>
            </td>
            <td>
                <form method="get" action="/student/${s.id}">
                    <input type="hidden" name="id" value="${s.id}">
                    <input type="hidden" name="name" value="${s.name}">
                    <input type="submit" value="查询json">
                </form>
            </td>
            <td>
                <form method="get" action="/student/${s.id}">
                    <input type="hidden" name="id" value="${s.id}">
                    <input type="submit" value="编辑">
                </form>
            </td>
            <td>
                <form method="post" action="/student/${s.id}">
                    <!-- 隐藏域：把post请求转化成delete请求-->
                    <input type="hidden" name="_method" value="DELETE">
                    <input type="hidden" name="id" value="${s.id}">
                    <input type="submit" value="删除">
                </form>
            </td>
        </tr>
    </c:forEach>
</table>
<%--<div style="text-align:center">--%>
<%--<a href="?start=0">首 页</a>--%>
<%--<c:if test="${page.start-page.count>=0}">--%>
<%--<a href="?start=${page.start-page.count}">上一页</a>--%>
<%--</c:if>--%>
<%--<c:if test="${page.start+page.count<=page.last}">--%>
<%--<a href="?start=${page.start+page.count}">下一页</a>--%>
<%--</c:if>--%>
<%--<a href="?start=${page.last}">末页</a>--%>
<%--</div>--%>
<div style="text-align:center">
    <p>添加用户</p>
    <form action="/student" method="post">
        <input type="text" placeholder="姓名" name="name">
        <input type="text"  placeholder="年龄" name="age">
        <input type="text"  placeholder="性别" name="sex">
        <input  type="text" placeholder="学校" name="school">
        <input type="submit" value="增加">
    </form>
</div>
</body>
</html>
