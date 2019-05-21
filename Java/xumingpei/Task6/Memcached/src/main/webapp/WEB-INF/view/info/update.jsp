<%--
  Created by IntelliJ IDEA.
  User: Shinelon
  Date: 2019/4/29
  Time: 17:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" import="java.util.*"%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>更新页面</title>
</head>
<body>
<div style="text-align:center;margin-top:40px">
    <form method="post" action="/u/student/${student.id}">
        <input type="hidden" name="_method" value="PUT" /><br>
        学生名字：<input name="name" value="${student.name}" type="text"> <br><br>
        学生介绍: <input name="introduction" value="${student.introduction}" type="text"> <br><br>
        学生岗位：<input name="position" value="${student.position}" type="text"> <br><br>
        学生头像：<input name="img" value="${student.img}" type="text"> <br><br>
        学生薪水：<input name="salary" value="${student.salary}" type="text"> <br><br>
        <input type="submit" value="更新">
        <input name="status" value="${student.status}" value="0" type="hidden"> <br><br>
        <input name="createAt" value="${student.createAt}" type="hidden"> <br><br>
        <input name="updateAt" value="${student.updateAt}" type="hidden"> <br><br>
        <input name="createBy"  value="xmp" type="hidden"> <br><br>
        <br>
    </form>
</div>
</body>
</html>
