<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Yzzzt
  Date: 2018/5/25
  Time: 23:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>新增信息</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/rest/add" method="post">
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
            <label for="major">修真类型：</label>
            <input type="text" id="major" name="major" style="width: 100px;">
        </p>
        <p>
            <label for="startTime">预计入学时间：</label>
            <input type="text" id="startTime" name="startTime">
        </p>
        <p>
            <label for="school">毕业学校：</label>
            <input type="text" id="school" name="school" style="width: 120px;">
        </p>
        <p>
            <label for="student_Id">线上学号：</label>
            <input type="text" id="student_Id" name="student_Id" style="width: 65px;">
        </p>
        <p>
            <label for="daily_cone">日报连接：</label>
            <input type="text" id="daily_cone" name="daily_cone">
        </p>
        <p>
            <label for="desire">立愿：</label>
            <input type="text" id="desire" name="desire">
        </p>
        <p>
            <label for="bre">辅导师兄：</label>
            <input type="text" id="bre" name="bre" style="width: 65px;">
        </p>
        <p>
            <label for="know_from">从哪里知道：</label>
            <input type="text" id="know_from" name="know_from" style="width: 80px;">
        </p>
        <input type="submit" value="提交">
    </fieldset>
</form>

</body>
</html>
