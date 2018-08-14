<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/7/18
  Time: 23:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>验证码页面</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/verificationNumber">
        <input type="text" name="verificationNumber" placeholder="验证码">
        <input type="submit" value="确认">
    </form>
</body>
</html>
