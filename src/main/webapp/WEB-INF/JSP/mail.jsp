<%--
  Created by IntelliJ IDEA.
  User: 田野
  Date: 2018/7/21
  Time: 18:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>mail</title>
</head>
<body>
<div style="text-align: center">
    <form action="/sendMail" name="form" method ="post">
        <div class="form-group">
            <label for="userId">用户名:</label>
            <input type="text" class="form-control" id="userId" name="userId" placeholder="输入用户名"/>
        </div>
        <div class="form-group">
            <label for="mail">邮箱名:</label>
            <input type="text" class="form-control" id="mail" name="userMail" placeholder="输入邮箱号名"/>
        </div>
        <div class="form-group">
            <input type="submit"value="提交"/>
        </div>
    </form>
</div>
</body>
</html>
