<%--
  Created by IntelliJ IDEA.
  User: luojiac
  Date: 2018/5/1
  Time: 下午8:32
  To change this template use File | Settings | File Templates.
--%>

<%--<!DOCTYPE html>--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="ex" uri="/WEB-INF/dateTag.tld" %>
<div class="container  hidden-xs">
    <div class="row header-top">
        <p class="col-xs-12 col-sm-6 col-md-6 col-lg-6">
            客服电话:010-594-78634
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <ex:ToDate time=""/>
        </p>
        <div class="col-xs-12 col-sm-6 col-md-6 col-lg-6 text-right">
            <div>
                <a href="#" target="_blank"> <img alt=""  src="/imges/54537.png"></a>
                <a href="#" target="_blank"><img alt=""  src="/imges/45678678.png"></a>
                <a href="#" target="_blank"> <img alt=""  src="/imges/54375483543.png"></a>
                <a href="/loginRegister" target="_self" style="color: green ;font-size: 16px;font-family:'Microsoft YaHei'">登录</a>
            </div>
        </div>
    </div>
    <a href="tencent://AddContact/?fromId=45&fromSubId=1&subcmd=all&uin=845634109&website=www.oicqzone.com" style="color: red">加QQ</a>
    <a href="tencent://message/?uin=845634109&Site=QQ交谈&Menu=yes" target="blank" style="color: blue">打开聊天框</a>
</div>

<nav class="navbar navbar-default">
    <div class="container">
        <div class="navbar-header">
            <a href="#" class="navbar-brand">
                <img src="/imges/logo.png" alt="Brand" class="img-responsive">
            </a>
            <button data-target="#open-nav" data-toggle="collapse" class="navbar-toggle btn-primary collapsed" aria-expanded="false">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
        </div>
        <div id="open-nav" class="navbar-collapse collapse" aria-expanded="false" style="height: 1px;">
            <ul class="nav navbar-nav navbar-right text-center list-inline">
                <li><a href="/">首页</a></li>
                <li><a href="/position">职业</a></li>
                <li><a href="/company">推荐</a></li>
                <li><a href="">关于</a></li>
                <li><a href="/listStudent">需要登录的展示列表</a></li>
            </ul>
        </div>
    </div>
</nav>

