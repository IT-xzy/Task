<%--
  Created by IntelliJ IDEA.
  User: Joe
  Date: 2018/11/3
  Time: 14:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1 style="text-align: center">输入要更新的id为${id}的学生的信息</h1>
<div style="position: relative;margin: 0 auto;width: 30rem">
    <form action="/Tiles/u/student/${id}" method="post">
        <input type="hidden" name="_method" value="put">
        <select name="key">
            <option value="name">姓名</option>
            <option value="qq">QQ</option>
            <option value="type">修真类型</option>
            <option value="time_of">入学时间</option>
            <option value="grade_school">毕业院校</option>
            <option value="online_id">线上学号</option>
            <option value="link">日报连接</option>
            <option value="wish">立愿</option>
            <option value="fellow">师兄</option>
            <option value="understand">了解渠道</option>
        </select>
        <input type="text" name="value"><br>
        <input type="submit" value="提交">
    </form>
</div>
</body>
</html>