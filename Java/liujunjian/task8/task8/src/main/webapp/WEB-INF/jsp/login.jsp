<%@page contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
    <title>Spring MVC</title>
</head>
<body>
${message}<br>
<form action="${pageContext.request.contextPath}/loginResult" method="POST">
    <table>
        <caption>用户登录</caption>
        <tr>
            <td>用户名：</td>
            <td><input type="text" name="username" size="20"/></td>
        </tr>
        <tr>
            <td>密码:</td>
            <td><input type="password" name="password" size="20"/></td>
        </tr>
        <tr>
            <td><input type="submit" value="确定"/></td>
            <td><input type="reset" value="重置"/></td>
        </tr>
    </table>
</form>
<a href="${pageContext.request.contextPath}/register">注册</a>
<form action="${pageContext.request.contextPath}/u">
    <input type="submit" value="拦截器测试">
</form>
</body>
</html>