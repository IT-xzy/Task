<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isErrorPage="true" isELIgnored="false" %>
<%@taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>
<%@taglib uri="/tags" prefix="date" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en" xmlns="http://www.w3.org/1999/html">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <title>vote</title>
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="css/task8.css"/>
    <script src="https://cdn.bootcss.com/jquery/3.1.1/jquery.min.js"></script>
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

<main>

    <div id="myCarousel" class="carousel slide lunbotu">
        <!-- 轮播（Carousel）指标 -->
        <ol class="carousel-indicators">
            <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
            <li data-target="#myCarousel" data-slide-to="1"></li>
            <li data-target="#myCarousel" data-slide-to="2"></li>
        </ol>
        <!-- 轮播（Carousel）项目 -->
        <div class="carousel-inner">
            <div class="item active">
                <img src="img/Image.jpg" class="imgw" alt="First slide">
            </div>
            <div class="item">
                <img src="img/Image.jpg" class="imgw" alt="Second slide">
            </div>
            <div class="item">
                <img src="img/Image.jpg" class="imgw" alt="Third slide">
            </div>
        </div>
        <!-- 轮播（Carousel）导航 -->
        <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
            <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
            <span class="sr-only">Previous</span>
        </a>
        <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
            <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
            <span class="sr-only">Next</span>
        </a>
    </div>

    <div class="container ct1">
        <div class="row advantage">
            <div class="col-xs-12 col-md-6 col-lg-3">
                <div class="wearegood">
                    <span class="rocket"></span>
                    <p>高效</p>
                    <span class="f2">将五到七年的成长时间，缩短到一年到三年。</span>
                </div>
            </div>
            <div class="col-xs-12 col-md-6 col-lg-3">
                <div class="wearegood1">
                    <span class="archive"></span>
                    <p>规范</p>
                    <span class="f2">标准的路程，不会走弯路</span>
                </div>
            </div>
            <div class="col-xs-12 col-md-6 col-lg-3">
                <div class="wearegood">
                    <span class="regulation"></span>
                    <p>人脉</p>
                    <span class="f2">同班同学，同院学长，技术大师，入学就混入职业圈，为以后铺平道路</span>
                </div>
            </div>
            <div class="col-xs-12 col-md-6 col-lg-3">
                <div class="count">
                    <p><a class="glyphicon glyphicon-user">${i}</a><a class="f3">累计在线学习人数</a></p>
                    <p><a class="glyphicon glyphicon-user">${b}</a><a class="f3">学员已经找到满意工作</a></p>
                </div>
            </div>
        </div>
    </div>
    <h5>如何学习</h5>
    <div class="howtolearn"></div>
    <div class="container">
        <div class="row">
            <div class="col-xs-12 col-md-6 col-lg-3">
                <div class="arrow">
                    <div class="num">
                        <p>1</p>
                    </div>
                    <div>
                        <p>匹配你现在的个人情况 寻找适合自己的岗位</p>
                    </div>
                    <div class="arrow1"></div>
                </div>
            </div>
            <div class="col-xs-12 col-md-6 col-lg-3">
                <div class="arrow">
                    <div class="num">
                        <p>2</p>
                    </div>
                    <div>
                        <p>了解职业前景薪金待遇、 竞争压力等</p>
                    </div>
                    <div class="arrow1"></div>
                </div>
            </div>
            <div class="ccol-xs-12 col-md-6 col-lg-3">
                <div class="arrow">
                    <div class="num">
                        <p>3</p>
                    </div>
                    <div class="zw">
                        <p>掌握行业内顶级技能</p>
                    </div>
                    <div class="arrow1"></div>
                </div>
            </div>
            <div class="col-xs-12 col-md-6 col-lg-3">
                <div class="arrow">
                    <div class="num">
                        <p>4</p>
                    </div>
                    <div class="zw">
                        <p>查看职业目标任务</p>
                    </div>
                    <div class="arrow1"></div>
                </div>
            </div>
        </div>
        <div class="howtolearn1"></div>
        <div class="row">
            <div class="col-xs-12 col-md-6 col-lg-3">
                <div class="arrow">
                    <div class="num">
                        <p>5</p>
                    </div>
                    <div>
                        <p>参考学习资源，掌握 技能点，逐个完成任务</p>
                    </div>
                    <div class="arrow1"></div>
                </div>
            </div>
            <div class="col-xs-12 col-md-6 col-lg-3">
                <div class="arrow">
                    <div class="num">
                        <p>6</p>
                    </div>
                    <div>
                        <p>加入班级，和小伙伴们 互帮互助，一块学习</p>
                    </div>
                    <div class="arrow1"></div>
                </div>
            </div>
            <div class="col-xs-12 col-md-6 col-lg-3">
                <div class="arrow">
                    <div class="num">
                        <p>7</p>
                    </div>
                    <div>
                        <p>选择导师，一路引导， 加速自己成长</p>
                    </div>
                    <div class="arrow1"></div>
                </div>
            </div>
            <div class="col-xs-12 col-md-6 col-lg-3">
                <div class="arrow">
                    <div class="num">
                        <p>8</p>
                    </div>
                    <div class="zw">
                        <p>完成职业技能，升级业界大牛</p>
                    </div>
                    <div class="arrow1"></div>
                </div>
            </div>
        </div>
    </div>

    <div class="show">
        <h5>优秀学员展示</h5>
        <div class="container showone">
            <div class="row">
                <c:forEach items="${peo}" var="p" begin="0" end="3" varStatus="now">
                    <div class="col-md-6 col-lg-3 col-xs-12">
                        <div class="students">
                            <img class="img-circle" src="${p.picture}">
                            <span class="title">技术顾问：${p.name}</span>
                            <div>
                                <p>${p.info}</p>
                                <p>
                                    <date:date value="${p.creatTime}"/>
                                </p>
                            </div>
                        </div>
                    </div>
                </c:forEach>
                <div class="yuanquan">
                    <div class="circle1"></div>
                    <div class="circle"></div>
                    <div class="circle"></div>
                    <div class="circle"></div>
                </div>
            </div>
        </div>
    </div>
    <div class="cooperate"></div>
    <h5>战略合作企业</h5>
    <div class="container">
        <div class="row">
            <div class="col-lg-12 company">
                <span><a><img src="img/alibaba.png"></a></span>
                <span><a><img src="img/jinshan.png"></a></span>
                <span><a><img src="img/huanqiu.png"></a></span>
                <span><a><img src="img/ronglian.png"></a></span>
                <span><a><img src="img/qiniu.png"></a></span>
            </div>
        </div>
    </div>
    <div class="links">
        <h5>友情链接</h5>
        <ul>
            <li><a href="#">手机软件</a></li>
            <li><a href="#">教师招聘</a></li>
            <li><a href="#">工作求职</a></li>
            <li><a href="#">教师招聘</a></li>
            <li><a href="#">手机软件</a></li>
            <li><a href="#">教师招聘</a></li>
            <li><a href="#">工作求职</a></li>
            <li><a href="#">教师招聘</a></li>
            <li><a href="#">教师招聘</a></li>
            <li><a href="#">工作求职</a></li>
        </ul>
        <ul>
            <li><a href="#">手机软件</a></li>
            <li><a href="#">教师招聘</a></li>
            <li><a href="#">工作求职</a></li>
            <li><a href="#">教师招聘</a></li>
            <li><a href="#">手机软件</a></li>
            <li><a href="#">教师招聘</a></li>
            <li><a href="#">工作求职</a></li>
            <li><a href="#">教师招聘</a></li>
            <li><a href="#">教师招聘</a></li>
            <li><a href="#">工作求职</a></li>
        </ul>
    </div>
</main>

</body>
</html>