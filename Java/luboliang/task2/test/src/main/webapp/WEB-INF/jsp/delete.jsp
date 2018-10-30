<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" isErrorPage="true" %>

  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/9/13
  Time: 21:57
  To change this template use File | Settings | File Templates.


<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/students/${id}" name="student" method="post">
    <input type="hidden" name="_method" value="DELETE">
    姓名：<input type="text" name="name" value="${student.name}"/> <br>
    更新时间：<input type="text" name="update_at" value="${student.update_at}"/> <br>
    QQ:<input type="text" name="qq" value="${student.qq }"/> <br>
    课程类型:<input type="text" name="course_type" value="${student.course_type}"/> <br>
    入学时间:<input type="text" name="entrance_time" value="${student.entrance_time}"/> <br>
    毕业学校:<input type="text" name="graduate_school" value="${student.graduate_school}"/> <br>
    线上学号:<input type="text" name="wish" value="${student.wish}"/> <br>
    日报:<input type="text" name="daily_link" value="${student.daily_link}"/> <br>
    愿望:<input type="text" name="set_to" value="${student.set_to}"/> <br>
    师兄:<input type="text" name="brother" value="${student.brother}"/> <br>
    何处了解:<input type="text" name="learn" value="${student.learn}"/> <br>
    <input type="submit" value="删除"><br>
</form>
</body>
</html>
