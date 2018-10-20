<!--注意isELIgnored是选择EL表达式是否输出-->
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="java.util.*" isELIgnored="false" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html>
<head>
    <title>个人信息展示</title>
</head>
<h2 align="center">个人信息展示</h2>
<body>
<table align="center" border="1" cellspacing="0">
    <tr size="4">
        <td width="100" align="right"><strong>姓名</strong></td>
        <td width="200" alian="left">${student.name}</td>
        <td align="center" height="250" width="200">
            <img height="200" width ="150" alt="您还没有上传头像" src= "${student.image}"/>
            <button type="button"><a href="${pageContext.request.contextPath}/u/updateImage">修改头像</a></button>
        </td>
    </tr>
    <tr>
        <td align="right"><strong>职业</strong></td>
        <td alian="left">${student.profession}</td>
        <td align="center"></td>
    </tr>
    <tr>
        <td align="right"><strong>开始时间</strong></td>
        <td alian="left"><date:date value ="${student.startTime}"/></td>
        <td align="center"></td>
    </tr>
    <tr>
        <td align="right"><strong>学号</strong></td>
        <td alian="left">${student.stuNumber}</td>
        <td align="center"></td>
    </tr>
    <tr>
        <td align="right"><strong>在学状态</strong></td>
        <td alian="left">${student.status}</td>
        <td align="center"></td>
    </tr>
    <tr>
        <td align="right"><strong>手机号码</strong></td>
        <td alian="left">${student.telephone}</td>
        <td align="center"><button type="button"><a href="${pageContext.request.contextPath}/u/bindPhone">绑定修改手机</a></button></td>
    </tr>
    <tr>
        <td align="right"><strong>邮箱</strong></td>
        <td alian="left">${student.email}</td>
        <td align="center"><button type="button"><a href="${pageContext.request.contextPath}/u/bindEmail">绑定邮箱</a></button></td>
        <td></td>
    </tr>
    <tr>
        <td colspan="3" align="center"><button type="button" ><a href="${pageContext.request.contextPath}/homepage">返回首页</a></button></td>
    </tr>
</table>
</body>
</html>
