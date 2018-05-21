<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: yyj
  Date: 2017/12/27
  Time: 20:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1, user-scalable=no">
    <script src="${pageContext.request.contextPath}/t8/js/jquery-3.2.1.min.js"></script>
    <link href="${pageContext.request.contextPath}/t8/css/bootstrap.min.css" rel="stylesheet">
    <script src="${pageContext.request.contextPath}/t8/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/t8/css/jnshu.css">
    <title>技能树</title>
</head>

<body>
<header><tiles:insertAttribute name="head"/>
</header>
<!-- 轮播模块 -->
<div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
    <!-- 原点计数 -->
    <ol class="carousel-indicators margin-bottom-0 ">
        <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
        <li data-target="#carousel-example-generic" data-slide-to="1"></li>
        <li data-target="#carousel-example-generic" data-slide-to="2"></li>
        <li data-target="#carousel-example-generic" data-slide-to="3"></li>
    </ol>
    <!-- 轮播图片 -->
    <div class="carousel-inner" role="listbox">
        <div class="item active">
            <a href="" class="">
                <img src="${pageContext.request.contextPath}/t8/img/carousel-inner-1.jpg">
            </a>
        </div>
        <div class="item">
            <a href="" class="">
                <img src="${pageContext.request.contextPath}/t8/img/carousel-inner-2.jpg">
            </a>
        </div>
        <div class="item">
            <a href="" class="">
                <img src="${pageContext.request.contextPath}/t8/img/carousel-inner-3.jpg">
            </a>
        </div>
        <div class="item">
            <a href="" class="">
                <img src="${pageContext.request.contextPath}/t8/img/carousel-inner-4.jpg">
            </a>
        </div>
    </div>
    <!-- 左右箭头控制 -->
    <a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
        <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
    </a>
    <a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
        <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
    </a>
</div>
<!-- 图标 -->
<div class="img-wrap">
    <div class="container">
        <div class="row">
            <div class="col-xs-12 col-md-3">
                <div class="img-contain effective">
                    <p>高效</p>
                    <span>将五到七年的成长时间，缩短到一年到三年。
						</span>
                </div>
            </div>
            <div class="col-xs-12 col-md-3">
                <div class="img-contain ruler">
                    <p>规范</p>
                    <span>标准的实战教程，不会走弯路
						</span>
                </div>
            </div>
            <div class="col-xs-12 col-md-3">
                <div class="img-contain relation">
                    <p>人脉</p>
                    <span>同班好友，同院学长，技术大师， 入学就混入职脉圈，为以后铺平道路。
						</span>
                </div>
            </div>
            <div class="col-xs-12 col-md-3">
                <div class="count">
                    <p>${count}</p>
                    <span>累计在线学习人数</span>
                    <p>${countGood}</p>
                    <span>学员已经找到满意工作</span>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- 学习路径 -->
<div class="container study-path">
    <div class="row">
        <div class="col-xs-12 col-md-12 text-center title">如何学习</div>
        <div class="col-xs-12 col-md-3 path-step">
            <span class="number">1</span>
            <span class="path-contain">匹配你现在的个人情况,寻找适合自己的岗位</span>
            <sapn class="next"></sapn>
        </div>
        <div class="col-xs-12 col-md-3 path-step">
            <span class="number">2</span>
            <span class="path-contain">了解职业前景薪金待遇、竞争压力等</span>
            <sapn class="next"></sapn>
        </div>
        <div class="col-xs-12 col-md-3 path-step">
            <span class="number">3</span>
            <span class="path-contain">掌握行业内顶级技能</span>
            <sapn class="next"></sapn>
        </div>
        <div class="col-xs-12 col-md-3 path-step">
            <span class="number">4</span>
            <span class="path-contain">查看职业目标任务</span>
            <sapn class="next"></sapn>
        </div>
        <div class="col-xs-12 col-md-3 path-step">
            <span class="number">5</span>
            <span class="path-contain">参考学习资源，掌握技能点，逐个完成任务</span>
            <sapn class="next"></sapn>
        </div>
        <div class="col-xs-12 col-md-3 path-step">
            <span class="number">6</span>
            <span class="path-contain">加入班级，和小伙伴们互帮互助，一块学习</span>
            <sapn class="next"></sapn>
        </div>
        <div class="col-xs-12 col-md-3 path-step">
            <span class="number">7</span>
            <span class="path-contain">选择导师，一路引导，加速自己成长</span>
            <sapn class="next"></sapn>
        </div>
        <div class="col-xs-12 col-md-3 path-step">
            <span class="number">8</span>
            <span class="path-contain">完成职业技能，升级业界大牛</span>
            <sapn class="next"></sapn>
        </div>
    </div>
</div>
<!-- 优秀学员展示 -->
<div class="container student-list">
    <div class="text-center title">优秀学员展示</div>
<c:forEach items="${list}" var="l">
    <!-- 优秀学员 -->
    <div class="row">
        <div class="col-xs-12 col-md-3">
            <div class="student">
                <img src=${l.head} alt="头像">
                <p class="name">${l.job}：${l.name}</p>
                <span class="career">
						${l.intro}
					</span>
            </div>
        </div>
        </c:forEach>
    <!-- 切换圆点 -->
    <ul class="dot text-center">
        <li class="active"></li>
        <li></li>
        <li></li>
        <li></li>
    </ul>
</div>
<!-- 合作企业图标 -->
<div class="container hidden-xs text-center company-list">
    <div class="title">
        战略合作企业
    </div>
    <div class="row">
        <a href="" class="company-alibaba">
        </a><a href="" class="company-jinshanyun">
    </a><a href="" class="company-huanxin">
    </a><a href="" class="company-ronglian"></a><a href="" class="company-qiniu"></a>
    </div>
</div>
<!-- 友情链接 -->
<div class="link hidden-xs">
    <div class="container">
        <div class="text-center title">
            友情链接
        </div>
        <div class="text-center row">
            <ul>
                <li><a href="">手机软件</a></li>
                <li><a href="">教师招聘</a></li>
                <li><a href="">找工作</a></li>
                <li><a href="">教师招聘</a></li>
                <li><a href="">找工作</a></li>
                <li><a href="">手机软件</a></li>
                <li><a href="">教师招聘</a></li>
                <li><a href="">找工作</a></li>
                <li><a href="">教师招聘</a></li>
                <li><a href="">找工作</a></li>
                <li><a href="">手机软件</a></li>
                <li><a href="">教师招聘</a></li>
                <li><a href="">找工作</a></li>
                <li><a href="">教师招聘</a></li>
                <li><a href="">找工作</a></li>
                <li><a href="">手机软件</a></li>
                <li><a href="">教师招聘</a></li>
                <li><a href="">找工作</a></li>
                <li><a href="">教师招聘</a></li>
                <li><a href="">找工作</a></li>
            </ul>
        </div>
    </div>
</div>
<footer><tiles:insertAttribute name="tail"/>
</footer>
</body>
</html>
