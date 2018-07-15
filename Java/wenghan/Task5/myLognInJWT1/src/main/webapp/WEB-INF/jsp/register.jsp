<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/7/13
  Time: 23:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册页面</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/register" method="post">
        <input type="text" name="accountNumber" placeholder="账号">
        <input type="text" name="password" placeholder="密码">
        <input type="submit" value="注册">
    </form>
    <p>用户名:2到40位，字母+数字</p>
    <p>密码:3到20位的数字</p>
</body>
</html>
