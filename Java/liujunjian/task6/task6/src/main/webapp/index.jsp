<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<html>
<body>
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
如果您还没有注册，请单击<a href="${pageContext.request.contextPath}/register">这里</a>注册！
</body>
</html>

