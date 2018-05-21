<%--
  Created by IntelliJ IDEA.
  User: Blue
  Date: 2018/1/21
  Time: 10:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
</head>
<body>
    <form action="/register" method="post">
        <table>
            <tr><td>用户名</td><td><input type="text" name="userName"/></td></tr>
            <tr><td>密码</td><td><input type="password" name="passWord"></td></tr>
            <tr><td colspan="2"><input type="submit" value="注册"></td></tr>
        </table>
    </form>

</body>
</html>
