<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/8/3
  Time: 9:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
    <base action="${pageContext.request.contextPath}/">
</head>
<body>
<h1>${name}${message}</h1>

<form action="register" method="post" name="test">
    <p>用户<input name="name" type="text"><br/>
        密码<input name="password" type="text"><br/>
        密码<input name="password1" type="text"><br/>
        <input type="submit" value="注册"></p>
</form>
</body>
</html>
