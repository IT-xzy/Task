<%--
  Created by IntelliJ IDEA.
  User: LL
  Date: 2018/4/21
  Time: 22:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录界面</title>
</head>
<body>
<h3 align="center">登录界面</h3>
<form action="/login" method="post" name="User">
    <table align="center">
        <tr>
            <td>账号:</td>
            <td><input type="text" name="name"></td>
        </tr>
        <tr>
            <td>密码:</td>
            <td><input type="text" name="password"> </td>
        </tr>
        <tr>
            <td><input type="reset" value="重置"></td>
            <td><input type="submit" value="登陆"></td>
        </tr>
    </table>
</form>
</body>
</html>
