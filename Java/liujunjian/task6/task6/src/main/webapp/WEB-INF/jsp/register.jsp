<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>register</title>
</head>
<body>
${message}<br>
<form action="${pageContext.request.contextPath}/registerResult" method="POST">
    <table>
        <caption>用户注册</caption>
        <tr>
            <td>用户名：</td>
            <td><input type="text" name="username" size="20"/></td>
            <td>必填</td>
        </tr>
        <tr>
            <td>密码:</td>
            <td><input type="password" name="password" size="20"/></td>
            <td>必填，不少于6位</td>
        </tr>
        <tr>
            <td>年龄:</td>
            <td><input type="text" name="age" size="20"/></td>
            <td>可选</td>
        </tr>
        <tr>
            <td>生日:</td>
            <td><input type="text" name="birthday" size="20"/></td>
            <td>可选</td>
        </tr>
        <tr>
            <td><input type="submit" value="注册"/></td>
            <td><input type="reset" value="重置"/></td>
        </tr>
    </table>
</form>
如果您已经注册，请单击<a href="${pageContext.request.contextPath}/login">这里</a>登录！
</body>
</html>