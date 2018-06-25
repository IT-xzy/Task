<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles-extras" prefix="tilesx" %>
<%--核心标签 支持 c:--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--json标签 支持<json:object>--%>
<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>
<%--page 支持EL表达式 ${name}--%>
<%@ page isELIgnored="false" %>
<link rel="stylesheet" href="${pageContext.request.contextPath}/stat/sass/task14-1.css">
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
            <img src="${pageContext.request.contextPath}/stat/images/24-task8.png" alt="First slide">
        </div>
        <div class="item">
            <img src="${pageContext.request.contextPath}/stat/images/24-task8.png" alt="Second slide">
        </div>
        <div class="item">
            <img src="${pageContext.request.contextPath}/stat/images/24-task8.png" alt="Third slide">
        </div>
    </div>
    <!-- 轮播（Carousel）导航 -->
    <a class="carousel-control left" href="#myCarousel"
       data-slide="prev">&lsaquo;</a>
    <a class="carousel-control right" href="#myCarousel"
       data-slide="next">&rsaquo;</a>
</div>
<main>
    <div class="container">
        <div class="row">
            <div class="col-md-3">
                <div class="classify">
                    <div class="brief">
                        <img src="${pageContext.request.contextPath}/stat/images/4-task8.png" class="fire">
                    </div>
                    <p class="name">高效</p>
                    <p class="detail">将五到七年的成长时间,缩短到一年到三年</p>
                </div>
            </div>
            <div class="col-md-3">
                <div class="classify">
                    <div class="brief">
                        <img src="${pageContext.request.contextPath}/stat/images/5-task8.png" class="book">
                    </div>
                    <p class="name">规范</p>
                    <p class="detail">标准的实战教程,不会走弯路</p>
                </div>
            </div>
            <div class="col-md-3">
                <div class="classify">
                    <div class="brief">
                        <img src="${pageContext.request.contextPath}/stat/images/6-task8.png" class="people">
                    </div>
                    <p class="name">人脉</p>
                    <p class="detail">同班好友,同院学长,技术大师,入学就混入职脉圈,为以后铺平道路</p>
                </div>
            </div>
            <div class="col-md-3">
                <div class="forthwith">
                    <div>
                        <div class="study">
                            <div class="online">
                                <img src="${pageContext.request.contextPath}/stat/images/7-task8.png" class="human">
                                12400
                            </div>
                            <p class="state">累计在线学习人数</p>
                        </div>
                        <div class="study">
                            <div class="online">
                                <img src="${pageContext.request.contextPath}/stat/images/7-task8.png" class="human">
                                12400
                            </div>
                            <p class="state">学员已经找到满意工作</p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <p class="way">如何学习</p>
    <div class="container">
        <div class="row">
            <div class="isolate">
                <div class="col-md-3">
                    <div class="introduce">
                        <div class="step">1</div>
                        <p class="minute">匹配你现在的个人情况,寻找适合自己的岗位</p>
                        <img src="${pageContext.request.contextPath}/stat/images/8-task8.png">
                    </div>
                </div>
                <div class="col-md-3">
                    <div class="introduce">
                        <div class="step">2</div>
                        <p class="minute">了解职业前景薪资待遇,竞争压力等</p>
                        <img src="${pageContext.request.contextPath}/stat/images/8-task8.png">
                    </div>
                </div>
                <div class="col-md-3">
                    <div class="introduce">
                        <div class="step">3</div>
                        <p class="minute">掌握行业内顶级技能</p>
                        <img src="${pageContext.request.contextPath}/stat/images/8-task8.png">
                    </div>
                </div>
                <div class="col-md-3">
                    <div class="introduce-right">
                        <div class="step">4</div>
                        <p class="minute">查看职业目标任务</p>
                        <img src="${pageContext.request.contextPath}/stat/images/8-task8.png" class="display-none">
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="container">
        <div class="row">
            <div class="isolate">
                <div class="col-md-3">
                    <div class="introduce">
                        <div class="step">5</div>
                        <p class="minute">参考学习资源,掌握技能点,逐个完成任务</p>
                        <img src="${pageContext.request.contextPath}/stat/images/8-task8.png">
                    </div>
                </div>
                <div class="col-md-3">
                    <div class="introduce">
                        <div class="step">6</div>
                        <p class="minute">加入班级,和小伙伴们互帮互助,一块学习</p>
                        <img src="${pageContext.request.contextPath}/stat/images/8-task8.png">
                    </div>
                </div>
                <div class="col-md-3">
                    <div class="introduce">
                        <div class="step">7</div>
                        <p class="minute">选择导师,一路引导,加速自己成长</p>
                        <img src="${pageContext.request.contextPath}/stat/images/8-task8.png">
                    </div>
                </div>
                <div class="col-md-3">
                    <div class="introduce-right">
                        <div class="step">8</div>
                        <p class="minute">完成职业技能,升级业界大牛</p>
                        <img src="${pageContext.request.contextPath}/stat/images/8-task8.png" class="display-none">
                    </div>
                </div>
            </div>
        </div>
    </div>
    <p class="way">优秀学员展示</p>
    <div class="container">
        <div class="row">
            <c:forEach items="${students}" var="student">
            <div class="col-md-3 col-sm-6 col-xs-12">
                <div class="student">
                    <img src="${pageContext.request.contextPath}/stat/images/9-task8.png" class="portrait">
                    <p class="name">${student.stuName}</p>
                    <p class="detail">${student.school}</p>
                    <p class="detail">${student.recommend}</p>
                </div>
            </div>
            </c:forEach>
        </div>
    </div>
    <div class="choose">
        <div class="page"></div>
        <div class="page"></div>
        <div class="page"></div>
        <div class="page"></div>
    </div>
    <p class="way">战略合作企业</p>
    <div class="container">
        <div class="row">
            <div class="firm">
                <div class="col-md-5 col-sm-05">
                    <div class="alibaba">
                        <img src="${pageContext.request.contextPath}/stat/images/13-task8.png" class="firm-logo">
                    </div>
                </div>
                <div class="col-md-5 col-sm-05">
                    <div class="company">
                        <img src="${pageContext.request.contextPath}/stat/images/14-task8.png" class="firm-logo">
                    </div>
                </div>
                <div class="col-md-5 col-sm-05">
                    <div class="company">
                        <img src="${pageContext.request.contextPath}/stat/images/15-task8.png" class="firm-logo">
                    </div>
                </div>
                <div class="col-md-5 col-sm-05">
                    <div class="company">
                        <img src="${pageContext.request.contextPath}/stat/images/16-task8.png" class="firm-logo">
                    </div>
                </div>
                <div class="col-md-5 col-sm-05">
                    <div class="qiniu">
                        <img src="${pageContext.request.contextPath}/stat/images/17-task8.png" class="firm-logo">
                    </div>
                </div>
            </div>
        </div>
    </div>
</main>