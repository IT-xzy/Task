<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@page contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0;">
    <meta name="format-detection" content="telephone=no">
    <title>职位</title>
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="../../css/base.css">
    <link rel="stylesheet" href="../../css/task-93.css">
    <script src="https://cdn.bootcss.com/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>

<body>
    <!-- 头部 -->
    <%--<header>--%>
        <%--<div class="top w">--%>
            <%--<div class="num">客服热线：010-594-78634</div>--%>
            <%--<div class="logos">--%>
                <%--<img src="images/wx.png" alt="">--%>
                <%--<img src="images/qq.png" alt="">--%>
                <%--<img src="images/xl.jpg" alt="">--%>
            <%--</div>--%>
        <%--</div>--%>
        <%--<div class="top1">--%>
            <%--登陆&nbsp<span>|</span>&nbsp注册--%>
        <%--</div>--%>
        <%--<nav>--%>
            <%--<ul class=" nav1 w">--%>
                <%--<img src="images/logo.png" alt="">--%>
                <%--<li><a href="/home">首页</a></li>--%>
                <%--<li><a href="/profession">职业</a></li>--%>
                <%--<li><a href="task-92.jsp">推荐</a></li>--%>
                <%--<li><a href="">关于</a></li>--%>
            <%--</ul>--%>
            <%--<div class="dropdown">--%>
                <%--<img class="ji" src="images/logo.png" alt="">--%>
                <%--<button class="btn dropdown-toggle clearfix" type="button" id="dropdownMenu1" data-toggle="dropdown"--%>
                    <%--aria-haspopup="true" aria-expanded="true">--%>
                    <%--<span>--%>
                        <%--<img src="images/btn1.png" alt="">--%>
                    <%--</span>--%>
                <%--</button>--%>
                <%--<ul class="dropdown-menu" aria-labelledby="dropdownMenu1">--%>
                    <%--<li><a href="task-91.jsp">首页</a></li>--%>
                    <%--<li><a href="task-93.jsp">职业</a></li>--%>
                    <%--<li><a href="task-92.jsp">推荐</a></li>--%>
                    <%--<li><a href="#">关于</a></li>--%>
                <%--</ul>--%>
            <%--</div>--%>
        <%--</nav>--%>
    <%--</header>--%>

    <div class="container">

        <div class="title w">
            <span class="txt1">首页></span>
            <span class="txt2">职位</span>
        </div>

        <div class="fx w">
            <span class="tt">方向：</span>
            <span class="active">全部</span>
            <span>前端开发</span>
            <span>后端开发</span>
            <span>整站开发</span>
            <span>移动开发</span>
            <span>运营维护</span>
        </div>

    </div>
    <!-- 内容部分 -->
    <div class="container">
        <div class="contain w">
            <div class="section1 w row">
                <div class="head col-md-12 col-sm-12 col-xs-12">前端开发方向</div>
                <div class="content">
                    <c:if test="${list!= null || fn:length(list) != 0}">
                    <c:forEach items="${list}" var="p" begin="0" end="${fn:length(list) }">
                    <div class="people col-md-4 col-sm-12 col-xs-12">
                        <div class="first">
                            <img src="images/tx1.jpg" alt="">
                            <div class="txt">
                                <p>${p.name}工程师</p>
                                <span>${p.overview}
                                </span>
                            </div>
                        </div>
                        <div class="sec">
                            <div class="menk">门槛
                                <c:forEach begin="1" end="${p.threshold}">
                                <img src="images/star.png" alt="">
                                </c:forEach>
                            </div>
                            <div class="nan">难易程度
                        <c:forEach begin="1" end="${p.complexity}">
                                <img src="images/star.png" alt="">
                        </c:forEach>
                            </div>
                        </div>
                        <div class="sec">
                            <div class="menk">成长周期：
                                <span><i>${p.growth_cycle}</i>年</span>
                            </div>
                            <div class="nan">稀缺程度：
                                <span><i>${p.need}</i>公司需要</span>
                            </div>
                        </div>
                        <div class="third">
                            <div class="l">薪资待遇</div>
                            <ul class="r">
                                <li class="line">0-1年<span>${p.salary1}</span></li>
                                <li class="line">1-3年<span>${p.salary2}</span></li>
                                <li>3-5年<span>${p.salary3}</span></li>
                            </ul>
                        </div>
                        <div class="four">
                            有<i>${java}</i>人正在学习
                        </div>
                        <div class="five">
                            ${p.hint}
                        </div>

                        <div class="mask">
                            <p>${p.name}工程师</p>
                            <span>${p.tc}</span>
                        </div>
                    </div>
                    </c:forEach>
                    </c:if>

                </div>
                <div class="head col-md-12 col-sm-12 col-xs-12">后端开发方向</div>
                <div class="content">
                    <c:if test="${list1!= null || fn:length(list1) != 0}">
                    <c:forEach items="${list1}" var="pp" begin="0" end="${fn:length(list1) }">
                    <div class="people col-md-4 col-sm-12 col-xs-12">
                        <div class="first">
                            <img src="images/tx1.jpg" alt="">
                            <div class="txt">
                                <p>${pp.name}工程师</p>
                                <span>${pp.overview}
                                </span>
                            </div>
                        </div>
                        <div class="sec">
                            <div class="menk">门槛
                                <c:forEach begin="1" end="${pp.threshold}">
                                    <img src="images/star.png" alt="">
                                </c:forEach>
                            </div>
                            <div class="nan">难易程度
                                <c:forEach begin="1" end="${pp.complexity}">
                                    <img src="images/star.png" alt="">
                                </c:forEach>
                            </div>
                        </div>
                        <div class="sec">
                            <div class="menk">成长周期：
                                <span><i>${pp.growth_cycle}</i>年</span>
                            </div>
                            <div class="nan">稀缺程度：
                                <span><i>${pp.need}</i>公司需要</span>
                            </div>
                        </div>
                        <div class="third">
                            <div class="l">薪资待遇</div>
                            <ul class="r">
                                <li class="line">0-1年<span>${pp.salary1}</span></li>
                                <li class="line">1-3年<span>${pp.salary2}</span></li>
                                <li>3-5年<span>${pp.salary3}</span></li>
                            </ul>
                        </div>
                        <div class="four">
                            有<i>235</i>人正在学习
                        </div>
                        <div class="five">
                            ${pp.hint}
                        </div>
                        <div class="mask">
                            <p>${pp.name}工程师</p>
                            <span>${pp.tc}</span>
                        </div>
                    </div>
                    </c:forEach>
                    </c:if>

                </div>
                <div class="head col-md-12 col-sm-12 col-xs-12">运维方向</div>
                <div class="content">
                    <c:if test="${list2!= null || fn:length(list2) != 0}">
                    <c:forEach items="${list2}" var="pp" begin="0" end="${fn:length(list2) }">
                    <div class="people col-md-4 col-sm-12 col-xs-12">
                        <div class="first">
                            <img src="images/tx1.jpg" alt="">
                            <div class="txt">
                                <p>${pp.name}工程师</p>
                                <span>${pp.overview}
                                </span>
                            </div>
                        </div>
                        <div class="sec">
                            <div class="menk">门槛
                                <c:forEach begin="1" end="${pp.threshold}">
                                    <img src="images/star.png" alt="">
                                </c:forEach>
                            </div>
                            <div class="nan">难易程度
                                <c:forEach begin="1" end="${pp.complexity}">
                                    <img src="images/star.png" alt="">
                                </c:forEach>
                            </div>
                        </div>
                        <div class="sec">
                            <div class="menk">成长周期：
                                <span><i>${pp.growth_cycle}</i>年</span>
                            </div>
                            <div class="nan">稀缺程度：
                                <span><i>${pp.need}</i>公司需要</span>
                            </div>
                        </div>
                        <div class="third">
                            <div class="l">薪资待遇</div>
                            <ul class="r">
                                <li class="line">0-1年<span>${pp.salary1}</span></li>
                                <li class="line">1-3年<span>${pp.salary2}</span></li>
                                <li>3-5年<span>${pp.salary3}</span></li>
                            </ul>
                        </div>
                        <div class="four">
                            有<i>235</i>人正在学习
                        </div>
                        <div class="five">
                            提示:在你学习之前你应该已经掌握XXXXX、XXXXX、XX等语言基础
                        </div>
                        <div class="mask">
                            <p>${pp.name}工程师</p>
                            <span>${pp.tc}</span>
                        </div>
                    </div>
                    </c:forEach>
                    </c:if>

                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- 脚部 -->
    <%--<footer>--%>
        <%--<div class="box">--%>
            <%--<div class="top w">--%>
                <%--<div class="container">--%>
                    <%--<div class="row">--%>
                        <%--<div class="first col-xs-12 col-md-4">--%>
                            <%--<div class="up">技能树&nbsp——&nbsp改变你我</div>--%>
                            <%--<div class="down">--%>
                                <%--<a href="">关于我们</a>&nbsp|&nbsp--%>
                                <%--<a href="">联系我们</a>&nbsp|&nbsp--%>
                                <%--<a href="">合作企业</a>--%>
                            <%--</div>--%>
                        <%--</div>--%>
                        <%--<div class="second col-xs-12 col-md-5">--%>
                            <%--<div class="up">旗下网站</div>--%>
                            <%--<div class="down">--%>
                                <%--<p>--%>
                                    <%--<a href="">草船云孵化器</a>&#12288--%>
                                    <%--<a href="">最强IT特训营</a>--%>
                                <%--</p>--%>
                                <%--<p>--%>
                                    <%--<a href="">葡萄藤轻游戏</a>&#12288--%>
                                    <%--<a href="">桌游游戏</a>--%>
                                <%--</p>--%>
                            <%--</div>--%>
                        <%--</div>--%>
                        <%--<div class="third col-xs-12 col-md-3">--%>
                            <%--<p>微信公众号</p>--%>
                            <%--<img src="images/qcode.jpg" alt="">--%>
                        <%--</div>--%>
                    <%--</div>--%>
                <%--</div>--%>

            <%--</div>--%>
        <%--</div>--%>
        <%--<div class="">--%>
            <%--<div class="bottom w">--%>
                <%--Copyright © 2015技能树 www.jnshu.com All Rights Reserved <span>|</span>京ICP备--%>
            <%--</div>--%>
        <%--</div>--%>

    <%--</footer>--%>
</body>

</html>