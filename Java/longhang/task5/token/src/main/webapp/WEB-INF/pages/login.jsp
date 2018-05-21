<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <meta charset="utf-8">
    <title></title>
</head>

<body >
<form action="${pageContext.request.contextPath}/logins" method="post" >
    用户名：<input type="text" name="name"><br/><br/>
    密码：<input type="password" name="password" /><br/><br/>
    <input type="submit"  value="登录">

</form>
<td>
    <form action="${pageContext.request.contextPath}/toregist"  >
        <p id="editButton"><input  type="submit"  value="注册">
    </form>
</td>
</body>

</html>
