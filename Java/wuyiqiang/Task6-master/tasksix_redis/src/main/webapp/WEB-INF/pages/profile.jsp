<%--
  Created by IntelliJ IDEA.
  User: yiqia
  Date: 2018/2/3 0003
  Time: 18:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>学生信息</title>
</head>
<body>
<h1>学生信息</h1>
    <c:if test="${student==null}" var="condition" scope="request">
        <form action="/student/itschool/students" name="student" method="post">
    </c:if>

    <c:if test="${student!=null}" var="condition" scope="request">
        <form action="/student/itschool/students/${student.id}" name="student" method="post">
    </c:if>
            姓名： <input name="name" type="text" value="${student.name}" required="required"><br/>
            Q  Q： <input name="qq" type="text" value="${student.qq}" required="required"><br/>
            修真类型： <input name="type" type="text" value="${student.type}" required="required"><br/>
            预计入学时间： <input name="stime" type="text" value="${student.stime}" required="required"><br/>
            毕业学校： <input name="graschool" type="text" value="${student.graschool}" required="required"><br/>
            线上（jnshu.com）学号： <input name="classnum" type="text" value="${student.classnum}" required="required"><br/>
            日报链接： <input name="link" type="text" value="${student.link}" required="required"><br/>
            立愿： <input name="mentor" type="text" value="${student.mentor}" required="required"><br/>
            辅导师兄： <input name="conbrother" type="text" value="${student.conbrother}" required="required"><br/>
            从何处了解到修真院： <input name="hknow" type="text" value="${student.hknow}" required="required"><br/>
            <a href="/student/itschool/students">返回</a>
            <input type="submit" value="提交">
        </form>
</body>
</html>
