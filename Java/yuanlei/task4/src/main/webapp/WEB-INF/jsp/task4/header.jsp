<%--
  Created by IntelliJ IDEA.
  User: LL
  Date: 2018/4/14
  Time: 14:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"
         pageEncoding="UTF-8" import="java.util.*"%>
<%@ taglib uri="/tags" prefix="date"%>
<!DOCTYPE html>
<html>
<head>

</head>
<body>
<%--微信电话--%>
<%--顶部--%>
<%--<div class="dianhuaweixin">--%>
    <%--<div class="color-green font-size16 cursor top1-1">--%>
        <%--客户热线：010-594-78634--%>
    <%--</div>--%>
    <%--<span>--%>
             <%--<a id="box1" class="box" style="cursor:pointer; " href="/login">--%>
                <%--登陆--%>
            <%--</a>--%>
             <%--<a id="box2" class="box" style="cursor:pointer; " href="/register">--%>
                 <%--注册--%>
            <%--</a>--%>
             <%--<a id="box3" class="box" style="cursor:pointer; " href="/loginout">--%>
                 <%--登出--%>
            <%--</a>--%>
            <%--<a  id="box4" class="box" style="cursor:pointer; " href="/loginout">--%>
                 <%--user--%>
            <%--</a>--%>
            <%--<a style="cursor:pointer; ">--%>
                <%--<img class="vx" src="<%=request.getContextPath()%>/image/微信.png">--%>
            <%--</a>--%>
            <%--<a style="cursor:pointer;">--%>
                <%--<img class="vx" src="<%=request.getContextPath()%>/image/qq.png">--%>
            <%--</a>--%>
            <%--<a style="cursor:pointer;">--%>
                <%--<img class="vx" src="<%=request.getContextPath()%>/image/sina.png">--%>
            <%--</a>--%>
    <%--</span>--%>
<%--</div>--%>
<div class="container  hidden-xs">
    <div class="row header-top">
        <p class="col-xs-12 col-sm-6 col-md-6 col-lg-6">客服电话:010-594-78634</p>
        <div class="col-xs-12 col-sm-6 col-md-6 col-lg-6 text-right">
            <div>
                <a href="#" target="_blank"> <img alt=""  src="<%=request.getContextPath()%>/image/微信.png"></a>
                <a href="#" target="_blank"><img alt=""  src="<%=request.getContextPath()%>/image/qq.png"></a>
                <a href="#" target="_blank"> <img alt=""  src="<%=request.getContextPath()%>/image/sina.png"></a>
            </div>
        </div>
    </div>
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
            </ul>
        </div>
    </div>
</nav>
</body>
</html>
