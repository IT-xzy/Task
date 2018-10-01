<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="java.util.*,java.text.*"%>
<%--<main>--%>
    <!--轮播图-->
    <div id="myCarousel" class="carousel slide">
        <!-- 轮播（Carousel）指标 -->
        <%--<ol class="carousel-indicators">--%>
            <%--<li data-target="#myCarousel" data-slide-to="0" class="active"></li>--%>
            <%--<li data-target="#myCarousel" data-slide-to="1"></li>--%>
            <%--<li data-target="#myCarousel" data-slide-to="2"></li>--%>
        <%--</ol>--%>
        <!-- 轮播（Carousel）项目 -->
        <div class="carousel-inner">
            <div class="item active">
                <img src="${pageContext.request.contextPath}/img/other/color.jpg" alt="First slide" class="i-bg">
            </div>
            <%--<div class="item">--%>
                <%--<img src="${pageContext.request.contextPath}/img/首页/bg2.png" alt="Second slide" class="i-bg">--%>
            <%--</div>--%>
            <%--<div class="item">--%>
                <%--<img src="${pageContext.request.contextPath}/img/首页/bg3.jpg" alt="Third slide" class="i-bg">--%>
            <%--</div>--%>
        </div>
        <!-- 轮播（Carousel）导航 -->
        <%--<a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">--%>
            <%--<span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>--%>
            <%--<span class="sr-only">Previous</span>--%>
        <%--</a>--%>
        <%--<a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">--%>
            <%--<span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>--%>
            <%--<span class="sr-only">Next</span>--%>
        <%--</a>--%>
    </div>
    <!--人脉-->
    <div class="container">
        <div class="row first-row">
            <div class="col-md-3 col-sm-6 first-box">
                <div class="imtl-box">
                    <img src="${pageContext.request.contextPath}/img/首页/m-t1.png" class="i-mtl" />
                </div>
                <h3>高效</h3>
                <p>将五到七年的成长时间，缩短到一到三年。</p>
            </div>
            <div class="col-md-3 col-sm-6 first-box">
                <div class="imtl-box">
                    <img src="${pageContext.request.contextPath}/img/首页/m-t2.png" class="i-mtl" />
                </div>
                <h3>规范</h3>
                <p>标准的实战教程，不会走弯路。</p>
            </div>
            <div class="col-md-3 col-sm-6 first-box">
                <div class="imtl-box">
                    <img src="${pageContext.request.contextPath}/img/首页/m-t3.png" class="i-mtl" />
                </div>
                <h3>人脉</h3>
                <p>同班同学，同院学长，技术大师，入学就混入人脉圈，为以后铺平道路。</p>
            </div>
            <div class="col-md-3 col-sm-6 first-box4">
                <div class="box4-in">
                    <span class="color-num"><span class="glyphicon glyphicon-user"></span>&nbsp&nbsp${amount.amountOnline}</span>
                    <p>累计在线学习人数</p>
                    <span class="color-num"><span class="glyphicon glyphicon-user"></span>&nbsp&nbsp${amount.amountGraduation}</span>
                    <p>学员已经找到满意工作</p>
                    <span class="color-num"><span class="glyphicon glyphicon-user">
                    </span>&nbsp&nbsp

                        <%--jsp useBean标签和c标签，fmt标签结合使用--%>
                        <jsp:useBean id="myDate" class="java.util.Date"/>
                        <c:set target="${myDate}" property="time" value="${amount.updateAt}"/>
                        <fmt:formatDate pattern="yyyy-MM-dd hh:mm:ss" value="${myDate}" type="both"/>
                    </span>

                    <p>统计截止日期</p>
                    <%--<% Date date = new Date();   out.print( "<p align=\"center\">" +date.toString()+"</p>");%>--%>
                </div>
            </div>
        </div>
    </div>
    <!--如何学习-->
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <h3>如何学习</h3>
            </div>
            <div class="col-md-3 col-sm-6">
                <div class="second-box">
                    <img src="${pageContext.request.contextPath}/img/首页/num1.png" class="i-mleft" />
                    匹配你现在的个人情况，寻找适合自己的岗位
                    <img src="${pageContext.request.contextPath}/img/首页/m-t5.png" class="i-mright" />
                </div>
            </div>
            <div class="col-md-3 col-sm-6">
                <div class="second-box">
                    <img src="${pageContext.request.contextPath}/img/首页/num2.png" class="i-mleft" />
                    匹配你现在的个人情况，寻找适合自己的岗位
                    <img src="${pageContext.request.contextPath}/img/首页/m-t5.png" class="i-mright" />
                </div>
            </div>
            <div class="col-md-3 col-sm-6">
                <div class="second-box">
                    <img src="${pageContext.request.contextPath}/img/首页/num3.png" class="i-mleft" />
                    匹配你现在的个人情况，寻找适合自己的岗位
                    <img src="${pageContext.request.contextPath}/img/首页/m-t5.png" class="i-mright" />
                </div>
            </div>
            <div class="col-md-3 col-sm-6">
                <div class="second-box">
                    <img src="${pageContext.request.contextPath}/img/首页/num4.png" class="i-mleft" />
                    匹配你现在的个人情况，寻找适合自己的岗位
                    <img src="${pageContext.request.contextPath}/img/首页/m-t5.png" class="i-mright" />
                </div>
            </div>
            <div class="col-md-3 col-sm-6">
                <div class="second-box">
                    <img src="${pageContext.request.contextPath}/img/首页/num5.png" class="i-mleft" />
                    匹配你现在的个人情况，寻找适合自己的岗位
                    <img src="${pageContext.request.contextPath}/img/首页/m-t5.png" class="i-mright" />
                </div>
            </div>
            <div class="col-md-3 col-sm-6">
                <div class="second-box">
                    <img src="${pageContext.request.contextPath}/img/首页/num6.png" class="i-mleft" />
                    匹配你现在的个人情况，寻找适合自己的岗位
                    <img src="${pageContext.request.contextPath}/img/首页/m-t5.png" class="i-mright" />
                </div>
            </div>
            <div class="col-md-3 col-sm-6">
                <div class="second-box">
                    <img src="${pageContext.request.contextPath}/img/首页/num7.png" class="i-mleft" />
                    匹配你现在的个人情况，寻找适合自己的岗位
                    <img src="${pageContext.request.contextPath}/img/首页/m-t5.png" class="i-mright" />
                </div>
            </div>
            <div class="col-md-3 col-sm-6">
                <div class="second-box">
                    <img src="${pageContext.request.contextPath}/img/首页/num8.png" class="i-mleft" />
                    匹配你现在的个人情况，寻找适合自己的岗位
                    <img src="${pageContext.request.contextPath}/img/首页/m-t5.png" class="i-mright" />
                </div>
            </div>
        </div>
    </div>
    <!--优秀学员轮播-->

    <div class="container">
        <div class="row third-row">
            <div class="col-md-12">
                <h3>优秀学员展示</h3>
            </div>
            <div class="col-md-12 thi-box">
                <div id="newmyCarousel" class="carousel slide">
                    <!-- 轮播（Carousel）指标 -->
                    <ol class="carousel-indicators new-carousel-indicators">
                        <li data-target="#newmyCarousel" data-slide-to="0" class="active"></li>
                        <li data-target="#newmyCarousel" data-slide-to="1"></li>
                        <li data-target="#newmyCarousel" data-slide-to="2"></li>
                        <li data-target="#newmyCarousel" data-slide-to="3"></li>
                    </ol>
                    <!-- 轮播（Carousel）项目 -->
                    <div class="carousel-inner">
                        <div class="item active">
                            <div class="col-md-3 col-sm-6">
                                <div class="photo-box">
                                    <img src="${pageContext.request.contextPath}/img/首页/photo1.png" />
                                    <h4>技术顾问：罗大佑</h4>
                                    <p>百度技术总监：互联网基础服务领域，从事虚拟主机、云服务器、域名。曾任新网高级拘束经理，复制技术研发、团队管理与建设。</p>
                                </div>
                            </div>
                            <c:forEach items="${excellent}" var="ex">
                            <div class="col-md-3 col-sm-6">
                                <div class="photo-box">
                                    <img src="${pageContext.request.contextPath}/${ex.excellentImg}" />
                                    <h4>技术顾问：${ex.excellentName}</h4>
                                    <p>${ex.excellentCompany}:${ex.excellentIntro}</p>
                                </div>
                            </div>
                            </c:forEach>
                            <%--<div class="col-md-3 col-sm-6">--%>
                                <%--<div class="photo-box">--%>
                                    <%--<img src="img/首页/photo3.png" />--%>
                                    <%--<h4>技术顾问：罗大佑</h4>--%>
                                    <%--<p>百度技术总监：互联网基础服务领域，从事虚拟主机、云服务器、域名。曾任新网高级拘束经理，复制技术研发、团队管理与建设。</p>--%>
                                <%--</div>--%>
                            <%--</div>--%>
                            <%--<div class="col-md-3 col-sm-6">--%>
                                <%--<div class="photo-box">--%>
                                    <%--<img src="img/首页/photo4.png" />--%>
                                    <%--<h4>技术顾问：罗大佑</h4>--%>
                                    <%--<p>百度技术总监：互联网基础服务领域，从事虚拟主机、云服务器、域名。曾任新网高级拘束经理，复制技术研发、团队管理与建设。</p>--%>
                                <%--</div>--%>
                            <%--</div>--%>
                        <%--</div>--%>
                        <%--<div class="item">--%>
                            <%--<div class="col-md-3 col-sm-6">--%>
                                <%--<div class="photo-box">--%>
                                    <%--<img src="img/首页/photo2.png" />--%>
                                    <%--<h4>技术顾问：罗大佑</h4>--%>
                                    <%--<p>百度技术总监：互联网基础服务领域，从事虚拟主机、云服务器、域名。曾任新网高级拘束经理，复制技术研发、团队管理与建设。</p>--%>
                                <%--</div>--%>
                            <%--</div>--%>
                            <%--<div class="col-md-3 col-sm-6">--%>
                                <%--<div class="photo-box">--%>
                                    <%--<img src="img/首页/photo3.png" />--%>
                                    <%--<h4>技术顾问：罗大佑</h4>--%>
                                    <%--<p>百度技术总监：互联网基础服务领域，从事虚拟主机、云服务器、域名。曾任新网高级拘束经理，复制技术研发、团队管理与建设。</p>--%>
                                <%--</div>--%>
                            <%--</div>--%>
                            <%--<div class="col-md-3 col-sm-6">--%>
                                <%--<div class="photo-box">--%>
                                    <%--<img src="img/首页/photo4.png" />--%>
                                    <%--<h4>技术顾问：罗大佑</h4>--%>
                                    <%--<p>百度技术总监：互联网基础服务领域，从事虚拟主机、云服务器、域名。曾任新网高级拘束经理，复制技术研发、团队管理与建设。</p>--%>
                                <%--</div>--%>
                            <%--</div>--%>
                            <%--<div class="col-md-3 col-sm-6">--%>
                                <%--<div class="photo-box">--%>
                                    <%--<img src="img/首页/photo1.png" />--%>
                                    <%--<h4>技术顾问：罗大佑</h4>--%>
                                    <%--<p>百度技术总监：互联网基础服务领域，从事虚拟主机、云服务器、域名。曾任新网高级拘束经理，复制技术研发、团队管理与建设。</p>--%>
                                <%--</div>--%>
                            <%--</div>--%>
                        <%--</div>--%>
                        <%--<div class="item">--%>
                            <%--<div class="col-md-3 col-sm-6">--%>
                                <%--<div class="photo-box">--%>
                                    <%--<img src="img/首页/photo3.png" />--%>
                                    <%--<h4>技术顾问：罗大佑</h4>--%>
                                    <%--<p>百度技术总监：互联网基础服务领域，从事虚拟主机、云服务器、域名。曾任新网高级拘束经理，复制技术研发、团队管理与建设。</p>--%>
                                <%--</div>--%>
                            <%--</div>--%>
                            <%--<div class="col-md-3 col-sm-6">--%>
                                <%--<div class="photo-box">--%>
                                    <%--<img src="img/首页/photo4.png" />--%>
                                    <%--<h4>技术顾问：罗大佑</h4>--%>
                                    <%--<p>百度技术总监：互联网基础服务领域，从事虚拟主机、云服务器、域名。曾任新网高级拘束经理，复制技术研发、团队管理与建设。</p>--%>
                                <%--</div>--%>
                            <%--</div>--%>
                            <%--<div class="col-md-3 col-sm-6">--%>
                                <%--<div class="photo-box">--%>
                                    <%--<img src="img/首页/photo1.png" />--%>
                                    <%--<h4>技术顾问：罗大佑</h4>--%>
                                    <%--<p>百度技术总监：互联网基础服务领域，从事虚拟主机、云服务器、域名。曾任新网高级拘束经理，复制技术研发、团队管理与建设。</p>--%>
                                <%--</div>--%>
                            <%--</div>--%>
                            <%--<div class="col-md-3 col-sm-6">--%>
                                <%--<div class="photo-box">--%>
                                    <%--<img src="img/首页/photo2.png" />--%>
                                    <%--<h4>技术顾问：罗大佑</h4>--%>
                                    <%--<p>百度技术总监：互联网基础服务领域，从事虚拟主机、云服务器、域名。曾任新网高级拘束经理，复制技术研发、团队管理与建设。</p>--%>
                                <%--</div>--%>
                            <%--</div>--%>
                        <%--</div>--%>
                        <%--<div class="item">--%>
                            <%--<div class="col-md-3 col-sm-6">--%>
                                <%--<div class="photo-box">--%>
                                    <%--<img src="img/首页/photo4.png" />--%>
                                    <%--<h4>技术顾问：罗大佑</h4>--%>
                                    <%--<p>百度技术总监：互联网基础服务领域，从事虚拟主机、云服务器、域名。曾任新网高级拘束经理，复制技术研发、团队管理与建设。</p>--%>
                                <%--</div>--%>
                            <%--</div>--%>
                            <%--<div class="col-md-3 col-sm-6">--%>
                                <%--<div class="photo-box">--%>
                                    <%--<img src="img/首页/photo1.png" />--%>
                                    <%--<h4>技术顾问：罗大佑</h4>--%>
                                    <%--<p>百度技术总监：互联网基础服务领域，从事虚拟主机、云服务器、域名。曾任新网高级拘束经理，复制技术研发、团队管理与建设。</p>--%>
                                <%--</div>--%>
                            <%--</div>--%>
                            <%--<div class="col-md-3 col-sm-6">--%>
                                <%--<div class="photo-box">--%>
                                    <%--<img src="img/首页/photo2.png" />--%>
                                    <%--<h4>技术顾问：罗大佑</h4>--%>
                                    <%--<p>百度技术总监：互联网基础服务领域，从事虚拟主机、云服务器、域名。曾任新网高级拘束经理，复制技术研发、团队管理与建设。</p>--%>
                                <%--</div>--%>
                            <%--</div>--%>
                            <%--<div class="col-md-3 col-sm-6">--%>
                                <%--<div class="photo-box">--%>
                                    <%--<img src="img/首页/photo3.png" />--%>
                                    <%--<h4>技术顾问：罗大佑</h4>--%>
                                    <%--<p>百度技术总监：互联网基础服务领域，从事虚拟主机、云服务器、域名。曾任新网高级拘束经理，复制技术研发、团队管理与建设。</p>--%>
                                <%--</div>--%>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

