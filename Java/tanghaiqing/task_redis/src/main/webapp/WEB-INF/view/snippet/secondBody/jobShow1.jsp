<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="/tags" prefix="date" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!--分类数据展示1-->
<div class="container">
<div class="caption">
    <h4>${frontJobs.get(0).jobCategory}</h4>
</div>
<div class="row">
    <c:forEach items="${frontJobs}" var="frontJob">
        <div class="col-md-4 col-sm-6 col-xs-12 top-margin">
            <div class="warp-border">
                <div class="clearfix">
                    <div class="icon-people"><img
                            src="${pageContext.request.contextPath}/static/imges/${frontJob.jobImage}.png"></div>
                    <div class="text">
                        <h4 class="">${frontJob.jobName}</h4>
                        <p class="text-present">${frontJob.jobIntro}</p>
                    </div>
                </div>
                <div class="warp-class2">
                    <div class="warp-class2-text">
                        <div class="iconfont text-padding">门槛
                            <c:forEach var="i" begin="1" end="1">
                                <img src="${pageContext.request.contextPath}/static/imges/xx.png">
                            </c:forEach>
                        </div>
                    </div>
                    <div class="warp-class2-text">
                        <div class="iconfont text-padding text-border-left">难易程度
                            <c:forEach var="i" begin="1" end="${frontJob.threshold}">
                                <img src="${pageContext.request.contextPath}/static/imges/xx.png">
                            </c:forEach>
                        </div>
                    </div>
                </div>
                <div class="warp-class2">
                    <div class="warp-class2-text">
                        <div class="iconfont text-padding">成长周期 <span
                                class="iconfont-color">${frontJob.cycle}</span>年
                        </div>
                    </div>
                    <div class="warp-class2-text">
                        <div class="iconfont text-padding text-border-left">稀缺程度 <span
                                class="iconfont-color">${frontJob.scarcity}</span>家公司需要
                        </div>
                    </div>
                </div>
                <div class="warp-class2">
                    <div class="leftWarp">
                        薪资待遇
                    </div>
                    <div class="rightWarp">
                        <div class="rightWarp-class">
                            <div class="rightWarp-year">${frontJob.term1}</div>
                            <div class="rightWarp-wages">${frontJob.salary1}</div>
                        </div>
                        <div class="rightWarp-class">
                            <div class="rightWarp-year">${frontJob.term2}</div>
                            <div class="rightWarp-wages">${frontJob.salary2}</div>
                        </div>
                        <div class="rightWarp-class border-bottom">
                            <div class="rightWarp-year">${frontJob.term3}</div>
                            <div class="rightWarp-wages">${frontJob.salary3}</div>
                        </div>
                    </div>
                </div>
                <div class="warp-class2">
                    <b class="text-b">有${frontJob.atSchool}人正在学 更新时间：<date:date value="${frontJob.updateTime}"/>
                    </b>
                </div>
                <div class="warp-class2">
                    <p class="text-p">${frontJob.hint}</p>
                </div>
                <div class="flip-container">
                    <p class="flip-title">${frontJob.jobName}</p>
                    <p class="flip-text">${frontJob.jobIntroduce}</p>
                </div>
            </div>
        </div>
    </c:forEach>
</div>
</div>
