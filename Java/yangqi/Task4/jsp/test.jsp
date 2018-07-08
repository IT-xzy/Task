<%--
  Created by IntelliJ IDEA.
  User: Yzzzt
  Date: 2018/6/13
  Time: 17:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>zhuche</title>
</head>
<body>
<form style="text-align:center" action="${pageContext.request.contextPath }/user/Register" method="post">
    <table align="center" style="border-width: 1px;">
        <tr><td>用户名: </td><td><input type="text" name="name"> </td></tr>
        <tr><td>密码: </td><td><input type="password" name="password"></td></tr>
        <tr><td colspan="2" align="center"><input type="submit" value="注册"></td> </tr>
    </table>
</form>
</body>
</html>
