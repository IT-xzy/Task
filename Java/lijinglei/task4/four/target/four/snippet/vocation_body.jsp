<%--
  Created by IntelliJ IDEA.
  User: ljl
  Date: 2018/7/30
  Time: 21:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<head>
    <link href="/css/t11.css" rel="stylesheet" type="text/css">
</head>

<body>
<div class="container">

    <div class="nav-title">首页&gt;职业</div>
    <div class="nav-bar">
        <span class="">方向：</span>
        <a class="nav-bar-a a-selected" href="">全部</a>
        <a class="nav-bar-a" href="">前端开发</a>
        <a class="nav-bar-a" href="">后端开发</a>
        <a class="nav-bar-a" href="">移动开发</a>
        <a class="nav-bar-a" href="">整站开发</a>
        <a class="nav-bar-a" href="">运营维护</a>
    </div>

    <div class="caption">
        <h4>前端开发方向</h4>
    </div>
    <div class="row">
        <c:forEach var="info" items="${info}">
            <div class="col-md-4 col-sm-6 col-xs-12 top-margin">
                <div class="warp-border">
                    <div class="clearfix">
                        <div class="icon-people"><img src="${info.image}"></div>
                        <div class="text">
                            <h4 class="">${info.jobName}</h4>
                            <p class="text-present">${info.jobDescripe}</p>
                        </div>
                    </div>

                    <div class="warp-class2">
                        <div class="warp-class2-text">
                            <div class="iconfont text-padding">门槛
                                <c:forEach var="i" begin="1" end="${info.threshold}" step="1">
                                    <img src="/images/xx.png">
                                </c:forEach>

                            </div>
                        </div>
                        <div class="warp-class2-text">
                            <div class="iconfont text-padding text-border-left">难易程度
                                <c:forEach var="i" begin="1" end="${info.difficulty}" step="1">
                                    <img src="/images/xx.png">
                                </c:forEach></div>
                        </div>
                    </div>
                    <div class="warp-class2">
                        <div class="warp-class2-text">
                            <div class="iconfont text-padding">成长周期 <span
                                    class="iconfont-color">${info.growthCycle}</span>年
                            </div>
                        </div>
                        <div class="warp-class2-text">
                            <div class="iconfont text-padding text-border-left">稀缺程度 <span
                                    class="iconfont-color">${info.degreeOfScarcity}</span>家公司需要
                            </div>
                        </div>
                    </div>

                    <div class="warp-class2">
                        <div class="leftWarp">
                            薪资待遇
                        </div>
                        <div class="rightWarp">
                            <div class="rightWarp-class">
                                <div class="rightWarp-year">0-1年</div>
                                <div class="rightWarp-wages">${info.treatmentOne}</div>
                            </div>
                            <div class="rightWarp-class">
                                <div class="rightWarp-year">3-5年</div>
                                <div class="rightWarp-wages">${info.treatmentTwo}</div>
                            </div>
                            <div class="rightWarp-class border-bottom">
                                <div class="rightWarp-year">5年以上</div>
                                <div class="rightWarp-wages">${info.treatmentThree}</div>
                            </div>
                        </div>
                    </div>

                    <div class="warp-class2">
                        <b class="text-b">有${info.learningNum}人正在学</b>
                    </div>
                    <div class="warp-class2">
                        <p class="text-p">提示:在你学习之前你应该已经掌握${info.prompt}等语言基础</p>
                    </div>

                    <div class="flip-container">
                        <p class="flip-title">${info.work}</p>
                        <p class="flip-text">${info.workDescripe}</p>
                    </div>
                </div>

            </div>
        </c:forEach>
    </div>

</div>
</body>