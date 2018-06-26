<%--
  Created by IntelliJ IDEA.
  User: caoyue
  Date: 2018/4/11
  Time: 下午6:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改新增页面</title>
</head>
<body>
<form action="/upload" method="post" enctype="multipart/form-data">
    　　文件名: <input type="file" name="upfile"/> <br/>
    　　<input type="submit" value="提交" />
</form>
</body>
</html>
