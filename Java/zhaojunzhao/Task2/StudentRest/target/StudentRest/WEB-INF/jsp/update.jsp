
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>输入要更新的id为${id}的学生的信息</h1>
    <form action="/StudentRest/student/${id}" method="post">
        <input type="hidden" name="_method" value="put">
        <select name="key">
            <option value="name">姓名</option>
            <option value="qq">QQ</option>
            <option value="type">修真类型</option>
            <option value="timeOf">入学时间</option>
            <option value="gradeSchool">毕业院校</option>
            <option value="onlineID">线上学号</option>
            <option value="link">日报连接</option>
            <option value="wish">立愿</option>
            <option value="fellow">师兄</option>
            <option value="understand">了解渠道</option>
        </select>
        <input type="text" name="value"><br>
        <input type="submit" value="提交">
    </form>
</body>
</html>
