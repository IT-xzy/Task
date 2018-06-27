<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="java.util.*"%>
<%@ taglib uri="/tags" prefix="date"%>
<!DOCTYPE html>
<html>
<body>
<!--微信电话-->
<!--电话微信-->
<!--顶部-->
<div class="dianhuaweixin">
    <div class="color-green font-size16 cursor top1-1">
        客户热线：010-594-78634
    </div>
    <span>
             <a style="cursor:pointer; " href="/login">
                登陆
            </a>
             <a style="cursor:pointer; " href="/register">
                 注册
            </a>
            <a style="cursor:pointer; ">
                <img class="vx" src="<%=request.getContextPath()%>/image/微信.png">
            </a>
            <a style="cursor:pointer;">
                <img class="vx" src="<%=request.getContextPath()%>/image/qq.png">
            </a>
            <a style="cursor:pointer;">
                <img class="vx" src="<%=request.getContextPath()%>/image/sina.png">
            </a>
        </span>
</div>
<!--导航栏-->
<nav class=" navbar navbar-default" role="navigation">
    <div class="container-fluid backgroundcolor-green">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle " data-toggle="collapse" data-target="#navbar-menu">
                <span class="sr-only">切换导航</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a href="#" class="navbar-brand nav-title "></a>
        </div>
        <div class="collapse navbar-collapse " id="navbar-menu">
            <ul class="nav navbar-nav navbar-right ">
                <li class="lide"><a href="/home">当前系统时间：<date:date/></a><div class="kongbai"></div> </li>
                <li class="lide"><a href="/home">首页</a><div class="kongbai"></div> </li>
                <li class="lide"><a href="/job">职业</a><div class="kongbai"></div> </li>
                <li class="lide"><a href="/u/company">推荐</a><div class="kongbai"></div> </li>
                <li class="lide"><a href="task8-1.html">关于</a><div class="kongbai"></div> </li>
            </ul>
        </div>
    </div>
</nav>
</body>
</html>