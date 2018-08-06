<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/6/24
  Time: 14:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>home</title>
</head>
<body>

    <form action="${pageContext.request.contextPath}/T0" method="get">
        <input type="submit" value="T0页面">
    </form>

    <form action="${pageContext.request.contextPath}/u/T1" method="get">
        <input type="submit" value="T1页面">
    </form>

    <form action="${pageContext.request.contextPath}/Login" method="get">
        <input type="submit" value="登录">
    </form>

    <form action="${pageContext.request.contextPath}/remove" method="get">
        <input type="submit" value="注销">
    </form>

    <form action="${pageContext.request.contextPath}/register" method="get">
        <input type="submit" value="注册">
    </form>

    <form action="${pageContext.request.contextPath}/u/User" method="get">
        <input type="submit" value="个人主页">
    </form>

    <p>当前使用:${Oss}</p>
</body>
</html>
