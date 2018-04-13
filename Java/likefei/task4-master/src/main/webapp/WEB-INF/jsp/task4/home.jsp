<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="java.util.*"%>
<%@ taglib uri="/tags" prefix="date"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>首页</title>
    <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/task8-1.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/font.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/bootstrap.min.css" >
</head>
<!--轮播图——bootstrap实现-->
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
            <img src="<%=request.getContextPath()%>/image/banner-0.png" alt="First slide">
        </div>
        <div class="item">
            <img src="<%=request.getContextPath()%>/image/banner-1.jpg" alt="Second slide">
        </div>
        <div class="item">
            <img src="<%=request.getContextPath()%>/image/banner-2.jpg" alt="Third slide">
        </div>
    </div>
    <!-- 轮播（Carousel）导航 -->
    <a class="control left2" href="#myCarousel"
       data-slide="prev">&lsaquo;</a>
    <a class="control right2" href="#myCarousel"
       data-slide="next">&rsaquo;</a>
</div>
<!--录播图结束-->
<div style="height: 50px"></div>
<!--修真院优势-->
<div class="container">
    <div class="row">
        <div class="col-xs-12 col-sm-6 col-md-6 col-lg-3 ">
            <div class="body-part1-1">
                <div class="body-part1-1-1">
                    <img src="<%=request.getContextPath()%>/image/img1-5.jpg">
                    <div class="text1">高效</div>
                    <div class="text2" style="color: #999">将五到七年的成长时间缩短为一至三年</div>
                </div>
            </div>
        </div>
        <div class="col-xs-12 col-sm-6 col-md-6 col-lg-3  ">
            <div class="body-part1-1">
                <div class="body-part1-1-1">
                    <img style="margin-bottom:10px " src="<%=request.getContextPath()%>/image/img1-6.jpg">
                    <div class="text1">规范</div>
                    <div class="text2" style="color: #999">标准的实战教程，不会走弯路</div>
                </div>
            </div>
        </div>
        <div class="col-xs-12 col-sm-6 col-md-6 col-lg-3 ">
            <div class="body-part1-1">
                <div class="body-part1-1-1">
                    <img src="<%=request.getContextPath()%>/image/img1-7.jpg">
                    <div class="text1">人脉</div>
                    <div class="text2" style="color: #999">同班好友，同院学长，技术大师，入学就混入职脉圈，为以后铺平道路。</div>
                </div>
            </div>
        </div>
        <div class="col-xs-12 col-sm-6 col-md-6 col-lg-3 ">
            <div class="body-part1-2">
                <div class="body-part1-2-1">
                    <img style="margin-top: 3px" src="<%=request.getContextPath()%>/image/img1-12.png">
                    ${total}
                </div>
                <div class="text3">
                    当前在学人数
                </div>
                <div class="body-part1-2-1">
                    <img style="margin-top: 3px" src="<%=request.getContextPath()%>/image/img1-12.png">
                    ${gtotal}
                </div>
                <div class="text3">
                    毕业学生人数
                </div>
            </div>
        </div>
    </div>
</div>
<div class="body2">
    如何学习
</div>

<div class="container">
    <div class="row">
        <div class="col-xs-12 col-sm-6 col-md-6 col-lg-3  ">
            <div class="howtostudy">
                <div class="circle">
                    1
                </div>
                <div class="text4">
                    匹配你现在的个人情况<br/>
                    学找适合自己的岗位
                </div>
                <img src="<%=request.getContextPath()%>/image/img1-20.png">
            </div>
        </div>
        <div class="col-xs-12 col-sm-6 col-md-6 col-lg-3 ">
            <div class="howtostudy">
                <div class="circle">
                    2
                </div>
                <div class="text4">
                    匹配你现在的个人情况<br/>
                    学找适合自己的岗位
                </div>
                <img src="<%=request.getContextPath()%>/image/img1-20.png">
            </div>
        </div>
        <div class="col-xs-12 col-sm-6 col-md-6 col-lg-3 ">
            <div class="howtostudy">
                <div class="circle">
                    2
                </div>
                <div class="text4">
                    匹配你现在的个人情况<br/>
                    学找适合自己的岗位
                </div>
                <img src="<%=request.getContextPath()%>/image/img1-20.png">
            </div>
        </div>
        <div class="col-xs-12 col-sm-6 col-md-6 col-lg-3 ">
            <div class="howtostudy">
                <div class="circle">
                    4
                </div>
                <div class="text4">
                    匹配你现在的个人情况<br/>
                    学找适合自己的岗位
                </div>
                <img src="<%=request.getContextPath()%>/image/img1-20.png">
            </div>
        </div>
    </div>
</div>

<div style="height: 50px"></div>


<div class="container">
    <div class="row">
        <div class="col-xs-12 col-sm-6 col-md-6 col-lg-3  ">
            <div class="howtostudy">
                <div class="circle">
                    1
                </div>
                <div class="text4">
                    匹配你现在的个人情况<br/>
                    学找适合自己的岗位
                </div>
                <img src="<%=request.getContextPath()%>/image/img1-20.png">
            </div>
        </div>
        <div class="col-xs-12 col-sm-6 col-md-6 col-lg-3 ">
            <div class="howtostudy">
                <div class="circle">
                    2
                </div>
                <div class="text4">
                    匹配你现在的个人情况<br/>
                    学找适合自己的岗位
                </div>
                <img src="<%=request.getContextPath()%>/image/img1-20.png">
            </div>
        </div>
        <div class="col-xs-12 col-sm-6 col-md-6 col-lg-3 ">
            <div class="howtostudy">
                <div class="circle">
                    2
                </div>
                <div class="text4">
                    匹配你现在的个人情况<br/>
                    学找适合自己的岗位
                </div>
                <img src="<%=request.getContextPath()%>/image/img1-20.png">
            </div>
        </div>
        <div class="col-xs-12 col-sm-6 col-md-6 col-lg-3 ">
            <div class="howtostudy">
                <div class="circle">
                    4
                </div>
                <div class="text4">
                    匹配你现在的个人情况<br/>
                    学找适合自己的岗位
                </div>
                <img src="<%=request.getContextPath()%>/image/img1-20.png">
            </div>
        </div>
    </div>
