<%--
  Created by IntelliJ IDEA.
  User: TwT
  Date: 2018/9/14
  Time: 17:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>全部学生信息</h1>
    <table border="1">
        <c:forEach items="${pageInfo.list}" var="stu">
            <tr>
                <td>${stu.id}</td>
                <td>${stu.name}</td>
                <td>${stu.qq}</td>
                <td>${stu.type}</td>
                <td>${stu.timeOf}</td>
                <td>${stu.gradeSchool}</td>
                <td>${stu.onlineId}</td>
                <td>${stu.link}</td>
                <td>${stu.wish}</td>
                <td>${stu.fellow}</td>
                <td>${stu.understand}</td>
                <td>${stu.createAt}</td>
                <td>${stu.updateAt}</td>
                <td>
                    <form action="/StudentRest/student/${stu.id}" method="post">
                        <input type="hidden" name="_method" value="delete">
                        <input type="submit" value="删除">
                    </form>
                </td>
                <td>
                    <form action="/StudentRest/student/update/${stu.id}" method="post">
                        <input type="submit" value="更新">
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>
    <a href="/StudentRest/student/add">添加</a><br>
    <a href="/StudentRest/student/page/${pageInfo.prePage}">上一页</a>
    <a href="/StudentRest/student/page/${pageInfo.nextPage}">下一页</a>
    <scan>共${pageInfo.pages}页</scan>
</body>
</html>
