<%--
  Created by IntelliJ IDEA.
  User: Blue
  Date: 2018/1/20
  Time: 14:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>登陆</title>
</head>
<body>
<form action="/login" method="post">
    <table>
        <tr><td>用户名</td><td><input type="text" name="userName"/></td></tr>
        <tr><td>密码</td><td><input type="password" name="passWord"></td></tr>
        <tr><td colspan="2"><input type="submit" value="登录"></td></tr>
    </table>
</form>

</body>
</html>
