<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@page contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="/tags" prefix="date"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width initial-scale=1.0 maximum-scale=1.0 user-scalable=0">
    <meta name="format-detection" content="telephone=no">
    <title>首页</title>
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="/css/base.css">
    <link rel="stylesheet" href="/css/task-91.css">
    <script src="https://cdn.bootcss.com/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>

<body>
<!-- 头部 -->
<%--<date:date value ="${time}"/>--%>
<!-- banner部分 -->
<div id="myCarousel" class="carousel slide">
    <!-- 轮播（Carousel）指标 -->
    <ol class="carousel-indicators">
        <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
        <li data-target="#myCarousel" data-slide-to="1"></li>
        <li data-target="#myCarousel" data-slide-to="2"></li>
    </ol>
    <!-- 轮播（Carousel）项目 -->
    <div class="carousel-inner">
        <div class="item active">
            <img src="images/banner.png" alt="First slide">
        </div>
        <div class="item">
            <img src="images/banner.png" alt="Second slide">
        </div>
        <div class="item">
            <img src="images/banner.png" alt="Third slide">
        </div>
    </div>
    <!-- 轮播（Carousel）导航 -->
    <a class="carousel-control left" href="#myCarousel" data-slide="prev"> <span _ngcontent-c3="" aria-hidden="true"
                                                                                 class="glyphicon glyphicon-chevron-left"></span></a>
    <a class="carousel-control right" href="#myCarousel" data-slide="next"><span _ngcontent-c3="" aria-hidden="true"
                                                                                 class="glyphicon glyphicon-chevron-right"></span></a>
</div>
<!-- 中间第一部分 -->
<div class="section1 w">
    <div class="left">
        <div class="row">
            <div class="mock col-xs-12 col-sm-12 col-md-3">
                <div class="image">
                    <img class="gx" src="images/rocket.png" alt="">
                </div>
                <p>高效</p>
                <span class="txt">将五到七年的成长时间，缩短到一年到三年。</span>
            </div>
            <div class="mock col-xs-12 col-sm-12 col-md-3">
                <div class="image">
                    <img class="gf" src="images/archive.png" alt="">
                </div>
                <p>规范</p>
                <span>标准的实战教程，不会走弯路 </span>
            </div>
            <div class="mock col-xs-12 col-sm-12 col-md-3">
                <div class="image">
                    <img class="rm" src="images/Shape.png" alt="">
                </div>
                <p>人脉</p>
                <span>同班好友，同院学长，技术大师，入学就混入职脉圈，为以后铺平道路。</span>
            </div>
        </div>
    </div>
    <div class="right hidden-sm hidden-xs">
        <div class="content">
            <div class="num">
                <img src="images/user.jpg" alt=""> <span>${count}</span>
                <p>累计在线学习人数</p>
            </div>

            <div class="num">
                <img src="images/user.jpg" alt=""> <span>${number}</span>
                <p>累计结业人数</p>
            </div>
        </div>
    </div>
</div>
<!-- 中间第二部分 -->
<div class="section2 w hidden-sm hidden-xs">
    <p>如何学习</p>
    <div class="list">
        <div class="step">
            <div class="circle">
                <div class="num">1</div>
            </div>
            <span class="txt">匹配你现在的个人情况，寻找适合的岗位</span>
        </div>
        <img src="images/arrow.png" alt="">
        <div class="step">
            <div class="circle">
                <div class="num">2</div>
            </div>
            <span class="txt">了解职业前景薪金待遇、竞争压力等</span>
        </div>
        <img src="images/arrow.png" alt="">
        <div class="step">
            <div class="circle">
                <div class="num">3</div>
            </div>
            <span class="txt">掌握行内顶级技能</span>
        </div>
        <img src="images/arrow.png" alt="">
        <div class="step">
            <div class="circle">
                <div class="num">4</div>
            </div>
            <span class="txt">查看职业目标任务</span>
        </div>
    </div>
    <div class="list">
        <div class="step">
            <div class="circle">
                <div class="num">5</div>
            </div>
            <span class="txt">参考学习资源，掌握技能点，逐个完成任务</span>
        </div>
        <img src="images/arrow.png" alt="">
        <div class="step">
            <div class="circle">
                <div class="num">6</div>
            </div>
            <span class="txt">加入班级，和小伙伴们互帮互助，一块学习</span>
        </div>
        <img src="images/arrow.png" alt="">
        <div class="step">
            <div class="circle">
                <div class="num">7</div>
            </div>
            <span class="txt">选择导师，一路引导,加速自己成长</span>
        </div>
        <img src="images/arrow.png" alt="">
        <div class="step">
            <div class="circle">
                <div class="num">8</div>
            </div>
            <span class="txt">完成职业技能，升级业界大牛</span>
        </div>
    </div>
