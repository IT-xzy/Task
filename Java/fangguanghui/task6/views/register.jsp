<%--
  Created by IntelliJ IDEA.
  User: FGH
  Date: 2018/7/13
  Time: 12:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>注册界面</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/reset.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/common.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/font-awesome.min.css" />
</head>
<body>
<style>
    body {
        background-image: url("${pageContext.request.contextPath}/static/imges/logo_bg.jpg");
    }
</style>
<div class="wrap login_wrap">
    <div class="content">

        <div class="logo"></div>

        <div class="login_box">

            <div class="login_form">
                <div class="login_title">
                    注册
                </div>
                <form action="${pageContext.request.contextPath}/register" method="post">

                    <div class="form_text_ipt">
                        <input name="name" type="text" placeholder="手机号/邮箱" autocomplete="off">
                    </div>
                    <div class="ececk_warning"><span>手机号/邮箱不能为空</span></div>
                    <div class="form_text_ipt">
                        <input name="password" type="password" placeholder="密码" autocomplete="off">
                    </div>
                    <div class="ececk_warning"><span>密码不能为空</span></div>
                    <%--<div class="form_text_ipt">--%>
                        <%--<input name="repassword" type="password" placeholder="重复密码">--%>
                    <%--</div>--%>
                    <%--<div class="ececk_warning"><span>密码不能为空</span></div>--%>
                    <%--<div class="form_text_ipt">--%>
                        <%--<input name="MP" type="text" placeholder="验证码">--%>
                    <%--</div>--%>
                    <%--<div class="ececk_warning"><span>验证码不能为空</span></div>--%>

                    <div class="form_btn">
                        <button type="submit" onclick="register()">注册</button>
                    </div>
                    <div class="form_reg_btn">
                        <span>已有帐号？</span><a href="${pageContext.request.contextPath}/index">马上登录</a>
                    </div>
                </form>
                <div class="other_login">
                    <div class="left other_left">
                        <span>其它登录方式</span>
                    </div>

                    <%--<div class="right other_right">--%>
                        <%--<a href="#"><i class="fa fa-qq fa-2x"></i></a>--%>
                        <%--<a href="#"><i class="fa fa-weixin fa-2x"></i></a>--%>
                        <%--<a href="#"><i class="fa fa-weibo fa-2x"></i></a>--%>
                    <%--</div>--%>
                </div>
            </div>
        </div>
    </div>
</div>

<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js" ></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/common.js" ></script>
<div style="text-align:center;">
</div>
</body>
<script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript">
    <%--function register() {--%>
        <%--var url='\'${pageContext.request.contextPath}/register'--%>
        <%--$.ajax({--%>
            <%--url:url,--%>
            <%--type:POST,--%>
            <%--success:--%>
            <%--function (result) {--%>
                <%--if(result==0)--%>
                    <%--alert("用户已存在")--%>
            <%--}--%>
        <%--})--%>
    <%--}--%>
</script>
</html>

