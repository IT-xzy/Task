<%--suppress ALL --%>
<%--
  Created by IntelliJ IDEA.
  User: 田野
  Date: 2018/4/27
  Time: 21:32
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="Pragma" content="no-cache">
    <meta http-equiv="Cache-Control" content="no-cache">
    <meta http-equiv="Expires" content="0">
    <title>后台管理</title>
    <link href="${pageContext.request.contextPath }/static/css/login.css" rel="stylesheet" type="text/css" />
</head>

<body>
<div class="login_box">
    <div class="login_l_img"><img src="${pageContext.request.contextPath }/static/images/login-img.png" /></div>
    <div class="login">
        <div class="login_logo"><a href="#"><img src="${pageContext.request.contextPath }/static/images/login_logo.png" /></a></div>
        <div class="login_name">
            <p>登录系统</p>
        </div>
        <form action="/login" method="post">
            <input name="userId" type="text"  value="用户名" onfocus="this.value=''" onblur="if(this.value==''){this.value='用户名'}">
            <span id="password_text" onclick="this.style.display='none';document.getElementById('userPassword').style.display='block';document.getElementById('userPassword').focus().select();" >密码</span>
            <input name="userPassword" type="password" id="userPassword" style="display:none;" onblur="if(this.value==''){document.getElementById('password_text').style.display='block';this.style.display='none'};"/>
            <input value="登录" style="width:100%;" type="submit">
            <a href="register">没有账号?免费注册</a>
        </form>

    </div>
    <div class="copyright">某某有限公司 版权所有©2016-2018 技术支持电话：000-00000000</div>
</div>
</body>
</html>

