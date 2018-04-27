<%--
  Created by IntelliJ IDEA.
  User: LL
  Date: 2018/4/15
  Time: 15:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="java.util.*"%>
<%@ taglib uri="/tags" prefix="date"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>无标题文档</title>
    <link href="<%=request.getContextPath()%>/css/bootstrap.min.css" rel="stylesheet" type="text/css">
    <link href="<%=request.getContextPath()%>/css/Untitled-3.css" rel="stylesheet" type="text/css">
    <link href="<%=request.getContextPath()%>/css/Untitled-1base.css" rel="stylesheet" type="text/css">
</head>
<body>
    <%--<div id="myCarousel" class="carousel slide">--%>
        <%--<!-- 轮播（Carousel）指标 -->--%>
        <%--<ol class="carousel-indicators">--%>
            <%--<li data-target="#myCarousel" data-slide-to="0" class="active"></li>--%>
            <%--<li data-target="#myCarousel" data-slide-to="1"></li>--%>
            <%--<li data-target="#myCarousel" data-slide-to="2"></li>--%>
        <%--</ol>--%>
        <!-- 轮播（Carousel）项目 -->
        <%--<div class="carousel-inner">--%>
            <%--<div class="item active">--%>
                <%--<img src="<%=request.getContextPath()%>/image/banner-0.png" alt="First slide">--%>
            <%--</div>--%>
            <%--<div class="item">--%>
                <%--<img src="<%=request.getContextPath()%>/image/banner-1.jpg" alt="Second slide">--%>
            <%--</div>--%>
            <%--<div class="item">--%>
                <%--<img src="<%=request.getContextPath()%>/image/banner-2.jpg" alt="Third slide">--%>
            <%--</div>--%>
        <%--</div>--%>
        <!-- 轮播（Carousel）导航 -->
        <%--<a class="control left2" href="#myCarousel"--%>
           <%--data-slide="prev">&lsaquo;</a>--%>
        <%--<a class="control right2" href="#myCarousel"--%>
           <%--data-slide="next">&rsaquo;</a>--%>
    <%--</div>--%>
