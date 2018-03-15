<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/10/26
  Time: 13:55
  To change this template use File | Settings | File Templates.
--%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户详细信息</title>
</head>
<body>
    <table border="1">
        <tr>
            <td>头像</td>
            <td><img src="${user.avatar}"></td>
        </tr>
        <tr>
            <td>用户名</td>
            <td>${user.username}</td>
        </tr>
        <tr>
            <td>邮箱</td>
            <td>${user.email}</td>
        </tr>
        <tr>
            <td>手机</td>
            <td>${user.tel}</td>
        </tr>
    </table>
    <form action="${ctx}/user/modify" method="get">
<%--        <input type="hidden" name="_method" value="PUT">--%>
        <input hidden name="id" type="text" value="${user.id}">
        <input type="submit" value="修改信息">
    </form>
</body>
</html>
