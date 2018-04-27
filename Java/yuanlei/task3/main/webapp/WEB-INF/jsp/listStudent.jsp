<%--&lt;%&ndash;--%>
  <%--Created by IntelliJ IDEA.--%>
  <%--User: G510--%>
  <%--Date: 2018/3/29--%>
  <%--Time: 10:13--%>
  <%--To change this template use File | Settings | File Templates.--%>
<%--&ndash;%&gt;--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%--<%@taglib uri="http://java.sun.com/jstl/core" prefix="c"%>--%>
<%--<html>--%>
<%--<head>--%>
    <%--<title>List</title>--%>
<%--</head>--%>
<%--<body>--%>
 <%--<h1>修真人员</h1>--%>
<%--<table border="1" width="100%">--%>
    <%--<tr>--%>
        <%--<th>id</th>--%>
        <%--<th>name</th>--%>
        <%--<th>age</th>--%>
    <%--</tr>--%>
    <%--<c:forEach items="${list}" var="c" varStatus="st">--%>
        <%--<tr>--%>
            <%--<td>${c.id}</td>--%>
            <%--<td>${c.name}</td>--%>
            <%--<td>${c.age}</td>--%>
        <%--</tr>--%>
    <%--</c:forEach>--%>
<%--</table>--%>
<%--</body>--%>
<%--</html>--%>
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
</body>
</html>