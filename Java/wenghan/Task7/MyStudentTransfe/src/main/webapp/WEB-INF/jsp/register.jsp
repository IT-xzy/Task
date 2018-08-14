<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/7/13
  Time: 23:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>注册页面</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/register" method="post">
        <input type="text" name="accountNumber" placeholder="用户名:2到40位字母+数字">
        <input type="text" name="password" placeholder="密码:3到20位的数字">
        <input type="submit" value="注册">
    </form>
</body>
</html>
