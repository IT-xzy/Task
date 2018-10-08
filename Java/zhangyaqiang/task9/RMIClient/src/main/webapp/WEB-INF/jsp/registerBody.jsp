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
            width: 380px;
            text-align: center;
            line-height: 50px;
        }

        #hear li { /*第几个选项卡的样式，有几个选项卡就有几个*/
            width: 49.9%;
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
    <h2>注册页面</h2>
    <form action="/user" method="post" onkeydown="if(event.keyCode==13)return false;" id="form1">
        <table style="border: 1px solid chartreuse;background:#dddddd">
            <tr>
                <td colspan="2">
                    <!--选项卡列表，如果是底部选项卡，将hear fixed到底部，侧边栏重新设置css-->
                    <ul id="hear">
                        <!--带action的会默认选中-->
                        <li class="action" style="border-bottom: 1px solid #FF4200;">手机注册</li>
                        <li> 邮箱注册</li>
                    </ul>
                </td>
            </tr>
            <tr>
                <td style="width:80px;font-size: large" style="font-size: large" align="center">&nbsp;&nbsp;账号</td>
                <td style="width:160px"><input type="text" name="username" id="username">
                    <div id="usernameNotNull" style="display: none;color: red">账号不能为空</div>
                    <div id="usernameUnique" style="display: none;color: red">账号已存在</div>
                </td>
            </tr>
            <tr>
                <td style="font-size: large" align="center">&nbsp;&nbsp;密码</td>
                <td><input type="password" name="password" id="password">
                    <div id="passwordNotNull" style="display: none;color: red">密码不能为空</div>
                </td>
            </tr>
            <tr>
                <td style="font-size: large" align="center">确认密码</td>
                <td><input type="password" id="password2">
                    <div id="password2NotNull" style="display: none;color: red">两次密码不一致</div>
                </td>
            </tr>
            <!--选项卡内容列表-->
            <tr>
                <td colspan="2" style="font-size: large">
                    <ul id="content">
                        <!--带action的会默认显示-->
                        <li class="action" id="content1">
                            &ensp;&ensp;&ensp;&nbsp;手机号&emsp;&ensp;&ensp;
                            <input type="text" name="telephone" id="telephone">
                            <button type="button" style="width: 90px" id="sendMsgByTel" disabled="disabled">发送验证码
                            </button>
                        </li>
                        <li id="content2">
                            &thinsp;&thinsp;&ensp;&ensp;&ensp;&nbsp;邮箱&emsp;&ensp;&ensp;&ensp;
                            <input type="text" name="email" id="email">
                            <button type="button" style="width: 90px" id="sendMsgByEmail" disabled="disabled">发送验证码
                            </button>
                        </li>
                    </ul>
                    <div id="telephoneNotNull" style="display: none;color: red;font-size:medium" align="center">
                        请输入正确的手机号
                    </div>
                    <div id="telephoneUnique" style="display: none;color: red;font-size:medium" align="center">
                        该手机号已经注册
                    </div>
                    <div id="emailNotNull" style="display: none;color: red;font-size:medium" align="center">请输入正确格式的邮箱
                    </div>
                    <div id="emailUnique" style="display: none;color: red;font-size:medium" align="center">该邮箱已经注册</div>
                </td>

            </tr>
            <tr>
                <td style="font-size: large" align="center">验证码</td>
                <td><input type="text" id="message">
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <div id="msgFailure" style="display: none;color: red">验证码错误</div>
                </td>
            </tr>
            <tr align="center">
                <td colspan="2"><input type="button" style="height: 200%;width: 35%" id="button" value="提交">
                    <div id="buttonDiv" style="display: none;color: red">请填写所有的注册信息</div>
                </td>
            </tr>
            <tr align="center">
                <td colspan="2">
                    <h5>已注册?点击<a href="/login">登录</a></h5>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
