<%--
  Created by IntelliJ IDEA.
  User: x1c
  Date: 2018/7/5
  Time: 10:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>增加学员</title>
</head>
<body>
<form action="${pageContext.request.contextPath }/student/adds" method="post">
    <br>姓名<input type="text" name="name">
    <br>QQ<input type="text" name="qq">
    <br>类型<input type="text" name="type">
    <br>入学时间<input type="text" name="enrolmenttime">
    <br>毕业于<input type="text" name="graduated">
    <br>数目<input type="text" name="number">
    <br>日报<input type="text" name="daily">
    <br>立志<input type="text" name="ambition">
    <br>负责的<input type="text" name="responsible">
    <br>来自于<input type="text" name="wfrom">
    <br>电话<input type="text" name="telipone">
    <br>邮箱<input type="text" name="email">
    <br>肖像<input type="text" name="portrait">
    <br>创建时间<input type="text" name="create_at">
    <br>更新时间<input type="text" name="update_at">
    <input type="submit" name="注册">
</form>
</body>
</html>
