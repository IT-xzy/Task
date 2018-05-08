<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>学员头像上传</title>

</head>
<body>
<h1 align="center">学员头像上传</h1>
<br>
<br>


<form method="post" action="${pageContext.request.contextPath}/subUpload" enctype="multipart/form-data">
    <table align="center" border="1" width="40%">
        <tr>
            <th align="center" colspan="2">学员头像上传</th>
        </tr>
        <tr>
            <td>用户名</td>
            <td><input id="userName" name="userName" value="" type="text" placeholder="请输入用户名"></td>
        </tr>
        <tr>
            <td>选择图片</td>
            <td><input id="photo" type="file" name="photo" /></td>
        </tr>
        <tr>
            <td colspan="2" align="center">
                <button type="submit">提   交</button>
            </td>
        </tr>
    </table>
</form>
<br><br><br><br>
<div align="center">
    <a href="${pageContext.request.contextPath}/home">返回主页</a>
</div>
</body>
</html>
