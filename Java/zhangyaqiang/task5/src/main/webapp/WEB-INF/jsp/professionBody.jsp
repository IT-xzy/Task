<%--
  Created by IntelliJ IDEA.
  User: zyq
  Date: 2018/8/21
  Time: 17:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/tags" prefix="date"%>
<html>
<head>
    <title>职业推荐</title>
</head>
<body>
<!--主体部分-->
<div class="body-center">
    <!--分类部分-->
    <div class="homepage-center">
        <div class="div-homepage">
            <span class="span-homepage"><a href="/index">首页></a></span>
            <span class="span-company"><a href="/profession">职业</a></span>
        </div>
    </div>
    <div class="direction">
        <span class="direction_span">方向:</span>
        <a class="direction_a" href="#front">前端开发</a>
        <a class="direction_a" href="#back">后端开发</a>
        <a class="direction_a" href="#running">运营维护</a>
    </div>

    <!--分类标题-->
     <div class="profession-title" id="front">前端开发方向</div>
         <!--详细介绍-->
    <div class="container-fluid">
        <div class="row">
  <c:forEach items="${list}" var="profession">
    <c:if test="${profession.developmentDirection=='前端开发方向'}">
        <div class="col-lg-4 col-md-6  col-sm-12">
            <!--网格布局-->
            <div class="grid-padding">
                <div class="wrapper">
                    <img class="div-background" src="../img/css8/background.png">
                    <div class="item1">
                        <img class="item1_userhead" src="${profession.img}">
                        <div class="item1_introduce">
                            <div class="introduce_bold">${profession.professionName}</div>
                            <p class="introduce_text">
                                    ${profession.description}
                            </p>
                        </div>
                    </div>
                    <div class="item2">
                        <div class="text-gray">
                            门槛
                        </div>
                        <c:forEach step="1" begin="1" end="${profession.limitCondition}">
                            <img class="img-star" src="../img/css8/star.png">
                        </c:forEach>
                    </div>
                    <div class="item3">
                        <div class="text-gray">
                            难易程度
                        </div>
                        <c:forEach step="1" begin="1" end="${profession.difficulty}">
                            <img class="img-star" src="../img/css8/star.png">
                        </c:forEach>
                    </div>
                    <div class="item4">
                        <div class="text-gray">
                            成长周期
                        </div>
                        <div class="red-number">${profession.periodOne}-${profession.periodTwo}</div>
                        <div class="text-item4">年</div>
                    </div>
                    <div class="item5">
                        <div class="text-gray">
                            就业前景
                        </div>
                        <div class="red-number">${profession.carrerProspects}</div>
                        <div class="text-item5">家公司需要</div>
                    </div>
                    <div class="item6">
                        <div class="text-gray">
                            薪资待遇
                        </div>
                    </div>
                    <div class="item7">
                        <div class="item-left">0-1年</div>
                        <div class="item-rigt">${profession.salaryOne}k-${profession.salaryTwo}k/月</div>
                    </div>
                    <div class="item8">
                        <div class="item-left">1-3年</div>
                        <div class="item-rigt">${profession.salaryTwo}k-${profession.salaryThree}k/月</div>
                    </div>
                    <div class="item9">
                        <div class="item-left">3-5年</div>
                        <div class="item-rigt">${profession.salaryThree}k-${profession.salaryFour}k/月</div>
                    </div>
                    <div class="item10">
                        <div class="text-bold">有</div>
                        <div class="red-number">${profession.studying}</div>

                        <div class="text-bold-right">人正在学</div>&nbsp;
                        <div class="red-number">
                            更新时间:<date:date value="${profession.updateAt}" pattern="yy/MM/dd HH:mm:ss"/></div>
                        </div>
                    <div class="item11">
                        <div class="text-gray-hidden">
                                ${profession.reminder}
                        </div>
                    </div>
                </div>
            </div>
        </div>
             </c:if>
            </c:forEach>
         </div>
     </div>

    <div class="profession-title" id="back">后端开发方向</div>
    <!--详细介绍-->
    <div class="container-fluid">
        <div class="row">
    <c:forEach items="${list}" var="profession">
     <c:if test="${profession.developmentDirection=='后端开发方向'}">

            <div class="col-lg-4 col-md-6  col-sm-12">
                <!--网格布局-->
                <div class="grid-padding">
                    <div class="wrapper">
                        <img class="div-background" src="../img/css8/background.png">
                        <div class="item1">
                            <img class="item1_userhead" src="${profession.img}">
                            <div class="item1_introduce">
                                <div class="introduce_bold">${profession.professionName}</div>
                                <p class="introduce_text">
                                        ${profession.description}
                                </p>
                            </div>
                        </div>
                        <div class="item2">
                            <div class="text-gray">
                                门槛
                            </div>
                            <c:forEach step="1" begin="1" end="${profession.limitCondition}">
                                <img class="img-star" src="../img/css8/star.png">
                            </c:forEach>
                        </div>
                        <div class="item3">
                            <div class="text-gray">
                                难易程度
                            </div>
                            <c:forEach step="1" begin="1" end="${profession.difficulty}">
                                <img class="img-star" src="../img/css8/star.png">
                            </c:forEach>
                        </div>
                        <div class="item4">
                            <div class="text-gray">
                                成长周期
                            </div>
                            <div class="red-number">${profession.periodOne}-${profession.periodTwo}</div>
                            <div class="text-item4">年</div>
                        </div>
                        <div class="item5">
                            <div class="text-gray">
                                就业前景
                            </div>
                            <div class="red-number">${profession.carrerProspects}</div>
                            <div class="text-item5">家公司需要</div>
                        </div>
                        <div class="item6">
                            <div class="text-gray">
                                薪资待遇
                            </div>
                        </div>
                        <div class="item7">
                            <div class="item-left">0-1年</div>
                            <div class="item-rigt">${profession.salaryOne}k-${profession.salaryTwo}k/月</div>
                        </div>
                        <div class="item8">
                            <div class="item-left">1-3年</div>
                            <div class="item-rigt">${profession.salaryTwo}k-${profession.salaryThree}k/月</div>
                        </div>
                        <div class="item9">
                            <div class="item-left">3-5年</div>
                            <div class="item-rigt">${profession.salaryThree}k-${profession.salaryFour}k/月</div>
                        </div>
                        <div class="item10">
                            <div class="text-bold">有</div>
                            <div class="red-number">${profession.studying}</div>

                            <div class="text-bold-right">人正在学</div>&nbsp;
                            <div class="red-number">
                                更新时间:<date:date value="${profession.updateAt}" pattern="yy/MM/dd HH:mm:ss"/></div>
                        </div>
                        <div class="item11">
                            <div class="text-gray-hidden">
                                    ${profession.reminder}
                            </div>
                        </div>
                    </div>
                </div>
            </div>
    </c:if>
    </c:forEach>
    </div>
    </div>


    <div class="profession-title" id="running">运行维护方向</div>
    <!--详细介绍-->
    <div class="container-fluid">
        <div class="row">
    <c:forEach items="${list}" var="profession">
     <c:if test="${profession.developmentDirection=='运行维护方向'}">

            <div class="col-lg-4 col-md-6  col-sm-12">
                <!--网格布局-->
                <div class="grid-padding">
                    <div class="wrapper">
                        <img class="div-background" src="../img/css8/background.png">
                        <div class="item1">
                            <img class="item1_userhead" src="${profession.img}">
                            <div class="item1_introduce">
                                <div class="introduce_bold">${profession.professionName}</div>
                                <p class="introduce_text">
                                        ${profession.description}
                                </p>
                            </div>
                        </div>
                        <div class="item2">
                            <div class="text-gray">
                                门槛
                            </div>
                            <c:forEach step="1" begin="1" end="${profession.limitCondition}">
                                <img class="img-star" src="../img/css8/star.png">
                            </c:forEach>
                        </div>
                        <div class="item3">
                            <div class="text-gray">
                                难易程度
                            </div>
                            <c:forEach step="1" begin="1" end="${profession.difficulty}">
                                <img class="img-star" src="../img/css8/star.png">
                            </c:forEach>
                        </div>
                        <div class="item4">
                            <div class="text-gray">
                                成长周期
                            </div>
                            <div class="red-number">${profession.periodOne}-${profession.periodTwo}</div>
                            <div class="text-item4">年</div>
                        </div>
                        <div class="item5">
                            <div class="text-gray">
                                就业前景
                            </div>
                            <div class="red-number">${profession.carrerProspects}</div>
                            <div class="text-item5">家公司需要</div>
                        </div>
                        <div class="item6">
                            <div class="text-gray">
                                薪资待遇
                            </div>
                        </div>
                        <div class="item7">
                            <div class="item-left">0-1年</div>
                            <div class="item-rigt">${profession.salaryOne}k-${profession.salaryTwo}k/月</div>
                        </div>
                        <div class="item8">
                            <div class="item-left">1-3年</div>
                            <div class="item-rigt">${profession.salaryTwo}k-${profession.salaryThree}k/月</div>
                        </div>
                        <div class="item9">
                            <div class="item-left">3-5年</div>
                            <div class="item-rigt">${profession.salaryThree}k-${profession.salaryFour}k/月</div>
                        </div>
                        <div class="item10">
                            <div class="text-bold">有</div>
                            <div class="red-number">${profession.studying}</div>

                            <div class="text-bold-right">人正在学</div>&nbsp;
                            <div class="red-number">
                                更新时间:<date:date value="${profession.updateAt}" pattern="yy/MM/dd HH:mm:ss"/></div>
                        </div>
                        <div class="item11">
                            <div class="text-gray-hidden">
                                    ${profession.reminder}
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
</body>
</html>
