<%--
  Created by IntelliJ IDEA.
  User: zyq
  Date: 2018/8/25
  Time: 20:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h2 align="center">登录页面</h2>
    <h3 align="center" style="color: red">${msg}</h3>
    <h3 align="center" style="color: red">${studentMsg}</h3>
    <form action="/User" method="post" onkeydown="if(event.keyCode==13)return false;">
        <table align="center">
            <tr>
                <td style="font-size: large">账号</td>
                <td><input type="text" name="username" id="username">
                    <div id="usernameNotNull" style="display: none;color: red">账号不能为空</div></td>
            </tr>
            <tr>
                <td style="font-size: large">密码</td>
                <td><input type="password" name="password" id="password">
                    <div id="passwordNotNull" style="display: none;color: red">密码不能为空</div></td>
            </tr>
            <tr>
                <td colspan="2"/>
            </tr>
            <tr align="center">
                <td colspan="2">
                    <button type="submit" style="height: 200%;width: 50%" id="button">确认登录</button>
                    <div id="buttonDiv" style="display: none;color: red">请按照要求输入账号密码</div>
                </td>
            </tr>
            <tr align="center">
                <td colspan="2">
                    <h5>没有账号?点击<a href="/register">注册</a></h5>
                </td>
            </tr>
        </table>
       >
    </form>

</body>
<script>
    document.getElementById("username").onblur=function () {
        var username =  document.getElementById("username");
        if (username.value=="") {
            document.getElementById("usernameNotNull").style.display = "block";
        }else {
            document.getElementById("usernameNotNull").style.display = "none";
        }
    }

    document.getElementById("password").onblur=function () {
        var username =  document.getElementById("password");
        if (username.value=="") {
            document.getElementById("passwordNotNull").style.display = "block";
        }else {
            document.getElementById("passwordNotNull").style.display = "none";
        }
    }
    document.getElementById("button").onmouseover=function () {
        var username =  document.getElementById("username");
        var password =  document.getElementById("password");
        if (username.value!=""&&password.value!=""){
            document.getElementById("buttonDiv").style.display = "none";
        }else {
            document.getElementById("button").type= "reset";
            document.getElementById("buttonDiv").style.display = "block";
        }
    }

    document.getElementById("button").onmouseout=function () {
        document.getElementById("button").type= "submit";
        document.getElementById("buttonDiv").style.display = "none";
    }
</script>
</html>
