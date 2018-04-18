<%--
  Created by IntelliJ IDEA.
  User: G510
  Date: 2018/3/29
  Time: 23:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>添加信息</title>
</head>
<br>
<h1>学生信息</h1>
<form action="${pageContext.request.contextPath}/ssm/student/users" name="student" method="post">
    姓名:<input name="name" type="text" value="${student.name}" required="required"></br>
    年龄:<input name="age" type="text" value="${student.age}" required="required"></br>

<input type="submit" value="添加">

<a href="${pageContext.request.contextPath}/ssm/listStudent">返回列表</a></br>
</form>
</body>
</html>
