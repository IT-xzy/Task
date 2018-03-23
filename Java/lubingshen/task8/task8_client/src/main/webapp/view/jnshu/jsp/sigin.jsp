<%@ taglib prefix="titles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>用户注册</title>
    <meta charset="utf-8" name="viewport" content="width=device-width" initial-scale=1  maximum-scale=1  minimum-scale=1  user-scalable=no>
    <link rel="stylesheet" href="/view/jnshu/css/home.css">
    <script src="/view/jnshu/js/jquery-3.2.1.min.js"></script>
    <link href="/view/jnshu/css/bootstrap.min.css" rel="stylesheet">
    <script src="/view/jnshu/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/view/jnshu/js/mysigin.js"></script>
    <link href="/view/jnshu/css/login2.css" rel="stylesheet" type="text/css"/>
</head>

<body>

<h1>IT</h1>

<div class="login" style="margin-top:50px;">

    <div class="header">
        <div class="switch" id="switch">
            <a class="switch_btn_focus" id="switch_qlogin" href="javascript:void(0);"
               tabindex="7">手机号码注册</a>
            <a class="switch_btn" id="switch_login" href="javascript:void(0);" tabindex="8">邮箱注册</a>
            <div class="switch_bottom" id="switch_bottom" style="position: absolute; width: 64px; left: 14px;"></div>
        </div>
    </div>

    <!--手机号注册-->
    <div class="web_qr_login" id="web_qr_login" style="display: block; ">

        <div class="web_login">
            <form name="form1" id="phUser" accept-charset="utf-8"
                  action="/a/sign/cellphone"
                  method="post">
                <!--input type="hidden" name="to" value="reg"/-->
                <!--input type="hidden" name="did" value="0"/-->
                <ul class="reg_form" id="reg-ul">
                    <div id="userCue" class="cue">快速注册请注意格式</div>
                    <li>

                        <label for="puser" class="input-tips2">用户名：</label>
                        <div class="inputOuter2">
                            <input type="text" id="puser" name="userName" maxlength="10" class="inputstyle2"/>
                        </div>

                    </li>

                    <li>
                        <label for="phpasswd" class="input-tips2">密码：</label>
                        <div class="inputOuter2">
                            <input type="password" id="phpasswd" name="userKey" maxlength="16" class="inputstyle2"/>
                        </div>

                    </li>
                    <li>
                        <label for="phpasswd2" class="input-tips2">确认密码：</label>
                        <div class="inputOuter2">
                            <input type="password" id="phpasswd2" name="" maxlength="16" class="inputstyle2"/>
                        </div>

                    </li>

                    <li>
                        <label for="phoneNum" class="input-tips2">手机号码：</label>
                        <div class="inputOuter2">

                            <input type="text" id="phoneNum" name="cellphone" maxlength="11" class="inputstyle2"/>
                        </div>

                    </li>
                    <div>
                            <span id="phqyzm" class="hqyzm">
                                  <a href="javascript:void(0);" class="qyzm">获取验证码> </a>
                            </span>

                    </div>
                    <li>
                        <label for="phoneCode" class="input-tips2">验证码：</label>
                        <div class="inputOuter2">

                            <input type="text" id="phoneCode" name="phoneCode" maxlength="6" class="inputstyle2"/>
                        </div>

                    </li>

                    <li>
                        <div class="inputArea">
                            <input type="submit" id="phreg" style="margin-top:10px;margin-left:85px;"
                                   class="button_blue"
                                   value="手机注册"/> <a href="/a/login" class="zcxy"
                                                     target="_blank">已有账号></a>
                        </div>

                    </li>
                    <div class="cl"></div>
                </ul>
            </form>

        </div>

        <!--end-->
    </div>

    <!--邮箱注册-->
    <div class="qlogin" id="qlogin" style="display: none; ">

        <div class="web_login">
            <form name="form2" id="emUser" accept-charset="utf-8"
                  action="/a/mail/success"
                  method="post">
                <input type="hidden" name="to" value="reg"/>
                <input type="hidden" name="did" value="0"/>
                <ul class="reg_form" id="ereg-ul">
                    <div id="euserCue" class="cue">快速注册请注意格式</div>
                    <li>

                        <label for="euser" class="input-tips2">用户名：</label>
                        <div class="inputOuter2">
                            <input type="text" id="euser" name="name" maxlength="12" class="inputstyle2"/>
                        </div>

                    </li>

                    <li>
                        <label for="epasswd" class="input-tips2">密码：</label>
                        <div class="inputOuter2">
                            <input type="password" id="epasswd" name="password" maxlength="16" class="inputstyle2"/>
                        </div>

                    </li>
                    <li>
                        <label for="epasswd2" class="input-tips2">确认密码：</label>
                        <div class="inputOuter2">
                            <input type="password" id="epasswd2" name="" maxlength="16" class="inputstyle2"/>
                        </div>

                    </li>

                    <li>
                        <label for="email" class="input-tips2">邮箱：</label>
                        <div class="inputOuter2">

                            <input type="text" id="email" name="email" maxlength="24" class="inputstyle2"/>
                        </div>

                    </li>


                    <li>
                        <div class="inputArea">
                            <input type="submit" id="emailreg" style="margin-top:10px;margin-left:85px;"
                                   class="button_blue"
                                   value="邮箱注册"/> <a href="/a/login" class="zcxy"
                                                     target="_blank">已有账号></a>
                        </div>

                    </li>
                    <div class="cl"></div>
                </ul>
            </form>

        </div>

    </div>

</div>
<!-- loading start -->
<div class="spinner" id="loading">
    <div class="rect1"></div>
    <div class="rect2"></div>
    <div class="rect3"></div>
    <div class="rect4"></div>
    <div class="rect5"></div>
</div>
<!-- loading end -->
</div>
<!--注册end-->
</div>
<div class="jianyi">找个师兄，带你入门</div>

</body>

</html>