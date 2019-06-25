<%--
  Created by IntelliJ IDEA.
  User: 老王
  Date: 2019/4/26
  Time: 18:12
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
    <br/>姓名: <input type="text" name="name" value="${student.name}">
    <br/>QQ: <input type="text" name="qq" value="${student.qq}">
    <br/>修真类型: <input type="text" name="type" value="${student.type}">
    <br/>入学日期: <input type="text" name="estimatedtime" value="${student.estimatedtime}">
    <br/>毕业院校: <input type="text" name="school" value="${student.school}">
    <br/>方式: <input type="text" name="manner" value="${student.manner}">
    <br/>学号: <input type="text" name="number" value="${student.number}">
    <br/>日报: <input type="text" name="daily" value="${student.daily}">
    <br/>愿望：<input type="text" name="wish" value="${student.wish}">
    <br/>辅导: <input type="text" name="counselor" value="${student.counselor}">
    <br/>来源: <input type="text" name="source" value="${student.source}">
    <br/>创建: <input type="text" name="create_at" value="${student.create_at}">
    <br/>更新: <input type="text" name="update_at" value="${student.update_at}">
    <br/><input type="submit" value="修改">
    <td><a href="/table">返回页面</a></td>
</form>

</body>
</html>