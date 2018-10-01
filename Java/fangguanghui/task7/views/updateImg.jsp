<%--
  Created by IntelliJ IDEA.
  User: FGH
  Date: 2018/8/13
  Time: 1:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div id="head">
    <p>修改头像</p>
</div>
<img alt="图片无法显示" src="${uploadImge.photo}"/>
<form action="${pageContext.request.contextPath}/imgOSS" method="post" enctype="multipart/form-data">
    <p>
        <input name="id"  type="hidden" value="${uploadImge.id}" /><br>
    </p>
    上传头像   <input name="fileName" id="name" type="file" /><br>
    <input type="submit" value="提交"/> <br>
</form>
</body>
</html>
