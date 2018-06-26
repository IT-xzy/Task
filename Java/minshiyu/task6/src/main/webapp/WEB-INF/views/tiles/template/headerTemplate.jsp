<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<div class="header">
    <!--1联系方式-->
    <div class="header-1">
        <div class="col-md-6  col-lg-4">
            <div class="top1">客服热线：010-594-78634</div>
        </div>
        <div class="col-md-6 col-lg-4">
            <div class="topright">
                <button class="button1" type="button"></button>
                <button class="button2" type="button"></button>
                <button class="button3" type="button"></button>
            </div>
        </div>
    </div>
    <!--title-->
    <div class=" row2">
        <div class="col-md-6 col-lg-4 col-lg-offset-2">
            <div class="logo">
                <img class="img-logo" src="${pageContext.request.contextPath}/static/img/技能树.png">
            </div>
        </div>
        <div class="col-md-6 col-lg-4">
            <button type="button" class="page2-button"></button>
            <div class="newbutton">
                <button type="submit" class="row2-button2 row2-button2:hover"><a
                        href="${pageContext.request.contextPath}/home"
                        style="color:#fff !important;text-decoration: none;">首页</a>
                </button>
                <button type="submit" class="row2-button2 row2-button2:hover"><a
                        href="${pageContext.request.contextPath}/u/occupation"
                        style="color:#fff !important;text-decoration: none;">职业</a>
                </button>
                <button type="submit" class="row2-button2 row2-button2:hover"><a
                        href="${pageContext.request.contextPath}/enterprise"
                        style="color:#fff !important;text-decoration: none;">推荐</a>
                </button>
                <button type="submit" class="row2-button2 row2-button2:hover"><a
                        href="${pageContext.request.contextPath}/login"
                        style="color:#fff !important;text-decoration: none;">登录</a>
                </button>
                <button type="submit" class="row2-button2 row2-button2:hover"><a
                        href="${pageContext.request.contextPath}/logout"
                        style="color:#fff !important;text-decoration: none;">登出</a>
                </button>
                <button type="submit" class="row2-button2 row2-button2:hover"><a
                        href="${pageContext.request.contextPath}/signup"
                        style="color:#fff !important;text-decoration: none;">注册</a>
                </button>
                <button class="row2-button4 row2-button4:hover" type="button">关于</button>
            </div>
        </div>
    </div>
</div>