<%--
  Created by IntelliJ IDEA.
  User: TF
  Date: 2018/4/9
  Time: 20:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册界面</title>
</head>
<body>
<h2 align="center">注册界面</h2>
<form name=form1 action="register" method="post" >
    <table align="center">
        <tr>
            <td>用户ID：</td>
            <td><input type="text" name="name" value="${user.name}">7~14位账号，首位必须为字母，字母数字下划线组合</td>
        </tr>
        <tr>
            <td>密码：</td>
            <td><input type="text" name="password" value="${user.password}" >7-14位密码 首位必须为大写字母,允许为大小写字母、数字</td>
        </tr>
        <tr>
            <td><input type="reset" value="重置"></td>
            <td><input type="submit" value="注册"></td>
        </tr>
    </table>
</form>

</body>
</html>