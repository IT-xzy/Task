<%--
  Created by IntelliJ IDEA.
  User: Dong
  Date: 2018/3/17
  Time: 9:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>完善资料</h2>
<form action="${pageContext.request.contextPath }/upload" enctype="multipart/form-data" method="post">
    <table>
        <tr>
            <td>性别：</td>
            <td><input type="text" name="sex"></td>
        </tr>
        <tr>
            <td>QQ：</td>
            <td><input type="text" name="qq"></td>
        </tr>
        <tr>
            <td>职业选择：</td>
            <td><input type="text" name="major"></td>
        </tr>
        <tr>
            <td>自我描述：</td>
            <td><input type="text" name="intro"></td>
        </tr>

        <tr>
            <td>请选择头像:</td>
            <td><input type="file" name="file"></td>
        </tr>
        <tr>
            <td><input type="submit" value="上传"></td>
        </tr>
    </table>
</form>
</body>
</html>
