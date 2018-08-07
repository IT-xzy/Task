<%--
  Created by IntelliJ IDEA.
  User: CH0918
  Date: 2018/7/19
  Time: 15:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>登录页面</title>

    <link rel="stylesheet" type="text/css" href="login.css"/>
    <script type="text/javascript">
        function volidate(){
            if(document.getElementById("username").value==""){
                alert("用户名不能为空！")
                document.getElementById("username").focus();
                return false;
            }else if(document.getElementById("password")==""){
                alert("密码不能为空！")
                document.getElementById("password").focus();
                return false;
            }
            return true;
        }
        function register() {
            window.location.href="${pageContext.request.contextPath}/register/register.jsp";
        }
    </script>
</head>

<body>
<div id="login_frame">

    <p id="image_logo"><img src="/login/imges/2235785470.jpg" height="100" width="100"></p>

    <form method="post" action="${pageContext.request.contextPath}/account" onsubmit="return volidate()" >
        <p><label class="label_input">用户名</label>
            <input type="text" id = "name" name="name" class="text_field"/>
        </p>
        <p><label class="label_input">密码</label>
            <input type="password" id = "password", name="password" class="text_field"/>
        </p>
        <div id="login_control">
            <input type="submit" id="btn_login" value="登录" />
            <%--<a id="forget_pwd" href="forget_pwd.html">忘记密码？</a>--%>
        </div>
        <div id="register_control">
            <input type="button" id="btn_register" value="注册" onclick="register();"/>
        </div>
    </form>
</div>
</body>
</html>

