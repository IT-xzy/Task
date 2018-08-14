<%--
  Created by IntelliJ IDEA.
  User: 田野
  Date: 2018/6/23
  Time: 14:55
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册界面</title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery-3.31.min.js"></script>
    <script type="text/javascript">
        function sendBtn(userTel) {
            var userTel = document.form.userTel.value;
            var url = '${pageContext.request.contextPath }/message?userTel=' + userTel;
            $.ajax({
                url: url,
                type: 'GET',
            });
        }
    </script>
</head>
<body>
<div style="text-align: center">
    <form action="/register" name="form" method="post">
        <div class="form-group">
            <label for="Id">账号名:</label>
            <input type="text" class="form-control" id="Id" name="userId" placeholder="输入账号名"/>
        </div>
        <div class="form-group">
            <label for="password">密码:</label>
            <input type="password" class="form-control" id="password" name="userPassword" placeholder="密码"/>
        </div>
        <div class="form-group">
            <label for="name">姓名:</label>
            <input type="text" class="form-control" id="name" name="userName" placeholder="输入姓名"/>
        </div>
        <div class="form-group">
            <label for="gender">QQ:</label>
            <input type="text" class="form-control" id="gender" name="userQq" placeholder="QQ"/>
        </div>
        <div class="form-group">
            <label for="type">学习类型:</label>
            <input type="text" class="form-control" id="type" name="userType" placeholder="学习类型"/>
        </div>
        <div>
            <label for="type">性别：</label>
        <select name="userSex">
            <option value="0" aria-checked="true">男</option>
            <option value="1">女</option>
        </select>
        </div>
        <div>
            <label for="type">手机号码:</label>
            <input type="text" name="userTel" id="userTel" placeholder="请输入手机号码" required="required"/>
            <button type="button" onclick="sendBtn()">获取验证码</button>
            <input type="text"  name="verifyCode" placeholder="请输入验证码" required="required">
        </div>

        <div class="form-group">
            <input type="submit"value="提交"/>
        </div>
    </form>
</div>
</body>
</html>
