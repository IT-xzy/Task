<%--
  Created by IntelliJ IDEA.
  User: 孙若飞
  Date: 2019/1/8
  Time: 14:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加</title>
</head>
<body>
<h1> 添加用户</h1>
<form action="/student" name="student" method=post>
    姓名<input type="text" name="name">
    QQ<input type="text" name="qq">
    修真类型<input type="text" name="type">
    入学日期<input type="text" name="admission_date">
    毕业院校<input type="text" name="graduate_school">
    学号<input type="text" name="student_number">
    日报链接<input type="text" name="daily_link">
    愿望<input type="text" name="wish">
    辅导师兄<input type="text" name="instructor">
    信息来源<input type="text" name="information_source">
    <input type="submit" value="添加" >
    <td><a href="/listtable">返回页面</a></td>
</form>

</body>
</html>
