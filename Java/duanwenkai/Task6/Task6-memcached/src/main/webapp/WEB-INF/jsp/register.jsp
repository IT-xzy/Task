<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>学员报名</title>
</head>
<body>
<h1 align="center">学员报名</h1>
<br>
<br>

<form method="post" action="${pageContext.request.contextPath}/u/subRegister">
    <table align="center" border="1" width="40%">
        <tr>
            <th align="center" colspan="2">修真院学员注册</th>
        </tr>
        <tr>
            <td>用户名</td> <%--name属性与实体类属性相对应，只有设置了 name 属性的表单元素才能在提交表单时传递它们的值。--%>
            <td><input id="userName" name="userName" value="" type="text" placeholder="请输入用户名"></td>
        </tr>
        <tr>
            <td>邮箱</td>
            <td><input id="email" name="email" value="" type="text" placeholder="请输入邮箱"></td>
        </tr>
        <tr>
            <td>手机号</td>
            <td><input id="phone" name="phone" value="" type="text" placeholder="请输入手机号"></td>
        </tr>
        <tr>
            <td>密码</td>
            <td><input id="password" name="password" value="" type="text" placeholder="请输入密码"></td>
        </tr>
        <tr>
            <td colspan="2" align="center">
                <button type="submit">提   交</button>
            </td>
        </tr>
    </table>
</form>
</body>
</html>
