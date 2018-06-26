<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="java.util.*"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>List</title>
</head>
<body>
<h1 align='center'>修真人员</h1>
<form action="${pageContext.request.contextPath}/ssm/student/students" method="get"  align='center'>
    <input name="id" type="text" placeholder="请输入查询ID" required="required">
    <input type="submit" value="查找">
</form>
<a href="${pageContext.request.contextPath}/ssm/listStudent"  >****返回目录****</a>
<a href="${pageContext.request.contextPath}/ssm/student/user" >****添加****</a>
<table align='center' border='1' width="100%" cellspacing='0'>
    <tr>
        <th>id</th>
        <th>name</th>
        <th>age</th>
        <th colspan="2">设置</th>
    </tr>
    <c:forEach items="${cs}" var="c" varStatus="st">
        <tr>
              <td>${c.id}</td>
            <td>${c.name}</td>
            <td>${c.age}</td>
            <td><a href="${pageContext.request.contextPath}/ssm/student/profile/${c.id}">更新</a></td>
            <td><a href="${pageContext.request.contextPath}/ssm/student/${c.id}">删除</a></td>
        </tr>
    </c:forEach>
</table>
<div style="text-align:center">
    <a href="${pageContext.request.contextPath}/ssm/listStudent?pageNum=1">首  页</a>
    <a href="${pageContext.request.contextPath}/ssm/listStudent?pageNum=${page.prePage}">上一页</a>
    <a href="${pageContext.request.contextPath}/ssm/listStudent?pageNum=${page.nextPage}">下一页</a>
    <a href="${pageContext.request.contextPath}/ssm/listStudent?pageNum=${page.pages}">末  页</a>
</div>
</body>
</html>