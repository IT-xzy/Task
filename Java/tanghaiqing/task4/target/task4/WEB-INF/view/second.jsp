<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="/tags" prefix="date" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>任务四2</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta content="width=device-width, initial-scale=1.0" name="viewport">
    <link rel="stylesheet" href="http://apps.bdimg.com/libs/bootstrap/3.3.4/css/bootstrap.min.css">
    <link href="../bootstrap-3.3.5-dist/css/bootstrap.css">
    <link href="${pageContext.request.contextPath}/static/css/Untitled-3.css" rel="stylesheet" type="text/css">
    <link href="${pageContext.request.contextPath}/static/css/Untitled-1base.css" rel="stylesheet" type="text/css">
    <link href="${pageContext.request.contextPath}/static/css/t11.css" rel="stylesheet" type="text/css">
    <link href="${pageContext.request.contextPath}/static/css/base.css" rel="stylesheet" type="text/css">
</head>
<body>
<header>
    <div class="container  hidden-xs">
        <div class="row header-top">
            <p class="col-xs-12 col-sm-6 col-md-6 col-lg-6">客服电话:010-594-78634</p>
            <div class="col-xs-12 col-sm-6 col-md-6 col-lg-6 text-right">
                <div>
                    <a href="#" target="_blank"> <img alt=""
                                                      src="${pageContext.request.contextPath}/static/imges/54537.png"></a>
                    <a href="#" target="_blank"><img alt=""
                                                     src="${pageContext.request.contextPath}/static/imges/45678678.png"></a>
                    <a href="#" target="_blank"> <img alt=""
                                                      src="${pageContext.request.contextPath}/static/imges/54375483543.png"></a>
                </div>
            </div>
        </div>
    </div>
    <nav class="navbar navbar-default">
        <div class="container">
            <div class="navbar-header">
                <a href="#" class="navbar-brand">
                    <img src="${pageContext.request.contextPath}/static/imges/logo.png" alt="Brand"
                         class="img-responsive">
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
                    <li><a href="">首页</a></li>
                    <li><a href="secondPage">职业</a></li>
                    <li><a href="">推荐</a></li>
                    <li><a href="">关于</a></li>
                </ul>
            </div>

        </div>
    </nav>
</header>
    <div class="container">
    <div class="nav-title">首页&gt;职业</div>
    <div class="nav-bar">
        <span class="">方向：</span>
        <a class="nav-bar-a a-selected" href="">全部</a>
        <a class="nav-bar-a" href="">前端开发</a>
        <a class="nav-bar-a" href="">后端开发</a>
        <a class="nav-bar-a" href="">移动开发</a>
        <a class="nav-bar-a" href="">整站开发</a>
        <a class="nav-bar-a" href="">运营维护</a>
    </div>
    <div class="caption">
        <h4>${frontJobs.get(0).jobCategory}</h4>
    </div>
    <div class="row">
        <c:forEach items="${frontJobs}" var="frontJob">
            <div class="col-md-4 col-sm-6 col-xs-12 top-margin">
                <div class="warp-border">
                    <div class="clearfix">
                        <div class="icon-people"><img
                                src="${pageContext.request.contextPath}/static/imges/${frontJob.jobImage}.png"></div>
                        <div class="text">
                            <h4 class="">${frontJob.jobName}</h4>
                            <p class="text-present">${frontJob.jobIntro}</p>
                        </div>
                    </div>
                    <div class="warp-class2">
                        <div class="warp-class2-text">
                            <div class="iconfont text-padding">门槛
                                <c:forEach var="i" begin="1" end="1">
                                    <img src="${pageContext.request.contextPath}/static/imges/xx.png">
                                </c:forEach>
                            </div>
                        </div>
                        <div class="warp-class2-text">
                            <div class="iconfont text-padding text-border-left">难易程度
                                <c:forEach var="i" begin="1" end="${frontJob.threshold}">
                                    <img src="${pageContext.request.contextPath}/static/imges/xx.png">
                                </c:forEach>
                            </div>
                        </div>
                    </div>
                    <div class="warp-class2">
                        <div class="warp-class2-text">
                            <div class="iconfont text-padding">成长周期 <span
                                    class="iconfont-color">${frontJob.cycle}</span>年
                            </div>
                        </div>
                        <div class="warp-class2-text">
                            <div class="iconfont text-padding text-border-left">稀缺程度 <span
                                    class="iconfont-color">${frontJob.scarcity}</span>家公司需要
                            </div>
                        </div>
                    </div>
                    <div class="warp-class2">
                        <div class="leftWarp">
                            薪资待遇
                        </div>
                        <div class="rightWarp">
                            <div class="rightWarp-class">
                                <div class="rightWarp-year">${frontJob.term1}</div>
                                <div class="rightWarp-wages">${frontJob.salary1}</div>
                            </div>
                            <div class="rightWarp-class">
                                <div class="rightWarp-year">${frontJob.term2}</div>
                                <div class="rightWarp-wages">${frontJob.salary2}</div>
                            </div>
                            <div class="rightWarp-class border-bottom">
                                <div class="rightWarp-year">${frontJob.term3}</div>
                                <div class="rightWarp-wages">${frontJob.salary3}</div>
                            </div>
                        </div>
                    </div>
                    <div class="warp-class2">
                        <b class="text-b">有${frontJob.atSchool}人正在学 更新时间：<date:date value="${frontJob.updateTime}"/>
                        </b>
                    </div>
                    <div class="warp-class2">
                        <p class="text-p">${frontJob.hint}</p>
                    </div>
                    <div class="flip-container">
                        <p class="flip-title">${frontJob.jobName}</p>
                        <p class="flip-text">${frontJob.jobIntroduce}</p>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>

    <div class="caption">
        <h4>${laterJobs.get(0).jobCategory}</h4>
    </div>
    <div class="row">
        <c:forEach items="${laterJobs}" var="laterJob">
            <div class="col-md-4 col-sm-6 col-xs-12 top-margin">
                <div class="warp-border">
                    <div class="clearfix">
                        <div class="icon-people"><img
                                src="${pageContext.request.contextPath}/static/imges/${laterJob.jobImage}.png">
                        </div>
                        <div class="text">
                            <h4 class="">${laterJob.jobName}</h4>
                            <p class="text-present">${laterJob.jobIntro}</p>
                        </div>
                    </div>
                    <div class="warp-class2">
                        <div class="warp-class2-text">
                            <div class="iconfont text-padding">门槛
                                <c:forEach var="i" begin="1" end="2">
                                    <img src="${pageContext.request.contextPath}/static/imges/xx.png">
                                </c:forEach>
                            </div>
                        </div>
                        <div class="warp-class2-text">
                            <div class="iconfont text-padding text-border-left">难易程度
                                <c:forEach var="i" begin="1" end="${laterJob.threshold}">
                                    <img src="${pageContext.request.contextPath}/static/imges/xx.png">
                                </c:forEach>
                            </div>
                        </div>
                    </div>
                    <div class="warp-class2">
                        <div class="warp-class2-text">
                            <div class="iconfont text-padding">成长周期 <span
                                    class="iconfont-color">${laterJob.cycle}</span>年
                            </div>
                        </div>
                        <div class="warp-class2-text">
                            <div class="iconfont text-padding text-border-left">稀缺程度 <span
                                    class="iconfont-color">${laterJob.scarcity}</span>家公司需要
                            </div>
                        </div>
                    </div>
                    <div class="warp-class2">
                        <div class="leftWarp">
                            薪资待遇
                        </div>
                        <div class="rightWarp">
                            <div class="rightWarp-class">
                                <div class="rightWarp-year">${laterJob.term1}</div>
                                <div class="rightWarp-wages">${laterJob.salary1}</div>
                            </div>
                            <div class="rightWarp-class">
                                <div class="rightWarp-year">${laterJob.term2}</div>
                                <div class="rightWarp-wages">${laterJob.salary2}</div>
                            </div>
                            <div class="rightWarp-class border-bottom">
                                <div class="rightWarp-year">${laterJob.term3}</div>
                                <div class="rightWarp-wages">${laterJob.salary3}</div>
                            </div>
                        </div>
                    </div>
                    <div class="warp-class2">
                        <b class="text-b">有${laterJob.atSchool}人正在学</b>
                    </div>
                    <div class="warp-class2">
                        <p class="text-p">${laterJob.hint}</p>
                    </div>
                    <div class="flip-container">
                        <p class="flip-title">${laterJob.jobName}</p>
                        <p class="flip-text">${laterJob.jobIntroduce}</p>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
