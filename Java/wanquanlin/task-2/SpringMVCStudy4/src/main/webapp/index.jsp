<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html;

charset=UTF-8">
    <title>Insert title here</title>
</head>
<body align="center">
<br>
<td><form action="${pageContext.request.contextPath}/user/student/list" method="get">
    <input type="submit" value="查询所有学员信息">
</form> </td><br>

<td><form action="${pageContext.request.contextPath}/user/student/ID" method="get">
    <input type="submit" value="按ID查询学员信息">
</form></td><br>
<td><form action="${pageContext.request.contextPath}/user/name" method="get">
    <input type="submit" value="按名字查询学员信息">
</form></td><br>
<td><form action="${pageContext.request.contextPath}/user/new/" method="post">
    <input type="submit" value="添加新到学员信息">
</form></td><br>
<td><form action="${pageContext.request.contextPath}/user/student/ID" method="get">
    <input type="submit" value="编辑学员信息">
</form></td><br>
<td><form action="${pageContext.request.contextPath}/user/student/ID" method="get">
    <input type="submit" value="删除学员信息">
</form></td>



<br>
</body>
</html>