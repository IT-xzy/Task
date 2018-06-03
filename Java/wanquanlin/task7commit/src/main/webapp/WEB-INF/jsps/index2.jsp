<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/4/4
  Time: 17:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<div id="picture" class="carousel slide" data-ride="carousel">
    <ol class="carousel-indicator">
        <li data-target="#picture" data-slide-to="0" class="active"></li>
        <li data-target="#picture" data-slide-to="1" class></li>
        <li data-target="#picture" data-slide-to="3" class></li>
    </ol>

    <div class="carousel-inner" role="listbox">
        <div class="item active">
            <c:forEach items="${images1}" var="q" begin="0" end="0">
                <img src=${q.picture}>
            </c:forEach>
        </div>
        <c:forEach items="${images1}" var="q" begin="1" end="2">
            <div class="item">
                <img src=${q.picture}>
            </div>
        </c:forEach>
    </div>
    <a class="left carousel-control" href="#picture" role="button" data-slide="prev">
        <span class="glyphicon glyphicon-chevron-left spanModefy" aria-hidden="true "></span>
    </a>
    <a class="right carousel-control" href="#picture" role="button" data-slide="next">
            <span class="glyphicon glyphicon-chevron-right spanModefy" aria-hidden="true"></span>
    </a>
</div>
<div class="container">
    <div class="row">
        <div class="col-xs-12 col-md-3">
            <div class="battle"></div>
            <p>战役模式</p>
            <span class="spanModefy">感受波澜壮阔、惊险刺激的冒险之旅，和想要摧毁我们所有人的猩红军团战斗，夺回我们的家园，人类最后的避难所。</span>
        </div>
        <div class="col-xs-12 col-md-3">
            <div class="teamwork"></div>
            <p>合作模式</p>
            <span class="spanModefy">与朋友一起，或与其他守护者匹配，组成最多为3人的小组渗透入对方堡垒，击败所有潜在威胁。</span>
        </div>
        <div class="col-xs-12 col-md-3">
            <div class="multiplayer"></div>
            <p>多人竞技</p>
            <span class="spanModefy">对抗最危险的敌人——其他玩家，在4v4比赛中证明自己的竞技实力。</span>
        </div>
        <div class="col-xs-12 col-md-3">
            <div class="person">
                <div class="people">${numberofstudent}</div>
                <span class="spanModefy">累计在线玩家</span>
                <div class="people">${numberofgraduate}</div>
                <span class="spanModefy">VIP玩家</span>
            </div>
        </div>
    </div>
</div>
<div class="container study">
    <div class="row">
        <div class="col-xs-12 col-md-12 text-title">如何购买</div>

        <div class="col-xs-12 col-md-3 study-page">
            <div class="number">1</div>
            <div class="path-text">选择版本</div>
        </div>

        <div class="col-xs-12 col-md-3 study-page">
            <div class="number">2</div>
            <div class="path-text">选择平台</div>
        </div>

        <div class="col-xs-12 col-md-3 study-page">
            <div class="number">3</div>
            <div class="path-text"> 选择地区</div>
        </div>
        <div class="col-xs-12 col-md-3 study-page">
            <div class="number">4</div>
            <div class="path-text">选择零售商</div>
        </div>
    </div>
</div>
<div class="container list">
    <div class="row">
        <div class="col-xs-12 col-md-12 list-show">职业展示</div>
        <c:forEach items="${goodstudent}" var="s">
            <div class="col-xs-12 col-md-4 faker">
                <div class="student">
                    <img src="${s.picture}">
                    <p>${s.name}</p>
                    <span class="spanModefy">${s.job}
                    </span>
                </div>
            </div>
        </c:forEach>
    </div>
</div>
<div class="container hidden-xs company">
    <div class="hezuo">
        <a href="task8-2.html ">战略合作企业</a>
    </div>
    <div class="row">
        <a href class="alibaba"></a>
        <a href class="jinshanyun"></a>
        <a href class="huanxin"></a>
        <a href class="ronglian"></a>
        <a href class="qiniu"></a>
    </div>
</div>
<div class="link hidden-sm">
    <div class="container">
        <div class="frind">友情链接</div>
        <div class="frind-text row">
            <ul>
                <li><a href="#">手机软件</a></li>
                <li><a href="#">教师招聘</a></li>
                <li><a href="#">找工作</a></li>
                <li><a href="#">教师招聘</a></li>
                <li><a href="#">找工作</a></li>
                <li><a href="#">手机软件</a></li>
                <li><a href="#">教师招聘</a></li>
                <li><a href="#">找工作</a></li>
                <li><a href="#">教师招聘</a></li>
                <li><a href="#">找工作</a></li>
                <li><a href="#">手机软件</a></li>
                <li><a href="#">教师招聘</a></li>
                <li><a href="#">找工作</a></li>
                <li><a href="#">教师招聘</a></li>
                <li><a href="#">找工作</a></li>
                <li><a href="#">手机软件</a></li>
                <li><a href="#">教师招聘</a></li>
                <li><a href="#">找工作</a></li>
                <li><a href="#">教师招聘</a></li>
                <li><a href="#">找工作</a></li>

            </ul>
        </div>
    </div>
</div>
</body>
</html>
