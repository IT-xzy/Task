<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="/tags" prefix="date" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!--分类数据展示2-->
<div class="container">
    <div class="caption">
        <h4>${frontJobs.get(0).jobCategory}</h4>
    </div>
    <div class="row">
        <c:forEach items="${laterJobs}" var="laterJob">
            <div class="col-md-4 col-sm-6 col-xs-12 top-margin">
                <div class="warp-border">
                    <div class="clearfix">
                        <div class="icon-people"><img
                                src="${pageContext.request.contextPath}/static/imges/${laterJob.jobImage}.png"></div>
                        <div class="text">
                            <h4 class="">${laterJob.jobName}</h4>
                            <p class="text-present">${laterJob.jobIntro}</p>
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
                                <c:forEach var="i" begin="1" end="${laterJob.threshold}">
                                    <img src="${pageContext.request.contextPath}/static/imges/xx.png">
                                </c:forEach>
                            </div>
                        </div>
                    </div>
                    <div class="warp-class2">
                        <div class="warp-class2-text">
                            <div class="iconfont text-padding">成长周期 <span
                                    class="iconfont-color">${laterJob.cycle}</span>年
                            </div>
                        </div>
                        <div class="warp-class2-text">
                            <div class="iconfont text-padding text-border-left">稀缺程度 <span
                                    class="iconfont-color">${laterJob.scarcity}</span>家公司需要
                            </div>
                        </div>
                    </div>
                    <div class="warp-class2">
                        <div class="leftWarp">
                            薪资待遇
                        </div>
                        <div class="rightWarp">
                            <div class="rightWarp-class">
                                <div class="rightWarp-year">${laterJob.term1}</div>
                                <div class="rightWarp-wages">${laterJob.salary1}</div>
                            </div>
                            <div class="rightWarp-class">
                                <div class="rightWarp-year">${laterJob.term2}</div>
                                <div class="rightWarp-wages">${laterJob.salary2}</div>
                            </div>
                            <div class="rightWarp-class border-bottom">
                                <div class="rightWarp-year">${laterJob.term3}</div>
                                <div class="rightWarp-wages">${laterJob.salary3}</div>
                            </div>
                        </div>
                    </div>
                    <div class="warp-class2">
                        <b class="text-b">有${laterJob.atSchool}人正在学 更新时间：<date:date value="${laterJob.updateTime}"/>
                        </b>
                    </div>
                    <div class="warp-class2">
                        <p class="text-p">${laterJob.hint}</p>
                    </div>
                    <div class="flip-container">
                        <p class="flip-title">${laterJob.jobName}</p>
                        <p class="flip-text">${laterJob.jobIntroduce}</p>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
</div>
