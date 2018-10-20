<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isErrorPage="true"
        isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">


<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0;">
    <meta name="format-detection" content="telephone=no">
    <title>职位</title>
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <%--注意设置的css路径，就是用这种，配置了（加全路径就出错）--%>
    <link rel="stylesheet" href="css/base.css">
    <link rel="stylesheet" href="css/task-93.css">
    <script src="https://cdn.bootcss.com/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>

<body>

<div class="container">

    <div class="title w">
        <span class="txt1">首页></span>
        <span class="txt2">职位</span>
    </div>

    <div class="fx w">
        <span class="tt">方向：</span>
        <span class="active">全部</span>
        <span>前端开发</span>
        <span>后端开发</span>
        <span>整站开发</span>
        <span>移动开发</span>
        <span>运营维护</span>
    </div>

</div>
<!-- 内容部分 -->
<div class="container">
    <div class="contain w">
        <div class="section1 w row">


            <div class="head col-md-12 col-sm-12 col-xs-12">前端开发方向</div>
            <div class="content">
                <c:forEach items="${data1}" var="profession" varStatus="now" begin="0" end="3">
                <div class="people col-md-4 col-sm-12 col-xs-12">
                    <div class="first">
                        <img src="images/tx1.jpg" alt="">
                        <div class="txt">
                            <p>${profession.classify}</p>
                            <span>${profession.duty}
                                </span>
                        </div>
                    </div>
                    <div class="sec">
                        <div class="menk">门槛
                            <c:forEach begin="1" end="${profession.strip}">
                            <img src="images/star.png" alt="">
                            </c:forEach>
                        </div>
                        <div class="nan">难易程度
                            <c:forEach begin="1" end="${profession.difficultyLevel}">
                            <img src="images/star.png" alt="">
                            </c:forEach>
                        </div>
                    </div>
                    <div class="sec">
                        <div class="menk">成长周期：
                            <span><i>${profession.growthCycle}</i>年</span>
                        </div>
                        <div class="nan">稀缺程度：
                            <span><i>${profession.scarcityDegree}</i>公司需要</span>
                        </div>
                    </div>
                    <div class="third">
                        <div class="l">薪资待遇</div>
                        <ul class="r">
                            <li class="line">0-1年<span>${profession.firstSalary}</span></li>
                            <li class="line">1-3年<span>${profession.secondSalary}</span></li>
                            <li>3-5年<span>${profession.thirdSalary}</span></li>
                        </ul>
                    </div>
                    <div class="four">
                        有<i>${profession.count}</i>人正在学习
                    </div>
                    <div class="five">
                        提示:在你学习之前你应该已经掌握${profession.basicKnowledge}等语言基础
                    </div>
                    <div class="mask">
                        <p>${profession.engineer}</p>
                        <span>${profession.engineerIntro}
                              </span>
                    </div>
                </div>
                </c:forEach>
            </div>



            <div class="head col-md-12 col-sm-12 col-xs-12">后端开发方向</div>
            <div class="content">
                <c:forEach items="${data2}" var="profession" varStatus="now" begin="0" end="3">
                    <div class="people col-md-4 col-sm-12 col-xs-12">
                        <div class="first">
                            <img src="images/tx1.jpg" alt="">
                            <div class="txt">
                                <p>${profession.classify}</p>
                                <span>${profession.duty}
                                </span>
                            </div>
                        </div>
                        <div class="sec">
                            <div class="menk">门槛
                                <c:forEach begin="1" end="${profession.strip}">
                                    <img src="images/star.png" alt="">
                                </c:forEach>
                            </div>
                            <div class="nan">难易程度
                                <c:forEach begin="1" end="${profession.difficultyLevel}">
                                    <img src="images/star.png" alt="">
                                </c:forEach>
                            </div>
                        </div>
                        <div class="sec">
                            <div class="menk">成长周期：
                                <span><i>${profession.growthCycle}</i>年</span>
                            </div>
                            <div class="nan">稀缺程度：
                                <span><i>${profession.scarcityDegree}</i>公司需要</span>
                            </div>
                        </div>
                        <div class="third">
                            <div class="l">薪资待遇</div>
                            <ul class="r">
                                <li class="line">0-1年<span>${profession.firstSalary}</span></li>
                                <li class="line">1-3年<span>${profession.secondSalary}</span></li>
                                <li>3-5年<span>${profession.thirdSalary}</span></li>
                            </ul>
                        </div>
                        <div class="four">
                            有<i>${profession.count}</i>人正在学习
                        </div>
                        <div class="five">
                            提示:在你学习之前你应该已经掌握${profession.basicKnowledge}等语言基础
                        </div>
                        <div class="mask">
                            <p>${profession.engineer}</p>
                            <span>${profession.engineerIntro}
                            </span>
                        </div>
                    </div>
                </c:forEach>
            </div>






        </div>
    </div>
</div>
</body>

</html>