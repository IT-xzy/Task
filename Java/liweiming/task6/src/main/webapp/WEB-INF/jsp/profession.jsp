<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
    <div class="row padding-bottom">
        <c:forEach items="${profession}" var="profession" >
            <div class="col-md-4 col-sm-6 col-xs-12 top-margin">
                <div class="warp-border">
                    <div class="clearfix">
                        <div class="icon-people"><img
                                src="${pageContext.request.contextPath }/static/images/687.png">
                        </div>
                        <div class="text">
                            <h4 class="">${profession.proName}</h4>
                            <p class="text-present">
                                ${profession.proIntro}</p>
                        </div>
                    </div>

                    <div class="warp-class2">
                        <div class="warp-class2-text">
                            <div class="iconfont text-padding">门槛 :
                                    <%-- for 循环 --%>
                                <c:forEach begin="1"
                                           end="${profession.proThreshold}"><img
                                        src="${pageContext.request.contextPath }/static/images/xx.png">
                                </c:forEach>
                            </div>
                        </div>
                        <div class="warp-class2-text">
                            <div class="iconfont text-padding text-border-left">
                                难易程度 :
                                    <%-- for 循环 --%>
                                <c:forEach begin="1"
                                           end="${profession.diffLevel}"><img
                                        src="${pageContext.request.contextPath }/static/images/xx.png">
                                </c:forEach>
                            </div>
                        </div>
                    </div>
                    <div class="warp-class2">
                        <div class="warp-class2-text">
                            <div class="iconfont text-padding">成长周期 <span
                                    class="iconfont-color">1-${profession.proCycle}</span>年
                            </div>
                        </div>
                        <div class="warp-class2-text">
                            <div class="iconfont text-padding text-border-left">
                                稀缺程度
                                <span class="iconfont-color">${profession.proFirm}</span>家公司需要
                            </div>
                        </div>
                    </div>

                    <div class="warp-class2">
                        <div class="leftWarp">
                            薪资待遇
                        </div>
                        <div class="rightWarp">
                                <%-- 循环2次--%>
                            <c:set var="proSalary_min" value="${profession.proSalary}"/>
                            <c:set var="proSalary_max" value="${profession.proSalary + 2}"/>

                            <c:forEach var="i" begin="1" end="3" step="1">
                                <div class="rightWarp-class">
                                    <div class="rightWarp-year">${i-1}-${i}年</div>
                                    <div class="rightWarp-wages">
                                            <%-- 自动增长 --%>
                                        <fmt:formatNumber type="number" maxFractionDigits="1" value="${proSalary_min}"/>k-
                                        <fmt:formatNumber type="number" maxFractionDigits="1" value="${proSalary_max}"/>k/月

                                        <c:set var="proSalary_min" value="${proSalary_min * 1.3}"/>
                                        <c:set var="proSalary_max" value="${proSalary_max * 1.5}"/>
                                    </div>
                                </div>
                            </c:forEach>

                        </div>
                    </div>

                    <div class="warp-class2">
                        <b class="text-b">有${profession.proCount}人正在学</b>
                    </div>

                    <div class="warp-class2">
                        <p class="text-p">
                            提示:在你学习之前你应该已经掌握XXXXX、XXXXX、XX等语言基础</p>
                    </div>

                    <div class="flip-container">
                        <p class="flip-title">${profession.proName}</p>
                        <p class="flip-text">${profession.proIntro}</p>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
</div>