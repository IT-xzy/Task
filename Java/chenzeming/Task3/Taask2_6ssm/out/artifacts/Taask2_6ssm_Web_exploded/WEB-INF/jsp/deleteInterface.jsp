<%--
  Created by IntelliJ IDEA.
  User: LUCKY 铭
  Date: 2018/7/7
  Time: 19:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="showProduct" content="text/html; charset=UTF-8">
    <title>Title</title>
</head>
<body>
<h1>删除用户</h1>

<%--<form action="/DELETE">--%>
<form action="/category" method="POST">
        <input type="hidden" name="_method" value="DELETE"/>
        id ：<input type="text"  id="id" name="id" value=""><br/>
            <input  id="submit" type="submit" value="删除">
</form>
</body>
</html>
