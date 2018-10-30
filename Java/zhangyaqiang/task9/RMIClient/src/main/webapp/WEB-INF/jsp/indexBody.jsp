<%--
  Created by IntelliJ IDEA.
  User: zyq
  Date: 2018/8/21
  Time: 17:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>首页</title>
</head>
<body>
<!--轮播图-->
<div class="carousel-main">
    <input class="carousel-main_input--a1" type="radio" id="carousel-checkbox1" name="value">
    <input class="carousel-main_input--a2" type="radio" id="carousel-checkbox2" name="value">
    <input class="carousel-main_input--b1" type="radio" id="carousel-checkbox3" name="value" checked="checked">
    <input class="carousel-main_input--b2" type="radio" id="carousel-checkbox4" name="value">
    <input class="carousel-main_input--c1" type="radio" id="carousel-checkbox5" name="value">
    <input class="carousel-main_input--c2" type="radio" id="carousel-checkbox6" name="value">
    <!--两侧控制按钮-->
    <label class="a1_go-3 label label-left" for="carousel-checkbox1"></label>
    <label class="a2_go-2 label label-right" for="carousel-checkbox2"></label>
    <label class="b1_go-1 label label-left" for="carousel-checkbox3"></label>
    <label class="b2_go-3 label label-right" for="carousel-checkbox4"></label>
    <label class="c1_go-2 label label-left" for="carousel-checkbox5"></label>
    <label class="c2_go-1 label label-right" for="carousel-checkbox6"></label>
    <!--/*底部按钮*/-->
    <label class="go-1 circle" for="carousel-checkbox3"></label>
    <label class="go-2 circle" for="carousel-checkbox2"></label>
    <label class="go-3 circle" for="carousel-checkbox1"></label>
    <!--轮播图片-->
    <img class="carousel_img-1" src="/img/css8/carousel-1.png">
    <img class="carousel_img-2" src="/img/css8/carousel-2.jpeg">
    <img class="carousel_img-3" src="/img/css8/carousel-3.jpg">
    <!--左右空心箭头-->
    <div class="arrow-left"></div>
    <div class="arrow-right"></div>
