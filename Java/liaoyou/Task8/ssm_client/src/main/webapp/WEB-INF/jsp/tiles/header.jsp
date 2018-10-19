<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" session="false" %>

<header>
    <div class="container hidden-xs">
        <!--第一行即顶行-->
        <div class="row header-top">
            <p class="col-xs-12 col-sm-6 col-md-6 col-lg-6">客服电话:010-594-78634</p>
            <div class="col-xs-12 col-sm-6 col-md-6 col-lg-6 text-right">
                <a class="login" href="" target="_blank"><font color="29B078">ID:${requestScope.get("id")}</font></a> &nbsp;&nbsp;
                <a class="login" href="${pageContext.request.contextPath}/u/login" target="_blank"><font color="29B078">登录</font></a> &nbsp;&nbsp;
                <a class="login" href="${pageContext.request.contextPath}/u/personCenter/${requestScope.get("id")}"><font color="29B078">个人中心</font></a> &nbsp;&nbsp;
                <a class="user" href="${pageContext.request.contextPath}/u/loginout"><font color="29B078">退出</font></a> &nbsp;&nbsp;
                <a class="hd-icon" href="#" target="_blank"><img src="${pageContext.request.contextPath}/images/home/weibo.png" alt="weibo"></a>
                <a class="hd-icon" href="#" target="_blank"><img src="${pageContext.request.contextPath}/images/home/qq.png" alt="qq"></a>
                <a class="hd-icon" href="#" target="_blank"><img src="${pageContext.request.contextPath}/images/home/weixin.png" alt="weixin"></a>
            </div>
        </div>
    </div>

    <!--第二行 导航栏-->
    <nav class="navbar navbar-default">
        <div class="container">
            <div class="navbar-header">
                <a class="navbar-brand" href="#"><img src="${pageContext.request.contextPath}/images/home/logo.png" alt="logo" class="img-responsive"></a>
            </div>
            <button data-target="#open-nav" data-toggle="collapse" class="navbar-toggle btn-primary collapsed" aria-expanded="false">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <div id="open-nav" class="navbar-collapse collapse" aria-expanded="false" style="height: 1px;">
                <ul class="nav navbar-nav navbar-right text-center list-inline">
                    <li><a href="<%=request.getContextPath()%>/home">首页</a></li>
                    <li><a href="${pageContext.request.contextPath}/job">职业</a></li>
                    <li><a href="${pageContext.request.contextPath}/u/studentByT">学员列表</a></li>
                    <li><a href="">关于</a></li>
                </ul>
            </div>
        </div>
    </nav>
</header>