<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
    <title>头像上传</title>
    <script src="/view/jnshu/js/jquery-3.2.1.min.js"></script>
    <script type="text/javascript" src="/view/jnshu/js/avatar.js"></script>
</head>
<body>
<form id="uploadAvatar" enctype="multipart/form-data">
    <div id="tip" color="red">只允许上传jpg或png图片</div><br/>
    <input type="file" name="file" id="avatar">
    <input type="button" id="avatar_button" value="更新头像">
</form>
</body>
</html>
