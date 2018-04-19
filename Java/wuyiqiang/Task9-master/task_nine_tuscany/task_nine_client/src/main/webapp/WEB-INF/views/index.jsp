<%--
  Created by IntelliJ IDEA.
  User: yiqia
  Date: 2018/2/24 0024
  Time: 16:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <base href="<%=basePath%>">
    <%--<%--%>
        <%--out.println(basePath);--%>
        <%--out.println(path);--%>
    <%--%>--%>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>首页</title>
    <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css">
    <link href="css/base.css" rel="stylesheet" type="text/css">
    <link href="css/main.css" rel="stylesheet" type="text/css">
    <%--<script src="http://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>--%>
    <%--<script src="http://apps.bdimg.com/libs/bootstrap/3.3.4/js/bootstrap.min.js"></script>--%>
    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
</head>
<body>
<div class="container hidden-xs">
    <div class="row header-top">
        <p class="col-xs-12 col-sm-6 col-md-6 col-lg-6">客服电话:010-594-78634</p>
        <div class="col-xs-12 col-sm-6 col-md-6 col-lg-6 text-right">
            <div>
                <a href="javascript:void(0);" target="_blank"><img alt="" src="image/54537.png"></a>
                <a href="javascript:void(0);" target="_blank"><img alt="" src="image/45678678.png"></a>
                <a href="javascript:void(0);" target="_blank"><img alt="" src="image/54375483543.png"></a>
            </div>
        </div>
    </div>
</div>

<nav class="navbar navbar-default">
    <div class="container">
        <div class="navbar-header">
            <a href="javascript:void(0);" class="navbar-brand">
                <img src="image/logo.png" alt="Brand" class="img-responsive">
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
                <li><a href="javascript:void(0);">首页</a></li>
                <li><a href="school/profession">职业</a></li>
                <li><a href="javascript:void(0);">推荐</a></li>
                <li><a href="javascript:void(0);">关于</a></li>
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
            <img alt="First slide" src="image/547567.jpg">
        </div>
        <div class="item">
            <img alt="Second slide" src="image/547567.jpg">
        </div>
        <div class="item">
            <img alt="Third slide" src="image/547567.jpg">
        </div>
        <div class="item">
            <img alt="Third slide" src="image/547567.jpg">
        </div>
        <a data-slide="prev" href="#myCarousel" class="carousel-control left">
            <i class="icon-left"><img src="image/54354.png"></i>
        </a>
        <a data-slide="next" href="#myCarousel" class="carousel-control right">
            <i class="icon-right"><img src="image/4525424.png"></i>
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
                        <img alt="" src="image/45354312.png">
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
                        <img alt="" src="image/879789.png">
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
                        <img alt="" src="image/786453654365.png">
                    </li>
                    <li class="up-2 col-xs-12">人脉</li>
                    <li class="up-3 col-xs-12">同班好友,同院学长,技术大师,入学就混职脉圈,为以后铺平道路</li>
                </ul>
            </div>
        </div>

        <div class="col-xs-12 col-sm-6 col-md-6 col-lg-3 text-center">
            <p>
                <img src="image/453254312.png">${count}<br>
                <span class="up-3">累计在线学习人数</span>
            </p>
            <p>
                <img src="image/453254312.png">${graduated}<br>
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

            <c:forEach items="${students}" var="s">

                <li class="col-xs-12 col-sm-6 col-md-6 col-lg-3">
                    <div>
                        <img src="image/${s.picture}">
                        <span>${s.profession}:${s.name}</span>
                        <p class="text-left">${s.job}：${s.workIntroduction}</p>
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
                <li>
                    <a href="javascript:void(0);"><img src="image/123132.png"></a>
                </li>
                <li>
                    <a href="javascript:void(0);"><img src="image/1549865.png"></a>
                </li>
                <li>
                    <a href="javascript:void(0);"><img src="image/785345.png"></a>
                </li>
                <li>
                    <a href="javascript:void(0);"><img src="image/1471.png"></a>
                </li>
                <li>
                    <a href="javascript:void(0);"><img src="image/7861.png"></a>
                </li>
            </ul>
        </div>
    </div>
</div>

<div class="main-e">
    <h3 class="text-center main-tab ">友情链接</h3>
    <div class="container">
        <ul class="text-justify">
            <li><a href="javascript:void(0);">手机软件</a></li>
            <li><a href="javascript:void(0);">教师招聘</a></li>
            <li><a href="javascript:void(0);">找工作</a></li>
            <li><a href="javascript:void(0);">教师招聘</a></li>
            <li><a href="javascript:void(0);">找工作</a></li>
            <li><a href="javascript:void(0);">手机软件</a></li>
            <li><a href="javascript:void(0);">教师招聘</a></li>
            <li><a href="javascript:void(0);">手机软件</a></li>
            <li><a href="javascript:void(0);">手机软件</a></li>
            <li><a href="javascript:void(0);">找工作</a></li>
            <li><a href="javascript:void(0);">手机软件</a></li>
            <li><a href="javascript:void(0);">教师招聘</a></li>
            <li><a href="javascript:void(0);">找工作</a></li>
            <li><a href="javascript:void(0);">教师招聘</a></li>
            <li><a href="javascript:void(0);">找工作</a></li>
            <li><a href="javascript:void(0);">手机软件</a></li>
            <li><a href="javascript:void(0);">教师招聘</a></li>
            <li><a href="javascript:void(0);">手机软件</a></li>
            <li><a href="javascript:void(0);">手机软件</a></li>
            <li><a href="javascript:void(0);">找工作</a></li>
        </ul>
    </div>
</div>

<div class="footer">
    <div class="container">
        <div class="row">
            <div class="col-xs-12 col-sm-4 col-md-5 col-lg-5 up-1">
                <p><a>技能树-改变你我</a></p>
                <p><a href="javascript:void(0);"> 关于我们 </a>|<a href="javascript:void(0);"> 联系我们 </a>|<a href="javascript:void(0);"> 合作企业 </a></p>
            </div>
            <div class="col-xs-12 col-sm-4 col-md-5 col-lg-5 up-2">
                <p>旗下网站</p>
                <ul class="list-inline">
                    <li><a href="javascript:void(0);">草船云孵化器</a></li>
                    <li><a href="javascript:void(0);">最强IT特训营</a><br></li>
                </ul>
                <ul class="list-inline">
                    <li><a href="javascript:void(0);">葡萄藤轻游戏</a></li>
                    <li><a href="javascript:void(0);">桌游精灵</a></li>
                </ul>
            </div>
            <div class="col-xs-12 col-sm-4 col-md-2 col-lg-2 up-3">
                <p>微信公众平台</p>
                <img alt="" src="image/2524.jpg">
            </div>
        </div>
    </div>
    <div class="container-fluid text-center">
        <p>Copyright &copy; 2015 北京葡萄藤信息技术有限公司 All Rights Reserved | 京ICP备15035574号-1</p>
    </div>
</div>
</body>
</html>
