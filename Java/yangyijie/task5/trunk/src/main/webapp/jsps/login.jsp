<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"><head>
    <title>J2web</title>
    <meta name="keywords" content="Lava FAQ" />
    <meta name="description" content="Lava FAQ" />
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <script type="text/javascript" src="${pageContext.request.contextPath}/t8/script/jquery-1.9.0.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/t8/script/login/login.js"></script>
    <link href="${pageContext.request.contextPath}/t8/css/login2.css" rel="stylesheet" type="text/css" />
    <link href="${pageContext.request.contextPath}/t8/css/loading.css" rel="stylesheet" type="text/css" />
</head>
<body>
<h1>J2web<sup>V2018</sup></h1>

<div class="login" style="margin-top:50px;">

    <div class="header">
        <div class="switch" id="switch"><a class="switch_btn_focus" id="switch_qlogin" href="javascript:void(0);" tabindex="7">快速登录</a>
            <a class="switch_btn" id="switch_login" href="javascript:void(0);" tabindex="8">快速注册</a><div class="switch_bottom" id="switch_bottom" style="position: absolute; width: 64px; left: 0px;"></div>
        </div>
    </div>


    <div class="web_qr_login" id="web_qr_login" style="display: block; height: 235px;">

        <!--登录-->
        <div class="web_login" id="web_login">


            <div class="login-box">


                <div class="login_form">
                    <form action="${pageContext.request.contextPath}/loginPage" name="loginform" accept-charset="utf-8" id="login_form" class="loginForm" method="post">
                        <input type="hidden" name="did" value="0"/>
                        <input type="hidden" name="to" value="log"/>

                        <div class="loginHint" id="loginHint">${param.intro}</div>

                        <div class="uinArea" id="uinArea">
                            <label class="input-tips" for="u">帐号：</label>
                            <div class="inputOuter" id="uArea">

                                <input type="text" id="u" name="userName" class="inputstyle"/>
                            </div>
                        </div>
                        <div class="pwdArea" id="pwdArea">
                            <label class="input-tips" for="p">密码：</label>
                            <div class="inputOuter" id="pArea">

                                <input type="password" id="p" name="passWord" class="inputstyle"/>
                            </div>
                        </div>

                        <div style="padding-left:50px;margin-top:20px;"><input type="submit" value="登 录" style="width:150px;" class="button_blue"/></div>
                    </form>
                </div>

            </div>

        </div>
        <!--登录end-->
    </div>

    <!--注册-->
    <div class="qlogin" id="qlogin" style="display: none; ">

        <div class="web_login"><form name="form2" id="regUser" accept-charset="utf-8"  action="${pageContext.request.contextPath}/regUser" method="post">
            <input type="hidden" name="to" value="reg"/>
            <input type="hidden" name="did" value="0"/>
            <ul class="reg_form" id="reg-ul">
                <div id="userCue" class="cue">快速注册请注意格式</div>
                <li>

                    <label for="user"  class="input-tips2">用户名：</label>
                    <div class="inputOuter2">
                        <input type="text" id="user" name="userName" maxlength="16" class="inputstyle2"/>
                    </div>

                </li>

                <li>
                    <label for="passwd" class="input-tips2">密码：</label>
                    <div class="inputOuter2">
                        <input type="password" id="passwd" name="passWord" maxlength="16" class="inputstyle2"/>
                    </div>

                </li>
                <li>
                    <label for="passwd2" class="input-tips2">确认密码：</label>
                    <div class="inputOuter2">
                        <input type="password" id="passwd2" name="" maxlength="16" class="inputstyle2" />
                    </div>

                </li>

                <li>
                    <label for="qq" class="input-tips2">邮箱：</label>
                    <div class="inputOuter2">

                        <input type="text" id="qq" name="email" maxlength="24" class="inputstyle2"/>
                    </div>

                </li>

                <li>
                    <div class="inputArea">
                        <input type="submit" id="reg"  style="margin-top:10px;margin-left:85px;" class="button_blue" value="注册"/> <a href="${pageContext.request.contextPath}/login" class="zcxy" target="_self" >已有账号></a>
                    </div>

                </li><div class="cl"></div>
            </ul></form>

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
<div class="jianyi">*使用ie8以上版本ie浏览器*爱J2web爱生活爱分享</div>
</body></html>