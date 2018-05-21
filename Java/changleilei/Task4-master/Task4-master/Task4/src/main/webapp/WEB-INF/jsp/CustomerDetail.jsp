<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
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
        <h4>开发方向</h4>
    </div>
    <div class="row">
        <c:forEach var="list" items="${list}">
            <div class="col-md-4 col-sm-6 col-xs-12 top-margin">
                <div class="warp-border">
                    <div class="clearfix">
                        <div class="icon-people"><img src="${ctx}/statics/png/687.png"></div>
                        <div class="text">
                            <h4 class="">${list.occupation}</h4>
                            <p class="text-present">${list.duty}</p>
                        </div>
                    </div>
                    <div class="warp-class2">
                        <div class="warp-class2-text">
                            <div class="iconfont text-padding">门槛：
                                <c:forEach begin="1" end="${list.threshold}">
                                    <img src="${ctx}/statics/png/xx.png">
                                </c:forEach></div>
                        </div>
                        <div class="warp-class2-text">
                            <div class="iconfont text-padding text-border-left">难易程度:
                                <c:forEach begin="1" end="${list.difficultyDegree}">
                                    <img src="${ctx}/statics/png/xx.png">
                                </c:forEach>
                            </div>
                        </div>
                    </div>
                    <div class="warp-class2">
                        <div class="warp-class2-text">
                            <div class="iconfont text-padding">成长周期: ${list.growthCycle}</div>
                        </div>
                        <div class="warp-class2-text">
                            <div class="iconfont text-padding text-border-left">稀缺程度:${list.degreeOfScarcit}</div>
                        </div>
                    </div>
                    <div class="warp-class2">
                        <div class="leftWarp">
                            薪资待遇
                        </div>
                        <div class="rightWarp">
                            <div class="rightWarp-class">
                                <div class="rightWarp-year">0-1年</div>
                                <div class="rightWarp-wages">${list.theMinimumSalary1}/月
                                </div>
                            </div>
                            <div class="rightWarp-class">
                                <div class="rightWarp-year">2-3年</div>
                                <div class="rightWarp-wages">${list.theMinimumSalary3}/月
                                </div>
                            </div>
                            <div class="rightWarp-class border-bottom">
                                <div class="rightWarp-year">3-5年</div>
                                <div class="rightWarp-wages">${list.theMinimumSalary3}/月
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="warp-class2">
                        <b class="text-b"><span class="iconfont-color">${list.inTheNumberOfStudents}</span></b>
                    </div>
                    <div class="warp-class2">
                        <p class="text-p">提示:<span class="iconfont-color">${list.promptStatement}</span></p>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
</div>
</body>
</html>