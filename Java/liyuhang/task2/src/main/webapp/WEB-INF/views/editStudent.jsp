
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/11/22
  Time: 17:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="java.util.*"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<html>
<head>
    <title>学生编辑页面</title>
</head>
<body>
<div style="width:500px;margin:0px auto;text-align:center">
    <div style="text-align: center;margin-top: 40px">
        <form method="post" action="/student">
            <input type="hidden" name="_method" value="PUT">
            学生学号：<input name="studentNumber" value="${student.studentNumber}" type="text" style="min-width:12%;"> <br><br>
            学生名字：<input name="name" value="${student.name}" type="text" style="min-width:12%;"> <br><br>
            学生QQ：<input name="qq" value="${student.qq}" type="text" style="min-width:12%;"> <br><br>
            入门誓言：<input name="wish" value="${student.wish}" type="text" style="min-width:12%;"> <br><br>
            毕业院校：<input name="school" value="${student.school}" type="text" style="min-width:12%;"> <br><br>
            入学时间：<input name="enrolmentTime" value="${student.school}" type="date" style="min-width:30%;"> <br><br>
            修真类型： <select name="type" style="min-width:30%;">
            <option value="java">java</option>
            <option value="css">css</option>
            <option value="ui">ui</option>
            <option value="运营">运营</option>
            <option value="测试">测试</option>
            <option value="动画师">动画师</option>
            <option value="js">js</option>
            <option value="python">python</option>
            <option value="Android">Android</option>
            <option value="ios">ios</option>
            <option value="op">op</option>
        </select> <br><br>
            了解渠道：<input name="knowFrom" value="${student.knowFrom}" type="text" style="min-width:12%;"> <br><br>
            <input type="submit" value="编辑学生信息" style="min-width:10%;">
            <input type="hidden" value="${student.id}" name="id">
            <input type="hidden" value="${student.createAt}" name="createAt">
            <input type="hidden" value="<%=System.currentTimeMillis()%>" name="updateAt">
        </form>
    </div>
</div>
</body>
</html>

