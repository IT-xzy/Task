<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isErrorPage="true" isELIgnored="false" %>
<%--设置编写语言为java,编写内容为txt或者html设置编码格式为UTF-8--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--json taglib的C标签--%>
<!DOCTYPE html>

<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>孙若飞的第一个页面</title>
    <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css">
    <link href="css/Untitled-3.css" rel="stylesheet" type="text/css">
    <link href="css/Untitled-1base.css" rel="stylesheet" type="text/css">
</head>
<body>
<div class="container  hidden-xs">
    <div class="row header-top">
        <p class="col-xs-12 col-sm-6 col-md-6 col-lg-6">客服电话:010-594-78634</p>
        <div class="col-xs-12 col-sm-6 col-md-6 col-lg-6 text-right">
            <div>
                <a href="#" target="_blank"> <img alt="" src="images/54537.png"></a>
                <a href="#" target="_blank"><img alt="" src="images/45678678.png"></a>
                <a href="#" target="_blank"> <img alt="" src="images/54375483543.png"></a>
            </div>
        </div>
    </div>
</div>

<nav class="navbar navbar-default">
    <div class="container">
        <div class="navbar-header">
            <a href="#" class="navbar-brand">
                <img src="images/logo.png" alt="Brand" class="img-responsive">
            </a>
            <button data-target="#open-nav" data-toggle="collapse" class="navbar-toggle btn-primary collapsed"
                    aria-expanded="false">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
        </div>
        <div id="open-nav" class="navbar-collapse collapse" aria-expanded="false" style="height: 1px;">
            <ul class="nav navbar-nav navbar-right text-center list-inline">
                <li><a href="">首页</a></li>
                <li><a href="../t11/index.html">职业</a></li>
                <li><a href="">推荐</a></li>
                <li><a href="">关于</a></li>
            </ul>
        </div>

    </div>
</nav>

<div id="myCarousel" class="carousel slide">
    <ol class="carousel-indicators">
        <li class="active" data-slide-to="0" data-target="#myCarousel"></li>
        <li data-slide-to="1" data-target="#myCarousel"></li>
        <li data-slide-to="2" data-target="#myCarousel"></li>
        <li data-slide-to="3" data-target="#myCarousel"></li>
    </ol>
    <div class="carousel-inner">
        <div class="item active">
            <img alt="First slide" src="images/547567.jpg">
        </div>
        <div class="item">
            <img alt="Second slide" src="images/547567.jpg">
        </div>
        <div class="item">
            <img alt="Third slide" src="images/547567.jpg">
        </div>
        <div class="item">
            <img alt="Third slide" src="images/547567.jpg">
        </div>
        <a data-slide="prev" href="#myCarousel" class="carousel-control left">
            <i class="icon-left"><img src="images/54354.png"></i>
        </a>
        <a data-slide="next" href="#myCarousel" class="carousel-control right">
            <i class="icon-right"><img src="images/4525424.png"></i>
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
                        <img alt="" src="images/45354312.png">
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
                        <img alt="" src="images/879789.png">
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
                        <img alt="" src="images/786453654365.png">
                    </li>
                    <li class="up-2 col-xs-12">人脉</li>
                    <li class="up-3 col-xs-12">同班好友,同院学长,技术大师,入学就混职脉圈,为以后铺平道路</li>
                </ul>
            </div>
        </div>

        <div class="col-xs-12 col-sm-6 col-md-6 col-lg-3 text-center">
            <p>
                <img src="images/453254312.png">12400<br>
                <span class="up-3">累计在线学习人数</span>
            </p>
            <p>
                <img src="images/453254312.png">12400<br>
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

            <c:forEach items="${students}"  varStatus="now">
                <%--定义了一个now名的对象作为varStatus的绑定值。该绑定值也就是now封装了当前遍历的状态--%>
                <li class="col-xs-12 col-sm-6 col-md-6 col-lg-3">
                    <div>
                        <img src=${students.get(now.index).picture} width="108" height="108">
                        <%--varStatus: 显示循环状态的变量，有一下几个属性,${now.index} 输出行号，从0开始。--%>
                        <%--width宽度,height高度--%>
                        <span>${students.get(now.index).position}</span>
                        <span>${students.get(now.index).name}</span>
                        <p class="text-left">${students.get(now.index).introduction}</p>
                    </div>
                </li>
            </c:forEach>

        </ul>
    </div>

    <!--第四部分开始-->
    <div class="row main-bottom">
        <h3 class="text-center">战略合作企业</h3>
        <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
            <ul class="logo">
                <c:forEach items="${companies}" varStatus="now">
                    <li>
                        <a href=""><img src=${companies.get(now.index).url} width="141" height="54"></a>
                    </li>
                </c:forEach>
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

<div class="footer">
    <div class="container">
        <div class="row">
            <div class="col-xs-12 col-sm-4 col-md-5 col-lg-5 up-1">
                <p><a>技能树-改变你我</a></p>
                <p><a href="#">关于我们 </a>|<a href="#"> 联系我们 </a>|<a href="#"> 合作企业 </a></p>
            </div>
            <div class="col-xs-12 col-sm-4 col-md-5 col-lg-5 up-2">
                <p>旗下网站</p>
                <ul class="list-inline">
                    <li><a href="#">草船云孵化器</a></li>
                    <li><a href="#">最强IT特训营</a><br></li>
                </ul>
                <ul class="list-inline">
                    <li><a href="#">葡萄藤轻游戏</a></li>
                    <li><a href="#">桌游精灵</a></li>
                </ul>
            </div>
            <div class="col-xs-12 col-sm-4 col-md-2 col-lg-2 up-3">
                <p>微信公众平台</p>
                <img alt="" src="images/2524.jpg">
            </div>
        </div>
    </div>
    <div class="container-fluid text-center">
        <p>Copyright &copy; 2015 北京葡萄藤信息技术有限公司 All Rights Reserved | 京ICP备15035574号-1</p>
    </div>
</div>
</body>
<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</html>
