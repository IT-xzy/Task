<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Title</title>
    <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <link href="/static/css/task8.1.css" type="text/css" rel="stylesheet"/>
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>

<div id="myCarousel" class="carousel slide">
    <!-- 轮播（Carousel）指标 -->
    <ol class="carousel-indicators">
        <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
        <li data-target="#myCarousel" data-slide-to="1"></li>
        <li data-target="#myCarousel" data-slide-to="2"></li>
        <li data-target="#myCarousel" data-slide-to="3"></li>
        <li data-target="#myCarousel" data-slide-to="4"></li>
    </ol>
    <!-- 轮播（Carousel）项目 -->
    <div class="carousel-inner">
        <div class="item active">
            <img src="${pageContext.request.contextPath}/static/image/headimg1.png" alt="First slide">
        </div>
        <div class="item">
            <img src="${pageContext.request.contextPath}/static/image/headimg2.png" alt="Second slide">
        </div>
        <div class="item">
            <img src="${pageContext.request.contextPath}/static/image/headimg3.png" alt="Third slide">
        </div>
        <div class="item">
            <img src="${pageContext.request.contextPath}/static/image/headimg4.jpg" alt="Third slide">
        </div>
        <div class="item">
            <img src="${pageContext.request.contextPath}/static/image/headimg5.jpeg" alt="Third slide">
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

