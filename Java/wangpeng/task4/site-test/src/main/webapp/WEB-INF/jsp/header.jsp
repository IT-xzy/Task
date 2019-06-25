<%@page language="java" contentType="text/html; charset=UTF-8"
        pageEncoding="UTF-8" isErrorPage="true" isELIgnored="false" %>

<%--json taglib的C标签--%>
<!DOCTYPE html>
<html lang="en">

<body>
<div class="container  hidden-xs">
    <div class="row header-top">
        <p class="col-xs-12 col-sm-6 col-md-6 col-lg-6">客服电话:010-594-78634</p>

        <div class="col-xs-12 col-sm-6 col-md-6 col-lg-6 text-right">
            <div>
                <a href="#" target="_blank"> <img alt=""
                                                  src="${pageContext.request.contextPath}/static/images/54537.png"></a>
                <a href="#" target="_blank"><img alt=""
                                                 src="${pageContext.request.contextPath}/static/images/45678678.png"></a>
                <a href="#" target="_blank"> <img alt=""
                                                  src="${pageContext.request.contextPath}/static/images/54375483543.png"></a>
            </div>
        </div>
    </div>
</div>

<nav class="navbar navbar-default">
    <div class="container">
        <div class="navbar-header">
            <a href="#" class="navbar-brand">
                <img src="${pageContext.request.contextPath}/static/images/logo.png" alt="Brand" class="img-responsive">
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
                <li><a href="${pageContext.request.contextPath}/a/u/profession/list">职业</a></li>
                <li><a href="">推荐</a></li>
                <li><a href="">关于</a></li>
            </ul>
        </div>

    </div>
</nav>
</body>

</html>