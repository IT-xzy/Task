<%@ page contentType="text/html; charset=UTF-8" pageEncoding="utf-8" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
    <title>Spring MVC</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/login" method="GET">
    <table>
        <caption>管理员登录</caption>
        <tr>
            <td>用户名：</td>
            <td><input type="text" name="username" size="20"/></td>
        </tr>
        <tr>
            <td>密码:</td>
            <td><input type="password" name="password" size="20"/></td>
        </tr>
        <tr>
            <td><input type="submit" value="登录"/></td>
            <td><input type="reset" value="重置"/></td>
        </tr>
    </table>
</form>
</body>
</html>