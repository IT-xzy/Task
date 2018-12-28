<%--
  Created by IntelliJ IDEA.
  User: luojiac
  Date: 2018/5/1
  Time: 下午9:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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



    <c:forEach items="${lists}" var="list">
    <div class="caption">
        <h4>${list.job}开发方向</h4>
    </div>

    <div class="row">
        <div class="col-md-4 col-sm-6 col-xs-12 top-margin">

            <div class="warp-border">
                <div class="clearfix">
                    <div class="icon-people"><img src="imges/687.png"></div>
                    <div class="text">
                        <h4 class="">${list.job}</h4>
                        <p class="text-present">${list.introduce}</p>
                    </div>
                </div>

                <div class="warp-class2">
                    <div class="warp-class2-text">
                        <div class="iconfont text-padding">门槛
                            <c:forEach begin="1" end="${list.threshold}" step="1">
                            <img src="imges/xx.png">
                            </c:forEach>
                        </div>
                    </div>
                    <div class="warp-class2-text">
                        <div class="iconfont text-padding text-border-left">难易程度
                            <c:forEach begin="1" end="${list.degree_of_difficulty}" step="1">
                            <img src="imges/xx.png">
                            </c:forEach>
                        </div>
                    </div>
                </div>
                <div class="warp-class2">
                    <div class="warp-class2-text">
                        <div class="iconfont text-padding">成长周期 <span class="iconfont-color">1-${list.grow_year}</span>年</div>
                    </div>
                    <div class="warp-class2-text">
                        <div class="iconfont text-padding text-border-left">稀缺程度 <span class="iconfont-color">${list.need}</span>家公司需要</div>
                    </div>
                </div>

                <div class="warp-class2">
                    <div class="leftWarp">
                        薪资待遇
                    </div>
                    <div class="rightWarp">
                        <div class="rightWarp-class">
                            <div class="rightWarp-year">0-1年</div>
                            <div class="rightWarp-wages">5k-10k/月</div>
                        </div>
                        <div class="rightWarp-class">
                            <div class="rightWarp-year">0-1年</div>
                            <div class="rightWarp-wages">5k-10k/月</div>
                        </div>
                        <div class="rightWarp-class border-bottom">
                            <div class="rightWarp-year">0-1年</div>
                            <div class="rightWarp-wages">5k-10k/月</div>
                        </div>
                    </div>
                </div>

                <div class="warp-class2">
                    <b class="text-b">有${list.threshold}人正在学</b>
                </div>
                <div class="warp-class2">
                    <p class="text-p">提示:${list.need_know}</p>
                </div>

                <div class="flip-container">
                    <p class="flip-title">${list.job}工程师</p>
                    <p class="flip-text">${list.detailed}</p>
                </div>

            </div>

        </div>

            </div>
    </c:forEach>
        </div>

    </div>
</div>