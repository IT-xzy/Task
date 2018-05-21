<%--
  Created by IntelliJ IDEA.
  User: TF
  Date: 2018/4/10
  Time: 8:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script language="JavaScript">
</script>
<html>
<head>
    <title>Title</title>
</head>
<body>
<body>
<h2 align="center">登录界面</h2>
<form name=form1 action="/login" method="post" onsubmit="return isValidate(form1)">
    <table align="center">
        <tr>
            <td>用户ID：</td>
            <td><input type="text" name="name" value="${user.name}">6~8位</td>
        </tr>
        <tr>
            <td>密码：</td>
            <td><input type="text" name="password" value="${user.password}" >6~8位，且不能与用户ID相同</td>
        </tr>
        <tr>
            <td><input type="reset" value="重置"></td>
            <td><input type="submit" value="登陆"></td>
        </tr>
    </table>
</form>
</body>
</html>
