<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!--3首页背景-->
<div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
    <!--Indicators -->
    <ol class="carousel-indicators">
        <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
        <li data-target="#carousel-example-generic" data-slide-to="1"></li>
        <li data-target="#carousel-example-generic" data-slide-to="2"></li>
    </ol>

    <!--Wrapper for slides -->
    <div class="carousel-inner" role="listbox">
        <div class="item active">
            <img src="/image/首页背景.png" alt="图裂了">
            <div class="carousel-caption">
                ...
            </div>
        </div>
        <div class="item">
            <img src="/image/首页背景.png" alt="图裂了">
            <div class="carousel-caption">
                ...
            </div>
        </div>
        <div class="item">
            <img src="/image/首页背景.png" alt="图裂了">
            <div class="carousel-caption">
                ...
            </div>
        </div>
    </div>

    <!--Controls -->
    <a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
        <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
        <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
        <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
        <span class="sr-only">Next</span>
    </a>
</div>

<a href="${pageContext.request.contextPath}/info">个人信息</a>&nbsp;&nbsp;
<a href="${pageContext.request.contextPath}/uploadPhoto">上传头像</a>&nbsp;&nbsp;
<a href="${pageContext.request.contextPath}/emailVerifi">邮箱验证</a>
<!--4高效、规范、人脉-->
<main>
    <div class="container-fluid">
        <div class="row">
            <div class="col-md-12 col-lg-12">
                <div class="row">
                    <div class="col-lg-3 col-md-3 col-sm-3">
                        <div class="row4-div1"><img src="/image/rocket.png" class="row4-rocket"></div>
                        <div class="row4-gaoxiao"><b>高效</b></div>
                        <div class=" row4-1">将五到七年的成长时间，缩短到一年到三年。</div>
                    </div>
                    <div class="col-lg-3 col-md-3 col-sm-3">
                        <div class="row4-div1"><img src="/image/archive.png" class="row4-rocket"></div>
                        <div class="row4-gaoxiao"><b>规范</b></div>
                        <div class="row4-1">标准的实战教程，不会走弯路</div>
                    </div>
                    <div class="col-lg-3 col-md-3 col-sm-3">
                        <div class="row4-div1"><img src="/image/shape253.png" class="row4-rocket"></div>
                        <div class="row4-gaoxiao"><b>人脉</b></div>
                        <div class="row4-1">同班好友，同院学长，技术大师，入学就混入职脉圈，为以后铺平道路。
                        </div>
                    </div>
                    <div class="col-lg-3 col-md-3 col-sm-3">
                        <div class="man-number0">
                            <div class="man-number1"><img src="/image/右边小人.png">${totalCount}</div>
                            <div class="man-number2">累计在线学习人数</div>
                            <div class="man-number1"><img src="/image/右边小人.png">${workCount}</div>
                            <div class="man-number2">学员已经找到满意工作</div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!--5如何学习-->
        <div class="row">
            <div class="col-md-12 row-5 row10"><strong>如何学习</strong></div>
        </div>
        <!--6如何学习1-4-->
        <div class="row row6">
            <div class="col-lg-3 col-lg-offset-0 col-md-4 col-sm-4 col-sm-offset-2 col-md-offset-2">
                <div class="how-to-learn">
                    <div class="circle1">1</div>
                    <div class="row7-mid">匹配你现在的个人情况寻找适合自己的岗位</div>
                    <div class="row7-img"><img src="/image/箭头.png"></div>
                </div>
            </div>
            <div class=" col-lg-3 col-md-4 col-sm-4">
                <div class="how-to-learn">
                    <div class="circle1">2</div>
                    <div class="row7-mid">了解职业前景薪金待遇、竞争压力等</div>
                    <div class="row7-img"><img src="/image/箭头.png"></div>
                </div>
            </div>
            <div class="col-lg-3 col-lg-offset-0 col-md-4 col-sm-4 col-sm-offset-2 col-md-offset-2">
                <div class="how-to-learn">
                    <div class="circle1">3</div>
                    <div class="row7-mid">掌握行业内顶级技能&nbsp&nbsp&nbsp</div>
                    <div class="row7-img"><img src="/image/箭头.png"></div>
                </div>
            </div>
            <div class="col-lg-3 col-md-4 col-sm-4">
                <div class="how-to-learn">
                    <div class="circle1">4</div>
                    <div class="row7-mid">查看职业目标任务&nbsp&nbsp&nbsp</div>
                    <div></div>
                </div>
            </div>
        </div>
        <!--7如何学习5-8-->
        <div class="row row6">
            <div class="col-lg-3 col-lg-offset-0 col-md-4 col-sm-4 col-sm-offset-2 col-md-offset-2">
                <div class="how-to-learn">
                    <div class="circle1">5</div>
                    <div class="row7-mid">参考学习资源，掌握技能点，逐个完成任务</div>
                    <div class="row7-img"><img src="/image/箭头.png"></div>
                </div>
            </div>
            <div class="col-lg-3 col-md-4 col-sm-4">
                <div class="how-to-learn">
                    <div class="circle1">6</div>
                    <div class="row7-mid">加入班级，和小伙伴们互帮互助，一块学习</div>
                    <div class="row7-img"><img src="/image/箭头.png"></div>
                </div>
            </div>
            <div class="col-lg-3 col-lg-offset-0 col-md-4 col-sm-4 col-sm-offset-2 col-md-offset-2">
                <div class="how-to-learn">
                    <div class="circle1">7</div>
                    <div class="row7-mid">选择导师，一路引导,&nbsp加速自己成长</div>
                    <div class="row7-img"><img src="/image/箭头.png"></div>
                </div>
            </div>
            <div class="col-lg-3 col-md-4 col-sm-4">
                <div class="how-to-learn">
                    <div class="circle1">8</div>
                    <div class="row7-mid">完成职业技能，升级业界大牛</div>
                    <div></div>
                </div>
            </div>
        </div>
        <!--8优秀学员展示-->
        <div class="row row10">
            <div class="col-md-12 row-8"><strong>优秀学员展示</strong></div>
        </div>
        <!--9优秀学员一览-->
        <div class="row">
            <div class="col-lg-3 col-md-6 col-sm-6 row-9">
                <button type="button" class="row9-button">
                    <img src="/image/照片1.png" class="row9-button-img">
                    <div>技术顾问${list[0].userName}<br></div>
                    <div>${list[0].company}${list[0].post}：${list[0].description}长坂坡在燃烧，我直播砍曹操！</div>
                </button>
            </div>
            <div class="col-lg-3 col-md-6 col-sm-6 row-9">
                <button type="button" class="row9-button">
                    <img src="/image/照片2.png" class="row9-button-img">
                    <div>技术顾问${list[1].userName}<br></div>
                    <div>${list[1].company}${list[1].post}：${list[1].description}乾坤大挪移、九阳真经、圣火令、倚天屠龙</div>
                </button>
            </div>
            <div class="col-lg-3 col-md-6 col-sm-6 row-9">
                <button type="button" class="row9-button">
                    <img src="/image/照片3.png" class="row9-button-img">
                    <div>技术顾问${list[2].userName}<br></div>
                    <div>${list[2].company}${list[2].post}：${list[2].description}女施主，不要啊！</div>
                </button>
            </div>
            <div class="col-lg-3 col-md-6 col-sm-6 row-9">
                <button type="button" class="row9-button">
                    <img src="/image/照片4.png" class="row9-button-img">
                    <div>技术顾问${list[3].userName}<br></div>
                    <div>${list[3].company}${list[3].post}：${list[3].description}</div>
                </button>
            </div>
        </div>
        <div class="row">
            <div class="col-sm-12 col-md-12 col-lg-12">
                <div class="four-shapes"><img src="/image/fourshapes.png"></div>
            </div>
        </div>
        <!--10战略合作企业-->
        <div class="row row10-1">
            <div class="col-md-12"><strong>战略合作企业</strong></div>
        </div>

        <!--11企业图标-->
        <div class="row row11-main">
            <div class="col-lg-2 col-md-2 col-md-offset-0 col-sm-2 col-lg-offset-0 row11">
                <a href="task8-2.html"><button type="button" class="row11-button1"></button></a>
            </div>
            <div class="col-lg-2 col-md-2 col-sm-2 row11">
                <button type="button" class="row11-button2"></button>
            </div>
            <div class="col-lg-2 col-md-2 col-sm-2 row11">
                <button type="button" class="row11-button3"></button>
            </div>
            <div class="col-lg-2 col-md-2 col-sm-2 row11">
                <button type="button" class="row11-button4"></button>
            </div>
            <div class="col-lg-2 col-md-2 col-sm-2 row11">
                <button type="button" class="row11-button5"></button>
            </div>
        </div>
    </div>
