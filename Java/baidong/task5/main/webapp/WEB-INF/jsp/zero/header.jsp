<%@ page import="com.jnshu.Listener" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<!doctype html>
<html>

<body>
<div class="container  hidden-xs">
    <div class="row header-top">
        <p class="col-xs-12 col-sm-6 col-md-6 col-lg-6">客服电话:010-594-78634</p>
        <div class="col-xs-12 col-sm-6 col-md-6 col-lg-6 text-right">
            <div>
                在线人数为：<%=Listener.getActiveSessions() %>
                <a href="/a/register"><input type="button" value="注册"></a>
                <a href="/a/login"> <input type="button" value="登录"></a>
                <a href="#" target="_blank"> <img alt="" src="/imges/54537.png"></a>
                <a href="#" target="_blank"><img alt="" src="/imges/45678678.png"></a>
                <a href="#" target="_blank"> <img alt="" src="/imges/54375483543.png"></a>
                <a href="/a/u/logout"><input type="button" value="注销"></a>
            </div>
        </div>
    </div>
</div>

<nav class="navbar navbar-default">
    <div class="container">
        <div class="navbar-header">
            <a href="#" class="navbar-brand">
                <img src="/imges/logo.png" alt="Brand" class="/img-responsive">
            </a>
            <button data-target="#open-nav" data-toggle="collapse" class="navbar-toggle btn-primary collapsed"
                    aria-expanded="false">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
        </div>
        <div id="open-nav" class="navbar-collapse collapse" aria-expanded="false" style="height: 1px;">
            <ul class="nav navbar-nav navbar-right text-center list-inline">
                <li><a href="${pageContext.request.contextPath}/a/u/student/list">首页</a></li>
                <li><a href="${pageContext.request.contextPath}/a/u/career/list">职业</a></li>
                <li><a href="">推荐</a></li>
                <li><a href="">关于</a></li>
            </ul>
        </div>

    </div>
</nav>
</body>
</html>