</div>
<div class="main-e">
    <h3 class="text-center main-tab ">友情链接</h3>
    <div class="container">
        <ul class="text-justify">
            <li><a href="#">手机软件</a></li>
            <li><a href="#">教师招聘</a></li>
            <li><a href="#">找工作</a></li>
            <li><a href="#">教师招聘</a></li>
            <li><a href="#">找工作</a></li>
            <li><a href="#">手机软件</a></li>
            <li><a href="#">教师招聘</a></li>
            <li><a href="#">手机软件</a></li>
            <li><a href="#">手机软件</a></li>
            <li><a href="#">找工作</a></li>
            <li><a href="#">手机软件</a></li>
            <li><a href="#">教师招聘</a></li>
            <li><a href="#">找工作</a></li>
            <li><a href="#">教师招聘</a></li>
            <li><a href="#">找工作</a></li>
            <li><a href="#">手机软件</a></li>
            <li><a href="#">教师招聘</a></li>
            <li><a href="#">手机软件</a></li>
            <li><a href="#">手机软件</a></li>
            <li><a href="#">找工作</a></li>
        </ul>
    </div>
</div>
<!--footer-->
<footer class="footer">
    <div class="footer">
        <div class="container">
            <div class="row">
                <div class="col-xs-12 col-sm-4 col-md-5 col-lg-5 up-1">
                    <p><a>技能树-改变你我</a></p>
                    <p><a href="#">关于我们 </a>|<a href="#"> 联系我们 </a>|<a href="#"> 合作企业 </a></p>
                </div>
                <div class="col-xs-12 col-sm-4 col-md-5 col-lg-5 up-2">
                    <p>旗下网站</p>
                    <ul class="list-inline">
                        <li><a href="#">草船云孵化器</a></li>
                        <li><a href="#">最强IT特训营</a><br></li>
                    </ul>
                    <ul class="list-inline">
                        <li><a href="#">葡萄藤轻游戏</a></li>
                        <li><a href="#">桌游精灵</a></li>
                    </ul>
                </div>
                <div class="col-xs-12 col-sm-4 col-md-2 col-lg-2 up-3">
                    <p>微信公众平台</p>
                    <img alt="" src="${pageContext.request.contextPath}/static/imges/2524.jpg">
                </div>
            </div>
        </div>
        <div class="footer-bottom">
            <p>Copyright &copy; 2015 北京葡萄藤信息技术有限公司 All Rights Reserved | 京ICP备15035574号-1</p>
        </div>
    </div>
</footer>
</body>
<script src="${pageContext.request.contextPath}/static/js/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/static/js/bootstrap.min.js"></script>
</html>