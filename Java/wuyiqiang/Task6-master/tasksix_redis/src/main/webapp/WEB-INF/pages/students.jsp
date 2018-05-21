<%--
  Created by IntelliJ IDEA.
  User: yiqia
  Date: 2018/2/3 0003
  Time: 14:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>学生信息</title>
    <c:if test="${0==flag}" var="condition" scope="request">
        <script>
            alert("失败");
        </script>
    </c:if>
    <c:if test="${0!=flag&&null!=flag}" var="condition" scope="request">
        <script>
            alert("成功");
        </script>
    </c:if>
</head>
<body>
    <h1>学生信息</h1>
    <form action="/student/itschool/students/student" method="get">
        <input name="id" type="text" placeholder="请输入查询ID" required="required">
        <input type="submit" value="查找">
    </form>
    <a href="/student/itschool/students">****查看所有****</a>
    <a href="/student/itschool/students/profile">****添加****</a>
    <a href="/student/itschool/menu">****返回目录****</a>

    <table border="1" width="100%">
        <thead>
        <tr>
            <td>ID：</td>
            <td>姓名：</td>
            <td>QQ：</td>
            <td>修真类型：</td>
            <td>预计入学时间：</td>
            <td>毕业学校：</td>
            <td>线上（jnshu.com）学号：</td>
            <td>日报链接：</td>
            <td>立愿：</td>
            <td>辅导师兄：</td>
            <td>从何处了解到修真院：</td>
            <td colspan="2">设置</td>
        </tr>
        </thead>
        <c:forEach items="${students}" var="student">
            <tr>
                <td>${student.id}</td>
                <td>${student.name}</td>
                <td>${student.qq}</td>
                <td>${student.type}</td>
                <td>${student.stime}</td>
                <td>${student.graschool}</td>
                <td>${student.classnum}</td>
                <td>${student.link}</td>
                <td>${student.mentor}</td>
                <td>${student.conbrother}</td>
                <td>${student.hknow}</td>
                <td><a href="/student/itschool/students/profile/${student.id}">更新</a></td>
                <td><a href="/student/itschool/students/${student.id}">删除</a></td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
