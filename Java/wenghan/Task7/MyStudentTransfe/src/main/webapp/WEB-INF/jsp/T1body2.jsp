
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="container">
    <div class="caption">
        <h4>前端开发方向</h4>
    </div>
    <div class="row">
        <c:forEach items="${list}" var="c">
        <div class="col-md-4 col-sm-6 col-xs-12 top-margin">
            <div class="warp-border">
                <div class="clearfix">
                    <div class="icon-people"><img src="${pageContext.request.contextPath}/static/image/687.png"></div>
                    <div class="text">
                        <h4 class="">${c.occupationName}</h4>
                        <p class="text-present">${c.careerIntroduction}</p>
                    </div>
                </div>

                <div class="warp-class2">
                    <div class="warp-class2-text">
                        <div class="iconfont text-padding">门槛
                            <c:forEach var="i" begin="1" end="${c.threshold}">
                            <img src="${pageContext.request.contextPath}/static/image/xx.png">
                            </c:forEach>
                        </div>
                    </div>
                    <div class="warp-class2-text">
                        <div class="iconfont text-padding text-border-left">难易程度
                            <c:forEach var="i" begin="1" end="${c.difficultyDegree}">
                            <img src="${pageContext.request.contextPath}/static/image/xx.png">
                            </c:forEach>
                            </div>
                    </div>
                </div>
                <div class="warp-class2">
                    <div class="warp-class2-text">
                        <div class="iconfont text-padding">成长周期 <span class="iconfont-color">${c.growthCycle}</span>年</div>
                    </div>
                    <div class="warp-class2-text">
                        <div class="iconfont text-padding text-border-left">稀缺程度 <span class="iconfont-color">${c.requirement}</span>家公司需要</div>
                    </div>
                </div>

                <div class="warp-class2">
                    <div class="leftWarp">
                        薪资待遇
                    </div>
                    <div class="rightWarp">
                        <div class="rightWarp-class">
                            <div class="rightWarp-year">0-1年</div>
                            <div class="rightWarp-wages">${c.earlySalary}/月</div>
                        </div>
                        <div class="rightWarp-class">
                            <div class="rightWarp-year">1-3年</div>
                            <div class="rightWarp-wages">${c.mediumTermSalary}/月</div>
                        </div>
                        <div class="rightWarp-class border-bottom">
                            <div class="rightWarp-year">3-5年</div>
                            <div class="rightWarp-wages">${c.lateSalary}/月</div>
                        </div>
                    </div>
                </div>

                <div class="warp-class2">
                    <b class="text-b">有${c.studentNumber}人正在学</b>
                </div>
                <div class="warp-class2">
                    <p class="text-p">提示:在你学习之前你应该已经掌握${c.relatedSkills}等语言基础</p>
                </div>

                <div class="flip-container">
                    <p class="flip-title">${c.occupationName}</p>
                    <p class="flip-text">${c.careerIntroduction}</p>
                </div>
            </div>
        </div>
        </c:forEach>
    </div>
</div>