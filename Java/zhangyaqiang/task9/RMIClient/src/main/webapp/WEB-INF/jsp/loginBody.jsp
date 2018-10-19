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
    <style type="text/css">
        * {
            margin: 0px;
            padding: 0px;
        }

        ul {
            list-style: none;
        }

        #hear {
            height: 50px;
            width: 300px;
            text-align: center;
            line-height: 50px;
        }

        #hear li { /*第几个选项卡的样式，有几个选项卡就有几个*/
            width: 33.3%;
            float: left;
        }

        #content li { /*让所有内容页隐藏*/
            display: none;
        }

        #content .action { /*让选中的内容页显示*/
            display: block;
        }
    </style>
</head>
<body>
<div align="center">
    <h2 align="center">登录页面</h2>
    <h3 align="center" style="color: red">${msg}</h3>
    <h3 align="center" style="color: red">${studentMsg}</h3>
    <form action="/User" method="post" onkeydown="if(event.keyCode==13)return false;">
        <table align="center" style="border: 1px solid chartreuse;background:#dddddd">
            <tr>
                <td colspan="2">
                    <!--选项卡列表，如果是底部选项卡，将hear fixed到底部，侧边栏重新设置css-->
                    <ul id="hear">
                        <!--带action的会默认选中-->
                        <li class="action" style="border-bottom: 1px solid #FF4200;">账号登录</li>
                        <li> 手机登录</li>
                        <li> 邮箱登录</li>
                    </ul>
                </td>
            </tr>
            <tr>
                <td style="font-size: large" colspan="2">
                    <ul id="content">
                        <!--带action的会默认显示-->
                        <li class="action" id="content1">
                            &ensp;&ensp;账号&ensp;&ensp;&ensp;&ensp;&nbsp;
                            <input type="text" name="username" id="username">
                            <div id="usernameNotNull" style="display: none;color: red;font-size: medium" align="center">
                                账号不能为空
                            </div>
                        </li>
                        <li id="content2">
                            &ensp;&nbsp;手机号&ensp;&ensp;&ensp;
                            <input type="text" name="telephone" id="telephone">
                            <div id="telephoneNotNull" style="display: none;color: red;font-size: medium"
                                 align="center">手机号不能为空
                            </div>
                        </li>
                        <li id="content3">
                            &ensp;&ensp;邮箱&ensp;&ensp;&ensp;&ensp;&nbsp;
                            <input type="text" name="email" id="email">
                            <div id="emailNotNull" style="display: none;color: red;font-size: medium" align="center">
                                邮箱不能为空
                            </div>
                        </li>
                    </ul>
                </td>
            </tr>
            <tr>
                <td style="font-size: large" align="right">密码</td>
                <td align="center">&nbsp;<input type="password" name="password" id="password"></td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <div id="passwordNotNull" style="display: none;color: red">密码不能为空</div>
                </td>
            </tr>
            <tr align="center">
                <td colspan="2">
                    <input type="button" style="height: 200%;width: 35%" id="button" value="确认登录"></input>
                    <div id="buttonDiv" style="display: none;color: red">请按照要求输入登录信息</div>
                </td>
            </tr>
            <tr align="center">
                <td colspan="2">
                    <h5>没有账号?点击<a href="/register">注册</a></h5>
                </td>
            </tr>
        </table>

    </form>
</div>

</body>
<script>

    $("#hear li").click(function () {       /*----------------选项卡的点击事件，移动端用tap-----------------*/
        $(this).css({
            /*选中选项卡的样式*/
            color: "#ff4200",
            borderBottom: "1px solid #ff4200"

        }).siblings().css({
            /*未选中选项卡的样式*/
            color: "#000000",
            borderBottom: "none"
        });

    });

    $("#hear li").click(function () { /*----------------选项卡的点击事件，移动端用tap-----------------*/
        $(this).addClass("action").siblings().removeClass("action");
        /*选中的li添加action类，其他的移除*/
        var index = $(this).index();
        /*定义索引数值*/
        $("#content li").eq(index).css("display", "block").siblings().css("display", "none");
        /*相对应的第几个内容区显示，其他的隐藏*/
        if (0 == index) {
            document.getElementById("telephone").value = "";
            document.getElementById("telephoneNotNull").style.display = "none";
            document.getElementById("email").value = "";
            document.getElementById("emailNotNull").style.display = "none";
        } else if (1 == index) {
            document.getElementById("username").value = "";
            document.getElementById("usernameNotNull").style.display = "none";
            document.getElementById("email").value = "";
            document.getElementById("emailNotNull").style.display = "none";
        } else if (2 == index) {
            document.getElementById("username").value = "";
            document.getElementById("usernameNotNull").style.display = "none";
            document.getElementById("telephone").value = "";
            document.getElementById("telephoneNotNull").style.display = "none";
        }
    });

    document.getElementById("username").onblur = function () {
        var username = document.getElementById("username");
        if (username.value == "") {
            document.getElementById("usernameNotNull").style.display = "block";
        } else {
            document.getElementById("usernameNotNull").style.display = "none";
        }
    }

    document.getElementById("username").onfocus = function () {
        document.getElementById("usernameNotNull").style.display = "none";
    }

    document.getElementById("telephone").onblur = function () {
        var telephone = document.getElementById("telephone");
        if (telephone.value == "") {
            document.getElementById("telephoneNotNull").style.display = "block";
        } else {
            document.getElementById("telephoneNotNull").style.display = "none";
        }
    }

    document.getElementById("telephone").onfocus = function () {
        document.getElementById("telephoneNotNull").style.display = "none";
    }

    document.getElementById("email").onblur = function () {
        var telephone = document.getElementById("email");
        if (telephone.value == "") {
            document.getElementById("emailNotNull").style.display = "block";
        } else {
            document.getElementById("emailNotNull").style.display = "none";
        }
    }

    document.getElementById("email").onfocus = function () {
        document.getElementById("emailNotNull").style.display = "none";
    }


    document.getElementById("password").onblur = function () {
        var username = document.getElementById("password");
        if (username.value == "") {
            document.getElementById("passwordNotNull").style.display = "block";
        } else {
            document.getElementById("passwordNotNull").style.display = "none";
        }
    }

    document.getElementById("password").onfocus = function () {
        document.getElementById("passwordNotNull").style.display = "none";
    }


    document.getElementById("button").onclick = function () {
        var username = document.getElementById("username");
        var telephone = document.getElementById("telephone");
        var email = document.getElementById("email");
        var password = document.getElementById("password");
        if ((username.value != "" || telephone.value != "" || email.value != "") && password.value != "") {
            document.getElementById("button").type = "submit";
            document.getElementById("buttonDiv").style.display = "none";
            document.getElementById("button").submit();
        } else {
            document.getElementById("button").type = "button";
            document.getElementById("buttonDiv").style.display = "block";
        }
    }

    document.getElementById("button").onmouseout = function () {
        document.getElementById("button").type = "button";
        document.getElementById("buttonDiv").style.display = "none";
    }


</script>
</html>
