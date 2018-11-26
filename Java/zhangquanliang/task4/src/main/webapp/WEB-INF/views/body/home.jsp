<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div id="myCarousel" class="carousel slide">
    <!-- 轮播（Carousel）指标 -->
    <ol class="carousel-indicators">
        <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
        <li data-target="#myCarousel" data-slide-to="1"></li>
        <li data-target="#myCarousel" data-slide-to="2"></li>
    </ol>
    <!-- 轮播（Carousel）项目 -->
    <div class="carousel-inner">
        <div class="item active">
            <img src="/static/img/html8.1.png" alt="First slide">
        </div>
        <div class="item">
            <img src="/static/img/html8.jpg" alt="Second slide">
        </div>
        <div class="item">
            <img src="/static/img/html8.3.png" alt="Third slide">
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

<main>
    <div class="container content">
        <div class="row">
            <div class="col-md-3  col-sm-6  content-box">
                <div class="img-box">
                    <img src="/static/img/css8.png" height="62" width="43"/>
                </div>
                <span>高效</span>
                <p>将五到七年的成长时间，缩短到一年到三年。</p>
            </div>
            <div class="col-md-3  col-sm-6 content-box">
                <div class="img-box">
                    <img src="/static/img/css8.1.png" height="48" width="60"/>
                </div>
                <span>规范</span>
                <p>标准的实战教程，不会走弯路</p>
            </div>
            <div class="col-md-3  col-sm-6 content-box">
                <div class="img-box">
                    <img src="/static/img/css8.2.png" height="48" width="60"/>
                </div>
                <span>人脉</span>
                <p>同班好友，同院学长，技术大师，入学就混入职脉圈，为以后铺平道路。</p>
            </div>
            <div class="col-md-3  col-sm-6 content-box">
                <div class="content-box-profile">
                    <img src="/static/img/css8.3.png" height="13" width="13"/>
                    <span>${total}</span>
                    <p>累计在线学习人数</p>
                    <img src="/static/img/css8.3.png" height="13" width="13"/>
                    <span>${workNum}</span>
                    <p>学员已经找到满意工作</p></div>
            </div>
        </div>
        <div class="row learn">
            <p>如何学习</p>
        </div>
        <div class="row  ">
            <div class=" col-md-3  col-sm-6 col-xs-12 how-to-learn">
                <div class="number">1 </div>
                <span class="detailed">
            匹配你现在的个人情况 寻找适合自己的岗位</span>
                <span>
        <img src="/static/img/task8.4.png" height="30" width="32"/></span>
            </div>
            <div class="col-md-3  col-sm-6 col-xs-12 how-to-learn">
                <div class="number">2 </div>
                <span class="detailed">
            了解职业前景薪金待遇、 竞争压力等
        </span>
                <span>
        <img src="/static/img/task8.4.png" height="30" width="32"/></span>
            </div>
            <div class="col-md-3  col-sm-6 col-xs-12 how-to-learn">
                <div class="number">3 </div>
                <span class="detailed">
               掌握行业内顶级技能
        </span>
                <span>
        <img src="/static/img/task8.4.png" height="30" width="32"/></span>
            </div>
            <div class="col-md-3  col-sm-6 col-xs-12 how-to-learn">
                <div class="number">4 </div>
                <span class="detailed">
            查看职业目标任务
        </span>
                <span class="clear">
        <img src="/static/img/task8.4.png" height="30" width="32"/></span>
            </div>
            <div class="col-md-3  col-sm-6 col-xs-12 how-to-learn">
                <div class="number">5 </div>
                <span class="detailed">
           参考学习资源，掌握 技能点，逐个完成任务
        </span>
                <span>
        <img src="/static/img/task8.4.png" height="30" width="32"/></span>
            </div>
            <div class="col-md-3   col-sm-6 col-xs-12 how-to-learn">
                <div class="number">6 </div>
                <span class="detailed">
         加入班级，和小伙伴们 互帮互助，一块学习
        </span>
                <span>
        <img src="/static/img/task8.4.png" height="30" width="32"/></span>
            </div>
            <div class="col-md-3  col-sm-6 col-xs-12 how-to-learn">
                <div class="number">7 </div>
                <span class="detailed">
            选择导师，一路引导， 加速自己成长
        </span>
                <span>
        <img src="/static/img/task8.4.png" height="30" width="32"/></span>
            </div>
            <div class="col-md-3   col-sm-6 col-xs-12  how-to-learn">
                <div class="number">8 </div>

                <span class="detailed">
            完成职业技能，升级业界大牛
        </span>
                <span class="clear">
        <img src="/static/img/task8.4.png" height="30" width="32"/></span>
            </div>
        </div>
        <div class="row learn">
            <p>优秀学员展示</p>
        </div>
        <div class="row">
            <c:forEach items="${students}" var="student">

            <div class="col-md-3  col-sm-6  content-box">
                <div class="introduce">
                    <img src="/static/img/${student.img}" height="108" width="108"/>
                    <h4>${student.position}：${student.name}</h4>
                    <p>${student.intro}</p>
                </div>
            </div>
            </c:forEach>
        </div>
        <div class="row green-point">
            <div class="moving-point"></div>
            <div class="moving-point"></div>
            <div class="moving-point"></div>
            <div class="moving-point"></div>
        </div>
        <div class="row learn">
            <p>战略合作企业</p>
        </div>

        <div class="row">
            <div class="  col-md-6 col-xs-12 img-photograph">
                <div class="photograph">
                    <img src="/static/img/corporation8.png">
                </div></div>
            <div class="   col-md-6 col-xs-12  img-photograph">
                <div class="photograph">
                    <img src="/static/img/corporation8.1.png">
                </div></div>
            <div class=" col-md-6 col-xs-12  img-photograph">
                <div class="photograph">
                    <img src="/static/img/corporation8.2.png">
                </div></div>
            <div class="col-md-6 col-xs-12  img-photograph">
                <div class="photograph">
                    <img src="/static/img/corporation8.3.png" >
                </div></div>
            <div class=" col-md-6 col-xs-12  img-photograph">
                <div class="photograph">
                    <img src="/static/img/corporation8.4.png">
                </div></div>
        </div>

        <div class="row learn">
            <p>友情链接</p>
        </div>

        <div class="row">
            <div class=" col-md-3  col-sm-6 detailed-introduction ">
                <div class="friendship-link">
                    <div class="box-circle">
                    </div>
                    <span class="frame">手机软件</span>
                </div>
            </div>
            <div class=" col-md-3  col-sm-6 detailed-introduction  ">
                <div class="friendship-link">
                    <div class="box-circle">
                    </div>
                    <span class="frame">教师招聘</span>
                </div>
            </div>
            <div class=" col-md-3  col-sm-6 detailed-introduction  ">
                <div class="friendship-link">
                    <div class="box-circle">
                    </div>
                    <span class="frame">手机软件</span>
                </div>
            </div>
            <div class=" col-md-3  col-sm-6 detailed-introduction  ">
                <div class="friendship-link">
                    <div class="box-circle">
                    </div>
                    <span class="frame">教师招聘</span>
                </div>
            </div>
            <div class=" col-md-3  col-sm-6 detailed-introduction  ">
                <div class="friendship-link">
                    <div class="box-circle">
                    </div>
                    <span class="frame">手机软件</span>
                </div>
            </div>
            <div class=" col-md-3  col-sm-6 detailed-introduction ">
                <div class="friendship-link">
                    <div class="box-circle">
                    </div>
                    <span class="frame">介绍私活</span>
                </div>
            </div>
            <div class=" col-md-3  col-sm-6 detailed-introduction ">
                <div class="friendship-link">
                    <div class="box-circle">
                    </div>
                    <span class="frame">手机软件</span>
                </div>
            </div>
            <div class=" col-md-3  col-sm-6 detailed-introduction ">
                <div class="friendship-link">
                    <div class="box-circle">
                    </div>
                    <span class="frame">出售光碟</span>
                </div>
            </div>
            <div class=" col-md-3  col-sm-6 detailed-introduction  ">
                <div class="friendship-link">
                    <div class="box-circle">
                    </div>
                    <span class="frame">手机软件</span>
                </div>
            </div>
            <div class=" col-md-3  col-sm-6 detailed-introduction  ">
                <div class="friendship-link">
                    <div class="box-circle">
                    </div>
                    <span class="frame">招聘学员</span>
                </div>
            </div>
            <div class=" col-md-3  col-sm-6 detailed-introduction ">
                <div class="friendship-link">
                    <div class="box-circle">
                    </div>
                    <span class="frame">手机软件</span>
                </div>
            </div>
            <div class=" col-md-3  col-sm-6 detailed-introduction  ">
                <div class="friendship-link">
                    <div class="box-circle">
                    </div>
                    <span class="frame">日常学习</span>
                </div>
            </div>
            <div class=" col-md-3  col-sm-6 detailed-introduction  ">
                <div class="friendship-link">
                    <div class="box-circle">
                    </div>
                    <span class="frame">手机软件</span>
                </div>
            </div>
            <div class=" col-md-3  col-sm-6 detailed-introduction ">
                <div class="friendship-link">
                    <div class="box-circle">
                    </div>
                    <span class="frame">手机软件</span>
                </div>
            </div>
            <div class=" col-md-3  col-sm-6 detailed-introduction ">
                <div class="friendship-link">
                    <div class="box-circle">
                    </div>
                    <span class="frame">手机软件</span>
                </div>
            </div>
            <div class=" col-md-3  col-sm-6 detailed-introduction  ">
                <div class="friendship-link">
                    <div class="box-circle">
                    </div>
                    <span class="frame">手机软件</span>
                </div>
            </div>
            <div class=" col-md-3  col-sm-6 detailed-introduction ">
                <div class="friendship-link">
                    <div class="box-circle">
                    </div>
                    <span class="frame">手机软件</span>
                </div>
            </div>
            <div class=" col-md-3  col-sm-6 detailed-introduction  ">
                <div class="friendship-link">
                    <div class="box-circle">
                    </div>
                    <span class="frame">手机软件</span>
                </div>
            </div>
            <div class=" col-md-3  col-sm-6 detailed-introduction  ">
                <div class="friendship-link">
                    <div class="box-circle">
                    </div>
                    <span class="frame">手机软件</span>
                </div>
            </div>
            <div class=" col-md-3  col-sm-6 detailed-introduction  ">
                <div class="friendship-link">
                    <div class="box-circle">
                    </div>
                    <span class="frame">手机软件</span>
                </div>
            </div>
        </div>
    </div>
</main>