<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2018/8/7
  Time: 21:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>个人信息页面</title>
</head>
<body>

<br>头像：<img src="${person.picture}" width="150" height="80">
<br>用户名：${person.username}
<br>手机号：${person.phone}
<br>邮箱号：${person.email}
<form action="${pageContext.request.contextPath}/phone">
    <br><input type="hidden" name="username" value="${person.username}">
    <br><input type="hidden" name="password" value="${person.password}">
    <br>手机号：<input type="text" name="phone">
    <br><input type="submit" value="绑定">
</form>

<br>---------------------------------------------
<form action="${pageContext.request.contextPath}/phoneModify">
    <input type="hidden" name="username" value="${person.username}">
    <input type="hidden" name="phone" value="${person.phone}">
    <input type="submit" value="修改">
</form>



<form action="${pageContext.request.contextPath}/email">
    <br><input type="hidden"name="username" value="${person.username}">
    <br><input type="hidden" name="password" value="${person.password}">
    <br>邮箱号：<input type="text" name="email">
    <br> <input type="submit" value="绑定">
</form>



</form>
<form action="${pageContext.request.contextPath}/i/picture" METHOD="POST" enctype="multipart/form-data">
<input type="file" name="image" value="点击上传图片"/>
<input type="hidden" name="username" value="${person.username}"/>
<input type="submit" value="上传"/>
</form>
<br><a href="${pageContext.request.contextPath}/main">返回首页</a>
</body>
</html>
