<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Title</title>
    <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <link href="/static/css/task8.3.css" type="text/css" rel="stylesheet"/>
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>

<main>
    <div class="container">
        <div class="row">
            <div class="main-text-text">
                <a class="main-text-text1" href="#">首页</a>
                <span>&ensp;&gt;&ensp;</span>
                <a class="main-text-text2" href="#">合作企业</a>
            </div>
        </div>
        <div class="row">
            <div class="main-text-text">
                <span>方向：</span>
                <a class="main-text-text3" href="#">全部</a>
                <a class="main-text-text3" href="#">前端开发</a>
                <a class="main-text-text3" href="#">后端开发</a>
                <a class="main-text-text3" href="#">移动开发</a>
                <a class="main-text-text3" href="#">整站开发</a>
                <a class="main-text-text3" href="#">运营维护</a>
            </div>
        </div>
        <div class="row">
            <div class="main-text-text">
                <a class="main-text-text1" href="#">前端开发方向</a>
            </div>
        </div>
        <div class="row">
            <c:forEach var="job" items="${jobs}">

            <div class="col-xs-12  col-sm-12 col-md-6">
                <div class="mainbox-box">
                    <div class="mianbox-box1">
                        <div class="mainbox-img"><img src="../../${job.img}" alt="你图炸了"></div>
                        <div  class="mianbox-box1text">
                            <span class="mianbox-box1text1">${job.professionName}</span>
                            <span class="mianbox-box1text2">${job.professionIntroduction}</span>
                        </div>
                    </div>
                    <div class="mianbox-box2">
                        <div class="mianbox-box2icobox"><span class="mianbox-box2icoboxtext">门槛</span><c:forEach begin="1" end="${job.threshold}"> <div class="mianbox-box2ico"></div></c:forEach></div>
                        <div class="mianbox-box2icobox"><span class="mianbox-box2icoboxtext">难易程度</span><c:forEach begin="1" end="${job.complexity}"><div class="mianbox-box2ico"></div><div class="mianbox-box2ico"></div></c:forEach></div>
                    </div>
                    <div class="mianbox-box3">
                        <div class="mianbox-box3icobox"><span class="mianbox-box3icoboxtext1">成长周期</span><span class="mianbox-box3icoboxtext2">${job.growthCycle}</span><span>年</span></div>
                        <div class="mianbox-box3icobox"><span class="mianbox-box3icoboxtext1">稀缺程度</span><span class="mianbox-box3icoboxtext2">${job.scarcityLevel}</span><span>家公司需要</span></div>
                    </div>
                    <div class="mianbox-box4">
                        <div class="mianbox-box4icobox1"><span class="mianbox-box4icobox1text">薪资待遇</span></div>
                        <div class="mianbox-box4icobox2">
                            <div class="mianbox-box4icoboxbox">
                                <div ><span class="mianbox-box4icoboxboxtext">0-1年</span></div><div><span class="mianbox-box4icoboxboxtext">${job.salary}</span></div>
                            </div>
                            <div class="mianbox-box4icoboxbox">
                                <div><span class="mianbox-box4icoboxboxtext">1-3年</span></div><div><span class="mianbox-box4icoboxboxtext">${job.salary}</span></div>
                            </div>
                            <div class="mianbox-box4icoboxbox">
                                <div><span class="mianbox-box4icoboxboxtext">3-5年</span></div><div><span class="mianbox-box4icoboxboxtext">${job.salary}</span></div>
                            </div>
                        </div>
                    </div>
                    <div class="mianbox-box5">
                        <span class="mianbox-box5text1">有</span><span class="mianbox-box5text2">${job.learning}</span><span class="mianbox-box5text1">人正在学</span>
                    </div>
                    <div class="mianbox-box6">
                        <span class="mianbox-box6text">${job.hint}</span>
                    </div>
                </div>
            </div>
            </c:forEach>
        </div>
    </div>
</main>