</div>
<!--页面主体-->
<div class="body-center">
    <!--简介部分-intro-->
    <div class="container-fluid">
        <div class="row">
            <div class="col-lg-3  col-sm-12">
                <div class="intro">
                    <div class="intro_div">
                        <img src="/img/css8/rocket.png">
                    </div>
                    <div class="intro_title">高效</div>
                    <div class="intro_content">将五到六年的成长时间，缩短到一到三年。</div>
                </div>
            </div>
            <div class="col-lg-3  col-sm-12">
                <div class="intro">
                    <div class="intro_div">
                        <img src="/img/css8/archive.png">
                    </div>
                    <div class="intro_title">高效</div>
                    <div class="intro_content">将五到六年的成长时间，缩短到一到三年。</div>
                </div>
            </div>
            <div class="col-lg-3  col-sm-12">
                <div class="intro">
                    <div class="intro_div">
                        <img src="/img/css8/relation.png">
                    </div>
                    <div class="intro_title">高效</div>
                    <div class="intro_content">将五到六年的成长时间，缩短到一到三年。</div>
                </div>
            </div>
            <div class="col-lg-3  col-sm-12">
                <div class="miniuser-center">
                    <div class="miniuser">
                        <div class="miniuser_title">
                            <img src="/img/css8/user-small.png">
                            <span class="miniuser_title_number">2506</span>
                            <%--<span class="miniuser_title_number">${online_number}</span>--%>
                        </div>
                        <div class="miniuser_content">
                            累计在线人数
                        </div>
                        <div class="miniuser_title">
                            <img src="/img/css8/user-small.png">
                            <span class="miniuser_title_number">12400</span>
                        </div>
                        <div class="miniuser_content">
                            学院已找到满意工作
                        </div>
                    </div>
                </div>

            </div>
        </div>
    </div>
    <!--步骤部分-step-->
    <div class="body-center_title">
        如何学习
    </div>
    <div class="container-fluid">
        <div class="row">
            <div class="col-lg-3  col-sm-12">
                <div class="step">
                    <div class="step_circle">1</div>
                    <span class="step_span">匹配你现在的个人情况寻找适合自己的岗位</span>
                    <img class="triangle" src="/img/css8/triangle-small.png">
                </div>
            </div>
            <div class="col-lg-3  col-sm-12">
                <div class="step">
                    <div class="step_circle">2</div>
                    <div class="step_span">了解职业前景薪金待遇、竞争压力等</div>
                    <img class="triangle" src="/img/css8/triangle-small.png">
                </div>
            </div>
            <div class="col-lg-3  col-sm-12">
                <div class="step">
                    <div class="step_circle">3</div>
                    <div class="step_span">掌握行业顶级技能</div>
                    <img class="triangle" src="/img/css8/triangle-small.png">
                </div>
            </div>
            <div class="col-lg-3  col-sm-12">
                <div class="step">
                    <div class="step_circle">4</div>
                    <div class="step_span">查看职业目标任务</div>
                    <img class="step_triangle-blank" src="/img/css8/triangle-small.png">
                </div>
            </div>
            <div class="col-lg-3  col-sm-12">
                <div class="step">
                    <div class="step_circle">5</div>
                    <span class="step_span">参考学习资源，掌握技能点，逐个完成任务</span>
                    <img class="triangle" src="/img/css8/triangle-small.png">
                </div>
            </div>
            <div class="col-lg-3  col-sm-12">
                <div class="step">
                    <div class="step_circle">6</div>
                    <div class="step_span">加入班级，和小伙伴们互帮互助，一块学习</div>
                    <img class="triangle" src="/img/css8/triangle-small.png">
                </div>
            </div>
            <div class="col-lg-3  col-sm-12">
                <div class="step">
                    <div class="step_circle">7</div>
                    <div class="step_span">选择导师，一路引导，加速自己成长</div>
                    <img class="triangle" src="/img/css8/triangle-small.png">
                </div>
            </div>
            <div class="col-lg-3  col-sm-12">
                <div class="step">
                    <div class="step_circle">8</div>
                    <div class="step_span">完成职业技能，升级业界大牛</div>
                    <img class="step_triangle-blank" src="/img/css8/triangle-small.png">
                </div>
            </div>
        </div>
    </div>
    <!--展示部分-show-->
    <div class="body-center_title">
        优秀学员展示
    </div>

    <div class="container-fluid">
        <div class="row">
            <c:forEach items="${list}" var="excellentStudent" varStatus="status">
                <div class="col-lg-3 col-md-6 col-sm-12" id="${status.index}" style="display: none">
                    <div class="show">
                        <img src="${excellentStudent.img}">
                        <div class="show_title">${excellentStudent.position}：${excellentStudent.name}</div>
                        <div class="show_content" style="height:13%">
                                ${excellentStudent.description}
                                ${status.index}
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>
    <!--跳转按钮-->
    <div class="button-container">
        <div class="button-center">
            <a>
                <div class="button1" id="button1"></div>
            </a>
            <a>
                <div class="button2" id="button2"></div>
            </a>
            <a>
                <div class="button2" id="button3"></div>
            </a>
            <a>
                <div class="button2" id="button4"></div>
            </a>
        </div>
    </div>
    <!--合作企业-partner-->
    <div class="body-center_title">
        战略合作企业
    </div>
    <div class="container-fluid">
        <div class="row">
            <div class="col-five col-sm-12 col-sign ">
                <div class="sign-container">
                    <img class="img-sign" src="/img/css8/sign1.png">
                </div>
            </div>
            <div class="col-five col-sm-12 col-sign ">
                <div class="sign-container">
                    <img class="img-sign" src="/img/css8/sign2.png">
                </div>
            </div>
            <div class="col-five col-sm-12 col-sign">
                <div class="sign-container">
                    <img class="img-sign" src="/img/css8/sign3.png">
                </div>
            </div>
            <div class="col-five col-sm-12 col-sign">
                <div class="sign-container">
                    <img class="img-sign" src="/img/css8/sign4.png">
                </div>
            </div>
            <div class="col-five col-sm-12 col-sign">
                <div class="sign-container">
                    <img class="img-sign" src="/img/css8/sign5.png">
                </div>
            </div>
        </div>
    </div>
