<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/8/26
  Time: 19:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css" href="css/style1.css"/>

    <title>上传图片测试</title>
    <base href="${pageContext.request.contextPath}/">
</head>
<body>

<form action="peoplePicture" method="post" enctype="multipart/form-data">
    <input type="hidden" name="name" value="${sessionScope.name}"/>
    图片： <input type="file" name="pictureFile"/><br>
    <input type="submit" value="提交">
</form>
</body>
</html>

