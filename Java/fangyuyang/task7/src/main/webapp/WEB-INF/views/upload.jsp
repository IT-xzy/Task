<%--
  Created by IntelliJ IDEA.
  User: LENOVO
  Date: 2018/5/29
  Time: 20:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>图片上传</h2>
<form action="${pageContext.request.contextPath}/uploadPicture" enctype="multipart/form-data" method="post">
    <table>

        <tr>
            <td>请选择文件:</td>
            <td><input type="file" name="file"></td>
        </tr>
        <tr>
            <td><input type="submit" value="上传"></td>
        </tr>
    </table>
</form>
</body>
</html>
