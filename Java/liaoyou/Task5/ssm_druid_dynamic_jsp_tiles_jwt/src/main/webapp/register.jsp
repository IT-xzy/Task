<%@page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" session="false" %>

<html>
<head>
    <title>register</title>
</head>
<body>
<center>
    <h1>用户注册</h1>
    <hr>
    <form action="/register" method="post">
        <table>
            <tr>
                <td>用户名：</td>
                <td><input type="text" name="name"/></td>
            </tr>
            <tr>
                <td>密码：</td>
                <td><input type="password" name="password"/></td>
            </tr>
            <tr>
                <td colspan="2" align="center"><input type="submit" value="注册"/>&nbsp;&nbsp;<input type="reset" value="取消"/></td>
            </tr>
        </table>
    </form>
</center>
</body>
</html>