<%--
  Created by IntelliJ IDEA.
  User: thinkpad
  Date: 2018/5/28
  Time: 18:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta http-equiv="pragma" content="no-cache" />
    <base target="_self">
    <title>上传头像</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/u/a/uploadimage" method="post" align="center" enctype="multipart/form-data">
    选择一个文件：
    <input type="file" name="file" >
    <%--<img src="${image_path}" width="200" height="200">--%>
    <br/><br/>
    <div align="center"><input type="submit" value="确认上传" ></div>
</form>
</body>
</html>
