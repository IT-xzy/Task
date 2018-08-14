<%--
  Created by IntelliJ IDEA.
  User: 田野
  Date: 2018/6/23
  Time: 14:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册界面</title>
</head>
<body>
<div style="text-align: center">
    <form action="/register" method="post">
        <input type="text" placeholder="请输入帐号" name="userId"><br/><br/>
        <input type="text" placeholder="请输入姓名" name="userName"><br/><br/>
        <input type="text" placeholder="请输入密码" name="userPassword"><br/><br/>
        <input type="number" placeholder="请输入创建时间" name="create_at"><br/><br/>
        <input type="number" placeholder="请输入更新时间" name="update_at"><br/><br/>
        <button type="submit">注册</button>
    </form>
</div>
</body>
</html>
