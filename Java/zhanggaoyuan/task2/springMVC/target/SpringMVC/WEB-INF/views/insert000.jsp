<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/10/16
  Time: 19:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/students" method="POST">
    请输入新增学员的信息:<br>
    <%--<input type="hidden" name="_method" value="DELETE" /><br>--%>
    <%--创建时间 :<input type="text" name="createAt" value="">--%>
    <%--<br>--%>
    <%--更新时间:<input type="text" name="updateAt" value="">--%>
    <br>
    姓名 :<input type="text" name="studentName" value="苏正荣">
    <br>
    QQ :<input type="text" name="qq" value="2210126316">
    <br>
    修真类型 :<input type="text" name="profession" value="Android工程师">
    <br>
    预计入学时间 :<input type="text" name="admissionDate" value="11">
    <br>
    毕业院校 :<input type="text" name="graduatedFrom" value="1">
    <br>
    线上学号 :<input type="text" name="studentId" value="221">
    <br>
    日报链接 :<input type="text" name="dailyLink" value="12">
    <br>
    立愿  :<input type="text" name="makeWishes" value="121">
    <br>
    辅导师兄 :<input type="text" name="coachingSenior" value="12">
    <br>
    从何处了解到修真院 :<input type="text" name="approach" value="12">
    <br>
    <br>
    <input type="submit" value="提交">
</form>
</body>
</html>
