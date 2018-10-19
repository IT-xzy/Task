<%--
  Created by IntelliJ IDEA.
  User: zyq
  Date: 2018/8/21
  Time: 17:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<!--头部-->
<header class="header">
    <div class="header-content">
        <div class="header-content_center">
            <div class="header-left" >客服热线：010-594-78634
            </div>
            <div class="header-right">
                <img class="img-header" src="/img/css8/header-1.png">
                <img class="img-header" src="/img/css8/header-2.png">
                <img class="img-header" src="/img/css8/header-3.png">
            </div>
        </div>
    </div>
    <div class="header-nav">
        <div class="header-nav_center">
            <img class="center_img" src="/img/css8/jnshu.png">
            <div class="nav">
                <a class="nav_a" href="/profession">职业</a>
                <a class="nav_a" href="/about">关于</a>
                <%--<a class="nav_a" href="#">推荐</a>--%>
                <a class="nav_a" href="/index">首页</a>
            </div>
            <div class="nav--small">
                <input class="nav-button" type="checkbox" id="nav--small_button">
                <div class="nav--small_right">
                    <label class="drop-down_button icon-menu" for="nav--small_button"></label>
                </div>
                <div class="drop-down">
                    <a class="drop_a" href=/index">首页</a>
                    <a class="drop_a" href="/profession">职业</a>
                    <%--<a class="drop_a" href="#">推荐</a>--%>
                    <a class="drop_a" href="/about">关于</a>
                </div>
            </div>
        </div>
    </div>
</header>
</body>
</html>
