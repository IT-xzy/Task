<%--
  Created by IntelliJ IDEA.
  User: 田野
  Date: 2018/7/19
  Time: 19:58
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
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
<div class="from-group">
    <h1 style="text-align: center">人员信息</h1>
    <hr/>
    <form method="post" name="form">
        <div class="form-group">
            <label for="Id">账号名:</label>
            <input type="text" class="form-control" id="Id" name="userId" placeholder="输入账号名"/>
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
        <div class="form-group">
            <label for="desire">立愿:</label>
            <input type="text" class="form-control" id="desire" name="userWords" placeholder="立愿"/>
        </div>
        <div>
        <input type="text" name="userTel" id="userTel" placeholder="请输入手机号码" required="required"/>
        <button type="button" onclick="sendBtn()">获取验证码</button>
        <input type="text"  id="verifyCode" placeholder="请输入验证码" required="required">
    </div>

        <div class="form-group">
            <input type="submit" id="_submit" value="提交"/>
        </div>
    </form>
</div>
</body>
</html>