</main>
<!--12友情链接-->
<div class="container-fluid friendly-link">
    <div class="row row12">
        <div class="col-md-12">友情链接</div>
    </div>
    <!--13链接清单-->
    <div class="link-list">
        <div class="row row-13">
            <div class="col-md-1 col-sm-1 col-xs-2 col-sm-offset-1 col-xs-offset-1 row13-div">
                <ul>
                    <li><a href="#">•手机软件</a></li>
                    <li><a href="#">•手机软件</a></li>
                </ul>
            </div>
            <div class="col-md-1 col-sm-1 col-xs-2 row13-div">
                <ul>
                    <li><a href="#">•手机软件</a></li>
                    <li><a href="#">•手机软件</a></li>
                </ul>
            </div>
            <div class="col-md-1 col-sm-1 col-xs-2 row13-div">
                <ul>
                    <li><a href="#">•手机软件</a></li>
                    <li><a href="#">•手机软件</a></li>
                </ul>
            </div>
            <div class="col-md-1 col-sm-1 col-xs-2 row13-div">
                <ul>
                    <li><a href="#">•手机软件</a></li>
                    <li><a href="#">•手机软件</a></li>
                </ul>
            </div>
            <div class="col-md-1 col-sm-1 col-xs-2 row13-div">
                <ul>
                    <li><a href="#">•手机软件</a></li>
                    <li><a href="#">•手机软件</a></li>
                </ul>
            </div>
            <div class="col-md-1 col-sm-1 col-xs-2 col-xs-offset-1 row13-div col-sm-offset-0">
                <ul>
                    <li><a href="#">•手机软件</a></li>
                    <li><a href="#">•手机软件</a></li>
                </ul>
            </div>
            <div class="col-md-1 col-sm-1 col-xs-2 row13-div">
                <ul>
                    <li><a href="#">•手机软件</a></li>
                    <li><a href="#">•手机软件</a></li>
                </ul>
            </div>
            <div class="col-md-1 col-sm-1 col-xs-2 row13-div">
                <ul>
                    <li><a href="#">•手机软件</a></li>
                    <li><a href="#">•手机软件</a></li>
                </ul>
            </div>
            <div class="col-md-1 col-sm-1 col-xs-2 row13-div">
                <ul>
                    <li><a href="#">•手机软件</a></li>
                    <li><a href="#">•手机软件</a></li>
                </ul>
            </div>
            <div class="col-md-1 col-sm-1 col-xs-2 row13-div">
                <ul>
                    <li><a href="#">•手机软件</a></li>
                    <li><a href="#">•手机软件</a></li>
                </ul>
            </div>
            <div class="col-md-1"></div>
        </div>
    </div>
</div>

