<%--
  Created by IntelliJ IDEA.
  User: Blue
  Date: 2018/1/27
  Time: 15:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>上传文件</title>
</head>
<body>
<h2>上传文件</h2>
<form action="fileSave" method="post"  enctype="multipart/form-data">
    <p>
        <label for="files">文件：</label>
        <input type="file" name="files" id="files" multiple="multiple" />
    </p>
    <p>
        <button>提交</button>
    </p>
    <p>
        ${message}
    </p>
</form>
</body>
</html>