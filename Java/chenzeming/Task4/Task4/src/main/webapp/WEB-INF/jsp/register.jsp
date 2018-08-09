<%--
  Created by IntelliJ IDEA.
  User: LUCKY 铭
  Date: 2018/7/26
  Time: 21:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户注册</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/register" method="post">
    <form>
        <%--<form action="FIND">--%>
        <h1>注册界面</h1>
        账  号 ：<input type="text"  name="username" value=""><br/>
        密  码 ：<input type="password"  name="password" value=""><br/>
        <p id="buttons">
            <input  id="submit" type="submit" value="注册">
        </p>

</body>
</html>
