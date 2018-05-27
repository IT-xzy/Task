<%--
  Created by IntelliJ IDEA.
  User: Y
  Date: 18/5/8
  Time: 12:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    String msg = (String) request.getAttribute("msg");
    out.print(msg);
%>

<div style="text-align: center">
    <form action="/login" method="post">
        用户名：<input type="text" name="username"/><br>
        密  码：<input type="password" name="password"/><br>
        <input type="submit" value="登录"/>
    </form>
</div>
</body>
</html>
