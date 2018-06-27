<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <title>无标题文档</title>
    <meta content="width=device-width, initial-scale=1.0" name="viewport" charset="UTF-8">
    <link rel="stylesheet" href="http://apps.bdimg.com/libs/bootstrap/3.3.4/css/bootstrap.min.css">
    <script src="http://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
    <script src="http://apps.bdimg.com/libs/bootstrap/3.3.4/js/bootstrap.min.js"></script>
    <link href="${pageContext.request.contextPath}/static/t11.css" rel="stylesheet" type="text/css">
    <link href="${pageContext.request.contextPath}/static/base.css" rel="stylesheet" type="text/css">
</head>

<body>
<header>
    <div class="top container">
        <p class="hidden-xs">客服热线：010-594-78634</p>
        <img src="${pageContext.request.contextPath}/static/imges/12321.gif">
    </div>

    <div role="navigation" class="nav1 navbar navbar-default">
        <div class="container">
            <div class="header-logo">
                <div class="logo-middle"><img src="${pageContext.request.contextPath}/static/imges/logo.png"></div>
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
                    <a href="${pageContext.request.contextPath}/"><li>首 页</li></a>
                    <a href="${pageContext.request.contextPath}/joblist"><li class="border">职 业</li></a>
                    <a href="${pageContext.request.contextPath}/cooperate"><li>推 荐</li></a>
                    <a href=""><li>关 于</li></a>
                </ul>
            </div>
        </div>

    </div>

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
        <h4>前端开发方向</h4>
    </div>

    <div class="row">
    <c:forEach items="${jobList}" var="info">
        <div class="col-md-4 col-sm-6 col-xs-12 top-margin">

            <div class="warp-border">
                <div class="clearfix">
                    <div class="icon-people"><img src="${pageContext.request.contextPath}/static/imges/687.png"></div>
                    <div class="text">
                        <h4 class="">${info.jobName}</h4>
                        <p class="text-present">${info.introduction}</p>
                    </div>
                </div>

                <div class="warp-class2">
                    <div class="warp-class2-text">
                        <div class="iconfont text-padding">门槛 <img src="${pageContext.request.contextPath}/static/imges/xx.png"></div>
                    </div>
                    <div class="warp-class2-text">
                        <div class="iconfont text-padding text-border-left">难易程度 <c:forEach begin="1" end="${info.threshold}" step="1"><img src="${pageContext.request.contextPath}/static//imges/xx.png"></c:forEach></div>
                    </div>
                </div>
                <div class="warp-class2">
                    <div class="warp-class2-text">
                        <div class="iconfont text-padding">成长周期 <span class="iconfont-color">${info.conpanyNumber}</span>年</div>
                    </div>
                    <div class="warp-class2-text">
                        <div class="iconfont text-padding text-border-left">稀缺程度 <span class="iconfont-color">${info.rarity}</span>家公司需要</div>
                    </div>
                </div>

                <div class="warp-class2">
                    <div class="leftWarp">
                        薪资待遇
                    </div>
                    <div class="rightWarp">
                        <div class="rightWarp-class">
                            <div class="rightWarp-year">0-1年</div>
                            <div class="rightWarp-wages">${info.salary_min}k-${info.salary_max}k/月</div>
                        </div>
                        <div class="rightWarp-class">
                            <div class="rightWarp-year">0-1年</div>
                            <div class="rightWarp-wages">5k-10k/月</div>
                        </div>
                        <div class="rightWarp-class border-bottom">
                            <div class="rightWarp-year">0-1年</div>
                            <div class="rightWarp-wages">5k-10k/月</div>
                        </div>
                    </div>
                </div>

                <div class="warp-class2">
                    <b class="text-b">有${count}人正在学</b>
                </div>
                <div class="warp-class2">
                    <p class="text-p">${info.tip}</p>
                </div>

                <div class="flip-container">
                    <p class="flip-title">iOS工程师</p>
                    <p class="flip-text">iOS是由苹果公司开发的移动操作统，iOS与苹果的Mac OS X操作系统一样， 也是以Darwin为基础的，因此同样属于类Unix的商业操作系统。国内iOS开发起步相对较晚， 人才培养机制更是远远跟不上市场发展速度。有限的iOS开发人才成了国内企业必争的资源。 国内iOS开发起步相对较晚，人才培养机制更是远远跟不上市场发展速度。 有限的iOS开发人才成了国内企业必争的资源。</p>
                </div>
            </div>
        </div>
    </c:forEach>
    </div>

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
                <img src="${pageContext.request.contextPath}/static/imges/2524.jpg">
            </div>
        </div>
    </div>
    <div class="footer-bottom">
        Copyright &copy; 2015技能树 www.jnshu.com  All Rights Reserved | 京ICP
    </div>
</footer>

</body>
</html>
