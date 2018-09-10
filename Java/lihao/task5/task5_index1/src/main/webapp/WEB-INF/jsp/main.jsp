<%--
  Created by IntelliJ IDEA.
  User: lihoo
  Date: 2018/8/22
  Time: 17:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"
         pageEncoding="UTF-8" import="java.util.*" isELIgnored="false" %>

<%@ include file="../includes/includes.jsp" %>



<main>
    <!--轮播图——bootstrap实现-->


    <div id="myCarousel" class="carousel slide">

        <%--<img src="${pageContext.request.contextPath}/fonts/glyphicons-halflings-regular.svg" />--%>
        <!-- 轮播（Carousel）指标 -->
        <ol class="carousel-indicators">
            <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
            <li data-target="#myCarousel" data-slide-to="1"></li>
            <li data-target="#myCarousel" data-slide-to="2"></li>
        </ol>
        <!-- 轮播（Carousel）项目 -->
        <div class="carousel-inner">
            <div class="item active">
                <img src="${pageContext.request.contextPath}/img/banner-0.png" alt="First slide">
            </div>
            <div class="item">
                <img src="${pageContext.request.contextPath}/img/banner-1.jpg" alt="Second slide">
            </div>
            <div class="item">
                <img src="${pageContext.request.contextPath}/img/banner-2.jpg" alt="Third slide">
            </div>
        </div>
        <!-- 轮播（Carousel）导航 -->
        <a class="carousel-control left" href="#myCarousel" role="button"
           data-slide="prev">
            <span class="glyphicon glyphicon-chevron-left"></span>
        </a>
        <a class="carousel-control right" href="#myCarousel" role="button"
           data-slide="next">
            <span class="glyphicon glyphicon-chevron-right"></span>
        </a>
    </div>
    <!--网站优势-->
    <div class="main-advantage container">
        <ul class=" main-advantage-items row list-style">
            <li class="col-lg-3 col-md-6 col-xs-12 main-adv-div">
                <div class="icon"><img src="${pageContext.request.contextPath}/img/rocket.png" alt=""></div>
                <h2>高效</h2>
                <span>将五到七年的成长时间，缩短到一到三年。</span>
            </li>
            <li class="col-lg-3 col-md-6 col-xs-12 main-adv-div">
                <div class="icon_1"><img src="${pageContext.request.contextPath}/img/book.png" alt=""></div>
                <h2>规范</h2>
                <span>标准的实战教程，不会走弯路</span>
            </li>
            <li class="col-lg-3 col-md-6 col-xs-12 main-adv-div">
                <div class="icon_2"><img src="${pageContext.request.contextPath}/img/relation.png" alt=""></div>
                <h2>人脉</h2>
                <span>同班好友，同院学长，技术大师，入学就混入职脉圈，为以后铺平道路。</span>
            </li>
            <li class="col-lg-3 col-md-6 col-xs-12 main-adv-div body_count">
                <div class="study-icon">
                    <%--<span style="content:url(/img/user.png);"></span>--%>
                        <img class="icon-user" src="${pageContext.request.contextPath}/img/user.png" alt="">
                        <span class="icon-user-green">${countAll - workingCount}</span><br>
                    <span>累计在线学习人数</span><br>
                </div>
                <div class="study-icon">
                    <%--<span class="icon-user"></span>--%>
                        <img class="icon-user" src="${pageContext.request.contextPath}/img/user.png" alt="">
                        <span class="icon-user-green">${workingCount}</span><br>
                    <span>累计就业人数</span><br>
                </div>
            </li>
        </ul>
    </div>
    <!--如何学习-->
    <div class="main-how2study container">
        <h2>如何学习</h2>
        <ul class=" main-study-items row list-style">
            <li class="col-lg-3 col-sm-6 col-xs-12 main-study-div">
                <img class="green-arrow img-hidden " src="${pageContext.request.contextPath}/img/arrow.png" alt="">
                <span class="order inline-block bgc-white font-green">1</span>
                <span class="order-text">匹配你现在的个人情况寻找适合自己的岗位</span>
            </li>
            <li class="col-lg-3 col-sm-6 col-xs-12 main-study-div">
                <img class="green-arrow" src="${pageContext.request.contextPath}/img/arrow.png" alt="">
                <span class="order inline-block bgc-white font-green">2</span>
                <span class="order-text">了解职业前景薪资待遇、竞争压力等</span>
            </li>
            <li class="col-lg-3 col-sm-6 col-xs-12 main-study-div">
                <img class="green-arrow" src="${pageContext.request.contextPath}/img/arrow.png" alt="">
                <span class="order inline-block bgc-white font-green">3</span>
                <span class="order-text">掌握行业内顶级技能</span>
            </li>
            <li class="col-lg-3 col-sm-6 col-xs-12 main-study-div">
                <img class="green-arrow" src="${pageContext.request.contextPath}/img/arrow.png" alt="">
                <span class="order inline-block bgc-white font-green">4</span>
                <span class="order-text">查看职业目标任务</span>
            </li>
        </ul>
        <ul class=" main-study-items row list-style">
            <li class="col-lg-3 col-sm-6 col-xs-12 main-study-div">
                <img class="green-arrow img-hidden " src="${pageContext.request.contextPath}/img/arrow.png" alt="">
                <span class="order inline-block bgc-white font-green">5</span>
                <span class="order-text">参考学习资源，掌握技能点，逐个完成任务</span>
            </li>
            <li class="col-lg-3 col-sm-6 col-xs-12 main-study-div">
                <img class="green-arrow" src="${pageContext.request.contextPath}/img/arrow.png" alt="">
                <span class="order inline-block bgc-white font-green">6</span>
                <span class="order-text">加入班级，和小伙伴们互帮互助，一块学习</span>
            </li>
            <li class="col-lg-3 col-sm-6 col-xs-12 main-study-div">
                <img class="green-arrow" src="${pageContext.request.contextPath}/img/arrow.png" alt="">
                <span class="order inline-block bgc-white font-green">7</span>
                <span class="order-text">选择导师，一路引导，加速自己成长</span>
            </li>
            <li class="col-lg-3 col-sm-6 col-xs-12 main-study-div">
                <img class="green-arrow" src="${pageContext.request.contextPath}/img/arrow.png" alt="">
                <span class="order inline-block bgc-white font-green">8</span>
                <span class="order-text">完成职业技能，升级业内大牛</span>
            </li>
        </ul>
    </div>
    <!--优秀学员展示-->
    <div class="main-student container">
        <h2>优秀学员展示</h2>
        <ul class=" main-student-items row list-style">
            <c:forEach items="${selectGreatStudent}" var="li">
                <li class="col-lg-3 col-sm-6 col-xs-12 main-student-div">
                    <div class="student-show">
                        <img class="student-head-icon"
                             src="${pageContext.request.contextPath}/img/${li.headImg}" alt="">
                        <h3>${li.username}</h3>
                        <span class="student-info">${li.userInfo}</span>
                    </div>
                </li>
            </c:forEach>
        </ul>
        <ul class="student-choose inline-block list-style">
            <li class="circle circle-0"></li>
            <li class="circle"></li>
            <li class="circle"></li>
            <li class="circle"></li>
        </ul>
    </div>
    <!--战略合作企业-->
    <div class="main-company container">
        <h2>战略合作企业</h2>
        <div class="main-corp-items row">
            <a class="my-col-5 main-corp-div">
                <img class="corp-logo" src="${pageContext.request.contextPath}/img/corp01.jpg" alt="">
            </a>
            <a class="my-col-5 main-corp-div">
                <img class="corp-logo" src="${pageContext.request.contextPath}/img/corp02.jpg" alt="">
            </a>
            <a class="my-col-5 main-corp-div">
                <img class="corp-logo" src="${pageContext.request.contextPath}/img/corp03.jpg" alt="">
            </a>
            <a class="my-col-5 main-corp-div">
                <img class="corp-logo" src="${pageContext.request.contextPath}/img/corp04.jpg" alt="">
            </a>
            <a class="my-col-5 main-corp-div">
                <img class="corp-logo" src="${pageContext.request.contextPath}/img/corp05.jpg" alt="">
            </a>
        </div>
    </div>
    <!--友情链接-->
    <div class="bgc-white">
        <div class="main-friendship container">
            <h2>友情链接</h2>
            <div class="main-friend-items row list-style text-line">
                <a class="friend-div my-col-10 text-line" href="#">
                    <span class="items-circle"></span>
                    <span class="friend-text">手机软件</span>
                </a>
                <a class="friend-div my-col-10" href="#">
                    <span class="items-circle"></span>
                    <span class="friend-text">教师招聘</span>
                </a>
                <a class="friend-div my-col-10" href="#">
                    <span class="items-circle"></span>
                    <span class="friend-text">找工作</span>
                </a>
                <a class="friend-div my-col-10" href="#">
                    <span class="items-circle"></span>
                    <span class="friend-text">招聘</span>
                </a>
                <a class="friend-div my-col-10" href="#">
                    <span class="items-circle"></span>
                    <span class="friend-text">软件</span>
                </a>
                <a class="friend-div my-col-10" href="#">
                    <span class="items-circle"></span>
                    <span class="friend-text">手机</span>
                </a>
                <a class="friend-div my-col-10" href="#">
                    <span class="items-circle"></span>
                    <span class="friend-text">手机软件</span>
                </a>
                <a class="friend-div my-col-10" href="#">
                    <span class="items-circle"></span>
                    <span class="friend-text">教师招聘</span>
                </a>
                <a class="friend-div my-col-10" href="#">
                    <span class="items-circle"></span>
                    <span class="friend-text">找工作</span>
                </a>
                <a class="friend-div my-col-10" href="#">
                    <span class="items-circle"></span>
                    <span class="friend-text">手机软件</span>
                </a>

                <a class="friend-div my-col-10" href="#">
                    <span class="items-circle"></span>
                    <span class="friend-text">手机软件</span>
                </a>
                <a class="friend-div my-col-10" href="#">
                    <span class="items-circle"></span>
                    <span class="friend-text">教师招聘</span>
                </a>
                <a class="friend-div my-col-10" href="#">
                    <span class="items-circle"></span>
                    <span class="friend-text">找工作</span>
                </a>
                <a class="friend-div my-col-10" href="#">
                    <span class="items-circle"></span>
                    <span class="friend-text">招聘</span>
                </a>
                <a class="friend-div my-col-10" href="#">
                    <span class="items-circle"></span>
                    <span class="friend-text">软件</span>
                </a>
                <a class="friend-div my-col-10" href="#">
                    <span class="items-circle"></span>
                    <span class="friend-text">手机</span>
                </a>
                <a class="friend-div my-col-10" href="#">
                    <span class="items-circle"></span>
                    <span class="friend-text">手机软件</span>
                </a>
                <a class="friend-div my-col-10" href="#">
                    <span class="items-circle"></span>
                    <span class="friend-text">教师招聘</span>
                </a>
                <a class="friend-div my-col-10" href="#">
                    <span class="items-circle"></span>
                    <span class="friend-text">找工作</span>
                </a>
                <a class="friend-div my-col-10" href="#">
                    <span class="items-circle"></span>
                    <span class="friend-text">手机软件</span>
                </a>
            </div>
        </div>
    </div>
</main>



