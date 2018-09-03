<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: ljl
  Date: 2018/7/30
  Time: 16:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="/tags" prefix="date"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="/css/bootstrap.min.css" rel="stylesheet" type="text/css">
<link href="/css/Untitled-1base.css" rel="stylesheet" type="text/css">

<%--<%
    HttpSession ses = request.getSession();
    String se = (String) ses.getAttribute("session");
    String username = se.split(",")[0];
%>
<%=request.setAttribute("username",username)%>--%>


<div class="container  hidden-xs">
    <div class="row header-top">

        <p class="col-xs-12 col-sm-6 col-md-6 col-lg-6">客服电话:010-594-78634</p>
        <div class="col-xs-12 col-sm-6 col-md-6 col-lg-6 text-right">
            <div>

                <a href="#" target="_blank"> <img alt=""  src="/images/54537.png"></a>
                <a href="#" target="_blank"><img alt=""  src="/images/45678678.png"></a>
                <a href="#" target="_blank"> <img alt=""  src="/images/54375483543.png">
                </a> 当前时间：<date:date value="${time} "/>
            </div>
        </div>
    </div>
</div>
<nav class="navbar navbar-default">
    <div class="container">
        <div class="navbar-header">
            <a href="#" class="navbar-brand">
                <img src="/images/logo.png" alt="Brand" class="img-responsive">
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
                <li><a href="/u/vocation">职业</a></li>
                <li><a href="">推荐</a></li>
                <li><a href="">关于</a></li>
                <c:if test="${username eq null}">
                <li><a href="/toLogin">登录</a></li>
                <li><a href="/toRegister">注册</a></li>
                </c:if>
                <c:if test="${username != null}">
                <li><a>${username}</a></li>
                <li><a href="/delCookie">退出登录</a> </li>
                </c:if>

            </ul>
        </div>

    </div>
</nav>
