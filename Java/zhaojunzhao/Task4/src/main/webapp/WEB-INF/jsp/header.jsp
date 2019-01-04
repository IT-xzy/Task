<%@ include file="../include/include.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="top container">
    <p class="hidden-xs">客服热线：010-594-78634</p>
    <p style="position: absolute;right: 20rem;">
        <c:forEach items="${msgList}" var="msg">
            <a style="color: #29b078;" href="/Tiles/${msg.getValue()}">${msg.getKey()}</a>
        </c:forEach>
    </p>
    <img src="${pageContext.request.contextPath}/imges/12321.gif">
</div>

<div role="navigation" class="nav1 navbar navbar-default">
    <div class="container">
        <div class="header-logo">
            <div class="logo-middle"><img src="${pageContext.request.contextPath}/imges/logo.png"></div>
        </div>
        <div class="navbar-header marginTop">
            <button data-target="#example-navbar-collapse" data-toggle="collapse" class="navbar-toggle" type="button">
                <span class="sr-only">切换导航</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
        </div>

        <div id="example-navbar-collapse" class=" collapse navbar-collapse">
            <ul class="nav navbar-nav">
                <a href="/Tiles/home"><li>首 页</li></a>
                <a href="/Tiles/job"><li class="border">职 业</li></a>
                <a href="/Tiles/student"><li>推 荐</li></a>
                <a href=""><li>关 于</li></a>
            </ul>
        </div>
    </div>
</div>