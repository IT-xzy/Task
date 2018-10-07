<%--
  Created by IntelliJ IDEA.
  User: zyq
  Date: 2018/6/14
  Time: 15:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page  isELIgnored = "false" contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3 align="center">学生信息修改</h3>
<c:forEach items="${page.list}" var="student">
    <div align="center">
        <form action="/u/Student/${student.id}?currPage=${page.currPage}" method="post">
            <input type="hidden" name="_method" value="PUT">
            姓名：<input type="text" name="name" value="${student.name}"><br>
            企鹅号：<input type="text" name="qq" value="${student.qq}"><br>
            专业：<input type="text" name="profession" value="${student.profession}"><br>
            毕业院校：<input type="text" name="university" value="${student.university}"><br>
            学号：<input type="text" name="number" value="${student.number}"><br>
            日报链接：<input type="text" name="daily" value="${student.daily}"><br>
            师兄：<input type="text" name="senior" value="${student.senior}"><br>
            渠道：<input type="text" name="from" value="${student.from}"><br>
            <input type="hidden" name="createTime" value="${student.createTime}">
            <input type="hidden" name="name2" value="${name}">
            <input type="hidden" name="number2" value="${number}">
            <button type="submit">确认修改</button>
        </form>
    </div>
</c:forEach>
</body>
</html>