<main>
    <div class="container main-div">
        <div class="row">
            <div class="col-xs-12 col-sm-6 col-md-3 main-box1">
                <div class="main-icobox">
                    <div class="main-ico1"></div>
                </div>
                <div class="mian-text11box"><span class="mian-text11">高效</span></div>
                <div class="mian-text13box"><span class="mian-text13">将五到七年的成长时间，缩短到一年到三年</span></div>
            </div>
            <div class="col-xs-12 col-sm-6 col-md-3 main-box1">
                <div class="main-icobox">
                    <div class="main-ico2"></div>
                </div>
                <div class="mian-text11box"><span class="mian-text11">规范</span></div>
                <div class="mian-text13box"><span class="mian-text13">标准的实战教程，不会走弯路</span><span
                        style="visibility:hidden;">标准的实战教程，不会走弯路</span></div>
            </div>
            <div class="col-xs-12 col-sm-6 col-md-3 main-box1">
                <div class="main-icobox">
                    <div class="main-ico3"></div>
                </div>
                <div class="mian-text11box"><span class="mian-text11">人脉</span></div>
                <div class="mian-text13box"><span class="mian-text13">同班好友，同院学长，技术大师，入学就混入职脉圈，为以后铺平道路。</span></div>
            </div>
            <div class="col-xs-12 col-sm-6 col-md-3 main-box1 main-box12">
                <div>
                    <div class="main-box11">
                        <div class="main-ico4"></div>
                        <span class="mian-text12">12400</span>
                    </div>
                    <div class="mian-text13box"><span class="mian-text13">累计在线学习人数</span></div>
                    <div class="main-box11">
                        <div class="main-ico4"></div>
                        <span class="mian-text12">12499</span>
                    </div>
                    <div class="mian-text13box"><span class="mian-text13">累计已经找到满意工作</span></div>
                </div>
            </div>
        </div>
    </div>

    <div class="main-headline1box main-div"><span class="main-headline1">如何学习</span></div>
    <div class="container">
        <div class="row">
            <div class="col-xs-12 col-sm-6 col-md-3 main2-box">
                <div class="circle-box"><span class="main2-text2">1</span></div>
                <div class="main2-text1box"><span class="main2-text1">匹配你现在的个人情况寻找适合自己的岗位</span></div>
                <div class="main2-ico5 main-hidden"></div>
            </div>
            <div class="col-xs-12 col-sm-6 col-md-3 main2-box">
                <div class="circle-box"><span class="main2-text2">2</span></div>
                <div class="main2-text1box"><span class="main2-text1">了解职业前景薪金待遇、竞争压力等</span></div>
                <div class="main2-ico5 main-hidden main-hidden2"></div>
            </div>
            <div class="col-xs-12 col-sm-6 col-md-3 main2-box">
                <div class="circle-box"><span class="main2-text2">3</span></div>
                <div class="main2-text1box"><span class="main2-text1">掌握行业内顶级技能</span></div>
                <div class="main2-ico5 main-hidden"></div>
            </div>
            <div class="col-xs-12 col-sm-6 col-md-3 main2-box">
                <div class="circle-box"><span class="main2-text2">4</span></div>
                <div class="main2-text1box"><span class="main2-text1">查看职业目标任务</span></div>
                <div class="main2-ico5 main-hidden main-hidden2 main-hidden3"></div>
            </div>
        </div>
        <div class="row">
            <div class="col-xs-12 col-sm-6 col-md-3 main2-box">
                <div class="circle-box"><span class="main2-text2">5</span></div>
                <div class="main2-text1box"><span class="main2-text1">参考学习资源，掌握技能点，逐个完成任务</span></div>
                <div class="main2-ico5 main-hidden"></div>
            </div>
            <div class="col-xs-12 col-sm-6 col-md-3 main2-box">
                <div class="circle-box"><span class="main2-text2">6</span></div>
                <div class="main2-text1box"><span class="main2-text1">加入班级，和小伙伴们互帮互助，一块学习</span></div>
                <div class="main2-ico5 main-hidden main-hidden2"></div>
            </div>
            <div class="col-xs-12 col-sm-6 col-md-3 main2-box">
                <div class="circle-box"><span class="main2-text2">7</span></div>
                <div class="main2-text1box"><span class="main2-text1">选择导师，一路引导加速自己成长</span></div>
                <div class="main2-ico5 main-hidden"></div>
            </div>
            <div class="col-xs-12 col-sm-6 col-md-3 main2-box">
                <div class="circle-box"><span class="main2-text2">8</span></div>
                <div class="main2-text1box"><span class="main2-text1">完成职业技能，升级业界大牛</span></div>
                <div class="main2-ico5 main-hidden main-hidden2 main-hidden3"></div>
            </div>
        </div>
    </div>
    

    <div class="main-headline1box main-div"><span class="main-headline1">优秀学员展示</span></div>
    <div class="container">
        <div class="row">
            <c:forEach var="student" items="${students}">
                <div class="col-xs-12 col-sm-6 col-md-3 main3-center">
                    <div class="main3-box">
                        <div class="main3-photo1"></div>
                        <div class="main3-text1box"><span class="main3-text1">技术顾问：${student.name}</span></div>
                        <div class="main3-text2box"><span class="main3-text2">${student.position}：${student.introduction}</span>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>
    <div class="main-headline1box main-div"><span class="main-headline1">战略合作企业</span></div>
    <div class="container main4-div">
        <div class="row">
            <div class="col-xs-12  col-sm-12 col-md-5 main4-box">
                <div class="main4-icobox">
                    <div class="main4-ico1 main4-clearhover"></div>
                </div>
            </div>
            <div class="col-xs-12  col-sm-12 col-md-5 main4-box">
                <div class="main4-icobox">
                    <div class="main4-ico2 main4-clearhover"></div>
                </div>
            </div>
            <div class="col-xs-12  col-sm-12 col-md-5 main4-box">
                <div class="main4-icobox">
                    <div class="main4-ico3 main4-clearhover"></div>
                </div>
            </div>
            <div class="col-xs-12  col-sm-12 col-md-5 main4-box">
                <div class="main4-icobox">
                    <div class="main4-ico4 main4-clearhover"></div>
                </div>
            </div>
            <div class="col-xs-12  col-sm-12 col-md-5 main4-box">
                <div class="main4-icobox">
                    <div class="main4-ico5 main4-clearhover"></div>
                </div>
            </div>
        </div>
    </div>
    <div class="main-headline1box main-div"><span class="main-headline1">友情链接</span></div>
    <div class="container">
        <div class="row">
            <div class="col-xs-12  col-sm-6 col-md-5 main5-div">
                <div>
                    <ul>
                        <li><a href="#">手机软件</a></li>
                        <li><a href="#">教师招聘</a></li>
                    </ul>
                </div>
            </div>
            <div class="col-xs-12  col-sm-6 col-md-5 main5-div">
                <div>
                    <ul>
                        <li><a href="#">手机软件</a></li>
                        <li><a href="#">教师招聘</a></li>
                    </ul>
                </div>
            </div>
            <div class="col-xs-12  col-sm-6 col-md-5 main5-div">
                <div>
                    <ul>
                        <li><a href="#">手机软件</a></li>
                        <li><a href="#">教师招聘</a></li>
                    </ul>
                </div>
            </div>
            <div class="col-xs-12  col-sm-6 col-md-5 main5-div">
                <div>
                    <ul>
                        <li><a href="#">手机软件</a></li>
                        <li><a href="#">教师招聘</a></li>
                    </ul>
                </div>
            </div>
            <div class="col-xs-12  col-sm-6 col-md-5 main5-div">
                <div>
                    <ul>
                        <li><a href="#">手机软件</a></li>
                        <li><a href="#">教师招聘</a></li>
                    </ul>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-xs-12  col-sm-6 col-md-5 main5-div">
                <div>
                    <ul>
                        <li><a href="#">手机软件</a></li>
                        <li><a href="#">教师招聘</a></li>
                    </ul>
                </div>
            </div>
            <div class="col-xs-12  col-sm-6 col-md-5 main5-div">
                <div>
                    <ul>
                        <li><a href="#">手机软件</a></li>
                        <li><a href="#">教师招聘</a></li>
                    </ul>
                </div>
            </div>
            <div class="col-xs-12  col-sm-6 col-md-5 main5-div">
                <div>
                    <ul>
                        <li><a href="#">手机软件</a></li>
                        <li><a href="#">教师招聘</a></li>
                    </ul>
                </div>
            </div>
            <div class="col-xs-12  col-sm-6 col-md-5 main5-div">
                <div>
                    <ul>
                        <li><a href="#">手机软件</a></li>
                        <li><a href="#">教师招聘</a></li>
                    </ul>
                </div>
            </div>
            <div class="col-xs-12  col-sm-6 col-md-5 main5-div">
                <div>
                    <ul>
                        <li><a href="#">手机软件</a></li>
                        <li><a href="#">教师招聘</a></li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</main>
