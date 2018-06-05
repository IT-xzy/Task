<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/5/30
  Time: 19:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/totest"   method="post"  enctype="multipart/form-data">

<input type="file"  id="picture"  name="upPicture"><br>
<input  type="submit" tabindex="5" value="添加">
</p>
</form>
</body>
</html>
