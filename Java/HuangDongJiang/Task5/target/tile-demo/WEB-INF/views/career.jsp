<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="ttf" uri="/WEB-INF/tld/timeFormat.tld" %>
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
    <c:forEach begin="0" end="2">
        <div class="caption">
            <h4>前端开发方向</h4>
        </div>

        <div class="row">
            <c:forEach items="${listCareer}" var="career" >
                <div class="col-md-4 col-sm-6 col-xs-12 top-margin">

                    <div class="warp-border">
                        <div class="clearfix">
                            <div class="icon-people"><img src=${career.picture} width="200" height="200"></div>
                            <div class="text">
                                <h4 class="">${career.name}</h4>
                                <p class="text-present">${career.detail}</p>
                            </div>
                        </div>

                        <div class="warp-class2">
                            <div class="warp-class2-text">
                                <div class="iconfont text-padding">门槛<c:forEach begin="0" end="${career.threshold}"><img src="/html2/imges/xx.png"></c:forEach> </div>
                            </div>
                            <div class="warp-class2-text">
                                <div class="iconfont text-padding text-border-left">难易程度<c:forEach begin="0" end="${career.diffcult}"><img src="/html2/imges/xx.png"></c:forEach> </div>
                            </div>
                        </div>
                        <div class="warp-class2">
                            <div class="warp-class2-text">
                                <div class="iconfont text-padding">成长周期 <span class="iconfont-color">${career.growing}</span>年</div>
                            </div>
                            <div class="warp-class2-text">
                                <div class="iconfont text-padding text-border-left">稀缺程度 <span class="iconfont-color">${career.need}</span>家公司需要</div>
                            </div>
                        </div>

                        <div class="warp-class2">
                            <div class="leftWarp">
                                薪资待遇
                            </div>
                            <div class="rightWarp">
                                <div class="rightWarp-class">
                                    <div class="rightWarp-year">${career.years1}</div>
                                    <div class="rightWarp-wages">${career.salary1}</div>
                                </div>
                                <div class="rightWarp-class">
                                    <div class="rightWarp-year">${career.years2}</div>
                                    <div class="rightWarp-wages">${career.salary2}</div>
                                </div>
                                <div class="rightWarp-class border-bottom">
                                    <div class="rightWarp-year">${career.years3}</div>
                                    <div class="rightWarp-wages">${career.salary3}</div>
                                </div>
                            </div>
                        </div>

                        <div class="warp-class2">
                            <b class="text-b">有${career.students_number}人正在学</b>
                        </div>
                        <div class="warp-class2">
                            <p class="text-p">提示:在你学习之前你应该已经掌握XXXXX、XXXXX、XX等语言基础</p>
                        </div>

                        <div class="flip-container">
                            <p class="flip-title">${career.name}</p>
                            <p class="flip-text">${career.detail}</p>
                        </div>
                    </div>

                </div>
            </c:forEach>
        </div>
    </c:forEach>
</div>