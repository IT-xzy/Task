<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="java.util.*"%>
<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Edit Student</title>
</head>
<div style="text-align:center">
    请输入需要修改的数据，点击修改按钮
</div>
<body>
<br>
<div>
    <form action="${pageContext.request.contextPath}/student/upd" method="post" >
        <%--将这个表单的post方法改为隐藏的put方法，变为rest风格--%>
        <%--<input type="hidden" name="_method" value="put">--%>
        <table align='center'>

            <tr>
                <td>studyId:${student.studyId}</td>
                <%--<td>${student.studyId}</td>--%>
                <td><input type="text" name="studyId" value="${student.studyId}"><br/></td>
            </tr>
            <tr>
                <td>dailyLink:</td>
                <td><input type="text" name="dailyLink" value="${student.dailyLink}"><br/></td>
            </tr>
            <tr>
                <td>slogen:</td>
                <td><input type="text" name="slogen" value="${student.slogen}"><br/></td>
            </tr>
            <tr>
                <td>master:</td>
                <td><input type="text" name="master" value="${student.master}"><br/></td>
            </tr>
            <%--<tr>--%>
                <%--<td><input type="submit" value="点击修改"></td>--%>
            <%--</tr>--%>
            <tr>
                <td><input style="background-color: #ff5050;"
                           type="button" value="修改" onclick="submit()"></td>
            </tr>
        </table>
    </form>
</div>
</table>
<br>
<br>

</body>