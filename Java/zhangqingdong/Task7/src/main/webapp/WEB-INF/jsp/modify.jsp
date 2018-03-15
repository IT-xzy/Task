<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/10/26
  Time: 15:59
  To change this template use File | Settings | File Templates.
--%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改用户信息</title>
</head>
<body>
<form action="${ctx}/user/${user.id}" method="post" enctype="multipart/form-data">
    <input hidden name="username" type="text" value="${user.username}">
    <input hidden name="id" type="text" value="${user.id}">
<table border="1">
    <tr>
        <td>用户名</td>
        <td>${user.username}</td>
    </tr>
    <tr>
        <td>头像</td>
        <td><input type="file" name="file" accept="image/png, image/jpeg, image/gif, image/jpg"></td>
    </tr>
    <tr>
        <td>邮箱</td>
        <td><input type="text" name="email" placeholder="${user.email}"></td>
    </tr>
    <tr>
        <td>手机号码</td>
        <td><input type="text" name="tel" placeholder="${user.tel}"></td>
    </tr>
    <tr>
        <td>确认</td>
        <td><input type="submit" value="确认"></td>
    </tr>
</table>
</form>

</body>
</html>