<script>

    document.getElementById("username").onblur = function () {
        var username = document.getElementById("username");
        if (username.value == "") {
            document.getElementById("usernameNotNull").style.display = "block";
        } else {
            $.ajax({
                url: "/user/" + username.value,
                type: 'GET',
                dataType: 'json',
                success: function (data) { // http code 200
                    if (1 == data) {
                        document.getElementById("usernameUnique").style.display = "none";
                    } else {
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

    document.getElementById("username").onfocus = function () {
        document.getElementById("usernameUnique").style.display = "none";
        document.getElementById("usernameNotNull").style.display = "none";
    }

    document.getElementById("password").onblur = function () {
        var password = document.getElementById("password");
        var password2 = document.getElementById("password2");
        if (password.value == "") {
            document.getElementById("passwordNotNull").style.display = "block";
        } else if (password2.value != "" && password.value != password2.value) {
            document.getElementById("password2NotNull").style.display = "block";
        } else {
            document.getElementById("passwordNotNull").style.display = "none";
            document.getElementById("password2NotNull").style.display = "none";
        }
    }

    document.getElementById("password").onfocus = function () {
        document.getElementById("passwordNotNull").style.display = "none";
    }

    document.getElementById("password2").onblur = function () {
        var password = document.getElementById("password");
        var password2 = document.getElementById("password2");
        if (password.value != password2.value) {
            document.getElementById("password2NotNull").style.display = "block";
        } else {
            document.getElementById("password2NotNull").style.display = "none";
        }
    }

    document.getElementById("password2").onfocus = function () {
        document.getElementById("password2NotNull").style.display = "none";
    }

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
        if (index == 0) {
            document.getElementById("email").value = "";
            document.getElementById("emailNotNull").style.display = "none";
            document.getElementById("message").value = "";
            window.clearInterval(InterValObjByEmail);//停止计时器
            document.getElementById("sendMsgByEmail").innerHTML = ("发送验证码");
            document.getElementById("sendMsgByEmail").setAttribute("disabled", "disabled");
            document.getElementById("sendMsgByEmail").style.color = "";
            document.getElementById("msgFailure").style.display = "none";
            document.getElementById("buttonDiv").style.display = "none";
            document.getElementById("emailUnique").style.display = "none";
        } else if (index == 1) {
            document.getElementById("telephone").value = "";
            document.getElementById("telephoneNotNull").style.display = "none";
            document.getElementById("message").value = "";
            window.clearInterval(InterValObjByTel);//停止计时器
            document.getElementById("sendMsgByTel").innerHTML = ("发送验证码");
            document.getElementById("sendMsgByTel").setAttribute("disabled", "disabled");
            document.getElementById("sendMsgByTel").style.color = "";
            document.getElementById("msgFailure").style.display = "none";
            document.getElementById("buttonDiv").style.display = "none";
            document.getElementById("telephoneUnique").style.display = "none";
        }
    });

    document.getElementById("telephone").onblur = function () {
        var phoneReg = /(^1[3|4|5|7|8]\d{9}$)/;
        var telephone = document.getElementById("telephone");
        if (telephone.value != "") {
            if (!phoneReg.test(telephone.value)) {
                document.getElementById("telephoneNotNull").style.display = "block";
                document.getElementById("sendMsgByTel").setAttribute("disabled", "disabled");
            } else {
                $.ajax({
                    url: "/user/telUnique/" + telephone.value,
                    type: 'GET',
                    dataType: 'json',
                    success: function (data) { // http code 200
                        if (1 == data) {
                            document.getElementById("telephoneUnique").style.display = "none";
                            document.getElementById("sendMsgByTel").removeAttribute("disabled");
                        } else {
                            document.getElementById("telephoneUnique").style.display = "block";
                            document.getElementById("sendMsgByTel").setAttribute("disabled", "disabled");
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
            }
        } else {
            document.getElementById("sendMsgByTel").setAttribute("disabled", "disabled");
        }
    }

    document.getElementById("telephone").onfocus = function () {
        document.getElementById("telephoneNotNull").style.display = "none";
        document.getElementById("telephoneUnique").style.display = "none";
    }

    document.getElementById("email").onblur = function () {
        var emailReg = new RegExp("^[a-z0-9A-Z]+[-|a-z0-9A-Z._]+@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-z]{2,}$");
        var email = document.getElementById("email");
        if (email.value != "") {
            if (!emailReg.test(email.value)) {
                document.getElementById("emailNotNull").style.display = "block";
                document.getElementById("sendMsgByEmail").setAttribute("disabled", "disabled");
            } else {
                $.ajax({
                    url: "/user/" + email.value + "/emailUnique",
                    type: 'GET',
                    dataType: 'json',
                    success: function (data) { // http code 200
                        if (1 == data) {
                            document.getElementById("emailUnique").style.display = "none";
                            document.getElementById("sendMsgByEmail").removeAttribute("disabled");
                        } else {
                            document.getElementById("emailUnique").style.display = "block";
                            document.getElementById("sendMsgByEmail").setAttribute("disabled", "disabled");
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
            }
        } else {
            document.getElementById("sendMsgByEmail").setAttribute("disabled", "disabled");
        }
    }

    document.getElementById("email").onfocus = function () {
        document.getElementById("emailNotNull").style.display = "none";
        document.getElementById("emailUnique").style.display = "none";
    }

    var InterValObjByTel; //timer变量，控制时间

    var countByTel = 60; //间隔函数，1秒执行
    var curCountByTel;//当前剩余秒数
    //timer处理函数
    function SetRemainTimeByTel() {
        if (curCountByTel == 0) {
            window.clearInterval(InterValObjByTel);//停止计时器
            document.getElementById("sendMsgByTel").style.color = "";
            document.getElementById("sendMsgByTel").removeAttribute("disabled");//启用按钮
            document.getElementById("sendMsgByTel").innerHTML = "重新发送";
        }
        else {
            curCountByTel--;
            document.getElementById("sendMsgByTel").innerHTML = ("重新发送(" + curCountByTel + ")");
        }
    }

    document.getElementById("sendMsgByTel").onclick = function () {
        document.getElementById("sendMsgByTel").style.color = "red";
        var telephone = document.getElementById("telephone");
        $.ajax({
            url: "/user/tel/" + telephone.value,
            type: 'GET',
            dataType: 'json',
            success: function (data) { // http code 200
                if (0 == data) {
                    curCountByTel = countByTel;
                    document.getElementById("sendMsgByTel").setAttribute("disabled", "disabled");
                    document.getElementById("sendMsgByTel").innerHTML = ("重新发送(" + curCountByTel + ")");
                    InterValObjByTel = window.setInterval(SetRemainTimeByTel, 1000); //启动计时器，1秒执行一次请求后台发送验证码
                } else if (2 == data) {
                    alert("发送冷中,1分钟后再试");
                    document.getElementById("sendMsgByTel").style.color = "";
                } else if (3 == data) {
                    alert("今日已发送3次，明日再试");
                    document.getElementById("sendMsgByTel").style.color = "";
                } else {
                    document.getElementById("sendMsgByTel").innerHTML = "今天注册名额已用尽";
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
    }

    var InterValObjByEmail; //timer变量，控制时间

    var countByEmail = 60; //间隔函数，1秒执行
    var curCountByEmail;//当前剩余秒数
    //timer处理函数
    function SetRemainTimeByEmail() {
        if (curCountByEmail == 0) {
            window.clearInterval(InterValObjByEmail);//停止计时器
            document.getElementById("sendMsgByEmail").style.color = "";
            document.getElementById("sendMsgByEmail").removeAttribute("disabled");//启用按钮
            document.getElementById("sendMsgByEmail").innerHTML = "重新发送";
        }
        else {
            curCountByEmail--;
            document.getElementById("sendMsgByEmail").innerHTML = ("重新发送(" + curCountByEmail + ")");
        }
    }

    document.getElementById("sendMsgByEmail").onclick = function () {
        var email = document.getElementById("email");
        document.getElementById("sendMsgByEmail").style.color = "red";
        $.ajax({
            url: "/user/" + email.value + "/email",
            type: 'GET',
            dataType: 'json',
            success: function (data) { // http code 200
                if (0 == data) {
                    curCountByEmail = countByEmail;
                    document.getElementById("sendMsgByEmail").setAttribute("disabled", "disabled");
                    document.getElementById("sendMsgByEmail").innerHTML = ("重新发送(" + curCountByEmail + ")");
                    InterValObjByEmail = window.setInterval(SetRemainTimeByEmail, 1000); //启动计时器，1秒执行一次请求后台发送验证码
                } else {
                    document.getElementById("sendMsgByEmail").innerHTML = "今天注册名额已用尽";
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

    }

    document.getElementById("button").onclick = function () {
        var username = document.getElementById("username");
        var password = document.getElementById("password");
        var password2 = document.getElementById("password2");
        var usernameUnique = document.getElementById("usernameUnique");
        var telephone = document.getElementById("telephone");
        var telephoneNotNull = document.getElementById("telephoneNotNull");
        var email = document.getElementById("email");
        var emailNotNull = document.getElementById("emailNotNull");
        var message = document.getElementById("message");
        var button = document.getElementById("button");
        if (telephone.value != "" && message.value != "") {
            $.ajax({
                url: "/user/verifyMsg/tel/" + telephone.value + "/" + message.value,
                type: 'GET',
                dataType: 'json',
                success: function (data) { // http code 200
                    if (0 == data) {
                        if (username.value != "" && password.value != "" && password.value == password2.value && usernameUnique.style.display == "none"
                            && ((telephone.value != "" && telephoneNotNull.style.display == "none") || (email.value != "" && emailNotNull.style.display == "none"))) {
                            button.type = "submit";
                            document.getElementById("form1").submit();
                            document.getElementById("buttonDiv").style.display = "none";
                        } else {
                            document.getElementById("buttonDiv").style.display = "block";
                            telephone.value = "";
                            message.value = "";
                            window.clearInterval(InterValObjByTel);//停止计时器
                            document.getElementById("sendMsgByTel").innerHTML = ("发送验证码");
                            document.getElementById("sendMsgByTel").setAttribute("disabled", "disabled");
                            document.getElementById("sendMsgByTel").style.color = "";
                            document.getElementById("msgFailure").style.display = "none";
                            button.type = "button";
                        }
                    } else {
                        document.getElementById("msgFailure").style.display = "block";
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
        } else if (email.value != "" && message.value != "") {
            $.ajax({
                url: "/user/verifyMsg/email/" + email.value + "/" + message.value,
                type: 'GET',
                dataType: 'json',
                success: function (data) { // http code 200
                    if (0 == data) {
                        if (username.value != "" && password.value != "" && password.value == password2.value && usernameUnique.style.display == "none"
                            && ((telephone.value != "" && telephoneNotNull.style.display == "none") || (email.value != "" && emailNotNull.style.display == "none"))) {
                            button.type = "submit";
                            document.getElementById("form1").submit();
                            document.getElementById("buttonDiv").style.display = "none";
                        } else {
                            document.getElementById("buttonDiv").style.display = "block";
                            email.value = "";
                            message.value = "";
                            window.clearInterval(InterValObjByEmail);//停止计时器
                            document.getElementById("sendMsgByEmail").innerHTML = ("发送验证码");
                            document.getElementById("sendMsgByEmail").setAttribute("disabled", "disabled");
                            document.getElementById("sendMsgByEmail").style.color = "";
                            document.getElementById("msgFailure").style.display = "none";
                            button.type = "button";
                        }
                    } else {
                        document.getElementById("msgFailure").style.display = "block";
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
        } else {
            document.getElementById("buttonDiv").style.display = "block";
        }
    }

    document.getElementById("message").onkeyup = function () {
        document.getElementById("msgFailure").style.display = "none";
    }

    document.getElementById("button").onmouseout = function () {
        document.getElementById("buttonDiv").style.display = "none";
    }

</script>
</html>