<%--</div>--%>
    <%--轮播图--%>
    <div id="myCarousel" class="carousel slide">
        <ol class="carousel-indicators">
            <li class="active" data-slide-to="0" data-target="#myCarousel"></li>
            <li data-slide-to="1" data-target="#myCarousel"></li>
            <li data-slide-to="2" data-target="#myCarousel"></li>
            <li data-slide-to="3" data-target="#myCarousel"></li>
        </ol>
        <div class="carousel-inner">
            <div class="item active">
                <img alt="First slide" src="<%=request.getContextPath()%>/image/banner-0.png">
            </div>
            <div class="item">
                <img alt="Second slide" src="<%=request.getContextPath()%>/image/banner-1.jpg">
            </div>
            <div class="item">
                <img alt="Third slide" src="<%=request.getContextPath()%>/image/banner-2.jpg">
            </div>
            <a data-slide="prev" href="#myCarousel" class="carousel-control left">
                <i class="icon-left"><img src="<%=request.getContextPath()%>/image/54354.png"></i>
            </a>
            <a data-slide="next" href="#myCarousel" class="carousel-control right">
                <i class="icon-right"><img src="<%=request.getContextPath()%>/image/4525424.png"></i>
            </a>
        </div>
    </div>

    <div class="main container">
    <!--第一部分开始-->
    <div class="main-a row">
        <div class="col-xs-12 col-sm-6 col-md-6 col-lg-3">
            <div class="row text-center">
                <ul class="list-unstyled">
                    <li class="col-xs-12 up-1">
                        <img alt="" src="<%=request.getContextPath()%>/image/45354312.png">
                    </li>
                    <li class="up-2 col-xs-12">高效</li>
                    <li class="up-3 col-xs-12">将三到七年的成长时间,缩短到一年到两年</li>
                </ul>
            </div>
        </div>

        <div class="col-xs-12 col-sm-6 col-md-6 col-lg-3">
            <div class="row text-center">
                <ul class="list-unstyled">
                    <li class="col-xs-12 up-1">
                        <img alt="" src="<%=request.getContextPath()%>/image/879789.png">
                    </li>
                    <li class="up-2 col-xs-12">规范</li>
                    <li class="up-3 col-xs-12">标准到实战教程,不会走弯路</li>
                </ul>
            </div>
        </div>

        <div class="col-xs-12 col-sm-6 col-md-6 col-lg-3">
            <div class="row text-center">
                <ul class="list-unstyled">
                    <li class="col-xs-12 up-1">
                        <img alt="" src="<%=request.getContextPath()%>/image/786453654365.png">
                    </li>
                    <li class="up-2 col-xs-12">人脉</li>
                    <li class="up-3 col-xs-12">同班好友,同院学长,技术大师,入学就混职脉圈,为以后铺平道路</li>
                </ul>
            </div>
        </div>

        <div class="col-xs-12 col-sm-6 col-md-6 col-lg-3 text-center">
            <p>
                <img src="<%=request.getContextPath()%>/image/453254312.png">${gtotal}<br>
                <span class="up-3">累计在线学习人数</span>
            </p>
            <p>
                <img src="<%=request.getContextPath()%>/image/453254312.png">${total}<br>
                <span class="up-3">学员已经找到满意工作</span>
            </p>
        </div>
    </div>

    <!--第二部分开始-->
    <div class="main-b row">
        <h3 class="text-center main-tab">如何学习</h3>
        <ul class="how to study">
            <li class="col-xs-12 col-sm-6 col-md-6 col-lg-3">
                <span class="up-1 text-center">1</span>
                <p class="up-2">匹配你现在的个人情况寻找适合自己的岗位</p>
                <span class="up-3"></span>
            </li>
            <li class="col-xs-12 col-sm-6 col-md-6 col-lg-3">
                <span class="up-1 text-center">2</span>
                <p class="up-2">了解职业前景薪金待遇，竞争压力等</p>
                <span class="up-3"></span>
            </li>
            <li class="col-xs-12 col-sm-6 col-md-6 col-lg-3">
                <span class="up-1 text-center">3</span>
                <p class="up-2">掌握行业内顶级技能</p>
                <span class="up-3"></span>
            </li>
            <li class="col-xs-12 col-sm-6 col-md-6 col-lg-3">
                <span class="up-1 text-center">4</span>
                <p class="up-2">查看职业目标任务</p>
                <span class="up-3"></span>
            </li>
            <li class="col-xs-12 col-sm-6 col-md-6 col-lg-3">
                <span class="up-1 text-center">5</span>
                <p class="up-2">参考学习资料，掌握技能点，逐个完成任务</p>
                <span class="up-3"></span>
            </li>
            <li class="col-xs-12 col-sm-6 col-md-6 col-lg-3">
                <span class="up-1 text-center">6</span>
                <p class="up-2">加入班级，和小伙伴们互帮互动，一块学习</p>
                <span class="up-3"></span>
            </li>
            <li class="col-xs-12 col-sm-6 col-md-6 col-lg-3">
                <span class="up-1 text-center">7</span>
                <p class="up-2">选择导师，一路引导，加速自己成长</p>
                <span class="up-3"></span>
            </li>
            <li class="col-xs-12 col-sm-6 col-md-6 col-lg-3">
                <span class="up-1 text-center">8</span>
                <p class="up-2">完成职业 技能，升级业界大牛</p>
                <span class="up-3 invisible"></span>
            </li>
        </ul>
    </div>

    <!--第三部分开始-->
    <div class="main-c row">
        <h3 class="text-center main-tab">优秀学员展示</h3>
        <ul class="list-unstyled text-center">

            <li class="col-xs-12 col-sm-6 col-md-6 col-lg-3">
                <div>
                    <img src="<%=request.getContextPath()%>/image/242424.png">
                    <span>炎帝：萧炎</span>
                    <a href="/u/student/profile/${2}">萧炎</a>
                    <p class="text-left">百度技术总监：互联网基础服务领域，从事虚拟主机，云主机，域名。
                        曾任新网高级技术经理，负责技术研发，团队管理与建设。</p>
                </div>
            </li>
            <li class="col-xs-12 col-sm-6 col-md-6 col-lg-3">
                <div>
                    <img src="<%=request.getContextPath()%>/image/242424.png">
                    <span>雷神：林动</span>
                    <a href="/u/student/profile/${3}">林动</a>
                    <p class="text-left">百度技术总监：互联网基础服务领域，从事虚拟主机，云主机，域名。
                        曾任新网高级技术经理，负责技术研发，团队管理与建设。</p>
                </div>
            </li>
            <li class="col-xs-12 col-sm-6 col-md-6 col-lg-3">
                <div>
                    <img src="<%=request.getContextPath()%>/image/242424.png">
                    <span>主宰：牧尘</span>
                    <a href="/u/student/profile/${4}">牧尘</a>
                    <p class="text-left">百度技术总监：互联网基础服务领域，从事虚拟主机，云主机，域名。
                        曾任新网高级技术经理，负责技术研发，团队管理与建设。</p>
                </div>
            </li>
            <li class="col-xs-12 col-sm-6 col-md-6 col-lg-3">
                <div>
                    <img src="<%=request.getContextPath()%>/image/jiangtaixu.jpg">
                    <span>神王:姜太虚</span>
                    <a href="/u/student/profile/${1}">姜太虚</a>
                    <p class="text-left">百度技术总监：互联网基础服务领域，从事虚拟主机，云主机，域名。
                        曾任新网高级技术经理，负责技术研发，团队管理与建设。</p>
                </div>
            </li>
        </ul>
    </div>

    <!--第四部分开始-->
    <div class="row main-bottom">
        <h3 class="text-center">战略合作企业</h3>
        <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
            <ul class="logo">
                <li>
                    <a href=""><img src="<%=request.getContextPath()%>/image/123132.png"></a>
                </li>
                <li>
                    <a href=""> <img src="<%=request.getContextPath()%>/image/1549865.png"></a>
                </li>
                <li>
                    <a href=""> <img src="<%=request.getContextPath()%>/image/785345.png"></a>
                </li>
                <li>
                    <a href=""> <img src="<%=request.getContextPath()%>/image/1471.png"></a>
                </li>
                <li>
                    <a href="">  <img src="<%=request.getContextPath()%>/image/7861.png"></a>
                </li>
            </ul>
        </div>
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
</body>
</html>
