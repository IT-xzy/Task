<%--
  Created by IntelliJ IDEA.
  User: 孙若飞
  Date: 2019/1/15
  Time: 21:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>更新</title>
</head>
<body>
<%--action是路径--%>
<form action="/student" name="student" method="post">
    <input type="hidden" name="_method" value="put">
    <%--隐藏起来id，在页面上不显示--%>
    <input type="hidden" value="${student.id}" name="id">
    姓名：<input type="text" name="name" value="${student.name}">
    qq：<input type="text" name="qq" value="${student.qq}">
    修真类型<input type="text" name="type" value="${student.type}">
    入学日期<input type="text" name="admission_date" value="${student.admission_date}">
    毕业院校<input type="text" name="graduate_school" value="${student.graduate_school}">
    学号<input type="text" name="student_number" value="${student.student_number}">
    日报链接<input type="text" name="daily_link" value="${student.daily_link}">
    愿望<input type="text" name="wish" value="${student.wish}">
    辅导师兄<input type="text" name="instructor" value="${student.instructor}">
    信息来源<input type="text" name="information_source" value="${student.information_source}">
    <input type="submit" value="修改">
    <td><a href="/page">返回页面</a></td>
</form>
</body>
</html>
