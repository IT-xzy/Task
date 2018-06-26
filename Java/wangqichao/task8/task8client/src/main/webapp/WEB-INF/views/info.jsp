<%--
  Created by IntelliJ IDEA.
  User: thinkpad
  Date: 2018/5/25
  Time: 19:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="java.util.*" isELIgnored="false"  %>
<%@ taglib uri="/tags" prefix="date"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
    <title>个人信息</title>
</head>
<body>
<table align="center" border="1" cellspacing="0">
    <tr size="4">
        <td width="300" align="right"><strong>姓名</strong></td>
        <td width="400" alian="left">${student.name}</td>
        <td width="300" align="center"><button type="button"><a href="${pageContext.request.contextPath}/u/goPassword">修改密码</a></button></td>
    </tr>
    <tr>
        <td align="right"><strong>头像</strong></td>
        <td alian="left"><img src="${student.image}" width="120" height="200"></td>
        <td align="center"><button type="button"><a href="${pageContext.request.contextPath}/u/a/goimage">修改头像</a></button></td>
    </tr>
    <tr>
        <td align="right"><strong>职业</strong></td>
        <td alian="left">${student.profession}</td>
        <td align="center"></td>
    </tr>
    <tr>
        <td align="right"><strong>开始时间</strong></td>
        <td alian="left"><date:date value ="${student.createdAt} "/></td>
        <td align="center"></td>
    </tr>
    <tr>
        <td align="right"><strong>学号</strong></td>
        <td alian="left">${student.studentID}</td>
        <td align="center"></td>
    </tr>
    <tr>
        <td align="right"><strong>在学状态</strong></td>
        <td alian="left">${student.isWorked}</td>
        <td align="center"></td>
    </tr>
    <tr>
        <td align="right"><strong>手机号码</strong></td>
        <td alian="left">${student.telephone}</td>
        <td align="center"><button type="button"><a href="${pageContext.request.contextPath}/u/a/boundtel">绑定修改手机</a></button></td>
    </tr>
    <tr>
        <td align="right"><strong>邮箱</strong></td>
        <td alian="left">${student.email}</td>
        <td align="center"><button type="button"><a href="${pageContext.request.contextPath}/u/a/boundemail">绑定邮箱</a></button></td>
        <td></td>
    </tr>
</table>
</body>
</html>
