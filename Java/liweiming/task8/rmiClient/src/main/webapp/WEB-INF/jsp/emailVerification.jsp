<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018\8\2 0002
  Time: 11:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>邮箱验证</title>

</head>
<body>
<h1 align="center">邮箱验证</h1>
<br>
<br>


<form action="${pageContext.request.contextPath}/aliEmail" method="post">
<table align="center" border="1" width="40%">

    <tr>
        <th align="center" colspan="2">修真院学员邮箱验证</th>
    </tr>
    <tr>
        <td>用户名</td>
        <td><input id="username" name="username" value="" type="text" placeholder="请输入用户名"></td>
    </tr>
    <tr>
        <td>邮箱</td>
        <td><input id="email" name="email" value="" type="text" placeholder="请输入邮箱"></td>
    </tr>
    <tr>
        <td colspan="2">
            <input value="邮箱验证" type="submit">
        </td>
    </tr>
    </table>
<br><br><br><br>
<div align="center">
    <a href="${pageContext.request.contextPath}/home">返回主页</a>
</div>
</form>
</body>
</html>