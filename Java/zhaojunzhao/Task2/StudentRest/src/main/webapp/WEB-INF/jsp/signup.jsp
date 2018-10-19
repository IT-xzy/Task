<%--
  Created by IntelliJ IDEA.
  User: TwT
  Date: 2018/9/13
  Time: 14:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <title>sign up</title>
</head>
<body>
<h1>输入要添加学生的信息</h1>
<form action="/StudentRest/student" method="post">
    姓名: <input type="text" name="name"><br/>
    QQ: <input type="text" name="qq"><br/>
    修真类型: <input type="text" name="type"><br/>
    入学时间: <input type="text" name="timeOf"><br/>
    毕业院校：<input type="text" name="gradeSchool"><br/>
    线上学号：<input type="text" name="onlineId"><br/>
    日报连接：<input type="text" name="link"><br/>
    立愿：<input type="text" name="wish"><br/>
    师兄：<input type="text" name="fellow"><br/>
    了解渠道：<input type="text" name="understand"><br/>
    <input type="submit" value="Submit">
</form>
</body>
</html>