</div>
<!--友情链接-link-->
<div class="adv">
    <div class="adv_center">
        <div class="adv_center_title">友情链接</div>
        <div class="container-fluid">
            <div class="row">
                <div class="col-five col-md-6 col-sm-12">
                    <div class="div-ul">
                        <ul class="ul">
                            <li><a class="a-ul-li">手机软件</a></li>
                        </ul>
                        <ul class="ul">
                            <li class="ul-li"><a class="a-ul-li">手机软件</a></li>
                        </ul>
                    </div>
                </div>
                <div class="col-five col-md-6 col-sm-12">
                    <div class="div-ul">
                        <ul class="ul">
                            <li><a class="a-ul-li">手机软件</a></li>
                        </ul>
                        <ul class="ul">
                            <li class="ul-li"><a class="a-ul-li">手机软件</a></li>
                        </ul>
                    </div>
                </div>
                <div class="col-five col-md-6 col-sm-12">
                    <div class="div-ul">
                        <ul class="ul">
                            <li><a class="a-ul-li">手机软件</a></li>
                        </ul>
                        <ul class="ul">
                            <li class="ul-li"><a class="a-ul-li">手机软件</a></li>
                        </ul>
                    </div>
                </div>
                <div class="col-five col-md-6 col-sm-12">
                    <div class="div-ul">
                        <ul class="ul">
                            <li><a class="a-ul-li">手机软件</a></li>
                        </ul>
                        <ul class="ul">
                            <li class="ul-li"><a class="a-ul-li">手机软件</a></li>
                        </ul>
                    </div>
                </div>
                <div class="col-five col-md-6 col-sm-12">
                    <div class="div-ul">
                        <ul class="ul">
                            <li><a class="a-ul-li">手机软件</a></li>
                        </ul>
                        <ul class="ul">
                            <li class="ul-li"><a class="a-ul-li">手机软件</a></li>
                        </ul>
                    </div>
                </div>
                <div class="col-five col-md-6 col-sm-12">
                    <div class="div-ul">
                        <ul class="ul">
                            <li><a class="a-ul-li">手机软件</a></li>
                        </ul>
                        <ul class="ul">
                            <li class="ul-li"><a class="a-ul-li">手机软件</a></li>
                        </ul>
                    </div>
                </div>
                <div class="col-five col-md-6 col-sm-12">
                    <div class="div-ul">
                        <ul class="ul">
                            <li><a class="a-ul-li">手机软件</a></li>
                        </ul>
                        <ul class="ul">
                            <li class="ul-li"><a class="a-ul-li">手机软件</a></li>
                        </ul>
                    </div>
                </div>
                <div class="col-five col-md-6 col-sm-12">
                    <div class="div-ul">
                        <ul class="ul">
                            <li><a class="a-ul-li">手机软件</a></li>
                        </ul>
                        <ul class="ul">
                            <li class="ul-li"><a class="a-ul-li">手机软件</a></li>
                        </ul>
                    </div>
                </div>
                <div class="col-five col-md-6 col-sm-12">
                    <div class="div-ul">
                        <ul class="ul">
                            <li><a class="a-ul-li">手机软件</a></li>
                        </ul>
                        <ul class="ul">
                            <li class="ul-li"><a class="a-ul-li">手机软件</a></li>
                        </ul>
                    </div>
                </div>
                <div class="col-five col-md-6 col-sm-12">
                    <div class="div-ul">
                        <ul class="ul">
                            <li><a class="a-ul-li">手机软件</a></li>
                        </ul>
                        <ul class="ul">
                            <li class="ul-li"><a class="a-ul-li">手机软件</a></li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
<script>
    window.onload = function () {
        for (var i = 0; i < 4; i++) {
            $("#" + i).css('display', 'inline');
        }
    }
    $("#button1").click(function () {
        for (var i = 0; i < 4; i++) {
            $("#" + i).css('display', 'inline');
        }
        for (var i = 4; i < 8; i++) {
            $("#" + i).css('display', 'none');
        }
        for (var i = 8; i < 12; i++) {
            $("#" + i).css('display', 'none');
        }
        for (var i = 12; i < 16; i++) {
            $("#" + i).css('display', 'none');
        }
        this.className = "button1";
        document.getElementById("button2").className = "button2";
        document.getElementById("button3").className = "button2";
        document.getElementById("button4").className = "button2";
    })

    $("#button2").click(function () {
        for (var i = 0; i < 4; i++) {
            $("#" + i).css('display', 'none');
        }
        for (var i = 4; i < 8; i++) {
            $("#" + i).css('display', 'inline');
        }
        for (var i = 8; i < 12; i++) {
            $("#" + i).css('display', 'none');
        }
        for (var i = 12; i < 16; i++) {
            $("#" + i).css('display', 'none');
        }
        this.className = "button1";
        document.getElementById("button1").className = "button2";
        document.getElementById("button3").className = "button2";
        document.getElementById("button4").className = "button2";
    })

    $("#button3").click(function () {
        for (var i = 0; i < 4; i++) {
            $("#" + i).css('display', 'none');
        }
        for (var i = 4; i < 8; i++) {
            $("#" + i).css('display', 'none');
        }
        for (var i = 8; i < 12; i++) {
            $("#" + i).css('display', 'inline');
        }
        for (var i = 12; i < 16; i++) {
            $("#" + i).css('display', 'none');
        }
        this.className = "button1";
        document.getElementById("button1").className = "button2";
        document.getElementById("button2").className = "button2";
        document.getElementById("button4").className = "button2";
    })
    $("#button4").click(function () {
        for (var i = 0; i < 4; i++) {
            $("#" + i).css('display', 'none');
        }
        for (var i = 4; i < 8; i++) {
            $("#" + i).css('display', 'none');
        }
        for (var i = 8; i < 12; i++) {
            $("#" + i).css('display', 'none');
        }
        for (var i = 12; i < 16; i++) {
            $("#" + i).css('display', 'inline');
        }
        this.className = "button1";
        document.getElementById("button1").className = "button2";
        document.getElementById("button2").className = "button2";
        document.getElementById("button3").className = "button2";
    })
</script>
</html>
