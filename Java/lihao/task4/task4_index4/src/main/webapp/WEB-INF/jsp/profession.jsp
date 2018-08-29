<%--
  Created by IntelliJ IDEA.
  User: lihoo
  Date: 2018/8/26
  Time: 9:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"
         pageEncoding="UTF-8" import="java.util.*" %>

<%@ include file="../includes/includes.jsp" %>


<!--main-->
<main>
    <div class="container">
        <!--<h1>real shit!</h1>-->
        <div class="main-home font-size-16">
            <span class="font-weight">首页></span>
            <span class="profess font-weight">职业</span>
        </div>

        <div class="main-type font-size-14 ">
            <span class="direction font-weight">方向：</span>
            <span class="nav-bar-hover">全部</span>
            <span class="nav-bar-hover"><a href="#css-js">前端开发</a></span>
            <span class="nav-bar-hover"><a href="#java-python">后端开发</a></span>
            <span class="nav-bar-hover"><a href="#mobile">移动开发</a></span>
            <span class="nav-bar-hover">整站开发</span>
            <span class="nav-bar-hover"><a href="#OP">运营维护</a></span>
        </div>

        <div class="main-web font-size-16">
            <span class="font-weight"><a id="css-js" href="#">前端开发方向</a></span>
            <!--<span class="profess">职业</span>-->
        </div>
        <div class="row font-size-16">
            <c:forEach items="${selectAll}" var="li">
                <!--一个完整的格子-->
                <div class="big-job-box col-lg-4 col-md-6 col-xs-12">
                    <div class=" main-type-web bgc-white" style="position: relative">
                        <!--第一行-->
                        <div class="main-job-div">
                            <img class=" job-icon fl" src="${pageContext.request.contextPath}/img/jobman.png" alt="">
                            <h4>${li.job}</h4>
                            <p style="padding: 0 32px;">${li.jobInfo}</p>
                        </div>
                        <!--第二行-->
                        <div class="main-difficulty">
                            <div class="main-difficult-left ">
                                <span class="font-gray">门槛</span>
                                <img src="${pageContext.request.contextPath}/img/stars.png" alt="">
                            </div>
                            <div class="main-difficult-right ">
                                <span class="font-gray">难易程度</span>
                                <img src="${pageContext.request.contextPath}/img/stars.png" alt="">
                                <img src="${pageContext.request.contextPath}/img/stars.png" alt="">
                            </div>
                        </div>
                        <!--第三行-->
                        <div class="main-group">
                            <div class="main-group-left ">
                                <span class="font-gray">创建时间：</span>

                                <span class="group-1">
                                    <strong>
                                        <datetag:date value="${li.createAt}"/>
                                        <%--<dsim:date_s value="${li.createAt}" />--%>
                                    </strong>
                                </span>
                            </div>
                            <div class="main-group-right ">
                                <span class="font-gray">更新时间：</span>
                                <span class="group-1">
                                    <strong>
                                        <dsim:date_s value="${li.updateAt}" />
                                    </strong>
                                </span>
                            </div>
                        </div>
                        <!--第四行-->
                        <div class="big-money-box">
                            <div class="main-money">
                                <div class="main-money-title">
                                    <span class="font-gray">薪资待遇</span>
                                </div>
                            </div>
                            <div class="money-tri-box">
                                <div class="money-box">
                                    <span>0-1年</span>
                                    <span class="month-money">${li.salary1}/月</span>
                                </div>
                                <div class="money-box">
                                    <span>1-3年</span>
                                    <span class="month-money">${li.salary2}/月</span>
                                </div>
                                <div class="money-box bottom-box">
                                    <span>3-5年</span>
                                    <span class="month-money">${li.salary3}/月</span>
                                </div>
                            </div>
                        </div>
                        <!--第五行-->
                        <div class="main-study-ing font-size-14">
                            <span>有<strong>${countAll}</strong>人正在学</span>
                        </div>
                        <!--第六行-->
                        <div class="main-bottom-text  font-gray">
                            <span>提示:在你学习之前你应该已经掌握${li.job}等语言基础。</span>
                        </div>
                        <!--上浮文本-->
                        <div class="cover-text" >
                            <h4>IOS开发</h4>
                            <span>${li.hoverInfo}</span>
                        </div>
                    </div>
                </div>
                <!--一个完整的格子-->

            </c:forEach>
        </div>

        <div class="main-web font-size-16">
            <span class="font-weight"><a id="java-python" href="#">后端开发方向</a></span>
            <!--<span class="profess">职业</span>-->
        </div>
        <div class="row font-size-16">
            <c:forEach items="${selectAll}" var="li">
                <!--一个完整的格子-->
                <div class="big-job-box col-lg-4 col-md-6 col-xs-12">
                    <div class=" main-type-web bgc-white" style="position: relative">
                        <!--第一行-->
                        <div class="main-job-div">
                            <img class=" job-icon fl" src="${pageContext.request.contextPath}/img/jobman.png" alt="">
                            <h4>${li.job}</h4>
                            <p style="padding: 0 32px;">${li.jobInfo}</p>
                        </div>
                        <!--第二行-->
                        <div class="main-difficulty">
                            <div class="main-difficult-left ">
                                <span class="font-gray">门槛</span>
                                <img src="${pageContext.request.contextPath}/img/stars.png" alt="">
                            </div>
                            <div class="main-difficult-right ">
                                <span class="font-gray">难易程度</span>
                                <img src="${pageContext.request.contextPath}/img/stars.png" alt="">
                                <img src="${pageContext.request.contextPath}/img/stars.png" alt="">
                            </div>
                        </div>
                        <!--第三行-->
                        <div class="main-group">
                            <div class="main-group-left ">
                                <span class="font-gray">成长周期</span>
                                <span class="group-1"><strong>1-3</strong>年</span>
                            </div>
                            <div class="main-group-right ">
                                <span class="font-gray">稀缺程度</span>
                                <span class="group-1"><strong>345</strong>家公司需要</span>
                            </div>
                        </div>
                        <!--第四行-->
                        <div class="big-money-box">
                            <div class="main-money">
                                <div class="main-money-title">
                                    <span class="font-gray">薪资待遇</span>
                                </div>
                            </div>
                            <div class="money-tri-box">
                                <div class="money-box">
                                    <span>0-1年</span>
                                    <span class="month-money">${li.salary1}/月</span>
                                </div>
                                <div class="money-box">
                                    <span>1-3年</span>
                                    <span class="month-money">${li.salary2}/月</span>
                                </div>
                                <div class="money-box bottom-box">
                                    <span>3-5年</span>
                                    <span class="month-money">${li.salary3}/月</span>
                                </div>
                            </div>
                        </div>
                        <!--第五行-->
                        <div class="main-study-ing font-size-14">
                            <span>有<strong>${countAll}</strong>人正在学</span>
                        </div>
                        <!--第六行-->
                        <div class="main-bottom-text  font-gray">
                            <span>提示:在你学习之前你应该已经掌握${li.job}等语言基础。</span>
                        </div>
                        <!--上浮文本-->
                        <div class="cover-text" >
                            <h4>IOS开发</h4>
                            <span>${li.hoverInfo}</span>
                        </div>
                    </div>
                </div>
                <!--一个完整的格子-->

            </c:forEach>
        </div>

        <div class="main-web font-size-16">
            <span class="font-weight"><a id="OP" href="#">运维方向</a></span>
            <!--<span class="profess">职业</span>-->
        </div>
        <div class="row font-size-16">
            <c:forEach items="${selectAll}" var="li">
                <!--一个完整的格子-->
                <div class="big-job-box col-lg-4 col-md-6 col-xs-12">
                    <div class=" main-type-web bgc-white" style="position: relative">
                        <!--第一行-->
                        <div class="main-job-div">
                            <img class=" job-icon fl" src="${pageContext.request.contextPath}/img/jobman.png" alt="">
                            <h4>${li.job}</h4>
                            <p style="padding: 0 32px;">${li.jobInfo}</p>
                        </div>
                        <!--第二行-->
                        <div class="main-difficulty">
                            <div class="main-difficult-left ">
                                <span class="font-gray">门槛</span>
                                <img src="${pageContext.request.contextPath}/img/stars.png" alt="">
                            </div>
                            <div class="main-difficult-right ">
                                <span class="font-gray">难易程度</span>
                                <img src="${pageContext.request.contextPath}/img/stars.png" alt="">
                                <img src="${pageContext.request.contextPath}/img/stars.png" alt="">
                            </div>
                        </div>
                        <!--第三行-->
                        <div class="main-group">
                            <div class="main-group-left ">
                                <span class="font-gray">成长周期</span>
                                <span class="group-1"><strong>1-3</strong>年</span>
                            </div>
                            <div class="main-group-right ">
                                <span class="font-gray">稀缺程度</span>
                                <span class="group-1"><strong>345</strong>家公司需要</span>
                            </div>
                        </div>
                        <!--第四行-->
                        <div class="big-money-box">
                            <div class="main-money">
                                <div class="main-money-title">
                                    <span class="font-gray">薪资待遇</span>
                                </div>
                            </div>
                            <div class="money-tri-box">
                                <div class="money-box">
                                    <span>0-1年</span>
                                    <span class="month-money">${li.salary1}/月</span>
                                </div>
                                <div class="money-box">
                                    <span>1-3年</span>
                                    <span class="month-money">${li.salary2}/月</span>
                                </div>
                                <div class="money-box bottom-box">
                                    <span>3-5年</span>
                                    <span class="month-money">${li.salary3}/月</span>
                                </div>
                            </div>
                        </div>
                        <!--第五行-->
                        <div class="main-study-ing font-size-14">
                            <span>有<strong>${countAll}</strong>人正在学</span>
                        </div>
                        <!--第六行-->
                        <div class="main-bottom-text  font-gray">
                            <span>提示:在你学习之前你应该已经掌握${li.job}等语言基础。</span>
                        </div>
                        <!--上浮文本-->
                        <div class="cover-text" >
                            <h4>IOS开发</h4>
                            <span>${li.hoverInfo}</span>
                        </div>
                    </div>
                </div>
                <!--一个完整的格子-->

            </c:forEach>
        </div>


        <div class="main-web font-size-16">
            <span class="font-weight"><a id="mobile" href="#">移动方向</a></span>
            <!--<span class="profess">职业</span>-->
        </div>
        <div class="row font-size-16">
            <c:forEach items="${selectAll}" var="li">
                <!--一个完整的格子-->
                <div class="big-job-box col-lg-4 col-md-6 col-xs-12">
                    <div class=" main-type-web bgc-white" style="position: relative">
                        <!--第一行-->
                        <div class="main-job-div">
                            <img class=" job-icon fl" src="${pageContext.request.contextPath}/img/jobman.png" alt="">
                            <h4>${li.job}</h4>
                            <p style="padding: 0 32px;">${li.jobInfo}</p>
                        </div>
                        <!--第二行-->
                        <div class="main-difficulty">
                            <div class="main-difficult-left ">
                                <span class="font-gray">门槛</span>
                                <img src="${pageContext.request.contextPath}/img/stars.png" alt="">
                            </div>
                            <div class="main-difficult-right ">
                                <span class="font-gray">难易程度</span>
                                <img src="${pageContext.request.contextPath}/img/stars.png" alt="">
                                <img src="${pageContext.request.contextPath}/img/stars.png" alt="">
                            </div>
                        </div>
                        <!--第三行-->
                        <div class="main-group">
                            <div class="main-group-left ">
                                <span class="font-gray">成长周期</span>
                                <span class="group-1"><strong>1-3</strong>年</span>
                            </div>
                            <div class="main-group-right ">
                                <span class="font-gray">稀缺程度</span>
                                <span class="group-1"><strong>345</strong>家公司需要</span>
                            </div>
                        </div>
                        <!--第四行-->
                        <div class="big-money-box">
                            <div class="main-money">
                                <div class="main-money-title">
                                    <span class="font-gray">薪资待遇</span>
                                </div>
                            </div>
                            <div class="money-tri-box">
                                <div class="money-box">
                                    <span>0-1年</span>
                                    <span class="month-money">${li.salary1}/月</span>
                                </div>
                                <div class="money-box">
                                    <span>1-3年</span>
                                    <span class="month-money">${li.salary2}/月</span>
                                </div>
                                <div class="money-box bottom-box">
                                    <span>3-5年</span>
                                    <span class="month-money">${li.salary3}/月</span>
                                </div>
                            </div>
                        </div>
                        <!--第五行-->
                        <div class="main-study-ing font-size-14">
                            <span>有<strong>${countAll}</strong>人正在学</span>
                        </div>
                        <!--第六行-->
                        <div class="main-bottom-text  font-gray">
                            <span>提示:在你学习之前你应该已经掌握${li.job}等语言基础。</span>
                        </div>
                        <!--上浮文本-->
                        <div class="cover-text" >
                            <h4>IOS开发</h4>
                            <span>${li.hoverInfo}</span>
                        </div>
                    </div>
                </div>
                <!--一个完整的格子-->

            </c:forEach>
        </div>


    </div>
</main>