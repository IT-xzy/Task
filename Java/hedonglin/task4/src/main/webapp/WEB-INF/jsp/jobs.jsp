<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Dong
  Date: 2018/2/1
  Time: 23:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


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

<c:forEach var="job" items="${jobList}">
    <div class="col-md-4 col-sm-6 col-xs-12 top-margin">

        <div class="warp-border">
            <div class="clearfix">
                <div class="icon-people"><img src="${pageContext.request.contextPath }/static/imges/687.png"></div>
                <div class="text">
                    <h4 class="">${job.job}</h4>
                    <p class="text-present">${job.jobDescription}</p>
                </div>
            </div>

            <div class="warp-class2">
                <div class="warp-class2-text">
                    <div class="iconfont text-padding">门槛：
                        <c:forEach begin="1" end="${job.entrance}" >
                            <img src="${pageContext.request.contextPath }/static/imges/xx.png">
                        </c:forEach></div>

                </div>
                <div class="warp-class2-text">

                    <div class="iconfont text-padding text-border-left">难易程度:
                        <c:forEach begin="1" end="${job.degreeOfDifficulty}">
                            <img src="${pageContext.request.contextPath }/static/imges/xx.png">
                        </c:forEach> </div>
                </div>
            </div>
            <div class="warp-class2">
                <div class="warp-class2-text">
                    <div class="iconfont text-padding">成长周期: <span class="iconfont-color">${job.learnCycle}</span></div>
                </div>
                <div class="warp-class2-text">
                    <div class="iconfont text-padding text-border-left">稀缺程度: <span class="iconfont-color">${job.rare}</span></div>
                </div>
            </div>

            <div class="warp-class2">
                <div class="leftWarp">
                    薪资待遇
                </div>
                <div class="rightWarp">
                    <div class="rightWarp-class">
                        <div class="rightWarp-year">0-1年</div>
                        <div class="rightWarp-wages">${job.oneYear}</div>
                    </div>
                    <div class="rightWarp-class">
                        <div class="rightWarp-year">2-3年</div>
                        <div class="rightWarp-wages">${job.twoToThreeYear}</div>
                    </div>
                    <div class="rightWarp-class border-bottom">
                        <div class="rightWarp-year">3-5年</div>
                        <div class="rightWarp-wages">${job.threeToFiveYear}</div>
                    </div>
                </div>
            </div>

            <div class="warp-class2">
                <b class="text-b">${job.learningNumber}</b>
            </div>
            <div class="warp-class2">
                <p class="text-p">提示:${job.prompt}</p>
            </div>

        </div>

    </div>
</c:forEach>
</div>
</div>
</body>
</html>