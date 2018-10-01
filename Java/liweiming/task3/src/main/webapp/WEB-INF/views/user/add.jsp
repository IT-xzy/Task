<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018\6\9 0009
  Time: 10:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+
            request.getServerName()+":"+request.getServerPort()+path+"/";%>

<!doctype html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">

    <base href="<%=basePath%>">
    <title>添加用户</title>
</head>
<body>
<form action="<%=basePath%>user/add" method="post">
    <fieldset>
        <legend>新增学生</legend>
        <p>
            <label for="name">名字: </label>
            <input type="text" id="name" name="name" style="width: 70px;">
        </p>
        <p>
            <label for="QQ">QQ：</label>
            <input type="text" id="QQ" name="QQ" style="width: 100px;">
        </p>
        <p>
            <label for="learning_type">学习类型：</label>
            <input type="text" id="learning_type" name="learning_type" style="width: 100px;">
        </p>
        <p>
            <label for="entrance_time">入学时间：</label>
            <input type="text" id="entrance_time" name="entrance_time">
        </p>
        <p>
            <label for="school">毕业学校：</label>
            <input type="text" id="school" name="school" style="width: 120px;">
        </p>
        <p>
            <label for="online_id">线上学号：</label>
            <input type="text" id="online_id" name="online_id" style="width: 65px;">
        </p>
        <p>
            <label for="daily_link">日报连接：</label>
            <input type="text" id="daily_link" name="daily_link">
        </p>
        <p>
            <label for="wish">立愿：</label>
            <input type="text" id="wish" name="wish">
        </p>
        <p>
            <label for="tutor">辅导师兄：</label>
            <input type="text" id="tutor" name="tutor" style="width: 65px;">
        </p>
        <input type="submit" value="提交">
    </fieldset>
</form>
</body>
</html>
