<%@ taglib prefix="titles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <title>用户登录</title>
    <meta charset="utf-8" name="viewport" content="width=device-width" initial-scale=1  maximum-scale=1  minimum-scale=1  user-scalable=no>
    <link rel="stylesheet" href="/view/jnshu/css/home.css">
    <script src="/view/jnshu/js/jquery-3.2.1.min.js"></script>
    <link href="/view/jnshu/css/bootstrap.min.css" rel="stylesheet">
    <script src="/view/jnshu/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/view/jnshu/js/mylogin.js"></script>
    <link href="/view/jnshu/css/login2.css" rel="stylesheet" type="text/css"/>
</head>


<body>

<h1>IT</h1>

<div class="login" style="margin-top:50px;">

    <div class="header">
        <div class="switch" id="switch">
            <a class="switch_btn_focus" id="switch_qlogin" href="javascript:void(0);"
               tabindex="7">快速登录</a>
            <a class="switch_btn" id="switch_login" href="/a/sigin"
               tabindex="8">快速注册</a>
            <div class="switch_bottom" id="switch_bottom" style="position: absolute; width: 64px; left: 0px;"></div>
        </div>
    </div>

    <!--登录-->
    <div class="web_qr_login" id="web_qr_login" style="display: block; height: 235px;">


        <div class="web_login" id="web_login">


            <div class="login-box">


                <div class="login_form">
                    <form action="#" name="loginform" accept-charset="utf-8" id="login_form"
                          class="loginForm" method="post">
                        <input type="hidden" name="did" value="0"/>
                        <input type="hidden" name="to" value="log"/>

                        <div id="loginCue" class="cue">帐号：手机号/邮箱/用户名</div>

                        <div class="uinArea" id="uinArea">
                            <label class="input-tips" for="name">帐号：</label>
                            <div class="inputOuter" id="uArea">
                                <input type="text" id="name" name="name" class="inputstyle"/>
                            </div>
                        </div>
                        <div class="pwdArea" id="pwdArea">
                            <label class="input-tips" for="password">密码：</label>
                            <div class="inputOuter" id="pArea">

                                <input type="password" id="password" name="password" class="inputstyle"/>
                            </div>
                        </div>

                        <div style="padding-left:50px;margin-top:20px;"><input type="button" value="登 录"
                                                                               style="width:150px;"
                                                                               class="button_blue" id="login_button"/>
                            <a href="#" class="zcxy" target="_blank">忘记密码></a></div>

                    </form>
                </div>

            </div>

        </div>
        <!--登录end-->
    </div>

    <!--注册-->


</div>

<div class="jianyi">找个师兄，带你入门</div>

</body>

</html>