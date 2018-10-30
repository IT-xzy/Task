<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/6/22
  Time: 11:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<style>
    .to{width: 50px;height: 50px;border-radius: 100px}
</style>
<style>

</style>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title></title>
    <link rel="stylesheet" href="/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/default.css">
    <link rel="stylesheet" href="/css/job.css">
</head>
<body>
<!-- 头部 -->
<header>
    <% String name= (String) session.getAttribute("name");
    if(name!=null){%>
    <a href="/logout" style="color:blue;float: right" >  注销</a>
    <a href="/personal" style="color:blue;float: right" ><%=request.getSession().getAttribute("name")%>  </a>
    <a href="/personal" style="float: right" class="to"><img  alt="" class="to" src="<%=request.getSession().getAttribute("img")%>"></a><%}else{%>
    <a href="/register" style="color:blue;float: right" >注册</a>
    <a href="/login" style="color:blue;float: right" >登录</a><%}
%>

    <div class="container">
        <!-- 第一行 -->
        <div class="row hd-info">
            <!-- center-vertical垂直居中 -->
            <p class="col-sm-5 col-md-5 col-xs-5 center-vertical text-ellipsis">客服热线：010-594-78634</p>

            <link class="col-sm-7 col-md-7 col-xs-7 center-vertical">
                <a class="hd-icon" href="#"><img src="/img/weibo.png" alt="weibo"></a>
                <a class="hd-icon" href="#"><img src="/img/qq.png" alt="qq"></a>
                <a class="hd-icon" href="#"><img src="/img/wechat.png" alt="wechat"></a>
            </div>
        </div>
    </div>
    <!-- 第二行 导航栏 -->
    <nav class="navbar navbar-default navbar-user" role="navigation">
        <div class="container">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle btn-user" data-toggle="collapse"
                        data-target="#example-navbar-collapse">
                    <span class="sr-only">切换导航</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="home">
                    <img src="/img/navlogo.png" alt="logo">
                </a>
            </div>
            <div class="collapse navbar-collapse" id="example-navbar-collapse">
                <!-- .navbar-right 宽度大于768px导航栏右浮动 -->
                <ul class="nav navbar-nav navbar-right">
                    <li>
                        <a href="/home">首页</a>
                    </li>
                    <li>
                        <a href="/job">职业</a>
                    </li>
                    <li >
                        <a href="/offer">推荐</a>
                    </li>
                    <li >
                        <a href=/u/students>学生信息管理</a>
                    </li>
                    <li>
                        <a href="/u/student">学生登记</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
</header>
</body>
</html>
