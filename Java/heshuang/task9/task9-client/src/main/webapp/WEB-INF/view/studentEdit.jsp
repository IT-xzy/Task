<%@page pageEncoding="UTF-8" contentType="text/html;charset=utf-8" isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1,minimum-scale=1.0,  maximum-scale=1">
    <link rel="stylesheet" type="text/css" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link type="text/css" rel="stylesheet" href="../../static/css/task9-3.css">
    <title>由id学生信息表</title>
</head>
<body>
<div style="text-align: center;height: auto;">
<form action="/u/Student" method="post">
    <%--<label style="width: 20px;text-align: right"></label>--%>
    <br>
        <br>
    &emsp;id：<input name="id" value="${student.id}" type="text">
    创建时间：<input name="create_at" value="${student.create_at}" type="text">
    姓名：<input name="name" value="${student.name}" type="text">
    QQ：<input name="qq" value="${student.qq}" type="text"><br>
    &thinsp;职业：<input name="professional" value="${student.professional}" type="text">
    开始时间：<input name="start_time" value="${student.start_time}" type="text">
    大学：<input name="university" value="${student.university}" type="text">
    学号：<input name="online_id" value="${student.online_id}" type="text"><br>
    &thinsp;日报：<input name="daily_url" value="${student.daily_url}" type="text">
    入学宣言：<input name="oath" value="${student.oath}" type="text">
    师兄：<input name="counselor" value="${student.counselor}" type="text">
    城市：<input name="city" value="${student.city}" type="text"><br>
    <input type="hidden" value="put" name="_method"><br>
    <input type="submit" value="修改">
</form>
</div>
</body>
</html>