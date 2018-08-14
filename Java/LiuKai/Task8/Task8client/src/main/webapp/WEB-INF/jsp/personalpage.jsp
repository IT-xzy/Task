<%--
  Created by IntelliJ IDEA.
  User: Liu Kai
  Date: 2018/8/3
  Time: 15:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div>
    <p>姓名：<span>${student.stuName}</span></p>
    <p>电话：<span>${student.phoneNum}</span></p>
    <p>个人头像</p><br>
    <img src="${student.stuImage}">
<form action="/u/student" method="post">
    <input type="hidden" name="stuID" value="${student.stuID}">
    邮箱:<input type="email" name="emailAddress" value="${student.emailAddress}"><br>
    <%--自我介绍：<<input type="text" name="selfInfo">--%>
    <input type="submit" value="提交"><br>
    <input type="hidden" value="put" name="_method">
</form>
</div>
<br><br>
<form action="/u/updateStuImage" method="post" enctype="multipart/form-data">
    <label>上传头像：小于1M</label><br>
    <input type="file" name="file"><br>
    <input type="submit" value="提交"><br>
</form>


</body>
</html>
