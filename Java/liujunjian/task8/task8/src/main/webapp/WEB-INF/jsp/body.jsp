<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<html>
<head>
    <link rel="stylesheet" href="../css/body.css">
    <title>Title</title>
    <script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<div id="myCarousel" class="carousel slide" data-ride="carousel">
        <ol class="carousel-indicators">
            <li class="active" data-slide-to="0" data-target="#myCarousel"></li>
            <li data-slide-to="1" data-target="#myCarousel"></li>
            <li data-slide-to="2" data-target="#myCarousel"></li>
            <li data-slide-to="3" data-target="#myCarousel"></li>
        </ol>
    <div class="carousel-inner" role="listbox">

        <div class="item active">
            <c:forEach items="${image}" var="picture" begin="0" end="0">
                <img src=${picture}>
            </c:forEach>
        </div>
        <c:forEach items="${image}" var="picture" begin="1" end="3">
            <div class="item">
                <img src=${picture}>
            </div>
        </c:forEach>
    </div>
    <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
        <span class="glyphicon glyphicon-chevron-left" aria-hidden="true "></span>
    </a>
    <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
        <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
    </a>
</div>
<div class="logo">
    <div class="container">
        <div class="row">
            <div class="col-xs-12 col-sm-3 text-center">
                <img src="../images/logo01.png" alt="">
                <strong>高效</strong>
                <p>将五到七年的成长时间，缩短<br>到一年到三年。</p>
            </div>
            <div class="col-xs-12 col-sm-3 text-center">
                <img src="../images/logo02.png" alt="">
                <strong>规范</strong>
                <p>标准的实战教程，不会走弯路</p>
            </div>
            <div class="col-xs-12 col-sm-3 text-center">
                <img src="../images/logo03.png" alt="">
                <strong>人脉</strong>
                <p>同班好友，同院学长，技术大师，入学就混入职脉圈，为以后铺平道路。</p>
            </div>
            <div class="col-xs-12 col-sm-3 text-center number">
                <strong><img src="../images/logo04.png" alt="">${stuSum}</strong>
                <span class="gy">累计在线学习人数</span>
                <strong><img src="../images/logo04.png" alt="">${graSum}</strong>
                <span class="gy">学员已经找到满意工作</span>
            </div>
        </div> <!-- logo-row -->
    </div> <!-- logo-container -->
</div> <!-- logo -->
<div class="stream">
    <div class="container">
        <div class="row text-center">
            <div class="col-xs-12">
                <strong>如何学习</strong>
            </div>
            <div class="col-xs-12 media-stream">
                <div class="colxs-12 col-sm-3">
                    <div class="circular">1<img src="../images/logo04.png" alt=""/></div>
                    <p>匹配你现在的个人情况寻找适合自己的岗位</p>
                </div>
                <div class="colxs-12 col-sm-3">
                    <div class="circular">2<img src="../images/logo04.png" alt=""/></div>
                    <p>了解职业前景薪金待遇、竞争压力等</p>
                </div>
                <div class="colxs-12 col-sm-3">
                    <div class="circular">3<img src="../images/logo04.png" alt=""/></div>
                    <p>掌握行业内顶级技能</p>
                </div>
                <div class="col-xs-12 col-sm-3">
                    <div class="circular">4<img src="../images/logo04.png" alt=""/></div>
                    <p>查看职业目标任务</p>
                </div>
            </div>
            <div class="col-xs-12 media-stream">
                <div class="colxs-12 col-sm-3">
                    <div class="circular">5<img src="../images/logo04.png" alt=""/></div>
                    <p>参考学习资源，掌握技能点，逐个完成任务</p>
                </div>
                <div class="colxs-12 col-sm-3">
                    <div class="circular">6<img src="../images/logo04.png" alt=""/></div>
                    <p>加入班级，和小伙伴们互帮互助，一块学习</p>
                </div>
                <div class="colxs-12 col-sm-3">
                    <div class="circular">7<img src="../images/logo04.png" alt=""/></div>
                    <p>选择导师，一路引导，加速自己成长</p>
                </div>
                <div class="colxs-12 col-sm-3">
                    <div class="circular">8<img src="../images/logo04.png" alt=""/></div>
                    <p>完成职业技能，升级业界大牛</p>
                </div>
            </div>
        </div> <!-- stream-row -->
    </div> <!-- stream-container -->
