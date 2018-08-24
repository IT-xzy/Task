<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
%>
<%@page deferredSyntaxAllowedAsLiteral="true"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
        <title>查询结果</title>
    </head>
    <body>
    <h3><center><font color="#dc143c" size="10">查询结果</font></center></h3>
    <form name="input" action="/idResult"  method="get">
        <center>输入ID: <input type="number" name="id">
        <input type="submit" value="提交"></center>
    </form>
    <table width="300px" border="1" cellpadding="0" cellspacing="0" align="center">
        <tr>
            <td><center>ID</center></td>
            <td><center>姓名</center></td>
            <td><center>QQ</center></td>
            <td><center>修真类型</center></td>
            <td><center>入学时间</center></td>
            <td><center>毕业学校</center></td>
            <td><center>线上学号</center></td>
            <td><center>日报链接</center></td>
            <td><center>立愿</center></td>
            <td><center>审核师兄</center></td>
            <td><center>了解途径</center></td>
        </tr>
        <tr>
            <td><center>${find.id}</center></td>
            <td><center>${find.name}</center></td>
            <td><center>${find.qq}</center></td>
            <td><center>${find.studyType}</center></td>
            <td><center>${find.enrollment}</center></td>
            <td><center>${find.graduateSchool}</center></td>
            <td><center>${find.studentNum}</center></td>
            <td><center>${find.dailyLink}</center></td>
            <td><center>${find.wish}</center></td>
            <td><center>${find.checkBro}</center></td>
            <td><center>${find.knowWay}</center></td>
        </tr>
</table>

    <center><a href="/index">返回首页</a></center>
    <center>Power By Resin</center>
</body>
</html>