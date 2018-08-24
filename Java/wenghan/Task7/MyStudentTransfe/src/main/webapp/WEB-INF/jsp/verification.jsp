<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/7/18
  Time: 20:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>获得验证码</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/verificationMail" method="get">
        <input type="text" name="mail" placeholder="请输入你的邮箱">
        <input type="submit" value="通过邮箱获得验证码">
    </form>
    <form action="${pageContext.request.contextPath}/verificationPhome" method="get">
        <input type="text" name="phome" placeholder="请输入你的手机号">
        <input type="submit" value="通过手机号获得验证码">
    </form>
</body>
</html>
