<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
        <title>所有用户所有信息</title>
    </head>
    <body>
    <h3><center><font color="#dc143c" size="10">所有用户所有信息</font></center></h3>
    <center><a href="/index">返回首页</a>
        <a href="add.jsp">新增数据</a>
    </center>

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
            <td><center>操作</center></td>
        </tr>
        <c:forEach var="list"  items="${addLists}">
        <tr>
            <td><center>${list.id}</center></td>
            <td><center>${list.name}</center></td>
            <td><center>${list.qq}</center></td>
            <td><center>${list.studyType}</center></td>
            <td><center>${list.enrollment}</center></td>
            <td><center>${list.graduateSchool}</center></td>
            <td><center>${list.studentNum}</center></td>
            <td><center>${list.dailyLink}</center></td>
            <td><center>${list.wish}</center></td>
            <td><center>${list.checkBro}</center></td>
            <td><center>${list.knowWay}</center></td>
            <td><center><a href="modify.do?id=${list.id}">更新</a>    <a href="del.do?id=${list.id}">删除</a></center></td>
        </tr>
        </c:forEach>
</table>


</body>
</html>