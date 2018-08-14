<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<head>
    <meta charset="UTF-8">
    <title>登录页面</title>

    <%--<link rel="stylesheet" type="text/css" href="login.css"/>--%>
    <%--<link rel="stylesheet" type="text/css"/>--%>
    <script type="text/javascript">
        function volidate(){
            if(document.getElementById("name").value==""){
                alert("用户名不能为空！")
                document.getElementById("name").focus();
                return false;
            }
//            else if(
//                document.getElementById("name").value!=(select )) {
//                alert("用户名不能为空！")
//                document.getElementById("name").focus();
//                return false;
//            }

            else if(document.getElementById("password")==""){
                alert("密码不能为空！")
                document.getElementById("password").focus();
                return false;
            }
            return true;
        }
        function register() {
            window.location.href="../register/register.jsp";
        }
    </script>
</head>

<body>
<div id="login_frame">
    <h1>用户登录</h1><br/>
    <%--<form method="post" action="${pageContext.request.contextPath}/home" onsubmit="return volidate()" >--%>
        <form method="post" action="${pageContext.request.contextPath}/home" >
     用户名<input type="text" id = "name" name="name" class="text_field"
                   style="width: 190px;height: 26px;margin-left: 39px;"/><br/>
     密码<input type="password" id = "password", name="password" class="text_field"
            style="width: 190px;height: 26px;margin-top: 8px;margin-left: 54px"/>
        </p>
        <div id="login_control">
            <input type="submit" id="btn_login" value="登录" />
        </div><br/>
        <div id="register_control">
            <input type="button" id="btn_register" value="点击跳转到注册页面" onclick="register();"/>
        </div>
    </form>
</div>
</body>
</html>