<!--合作企业-->
    <div class="container">
        <div class="row fourth-row">
            <div class="col-md-12">
                <h3>战略合作企业</h3>
            </div>
            <div class="col-md-2 logo-box">
                <img src="${pageContext.request.contextPath}/img/首页/logo1.png" class="logo" />
            </div>
            <div class="col-md-2 logo-box" >
                <img src="${pageContext.request.contextPath}/img/首页/logo2.png" class="logo" />
            </div>
            <div class="col-md-2 logo-box">
                <img src="${pageContext.request.contextPath}/img/首页/logo3.png" class="logo" />
            </div>
            <div class="col-md-2 logo-box">
                <img src="${pageContext.request.contextPath}/img/首页/logo4.png" class="logo" />
            </div>
            <div class="col-md-2 logo-box">
                <img src="${pageContext.request.contextPath}/img/首页/logo5.png" class="logo" />
            </div>
        </div>
    </div>
    <!--友情链接-->
    <div class="container">
        <div class="row last-row">
            <div class="col-md-12">
                <h3>友情链接</h3>
            </div>
            <div class="col-md-12">
                <a class="link" hred="#">·&nbsp&nbsp手机软件</a>
                <a class="link" hred="#">·&nbsp&nbsp教师招聘</a>
                <a class="link" hred="#">·&nbsp&nbsp找工作</a>
                <a class="link" hred="#">·&nbsp&nbsp手机软件</a>
                <a class="link" hred="#">·&nbsp&nbsp教师招聘</a>
                <a class="link" hred="#">·&nbsp&nbsp找工作</a>
                <a class="link" hred="#">·&nbsp&nbsp手机软件</a>
                <a class="link" hred="#">·&nbsp&nbsp教师招聘</a>
                <a class="link" hred="#">·&nbsp&nbsp找工作</a>
                <a class="link" hred="#">·&nbsp&nbsp手机软件</a>
                <a class="link" hred="#">·&nbsp&nbsp手机软件</a>
                <a class="link" hred="#">·&nbsp&nbsp教师招聘</a>
                <a class="link" hred="#">·&nbsp&nbsp找工作</a>
                <a class="link" hred="#">·&nbsp&nbsp手机软件</a>
                <a class="link" hred="#">·&nbsp&nbsp教师招聘</a>
                <a class="link" hred="#">·&nbsp&nbsp找工作</a>
                <a class="link" hred="#">·&nbsp&nbsp手机软件</a>
                <a class="link" hred="#">·&nbsp&nbsp教师招聘</a>
                <a class="link" hred="#">·&nbsp&nbsp找工作</a>
                <a class="link" hred="#">·&nbsp&nbsp手机软件</a>
            </div>
        </div>
    </div>
<%--</main>--%>

