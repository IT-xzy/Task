<%--
  Created by IntelliJ IDEA.
  User: Liu Kai
  Date: 2018/7/25
  Time: 16:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<br><br><br><br>
<a href="/homepage">homepage</a>
<br><br><br><br>

    <form method="post" action="/register">
        姓名： <input name="stuName" type="text">
        密码： <input type="password" name="password">
        <input type="submit" value="注册">
    </form>
         提示信息：<p>${result}</p>


</body>
</html>
