<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: yyj
  Date: 2017/12/27
  Time: 20:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1, user-scalable=no">
    <script src="${pageContext.request.contextPath}/t8/js/jquery-3.2.1.min.js"></script>
    <link href="${pageContext.request.contextPath}/t8/css/bootstrap.min.css" rel="stylesheet">
    <script src="${pageContext.request.contextPath}/t8/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/t8/css/jnshu.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/t8/css/cooperation.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/t8/css/joblist.css">
    <title>职位列表</title>
</head>
<body>
<header>
    <tiles:insertAttribute name="head"/>
</header>

<!-- 链式导航 -->
<div class="container link-line">
    <div class="row">
        <ol class="breadcrumb">
            <li><a href="${pageContext.request.contextPath}/u/jnshu">首页</a></li>
            <li class="active">职业</li>
        </ol>
    </div>
</div>
<!-- 职业方向 -->
<div class="container career-path">
    <div class="row">
        <ul>
            <li class="career-choise"><a>方向：</a></li>
            <li><a href="">全部</a></li>
            <li><a href="">前端开发</a></li>
            <li><a href="">后端开发</a></li>
            <li><a href="">移动开发</a></li>
            <li><a href="">整站开发</a></li>
            <li><a href="">运营维护</a></li>
        </ul>
    </div>
</div>
<c:forEach items="${joblist}" var="l">
<!-- 前端开发方向 -->
<div class="container">
    <div class="row">
        <p>${l.jobname}</p>
        <div class="col-xs-12 col-md-4 design">
            <div class="design-head row">
                <img class="img-responsive pull-left" src="${l.head}" alt="">
                <p>${l.jobname}</p>
                <span>${l.intro}</span>
            </div>
            <div class="design-main">
                <table class="level" border="1">
                    <tbody>
                    <tr class="">
                        <td>门槛：<img src="${pageContext.request.contextPath}/t8/img/star.png" alt=""></td>
                        <td>难易程度：<img src="${pageContext.request.contextPath}/t8/img/star.png" alt=""><img src="${pageContext.request.contextPath}/t8/img/star.png" alt=""></td>
                    </tr>
                    <tr>
                        <td>成长周期：1-3年</td>
                        <td>稀缺程度：345家公司需要</td>
                    </tr>
                    </tbody>
                </table>
                <table class="salary" border="1">
                    <tbody>
                    <tr>
                        <td rowspan="3" class="text-center">薪资待遇</td>
                        <td>0-1年</td>
                        <td>${l.lowSalary}</td>
                    </tr>
                    <tr>
                        <td>1-3年</td>
                        <td>${l.mediumSalary}</td>
                    </tr>
                    <tr>
                        <td>5-10年</td>
                        <td>${l.highSalary}</td>
                    </tr>
                    </tbody>
                </table>
            </div>
            <div class="design-foot">
                <table class="tip" border="1">
                    <tbody>
                    <tr>
                        <td>有286人正在学</td>
                    </tr>
                    <tr>
                        <td>${l.hint}</td>
                    </tr>
                    </tbody>
                </table>
            </div>
            <div class="hidden_over">
                <h4 class="text-center">${l.jobname}</h4>
                <p> ${l.jobsIntros.intros}
                </p>
            </div>
        </div>
    </div>
</div>
</c:forEach>
<footer>
    <tiles:insertAttribute name="tail"/>
</footer>
</body>
</html>
