<%--
  Created by IntelliJ IDEA.
  User: 孙若飞
  Date: 2019/3/8
  Time: 13:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <meta http-equiv="Content-Type" content="multipart/form-data; charset=utf-8" />
</head>
<body>
<form action="/register" name="user" method="post" enctype="multipart/form-data">
    用户名:<input type="text" name="name">
    密码:<input type="text" name="password">
    手机号:<input type="text" name="phone">
    验证码:<input type="text" name="code">
    邮箱:<input type="text" name="mail">
    图片<input type="file" name="multipartFile">
    <input type="submit" value="注册"><br>
</form>
</body>
</html>
