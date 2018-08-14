<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<% String path = request.getContextPath(); %>--%>
<html>
<head>
    <link rel="stylesheet" href="../css/profession.css">
    <title>Title</title>
</head>
<body>
<div class="occupation">
    <div class="container">
        <div class="row"><span class="bg-color-black">首页&gt;<a href="">职业</a></span></div>
        <div class="row">
            <span class="bg-color-gray">方向:<a href="" style="margin-left:15px">全部</a><a href="">前端开发</a><a href="">后端开发</a><a href="">移动开发</a><a href="">整站开发</a><a href="">运营维护</a></span>
        </div>
    </div>
</div>
<main>
    <div class="container">
        <div class="row nav-strong">
            <strong>前端方向</strong>

            <c:forEach items="${professionList}"  var="p" begin="0" end="3">
            <div class="col-xs-12 col-sm-6 col-md-4">


                <div class="warp">
                    <table border="1" class="text">
                        <tr>
                            <th><img src="../images/${p.picture}" alt="" class="avast"></th>
                            <td>
                                <strong>${p.type}</strong>
                                <p>${p.introduction}</p>
                            </td>
                        </tr>
                        <tr>
                            <td>门槛
                            <c:forEach begin="1" end="${p.threshold}">
                            <img src="../images/star.png" alt="">
                            </c:forEach>
                            </td>

                            <td>难易程度
                            <c:forEach begin="1" end="${p.difficulty}">
                            <img src="../images/star.png" alt="">
                            </c:forEach>
                            </td>
                        </tr>
                        <tr>
                            <td>成长周期 <em>${p.growthCycle}</em>年</td>
                            <td>稀缺程度 <em>${p.scarcity}</em>家公司需要</td>
                        </tr>
                        <tr>
                            <td>薪资待遇</td>
                            <td>
                                <div>${p.salary1}</div>
                                <div>${p.salary2}</div>
                                <div>${p.salary3}</div>
                            </td>
                        </tr>
                        <tr>
                            <td colspan="2">有<em>${p.number}</em>人正在学</td>
                        </tr>
                        <tr>
                            <td colspan="2">${p.hint}</td>
                        </tr>
                    </table>
                    <div class="zezhao"><strong>${p.type}工程师</strong>${p.jobDuties}</div>
                </div>
            </div>
            </c:forEach>

        </div> <!-- main-row -->
    </div> <!-- container -->



    <div class="container">
        <div class="row nav-strong">
            <strong>后端开发方向</strong>
            <c:forEach begin="4" end="5" items="${professionList}"  var="p" >
                <div class="col-xs-12 col-sm-6 col-md-4">


                    <div class="warp">
                        <table border="1" class="text">
                            <tr>
                                <th><img src="../images/${p.picture}" alt="" class="avast"></th>
                                <td>
                                    <strong>${p.type}</strong>
                                    <p>${p.introduction}</p>
                                </td>
                            </tr>
                            <tr>
                                <td>门槛
                                    <c:forEach begin="1" end="${p.threshold}">
                                        <img src="../images/star.png" alt="">
                                    </c:forEach>
                                </td>

                                <td>难易程度
                                    <c:forEach begin="1" end="${p.difficulty}">
                                        <img src="../images/star.png" alt="">
                                    </c:forEach>
                                </td>
                            </tr>
                            <tr>
                                <td>成长周期 <em>${p.growthCycle}</em>年</td>
                                <td>稀缺程度 <em>${p.scarcity}</em>家公司需要</td>
                            </tr>
                            <tr>
                                <td>薪资待遇</td>
                                <td>
                                    <div>${p.salary1}</div>
                                    <div>${p.salary2}</div>
                                    <div>${p.salary3}</div>
                                </td>
                            </tr>
                            <tr>
                                <td colspan="2">有<em>${p.number}</em>人正在学</td>
                            </tr>
                            <tr>
                                <td colspan="2">${p.hint}</td>
                            </tr>
                        </table>
                        <div class="zezhao"><strong>${p.type}工程师</strong>${p.jobDuties}</div>
                    </div>
                </div>
            </c:forEach>
        </div> <!-- main-row -->
    </div> <!-- container -->



    <div class="container">
        <div class="row nav-strong">
            <strong>测试方向</strong>

            <c:forEach begin="6" end="6" items="${professionList}"  var="p">
                <div class="col-xs-12 col-sm-6 col-md-4">


                    <div class="warp">
                        <table border="1" class="text">
                            <tr>
                                <th><img src="../images/${p.picture}" alt="" class="avast"></th>
                                <td>
                                    <strong>${p.type}</strong>
                                    <p>${p.introduction}</p>
                                </td>
                            </tr>
                            <tr>
                                <td>门槛
                                    <c:forEach begin="1" end="${p.threshold}">
                                        <img src="../images/star.png" alt="">
                                    </c:forEach>
                                </td>

                                <td>难易程度
                                    <c:forEach begin="1" end="${p.difficulty}">
                                        <img src="../images/star.png" alt="">
                                    </c:forEach>
                                </td>
                            </tr>
                            <tr>
                                <td>成长周期 <em>${p.growthCycle}</em>年</td>
                                <td>稀缺程度 <em>${p.scarcity}</em>家公司需要</td>
                            </tr>
                            <tr>
                                <td>薪资待遇</td>
                                <td>
                                    <div>${p.salary1}</div>
                                    <div>${p.salary2}</div>
                                    <div>${p.salary3}</div>
                                </td>
                            </tr>
                            <tr>
                                <td colspan="2">有<em>${p.number}</em>人正在学</td>
                            </tr>
                            <tr>
                                <td colspan="2">${p.hint}</td>
                            </tr>
                        </table>
                        <div class="zezhao"><strong>${p.type}工程师</strong>${p.jobDuties}</div>
                    </div>
                </div>
            </c:forEach>
        </div> <!-- main-row -->
    </div> <!-- container -->



    <div class="container">
        <div class="row nav-strong">
            <strong>产品方向</strong>
            <c:forEach begin="7" end="7" items="${professionList}"  var="p">
                <div class="col-xs-12 col-sm-6 col-md-4">


                    <div class="warp">
                        <table border="1" class="text">
                            <tr>
                                <th><img src="../images/${p.picture}" alt="" class="avast"></th>
                                <td>
                                    <strong>${p.type}</strong>
                                    <p>${p.introduction}</p>
                                </td>
                            </tr>
                            <tr>
                                <td>门槛
                                    <c:forEach begin="1" end="${p.threshold}">
                                        <img src="../images/star.png" alt="">
                                    </c:forEach>
                                </td>

                                <td>难易程度
                                    <c:forEach begin="1" end="${p.difficulty}">
                                        <img src="../images/star.png" alt="">
                                    </c:forEach>
                                </td>
                            </tr>
                            <tr>
                                <td>成长周期 <em>${p.growthCycle}</em>年</td>
                                <td>稀缺程度 <em>${p.scarcity}</em>家公司需要</td>
                            </tr>
                            <tr>
                                <td>薪资待遇</td>
                                <td>
                                    <div>${p.salary1}</div>
                                    <div>${p.salary2}</div>
                                    <div>${p.salary3}</div>
                                </td>
                            </tr>
                            <tr>
                                <td colspan="2">有<em>${p.number}</em>人正在学</td>
                            </tr>
                            <tr>
                                <td colspan="2">${p.hint}</td>
                            </tr>
                        </table>
                        <div class="zezhao"><strong>${p.type}工程师</strong>${p.jobDuties}</div>
                    </div>
                </div>
            </c:forEach>
        </div> <!-- main-row -->
    </div> <!-- container -->
</main>
</body>
</html>