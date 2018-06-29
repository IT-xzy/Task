<%--
  Created by IntelliJ IDEA.
  User: root
  Date: 2018/6/26
  Time: 17:18
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="date" uri="WEB-INF/tld/datetag.tld" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="bootstrap.min.css" rel="stylesheet" type="text/css">
    <link href="Untitled-3.css" rel="stylesheet" type="text/css">
    <link href="Untitled-1base.css" rel="stylesheet" type="text/css">
</head>
<body>

<div id="myCarousel" class="carousel slide">
    <ol class="carousel-indicators">
        <li class="active" data-slide-to="0" data-target="#myCarousel"></li>
        <li data-slide-to="1" data-target="#myCarousel"></li>
        <li data-slide-to="2" data-target="#myCarousel"></li>
        <li data-slide-to="3" data-target="#myCarousel"></li>
    </ol>
    <div class="carousel-inner">
        <div class="item active">
            <img alt="First slide" src="../../imges/547567.jpg">
        </div>
        <div class="item">
            <img alt="Second slide" src="../../imges/453254354.jpg">
        </div>
        <div class="item">
            <img alt="Third slide" src="../../imges/banner-3.jpg">
        </div>
        <div class="item">
            <img alt="Third slide" src="../../imges/banner-4.jpg">
        </div>
        <a data-slide="prev" href="#myCarousel" class="carousel-control left">
            <i class="icon-left"><img src="../../imges/54354.png"></i>
        </a>
        <a data-slide="next" href="#myCarousel" class="carousel-control right">
            <i class="icon-right"><img src="../../imges/4525424.png"></i>
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
                        <img alt="" src="../../imges/45354312.png">
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
                        <img alt="" src="../../imges/879789.png">
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
                        <img alt="" src="../../imges/786453654365.png">
                    </li>
                    <li class="up-2 col-xs-12">人脉</li>
                    <li class="up-3 col-xs-12">同班好友,同院学长,技术大师,入学就混职脉圈,为以后铺平道路</li>
                </ul>
            </div>
        </div>

        <div class="col-xs-12 col-sm-6 col-md-6 col-lg-3 text-center">
            <p>
                <img src="../../imges/453254312.png">${all}<br>
                <span class="up-3">累计在线学习人数</span>
            </p>
            <p>
                <img src="../../imges/453254312.png">${offer}<br>
                <span class="up-3">学员已经找到满意工作</span>
            </p>
        </div>
    </div>

    <!--第二部分开始-->
    <div class="main-b row">
        <h3 class="text-center main-tab">如何学习</h3>
        <ul class="list-unstyled text-center">
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
                    <img src="/imges/01.png" width="150" height="150">

                    <span>${list.get(0).name}</span>
                    <p class="text-center">${list.get(0).resume}</p>
                    <p class="text-center"><date:date value="${list.get(0).creatdate}"/></p>
                </div>
            </li>
            <li class="col-xs-12 col-sm-6 col-md-6 col-lg-3">
                <div>
                    <img src="/imges/02.png" height="150" width="150">

                    <span>${list.get(1).name}</span>
                    <p class="text-center">${list.get(1).resume}</p>
                    <p class="text-center"><date:date value="${list.get(1).creatdate}"/></p>
                </div>
            </li>
            <li class="col-xs-12 col-sm-6 col-md-6 col-lg-3">
                <div>
                    <img src="/imges/03.jpg" height="150" width="150">

                    <span>${list.get(2).name}</span>
                    <p class="text-center">${list.get(2).resume}</p>
                    <p class="text-center"><date:date value="${list.get(2).creatdate}"/></p>
                </div>
            </li>
            <li class="col-xs-12 col-sm-6 col-md-6 col-lg-3">
                <div>
                    <img src="/imges/04.jpg" height="150" width="150">

                    <span>${list.get(3).name}</span>
                    <p class="text-center">${list.get(3).resume}</p>
                    <p class="text-center"><date:date value="${list.get(3).creatdate}"/></p>
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
                    <a href=""><img src="../../imges/123132.png"></a>
                </li>
                <li>
                    <a href=""> <img src="../../imges/1549865.png"></a>
                </li>
                <li>
                    <a href=""> <img src="../../imges/785345.png"></a>
                </li>
                <li>
                    <a href=""> <img src="../../imges/1471.png"></a>
                </li>
                <li>
                    <a href="">  <img src="../../imges/7861.png"></a>
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
<script src="../../jquery.min.js"></script>
<script  src="../../bootstrap.min.js"></script>
</html>

