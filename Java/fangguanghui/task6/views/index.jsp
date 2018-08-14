<%--
  Created by IntelliJ IDEA.
  User: FGH
  Date: 2018/7/13
  Time: 17:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>登录界面</title>
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
                    登录
                </div>
                <form action="${pageContext.request.contextPath}/index" method="post">
                    <div>
                        <img src=""/>
                    </div>
                    <div class="form_text_ipt">
                        <input name="name" type="text" placeholder="手机号/邮箱">
                    </div>
                    <div class="ececk_warning"><span>手机号/邮箱不能为空</span></div>
                    <div class="form_text_ipt">
                        <input name="password" type="password" placeholder="密码">
                    </div>
                    <div class="ececk_warning"><span>密码不能为空</span></div>
                    <div class="form_check_ipt">
                        <div class="left check_left">
                            <%--<label><input name="" type="checkbox"> 下次自动登录</label>--%>
                            <select name="saveTime">
                                <option value="-1">会话</option>
                                <option value="7">一周</option>
                                <option value="30">一个月</option>
                            </select><br/>
                        </div>
                        <div class="right check_right">
                            <a href="#">忘记密码</a>
                        </div>
                    </div>
                    <div class="form_btn">
                        <button type="submit" >登录</button>
                    </div>
                    <div class="form_reg_btn">
                        <span>还没有帐号？</span><a href="${pageContext.request.contextPath}/toMsg_register">马上注册</a>
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
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery.min.js" ></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/common.js" ></script>
<div style="text-align:center;">
</div>
</body>
</html>
