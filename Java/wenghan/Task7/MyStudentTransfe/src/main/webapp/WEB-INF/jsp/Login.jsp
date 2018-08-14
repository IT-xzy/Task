
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>登录页面</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/success" method="post">
        <p>账号：</p>
        <label>
            <input type="text" name="accountNumber">
        </label><br>

        <p>密码：</p>
        <label>
            <input type="text" name="password">
        </label><br>

        <input type="submit" value="登录">

    </form>
</body>
</html>
