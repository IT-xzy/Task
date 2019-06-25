<%@page language="java" contentType="text/html; charset=UTF-8"
        pageEncoding="UTF-8" isErrorPage="true" isELIgnored="false" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%--uri指向我配置的dateTag.tid--%>
<%@ taglib uri="/tags" prefix="date" %>

<!DOCTYPE html>
<html>
<head>
    <title>职业介绍</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>profession</title>
    <meta content="width=device-width, initial-scale=1.0" name="viewport" charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="http://apps.bdimg.com/libs/bootstrap/3.3.4/css/bootstrap.min.css">
    <script src="http://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
    <script src="http://apps.bdimg.com/libs/bootstrap/3.3.4/js/bootstrap.min.js"></script>
    <link href="${pageContext.request.contextPath}/static/css/bootstrap.min.css" rel="stylesheet" type="text/css">
    <link href="${pageContext.request.contextPath}/static/css/Untitled-3.css" rel="stylesheet" type="text/css">
    <link href="${pageContext.request.contextPath}/static/css/Untitled-1base.css" rel="stylesheet" type="text/css">
    <link href="${pageContext.request.contextPath}/static/css/t11.css" rel="stylesheet" type="text/css">
    <link href="${pageContext.request.contextPath}/static/css/base.css" rel="stylesheet" type="text/css">
</head>

<body>
<div class="container">

    <div class="nav-title">首页&gt;职业</div>
    <div class="nav-bar">
        <span class="">方向：</span>

        <a class="nav-bar-a a-selected" href="">全部</a>
        <a class="nav-bar-a" href="" style="color:black">前端开发</a>
        <a class="nav-bar-a" href="" style="color:black">后端开发</a>
        <a class="nav-bar-a" href="" style="color:black">前端开发</a>
        <a class="nav-bar-a" href="" style="color:black">移动开发</a>
        <a class="nav-bar-a" href="" style="color:black">整站开发</a>
        <a class="nav-bar-a" href="" style="color:black">运营维护</a>
    </div>

    <div class="caption">
        <h4>前端开发方向</h4>
    </div>

    <div class="row">
        <c:forEach items="${profession}" var="profession">
            <div class="col-md-4 col-sm-6 col-xs-12 top-margin">
                <div class="warp-border">
                    <div class="clearfix">
                        <%--<div class="icon-people"><img src=${profession.picture}></div>--%>
                        <div class="icon-people"><img src="${pageContext.request.contextPath}/static/images/687.png"></div>
                        <div class="text">
                            <h4 class="">${profession.name}</h4>
                            <p class="text-present">${profession.introduction}</p>
                        </div>
                    </div>

                    <div class="warp-class2">
                        <div class="warp-class2-text">
                            <div class="iconfont text-padding">门槛
                                <c:forEach begin="1" end="${profession.threshold}">
                                    <img src="${pageContext.request.contextPath}/static/images/xx.png">
                                </c:forEach>
                            </div>
                        </div>
                        <div class="warp-class2-text">
                            <div class="iconfont text-padding text-border-left">难易程度
                                <c:forEach begin="1" end="${profession.difficult}">
                                    <img src="${pageContext.request.contextPath}/static/images/xx.png">
                                </c:forEach>
                            </div>
                        </div>
                    </div>
                    <div class="warp-class2">
                        <div class="warp-class2-text">
                            <div class="iconfont text-padding">成长周期 <span
                                    class="iconfont-color">${profession.growthCycle}</span>年
                            </div>
                        </div>
                        <div class="warp-class2-text">
                            <div class="iconfont text-padding text-border-left">稀缺程度 <span
                                    class="iconfont-color">${profession.scarcity}</span>家公司需要
                            </div>
                        </div>
                    </div>

                    <div class="warp-class2">
                        <div class="leftWarp">
                            薪资待遇
                        </div>
                        <div class="rightWarp">
                            <div class="rightWarp-class">
                                <div class="rightWarp-year">0-1年</div>
                                <div class="rightWarp-wages">${profession.stageOne}/月</div>
                            </div>
                            <div class="rightWarp-class">
                                <div class="rightWarp-year">1-3年</div>
                                <div class="rightWarp-wages">${profession.stageTwo}/月</div>
                            </div>
                            <div class="rightWarp-class border-bottom">
                                <div class="rightWarp-year">3-5年</div>
                                <div class="rightWarp-wages">${profession.stageThree}/月</div>
                            </div>
                        </div>
                    </div>

                    <div class="warp-class2">
                        <b class="text-b">有${profession.count}人正在学</b>
                    </div>

                    <div class="warp-class2">
                        <p class="text-p">提示:在你学习之前你应该已经掌握XXXXX、XXXXX、XX等语言基础</p>
                        <p class="text-p">创建时间<date:date value=""/></p>
                    </div>

                    <div class="flip-container">
                        <p class="flip-title">iOS工程师</p>
                        <p class="flip-text">iOS是由苹果公司开发的移动操作统，iOS与苹果的Mac OS X操作系统一样，
                            也是以Darwin为基础的，因此同样属于类Unix的商业操作系统。国内iOS开发起步相对较晚， 人才培养机制更是远远跟不上市场发展速度。有限的iOS开发人才成了国内企业必争的资源。
                            国内iOS开发起步相对较晚，人才培养机制更是远远跟不上市场发展速度。 有限的iOS开发人才成了国内企业必争的资源。</p>
                            <%--<p class="flip-title">${profession.name}</p>--%>
                            <%--<p class="flip-text">${profession.introduction}</p>--%>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>

</div>

<br/>
<br/>
<br/>

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
                <img src="${pageContext.request.contextPath}/static/images/2524.jpg">
            </div>
        </div>

    </div>

    <div class="footer-bottom">
        Copyright &copy; 2015技能树 www.jnshu.com All Rights Reserved | 京ICP
    </div>
</footer>

</body>
</html>