</div> <!-- stream -->
<div class="student">
    <div class="container">
        <div class="row">
            <div class="col-xs-12 text-center">
                <strong>优秀学员展示</strong>
            </div>
            <div class="col-xs-12 col-sm-3 text-center student-border media-student">
                <img src="../images/portrait1.png" alt="">
                <strong>技术顾问：晋良金</strong>
                <p>百度技术总监：互联网基础服务领域，从事虚拟主机、云服务器、域名。曾任新网高级技术经理，负责技术研发、团队管理与建设。</p>
            </div>
            <div class="col-xs-12 col-sm-3 text-center student-border media-student">
                <img src="../images/portrait2.png" alt="">
                <strong>技术顾问：王佳妮</strong>
                <p>百度技术总监：互联网基础服务领域，从事虚拟主机、云服务器、域名。曾任新网高级技术经理，负责技术研发、团队管理与建设。</p>
            </div>
            <div class="col-xs-12 col-sm-3 text-center student-border media-student">
                <img src="../images/portrait3.png" alt="">
                <strong>技术顾问：万全林</strong>
                <p>百度技术总监：互联网基础服务领域，从事虚拟主机、云服务器、域名。曾任新网高级技术经理，负责技术研发、团队管理与建设。</p>
            </div>
            <div class="col-xs-12 col-sm-3 text-center student-border media-student">
                <img src="../images/portrait4.png" alt="">
                <strong>技术顾问：陈丹婷</strong>
                <p>百度技术总监：互联网基础服务领域，从事虚拟主机、云服务器、域名。曾任新网高级技术经理，负责技术研发、团队管理与建设。</p>
            </div>
        </div> <!-- student-row -->
    </div> <!-- student-container -->
</div>
<div class="cooperation">
    <div class="container">
        <div class="row text-center">
            <div class="col-xs-12"><strong>战略合作企业</strong></div>
            <div class="cooperation-warp col-xs-12 col-sm-12">
                <div class="col-xs-12 col-sm-2 img-shadow media-img-shadow"><img src="../images/qy1.png" alt=""
                                                                                 class="img-responsive"></div>
                <div class="col-xs-12 col-sm-2 img-shadow media-img-shadow"><img src="../images/qy2.png" alt=""
                                                                                 class="img-responsive"></div>
                <div class="col-xs-12 col-sm-2 img-shadow media-img-shadow"><img src="../images/qy3.png" alt=""
                                                                                 class="img-responsive"></div>
                <div class="col-xs-12 col-sm-2 img-shadow media-img-shadow"><img src="../images/qy4.png" alt=""
                                                                                 class="img-responsive"></div>
                <div class="col-xs-12 col-sm-2 img-shadow media-img-shadow"><img src="../images/qy5.png" alt=""
                                                                                 class="img-responsive"></div>
            </div>
        </div>
    </div>
</div>
<div class="friends">
    <div class="div container">
        <div class="row">
            <div class="col-xs-12 hidden-xs text-center">
                <strong>友情链接</strong>
                <ul class="text-center">
                    <li><a href="">·手机软件</a></li>
                    <li><a href="">·教师招聘</a></li>
                    <li><a href="">·找工作</a></li>
                    <li><a href="">·线下聚会</a></li>
                    <li><a href="">·线上辅导</a></li>

                    <li><a href="">·手机软件</a></li>
                    <li><a href="">·教师招聘</a></li>
                    <li><a href="">·找工作</a></li>
                    <li><a href="">·线下聚会</a></li>
                    <li><a href="">·线上辅导</a></li>
                    <br>
                    <li><a href="">·手机软件</a></li>
                    <li><a href="">·教师招聘</a></li>
                    <li><a href="">·找工作</a></li>
                    <li><a href="">·线下聚会</a></li>
                    <li><a href="">·线上辅导</a></li>

                    <li><a href="">·手机软件</a></li>
                    <li><a href="">·教师招聘</a></li>
                    <li><a href="">·找工作</a></li>
                    <li><a href="">·线下聚会</a></li>
                    <li><a href="">·线上辅导</a></li>

                </ul>
            </div> <!-- friends-col-xs-12 -->
        </div>  <!-- friends-row -->
    </div> <!-- friends-container -->
</div>
</body>
</html>
