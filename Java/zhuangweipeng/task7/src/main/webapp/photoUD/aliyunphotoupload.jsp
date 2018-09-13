<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>图片上传</title>
</head>
<body>
<h1 >图片上传</h1>
<h4>阿里云图片上传</h4>
<form action="/photeUpload" enctype="multipart/form-data" method="post">
    <table>
        <p>
            <label>关联用户名上传图片：</label>
            <input type="text" name="name">
        </p>
        <tr style="text-align:center;">

            <td style="text-align:center;" >请选择上传阿里云图片:</td>
            <td><input type="file" name="photoPath"></td>
        </tr>
        <tr>
            <td><input type="submit" value="上传"></td>
        </tr>
    </table>
</form><br>

<h4>七牛云图片上传</h4>
<form action="/upLoadQiNiu" enctype="multipart/form-data" method="post">
    <table>
        <tr style="text-align:center;">
            <td style="text-align:center;" >请选择上传七牛云图片:</td>
            <td><input style="text-align:center;" type="file" name="photoPath1"></td>
        </tr>
        <tr>
            <td><input style="text-align:center;" type="submit" value="上传"></td>
        </tr>
    </table>
</form><br>
${msg}

<a href="/ALiToQiNiu">阿里云一键迁移到七牛云</a><br>
<a href="/QiNiuToALi">七牛云一键迁移到阿里云</a><br>

    <%--根据用户名查询图片--%>
    <form action="/findNameByPhoto" method="post">
        <p>
            <label>根据用户名查询图片：</label>
            <input type="text" name="name">
            <input id="submit1" type="submit" value="查询">
        </p>
    </form>
</body>
</html>