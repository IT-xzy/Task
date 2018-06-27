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

    <div class="row">
        <c:forEach items="${pro}" var="d">
            <div class="col-md-4 col-sm-6 col-xs-12 top-margin">

                <div class="warp-border">
                    <div class="clearfix">
                        <div class="icon-people"><img src="${pageContext.request.contextPath }/static/images/${d.picture_tx}"></div>
                        <div class="text">
                            <h4 class="">${d.name}</h4>
                            <p class="text-present">${d.pro_js}</p>
                        </div>
                    </div>

                    <div class="warp-class2">
                        <div class="warp-class2-text">
                            <div class="iconfont text-padding">门槛 <img src="${pageContext.request.contextPath}/static/images/xx.png"></div>
                        </div>
                        <div class="warp-class2-text">
                            <div class="iconfont text-padding text-border-left">难易程度 <img src="${pageContext.request.contextPath}/static/images/xx.png"><img
                                    src="${pageContext.request.contextPath}/static/images/xx.png"></div>
                        </div>
                    </div>
                    <div class="warp-class2">
                        <div class="warp-class2-text">
                            <div class="iconfont text-padding">成长周期 <span class="iconfont-color">1-3</span>年</div>
                        </div>
                        <div class="warp-class2-text">
                            <div class="iconfont text-padding text-border-left">稀缺程度 <span class="iconfont-color">${d.proCompany}</span>家公司需要
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
                                <div class="rightWarp-wages">5k-10k/月</div>
                            </div>
                            <div class="rightWarp-class">
                                <div class="rightWarp-year">2-3年</div>
                                <div class="rightWarp-wages">10k-20k/月</div>
                            </div>
                            <div class="rightWarp-class border-bottom">
                                <div class="rightWarp-year">3-5年</div>
                                <div class="rightWarp-wages">30k-45k/月</div>
                            </div>
                        </div>
                    </div>

                    <div class="warp-class2">
                        <b class="text-b">有${d.pro_zx}人正在学</b>
                    </div>
                    <div class="warp-class2">
                        <p class="text-p">提示:在你学习之前你应该已经掌握XXXXX、XXXXX、XX等语言基础</p>
                    </div>

                    <div class="flip-container">
                        <p class="flip-title">${d.pro_ts}</p>
                        <p class="flip-text">${d.useryq}</p>
                    </div>
                </div>

            </div>
        </c:forEach>
    </div>

    <div class="caption">
        <h4>移动开发</h4>
    </div>

    <div class="row">
        <c:forEach items="${pro}" var="d">
            <div class="col-md-4 col-sm-6 col-xs-12 top-margin">

                <div class="warp-border">
                    <div class="clearfix">
                        <div class="icon-people"><img src="static/images/${d.picture_tx}"></div>
                        <div class="text">
                            <h4 class="">${d.name}</h4>
                            <p class="text-present">${d.pro_js}</p>
                        </div>
                    </div>

                    <div class="warp-class2">
                        <div class="warp-class2-text">
                            <div class="iconfont text-padding">门槛 <img src="${pageContext.request.contextPath}/static/images/xx.png"></div>
                        </div>
                        <div class="warp-class2-text">
                            <div class="iconfont text-padding text-border-left">难易程度 <img src="${pageContext.request.contextPath}/static/images/xx.png"><img
                                    src="${pageContext.request.contextPath}/static/images/xx.png"></div>
                        </div>
                    </div>
                    <div class="warp-class2">
                        <div class="warp-class2-text">
                            <div class="iconfont text-padding">成长周期 <span class="iconfont-color">1-3</span>年</div>
                        </div>
                        <div class="warp-class2-text">
                            <div class="iconfont text-padding text-border-left">稀缺程度 <span class="iconfont-color">${d.proCompany}</span>家公司需要
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
                                <div class="rightWarp-wages">5k-10k/月</div>
                            </div>
                            <div class="rightWarp-class">
                                <div class="rightWarp-year">2-3年</div>
                                <div class="rightWarp-wages">10k-20k/月</div>
                            </div>
                            <div class="rightWarp-class border-bottom">
                                <div class="rightWarp-year">3-5年</div>
                                <div class="rightWarp-wages">30k-45k/月</div>
                            </div>
                        </div>
                    </div>

                    <div class="warp-class2">
                        <b class="text-b">有${d.pro_zx}人正在学</b>
                    </div>
                    <div class="warp-class2">
                        <p class="text-p">提示:在你学习之前你应该已经掌握XXXXX、XXXXX、XX等语言基础</p>
                    </div>

                    <div class="flip-container">
                        <p class="flip-title">${d.pro_ts}</p>
                        <p class="flip-text">${d.useryq}</p>
                    </div>
                </div>

            </div>
        </c:forEach>
    </div>

    <div class="caption">
        <h4>后端开发方向</h4>
    </div>

    <div class="row">
        <c:forEach items="${pro}" var="d">
            <div class="col-md-4 col-sm-6 col-xs-12 top-margin">

                <div class="warp-border">
                    <div class="clearfix">
                        <div class="icon-people"><img src="/static/images/${d.picture_tx}"></div>
                        <div class="text">
                            <h4 class="">${d.name}</h4>
                            <p class="text-present">${d.pro_js}</p>
                        </div>
                    </div>

                    <div class="warp-class2">
                        <div class="warp-class2-text">
                            <div class="iconfont text-padding">门槛 <img src="${pageContext.request.contextPath}/static/images/xx.png"></div>
                        </div>
                        <div class="warp-class2-text">
                            <div class="iconfont text-padding text-border-left">难易程度 <img src="${pageContext.request.contextPath}/static/images/xx.png"><img
                                    src="${pageContext.request.contextPath}/static/images/xx.png"></div>
                        </div>
                    </div>
                    <div class="warp-class2">
                        <div class="warp-class2-text">
                            <div class="iconfont text-padding">成长周期 <span class="iconfont-color">1-3</span>年</div>
                        </div>
                        <div class="warp-class2-text">
                            <div class="iconfont text-padding text-border-left">稀缺程度 <span class="iconfont-color">${d.proCompany}</span>家公司需要
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
                                <div class="rightWarp-wages">5k-10k/月</div>
                            </div>
                            <div class="rightWarp-class">
                                <div class="rightWarp-year">2-3年</div>
                                <div class="rightWarp-wages">10k-20k/月</div>
                            </div>
                            <div class="rightWarp-class border-bottom">
                                <div class="rightWarp-year">3-5年</div>
                                <div class="rightWarp-wages">30k-45k/月</div>
                            </div>
                        </div>
                    </div>

                    <div class="warp-class2">
                        <b class="text-b">有${d.pro_zx}人正在学</b>
                    </div>
                    <div class="warp-class2">
                        <p class="text-p">提示:在你学习之前你应该已经掌握XXXXX、XXXXX、XX等语言基础</p>
                    </div>

                    <div class="flip-container">
                        <p class="flip-title">${d.pro_ts}</p>
                        <p class="flip-text">${d.useryq}</p>
                    </div>
                </div>

            </div>
        </c:forEach>
    </div>

