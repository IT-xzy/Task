<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/7/21
  Time: 20:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>更新密码验证页面</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/u/updatePassword" method="get">
        <input type="text" name="verification" placeholder="请输入你的验证码">
        <input type="submit" value="更新密码">
    </form>
</body>
</html>
