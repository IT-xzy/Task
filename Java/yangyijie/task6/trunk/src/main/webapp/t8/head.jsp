<%--
  Created by IntelliJ IDEA.
  User: yyj
  Date: 2017/12/27
  Time: 19:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<body>
<%String name = (String)request.getSession().getValue("name");%>
<!-- 页面顶部栏 -->
<div class="container">
    <div class="row">
        <div class="col-sm-4 hidden-xs">
            <span class="tel">咨询电话 : 010-59478634</span>
        </div>
        <div class="col-sm-8">
            <div class="wrap-img text-right ">
                <a href="" target="_blank" class="jnshu-mobile-img">
                </a>
                <a href="" target="_blank" class="weixin-share-img">
                </a>
                <a href="" target="_blank" class="weibo-share-img">
                </a>
                <a   class="loginOut"><%=name%></a>
                <span class="loginOut">|</span>
                <a href="${pageContext.request.contextPath}/loginOut" target="_self" class="loginOut">退出</a>
            </div>
        </div>
    </div>
</div>
<!-- 页面导航栏 -->
<nav class="navbar navbar-default header-nav-wrap" role="navigation">
    <div class="container">
        <div class="navbar-header">
            <!-- 展开按钮 -->
            <button type="button" class="navbar-toggle" data-toggle="collapse"
                    data-target="#example-navbar-collapse">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <!-- 主页logo -->
            <a class="navbar-brand" href="#">
                <img src="${pageContext.request.contextPath}/t8/img/home-logo.png" class="img-responsive" alt="">
            </a>
        </div>
        <!-- 导航项目 -->
        <div class="collapse navbar-collapse" id="example-navbar-collapse">
            <ul class="nav navbar-nav">
                <li href="#">
                    <a href="${pageContext.request.contextPath}/u/jnshu">首页</a>
                </li>
                <li>
                    <a href="${pageContext.request.contextPath}/u/joblist">职业</a>
                </li>
                <li>
                    <a href="#">推荐</a>
                </li>
                <li>
                    <a href="${pageContext.request.contextPath}/u/cooperation">关于</a>
                </li>
            </ul>
        </div>
    </div>
</nav>
</body>
</html>
