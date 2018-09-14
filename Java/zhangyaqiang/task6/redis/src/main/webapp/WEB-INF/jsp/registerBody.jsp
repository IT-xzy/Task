<%--
  Created by IntelliJ IDEA.
  User: zyq
  Date: 2018/8/25
  Time: 21:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h2 align="center">注册页面</h2>
    <form action="/user" method="post" onkeydown="if(event.keyCode==13)return false;">
        <table align="center">
            <tr>
                <td style="font-size: large">&nbsp;&nbsp;姓名</td>
                <td><input type="text" name="name"></td>
            </tr>
            <tr>
                <td style="font-size: large">&nbsp;&nbsp;账号</td>
                <td><input type="text"  name="username" id="username">
                    <div id="usernameNotNull" style="display: none;color: red">账号不能为空</div>
                    <div id="usernameUnique" style="display: none;color: red">账号已存在</div></td>
            </tr>
            <tr>
                <td style="font-size: large" >&nbsp;&nbsp;密码</td>
                <td><input type="password" name="password" id="password">
                    <div id="passwordNotNull" style="display: none;color: red">密码不能为空</div></td>
            </tr>
            <tr>
                <td style="font-size: large">确认密码</td>
                <td><input type="password" id="password2">
                    <div id="password2NotNull" style="display: none;color: red">两次密码不一致</div></td>
            </tr>
            <tr align="center"><td colspan="2"><button type="submit" style="height: 200%;width: 35%" id="button">确认提交</button>
                <div id="buttonDiv" style="display: none;color: red">请按照要求输入账号密码</div></td></tr>
        </table>
    </form>
</body>
<script>

    document.getElementById("username").onblur=function () {
        var username =  document.getElementById("username");
        if (username.value=="") {
            document.getElementById("usernameNotNull").style.display = "block";
        }else {
            $.ajax({
                url: "/user/"+username.value,
                type: 'GET',
                dataType:'json',
                success: function (data) { // http code 200
                    if (1==data){
                        document.getElementById("usernameUnique").style.display = "none";
                    }else {
                        document.getElementById("usernameUnique").style.display = "block";
                    }
                },
                error: function (XMLHttpRequest, textStatus, errorThrown) {
                    switch (XMLHttpRequest.status) {
                        case 401:
                            break;
                        case 404:
                            break;
                        case 500:
                            break;
                    }
                }
            });
            document.getElementById("usernameNotNull").style.display = "none";
        }
    }

    document.getElementById("username").onfocus=function () {
        document.getElementById("usernameUnique").style.display = "none";
        document.getElementById("usernameNotNull").style.display = "none";
    }

    document.getElementById("password").onblur=function () {
        var password =  document.getElementById("password");
        var password2 =  document.getElementById("password2");
        if (password.value=="") {
            document.getElementById("passwordNotNull").style.display = "block";
        }else if(password2.value!=""&&password.value!=password2.value){
            document.getElementById("password2NotNull").style.display = "block";
        }else {
            document.getElementById("passwordNotNull").style.display = "none";
            document.getElementById("password2NotNull").style.display = "none";
        }
    }

    document.getElementById("password2").onblur=function () {
        var password =  document.getElementById("password");
        var password2 =  document.getElementById("password2");
        if (password.value!=password2.value){
            document.getElementById("password2NotNull").style.display = "block";
        } else {
            document.getElementById("password2NotNull").style.display = "none";
        }
    }

    document.getElementById("button").onmouseover=function () {
        var username =  document.getElementById("username");
        var password =  document.getElementById("password");
        var password2 =  document.getElementById("password2");
        var usernameUnique = document.getElementById("usernameUnique")
        if (username.value!=""&&password.value!=""&&password.value==password2.value&&usernameUnique.style.display=="none"){
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
