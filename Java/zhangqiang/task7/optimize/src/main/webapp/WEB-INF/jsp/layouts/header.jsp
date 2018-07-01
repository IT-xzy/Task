<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--json标签 支持<json:object>--%>
<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>
<%--page 支持EL表达式 ${name}--%>
<%@ page isELIgnored="false" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/5/22
  Time: 17:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<div class="container">
    <div class="row">
        <div class="col-md-4 service-none">
            <div class="head-left">
                <div class="service">客服热线: 010-594-78634</div>
            </div>
        </div>
        <div class="col-md-8">
            <div class="head-right">
                <c:if test="${!empty onlineT}">
                    <span>当前在线人数:${onlineT}</span>
                </c:if>
                <c:if test="${!empty sessionScope.username}" >
                    <span>登录用户${onlineT}个</span>&nbsp;
                <span>欢迎!&nbsp;${sessionScope.username}</span>
                    <%--<from action="/u/login" method="POST"><input type="hidden" name="_method" value="DELETE"/><button type="submit">退出登录</button></from>--%>
                    <a href="/u/e">退出登录</a>
                </c:if>
                <c:if test="${empty sessionScope.username}" var="sessionname">
                    <a href="/u/login">登录</a><a href="/u/reg"> 注冊</a>
                </c:if>
                <img src="${pageContext.request.contextPath}/stat/images/1-task8.png">
                <img src="${pageContext.request.contextPath}/stat/images/2-task8.png">
                <img src="${pageContext.request.contextPath}/stat/images/3-task8.png">
            </div>
        </div>
    </div>
</div>
<header>
    <div class="container">
        <div class="row">
            <div class="col-md-4 col-sm-4 col-xs-4">
                <div class="header-left">
                    <div class="logo"></div>
                </div>
            </div>
            <div class="col-md-8 col-sm-8 col-xs-8">
                <nav class="navbar navbar-default" role="navigation">
                    <div class="container-fluid">
                        <div class="navbar-header">
                            <button type="button" class="navbar-toggle" data-toggle="collapse"
                                    data-target="#example-navbar-collapse">
                                <span class="sr-only">切换导航</span>
                                <img src="${pageContext.request.contextPath}/stat/images/26-task8.png" class="img-nav">
                            </button>
                        </div>
                    </div>
                </nav>
            </div>
            <div class="collapse navbar-collapse" id="example-navbar-collapse">
                <ul class="nav navbar-nav">
                    <li class="active"><a href="/home" class="navigation">首页</a></li>
                    <li><a href="/u/profession" class="navigation">职业</a></li>
                    <li><a href="/u/commend" class="navigation">推荐</a></li>
                    <li><a href="/u/list" class="navigation">列表页</a></li>
                    <li><a href="#" class="navigation">关于</a></li>
                </ul>
            </div>
        </div>
    </div>
</header>
