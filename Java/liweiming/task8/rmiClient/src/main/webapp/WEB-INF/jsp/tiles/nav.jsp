<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="title" uri="http://tiles.apache.org/tags-tiles" %>
<nav class="navbar navbar-default">
    <div class="container">
        <div class="navbar-header">
            <a href="#" class="navbar-brand">
                <img src="${pageContext.request.contextPath}/static/images/logo.png" alt="Brand" class="img-responsive">
            </a>
            <button data-target="#open-nav" data-toggle="collapse" class="navbar-toggle btn-primary collapsed" aria-expanded="false">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
        </div>
        <div id="open-nav" class="navbar-collapse collapse" aria-expanded="false" style="height: 1px;">
            <ul class="nav navbar-nav navbar-right text-center list-inline">
                <li> <a href="${pageContext.request.contextPath}/infor">个人信息</a></li>
                <li><a href="${pageContext.request.contextPath}/uploadPhoto">上传头像</a></li>
                 <li><a href="${pageContext.request.contextPath}/emailVerify">邮箱验证</a></li>
                <li><a href="${pageContext.request.contextPath}/home">首页</a></li>
                <li><a href="${pageContext.request.contextPath}/u/profession">职业</a></li>
                <li><a href="">推荐</a></li>
                <li><a href="">关于</a></li>
            </ul>
        </div>
    </div>
</nav>