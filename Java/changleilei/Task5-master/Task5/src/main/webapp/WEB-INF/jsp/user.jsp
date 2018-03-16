<%--
  Created by IntelliJ IDEA.
  User: lucifer
  Date: 2018/2/6
  Time: 17:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${ctx}/user" method="post">
    账户：<input type="text" name="user"/><br/><br/>
    在线：<input type="text" name="online"/><br/><br/>
    工作：<input type="text" name="workers"/><br/><br/>
    密码：<input type="text" name="pass"/><br/><br/>
    <input type="submit" name="注册" value="注册">
</form>
</body>
</html>
