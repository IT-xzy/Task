<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib uri="/tags" prefix="date"%>--%>
<html lang="en" xmlns="http://www.w3.org/1999/html">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <title>vote</title>
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="../../css/task8.css"/>
    <script src="https://cdn.bootcss.com/jquery/3.1.1/jquery.min.js"></script>
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<header>
    <div class="container">
        <div class="row">
            <div class="col-xs-12 col-md-12 col-lg-12 followus">
                <span>客服热线:010-59478634</span>
                <span class="pull-right"><a class="wechat" href="#"></a>
                <a class="qq" href="#"></a>
                <a class="sina" href="#"></a>
        </span>
            </div>
        </div>
    </div>
    <div class="login">
        <span class="login1"><a href="#">登录</a></span>
        <span><a href="#">注册</a></span>
    </div>
    <div class="btl">
        <div class="container navigation">
            <div class="row">
                <div class="col-xs-12 col-md-12 col-lg-12">

                    <a href="../jsps/task8-2.jsp#" class="frontpage">关于</a>
                    <a href="../jsps/task8-3.jsp#">推荐</a>
                    <a href="../jsps/task8-3.jsp">职业</a>
                    <a href="../jsps/task8.jsp">首页</a>
                </div>
            </div>
        </div>
    </div>
    <div class="dp">
        <div class="dp-cell">
            <ul class="nav nav-pills">
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#"><img src="../../img/holder.png"></a>
                    <ul class="scc dropdown-menu">
                        <li><a href="#">关于</a></li>
                        <li><a href="#">推荐</a></li>
                        <li><a href="#">职业</a></li>
                        <li><a href="#">首页</a></li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>
</header>
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
                <img src="../../img/Image.jpg" class="imgw" alt="First slide">
            </div>
            <div class="item">
                <img src="../../img/Image.jpg" class="imgw" alt="Second slide">
            </div>
            <div class="item">
                <img src="../../img/Image.jpg" class="imgw" alt="Third slide">
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
                    <p><a class="glyphicon glyphicon-user"> 12400</a><a class="f3">累计在线学习人数</a></p>
                    <p><a class="glyphicon glyphicon-user"> 12400</a><a class="f3">学员已经找到满意工作</a></p>
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
                <div class="col-md-6 col-lg-3 col-xs-12">
                    <div class="students">
                        <img class="img-circle" src="../../img/Avatar.png">
                        <span class="title">技术顾问：罗大佑</span>
                        <div>
                            <p>百度技术总监：互联网基础
                                服务领域，从事虚拟主机、
                                云服务器、域名。曾任新网
                                高级技术经理，负责技术研
                                发、团队管理与建设。</p>
                        </div>
                    </div>
                </div>
                <div class="col-md-6 col-lg-3 col-xs-12">
                    <div class="students">
                        <img class="img-circle" src="../../img/Avatar1.png">
                        <span class="title">技术顾问：罗大佑</span>
                        <div>
                            <p>百度技术总监：互联网基础
                                服务领域，从事虚拟主机、
                                云服务器、域名。曾任新网
                                高级技术经理，负责技术研
                                发、团队管理与建设。</p>
                        </div>
                    </div>
                </div>
                <div class="col-md-6 col-lg-3 col-xs-12">
                    <div class="students">
                        <img class="img-circle" src="../../img/Avatar2.png">
                        <span class="title">技术顾问：罗大佑</span>
                        <div>
                            <p>百度技术总监：互联网基础
                                服务领域，从事虚拟主机、
                                云服务器、域名。曾任新网
                                高级技术经理，负责技术研
                                发、团队管理与建设。</p>
                        </div>
                    </div>
                </div>
                <div class="col-md-6 col-lg-3 col-xs-12">
                    <div class="students">
                        <img class="img-circle" src="../../img/Avatar3.png">
                        <span class="title">技术顾问：罗大佑</span>
                        <div>
                            <p>百度技术总监：互联网基础
                                服务领域，从事虚拟主机、
                                云服务器、域名。曾任新网
                                高级技术经理，负责技术研
                                发、团队管理与建设。</p>
                        </div>
                    </div>
                </div>
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
                <span><a><img src="../../img/alibaba.png"></a></span>
                <span><a><img src="../../img/jinshan.png"></a></span>
                <span><a><img src="../../img/huanqiu.png"></a></span>
                <span><a><img src="../../img/ronglian.png"></a></span>
                <span><a><img src="../../img/qiniu.png"></a></span>
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
<footer>
    <div class="container">
        <div class="row">
            <div class="col-lg-12 aboutus">
                <div class="left1">
                    <p>技能树—改变你我</p>
                    <span class="cc2"><a href="#">关于我们</a> |
            <a href="#">联系我们</a> |
                <a href="#">合作企业</a></span>
                </div>
                <div class="middle1">
                    <p>旗下网站</p>
                    <span><a href="#">草船云孵化器</a>
            <a href="#">最强IT特训营</a></span>
                    <span><a href="#">葡萄藤轻游戏</a>
            <a href="#">桌游精灵</a></span>
                </div>
                <div class="right1">
                    <p>微信公众平台</p>
                    <span class="cc1"><img src="../../img/erweima.png"></span>
                </div>
            </div>
        </div>
    </div>
    <div class="copyright">Copyright&copy 2015技能树 www.jnshu.com All Rights Reserved | 京ICP备 13005880号</div>
</footer>
</body>
</html>