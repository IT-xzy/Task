<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/6/22
  Time: 11:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/default.css">
    <link rel="stylesheet" href="css/home.css">
</head>
<body>
<main>
    <!-- 轮播图 -->
    <section id="myCarousel" class="carousel slide">
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
                <img src="img/slide1.png" alt="First slide">
            </div>
            <div class="item">
                <img src="img/slide2.png" alt="Second slide">
            </div>
            <div class="item">
                <img src="img/slide3.png" alt="Third slide">
            </div>
            <div class="item">
                <img src="img/slide4.png" alt="Fourth slide">
            </div>
            <div class="item">
                <img src="img/slide5.jpg" alt="Fifth slide">
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
    </section>
    <div class="container">
        <!-- 介绍 -->
        <section class="row intro">
            <div class="col-sm-6 col-md-3 intro-colum1 text-center">
                <div class="colum-icon"><img src="img/rocket.png" alt="rocket"></div>
                <h4><strong>高效</strong></h4>
                <p class="text-left">将五到七年的成长时间，缩短到一年到三年</p>
            </div>
            <div class="col-sm-6 col-md-3 intro-colum1 text-center">
                <div class="colum-icon"><img src="img/archive.png" alt="archive"></div>
                <h4><strong>规范</strong></h4>
                <p class="text-left">标准的实战教程，不会走弯路</p>
            </div>
            <div class="col-sm-6 col-md-3 intro-colum1 text-center ">
                <div class="colum-icon"><img src="img/contacts.png" alt="contacts"></div>
                <h4><strong>人脉</strong></h4>
                <p class="text-left">同班好友，同院学长，技术大师，入学就混入职脉圈，为以后铺平道路</p>
            </div>
            <div class="col-sm-6 col-md-3 intro-colum4">
                <div class="center-vertical">
                    <p>
                        <img src="img/user.png" alt="user">
                        <span><strong>12400</strong></span>
                    </p>
                    <p>累计在线学习人数</p>
                    <p>
                        <img src="img/user.png" alt="user">
                        <span><strong>12400</strong></span>
                    </p>
                    <p>学员已经找到满意工作</p>
                </div>
            </div>
        </section>
        <!-- 如何学习 -->
        <h4 class="text-center"><strong>如何学习</strong></h4>
        <section class="row">
            <div class="col-sm-6 col-md-3 stu-colum">
                <div class="stu-left">1</div>
                <div class="stu-right">
                    <img src="img/arrow.png" alt="rightarrow">
                </div>
                <div class="stu-md"><span>匹配你现在的个人情况，寻找适合自己的岗位</span></div>
            </div>
            <div class="col-sm-6 col-md-3 stu-colum">
                <div class="stu-left">2</div>
                <div class="stu-right">
                    <img src="img/arrow.png" alt="rightarrow">
                </div>
                <div class="stu-md"><span>了解职业前景薪金待遇、竞争压力等</span></div>
            </div>
            <div class="col-sm-6 col-md-3 stu-colum">
                <div class="stu-left">3</div>
                <div class="stu-right">
                    <img src="img/arrow.png" alt="rightarrow">
                </div>
                <div class="stu-md"><span>掌握行业内顶级技巧</span></div>
            </div>
            <div class="col-sm-6 col-md-3 stu-colum">
                <div class="stu-left">4</div>
                <div class="stu-right">
                    <img src="img/arrow.png" alt="rightarrow">
                </div>
                <div class="stu-md"><span>查看职业目标任务</span></div>
            </div>
        </section>
        <section class="row">
            <div class="col-sm-6 col-md-3 stu-colum">
                <div class="stu-left">5</div>
                <div class="stu-right">
                    <img src="img/arrow.png" alt="rightarrow">
                </div>
                <div class="stu-md"><span>参考学习资源，掌握技能点，逐个完成任务</span></div>
            </div>
            <div class="col-sm-6 col-md-3 stu-colum">
                <div class="stu-left">6</div>
                <div class="stu-right">
                    <img src="img/arrow.png" alt="rightarrow">
                </div>
                <div class="stu-md"><span>加入班级，和小伙伴们互帮互助，一块学习</span></div>
            </div>
            <div class="col-sm-6 col-md-3 stu-colum">
                <div class="stu-left">7</div>
                <div class="stu-right">
                    <img src="img/arrow.png" alt="rightarrow">
                </div>
                <div class="stu-md"><span>选择导师，一路引导，加速自己成长</span></div>
            </div>
            <div class="col-sm-6 col-md-3 stu-colum">
                <div class="stu-left">8</div>
                <div class="stu-right" style="visibility: hidden;">
                    <img src="img/arrow.png" alt="rightarrow">
                </div>
                <div class="stu-md"><span>完成职业技能，升级业界大牛</span></div>
            </div>
        </section>
        <!-- 优秀学员 -->
        <h4 class="text-center"><strong>优秀学员展示</strong></h4>
        <section class="row">
            <div class="col-md-3 col-sm-6">
                <div class="text-center student-show">
                    <img src="img/Avatar1.png" alt="Avatar1">
                    <h5><strong>技术顾问：罗大佑</strong></h5>
                    <p>百度技术总监：互联网基础服务领域，从事虚拟主机、 云服务器、域名。
                        曾任新网高级技术经理，负责技术研发、团队管理与建设。</p>
                </div>
            </div>
            <div class="col-md-3 col-sm-6">
                <div class="text-center student-show">
                    <img src="img/Avatar2.png" alt="Avatar2">
                    <h5><strong>技术顾问：罗大佑</strong></h5>
                    <p>百度技术总监：互联网基础服务领域，从事虚拟主机、 云服务器、域名。
                        曾任新网高级技术经理，负责技术研发、团队管理与建设。</p>
                </div>
            </div>
            <div class="col-md-3 col-sm-6">
                <div class="text-center student-show">
                    <img src="img/Avatar3.png" alt="Avatar3">
                    <h5><strong>技术顾问：罗大佑</strong></h5>
                    <p>百度技术总监：互联网基础服务领域，从事虚拟主机、 云服务器、域名。
                        曾任新网高级技术经理，负责技术研发、团队管理与建设。</p>
                </div>
            </div>
            <div class="col-md-3 col-sm-6">
                <div class="text-center student-show">
                    <img src="img/Avatar4.png" alt="Avatar4">
                    <h5><strong>技术顾问：罗大佑</strong></h5>
                    <p>百度技术总监：互联网基础服务领域，从事虚拟主机、 云服务器、域名。
                        曾任新网高级技术经理，负责技术研发、团队管理与建设。</p>
                </div>
            </div>
        </section>
        <!-- 圆点 -->
        <div class="text-center circle"><span></span><span></span><span></span><span></span></div>
        <!-- 合作企业 -->
        <h4 class="text-center"><strong>战略合作企业</strong></h4>
        <section class="row corp">
            <div class="col-lg-3 col-md-4 col-sm-6 text-center">
                <img class="corp-icon" src="img/alibaba.png" alt="alibaba">
            </div>
            <div class="col-lg-3 col-md-4 col-sm-6 text-center">
                <img class="corp-icon" src="img/jinshan.png" alt="jinshan">
            </div>
            <div class="col-lg-3 col-md-4 col-sm-6 text-center">
                <img class="corp-icon" src="img/huanxin.png" alt="huanxin">
            </div>
            <div class="col-lg-3 col-md-4 col-sm-6 text-center">
                <img class="corp-icon" src="img/yuntongxun.png" alt="yuntongxun">
            </div>
            <div class="col-lg-3 col-md-4 col-sm-6 text-center">
                <img class="corp-icon" src="img/qiniu.png" alt="qiniu">
            </div>
        </section>
    </div>
    <!-- 友情链接 -->
    <section class="link">
        <div class="container">
            <h4 class="text-center"><strong>友情链接</strong></h4>
            <div class="row">
                <ul class="clearfix center-block">
                    <li><a href="#">手机软件</a></li>
                    <li><a href="#">教师招聘</a></li>
                    <li><a href="#">找工作</a></li>
                    <li><a href="#">手机软件</a></li>
                    <li><a href="#">教师招聘</a></li>
                    <li><a href="#">找工作</a></li>
                    <li><a href="#">手机软件</a></li>
                    <li><a href="#">教师招聘</a></li>
                    <li><a href="#">找工作</a></li>
                    <li><a href="#">手机软件</a></li>
                    <li><a href="#">手机软件</a></li>
                    <li><a href="#">教师招聘</a></li>
                    <li><a href="#">找工作</a></li>
                    <li><a href="#">手机软件</a></li>
                    <li><a href="#">教师招聘</a></li>
                    <li><a href="#">找工作</a></li>
                    <li><a href="#">手机软件</a></li>
                    <li><a href="#">教师招聘</a></li>
                    <li><a href="#">找工作</a></li>
                    <li><a href="#">手机软件</a></li>
                </ul>
            </div>
        </div>
    </section>
