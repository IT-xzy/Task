<%--
  Created by IntelliJ IDEA.
  User: Yzzzt
  Date: 2018/6/13
  Time: 17:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div id="login_bg" class ="login_bg" style="background-image:url(${pageContext.request.contextPath }/static/images/u3.jpg);"></div>
<div class="login_header">
    <span></span>
</div>

<div class="container">
    <div class="form_header">
        <h1 id="logo">Register</h1>
        <h2 id="subheading">To follow me,just sign up</h2>
    </div>
    <div class="signup_forms" class="signup_forms">
        <div id="signup_forms_container" class="signup_forms_container">

            <form class="signup_form_form" id="sign_form" method="post" action="${pageContext.request.contextPath }/Register">
                <div class="signup_account" id="signup_account">
<%--                    <div class="form_user">
                        <input type="text" name="email" placeholder="Email" id="signup_email">
                    </div>--%>
                    <div class="form_username">
                        <input type="text" name="name" placeholder="name" id="name">
                    </div>
                    <div class="form_password">
                        <input type="password" name="password" placeholder="Password" id="password">
                    </div>
<%--                    <div class="form_confirm_password">
                        <input type="password"  placeholder="Confirm the password" id="signup_confirm_password">
                    </div>--%>
                </div>
        </div>
        <input type="submit" id="signup_forms_submit" ><span style="font-size:16px;"><strong>Sign up</strong></span></input>
<%--        <input class="act-but submit" href="javascript:;" style="color: #FFFFFF" type="submit" name="" id="" value="注册">--%>
    </div>
    </form>

</div>

<div class="footer">
    <div class="footer_signup_link">
        <a class="signup_link" href="${pageContext.request.contextPath }/login">Log in</a>
        <a href="../../index.html" target="_blank" class="link unnamed_1">index</a>
        <a href="../../index.html" target="_blank" class="link unnamed_2">Contact</a>
    </div>
    <div class="design_show">
        <div class="designer_info">
            <a href="https://shop303982252.taobao.com">Designed by Class 2 Software 11 <strong style="font-family:'微软雅黑'">qq空间</strong></a>
            <a href="#" target="_blank" class="face"><img id="face" src="${pageContext.request.contextPath }/static/images/face.jpg" alt="designed by RayZhang"/></a>
        </div>
    </div>
</div>

<%--
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="container demo-1">
    <div class="content">
        <div id="large-header" class="large-header">
            <canvas id="demo-canvas"></canvas>
            <div class="logo_box">
                <h3>欢迎注册</h3>
                <form action="${pageContext.request.contextPath }/Register" name="f" method="post">
                    <div class="input_outer">
                        <span class="u_user"></span>
                        <input name="name" class="text" style="color: #FFFFFF !important" type="text" placeholder="请输入账户">
                    </div>
                    <div class="input_outer">
                        <span class="us_uer"></span>
                        <input name="password" class="text" style="color: #FFFFFF !important; position:absolute; z-index:100;" value="Password" type="password" placeholder="请输入密码">
                    </div>
                    &lt;%&ndash;<div class="submit"><input type="submit" ></div>&ndash;%&gt;
                    <input class="act-but submit" href="javascript:;" style="color: #FFFFFF" type="submit" name="" id="" value="注册"/>
                    &nbsp;&nbsp;<button><a
                        href="register">返回</a></button>

                    &lt;%&ndash;<form action="${pageContext.request.contextPath }/User/Register" method="post"></form>
                    <input class="act-but submit" href="javascript:;" style="color: #FFFFFF" type="submit" name="" id="" value="注册">&ndash;%&gt;
                    &lt;%&ndash;<div class="mb2"><a class="act-but submit" href="javascript:;" style="color: #FFFFFF" type="submit" name="" id="" >登陆</a></div>&ndash;%&gt;
                </form>
            </div>
        </div>
    </div>
</div><!-- /container --><!-- /container -->
&lt;%&ndash;
<audio id="bgmMusic" src="/static/music/123.mp3" preload="auto" type="audio/mp3" autoplay loop></audio>
&ndash;%&gt;
<script src="/static/js/TweenLite.min.js"></script>
<script src="/static/js/EasePack.min.js"></script>
<script src="/static/js/rAF.js"></script>
<script src="/static/js/demo-1.js"></script>
<div style="text-align:center;">
    <p>Template by<a href="${pageContext.request.contextPath }/home">.技能树.</a></p>
</div>
--%>
