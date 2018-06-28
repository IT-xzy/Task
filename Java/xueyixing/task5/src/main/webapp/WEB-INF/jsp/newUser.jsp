<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="title" uri="http://tiles.apache.org/tags-tiles" %>
<html>
<head>
    <title>注册账号</title>
    <link href="${pageContext.request.contextPath }/data/newUser/css/NewUserStyle.css" rel='stylesheet' type='text/css' />
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
</head>
<body>
<div class="main">
    <div class="login-head">
        <h1>优雅的注册账号</h1>
    </div>
    <div  class="wrap">
        <div class="Regisration">
            <div class="Regisration-head">
                <h2><span></span>注册账号</h2>
            </div>
            <form action="${pageContext.request.contextPath }/register" method="post">
                <input type="text" placeholder="账号" name="userName" >
                <input type="password" placeholder="密码" name="password" >
                <input type="text" placeholder="邮箱" name="email" >
                <input type="text" placeholder="手机号" name="phone" >
                <div class="Remember-me">
                    <div class="p-container">
                        <label class="checkbox"><input type="checkbox" name="checkbox" checked><i></i>我同意条款和条件。</label>
                        <div class ="clear"></div>
                    </div>

                    <div class="submit">
                        <input type="submit" onclick="myFunction()" value="提交注册 >" >
                    </div>
                    <div class="clear">
                    </div>
                </div>
            </form>
        </div>
    </div>
<!--//End-login-form-->
<div class ="copy-right">
    <p>Welcome to <a href="${pageContext.request.contextPath }/home">刘欢小站</a></p>
</div>
<%--<fieldset style="width: 280px;margin: auto">
    <legend>注册账号</legend>
    <form id="regForm" action="${pageContext.request.contextPath }/register" method="post">

        <table align="center">
            <tr>
                <td>
                    <label path="username">账号</label>
                </td>
                <td>
                    <input path="username" name="userName" id="username"/>
                </td>
            </tr>
            <tr>
                <td>
                    <label path="password">密码</label>
                </td>
                <td>
                    <input password path="password" name="password" id="password"/>
                </td>
            </tr>
            <tr>
                <td>
                    <label path="email">邮箱</label>
                </td>
                <td>
                    <input path="email" name="email" id="email"/>
                </td>
            </tr>
            <tr>
                <td>
                    <label path="phone">手机号</label>
                </td>
                <td>
                    <input path="phone" name="phone" id="phone"/>
                </td>
            </tr>
            <tr>
                <td></td>
                <td>
                    <button id="register" name="register">提交</button>
                </td>
            </tr>
            <tr></tr>
            <tr>
                <td></td>
                <td><a href="${pageContext.request.contextPath }/home">Home</a>
                </td>
            </tr>
        </table>
    </form>
</fieldset>--%>
</body>
</html>
