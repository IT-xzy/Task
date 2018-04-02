<%--
  Created by IntelliJ IDEA.
  User: 52840
  Date: 2017/12/14
  Time: 11:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

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
    <title>修改学生信息</title>
</head>
<body>
<form id="itemForm" action="${pageContext.request.contextPath}/student/id" method="post">
    <input type="hidden" name="_method" value="PUT"/>
    <input type="hidden" name="id" value="${newstudent.id}"/>
    <font size=7>${newstudent.id}号修改</font>
    <table width="40%" >
        <tr>
            <td>学生名字</td>
            <td><input type="text" name="name" value="${newstudent.name}"/></td>
        </tr>
        <tr>
            <td>QQ号码</td>
            <td><input type="text" name="QQ" value="${newstudent.QQ} "/></td>
        </tr>

        <tr>
            <td>修真专业</td>
            <td><input type="text" name="major" value="${newstudent.major}"/></td>
        </tr>
        <tr>
            <td>毕业院校</td>
            <td><input type="text" name="gra_school" value="${newstudent.gra_school}"></td>
        </tr>
        <tr>
            <td>在线学号</td>
            <td><input type="text" name="online_id" value="${newstudent.online_id}"></td>
        </tr>
        <tr>
            <td>日报链接</td>
            <td><input type="text" name="daily_link" value="${newstudent.daily_link}"></td>
        </tr>
        <tr>
            <td>辅导师兄</td>
            <td><input type="text" name="bro" value="${newstudent.bro}"></td>
        </tr>
        <tr>
            <td>从哪里知道修真院</td>
            <td><input type="text" name="know_from" value="${newstudent.know_from}"></td>
        </tr>
        <tr>
            <td>学习愿望</td>
            <td><input type="text" name="desire" value="${newstudent.desire}"></td>
        </tr>
        <tr>
            <td>预计到校时间</td>
            <td><input type="date" name="entry_time" value="<fmt:formatDate value="${newdate}" pattern="yyyy-MM-dd"/>"></td>
        </tr>

        <tr>
            <td colspan="2" align="center"><input type="submit" value="提交"/>
            </td>
        </tr>
    </table>
</form>
</body>
</html>
