<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles-extras" prefix="tilesx" %>
<%@ taglib prefix="date" uri="/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<div>
    <%--用自定义标签显示当前时间--%>
    <date:date value="<%=System.currentTimeMillis()%>" pattern="yyyy-MM-dd HH:mm:ss" />
</div>
<%--<c:out value="1" default=""--%>
<div class="container  hidden-xs">
    <div class="row header-top">
        <p class="col-xs-12 col-sm-6 col-md-6 col-lg-6">客服电话:010-594-78634</p>
        <div class="col-xs-12 col-sm-6 col-md-6 col-lg-6 text-right">
            <div>
                <c:choose>
                    <c:when test="${status!=null}">
                        <c:out value="欢迎${status}"/>
                        <a href="/logout" style="color: black;">退出登录</a>
                    </c:when>
                    <c:otherwise>
                        <a href="/toLogin" style="color: black;">登录</a>
                        <a href="/toRegister" style="color: black;">注册</a>
                    </c:otherwise>
                </c:choose>

                <a href="#" target="_blank"> <img alt=""  src="${pageContext.request.contextPath}/static/imges/t10/imges/54537.png"></a>
                <a href="#" target="_blank"><img alt=""  src="${pageContext.request.contextPath}/static/imges/t10/imges/45678678.png"></a>
                <a href="#" target="_blank"> <img alt=""  src="${pageContext.request.contextPath}/static/imges/t10/imges/54375483543.png"></a>
            </div>
        </div>
    </div>
</div>

<nav class="navbar navbar-default">
    <div class="container">
        <div class="navbar-header">
            <a href="#" class="navbar-brand">
                <img src="${pageContext.request.contextPath}/static/imges/t10/imges/logo.png" alt="Brand" class="img-responsive">
            </a>
            <button data-target="#open-nav" data-toggle="collapse" class="navbar-toggle btn-primary collapsed" aria-expanded="false">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
        </div>
        <div id="open-nav" class="navbar-collapse collapse" aria-expanded="false" style="height: 1px;">
            <ul class="nav navbar-nav navbar-right text-center list-inline">
                <li><a href="/home">首页</a></li>
                <li><a href="/u/home11">职业</a></li>
                <li><a href="/u/list">学员信息管理</a></li>
                <li><a href="">推荐</a></li>
                <li><a href="">关于</a></li>
            </ul>
        </div>

    </div>
</nav>