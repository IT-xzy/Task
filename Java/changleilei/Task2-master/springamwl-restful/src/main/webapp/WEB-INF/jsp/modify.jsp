<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: summerwaves
  Date: 2017/9/18
  Time: 10:16
  To change this template use File | Settings | File Templates.
--%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<html>
<head>
    <title>更新学员</title>
</head>
<body>
<form action="${ctx}/student/{id}" method="post">
    <input type="hidden" name="_method" value="PUT">
    学生序号：<input type="text" name="id" value="${student.id}"/><br/>
    学生姓名：<input type="text" name="Name" value="${student.name}"/><br/>
    学生性别：<input type="text" name="Sex" value="${student.sex}"/><br/>
    学 生 QQ：<input type="text" name="QQ" value="${student.qq}"/><br>
    毕业学校：<input type="text" name="Graduate" value="${student.graduate}"/><br/>
    学生学号：<input type="text" name="Number" value="${student.number}"/><br/>
    个性签名：<input type="text" name="Autograph" value="${student.autograph}"/><br/>
    <input type="submit" name="注册" value="更新学员">
</form>
</body>
</html>
