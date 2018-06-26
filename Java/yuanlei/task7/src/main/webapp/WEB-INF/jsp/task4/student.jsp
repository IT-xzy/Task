<%--
  Created by IntelliJ IDEA.
  User: LL
  Date: 2018/4/18
  Time: 14:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="java.util.*"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>介绍</title>
</head>
<body>
<h3>已成功得道学员介绍</h3>
<h4><a href="/home">返回主页面</a> </h4>
<table align='center' border='1' width="100%" cellspacing='0'>
<tr>
    <th>姓名</th>
    <th>名言</th>
</tr>
   <tr>
    <td>${student.name}</td>
    <td>${student.declaration}</td>
   </tr>
</table>
</body>
</html>
