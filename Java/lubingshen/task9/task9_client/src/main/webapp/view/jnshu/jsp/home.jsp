<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>task8-技能树首页</title>
    <meta charset="utf-8" name="viewport" content="width=device-width" initial-scale=1  maximum-scale=1  minimum-scale=1  user-scalable=no>
    <link rel="stylesheet" href="/view/jnshu/css/home.css">
    <script src="/view/jnshu/js/jquery-3.2.1.min.js"></script>
    <link href="/view/jnshu/css/bootstrap.min.css" rel="stylesheet">
    <script src="/view/jnshu/js/bootstrap.min.js"></script>
</head>

<body>

<!-- 轮播图 -->
<div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
    <!-- Indicators -->
    <ol class="carousel-indicators">
        <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
        <li data-target="#carousel-example-generic" data-slide-to="1"></li>
        <li data-target="#carousel-example-generic" data-slide-to="2"></li>
        <li data-target="#carousel-example-generic" data-slide-to="3"></li>
    </ol>

    <!-- Wrapper for slides -->
    <div class="carousel-inner" role="listbox">

        <div class="item active">
            <img src="/view/jnshu/img/home/banner.png">
        </div>

        <div class="item">
            <img src="/view/jnshu/img/home/banner.png">
        </div>

        <div class="item">
            <img src="/view/jnshu/img/home/banner.png">
        </div>

        <div class="item">
            <img src="/view/jnshu/img/home/banner.png">
        </div>

    </div>

    <!-- Controls -->
    <a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
        <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
    </a>

    <a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
        <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
    </a>
</div>
<!--  特色内容,高效学习  -->
<div class="container ">

    <div class="row features">

        <div class="col-xs-3 main-media">
            <div class="main-one">
                <img src="/view/jnshu/img/home/main-one.png" height="50" width="35">
                <p class="topic">高效</p>
            </div>
            <div class="tip">将五年到七年的成长时间 , 缩短到一年到三年</div>
        </div>
        <div class="col-xs-3 main-media">
            <div class="main-two">
                <img src="/view/jnshu/img/home/main-two.png" height="50" width="60">
                <p class="topic">规范</p>
            </div>
            <div class="tip">标准的实战教程 , 不会走弯路。</div>
        </div>
        <div class="col-xs-3 main-media">
            <div class="main-three">
                <img src="/view/jnshu/img/home/main-three.png" height="50" width="50">
                <p class="topic">人脉</p>
            </div>
            <div class="tip">同班好友 , 同院学长 , 技术大师 , 入学就混入职脉圈 , 为以后铺平道路。</div>
        </div>
        <div class="col-xs-3 main-two-end main-media">
            <div class="main-fire">
                <img src="/view/jnshu/img/home/main-fire.png" height="13">${countStudent}
            </div>
            <div class="tip-end"><a href="#">累计在线学习人数</a></div>
            <div class="main-fire-bottom">
                <img src="/view/jnshu/img/home/main-fire.png" height="13">${countGraduate}
            </div>
            <div class="tip-end"><a href="#">学员已找到满意工作</a></div>
        </div>
    </div>
</div>

<!--  如何学习  -->
<div class="container">
    <p class="how-top">如何学习</p>

    <div class="row">

        <div class="col-xs-3 how">
            <div class="how-1">1</div>
            <p>匹配你现在的个人情况寻找适合自己的岗位</p>
        </div>
        <div class="col-xs-3 how">
            <div class="how-1">2</div>
            <p>了解职业前景薪金待遇、竞争压力等</p>
        </div>
        <div class="col-xs-3 how">
            <div class="how-1">3</div>
            <p>掌握行业内顶级技能</p>
        </div>
        <div class="col-xs-3 how-end">
            <div class="how-1">4</div>
            <p>查看职业目标任务</p>
        </div>

    </div>

</div>

<div class="container">

    <div class="row">

        <div class="col-xs-3 how">
            <div class="how-1">5</div>
            <p>参考学习资源、掌握技能点，逐个完成任务</p>
        </div>
        <div class="col-xs-3 how">
            <div class="how-1">6</div>
            <p>加入班级，和小伙伴们互帮互助，一块学习</p>
        </div>
        <div class="col-xs-3 how">
            <div class="how-1">7</div>
            <p>选择导师，一路引导，加速自己成长</p>
        </div>
        <div class="col-xs-3 how-end-2">
            <div class="how-1">8</div>
            <p>完成职业技能，升级业界大牛</p>
        </div>

    </div>

