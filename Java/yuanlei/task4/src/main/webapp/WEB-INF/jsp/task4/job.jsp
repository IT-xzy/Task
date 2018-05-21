<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="java.util.*"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>职位列表</title>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/font.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/task8-3.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/bootstrap.min1.css">
</head>

<body>
<div class="container">
    <div class="col-8 back2page1">
        <a class="mouse1" href="/home">首页</a><span class="back3page1">>职业</span>
    </div>
</div>

<div class="container position-this">
    <div class="row col-12 directian">
        <div class="color-gray font-size10 Occupation ">
            方向 &nbsp;：
        </div>
        <div class="Occupation font-size14 ">
            全部
        </div>
        <c:forEach items="${jobType}" var="jobtype" varStatus="st">
            <div class="Occupation font-size14 ">
                <a class="mouse1" href="#${jobtype.type}">${jobtype.type}</a>
            </div>
        </c:forEach>
    </div>
</div>
<c:forEach items="${jobType}" var="jobtype" varStatus="st" >
<!--前端-->
    <div class="container">
        <div id="${jobtype.type}" class="row col-12 qianduankaifafangxiang">
                <%--前端开发方向--%>
                ${jobtype.type}方向
        </div>
    </div>
    <div class="container">

        <div class="row ziwojianjie">
            <c:forEach items="${jobList}" var="job" varStatus="st">
                <c:if test="${job.type == jobtype.type}">

                    <div class="col-lg-3  col-sm-5 col-xs-12 jianjie">

                        <div class="blank"></div>

                        <div class="zhiweiliebiaopart1">
                            <img class="people" src="<%=request.getContextPath()%>/image/687.png">
                            <div class="zhiweiliebiaopart1-1">
                                <div><strong>${job.name}</strong></div>
                                <div class="font-size10 ">${job.introduction}</div>
                            </div>
                        </div>
                        <div class="easy-father">
                            <div class="easy">
                                门槛
                                <img src="<%=request.getContextPath()%>/image/职位列表_07.png">
                            </div>
                            <div class="easy">
                                难易程度
                                <img src="<%=request.getContextPath()%>/image/职位列表_07.png">
                                <img src="<%=request.getContextPath()%>/image/职位列表_07.png">
                            </div>
                        </div>
                        <div class="easy-father">
                            <div class="easy1">
                                成长周期${job.period}年
                            </div>
                            <div class="easy">
                                稀缺程度${job.need}家公司需要
                            </div>
                        </div>

                        <div class="easy-father">
                            <div class="cash">薪资待遇</div>
                            <div class="border">
                                <div>${job.salary1}</div>
                                <div class="border-topbottom">${job.salary2}</div>
                                <div>${job.salary3}</div>
                            </div>
                        </div>
                        <%--<div class="border1">有${job.totals}人正在学</div>--%>
                        <%--<div class="border1">${job.prompt}</div>--%>
                        <%--<div class="coverios">--%>
                            <%--<div class="h4">IOS开发</div>--%>
                            <%--iOS是由苹果公司开发的移动操作统，iOS与苹果的Mac OS X操作系统一样，也是以Darwin为基础的， 因此同样属于类Unix的商业操作系统。国内iOS开发起步相对较晚，人才培养机制更是远远跟不上市场发展速度。 有限的iOS开发人才成了国内企业必争的资源。国内iOS开发起步相对较晚，人才培养机制更是远远跟不上市场发展速度。 有限的iOS开发人才成了国内企业必争的资源。--%>
                        <%--</div>--%>
                    </div>
                    <div class="col-lg-1 col-sm-2"></div>
                </c:if>
            </c:forEach>
        </div>
    </div>
</c:forEach>
</body>
</html>