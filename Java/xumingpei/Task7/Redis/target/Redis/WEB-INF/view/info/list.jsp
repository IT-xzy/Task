<%--
  Created by IntelliJ IDEA.
  User: Shinelon
  Date: 2019/5/7
  Time: 9:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isErrorPage="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<script src="http://libs.baidu.com/jquery/2.0.0/jquery.min.js"></script>
<script type="text/javascript">
    $(function(){
        $(".delete").on("click", function(){
            var href=$(this).attr("href");
            $("#formdelete").attr("action",href).submit();
            return false;
        })
    })
</script>
<html>
<head>
    <title>学生主页</title>
</head>
<form method="get" action="/name">
    <input type="text" name="name" placeholder="请输入姓名">
    <input type="submit" value="根据姓名查询">
</form>
<body>
<a href="/u/goInsert">添加用户</a>
<div style="width:500px;margin:0px auto;text-align:center">
    <table align='left' border='1' cellspacing='0'>
        <tr>
            <td>id</td>
            <td>name</td>
            <td>introduction</td>
            <td>position</td>
            <td>img</td>
            <td>salary</td>
            <td>status</td>
            <td>createAt</td>
            <td>updateAt</td>
            <td>createBy</td>
            <td>编辑</td>
            <td>删除</td>
        </tr>
        <c:forEach items="${student}" var="student">
        <tr>
            <td>${student.id}</td>
            <td>${student.name}</td>
            <td>${student.introduction}</td>
            <td>${student.position}</td>
            <td>${student.img}</td>
            <td>${student.salary}</td>
            <td>${student.status}</td>
            <td>${student.createAt}</td>
            <td>${student.updateAt}</td>
            <td>${student.createBy}</td>
            <td><a href="/u/goUpdate/${student.id}">编辑</a></td>
            <td><a class="delete" href="/u/student/${student.id}">删除</a></td>
        </tr>
        </c:forEach>
</body>
</html>
