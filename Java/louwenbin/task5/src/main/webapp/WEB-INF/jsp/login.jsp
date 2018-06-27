﻿
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>登陆界面</title>
    <%--<link href="./Wopop_files/style_log.css" rel="stylesheet" type="text/css">--%>
    <link rel="stylesheet" type="text/css" href="/css/style.css">
    <%--<link rel="stylesheet" type="text/css" href="/css/userpanel.css">--%>
    <link rel="stylesheet" type="text/css" href="/css/jquery.ui.all.css">
</head>


<body class="login">

<div class="login_m">
    <div class="login_logo"><h1>登陆管理界面</h1></div>
    ${返回通知}
    <div class="login_boder">
        <div class="login_padding">
            <form action="/login" method="POST">
                <h2>USERNAME</h2>
                <label>
                    <input type="text" id="name" name="name" class="txt_input txt_input2">
                </label>
                <h2>PASSWORD</h2>
                <label>
                    <input type="password" name="password" id="password" class="txt_input">
                </label>

                <p class="forgot"><a>Forgot your password?</a></p>

                <div class="rem_sub">
                    <div class="rem_sub_2">
                        <label>
                            <a href="/login" methods="POST">
                                <input type="submit" class="sub_button" name="button" id="login" value="Landing">
                            </a>
                        </label>
                    </div>
                </div>
                <div class="rem_sub">
                    <div class="rem_sub_l">
                        <a href="/regi">
                            <input type="button" class="sub_button" name="button" id="Registered" value="Registered">
                        </a>
                    </div>
                </div>

            </form>

        </div>


        <!--login_padding  Sign up end-->
    </div><!--login_boder end-->
</div><!--login_m end-->
<br> <br>


</body>
</html>