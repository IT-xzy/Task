
<%--
  Created by IntelliJ IDEA.
  User: John
  Date: 2018/7/10
  Time: 10:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="date" uri="/tags" %>
<div class="body-center">
    <!--分类部分-->
    <div class="homepage-center">
        <div class="div-homepage">
            <span class="span-homepage">首页></span>
            <span class="span-company">职业</span>
        </div>
    </div>
    <div class="direction">
        <span class="direction_span">方向:</span>
        <a class="direction_a">全部</a>
        <a class="direction_a">前端开发</a>
        <a class="direction_a">后端开发</a>
        <a class="direction_a">移动开发</a>
        <a class="direction_a">整站开发</a>
        <a class="direction_a">运营维护</a>
    </div>
    <!--分类标题-->
    <div class="profession-title">前端开发方向</div>
    <!--详细介绍-->
    <div class="container-fluid">
        <div class="row">
            <c:forEach items="${engineers}" var="engr" varStatus="eng">
            <c:if test="${engr.direction == '前端'}">
            <div class="col-lg-4 col-md-6  col-sm-12">
                <!--网格布局-->
                <div class="grid-padding">
                    <div class="wrapper">
                        <img class="div-background" src="../img/css8/background.png">
                        <div class="item1">
                            <img class="item1_userhead" src="${engr.photo}">
                            <div class="item1_introduce">
                                <div class="introduce_bold">${engr.type}</div>
                                <p class="introduce_text">
                                    <date:formatDate value="${engr.createTime}" pattern="yyyy-MM-dd"/>
                                </p>
                            </div>
                        </div>
                        <div class="item2">
                            <div class="text-gray">
                                门槛
                            </div>
                            <c:forEach begin="1" end="${engr.threshold}">
                            <img class="img-star" src="../img/css8/star.png">
                            </c:forEach>
                        </div>
                        <div class="item3">
                            <div class="text-gray">
                                难易程度
                            </div>
                            <c:forEach begin="1" end="${engr.difficult}">
                            <img class="img-star" src="../img/css8/star.png">
                            </c:forEach>
                        </div>
                        <div class="item4">
                            <div class="text-gray">
                                成长周期
                            </div>
                            <div class="red-number">1-3</div>
                            <div class="text-item4">年</div>
                        </div>
                        <div class="item5">
                            <div class="text-gray">
                                需求
                            </div>
                            <div class="red-number">${engr.demand}</div>
                            <div class="text-item5">家公司需要</div>
                        </div>
                        <div class="item6">
                            <div class="text-gray">
                                薪资待遇
                            </div>
                        </div>
                        <div class="item7">
                            <div class="item-left">0-1年</div>
                            <div class="item-rigt">${engr.oneYear}k-${engr.threeYear}k/月</div>
                        </div>
                        <div class="item8">
                            <div class="item-left">1-3年</div>
                            <div class="item-rigt">${engr.threeYear}k-${engr.fiveYear}k/月</div>
                        </div>
                        <div class="item9">
                            <div class="item-left">3-5年</div>
                            <div class="item-rigt">${engr.fiveYear}k-${engr.tenYear}k/月</div>
                        </div>
                        <div class="item10">
                            <div class="text-bold">有</div>
                            <div class="red-number">${engr.studyNumber}</div>

                            <div class="text-bold-right">人正在学</div>
                        </div>
                        <div class="item11">
                            <div class="text-gray-hidden">
                                提示：在你学习之前你应该掌握语言基础。
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            </c:if>
            </c:forEach>
        </div>
    </div>
    <div class="profession-title">后端开发方向</div>
    <div class="container-fluid">
        <div class="row">
            <c:forEach items="${engineers}" var="engr" varStatus="eng">
                <c:if test="${engr.direction == '后端'}">
                    <div class="col-lg-4 col-md-6  col-sm-12">
                        <!--网格布局-->
                        <div class="grid-padding">
                            <div class="wrapper">
                                <img class="div-background" src="../img/css8/background.png">
                                <div class="item1">
                                    <img class="item1_userhead" src="${engr.photo}">
                                    <div class="item1_introduce">
                                        <div class="introduce_bold">${engr.type}</div>
                                        <p class="introduce_text">
                                            <jsp:useBean id="timestamp" class="java.util.Date"/>
                                            <jsp:setProperty name="timestamp" property="time" value="${engr.createTime}"/>
                                            <fmt:formatDate value="${timestamp}" pattern="yyyy-MM-dd HH:mm"/>
                                        </p>
                                    </div>
                                </div>
                                <div class="item2">
                                    <div class="text-gray">
                                        门槛
                                    </div>
                                    <c:forEach begin="1" end="${engr.threshold}">
                                        <img class="img-star" src="../img/css8/star.png">
                                    </c:forEach>
                                </div>
                                <div class="item3">
                                    <div class="text-gray">
                                        难易程度
                                    </div>
                                    <c:forEach begin="1" end="${engr.difficult}">
                                        <img class="img-star" src="../img/css8/star.png">
                                    </c:forEach>
                                </div>
                                <div class="item4">
                                    <div class="text-gray">
                                        成长周期
                                    </div>
                                    <div class="red-number">1-3</div>
                                    <div class="text-item4">年</div>
                                </div>
                                <div class="item5">
                                    <div class="text-gray">
                                        需求
                                    </div>
                                    <div class="red-number">${engr.demand}</div>
                                    <div class="text-item5">家公司需要</div>
                                </div>
                                <div class="item6">
                                    <div class="text-gray">
                                        薪资待遇
                                    </div>
                                </div>
                                <div class="item7">
                                    <div class="item-left">0-1年</div>
                                    <div class="item-rigt">${engr.oneYear}k-${engr.threeYear}k/月</div>
                                </div>
                                <div class="item8">
                                    <div class="item-left">1-3年</div>
                                    <div class="item-rigt">${engr.threeYear}k-${engr.fiveYear}k/月</div>
                                </div>
                                <div class="item9">
                                    <div class="item-left">3-5年</div>
                                    <div class="item-rigt">${engr.fiveYear}k-${engr.tenYear}k/月</div>
                                </div>
                                <div class="item10">
                                    <div class="text-bold">有</div>
                                    <div class="red-number">${engr.studyNumber}</div>

                                    <div class="text-bold-right">人正在学</div>
                                </div>
                                <div class="item11">
                                    <div class="text-gray-hidden">
                                        提示：在你学习之前你应该掌握语言基础。
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </c:if>
            </c:forEach>
        </div>
    </div>
    <div class="profession-title">运维方向</div>
    <div class="container-fluid">
        <div class="row">
            <c:forEach items="${engineers}" var="engr" varStatus="eng">
                <c:if test="${engr.direction == '运维'}">
                    <div class="col-lg-4 col-md-6  col-sm-12">
                        <!--网格布局-->
                        <div class="grid-padding">
                            <div class="wrapper">
                                <img class="div-background" src="../img/css8/background.png">
                                <div class="item1">
                                    <img class="item1_userhead" src="${engr.photo}">
                                    <div class="item1_introduce">
                                        <div class="introduce_bold">${engr.type}</div>
                                        <p class="introduce_text">
                                            <date:formatDate value="${engr.createTime}" pattern="yyyy-MM-dd"/>
                                        </p>
                                    </div>
                                </div>
                                <div class="item2">
                                    <div class="text-gray">
                                        门槛
                                    </div>
                                    <c:forEach begin="1" end="${engr.threshold}">
                                        <img class="img-star" src="../img/css8/star.png">
                                    </c:forEach>
                                </div>
                                <div class="item3">
                                    <div class="text-gray">
                                        难易程度
                                    </div>
                                    <c:forEach begin="1" end="${engr.difficult}">
                                        <img class="img-star" src="../img/css8/star.png">
                                    </c:forEach>
                                </div>
                                <div class="item4">
                                    <div class="text-gray">
                                        成长周期
                                    </div>
                                    <div class="red-number">1-3</div>
                                    <div class="text-item4">年</div>
                                </div>
                                <div class="item5">
                                    <div class="text-gray">
                                        需求
                                    </div>
                                    <div class="red-number">${engr.demand}</div>
                                    <div class="text-item5">家公司需要</div>
                                </div>
                                <div class="item6">
                                    <div class="text-gray">
                                        薪资待遇
                                    </div>
                                </div>
                                <div class="item7">
                                    <div class="item-left">0-1年</div>
                                    <div class="item-rigt">${engr.oneYear}k-${engr.threeYear}k/月</div>
                                </div>
                                <div class="item8">
                                    <div class="item-left">1-3年</div>
                                    <div class="item-rigt">${engr.threeYear}k-${engr.fiveYear}k/月</div>
                                </div>
                                <div class="item9">
                                    <div class="item-left">3-5年</div>
                                    <div class="item-rigt">${engr.fiveYear}k-${engr.tenYear}k/月</div>
                                </div>
                                <div class="item10">
                                    <div class="text-bold">有</div>
                                    <div class="red-number">${engr.studyNumber}</div>

                                    <div class="text-bold-right">人正在学</div>
                                </div>
                                <div class="item11">
                                    <div class="text-gray-hidden">
                                        提示：在你学习之前你应该掌握语言基础。
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </c:if>
            </c:forEach>
        </div>
    </div>
    <div class="profession-title">产品方向</div>
    <div class="container-fluid">
        <div class="row">
            <c:forEach items="${engineers}" var="engr" varStatus="eng">
                <c:if test="${engr.direction == '产品'}">
                    <div class="col-lg-4 col-md-6  col-sm-12">
                        <!--网格布局-->
                        <div class="grid-padding">
                            <div class="wrapper">
                                <img class="div-background" src="../img/css8/background.png">
                                <div class="item1">
                                    <img class="item1_userhead" src="${engr.photo}">
                                    <div class="item1_introduce">
                                        <div class="introduce_bold">${engr.type}</div>
                                        <p class="introduce_text">
                                            <date:formatDate value="${engr.createTime}" pattern="yyyy-MM-dd"/>
                                        </p>
                                    </div>
                                </div>
                                <div class="item2">
                                    <div class="text-gray">
                                        门槛
                                    </div>
                                    <c:forEach begin="1" end="${engr.threshold}">
                                        <img class="img-star" src="../img/css8/star.png">
                                    </c:forEach>
                                </div>
                                <div class="item3">
                                    <div class="text-gray">
                                        难易程度
                                    </div>
                                    <c:forEach begin="1" end="${engr.difficult}">
                                        <img class="img-star" src="../img/css8/star.png">
                                    </c:forEach>
                                </div>
                                <div class="item4">
                                    <div class="text-gray">
                                        成长周期
                                    </div>
                                    <div class="red-number">1-3</div>
                                    <div class="text-item4">年</div>
                                </div>
                                <div class="item5">
                                    <div class="text-gray">
                                        需求
                                    </div>
                                    <div class="red-number">${engr.demand}</div>
                                    <div class="text-item5">家公司需要</div>
                                </div>
                                <div class="item6">
                                    <div class="text-gray">
                                        薪资待遇
                                    </div>
                                </div>
                                <div class="item7">
                                    <div class="item-left">0-1年</div>
                                    <div class="item-rigt">${engr.oneYear}k-${engr.threeYear}k/月</div>
                                </div>
                                <div class="item8">
                                    <div class="item-left">1-3年</div>
                                    <div class="item-rigt">${engr.threeYear}k-${engr.fiveYear}k/月</div>
                                </div>
                                <div class="item9">
                                    <div class="item-left">3-5年</div>
                                    <div class="item-rigt">${engr.fiveYear}k-${engr.tenYear}k/月</div>
                                </div>
                                <div class="item10">
                                    <div class="text-bold">有</div>
                                    <div class="red-number">${engr.studyNumber}</div>

                                    <div class="text-bold-right">人正在学</div>
                                </div>
                                <div class="item11">
                                    <div class="text-gray-hidden">
                                        提示：在你学习之前你应该掌握语言基础。
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </c:if>
            </c:forEach>
        </div>
    </div>
</div>