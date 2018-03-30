<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: 52840
  Date: 2017/12/14
  Time: 11:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style type="text/css">

        table
        {
            border-collapse:collapse;
        }
        table, td, th
        {
            border:1px solid black;
        }

    </style>
    <title>新增学生信息 </title>
</head>
<%
    Date date = new Date();
%>
<body>
<form id="itemForm" action="${pageContext.request.contextPath}/student/new" method="post">
    <input type="hidden" name="assesid" value="1"/>
    <font size=7>新增学生信息</font>
    <table width="40%" >
        <tr>
            <td>学生名字</td>
            <td><input type="text" name="name" value="希尔瓦娜斯"/></td>
        </tr>
        <tr>
            <td>QQ号码</td>
            <td><input type="text" name="QQ" value="520"/></td>
        </tr>
        <tr>
            <td>修真专业</td>
            <td><input type="text" name="major" value="death"/></td>
        </tr>
        <tr>
            <td>毕业院校</td>
            <td><input type="text" name="gra_school" value="幽暗城"></td>
        </tr>
        <tr>
            <td>在线学号</td>
            <td><input type="text" name="online_id" value="death1"></td>
        </tr>
        <tr>
            <td>日报链接</td>
            <td><input type="text" name="daily_link" value="www.wow.com"></td>
        </tr>
        <tr>
            <td>辅导师兄</td>
            <td><input type="text" name="bro" value="萨尔"></td>
        </tr>
        <tr>
            <td>从哪里知道修真院</td>
            <td><input type="text" name="know_from" value="奥格瑞玛"></td>
        </tr>
        <tr>
            <td>学习愿望</td>
            <td><input type="text" name="desire" value="为了部落!"></td>
        </tr>
        <tr>
            <td>预计到校时间</td>
            <td><input type="date" name="entry_time" value="<fmt:formatDate value="<%=date%>" pattern="yyyy-MM-dd"/>"></td>
        </tr>

        <tr>
            <td colspan="2" align="center">
                <input type="submit" value="提交"/>
            </td>
        </tr>
    </table>
</form>
</body>
</html>

