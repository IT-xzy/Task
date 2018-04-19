<%--
  Created by IntelliJ IDEA.
  User: yiqia
  Date: 2018/2/24 0024
  Time: 20:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <meta charset="utf-8">
    <base href="<%=basePath%>">
    <%--<%--%>
        <%--out.println(basePath);--%>
        <%--out.println(path);--%>
    <%--%>--%>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>职业</title>
    <%--<link rel="stylesheet" href="http://apps.bdimg.com/libs/bootstrap/3.3.4/css/bootstrap.min.css">--%>
    <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css">
    <link href="css/t11.css" rel="stylesheet" type="text/css">
    <link href="css/base11.css" rel="stylesheet" type="text/css">
    <%--<script src="http://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>--%>
    <%--<script src="http://apps.bdimg.com/libs/bootstrap/3.3.4/js/bootstrap.min.js"></script>--%>
    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
</head>
<body>
<header>
    <div class="top container">
        <p class="hidden-xs">客服热线：010-594-78634</p>
        <img src="image/12321.gif">
    </div>

    <div role="navigation" class="nav1 navbar navbar-default">
        <div class="container">
            <div class="header-logo">
                <div class="logo-middle"><img src="image/logo.png"></div>
            </div>
            <div class="navbar-header marginTop">
                <button data-target="#example-navbar-collapse" data-toggle="collapse" class="navbar-toggle"
                        type="button">
                    <span class="sr-only">切换导航</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
            </div>

            <div id="example-navbar-collapse" class=" collapse navbar-collapse">
                <ul class="nav navbar-nav">
                    <a href="school/index"><li>首 页</li></a>
                    <a href="javascript:void(0);"><li class="border">职 业</li></a>
                    <a href="javascript:void(0);"><li>推 荐</li></a>
                    <a href="javascript:void(0);"><li>关 于</li></a>
                </ul>
            </div>
        </div>

    </div>

</header>

<div class="container">

    <div class="nav-title">首页&gt;职业</div>
    <div class="nav-bar">
        <span class="">方向：</span>
        <a class="nav-bar-a a-selected" href="/school/profession">全部</a>
        <c:forEach items="${directionCategoryList}" var="item">
            <a class="nav-bar-a" href="school/profession/#${item}">${item}</a>
        </c:forEach>
    </div>

    <c:forEach items="${directionCategoryList}" var="dcl">

        <div id="${dcl}" class="caption">
            <h4>${dcl}</h4>
        </div>

        <div class="row   <c:if test="${directionCategoryList.get(directionCategoryList.size()-1)==dcl}">padding-bottom</c:if> ">
            <c:forEach items="${professionList}" var="pl">
                <c:if test="${dcl==pl.direction}">
                    <div class="col-md-4 col-sm-6 col-xs-12 top-margin">

                        <div class="warp-border">
                            <div class="clearfix">
                                <div class="icon-people"><img src="image/${pl.picture}"></div>
                                <div class="text">
                                    <h4 class="">${pl.professionName}</h4>
                                    <p class="text-present">${pl.introduction}</p>
                                </div>
                            </div>

                            <div class="warp-class2">
                                <div class="warp-class2-text">
                                    <div class="iconfont text-padding">门槛 <img src="image/${pl.threshold}"></div>
                                </div>
                                <div class="warp-class2-text">
                                    <div class="iconfont text-padding text-border-left">难易程度 <img
                                            src="image/${pl.difficulty}"></div>
                                </div>
                            </div>
                            <div class="warp-class2">
                                <div class="warp-class2-text">
                                    <div class="iconfont text-padding">成长周期 <span
                                            class="iconfont-color">${pl.growth}</span>年
                                    </div>
                                </div>
                                <div class="warp-class2-text">
                                    <div class="iconfont text-padding text-border-left">稀缺程度 <span
                                            class="iconfont-color">${pl.market}</span>家公司需要
                                    </div>
                                </div>
                            </div>

                            <div class="warp-class2">
                                <div class="leftWarp">
                                    薪资待遇
                                </div>
                                <div class="rightWarp">
                                    <c:forEach items="${salaryList}" var="sl">
                                        <c:if test="${sl.id==pl.salary}">
                                            <div class="rightWarp-class">
                                                <div class="rightWarp-year">${sl.timeOne}</div>
                                                <div class="rightWarp-wages">${sl.salaryOne}</div>
                                            </div>
                                            <div class="rightWarp-class">
                                                <div class="rightWarp-year">${sl.timeTwo}</div>
                                                <div class="rightWarp-wages">${sl.salaryTwo}</div>
                                            </div>
                                            <div class="rightWarp-class border-bottom">
                                                <div class="rightWarp-year">${sl.timeThree}</div>
                                                <div class="rightWarp-wages">${sl.salaryThree}</div>
                                            </div>
                                        </c:if>
                                    </c:forEach>
                                </div>
                            </div>

                            <div class="warp-class2">
                                <b class="text-b">有${countStudents[pl.professionName]}人正在学</b>
                            </div>
                            <div class="warp-class2">
                                <p class="text-p">提示:${pl.cue}</p>
                            </div>

                            <div class="flip-container">
                                <p class="flip-title">${pl.professionName}</p>
                                <p class="flip-text">${pl.introductionMore}</p>
                            </div>
                        </div>

                    </div>
                </c:if>
            </c:forEach>
        </div>
    </c:forEach>
</div>

<!--footer-->
<footer class="footer">
    <div class="container height">
        <div class="row">
            <div class="text-left col-sm-4">
                <span>技能树 &mdash; 改变你我</span>
                <p class="bottom">关于我们 | 联系我们 | 合作企业</p>
            </div>
            <div class="text-center col-sm-4">
                <p>旗下网站</p>
                <span>草船云孵化器     最强IT特训营</span>
                <span>葡萄藤轻游戏     桌游精灵</span>
            </div>
            <div class="text-right col-sm-4">
                <p>微信公众号</p>
                <img src="image/2524.jpg">
            </div>
        </div>

    </div>

    <div class="footer-bottom">
        Copyright &copy; 2015技能树 www.jnshu.com All Rights Reserved | 京ICP
    </div>
</footer>
</body>
</html>
