<%--
  Created by IntelliJ IDEA.
  User: LUCKY 铭
  Date: 2018/8/10
  Time: 21:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>文件上传</title>
</head>
<body>
<h2>文件上传</h2>
<form action="/upload1" enctype="multipart/form-data" method="post">
    <table>
        <tr>
            <td>请选择文件:</td>
            <td><input type="file" name="photoPath"></td>
        </tr>
        <tr>
            <td><input type="submit" value="上传"></td>
        </tr>
    </table>
</form>
</body>
</html>