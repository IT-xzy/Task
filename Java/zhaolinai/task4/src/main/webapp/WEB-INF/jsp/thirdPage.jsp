<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %><%@ taglib prefix="zln" uri="/tags"%> 
<!DOCTYPE html>
<html lang="en">
<%@page language="java" contentType="text/html; UTF-8" pageEncoding="UTF-8" isELIgnored="false" isErrorPage="true" %>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0;">
    <meta name="format-detection" content="telephone=no">
    <title>职位</title>
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="../css/base.css">
    <link rel="stylesheet" href="../css/task-93.css">
    <script src="https://cdn.bootcss.com/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>

<body>
<!-- 头部 -->

<div class="container" style="text-align: left">

    <div class="title w" style="text-align: left">
        <span class="txt1">首页></span>
        <span class="txt2">职位</span>
    </div>

    <div class="fx w" style="text-align: left">
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
<div class="container" style="text-align: left">
    <div class="contain w" style="text-align: left">
        <div class="section1 w row">
            <div class="head col-md-12 col-sm-12 col-xs-12">前端开发方向</div>


            <div class="content">
                <c:forEach items="${job1}" var="Job">
                    <div class="people col-md-4 col-sm-12 col-xs-12">
                        <div class="first">
                            <img src=${Job.img} alt="">
                            <div class="txt">
                                <p>${Job.name}</p>
                                <span>${Job.introduce}
                                </span>
                            </div>
                        </div>
                        <div class="sec">
                            <div class="menk">门槛
                                <c:forEach begin="1" end="${Job.doorsill}">
                                    <img src="images/star.png" alt="">
                                </c:forEach>
                            </div>
                            <div class="nan">难易程度
                                <c:forEach begin="1" end="${Job.index}">
                                    <img src="images/star.png" alt="">
                                </c:forEach>
                            </div>
                        </div>
                        <div class="sec">
                            <div class="menk">成长周期：
                                <span><i>${Job.grow}</i>年</span>
                            </div>
                            <div class="nan">稀缺程度：
                                <span><i>${Job.needed}</i>公司需要</span>
                            </div>
                        </div>
                        <div class="third">
                            <div class="l">薪资待遇</div>
                            <ul class="r">
                                <li class="line">${Job.time1}年<span>${Job.salary1}</span></li>
                                <li class="line">${Job.time2}年<span>${Job.salary2}</span></li>
                                <li>${Job.time3}年<span>${Job.salary3}</span></li>
                            </ul>
                        </div> 
                        <div class="four">
                            有<i>${Job.count}</i>人正在学习 更新时间：<zln:date value="${time}"/>
                        </div>
                        <div class="five">
                            提示:在你学习之前你应该已经掌握${Job.language}等语言基础
                        </div>
                        <div class="mask">
                            <p>ios工程师</p>
                            <span>${Job.background}</span>
                        </div>
                    </div>
                </c:forEach>
            </div>

            <div class="head col-md-12 col-sm-12 col-xs-12">后端开发方向</div>
            <div class="content">
                <c:forEach items="${job2}" var="Job">
                    <div class="people col-md-4 col-sm-12 col-xs-12">
                        <div class="first">
                            <img src=${Job.img} alt="">
                            <div class="txt">
                                <p>${Job.name}</p>
                                <span>${Job.introduce}
                                </span>
                            </div>
                        </div>
                        <div class="sec">
                            <div class="menk">门槛
                                <c:forEach begin="1" end="${Job.doorsill}">
                                    <img src="images/star.png" alt="">
                                </c:forEach>
                            </div>
                            <div class="nan">难易程度
                                <c:forEach begin="1" end="${Job.index}">
                                    <img src="images/star.png" alt="">
                                </c:forEach>
                            </div>
                        </div>
                        <div class="sec">
                            <div class="menk">成长周期：
                                <span><i>${Job.grow}</i>年</span>
                            </div>
                            <div class="nan">稀缺程度：
                                <span><i>${Job.needed}</i>公司需要</span>
                            </div>
                        </div>
                        <div class="third">
                            <div class="l">薪资待遇</div>
                            <ul class="r">
                                <li class="line">${Job.time1}年<span>${Job.salary1}</span></li>
                                <li class="line">${Job.time2}年<span>${Job.salary2}</span></li>
                                <li>${Job.time3}年<span>${Job.salary3}</span></li>
                            </ul>
                        </div>
                        <div class="four">
                            有<i>${Job.count}</i>人正在学习 更新时间：<zln:date value="${time}"/>
                        </div>
                        <div class="five">
                            提示:在你学习之前你应该已经掌握${Job.language}等语言基础
                        </div>
                        <div class="mask">
                            <p>ios工程师</p>
                            <span>${Job.background}</span>
                        </div>
                    </div>
                </c:forEach>

            </div>
            <div class="head col-md-12 col-sm-12 col-xs-12">运维方向</div>
            <div class="content">
                <c:forEach items="${job3}" var="Job">
                    <div class="people col-md-4 col-sm-12 col-xs-12">
                        <div class="first">
                            <img src=${Job.img} alt="">
                            <div class="txt">
                                <p>${Job.name}</p>
                                <span> ${Job.introduce}
                                </span>
                            </div>
                        </div>
                        <div class="sec">
                            <div class="menk">门槛
                                <c:forEach begin="1" end="${Job.doorsill}">
                                    <img src="images/star.png" alt="">
                                </c:forEach>
                            </div>
                            <div class="nan">难易程度
                                <c:forEach begin="1" end="${Job.index}">
                                    <img src="images/star.png" alt="">
                                </c:forEach>
                            </div>
                        </div>
                        <div class="sec">
                            <div class="menk">成长周期：
                                <span><i>${Job.grow}</i>年</span>
                            </div>
                            <div class="nan">稀缺程度：
                                <span><i>${Job.needed}</i>公司需要</span>
                            </div>
                        </div>
                        <div class="third">
                            <div class="l">薪资待遇</div>
                            <ul class="r">
                                <li class="line">${Job.time1}年<span>${Job.salary1}</span></li>
                                <li class="line">${Job.time2}年<span>${Job.salary2}</span></li>
                                <li>${Job.time3}年<span>${Job.salary3}</span></li>
                            </ul>
                        </div>
                        <div class="four">
                            有<i>${Job.count}</i>人正在学习 更新时间：<zln:date value="${time}"/>
                        </div>
                        <div class="five">
                            提示:在你学习之前你应该已经掌握${Job.language}等语言基础
                        </div>
                        <div class="mask">
                            <p>ios工程师</p>
                            <span>${Job.background}</span>
                        </div>
                    </div>
                </c:forEach>
            </div>

        </div>
    </div>
</div>

<!-- 脚部 -->

</body>

</html>