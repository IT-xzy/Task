<%--
  Created by IntelliJ IDEA.
  User: root
  Date: 2018/7/17
  Time: 9:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
 <form action="/image" method="post" enctype="multipart/form-data">
     <input name="file" type="file"><br/>
     <input type="submit" value="提交">
 </form>
</body>
</html>
