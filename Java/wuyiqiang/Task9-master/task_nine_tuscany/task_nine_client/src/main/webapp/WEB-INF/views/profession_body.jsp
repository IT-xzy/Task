<%--
  Created by IntelliJ IDEA.
  User: yiqia
  Date: 2018/2/26 0026
  Time: 13:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="container">

    <div class="nav-title">首页&gt;职业</div>
    <div class="nav-bar">
        <span class="">方向：</span>
        <a class="nav-bar-a a-selected" href="/school/profession">全部</a>
        <c:forEach items="${directionCategoryList}" var="item">
            <a class="nav-bar-a" href="#${item}">${item}</a>
        </c:forEach>
    </div>

    <c:forEach items="${directionCategoryList}" var="dcl">

        <div id="${dcl}" class="caption">
            <h4>${dcl}</h4>
        </div>

        <div class="row   <c:if test="${directionCategoryList.get(directionCategoryList.size()-1)==dcl}">padding-bottom</c:if> ">
            <c:forEach items="${professionList}" var="pl">
                <c:if test="${dcl==pl.direction}">
                    <div class="col-md-4 col-sm-6 col-xs-12 top-margin">

                        <div class="warp-border">
                            <div class="clearfix">
                                <div class="icon-people"><img src="/image/${pl.picture}"></div>
                                <div class="text">
                                    <h4 class="">${pl.professionName}</h4>
                                    <p class="text-present">${pl.introduction}</p>
                                </div>
                            </div>

                            <div class="warp-class2">
                                <div class="warp-class2-text">
                                    <div class="iconfont text-padding">门槛 <img src="/image/${pl.threshold}"></div>
                                </div>
                                <div class="warp-class2-text">
                                    <div class="iconfont text-padding text-border-left">难易程度 <img
                                            src="/image/${pl.difficulty}"></div>
                                </div>
                            </div>
                            <div class="warp-class2">
                                <div class="warp-class2-text">
                                    <div class="iconfont text-padding">成长周期 <span
                                            class="iconfont-color">${pl.growth}</span>年
                                    </div>
                                </div>
                                <div class="warp-class2-text">
                                    <div class="iconfont text-padding text-border-left">稀缺程度 <span
                                            class="iconfont-color">${pl.market}</span>家公司需要
                                    </div>
                                </div>
                            </div>

                            <div class="warp-class2">
                                <div class="leftWarp">
                                    薪资待遇
                                </div>
                                <div class="rightWarp">
                                    <c:forEach items="${salaryList}" var="sl">
                                        <c:if test="${sl.id==pl.salary}">
                                            <div class="rightWarp-class">
                                                <div class="rightWarp-year">${sl.timeOne}</div>
                                                <div class="rightWarp-wages">${sl.salaryOne}</div>
                                            </div>
                                            <div class="rightWarp-class">
                                                <div class="rightWarp-year">${sl.timeTwo}</div>
                                                <div class="rightWarp-wages">${sl.salaryTwo}</div>
                                            </div>
                                            <div class="rightWarp-class border-bottom">
                                                <div class="rightWarp-year">${sl.timeThree}</div>
                                                <div class="rightWarp-wages">${sl.salaryThree}</div>
                                            </div>
                                        </c:if>
                                    </c:forEach>
                                </div>
                            </div>

                            <div class="warp-class2">
                                <b class="text-b">有${countStudents[pl.professionName]}人正在学</b>
                            </div>
                            <div class="warp-class2">
                                <p class="text-p">提示:${pl.cue}</p>
                            </div>

                            <div class="flip-container">
                                <p class="flip-title">${pl.professionName}</p>
                                <p class="flip-text">${pl.introductionMore}</p>
                            </div>
                        </div>
                    </div>
                </c:if>
            </c:forEach>
        </div>
    </c:forEach>
</div>
