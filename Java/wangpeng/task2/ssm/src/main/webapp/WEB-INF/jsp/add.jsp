<%--
  Created by IntelliJ IDEA.
  User: 老王
  Date: 2019/4/26
  Time: 18:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>增</title>
</head>
<body>

<form action="/student" name="student" method=post>
    <%--<input type="hidden" value="${q.id}" name="id">--%>
    <br/>姓名：<input type="text" name="name">
    <br/>qq：<input type="text" name="qq">
    <br/>修真类型：<input type="text" name="type">
    <br/>入学日期：<input type="text" name="estimatedtime">
    <br/>毕业院校：<input type="text" name="school">
    <br/>方式：<input type="text" name="manner">
    <br/>学号：<input type="text" name="number">
    <br/>日报：<input type="text" name="daily">
    <br/>愿望：<input type="text" name="wish">
    <br/>辅导：<input type="text" name="counselor">
    <br/>来源：<input type="text" name="source">
    <br/>创建：<input type="text" name="create_at">
    <br/>更新：<input type="text" name="update_at">
    <br/><input type="submit" value="添加">
    <td><a href="/table">返回页面</a></td>
    <%--td是一列,tr是一行,href 属性规定链接的目标,
    <a href="/listtable">指向/listtable超链接的--%>
</form>

</body>
</html>
