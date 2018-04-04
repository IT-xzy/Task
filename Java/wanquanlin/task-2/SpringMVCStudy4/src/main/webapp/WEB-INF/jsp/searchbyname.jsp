<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/3/14
  Time: 21:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
</head>
<body>

查询：<br><form action="${pageContext.request.contextPath}/user/student/dynamic">
    输入需要查询的学员的姓名:<input type="text" name="name" ><br>
    <input type="submit" value="查询">
</form><br>
<a href="/index.jsp">返回主页</a>
</body>
</html>