</div>


<div class="body2">
    优秀学员展示
</div>

<div class="container">
    <div class="row">
        <div class="col-xs-12 col-sm-6 col-md-6 col-lg-3 ">
            <div class="body-part3-1">
                <div class="body-part1-1-1">
                    <img src="<%=request.getContextPath()%>/image/img1-9.jpg">
                    <div class="text1"><a href = "http://www.jnshu.com/school/20212/class ">吴艺强</a></div>
                    <div class="text2" style="color: #999">
                        百度技术总监，互联网服务基础领域，
                        从事虚拟主机云服务，域名曾任新网高级技术经理，
                        负责技术研究、团队开发与建设
                    </div>
                </div>
            </div>
        </div>

        <div class="col-xs-12 col-sm-6 col-md-6 col-lg-3 ">
            <div class="body-part3-1">
                <div class="body-part1-1-1">
                    <img src="<%=request.getContextPath()%>/image/img1-8.jpg">
                    <div class="text1">技术顾问：罗大佑</div>
                    <div class="text2" style="color: #999">
                        百度技术总监，互联网服务基础领域，
                        从事虚拟主机云服务，域名曾任新网高级技术经理，
                        负责技术研究、团队开发与建设
                    </div>
                </div>
            </div>
        </div>

        <div class="col-xs-12 col-sm-6 col-md-6 col-lg-3 ">
            <div class="body-part3-1">
                <div class="body-part1-1-1">
                    <img src="<%=request.getContextPath()%>/image/img1-11.jpg">
                    <div class="text1">技术顾问：罗大佑</div>
                    <div class="text2" style="color: #999">
                        百度技术总监，互联网服务基础领域，
                        从事虚拟主机云服务，域名曾任新网高级技术经理，
                        负责技术研究、团队开发与建设
                    </div>
                </div>
            </div>
        </div>

        <div class="col-xs-12 col-sm-6 col-md-6 col-lg-3 ">
            <div class="body-part3-1">
                <div class="body-part1-1-1">
                    <img src="<%=request.getContextPath()%>/image/img1-10.jpg">
                    <div class="text1">技术顾问：罗大佑</div>
                    <div class="text2" style="color: #999">
                        百度技术总监，互联网服务基础领域，
                        从事虚拟主机云服务，域名曾任新网高级技术经理，
                        负责技术研究、团队开发与建设
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<div class="circle4">
    <div class="circle1"></div>
    <div class="circle1"></div>
    <div class="circle1"></div>
    <div class="circle1"></div>
</div>

<div class="body2">
    战略合作企业
</div>


<div class="container">
    <div class="row">
        <div class="col-lg-1"></div>
        <div class="col-lg-2 col-md-6 col-sm-6 col-xs-12">
            <img class="supporter" src="<%=request.getContextPath()%>/image/img1-13.jpg">
        </div>
        <div class="col-lg-2 col-md-6 col-sm-6 col-xs-12">
            <img class="supporter" src="<%=request.getContextPath()%>/image/img1-14.jpg">
        </div>
        <div class="col-lg-2 col-md-6 col-sm-6 col-xs-12">
            <img class="supporter" src="<%=request.getContextPath()%>/image/img1-15.jpg">
        </div>
        <div class="col-lg-2 col-md-6 col-sm-6 col-xs-12">
            <img class="supporter" src="<%=request.getContextPath()%>/image/img1-16.jpg">
        </div>
        <div class="col-lg-2 col-md-6 col-sm-6 col-xs-12">
            <img class="supporter" src="<%=request.getContextPath()%>/image/img1-17.jpg">
        </div>
        <div class="col-lg-1"></div>
    </div>
</div>


<div class="body2">
    友情链接
</div>

<div class="container">
    <div class="row">
        <div class="col-lg-2 col-sm-4 col-xs-6 ">
            <ul>
                <li><a class="mouse">友情链接</a></li>
                <li><a class="mouse">友情链接</a></li>
            </ul>
        </div>
        <div class="col-lg-2 col-sm-4 col-xs-6 ">
            <ul>
                <li><a class="mouse">友情链接</a></li>
                <li><a class="mouse">友情链接</a></li>
            </ul>
        </div>
        <div class="col-lg-2 col-sm-4 col-xs-6 ">
            <ul>
                <li><a class="mouse">友情链接</a></li>
                <li><a class="mouse">友情链接</a></li>
            </ul>
        </div>
        <div class="col-lg-2 col-sm-4 col-xs-6 ">
            <ul>
                <li><a class="mouse">友情链接</a></li>
                <li><a class="mouse">友情链接</a></li>
            </ul>
        </div>
        <div class="col-lg-2 col-sm-4 col-xs-6 ">
            <ul>
                <li><a class="mouse">友情链接</a></li>
                <li><a class="mouse">友情链接</a></li>
            </ul>
        </div>
        <div class="col-lg-2 col-sm-4 col-xs-6 ">
            <ul>
                <li><a class="mouse">友情链接</a></li>
                <li><a class="mouse">友情链接</a></li>
            </ul>
        </div>
    </div>
</div>
</html>