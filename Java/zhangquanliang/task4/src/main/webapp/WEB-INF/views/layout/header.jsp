<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<header>
    <div class="container logo">
        <span>客服热线：010-594-78634</span>
        <div class="img-amuse">
            <img src="/static/img/task8.2.png" height="24" width="25"/>
            <img src="/static/img/task8.1.png" height="24" width="25"/>
            <img src="/static/img/task8.png" height="24" width="25"/>
            &nbsp;
            <% String user=(String) session.getAttribute("USER_SESSION"); %>
            <% if(user==null||"".equals(user)){ %>
            <a class="btn btn-sm" href="${pageContext.request.contextPath}/u/login">登录</a>
            <a class="btn btn-sm" href="${pageContext.request.contextPath}/u/reg">注册</a>
            <%
            }else{
            %>
            <i style="color: #000000; font-size: x-small">欢迎：&nbsp;<%=user %> </i>
            <a class="btn btn-sm" href="${pageContext.request.contextPath}/u/logout">注销</a>
            <%
                }
            %>
        </div>
    </div>

    <nav class="navbar navbar-default" id="header" role="navigation">
        <div class="container">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse"
                        data-target="#example-navbar-collapse">
                    <span class="sr-only">切换导航</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="#">
                    <img src="/static/img/ptt8.png">
                </a>
            </div>
            <div class="collapse navbar-collapse" id="example-navbar-collapse">
                <ul class="nav navbar-nav" id="top">
                    <li><a href="/home">首页</a></li>
                    <li><a href="/profession">职业</a></li>
                    <li><a href="/recommend">推荐</a></li>
                    <li><a href="/u/user">用户信息</a></li>
                </ul>
            </div>
        </div>
    </nav>
</header>