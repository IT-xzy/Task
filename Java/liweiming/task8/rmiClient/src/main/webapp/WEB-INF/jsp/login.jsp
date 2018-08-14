<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018\8\2 0002
  Time: 9:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>学员登录</title>
</head>
<body>
<br>
<br>
<br>
<div align="center">
    <h5>学员登录</h5>
</div>
<br>
<br>
<br>
<br>
<div align="center">
    <form action="${pageContext.request.contextPath}/alogin" method="post">
        <table>
            <tr>
                <td>用户名：</td>
                <td><input name="username" type="text" value="" placeholder="用户名/邮箱/手机号"></td>
            </tr>
            <tr>
                <td>密码：</td>
                <td><input name="password" type="password" value="" placeholder="请输入密码"></td>
            </tr>
            <tr>
                <td colspan="2">
                    <input value="登录" type="submit">
                </td>
            </tr>
        </table>
    </form>
    <a href="${pageContext.request.contextPath}/register">注册</a>
</div>
</body>
</html>
