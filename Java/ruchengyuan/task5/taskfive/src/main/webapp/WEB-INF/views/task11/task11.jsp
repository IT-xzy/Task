<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <title>职业</title>
</head>
<body>
<header>
    <tiles:insertDefinition name="task4-head" />
</header>
    <tiles:insertDefinition name="task4-left" />
    <div class="container">
        <div class="nav-title">首页&gt;职业</div>
        <div class="nav-bar">
            <span class="">方向：</span>
            <a class="nav-bar-a a-selected" href="">全部</a>
            <a class="nav-bar-a a-selected" href="">前端开发</a>
            <a class="nav-bar-a a-selected" href="">后端开发</a>
            <a class="nav-bar-a a-selected" href="">移动开发</a>
            <a class="nav-bar-a a-selected" href="">整站开发</a>
            <a class="nav-bar-a a-selected" href="">运营维护</a>
        </div>
        <div class="caption">
            <h4>学习方向</h4>
        </div>

        <div class="row">
            <c:set var="i" value="0"/>
            <c:forEach items="${professions}" var="professions" varStatus="st">

            <div class="col-md-4 col-sm-6 col-xs-12 top-margin">

                <div class="warp-border">
                    <div class="clearfix">
                        <div class="icon-people"><img src="/statics/image/${professions.images}"></div>
                        <div class="text">
                            <h4 class="">${professions.profession}</h4>
                            <p class="text-present">${professions.introduction}</p>
                        </div>
                    </div>

                    <div class="warp-class2">
                        <div class="warp-class2-text">
                            <div class="iconfont text-padding">门槛
                                <c:forEach begin="1" end="${professions.learningFront}">
                                    <img src="/statics/image/xx.png">
                                </c:forEach>
                            </div>
                        </div>
                        <div class="warp-class2-text">
                            <div class="iconfont text-padding text-border-left">难易程度
                                <c:forEach begin="1" end="${professions.difficult}">
                                    <img src="/statics/image/xx.png">
                                </c:forEach>
                            </div>
                        </div>
                    </div>
                    <div class="warp-class2">
                        <div class="warp-class2-text">
                            <div class="iconfont text-padding">成长周期 <span class="iconfont-color">1-${professions.difficult}</span>年</div>
                        </div>
                        <div class="warp-class2-text">
                            <div class="iconfont text-padding text-border-left">稀缺程度 <span class="iconfont-color">${professions.socialNeeds}</span>家公司需要</div>
                        </div>
                    </div>

                    <div class="warp-class2">
                        <div class="leftWarp">
                            薪资待遇
                        </div>
                        <div class="rightWarp">
                            <div class="rightWarp-class">
                                <div class="rightWarp-year">0-1年</div>
                                <div class="rightWarp-wages">5k-10k/月</div>
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
                        <b class="text-b">有${a[i]}人正在学</b>
                    </div>
                    <div class="warp-class2">
                        <p class="text-p">提示:在你学习之前你应该已经掌握XXXXX、XXXXX、XX等语言基础</p>
                    </div>

                    <div class="flip-container">
                        <p class="flip-title">${professions.profession}</p>
                        <p class="flip-text">${professions.prospect}</p>
                    </div>
                </div>

            </div>
                <c:set var="i" value="${i+1}" />
            </c:forEach>

            <%--<div class="col-md-4 col-sm-6 col-xs-12 top-margin">--%>

                <%--<div class="warp-border">--%>
                    <%--<div class="clearfix">--%>
                        <%--<div class="icon-people"><img src="/statics/image/task11/687.png"></div>--%>
                        <%--<div class="text">--%>
                            <%--<h4 class="">Web前端工程师</h4>--%>
                            <%--<p class="text-present">Web前端开发工程师，主要职责是利用(X)HTML/CSS/JavaScript/flash等各种Web技术进行产品的开发。</p>--%>
                        <%--</div>--%>
                    <%--</div>--%>

                    <%--<div class="warp-class2">--%>
                        <%--<div class="warp-class2-text">--%>
                            <%--<div class="iconfont text-padding">门槛 <img src="/statics/image/task11/xx.png"></div>--%>
                        <%--</div>--%>
                        <%--<div class="warp-class2-text">--%>
                            <%--<div class="iconfont text-padding text-border-left">难易程度 <img src="/statics/image/task11/xx.png"><img src="/statics/image/task11/xx.png"></div>--%>
                        <%--</div>--%>
                    <%--</div>--%>
                    <%--<div class="warp-class2">--%>
                        <%--<div class="warp-class2-text">--%>
                            <%--<div class="iconfont text-padding">成长周期 <span class="iconfont-color">1-3</span>年</div>--%>
                        <%--</div>--%>
                        <%--<div class="warp-class2-text">--%>
                            <%--<div class="iconfont text-padding text-border-left">稀缺程度 <span class="iconfont-color">345</span>家公司需要</div>--%>
                        <%--</div>--%>
                    <%--</div>--%>

                    <%--<div class="warp-class2">--%>
                        <%--<div class="leftWarp">--%>
                            <%--薪资待遇--%>
                        <%--</div>--%>
                        <%--<div class="rightWarp">--%>
                            <%--<div class="rightWarp-class">--%>
                                <%--<div class="rightWarp-year">0-1年</div>--%>
                                <%--<div class="rightWarp-wages">5k-10k/月</div>--%>
                            <%--</div>--%>
                            <%--<div class="rightWarp-class">--%>
                                <%--<div class="rightWarp-year">0-1年</div>--%>
                                <%--<div class="rightWarp-wages">5k-10k/月</div>--%>
                            <%--</div>--%>
                            <%--<div class="rightWarp-class border-bottom">--%>
                                <%--<div class="rightWarp-year">0-1年</div>--%>
                                <%--<div class="rightWarp-wages">5k-10k/月</div>--%>
                            <%--</div>--%>
                        <%--</div>--%>
                    <%--</div>--%>

                    <%--<div class="warp-class2">--%>
                        <%--<b class="text-b">有286人正在学</b>--%>
                    <%--</div>--%>
                    <%--<div class="warp-class2">--%>
                        <%--<p class="text-p">提示:在你学习之前你应该已经掌握XXXXX、XXXXX、XX等语言基础</p>--%>
                    <%--</div>--%>

                    <%--<div class="flip-container">--%>
                        <%--<p class="flip-title">iOS工程师</p>--%>
                        <%--<p class="flip-text">iOS是由苹果公司开发的移动操作统，iOS与苹果的Mac OS X操作系统一样， 也是以Darwin为基础的，因此同样属于类Unix的商业操作系统。国内iOS开发起步相对较晚， 人才培养机制更是远远跟不上市场发展速度。有限的iOS开发人才成了国内企业必争的资源。 国内iOS开发起步相对较晚，人才培养机制更是远远跟不上市场发展速度。 有限的iOS开发人才成了国内企业必争的资源。</p>--%>
                    <%--</div>--%>
                <%--</div>--%>

            <%--</div>--%>
                <%--<div class="col-md-4 col-sm-6 col-xs-12 top-margin">--%>

                    <%--<div class="warp-border">--%>
                        <%--<div class="clearfix">--%>
                            <%--<div class="icon-people"><img src="/statics/image/task11/687.png"></div>--%>
                            <%--<div class="text">--%>
                                <%--<h4 class="">Web前端工程师</h4>--%>
                                <%--<p class="text-present">Web前端开发工程师，主要职责是利用(X)HTML/CSS/JavaScript/flash等各种Web技术进行产品的开发。</p>--%>
                            <%--</div>--%>
                        <%--</div>--%>

                        <%--<div class="warp-class2">--%>
                            <%--<div class="warp-class2-text">--%>
                                <%--<div class="iconfont text-padding">门槛 <img src="/statics/image/task11/xx.png"></div>--%>
                            <%--</div>--%>
                            <%--<div class="warp-class2-text">--%>
                                <%--<div class="iconfont text-padding text-border-left">难易程度 <img src="/statics/image/task11/xx.png"><img src="/statics/image/task11/xx.png"></div>--%>
                            <%--</div>--%>
                        <%--</div>--%>
                        <%--<div class="warp-class2">--%>
                            <%--<div class="warp-class2-text">--%>
                                <%--<div class="iconfont text-padding">成长周期 <span class="iconfont-color">1-3</span>年</div>--%>
                            <%--</div>--%>
                            <%--<div class="warp-class2-text">--%>
                                <%--<div class="iconfont text-padding text-border-left">稀缺程度 <span class="iconfont-color">345</span>家公司需要</div>--%>
                            <%--</div>--%>
                        <%--</div>--%>

                        <%--<div class="warp-class2">--%>
                            <%--<div class="leftWarp">--%>
                                <%--薪资待遇--%>
                            <%--</div>--%>
                            <%--<div class="rightWarp">--%>
                                <%--<div class="rightWarp-class">--%>
                                    <%--<div class="rightWarp-year">0-1年</div>--%>
                                    <%--<div class="rightWarp-wages">5k-10k/月</div>--%>
                                <%--</div>--%>
                                <%--<div class="rightWarp-class">--%>
                                    <%--<div class="rightWarp-year">0-1年</div>--%>
                                    <%--<div class="rightWarp-wages">5k-10k/月</div>--%>
                                <%--</div>--%>
                                <%--<div class="rightWarp-class border-bottom">--%>
                                    <%--<div class="rightWarp-year">0-1年</div>--%>
                                    <%--<div class="rightWarp-wages">5k-10k/月</div>--%>
                                <%--</div>--%>
                            <%--</div>--%>
                        <%--</div>--%>

                        <%--<div class="warp-class2">--%>
                            <%--<b class="text-b">有286人正在学</b>--%>
                        <%--</div>--%>
                        <%--<div class="warp-class2">--%>
                            <%--<p class="text-p">提示:在你学习之前你应该已经掌握XXXXX、XXXXX、XX等语言基础</p>--%>
                        <%--</div>--%>

                        <%--<div class="flip-container">--%>
                            <%--<p class="flip-title">iOS工程师</p>--%>
                            <%--<p class="flip-text">iOS是由苹果公司开发的移动操作统，iOS与苹果的Mac OS X操作系统一样， 也是以Darwin为基础的，因此同样属于类Unix的商业操作系统。国内iOS开发起步相对较晚， 人才培养机制更是远远跟不上市场发展速度。有限的iOS开发人才成了国内企业必争的资源。 国内iOS开发起步相对较晚，人才培养机制更是远远跟不上市场发展速度。 有限的iOS开发人才成了国内企业必争的资源。</p>--%>
                        <%--</div>--%>
                    <%--</div>--%>

                <%--</div>--%>
                <%--<div class="col-md-4 col-sm-6 col-xs-12 top-margin">--%>

                    <%--<div class="warp-border">--%>
                        <%--<div class="clearfix">--%>
                            <%--<div class="icon-people"><img src="/statics/image/task11/687.png"></div>--%>
                            <%--<div class="text">--%>
                                <%--<h4 class="">Web前端工程师</h4>--%>
                                <%--<p class="text-present">Web前端开发工程师，主要职责是利用(X)HTML/CSS/JavaScript/flash等各种Web技术进行产品的开发。</p>--%>
                            <%--</div>--%>
                        <%--</div>--%>

                        <%--<div class="warp-class2">--%>
                            <%--<div class="warp-class2-text">--%>
                                <%--<div class="iconfont text-padding">门槛 <img src="/statics/image/task11/xx.png"></div>--%>
                            <%--</div>--%>
                            <%--<div class="warp-class2-text">--%>
                                <%--<div class="iconfont text-padding text-border-left">难易程度 <img src="/statics/image/task11/xx.png"><img src="/statics/image/task11/xx.png"></div>--%>
                            <%--</div>--%>
                        <%--</div>--%>
                        <%--<div class="warp-class2">--%>
                            <%--<div class="warp-class2-text">--%>
                                <%--<div class="iconfont text-padding">成长周期 <span class="iconfont-color">1-3</span>年</div>--%>
                            <%--</div>--%>
                            <%--<div class="warp-class2-text">--%>
                                <%--<div class="iconfont text-padding text-border-left">稀缺程度 <span class="iconfont-color">345</span>家公司需要</div>--%>
                            <%--</div>--%>
                        <%--</div>--%>

                        <%--<div class="warp-class2">--%>
                            <%--<div class="leftWarp">--%>
                                <%--薪资待遇--%>
                            <%--</div>--%>
                            <%--<div class="rightWarp">--%>
                                <%--<div class="rightWarp-class">--%>
                                    <%--<div class="rightWarp-year">0-1年</div>--%>
                                    <%--<div class="rightWarp-wages">5k-10k/月</div>--%>
                                <%--</div>--%>
                                <%--<div class="rightWarp-class">--%>
                                    <%--<div class="rightWarp-year">0-1年</div>--%>
                                    <%--<div class="rightWarp-wages">5k-10k/月</div>--%>
                                <%--</div>--%>
                                <%--<div class="rightWarp-class border-bottom">--%>
                                    <%--<div class="rightWarp-year">0-1年</div>--%>
                                    <%--<div class="rightWarp-wages">5k-10k/月</div>--%>
                                <%--</div>--%>
                            <%--</div>--%>
                        <%--</div>--%>

                        <%--<div class="warp-class2">--%>
                            <%--<b class="text-b">有286人正在学</b>--%>
                        <%--</div>--%>
                        <%--<div class="warp-class2">--%>
                            <%--<p class="text-p">提示:在你学习之前你应该已经掌握XXXXX、XXXXX、XX等语言基础</p>--%>
                        <%--</div>--%>

                        <%--<div class="flip-container">--%>
                            <%--<p class="flip-title">iOS工程师</p>--%>
                            <%--<p class="flip-text">iOS是由苹果公司开发的移动操作统，iOS与苹果的Mac OS X操作系统一样， 也是以Darwin为基础的，因此同样属于类Unix的商业操作系统。国内iOS开发起步相对较晚， 人才培养机制更是远远跟不上市场发展速度。有限的iOS开发人才成了国内企业必争的资源。 国内iOS开发起步相对较晚，人才培养机制更是远远跟不上市场发展速度。 有限的iOS开发人才成了国内企业必争的资源。</p>--%>
                        <%--</div>--%>
                    <%--</div>--%>

                <%--</div>--%>
                <%--<div class="col-md-4 col-sm-6 col-xs-12 top-margin">--%>

                    <%--<div class="warp-border">--%>
                        <%--<div class="clearfix">--%>
                            <%--<div class="icon-people"><img src="/statics/image/task11/687.png"></div>--%>
                            <%--<div class="text">--%>
                                <%--<h4 class="">Web前端工程师</h4>--%>
                                <%--<p class="text-present">Web前端开发工程师，主要职责是利用(X)HTML/CSS/JavaScript/flash等各种Web技术进行产品的开发。</p>--%>
                            <%--</div>--%>
                        <%--</div>--%>

                        <%--<div class="warp-class2">--%>
                            <%--<div class="warp-class2-text">--%>
                                <%--<div class="iconfont text-padding">门槛 <img src="/statics/image/task11/xx.png"></div>--%>
                            <%--</div>--%>
                            <%--<div class="warp-class2-text">--%>
                                <%--<div class="iconfont text-padding text-border-left">难易程度 <img src="/statics/image/task11/xx.png"><img src="/statics/image/task11/xx.png"></div>--%>
                            <%--</div>--%>
                        <%--</div>--%>
                        <%--<div class="warp-class2">--%>
                            <%--<div class="warp-class2-text">--%>
                                <%--<div class="iconfont text-padding">成长周期 <span class="iconfont-color">1-3</span>年</div>--%>
                            <%--</div>--%>
                            <%--<div class="warp-class2-text">--%>
                                <%--<div class="iconfont text-padding text-border-left">稀缺程度 <span class="iconfont-color">345</span>家公司需要</div>--%>
                            <%--</div>--%>
                        <%--</div>--%>

                        <%--<div class="warp-class2">--%>
                            <%--<div class="leftWarp">--%>
                                <%--薪资待遇--%>
                            <%--</div>--%>
                            <%--<div class="rightWarp">--%>
                                <%--<div class="rightWarp-class">--%>
                                    <%--<div class="rightWarp-year">0-1年</div>--%>
                                    <%--<div class="rightWarp-wages">5k-10k/月</div>--%>
                                <%--</div>--%>
                                <%--<div class="rightWarp-class">--%>
                                    <%--<div class="rightWarp-year">0-1年</div>--%>
                                    <%--<div class="rightWarp-wages">5k-10k/月</div>--%>
                                <%--</div>--%>
                                <%--<div class="rightWarp-class border-bottom">--%>
                                    <%--<div class="rightWarp-year">0-1年</div>--%>
                                    <%--<div class="rightWarp-wages">5k-10k/月</div>--%>
                                <%--</div>--%>
                            <%--</div>--%>
                        <%--</div>--%>

                        <%--<div class="warp-class2">--%>
                            <%--<b class="text-b">有286人正在学</b>--%>
                        <%--</div>--%>
                        <%--<div class="warp-class2">--%>
                            <%--<p class="text-p">提示:在你学习之前你应该已经掌握XXXXX、XXXXX、XX等语言基础</p>--%>
                        <%--</div>--%>

                        <%--<div class="flip-container">--%>
                            <%--<p class="flip-title">iOS工程师</p>--%>
                            <%--<p class="flip-text">iOS是由苹果公司开发的移动操作统，iOS与苹果的Mac OS X操作系统一样， 也是以Darwin为基础的，因此同样属于类Unix的商业操作系统。国内iOS开发起步相对较晚， 人才培养机制更是远远跟不上市场发展速度。有限的iOS开发人才成了国内企业必争的资源。 国内iOS开发起步相对较晚，人才培养机制更是远远跟不上市场发展速度。 有限的iOS开发人才成了国内企业必争的资源。</p>--%>
                        <%--</div>--%>
                    <%--</div>--%>

                <%--</div>--%>
                <%--<div class="col-md-4 col-sm-6 col-xs-12 top-margin">--%>

                    <%--<div class="warp-border">--%>
                        <%--<div class="clearfix">--%>
                            <%--<div class="icon-people"><img src="/statics/image/task11/687.png"></div>--%>
                            <%--<div class="text">--%>
                                <%--<h4 class="">Web前端工程师</h4>--%>
                                <%--<p class="text-present">Web前端开发工程师，主要职责是利用(X)HTML/CSS/JavaScript/flash等各种Web技术进行产品的开发。</p>--%>
                            <%--</div>--%>
                        <%--</div>--%>

                        <%--<div class="warp-class2">--%>
                            <%--<div class="warp-class2-text">--%>
                                <%--<div class="iconfont text-padding">门槛 <img src="/statics/image/task11/xx.png"></div>--%>
                            <%--</div>--%>
                            <%--<div class="warp-class2-text">--%>
                                <%--<div class="iconfont text-padding text-border-left">难易程度 <img src="/statics/image/task11/xx.png"><img src="/statics/image/task11/xx.png"></div>--%>
                            <%--</div>--%>
                        <%--</div>--%>
                        <%--<div class="warp-class2">--%>
                            <%--<div class="warp-class2-text">--%>
                                <%--<div class="iconfont text-padding">成长周期 <span class="iconfont-color">1-3</span>年</div>--%>
                            <%--</div>--%>
                            <%--<div class="warp-class2-text">--%>
                                <%--<div class="iconfont text-padding text-border-left">稀缺程度 <span class="iconfont-color">345</span>家公司需要</div>--%>
                            <%--</div>--%>
                        <%--</div>--%>

                        <%--<div class="warp-class2">--%>
                            <%--<div class="leftWarp">--%>
                                <%--薪资待遇--%>
                            <%--</div>--%>
                            <%--<div class="rightWarp">--%>
                                <%--<div class="rightWarp-class">--%>
                                    <%--<div class="rightWarp-year">0-1年</div>--%>
                                    <%--<div class="rightWarp-wages">5k-10k/月</div>--%>
                                <%--</div>--%>
                                <%--<div class="rightWarp-class">--%>
                                    <%--<div class="rightWarp-year">0-1年</div>--%>
                                    <%--<div class="rightWarp-wages">5k-10k/月</div>--%>
                                <%--</div>--%>
                                <%--<div class="rightWarp-class border-bottom">--%>
                                    <%--<div class="rightWarp-year">0-1年</div>--%>
                                    <%--<div class="rightWarp-wages">5k-10k/月</div>--%>
                                <%--</div>--%>
                            <%--</div>--%>
                        <%--</div>--%>

                        <%--<div class="warp-class2">--%>
                            <%--<b class="text-b">有286人正在学</b>--%>
                        <%--</div>--%>
                        <%--<div class="warp-class2">--%>
                            <%--<p class="text-p">提示:在你学习之前你应该已经掌握XXXXX、XXXXX、XX等语言基础</p>--%>
                        <%--</div>--%>

                        <%--<div class="flip-container">--%>
                            <%--<p class="flip-title">iOS工程师</p>--%>
                            <%--<p class="flip-text">iOS是由苹果公司开发的移动操作统，iOS与苹果的Mac OS X操作系统一样， 也是以Darwin为基础的，因此同样属于类Unix的商业操作系统。国内iOS开发起步相对较晚， 人才培养机制更是远远跟不上市场发展速度。有限的iOS开发人才成了国内企业必争的资源。 国内iOS开发起步相对较晚，人才培养机制更是远远跟不上市场发展速度。 有限的iOS开发人才成了国内企业必争的资源。</p>--%>
                        <%--</div>--%>
                    <%--</div>--%>

                <%--</div>--%>
            <%--</div>--%>

            <%--<div class="caption">--%>
                <%--<h4>前端开发方向</h4>--%>
            <%--</div>--%>

            <%--<div class="row">--%>
                <%--<div class="col-md-4 col-sm-6 col-xs-12 top-margin">--%>

                    <%--<div class="warp-border">--%>
                        <%--<div class="clearfix">--%>
                            <%--<div class="icon-people"><img src="/statics/image/task11/687.png"></div>--%>
                            <%--<div class="text">--%>
                                <%--<h4 class="">Web前端工程师</h4>--%>
                                <%--<p class="text-present">Web前端开发工程师，主要职责是利用(X)HTML/CSS/JavaScript/flash等各种Web技术进行产品的开发。</p>--%>
                            <%--</div>--%>
                        <%--</div>--%>

                        <%--<div class="warp-class2">--%>
                            <%--<div class="warp-class2-text">--%>
                                <%--<div class="iconfont text-padding">门槛 <img src="/statics/image/task11/xx.png"></div>--%>
                            <%--</div>--%>
                            <%--<div class="warp-class2-text">--%>
                                <%--<div class="iconfont text-padding text-border-left">难易程度 <img src="/statics/image/task11/xx.png"><img src="/statics/image/task11/xx.png"></div>--%>
                            <%--</div>--%>
                        <%--</div>--%>
                        <%--<div class="warp-class2">--%>
                            <%--<div class="warp-class2-text">--%>
                                <%--<div class="iconfont text-padding">成长周期 <span class="iconfont-color">1-3</span>年</div>--%>
                            <%--</div>--%>
                            <%--<div class="warp-class2-text">--%>
                                <%--<div class="iconfont text-padding text-border-left">稀缺程度 <span class="iconfont-color">345</span>家公司需要</div>--%>
                            <%--</div>--%>
                        <%--</div>--%>

                        <%--<div class="warp-class2">--%>
                            <%--<div class="leftWarp">--%>
                                <%--薪资待遇--%>
                            <%--</div>--%>
                            <%--<div class="rightWarp">--%>
                                <%--<div class="rightWarp-class">--%>
                                    <%--<div class="rightWarp-year">0-1年</div>--%>
                                    <%--<div class="rightWarp-wages">5k-10k/月</div>--%>
                                <%--</div>--%>
                                <%--<div class="rightWarp-class">--%>
                                    <%--<div class="rightWarp-year">0-1年</div>--%>
                                    <%--<div class="rightWarp-wages">5k-10k/月</div>--%>
                                <%--</div>--%>
                                <%--<div class="rightWarp-class border-bottom">--%>
                                    <%--<div class="rightWarp-year">0-1年</div>--%>
                                    <%--<div class="rightWarp-wages">5k-10k/月</div>--%>
                                <%--</div>--%>
                            <%--</div>--%>
                        <%--</div>--%>

                        <%--<div class="warp-class2">--%>
                            <%--<b class="text-b">有286人正在学</b>--%>
                        <%--</div>--%>
                        <%--<div class="warp-class2">--%>
                            <%--<p class="text-p">提示:在你学习之前你应该已经掌握XXXXX、XXXXX、XX等语言基础</p>--%>
                        <%--</div>--%>

                        <%--<div class="flip-container">--%>
                            <%--<p class="flip-title">iOS工程师</p>--%>
                            <%--<p class="flip-text">iOS是由苹果公司开发的移动操作统，iOS与苹果的Mac OS X操作系统一样， 也是以Darwin为基础的，因此同样属于类Unix的商业操作系统。国内iOS开发起步相对较晚， 人才培养机制更是远远跟不上市场发展速度。有限的iOS开发人才成了国内企业必争的资源。 国内iOS开发起步相对较晚，人才培养机制更是远远跟不上市场发展速度。 有限的iOS开发人才成了国内企业必争的资源。</p>--%>
                        <%--</div>--%>
                    <%--</div>--%>

                <%--</div>--%>
                <%--<div class="col-md-4 col-sm-6 col-xs-12 top-margin">--%>

                    <%--<div class="warp-border">--%>
                        <%--<div class="clearfix">--%>
                            <%--<div class="icon-people"><img src="/statics/image/task11/687.png"></div>--%>
                            <%--<div class="text">--%>
                                <%--<h4 class="">Web前端工程师</h4>--%>
                                <%--<p class="text-present">Web前端开发工程师，主要职责是利用(X)HTML/CSS/JavaScript/flash等各种Web技术进行产品的开发。</p>--%>
                            <%--</div>--%>
                        <%--</div>--%>

                        <%--<div class="warp-class2">--%>
                            <%--<div class="warp-class2-text">--%>
                                <%--<div class="iconfont text-padding">门槛 <img src="/statics/image/task11/xx.png"></div>--%>
                            <%--</div>--%>
                            <%--<div class="warp-class2-text">--%>
                                <%--<div class="iconfont text-padding text-border-left">难易程度 <img src="/statics/image/task11/xx.png"><img src="/statics/image/task11/xx.png"></div>--%>
                            <%--</div>--%>
                        <%--</div>--%>
                        <%--<div class="warp-class2">--%>
                            <%--<div class="warp-class2-text">--%>
                                <%--<div class="iconfont text-padding">成长周期 <span class="iconfont-color">1-3</span>年</div>--%>
                            <%--</div>--%>
                            <%--<div class="warp-class2-text">--%>
                                <%--<div class="iconfont text-padding text-border-left">稀缺程度 <span class="iconfont-color">345</span>家公司需要</div>--%>
                            <%--</div>--%>
                        <%--</div>--%>

                        <%--<div class="warp-class2">--%>
                            <%--<div class="leftWarp">--%>
                                <%--薪资待遇--%>
                            <%--</div>--%>
                            <%--<div class="rightWarp">--%>
                                <%--<div class="rightWarp-class">--%>
                                    <%--<div class="rightWarp-year">0-1年</div>--%>
                                    <%--<div class="rightWarp-wages">5k-10k/月</div>--%>
                                <%--</div>--%>
                                <%--<div class="rightWarp-class">--%>
                                    <%--<div class="rightWarp-year">0-1年</div>--%>
                                    <%--<div class="rightWarp-wages">5k-10k/月</div>--%>
                                <%--</div>--%>
                                <%--<div class="rightWarp-class border-bottom">--%>
                                    <%--<div class="rightWarp-year">0-1年</div>--%>
                                    <%--<div class="rightWarp-wages">5k-10k/月</div>--%>
                                <%--</div>--%>
                            <%--</div>--%>
                        <%--</div>--%>

                        <%--<div class="warp-class2">--%>
                            <%--<b class="text-b">有286人正在学</b>--%>
                        <%--</div>--%>
                        <%--<div class="warp-class2">--%>
                            <%--<p class="text-p">提示:在你学习之前你应该已经掌握XXXXX、XXXXX、XX等语言基础</p>--%>
                        <%--</div>--%>

                        <%--<div class="flip-container">--%>
                            <%--<p class="flip-title">iOS工程师</p>--%>
                            <%--<p class="flip-text">iOS是由苹果公司开发的移动操作统，iOS与苹果的Mac OS X操作系统一样， 也是以Darwin为基础的，因此同样属于类Unix的商业操作系统。国内iOS开发起步相对较晚， 人才培养机制更是远远跟不上市场发展速度。有限的iOS开发人才成了国内企业必争的资源。 国内iOS开发起步相对较晚，人才培养机制更是远远跟不上市场发展速度。 有限的iOS开发人才成了国内企业必争的资源。</p>--%>
                        <%--</div>--%>
                    <%--</div>--%>

                <%--</div>--%>
                <%--<div class="col-md-4 col-sm-6 col-xs-12 top-margin">--%>

                    <%--<div class="warp-border">--%>
                        <%--<div class="clearfix">--%>
                            <%--<div class="icon-people"><img src="/statics/image/task11/687.png"></div>--%>
                            <%--<div class="text">--%>
                                <%--<h4 class="">Web前端工程师</h4>--%>
                                <%--<p class="text-present">Web前端开发工程师，主要职责是利用(X)HTML/CSS/JavaScript/flash等各种Web技术进行产品的开发。</p>--%>
                            <%--</div>--%>
                        <%--</div>--%>

                        <%--<div class="warp-class2">--%>
                            <%--<div class="warp-class2-text">--%>
                                <%--<div class="iconfont text-padding">门槛 <img src="/statics/image/task11/xx.png"></div>--%>
                            <%--</div>--%>
                            <%--<div class="warp-class2-text">--%>
                                <%--<div class="iconfont text-padding text-border-left">难易程度 <img src="/statics/image/task11/xx.png"><img src="/statics/image/task11/xx.png"></div>--%>
                            <%--</div>--%>
                        <%--</div>--%>
                        <%--<div class="warp-class2">--%>
                            <%--<div class="warp-class2-text">--%>
                                <%--<div class="iconfont text-padding">成长周期 <span class="iconfont-color">1-3</span>年</div>--%>
                            <%--</div>--%>
                            <%--<div class="warp-class2-text">--%>
                                <%--<div class="iconfont text-padding text-border-left">稀缺程度 <span class="iconfont-color">345</span>家公司需要</div>--%>
                            <%--</div>--%>
                        <%--</div>--%>

                        <%--<div class="warp-class2">--%>
                            <%--<div class="leftWarp">--%>
                                <%--薪资待遇--%>
                            <%--</div>--%>
                            <%--<div class="rightWarp">--%>
                                <%--<div class="rightWarp-class">--%>
                                    <%--<div class="rightWarp-year">0-1年</div>--%>
                                    <%--<div class="rightWarp-wages">5k-10k/月</div>--%>
                                <%--</div>--%>
                                <%--<div class="rightWarp-class">--%>
                                    <%--<div class="rightWarp-year">0-1年</div>--%>
                                    <%--<div class="rightWarp-wages">5k-10k/月</div>--%>
                                <%--</div>--%>
                                <%--<div class="rightWarp-class border-bottom">--%>
                                    <%--<div class="rightWarp-year">0-1年</div>--%>
                                    <%--<div class="rightWarp-wages">5k-10k/月</div>--%>
                                <%--</div>--%>
                            <%--</div>--%>
                        <%--</div>--%>

                        <%--<div class="warp-class2">--%>
                            <%--<b class="text-b">有286人正在学</b>--%>
                        <%--</div>--%>
                        <%--<div class="warp-class2">--%>
                            <%--<p class="text-p">提示:在你学习之前你应该已经掌握XXXXX、XXXXX、XX等语言基础</p>--%>
                        <%--</div>--%>

                        <%--<div class="flip-container">--%>
                            <%--<p class="flip-title">iOS工程师</p>--%>
                            <%--<p class="flip-text">iOS是由苹果公司开发的移动操作统，iOS与苹果的Mac OS X操作系统一样， 也是以Darwin为基础的，因此同样属于类Unix的商业操作系统。国内iOS开发起步相对较晚， 人才培养机制更是远远跟不上市场发展速度。有限的iOS开发人才成了国内企业必争的资源。 国内iOS开发起步相对较晚，人才培养机制更是远远跟不上市场发展速度。 有限的iOS开发人才成了国内企业必争的资源。</p>--%>
                        <%--</div>--%>
                    <%--</div>--%>

                <%--</div>--%>
                <%--<div class="col-md-4 col-sm-6 col-xs-12 top-margin">--%>

                    <%--<div class="warp-border">--%>
                        <%--<div class="clearfix">--%>
                            <%--<div class="icon-people"><img src="/statics/image/task11/687.png"></div>--%>
                            <%--<div class="text">--%>
                                <%--<h4 class="">Web前端工程师</h4>--%>
                                <%--<p class="text-present">Web前端开发工程师，主要职责是利用(X)HTML/CSS/JavaScript/flash等各种Web技术进行产品的开发。</p>--%>
                            <%--</div>--%>
                        <%--</div>--%>

                        <%--<div class="warp-class2">--%>
                            <%--<div class="warp-class2-text">--%>
                                <%--<div class="iconfont text-padding">门槛 <img src="/statics/image/task11/xx.png"></div>--%>
                            <%--</div>--%>
                            <%--<div class="warp-class2-text">--%>
                                <%--<div class="iconfont text-padding text-border-left">难易程度 <img src="/statics/image/task11/xx.png"><img src="/statics/image/task11/xx.png"></div>--%>
                            <%--</div>--%>
                        <%--</div>--%>
                        <%--<div class="warp-class2">--%>
                            <%--<div class="warp-class2-text">--%>
                                <%--<div class="iconfont text-padding">成长周期 <span class="iconfont-color">1-3</span>年</div>--%>
                            <%--</div>--%>
                            <%--<div class="warp-class2-text">--%>
                                <%--<div class="iconfont text-padding text-border-left">稀缺程度 <span class="iconfont-color">345</span>家公司需要</div>--%>
                            <%--</div>--%>
                        <%--</div>--%>

                        <%--<div class="warp-class2">--%>
                            <%--<div class="leftWarp">--%>
                                <%--薪资待遇--%>
                            <%--</div>--%>
                            <%--<div class="rightWarp">--%>
                                <%--<div class="rightWarp-class">--%>
                                    <%--<div class="rightWarp-year">0-1年</div>--%>
                                    <%--<div class="rightWarp-wages">5k-10k/月</div>--%>
                                <%--</div>--%>
                                <%--<div class="rightWarp-class">--%>
                                    <%--<div class="rightWarp-year">0-1年</div>--%>
                                    <%--<div class="rightWarp-wages">5k-10k/月</div>--%>
                                <%--</div>--%>
                                <%--<div class="rightWarp-class border-bottom">--%>
                                    <%--<div class="rightWarp-year">0-1年</div>--%>
                                    <%--<div class="rightWarp-wages">5k-10k/月</div>--%>
                                <%--</div>--%>
                            <%--</div>--%>
                        <%--</div>--%>

                        <%--<div class="warp-class2">--%>
                            <%--<b class="text-b">有286人正在学</b>--%>
                        <%--</div>--%>
                        <%--<div class="warp-class2">--%>
                            <%--<p class="text-p">提示:在你学习之前你应该已经掌握XXXXX、XXXXX、XX等语言基础</p>--%>
                        <%--</div>--%>

                        <%--<div class="flip-container">--%>
                            <%--<p class="flip-title">iOS工程师</p>--%>
                            <%--<p class="flip-text">iOS是由苹果公司开发的移动操作统，iOS与苹果的Mac OS X操作系统一样， 也是以Darwin为基础的，因此同样属于类Unix的商业操作系统。国内iOS开发起步相对较晚， 人才培养机制更是远远跟不上市场发展速度。有限的iOS开发人才成了国内企业必争的资源。 国内iOS开发起步相对较晚，人才培养机制更是远远跟不上市场发展速度。 有限的iOS开发人才成了国内企业必争的资源。</p>--%>
                        <%--</div>--%>
                    <%--</div>--%>

                <%--</div>--%>
                <%--<div class="col-md-4 col-sm-6 col-xs-12 top-margin">--%>

                    <%--<div class="warp-border">--%>
                        <%--<div class="clearfix">--%>
                            <%--<div class="icon-people"><img src="/statics/image/task11/687.png"></div>--%>
                            <%--<div class="text">--%>
                                <%--<h4 class="">Web前端工程师</h4>--%>
                                <%--<p class="text-present">Web前端开发工程师，主要职责是利用(X)HTML/CSS/JavaScript/flash等各种Web技术进行产品的开发。</p>--%>
                            <%--</div>--%>
                        <%--</div>--%>

                        <%--<div class="warp-class2">--%>
                            <%--<div class="warp-class2-text">--%>
                                <%--<div class="iconfont text-padding">门槛 <img src="/statics/image/task11/xx.png"></div>--%>
                            <%--</div>--%>
                            <%--<div class="warp-class2-text">--%>
                                <%--<div class="iconfont text-padding text-border-left">难易程度 <img src="/statics/image/task11/xx.png"><img src="/statics/image/task11/xx.png"></div>--%>
                            <%--</div>--%>
                        <%--</div>--%>
                        <%--<div class="warp-class2">--%>
                            <%--<div class="warp-class2-text">--%>
                                <%--<div class="iconfont text-padding">成长周期 <span class="iconfont-color">1-3</span>年</div>--%>
                            <%--</div>--%>
                            <%--<div class="warp-class2-text">--%>
                                <%--<div class="iconfont text-padding text-border-left">稀缺程度 <span class="iconfont-color">345</span>家公司需要</div>--%>
                            <%--</div>--%>
                        <%--</div>--%>

                        <%--<div class="warp-class2">--%>
                            <%--<div class="leftWarp">--%>
                                <%--薪资待遇--%>
                            <%--</div>--%>
                            <%--<div class="rightWarp">--%>
                                <%--<div class="rightWarp-class">--%>
                                    <%--<div class="rightWarp-year">0-1年</div>--%>
                                    <%--<div class="rightWarp-wages">5k-10k/月</div>--%>
                                <%--</div>--%>
                                <%--<div class="rightWarp-class">--%>
                                    <%--<div class="rightWarp-year">0-1年</div>--%>
                                    <%--<div class="rightWarp-wages">5k-10k/月</div>--%>
                                <%--</div>--%>
                                <%--<div class="rightWarp-class border-bottom">--%>
                                    <%--<div class="rightWarp-year">0-1年</div>--%>
                                    <%--<div class="rightWarp-wages">5k-10k/月</div>--%>
                                <%--</div>--%>
                            <%--</div>--%>
                        <%--</div>--%>

                        <%--<div class="warp-class2">--%>
                            <%--<b class="text-b">有286人正在学</b>--%>
                        <%--</div>--%>
                        <%--<div class="warp-class2">--%>
                            <%--<p class="text-p">提示:在你学习之前你应该已经掌握XXXXX、XXXXX、XX等语言基础</p>--%>
                        <%--</div>--%>

                        <%--<div class="flip-container">--%>
                            <%--<p class="flip-title">iOS工程师</p>--%>
                            <%--<p class="flip-text">iOS是由苹果公司开发的移动操作统，iOS与苹果的Mac OS X操作系统一样， 也是以Darwin为基础的，因此同样属于类Unix的商业操作系统。国内iOS开发起步相对较晚， 人才培养机制更是远远跟不上市场发展速度。有限的iOS开发人才成了国内企业必争的资源。 国内iOS开发起步相对较晚，人才培养机制更是远远跟不上市场发展速度。 有限的iOS开发人才成了国内企业必争的资源。</p>--%>
                        <%--</div>--%>
                    <%--</div>--%>

                <%--</div>--%>
                <%--<div class="col-md-4 col-sm-6 col-xs-12 top-margin">--%>

                    <%--<div class="warp-border">--%>
                        <%--<div class="clearfix">--%>
                            <%--<div class="icon-people"><img src="/statics/image/task11/687.png"></div>--%>
                            <%--<div class="text">--%>
                                <%--<h4 class="">Web前端工程师</h4>--%>
                                <%--<p class="text-present">Web前端开发工程师，主要职责是利用(X)HTML/CSS/JavaScript/flash等各种Web技术进行产品的开发。</p>--%>
                            <%--</div>--%>
                        <%--</div>--%>

                        <%--<div class="warp-class2">--%>
                            <%--<div class="warp-class2-text">--%>
                                <%--<div class="iconfont text-padding">门槛 <img src="/statics/image/task11/xx.png"></div>--%>
                            <%--</div>--%>
                            <%--<div class="warp-class2-text">--%>
                                <%--<div class="iconfont text-padding text-border-left">难易程度 <img src="/statics/image/task11/xx.png"><img src="/statics/image/task11/xx.png"></div>--%>
                            <%--</div>--%>
                        <%--</div>--%>
                        <%--<div class="warp-class2">--%>
                            <%--<div class="warp-class2-text">--%>
                                <%--<div class="iconfont text-padding">成长周期 <span class="iconfont-color">1-3</span>年</div>--%>
                            <%--</div>--%>
                            <%--<div class="warp-class2-text">--%>
                                <%--<div class="iconfont text-padding text-border-left">稀缺程度 <span class="iconfont-color">345</span>家公司需要</div>--%>
                            <%--</div>--%>
                        <%--</div>--%>

                        <%--<div class="warp-class2">--%>
                            <%--<div class="leftWarp">--%>
                                <%--薪资待遇--%>
                            <%--</div>--%>
                            <%--<div class="rightWarp">--%>
                                <%--<div class="rightWarp-class">--%>
                                    <%--<div class="rightWarp-year">0-1年</div>--%>
                                    <%--<div class="rightWarp-wages">5k-10k/月</div>--%>
                                <%--</div>--%>
                                <%--<div class="rightWarp-class">--%>
                                    <%--<div class="rightWarp-year">0-1年</div>--%>
                                    <%--<div class="rightWarp-wages">5k-10k/月</div>--%>
                                <%--</div>--%>
                                <%--<div class="rightWarp-class border-bottom">--%>
                                    <%--<div class="rightWarp-year">0-1年</div>--%>
                                    <%--<div class="rightWarp-wages">5k-10k/月</div>--%>
                                <%--</div>--%>
                            <%--</div>--%>
                        <%--</div>--%>

                        <%--<div class="warp-class2">--%>
                            <%--<b class="text-b">有286人正在学</b>--%>
                        <%--</div>--%>
                        <%--<div class="warp-class2">--%>
                            <%--<p class="text-p">提示:在你学习之前你应该已经掌握XXXXX、XXXXX、XX等语言基础</p>--%>
                        <%--</div>--%>

                        <%--<div class="flip-container">--%>
                            <%--<p class="flip-title">iOS工程师</p>--%>
                            <%--<p class="flip-text">iOS是由苹果公司开发的移动操作统，iOS与苹果的Mac OS X操作系统一样， 也是以Darwin为基础的，因此同样属于类Unix的商业操作系统。国内iOS开发起步相对较晚， 人才培养机制更是远远跟不上市场发展速度。有限的iOS开发人才成了国内企业必争的资源。 国内iOS开发起步相对较晚，人才培养机制更是远远跟不上市场发展速度。 有限的iOS开发人才成了国内企业必争的资源。</p>--%>
                        <%--</div>--%>
                    <%--</div>--%>

                <%--</div>--%>
            <%--</div>--%>

            <%--<div class="caption">--%>
                <%--<h4>前端开发方向</h4>--%>
            <%--</div>--%>

            <%--<div class="row padding-bottom">--%>
                <%--<div class="col-md-4 col-sm-6 col-xs-12 top-margin">--%>

                    <%--<div class="warp-border">--%>
                        <%--<div class="clearfix">--%>
                            <%--<div class="icon-people"><img src="/statics/image/task11/687.png"></div>--%>
                            <%--<div class="text">--%>
                                <%--<h4 class="">Web前端工程师</h4>--%>
                                <%--<p class="text-present">Web前端开发工程师，主要职责是利用(X)HTML/CSS/JavaScript/flash等各种Web技术进行产品的开发。</p>--%>
                            <%--</div>--%>
                        <%--</div>--%>

                        <%--<div class="warp-class2">--%>
                            <%--<div class="warp-class2-text">--%>
                                <%--<div class="iconfont text-padding">门槛 <img src="/statics/image/task11/xx.png"></div>--%>
                            <%--</div>--%>
                            <%--<div class="warp-class2-text">--%>
                                <%--<div class="iconfont text-padding text-border-left">难易程度 <img src="/statics/image/task11/xx.png"><img src="/statics/image/task11/xx.png"></div>--%>
                            <%--</div>--%>
                        <%--</div>--%>
                        <%--<div class="warp-class2">--%>
                            <%--<div class="warp-class2-text">--%>
                                <%--<div class="iconfont text-padding">成长周期 <span class="iconfont-color">1-3</span>年</div>--%>
                            <%--</div>--%>
                            <%--<div class="warp-class2-text">--%>
                                <%--<div class="iconfont text-padding text-border-left">稀缺程度 <span class="iconfont-color">345</span>家公司需要</div>--%>
                            <%--</div>--%>
                        <%--</div>--%>

                        <%--<div class="warp-class2">--%>
                            <%--<div class="leftWarp">--%>
                                <%--薪资待遇--%>
                            <%--</div>--%>
                            <%--<div class="rightWarp">--%>
                                <%--<div class="rightWarp-class">--%>
                                    <%--<div class="rightWarp-year">0-1年</div>--%>
                                    <%--<div class="rightWarp-wages">5k-10k/月</div>--%>
                                <%--</div>--%>
                                <%--<div class="rightWarp-class">--%>
                                    <%--<div class="rightWarp-year">0-1年</div>--%>
                                    <%--<div class="rightWarp-wages">5k-10k/月</div>--%>
                                <%--</div>--%>
                                <%--<div class="rightWarp-class border-bottom">--%>
                                    <%--<div class="rightWarp-year">0-1年</div>--%>
                                    <%--<div class="rightWarp-wages">5k-10k/月</div>--%>
                                <%--</div>--%>
                            <%--</div>--%>
                        <%--</div>--%>

                        <%--<div class="warp-class2">--%>
                            <%--<b class="text-b">有286人正在学</b>--%>
                        <%--</div>--%>
                        <%--<div class="warp-class2">--%>
                            <%--<p class="text-p">提示:在你学习之前你应该已经掌握XXXXX、XXXXX、XX等语言基础</p>--%>
                        <%--</div>--%>

                        <%--<div class="flip-container">--%>
                            <%--<p class="flip-title">iOS工程师</p>--%>
                            <%--<p class="flip-text">iOS是由苹果公司开发的移动操作统，iOS与苹果的Mac OS X操作系统一样， 也是以Darwin为基础的，因此同样属于类Unix的商业操作系统。国内iOS开发起步相对较晚， 人才培养机制更是远远跟不上市场发展速度。有限的iOS开发人才成了国内企业必争的资源。 国内iOS开发起步相对较晚，人才培养机制更是远远跟不上市场发展速度。 有限的iOS开发人才成了国内企业必争的资源。</p>--%>
                        <%--</div>--%>
                    <%--</div>--%>

                <%--</div>--%>
                <%--<div class="col-md-4 col-sm-6 col-xs-12 top-margin">--%>

                    <%--<div class="warp-border">--%>
                        <%--<div class="clearfix">--%>
                            <%--<div class="icon-people"><img src="/statics/image/task11/687.png"></div>--%>
                            <%--<div class="text">--%>
                                <%--<h4 class="">Web前端工程师</h4>--%>
                                <%--<p class="text-present">Web前端开发工程师，主要职责是利用(X)HTML/CSS/JavaScript/flash等各种Web技术进行产品的开发。</p>--%>
                            <%--</div>--%>
                        <%--</div>--%>

                        <%--<div class="warp-class2">--%>
                            <%--<div class="warp-class2-text">--%>
                                <%--<div class="iconfont text-padding">门槛 <img src="/statics/image/task11/xx.png"></div>--%>
                            <%--</div>--%>
                            <%--<div class="warp-class2-text">--%>
                                <%--<div class="iconfont text-padding text-border-left">难易程度 <img src="/statics/image/task11/xx.png"><img src="/statics/image/task11/xx.png"></div>--%>
                            <%--</div>--%>
                        <%--</div>--%>
                        <%--<div class="warp-class2">--%>
                            <%--<div class="warp-class2-text">--%>
                                <%--<div class="iconfont text-padding">成长周期 <span class="iconfont-color">1-3</span>年</div>--%>
                            <%--</div>--%>
                            <%--<div class="warp-class2-text">--%>
                                <%--<div class="iconfont text-padding text-border-left">稀缺程度 <span class="iconfont-color">345</span>家公司需要</div>--%>
                            <%--</div>--%>
                        <%--</div>--%>

                        <%--<div class="warp-class2">--%>
                            <%--<div class="leftWarp">--%>
                                <%--薪资待遇--%>
                            <%--</div>--%>
                            <%--<div class="rightWarp">--%>
                                <%--<div class="rightWarp-class">--%>
                                    <%--<div class="rightWarp-year">0-1年</div>--%>
                                    <%--<div class="rightWarp-wages">5k-10k/月</div>--%>
                                <%--</div>--%>
                                <%--<div class="rightWarp-class">--%>
                                    <%--<div class="rightWarp-year">0-1年</div>--%>
                                    <%--<div class="rightWarp-wages">5k-10k/月</div>--%>
                                <%--</div>--%>
                                <%--<div class="rightWarp-class border-bottom">--%>
                                    <%--<div class="rightWarp-year">0-1年</div>--%>
                                    <%--<div class="rightWarp-wages">5k-10k/月</div>--%>
                                <%--</div>--%>
                            <%--</div>--%>
                        <%--</div>--%>

                        <%--<div class="warp-class2">--%>
                            <%--<b class="text-b">有286人正在学</b>--%>
                        <%--</div>--%>
                        <%--<div class="warp-class2">--%>
                            <%--<p class="text-p">提示:在你学习之前你应该已经掌握XXXXX、XXXXX、XX等语言基础</p>--%>
                        <%--</div>--%>

                        <%--<div class="flip-container">--%>
                            <%--<p class="flip-title">iOS工程师</p>--%>
                            <%--<p class="flip-text">iOS是由苹果公司开发的移动操作统，iOS与苹果的Mac OS X操作系统一样， 也是以Darwin为基础的，因此同样属于类Unix的商业操作系统。国内iOS开发起步相对较晚， 人才培养机制更是远远跟不上市场发展速度。有限的iOS开发人才成了国内企业必争的资源。 国内iOS开发起步相对较晚，人才培养机制更是远远跟不上市场发展速度。 有限的iOS开发人才成了国内企业必争的资源。</p>--%>
                        <%--</div>--%>
                    <%--</div>--%>

                <%--</div>--%>
                <%--<div class="col-md-4 col-sm-6 col-xs-12 top-margin">--%>

                    <%--<div class="warp-border">--%>
                        <%--<div class="clearfix">--%>
                            <%--<div class="icon-people"><img src="/statics/image/task11/687.png"></div>--%>
                            <%--<div class="text">--%>
                                <%--<h4 class="">Web前端工程师</h4>--%>
                                <%--<p class="text-present">Web前端开发工程师，主要职责是利用(X)HTML/CSS/JavaScript/flash等各种Web技术进行产品的开发。</p>--%>
                            <%--</div>--%>
                        <%--</div>--%>

                        <%--<div class="warp-class2">--%>
                            <%--<div class="warp-class2-text">--%>
                                <%--<div class="iconfont text-padding">门槛 <img src="/statics/image/task11/xx.png"></div>--%>
                            <%--</div>--%>
                            <%--<div class="warp-class2-text">--%>
                                <%--<div class="iconfont text-padding text-border-left">难易程度 <img src="/statics/image/task11/xx.png"><img src="/statics/image/task11/xx.png"></div>--%>
                            <%--</div>--%>
                        <%--</div>--%>
                        <%--<div class="warp-class2">--%>
                            <%--<div class="warp-class2-text">--%>
                                <%--<div class="iconfont text-padding">成长周期 <span class="iconfont-color">1-3</span>年</div>--%>
                            <%--</div>--%>
                            <%--<div class="warp-class2-text">--%>
                                <%--<div class="iconfont text-padding text-border-left">稀缺程度 <span class="iconfont-color">345</span>家公司需要</div>--%>
                            <%--</div>--%>
                        <%--</div>--%>

                        <%--<div class="warp-class2">--%>
                            <%--<div class="leftWarp">--%>
                                <%--薪资待遇--%>
                            <%--</div>--%>
                            <%--<div class="rightWarp">--%>
                                <%--<div class="rightWarp-class">--%>
                                    <%--<div class="rightWarp-year">0-1年</div>--%>
                                    <%--<div class="rightWarp-wages">5k-10k/月</div>--%>
                                <%--</div>--%>
                                <%--<div class="rightWarp-class">--%>
                                    <%--<div class="rightWarp-year">0-1年</div>--%>
                                    <%--<div class="rightWarp-wages">5k-10k/月</div>--%>
                                <%--</div>--%>
                                <%--<div class="rightWarp-class border-bottom">--%>
                                    <%--<div class="rightWarp-year">0-1年</div>--%>
                                    <%--<div class="rightWarp-wages">5k-10k/月</div>--%>
                                <%--</div>--%>
                            <%--</div>--%>
                        <%--</div>--%>

                        <%--<div class="warp-class2">--%>
                            <%--<b class="text-b">有286人正在学</b>--%>
                        <%--</div>--%>
                        <%--<div class="warp-class2">--%>
                            <%--<p class="text-p">提示:在你学习之前你应该已经掌握XXXXX、XXXXX、XX等语言基础</p>--%>
                        <%--</div>--%>

                        <%--<div class="flip-container">--%>
                            <%--<p class="flip-title">iOS工程师</p>--%>
                            <%--<p class="flip-text">iOS是由苹果公司开发的移动操作统，iOS与苹果的Mac OS X操作系统一样， 也是以Darwin为基础的，因此同样属于类Unix的商业操作系统。国内iOS开发起步相对较晚， 人才培养机制更是远远跟不上市场发展速度。有限的iOS开发人才成了国内企业必争的资源。 国内iOS开发起步相对较晚，人才培养机制更是远远跟不上市场发展速度。 有限的iOS开发人才成了国内企业必争的资源。</p>--%>
                        <%--</div>--%>
                    <%--</div>--%>

                <%--</div>--%>
                <%--<div class="col-md-4 col-sm-6 col-xs-12 top-margin">--%>

                    <%--<div class="warp-border">--%>
                        <%--<div class="clearfix">--%>
                            <%--<div class="icon-people"><img src="/statics/image/task11/687.png"></div>--%>
                            <%--<div class="text">--%>
                                <%--<h4 class="">Web前端工程师</h4>--%>
                                <%--<p class="text-present">Web前端开发工程师，主要职责是利用(X)HTML/CSS/JavaScript/flash等各种Web技术进行产品的开发。</p>--%>
                            <%--</div>--%>
                        <%--</div>--%>

                        <%--<div class="warp-class2">--%>
                            <%--<div class="warp-class2-text">--%>
                                <%--<div class="iconfont text-padding">门槛 <img src="/statics/image/task11/xx.png"></div>--%>
                            <%--</div>--%>
                            <%--<div class="warp-class2-text">--%>
                                <%--<div class="iconfont text-padding text-border-left">难易程度 <img src="/statics/image/task11/xx.png"><img src="/statics/image/task11/xx.png"></div>--%>
                            <%--</div>--%>
                        <%--</div>--%>
                        <%--<div class="warp-class2">--%>
                            <%--<div class="warp-class2-text">--%>
                                <%--<div class="iconfont text-padding">成长周期 <span class="iconfont-color">1-3</span>年</div>--%>
                            <%--</div>--%>
                            <%--<div class="warp-class2-text">--%>
                                <%--<div class="iconfont text-padding text-border-left">稀缺程度 <span class="iconfont-color">345</span>家公司需要</div>--%>
                            <%--</div>--%>
                        <%--</div>--%>

                        <%--<div class="warp-class2">--%>
                            <%--<div class="leftWarp">--%>
                                <%--薪资待遇--%>
                            <%--</div>--%>
                            <%--<div class="rightWarp">--%>
                                <%--<div class="rightWarp-class">--%>
                                    <%--<div class="rightWarp-year">0-1年</div>--%>
                                    <%--<div class="rightWarp-wages">5k-10k/月</div>--%>
                                <%--</div>--%>
                                <%--<div class="rightWarp-class">--%>
                                    <%--<div class="rightWarp-year">0-1年</div>--%>
                                    <%--<div class="rightWarp-wages">5k-10k/月</div>--%>
                                <%--</div>--%>
                                <%--<div class="rightWarp-class border-bottom">--%>
                                    <%--<div class="rightWarp-year">0-1年</div>--%>
                                    <%--<div class="rightWarp-wages">5k-10k/月</div>--%>
                                <%--</div>--%>
                            <%--</div>--%>
                        <%--</div>--%>

                        <%--<div class="warp-class2">--%>
                            <%--<b class="text-b">有286人正在学</b>--%>
                        <%--</div>--%>
                        <%--<div class="warp-class2">--%>
                            <%--<p class="text-p">提示:在你学习之前你应该已经掌握XXXXX、XXXXX、XX等语言基础</p>--%>
                        <%--</div>--%>

                        <%--<div class="flip-container">--%>
                            <%--<p class="flip-title">iOS工程师</p>--%>
                            <%--<p class="flip-text">iOS是由苹果公司开发的移动操作统，iOS与苹果的Mac OS X操作系统一样， 也是以Darwin为基础的，因此同样属于类Unix的商业操作系统。国内iOS开发起步相对较晚， 人才培养机制更是远远跟不上市场发展速度。有限的iOS开发人才成了国内企业必争的资源。 国内iOS开发起步相对较晚，人才培养机制更是远远跟不上市场发展速度。 有限的iOS开发人才成了国内企业必争的资源。</p>--%>
                        <%--</div>--%>
                    <%--</div>--%>

                <%--</div>--%>
                <%--<div class="col-md-4 col-sm-6 col-xs-12 top-margin">--%>

                    <%--<div class="warp-border">--%>
                        <%--<div class="clearfix">--%>
                            <%--<div class="icon-people"><img src="/statics/image/task11/687.png"></div>--%>
                            <%--<div class="text">--%>
                                <%--<h4 class="">Web前端工程师</h4>--%>
                                <%--<p class="text-present">Web前端开发工程师，主要职责是利用(X)HTML/CSS/JavaScript/flash等各种Web技术进行产品的开发。</p>--%>
                            <%--</div>--%>
                        <%--</div>--%>

                        <%--<div class="warp-class2">--%>
                            <%--<div class="warp-class2-text">--%>
                                <%--<div class="iconfont text-padding">门槛 <img src="/statics/image/task11/xx.png"></div>--%>
                            <%--</div>--%>
                            <%--<div class="warp-class2-text">--%>
                                <%--<div class="iconfont text-padding text-border-left">难易程度 <img src="/statics/image/task11/xx.png"><img src="/statics/image/task11/xx.png"></div>--%>
                            <%--</div>--%>
                        <%--</div>--%>
                        <%--<div class="warp-class2">--%>
                            <%--<div class="warp-class2-text">--%>
                                <%--<div class="iconfont text-padding">成长周期 <span class="iconfont-color">1-3</span>年</div>--%>
                            <%--</div>--%>
                            <%--<div class="warp-class2-text">--%>
                                <%--<div class="iconfont text-padding text-border-left">稀缺程度 <span class="iconfont-color">345</span>家公司需要</div>--%>
                            <%--</div>--%>
                        <%--</div>--%>

                        <%--<div class="warp-class2">--%>
                            <%--<div class="leftWarp">--%>
                                <%--薪资待遇--%>
                            <%--</div>--%>
                            <%--<div class="rightWarp">--%>
                                <%--<div class="rightWarp-class">--%>
                                    <%--<div class="rightWarp-year">0-1年</div>--%>
                                    <%--<div class="rightWarp-wages">5k-10k/月</div>--%>
                                <%--</div>--%>
                                <%--<div class="rightWarp-class">--%>
                                    <%--<div class="rightWarp-year">0-1年</div>--%>
                                    <%--<div class="rightWarp-wages">5k-10k/月</div>--%>
                                <%--</div>--%>
                                <%--<div class="rightWarp-class border-bottom">--%>
                                    <%--<div class="rightWarp-year">0-1年</div>--%>
                                    <%--<div class="rightWarp-wages">5k-10k/月</div>--%>
                                <%--</div>--%>
                            <%--</div>--%>
                        <%--</div>--%>

                        <%--<div class="warp-class2">--%>
                            <%--<b class="text-b">有286人正在学</b>--%>
                        <%--</div>--%>
                        <%--<div class="warp-class2">--%>
                            <%--<p class="text-p">提示:在你学习之前你应该已经掌握XXXXX、XXXXX、XX等语言基础</p>--%>
                        <%--</div>--%>

                        <%--<div class="flip-container">--%>
                            <%--<p class="flip-title">iOS工程师</p>--%>
                            <%--<p class="flip-text">iOS是由苹果公司开发的移动操作统，iOS与苹果的Mac OS X操作系统一样， 也是以Darwin为基础的，因此同样属于类Unix的商业操作系统。国内iOS开发起步相对较晚， 人才培养机制更是远远跟不上市场发展速度。有限的iOS开发人才成了国内企业必争的资源。 国内iOS开发起步相对较晚，人才培养机制更是远远跟不上市场发展速度。 有限的iOS开发人才成了国内企业必争的资源。</p>--%>
                        <%--</div>--%>
                    <%--</div>--%>

                <%--</div>--%>
                <%--<div class="col-md-4 col-sm-6 col-xs-12 top-margin">--%>

                    <%--<div class="warp-border">--%>
                        <%--<div class="clearfix">--%>
                            <%--<div class="icon-people"><img src="/statics/image/task11/687.png"></div>--%>
                            <%--<div class="text">--%>
                                <%--<h4 class="">Web前端工程师</h4>--%>
                                <%--<p class="text-present">Web前端开发工程师，主要职责是利用(X)HTML/CSS/JavaScript/flash等各种Web技术进行产品的开发。</p>--%>
                            <%--</div>--%>
                        <%--</div>--%>

                        <%--<div class="warp-class2">--%>
                            <%--<div class="warp-class2-text">--%>
                                <%--<div class="iconfont text-padding">门槛 <img src="/statics/image/task11/xx.png"></div>--%>
                            <%--</div>--%>
                            <%--<div class="warp-class2-text">--%>
                                <%--<div class="iconfont text-padding text-border-left">难易程度 <img src="/statics/image/task11/xx.png"><img src="/statics/image/task11/xx.png"></div>--%>
                            <%--</div>--%>
                        <%--</div>--%>
                        <%--<div class="warp-class2">--%>
                            <%--<div class="warp-class2-text">--%>
                                <%--<div class="iconfont text-padding">成长周期 <span class="iconfont-color">1-3</span>年</div>--%>
                            <%--</div>--%>
                            <%--<div class="warp-class2-text">--%>
                                <%--<div class="iconfont text-padding text-border-left">稀缺程度 <span class="iconfont-color">345</span>家公司需要</div>--%>
                            <%--</div>--%>
                        <%--</div>--%>

                        <%--<div class="warp-class2">--%>
                            <%--<div class="leftWarp">--%>
                                <%--薪资待遇--%>
                            <%--</div>--%>
                            <%--<div class="rightWarp">--%>
                                <%--<div class="rightWarp-class">--%>
                                    <%--<div class="rightWarp-year">0-1年</div>--%>
                                    <%--<div class="rightWarp-wages">5k-10k/月</div>--%>
                                <%--</div>--%>
                                <%--<div class="rightWarp-class">--%>
                                    <%--<div class="rightWarp-year">0-1年</div>--%>
                                    <%--<div class="rightWarp-wages">5k-10k/月</div>--%>
                                <%--</div>--%>
                                <%--<div class="rightWarp-class border-bottom">--%>
                                    <%--<div class="rightWarp-year">0-1年</div>--%>
                                    <%--<div class="rightWarp-wages">5k-10k/月</div>--%>
                                <%--</div>--%>
                            <%--</div>--%>
                        <%--</div>--%>

                        <%--<div class="warp-class2">--%>
                            <%--<b class="text-b">有286人正在学</b>--%>
                        <%--</div>--%>
                        <%--<div class="warp-class2">--%>
                            <%--<p class="text-p">提示:在你学习之前你应该已经掌握XXXXX、XXXXX、XX等语言基础</p>--%>
                        <%--</div>--%>

                        <%--<div class="flip-container">--%>
                            <%--<p class="flip-title">iOS工程师</p>--%>
                            <%--<p class="flip-text">iOS是由苹果公司开发的移动操作统，iOS与苹果的Mac OS X操作系统一样， 也是以Darwin为基础的，因此同样属于类Unix的商业操作系统。国内iOS开发起步相对较晚， 人才培养机制更是远远跟不上市场发展速度。有限的iOS开发人才成了国内企业必争的资源。 国内iOS开发起步相对较晚，人才培养机制更是远远跟不上市场发展速度。 有限的iOS开发人才成了国内企业必争的资源。</p>--%>
                        <%--</div>--%>
                    <%--</div>--%>

         </div>
        </div>
    </div>

    <%--<!--footer-->--%>
<%--<footer class="footer">--%>
    <%--<div class="container height">--%>
        <%--<div class="row">--%>
            <%--<div class="text-left col-sm-4">--%>
                <%--<span>技能树 &mdash; 改变你我</span>--%>
                <%--<p class="bottom">关于我们 | 联系我们 | 合作企业</p>--%>
            <%--</div>--%>
            <%--<div class="text-center col-sm-4">--%>
                <%--<p>旗下网站</p>--%>
                <%--<span>草船云孵化器     最强IT特训营</span>--%>
                <%--<span>葡萄藤轻游戏     桌游精灵</span>--%>
            <%--</div>--%>
            <%--<div class="text-right col-sm-4">--%>
                <%--<p>微信公众号</p>--%>
                <%--<img src="/statics/image/task11/2524.jpg">--%>
            <%--</div>--%>
        <%--</div>--%>

    <%--</div>--%>

    <%--<div class="footer-bottom">--%>
        <%--Copyright &copy; 2015技能树 www.jnshu.com  All Rights Reserved | 京ICP--%>
    <%--</div>--%>
<%--</footer>--%>

</body>
<tiles:insertDefinition name="task4-footer" />
</html>