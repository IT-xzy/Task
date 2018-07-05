<%--
  Created by IntelliJ IDEA.
  User: zpyt5
  Date: 2018/5/10
  Time: 10:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="zhang" method="get">
    <input type="hidden" name="id" value="${user.id}">
    姓名：<br>
    <input type="text" name="name" value="${user.name}"><br>
    qq：<br>
    <input type="text" name="qq" value="${user.qq}"><br>
    修真类型：<br>
    <input type="text" name="type" value="${user.type}"><br>
    入学时间：<br>
    <input type="date" name="entranceTime" value="${user.entranceTime}"><br>
    毕业学校：<br>
    <input type="text" name="school" value="${user.school}"><br>
    学号：<br>
    <input type="text" name="onlineNum" value="${user.onlineNum}"><br>
    日报连接：<br>
    <input type="text" name="dailyLink" value="${user.dailyLink}"><br>
    志愿：<br>
    <input type="text" name="wish" value="${user.wish}"><br>
    师兄：<br>
    <input type="text" name="brother" value="${user.brother}"><br>
    哪里获知：<br>
    <input type="text" name="whereKnown" value="${user.whereKnown}"><br>
    创建时间：<br>
    <input type="date" name="create_at" value="${user.create_at}"><br>
    修改时间：<br>
    <input type="date" name="update_at" value="${user.update_at}"><br>
    <br>
    <input type="submit" value="修改"> <br>
</form>

</body>
</html>