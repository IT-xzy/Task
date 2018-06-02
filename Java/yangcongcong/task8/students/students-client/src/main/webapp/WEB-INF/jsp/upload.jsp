<%--
  Created by IntelliJ IDEA.
  User: Y
  Date: 18/5/12
  Time: 13:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>upload photo</title>
</head>
<body>
<form action="/u/user" method="post" enctype="multipart/form-data">
    选择文件：<input type="file" name="photoPath" id="photoPath"/><br>
    <input type="submit" value="上传头像"/>
</form>
</body>
</html>