</div>



    <%--<div class="nav-title">首页&gt;职业</div>
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
        <c:forEach items="${pro}" var="profession">
            <div class="col-md-4 col-sm-6 col-xs-12 top-margin">
                <div class="warp-border">
                    <div class="clearfix">
                        <div class="icon-people"><img
                                src="${pageContext.request.contextPath }/static/images/687.png">
                        </div>
                        <div class="text">
                            <h4 class="">${profession.name}</h4>
                            <p class="text-present">
                                    ${profession.name}</p>
                        </div>
                    </div>

                    <div class="warp-class2">
                        <div class="warp-class2-text">
                            <div class="iconfont text-padding">门槛 :
                                &lt;%&ndash; for 循环 &ndash;%&gt;
                                <c:forEach begin="1"
                                           end="${profession.proDifficulty}"><img
                                        src="${pageContext.request.contextPath }/static/images/xx.png"></c:forEach>
                            </div>
                        </div>
                        <div class="warp-class2-text">
                            <div class="iconfont text-padding text-border-left">
                                难易程度 :
                                    &lt;%&ndash; for 循环 &ndash;%&gt;
                                <c:forEach begin="1"
                                           end="${profession.proThreshold}"><img
                                        src="${pageContext.request.contextPath }/static/images/xx.png"></c:forEach>
                            </div>
                        </div>
                    </div>
                    <div class="warp-class2">
                        <div class="warp-class2-text">
                            <div class="iconfont text-padding">成长周期 <span
                                    class="iconfont-color">1-3</span>年
                            </div>
                        </div>
                        <div class="warp-class2-text">
                            <div class="iconfont text-padding text-border-left">
                                稀缺程度
                                <span class="iconfont-color">${profession.proCompany}</span>家公司需要
                            </div>
                        </div>
                    </div>

                    <div class="warp-class2">
                        <div class="leftWarp">
                            薪资待遇
                        </div>
                        <div class="rightWarp">
                                &lt;%&ndash; 循环3次 工资每年涨30%&ndash;%&gt;
                            <c:set var="proSalary_min"
                                   value="${profession.proSalary_min}"/>
                            <c:set var="proSalary_max"
                                   value="${profession.proSalary_max}"/>
                            <c:forEach var="i" begin="1" end="3" step="1">
                                <div class="rightWarp-class">
                                    <div class="rightWarp-year">${i-1}-${i}年</div>
                                    <div class="rightWarp-wages">
                                            &lt;%&ndash; 自动增长 &ndash;%&gt;
                                        <c:set var="proSalary_min"
                                               value="${proSalary_min * 1.3}"/>
                                        <c:set var="proSalary_max"
                                               value="${proSalary_max * 1.3}"/>

                                        <fmt:formatNumber type="number"
                                                          value="${proSalary_min}"
                                                          maxFractionDigits="2"/>k-<fmt:formatNumber
                                            type="number"
                                            value="${proSalary_max}"
                                            maxFractionDigits="2"/>k/月
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
                        <p class="flip-text">${profession.proIntroduction}</p>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
</div>--%>