</div>

<!--  优秀学员展示  -->
<p class="student-show">优秀学员展示</p>

<div class="container">

    <div class="row row-1">

        <div class="col-xs-3 student-1">
            <img src="/view/jnshu/img/home/${list.get(0).avatar}" alt="不高兴一号">
            <b>${list.get(0).name}</b>
            <p>${list.get(0).message}</p>
        </div>
        <div class="col-xs-3 student-2">
            <img src="/view/jnshu/img/home/${list.get(1).avatar}" alt="不高兴一号">
            <b>${list.get(1).name}</b>
            <p>${list.get(1).message}</p>
        </div>
        <div class="col-xs-3 student-3">
            <img src="/view/jnshu/img/home/${list.get(2).avatar}" alt="不高兴一号">
            <b>${list.get(2).name}</b>
            <p>${list.get(2).message}</p>
        </div>
        <div class="col-xs-3 student-4">
            <img src="/view/jnshu/img/home/${list.get(3).avatar}" alt="不高兴一号">
            <b>${list.get(3).name}</b>
            <p>${list.get(3).message}</p>
        </div>
    </div>

</div>

<!--战略合作企业-->
<div class="container ">
    <div class="row">
        <div class="col-xs-12 title">战略合作企业</div>
    </div>
    <div class="row spel-all">
        <div class="col-xs-1 spel">
            <a href="#" class="al"></a>
        </div>
        <div class="col-xs-1 spel">
            <a href="#" class="js"></a>
        </div>
        <div class="col-xs-1 spel">
            <a href="#" class="hx"></a>
        </div>
        <div class="col-xs-1 spel">
            <a href="#" class="rl"></a>
        </div>
        <div class="col-xs-1 spel">
            <a href="#" class="qn"></a>
        </div>
    </div>
    <!--友情链接-->
    <div id="link">
        <p class="link-title">友情链接</p>
        <ul class="link">
            <li>
                <div class="li-left"></div>
                <a href="#">手机软件</a>
            </li>

            <li>
                <div class="li-left"></div>
                <a href="#">教师招聘</a>
            </li>

            <li>
                <div class="li-left"></div>
                <a href="#">找工作</a>
            </li>

            <li>
                <div class="li-left"></div>
                <a href="#">手机软件</a>
            </li>

            <li>
                <div class="li-left"></div>
                <a href="#">教师招聘</a>
            </li>

            <li>
                <div class="li-left"></div>
                <a href="#">找工作</a>
            </li>

            <li>
                <div class="li-left"></div>
                <a href="#">手机软件</a>
            </li>

            <li>
                <div class="li-left"></div>
                <a href="#">教师招聘</a>
            </li>

            <li>
                <div class="li-left"></div>
                <a href="#">找工作</a>
            </li>

            <li>
                <div class="li-left"></div>
                <a href="#">找工作</a>
            </li>

        </ul>

        <ul class="link-2">
            <li>
                <div class="li-left"></div>
                <a href="#">手机软件</a>
            </li>

            <li>
                <div class="li-left"></div>
                <a href="#">教师招聘</a>
            </li>

            <li>
                <div class="li-left"></div>
                <a href="#">找工作</a>
            </li>

            <li>
                <div class="li-left"></div>
                <a href="#">手机软件</a>
            </li>

            <li>
                <div class="li-left"></div>
                <a href="#">教师招聘</a>
            </li>

            <li>
                <div class="li-left"></div>
                <a href="#">找工作</a>
            </li>

            <li>
                <div class="li-left"></div>
                <a href="#">手机软件</a>
            </li>

            <li>
                <div class="li-left"></div>
                <a href="#">教师招聘</a>
            </li>

            <li>
                <div class="li-left"></div>
                <a href="#">找工作</a>
            </li>

            <li>
                <div class="li-left"></div>
                <a href="#">找工作</a>
            </li>

        </ul>
    </div>
</div>

</body>
</html>
