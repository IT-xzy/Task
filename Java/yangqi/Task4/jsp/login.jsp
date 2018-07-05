<%--
  Created by IntelliJ IDEA.
  User: Yzzzt
  Date: 2018/6/13
  Time: 14:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="container demo-1">
    <div class="content">
        <div id="large-header" class="large-header">
            <canvas id="demo-canvas"></canvas>
            <div class="logo_box">
                <h3>欢迎登陆</h3>
                <form action="${pageContext.request.contextPath }/user/doLogin" name="f" method="post">
                    <div class="input_outer">
                        <span class="u_user"></span>
                        <input name="name" class="text" style="color: #FFFFFF !important" type="text" placeholder="请输入账户">
                    </div>
                    <div class="input_outer">
                        <span class="us_uer"></span>
                        <input name="password" class="text" style="color: #FFFFFF !important; position:absolute; z-index:100;" value="Password" type="password" placeholder="请输入密码">
                    </div>
                    <%--<div class="submit"><input type="submit" ></div>--%>
                    <input class="act-but submit" href="javascript:;" style="color: #FFFFFF" type="submit" name="" id="" value="登陆"/>
                    &nbsp;&nbsp;<button><a
                        href="/user/register">注册</a></button>
                    <%--<form action="${pageContext.request.contextPath }/user/Register" method="post"></form>
                    <input class="act-but submit" href="javascript:;" style="color: #FFFFFF" type="submit" name="" id="" value="注册">--%>
                    <p><a href="#">忘记密码 ?</a></p>
                    <%--<div class="mb2"><a class="act-but submit" href="javascript:;" style="color: #FFFFFF" type="submit" name="" id="" >登陆</a></div>--%>
                </form>
            </div>
        </div>
    </div>
</div><!-- /container --><!-- /container -->
<%--
<audio id="bgmMusic" src="/static/music/123.mp3" preload="auto" type="audio/mp3" autoplay loop></audio>
--%>
<script src="/static/js/TweenLite.min.js"></script>
<script src="/static/js/EasePack.min.js"></script>
<script src="/static/js/rAF.js"></script>
<script src="/static/js/demo-1.js"></script>
<div style="text-align:center;">
    <p>Template by<a href="${pageContext.request.contextPath }/home">.技能树.</a></p>
</div>