</div>
<!-- 中间第三部分 -->

<div class="section3 w container">
    <p>优秀学员显示</p>
    <div class="row xueyuan">
        <c:if test="${list!= null || fn:length(list) != 0}">
            <c:forEach items="${list}" var="student" begin="0" end="${fn:length(list) }">
                <div class="people col-xs-12 col-sm-12 col-md-3">
                    <div class="touxiang">
                        <img src=${student.icon} alt="">
                    </div>
                    <p class="intro">${student.position}：${student.name}</p>
                    <span>${student.overview}</span>
                    <div>
                        <span>入学时间:<date:date value ="${student.entrance_time}"/></span>
                    </div>

                </div>
            </c:forEach>
        </c:if>
    </div>

    <div class="dot hidden-sm hidden-xs">
        <ol>
            <li class="active"></li>
            <li></li>
            <li></li>
            <li></li>
        </ol>
    </div>
</div>

<!-- 中间第四部分 -->
<div class="section4 w container">
    <p><a href="task-92.jsp">战略合作企业</a></p>
    <ul class="com row">
        <li class="col-xs-12 col-sm-12 col-md-2"> <img class="i1" src="images/alibaba.jpg" alt=""></li>
        <li class="col-xs-12 col-sm-12 col-md-2"><img style="width:2rem" src="images/jsy.jpg" alt=""></li>
        <li class="col-xs-12 col-sm-12 col-md-2"><img src="images/hx.jpg" alt=""></li>
        <li class="col-xs-12 col-sm-12 col-md-2"> <img class="i1" src="images/rl.jpg" alt=""></li>
        <li class="col-xs-12 col-sm-12 col-md-2"> <img src="images/7n.jpg" alt=""></li>
    </ul>
</div>
<!-- 中间第五部分 -->
<div class="section5  hidden-sm hidden-xs">
    <p>友情链接</p>
    <ul class="w">
        <li><span></span><a href="">手机软件</a></li>
        <li><span></span><a href="">教师招聘</a></li>
        <li><span></span><a href="">找工作</a></li>
        <li><span></span><a href="">手机软件</a></li>
        <li><span></span><a href="">教师招聘</a></li>
        <li><span></span><a href="">找工作</a></li>
        <li><span></span><a href="">手机软件</a></li>
        <li><span></span><a href="">教师招聘</a></li>
        <li><span></span><a href="">找工作</a></li>
        <li><span></span><a href="">找工作</a></li>
    </ul>
    <ul>
        <li><a href="">手机软件</a></li>
        <li><a href="">教师招聘</a></li>
        <li><a href="">找工作</a></li>
        <li><a href="">手机软件</a></li>
        <li><a href="">教师招聘</a></li>
        <li><a href="">找工作</a></li>
        <li><a href="">手机软件</a></li>
        <li><a href="">教师招聘</a></li>
        <li><a href="">找工作</a></li>
        <li><a href="">找工作</a></li>
    </ul>
</div>
<!-- 脚部 -->

</body>

</html>