</main>

<%--<!-- 底部 -->--%>
<%--<footer>--%>
    <%--<div class="ft-top">--%>
        <%--<div class="container">--%>
            <%--<div class="row">--%>
                <%--<div class="col-lg-4 col-md-4 col-sm-4">--%>
                    <%--<h4>--%>
                        <%--<a href="#">技能树&nbsp;—&nbsp;改变你我</a>--%>
                    <%--</h4>--%>
                    <%--<p>--%>
                        <%--<a href="#">关于我们&nbsp;&nbsp;|&nbsp;&nbsp;</a>--%>
                        <%--<a href="#">联系我们&nbsp;&nbsp;|&nbsp;&nbsp;</a>--%>
                        <%--<a href="#">合作企业</a>--%>
                    <%--</p>--%>
                <%--</div>--%>
                <%--<div class="col-lg-5 col-md-5 col-sm-5">--%>
                    <%--<h4>旗下网站</h4>--%>
                    <%--<p>--%>
                        <%--<span><a href="#">草船云孵化器</a>&nbsp;&nbsp;&nbsp;&nbsp;</span>--%>
                        <%--<span><a href="#">最强IT训练营</a></span>--%>
                    <%--</p>--%>
                    <%--<p>--%>
                        <%--<span><a href="#">葡萄藤轻游戏</a>&nbsp;&nbsp;&nbsp;&nbsp;</span>--%>
                        <%--<span><a href="#">桌游精灵</a></span>--%>
                    <%--</p>--%>
                <%--</div>--%>
                <%--<div class="col-lg-3 col-md-3 col-sm-3">--%>
                    <%--<div class="pull-right">--%>
                        <%--<h4>微信公众平台</h4>--%>
                        <%--<img src="img/qrcode.png" alt="qrcode">--%>
                    <%--</div>--%>
                <%--</div>--%>
            <%--</div>--%>
        <%--</div>--%>
    <%--</div>--%>

    <%--<!-- 版权信息 -->--%>
    <%--<div class="ft-btm">--%>
        <%--<div class="container">--%>
            <%--<div class="row text-center">--%>
                <%--<span> Copyright &copy; 2015  </span>--%>
                <%--<a href="#">技能树www.jnshu.com </a>--%>
                <%--<span> All Right Reserved</span>--%>
                <%--<a href="#">| 京ICP备13005880号</a>--%>
            <%--</div>--%>
        <%--</div>--%>
    <%--</div>--%>
<%--</footer>--%>
<!-- jQuery (Bootstrap 的 JavaScript 插件需要引入 jQuery) -->
<script src="js/jquery-1.12.4.min.js"></script>
<!-- 包括所有已编译的插件 -->
<script src="js/bootstrap.min.js"></script>
</body>
</html>
