<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/11/24
  Time: 11:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
</head>
<body>
<div class="container  hidden-xs">
    <div class="row header-top">
        <p class="col-xs-12 col-sm-6 col-md-6 col-lg-6">客服电话:010-594-78634</p>
        <div class="col-xs-12 col-sm-6 col-md-6 col-lg-6 text-right">
            <div>

                <c:choose>
                    <c:when test="${!empty loginName}">
                        <a style="color: black"> welcome ${loginName}</a>
                        <a href="${pageContext.request.contextPath}/loginout" style="color: black">注销</a>
                    </c:when>

                    <c:otherwise>
                        <a href="${pageContext.request.contextPath}/login" target="_blank" style="color: black"> 登陆 </a>
                        <a href="${pageContext.request.contextPath}/registration" target="_blank" style="color: black"> 注册 </a>
                    </c:otherwise>
                </c:choose>

                <%--<c:if test="${!empty login.name}">--%>
                    <%--<a>welcome ${login.name}！</a>--%>
                <%--</c:if>--%>

                <%--<c:if test="${empty login.name}" >--%>
                    <%--<a href="" target="_blank"> 登陆 </a>--%>
                    <%--<a href="#" target="_blank"> 注册 </a>--%>
                <%--</c:if>--%>

                <a href="#" target="_blank"> <img alt=""  src="${pageContext.request.contextPath}/static/img/54537.png"></a>
                <a href="#" target="_blank"><img alt=""  src="${pageContext.request.contextPath}/static/img/45678678.png"></a>
                <a href="#" target="_blank"> <img alt=""  src="${pageContext.request.contextPath}/static/img/54375483543.png"></a>
            </div>
        </div>
    </div>
</div>

<nav class="navbar navbar-default">
    <div class="container">
        <div class="navbar-header">
            <a href="#" class="navbar-brand">
                <img src="${pageContext.request.contextPath}/static/img/logo.png" alt="Brand" class="img-responsive">
            </a>
            <button data-target="#open-nav" data-toggle="collapse" class="navbar-toggle btn-primary collapsed" aria-expanded="false">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
        </div>
        <div id="open-nav" class="navbar-collapse collapse" aria-expanded="false" style="height: 1px;">
            <ul class="nav navbar-nav navbar-right text-center list-inline">
                <li><a href="${pageContext.request.contextPath}/home">首页</a></li>
                <%--创建连接--%>
                <li><a href="${pageContext.request.contextPath}/u/profession">职业</a></li>
                <li><a href="">推荐</a></li>
                <li><a href="">关于</a></li>
            </ul>
        </div>

    </div>
</nav>
</body>
</html>
