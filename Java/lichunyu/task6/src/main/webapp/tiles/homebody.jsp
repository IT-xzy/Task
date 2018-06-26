<%--
  Created by IntelliJ IDEA.
  User: lichu
  Date: 2018-5-23
  Time: 14:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="/tags" prefix="date"%>
<html>
<head>

    <title>HomeBody</title>
</head>
<body>
<%--1.导航条部分--%>
<div id="myCarousel" class="carousel slide">
    <ol class="carousel-indicators">
        <li class="active" data-slide-to="0" data-target="#myCarousel"></li>
        <li data-slide-to="1" data-target="#myCarousel"></li>
        <li data-slide-to="2" data-target="#myCarousel"></li>
        <li data-slide-to="3" data-target="#myCarousel"></li>
    </ol>
    <div class="carousel-inner">
        <div class="item active">
            <img alt="First slide" src="../images/banner1.jpg">
        </div>
        <div class="item">
            <img alt="Second slide" src="../images/banner2.jpg">
        </div>
        <div class="item">
            <img alt="Third slide" src="../images/banner3.jpg">
        </div>
        <div class="item">
            <img alt="Third slide" src="../images/banner4.jpg">
        </div>
        <a data-slide="prev" href="#myCarousel" class="carousel-control left">
            <i class="icon-left"><img src="../images/iconleft.png"></i>
        </a>
        <a data-slide="next" href="#myCarousel" class="carousel-control right">
            <i class="icon-right"><img src="../images/iconright.png"></i>
        </a>
    </div>
</div>

    <%--2.在线人数部分--%>
    <div class="main container">
        <div class="main-a row">
            <div class="col-xs-12 col-sm-6 col-md-6 col-lg-3">
                <div class="row text-center">
                    <ul class="list-unstyled">
                        <li class="col-xs-12 up-1">
                            <img alt="" src="../images/efficient.png">
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
                            <img alt="" src="../images/conduct.png">
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
                            <img alt="" src="../images/relationship.png">
                        </li>
                        <li class="up-2 col-xs-12">人脉</li>
                        <li class="up-3 col-xs-12">同班好友,同院学长,技术大师,入学就混职脉圈,为以后铺平道路</li>
                    </ul>
                </div>
            </div>

            <div class="col-xs-12 col-sm-6 col-md-6 col-lg-3 text-center">
                <p>
                    <img src="../images/tinyhead.png">${onlineCount}<br>
                    <span class="up-3">累计在线学习人数</span>
                </p>
                <p>
                    <img src="../images/tinyhead.png">${workCount}<br>
                    <span class="up-3">学员已经找到满意工作</span>
                </p>
            </div>
        </div>

        <%--3.学习方法部分--%>
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

        <%--4.优秀学员部分--%>
        <div class="main-c row">
            <h3 class="text-center main-tab">优秀学员展示</h3>
            <ul class="list-unstyled text-center">
                <li class="col-xs-12 col-sm-6 col-md-6 col-lg-3">
                    <div>
                        <img src="../images/excellent1.png">
                        <span>${student1.career}:${student1.name}</span>
                        <p class="text-left">${student1.duty}</p>
                        <p class="text-left">创建时间<date:date value="${student1.createdDate}"/></p>
                    </div>
                </li>
                <li class="col-xs-12 col-sm-6 col-md-6 col-lg-3">
                    <div>
                        <img src="../images/excellent2.png">
                        <span>${student2.career}:${student2.name}</span>
                        <p class="text-left">${student2.duty}</p>
                        <p class="text-left">创建时间<date:date value="${student2.createdDate}"/></p>
                    </div>
                </li>
                <li class="col-xs-12 col-sm-6 col-md-6 col-lg-3">
                    <div>
                        <img src="../images/excellent1.png">
                        <span>${student3.career}:${student3.name}</span>
                        <p class="text-left">${student3.duty}</p>
                        <p class="text-left">创建时间<date:date value="${student3.createdDate}"/></p>
                    </div>
                </li>
                <li class="col-xs-12 col-sm-6 col-md-6 col-lg-3">
                    <div>
                        <img src="../images/excellent2.png">
                        <span>${student2.career}:${student2.name}</span>
                        <p class="text-left">${student2.duty}</p>
                        <p class="text-left">创建时间<date:date value="${student2.createdDate}"/></p>
                    </div>
                </li>
            </ul>
        </div>

        <%--5.战略合作部分--%>
        <div class="row main-bottom">
            <h3 class="text-center">战略合作企业</h3>
            <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                <ul class="logo">
                    <li>
                        <a href=""><img src="../images/alibaba.png"></a>
                    </li>
                    <li>
                        <a href=""> <img src="../images/kingyun.png"></a>
                    </li>
                    <li>
                        <a href=""> <img src="../images/huanxin.png"></a>
                    </li>
                    <li>
                        <a href=""> <img src="../images/yuntongxun.png"></a>
                    </li>
                    <li>
                        <a href="">  <img src="../images/qiniu.png"></a>
                    </li>
                </ul>
            </div>
        </div>
    </div>

    <%--6.友情链接部分--%>
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

</div>
</body>
</html>
