<%--
  Created by IntelliJ IDEA.
  User: 指缝de阳光
  Date: 2018/6/8
  Time: 18:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<p align="center">上传文件选择
<%--<form action="/upload" method="post" enctype="multipart/form-data">
    　　文件名: <input type="file" name="upfile"/> <br/>
    　　<input type="submit" value="提交" />
</form>--%>
<form action="/upload/${u.userId}" method="post" enctype="multipart/form-data">
    <input type="file" name="file">
    <input type="hidden" value="${u.userId}" name="userId">
    <input type="submit" value="提交">
</form>
</FORM>
</body>
</html>
