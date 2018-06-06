<%--
  Created by IntelliJ IDEA.
  User: lichu
  Date: 2018-5-23
  Time: 15:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="/css/t11.css" rel="stylesheet" type="text/css">
    <link href="/css/careerbase.css" rel="stylesheet" type="text/css">
    <link href="/css/font.css" rel="stylesheet" type="text/css">
    <title>CareerBody</title>
</head>
<body>
<div class="container">

    <%--1.导航条部分--%>
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
    <%--2.前端方向部分1--%>
        <div class="caption">
            <h4>前端开发方向</h4>
        </div>
        <div class="row">
            <div class="col-md-4 col-sm-6 col-xs-12 top-margin">
                <div class="warp-border">
                    <div class="clearfix">
                        <div class="icon-people"><img src="../images/guy.png"></div>
                        <div class="text">
                            <h4 class="">${list[0].career}前端工程师</h4>
                            <p class="text-present">${list[0].introduce}</p>
                        </div>
                    </div>
                    <div class="warp-class2">
                        <div class="warp-class2-text">
                            <div class="iconfont text-padding">门槛 <img src="../images/star.png"></div>
                        </div>
                        <div class="warp-class2-text">
                            <div class="iconfont text-padding text-border-left">难易程度 <img src="../images/star.png"><img src="../images/star.png"></div>
                        </div>
                    </div>
                    <div class="warp-class2">
                        <div class="warp-class2-text">
                            <div class="iconfont text-padding">成长周期 <span class="iconfont-color">${list[0].growthTime}</span>年</div>
                        </div>
                        <div class="warp-class2-text">
                            <div class="iconfont text-padding text-border-left">稀缺程度 <span class="iconfont-color">${list[0].wanted}</span>家公司需要</div>
                        </div>
                    </div>
                    <div class="warp-class2">
                        <div class="leftWarp">
                            薪资待遇
                        </div>
                        <div class="rightWarp">
                            <div class="rightWarp-class">
                                <div class="rightWarp-year">0-1年</div>
                                <div class="rightWarp-wages">${list[0].phaseOneSalary}/月</div>
                            </div>
                            <div class="rightWarp-class">
                                <div class="rightWarp-year">1-3年</div>
                                <div class="rightWarp-wages">${list[0].phaseTwoSalary}/月</div>
                            </div>
                            <div class="rightWarp-class border-bottom">
                                <div class="rightWarp-year">3-5年</div>
                                <div class="rightWarp-wages">${list[0].phaseThreeSalary}/月</div>
                            </div>
                        </div>
                    </div>
                    <div class="warp-class2">
                        <b class="text-b">有${webCount}人正在学</b>
                    </div>
                    <div class="warp-class2">
                        <p class="text-p">提示:在你学习之前你应该已经掌握XXXXX、XXXXX、XX等语言基础</p>
                    </div>
                    <div class="flip-container">
                        <p class="flip-title">${list[0].career}工程师</p>
                        <p class="flip-text">${list[0].detail}</p>
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="col-md-4 col-sm-6 col-xs-12 top-margin">
                    <div class="warp-border">
                        <div class="clearfix">
                            <div class="icon-people"><img src="../images/guy.png"></div>
                            <div class="text">
                                <h4 class="">${list[1].career}前端工程师</h4>
                                <p class="text-present">${list[1].introduce}</p>
                            </div>
                        </div>
                        <div class="warp-class2">
                            <div class="warp-class2-text">
                                <div class="iconfont text-padding">门槛 <img src="../images/star.png"></div>
                            </div>
                            <div class="warp-class2-text">
                                <div class="iconfont text-padding text-border-left">难易程度 <img src="../images/star.png"><img src="../images/star.png"></div>
                            </div>
                        </div>
                        <div class="warp-class2">
                            <div class="warp-class2-text">
                                <div class="iconfont text-padding">成长周期 <span class="iconfont-color">${list[1].growthTime}</span>年</div>
                            </div>
                            <div class="warp-class2-text">
                                <div class="iconfont text-padding text-border-left">稀缺程度 <span class="iconfont-color">${list[1].wanted}</span>家公司需要</div>
                            </div>
                        </div>
                        <div class="warp-class2">
                            <div class="leftWarp">
                                薪资待遇
                            </div>
                            <div class="rightWarp">
                                <div class="rightWarp-class">
                                    <div class="rightWarp-year">0-1年</div>
                                    <div class="rightWarp-wages">${list[1].phaseOneSalary}/月</div>
                                </div>
                                <div class="rightWarp-class">
                                    <div class="rightWarp-year">1-3年</div>
                                    <div class="rightWarp-wages">${list[1].phaseTwoSalary}/月</div>
                                </div>
                                <div class="rightWarp-class border-bottom">
                                    <div class="rightWarp-year">3-5年</div>
                                    <div class="rightWarp-wages">${list[1].phaseThreeSalary}/月</div>
                                </div>
                            </div>
                        </div>
                        <div class="warp-class2">
                            <b class="text-b">有${cssCount}人正在学</b>
                        </div>
                        <div class="warp-class2">
                            <p class="text-p">提示:在你学习之前你应该已经掌握XXXXX、XXXXX、XX等语言基础</p>
                        </div>
                        <div class="flip-container">
                            <p class="flip-title">${list[1].career}工程师</p>
                            <p class="flip-text">${list[1].detail}</p>
                        </div>
                    </div>
                </div>
            </div>

            <%--3.后端方向部分--%>
            <div class="caption">
                <h4>后端开发方向</h4>
            </div>
            <div class="row">
                <div class="col-md-4 col-sm-6 col-xs-12 top-margin">
                    <div class="warp-border">
                        <div class="clearfix">
                            <div class="icon-people"><img src="../images/guy.png"></div>
                            <div class="text">
                                <h4 class="">${list[2].career}后端工程师</h4>
                                <p class="text-present">${list[2].introduce}</p>
                            </div>
                        </div>
                        <div class="warp-class2">
                            <div class="warp-class2-text">
                                <div class="iconfont text-padding">门槛 <img src="../images/star.png"><img src="../images/star.png"><img src="../images/star.png"></div>
                            </div>
                            <div class="warp-class2-text">
                                <div class="iconfont text-padding text-border-left">难易程度 <img src="../images/star.png"><img src="../images/star.png"><img src="../images/star.png"><img src="../images/star.png"><img src="../images/star.png"><img src="../images/star.png"></div>
                            </div>
                        </div>
                        <div class="warp-class2">
                            <div class="warp-class2-text">
                                <div class="iconfont text-padding">成长周期 <span class="iconfont-color">${list[2].growthTime}</span>年</div>
                            </div>
                            <div class="warp-class2-text">
                                <div class="iconfont text-padding text-border-left">稀缺程度 <span class="iconfont-color">${list[2].wanted}</span>家公司需要</div>
                            </div>
                        </div>
                        <div class="warp-class2">
                            <div class="leftWarp">
                                薪资待遇
                            </div>
                            <div class="rightWarp">
                                <div class="rightWarp-class">
                                    <div class="rightWarp-year">0-1年</div>
                                    <div class="rightWarp-wages">${list[2].phaseOneSalary}/月</div>
                                </div>
                                <div class="rightWarp-class">
                                    <div class="rightWarp-year">1-3年</div>
                                    <div class="rightWarp-wages">${list[2].phaseTwoSalary}/月</div>
                                </div>
                                <div class="rightWarp-class border-bottom">
                                    <div class="rightWarp-year">3-5年</div>
                                    <div class="rightWarp-wages">${list[2].phaseThreeSalary}/月</div>
                                </div>
                            </div>
                        </div>
                        <div class="warp-class2">
                            <b class="text-b">有${javaCount}人正在学</b>
                        </div>
                        <div class="warp-class2">
                            <p class="text-p">提示:在你学习之前你应该已经掌握XXXXX、XXXXX、XX等语言基础</p>
                        </div>
                        <div class="flip-container">
                            <p class="flip-title">${list[2].career}工程师</p>
                            <p class="flip-text">${list[2].detail}</p>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="col-md-4 col-sm-6 col-xs-12 top-margin">
                        <div class="warp-border">
                            <div class="clearfix">
                                <div class="icon-people"><img src="../images/guy.png"></div>
                                <div class="text">
                                    <h4 class="">${list[3].career}后端工程师</h4>
                                    <p class="text-present">${list[3].introduce}</p>
                                </div>
                            </div>
                            <div class="warp-class2">
                                <div class="warp-class2-text">
                                    <div class="iconfont text-padding">门槛 <img src="../images/star.png"><img src="../images/star.png"></div>
                                </div>
                                <div class="warp-class2-text">
                                    <div class="iconfont text-padding text-border-left">难易程度 <img src="../images/star.png"><img src="../images/star.png"><img src="../images/star.png"><img src="../images/star.png"></div>
                                </div>
                            </div>
                            <div class="warp-class2">
                                <div class="warp-class2-text">
                                    <div class="iconfont text-padding">成长周期 <span class="iconfont-color">${list[3].growthTime}</span>年</div>
                                </div>
                                <div class="warp-class2-text">
                                    <div class="iconfont text-padding text-border-left">稀缺程度 <span class="iconfont-color">${list[3].wanted}</span>家公司需要</div>
                                </div>
                            </div>
                            <div class="warp-class2">
                                <div class="leftWarp">
                                    薪资待遇
                                </div>
                                <div class="rightWarp">
                                    <div class="rightWarp-class">
                                        <div class="rightWarp-year">0-1年</div>
                                        <div class="rightWarp-wages">${list[3].phaseOneSalary}/月</div>
                                    </div>
                                    <div class="rightWarp-class">
                                        <div class="rightWarp-year">1-3年</div>
                                        <div class="rightWarp-wages">${list[3].phaseTwoSalary}/月</div>
                                    </div>
                                    <div class="rightWarp-class border-bottom">
                                        <div class="rightWarp-year">3-5年</div>
                                        <div class="rightWarp-wages">${list[3].phaseThreeSalary}/月</div>
                                    </div>
                                </div>
                            </div>
                            <div class="warp-class2">
                                <b class="text-b">有${pythonCount}人正在学</b>
                            </div>
                            <div class="warp-class2">
                                <p class="text-p">提示:在你学习之前你应该已经掌握XXXXX、XXXXX、XX等语言基础</p>
                            </div>
                            <div class="flip-container">
                                <p class="flip-title">${list[3].career}工程师</p>
                                <p class="flip-text">${list[3].detail}</p>
                            </div>
                        </div>
                    </div>
                </div>

                <%--4.移动开发方向部分--%>
                <div class="caption">
                    <h4>移动开发方向</h4>
                </div>
                <div class="row">
                    <div class="col-md-4 col-sm-6 col-xs-12 top-margin">
                        <div class="warp-border">
                            <div class="clearfix">
                                <div class="icon-people"><img src="../images/guy.png"></div>
                                <div class="text">
                                    <h4 class="">${list[4].career}移动开发工程师</h4>
                                    <p class="text-present">${list[4].introduce}</p>
                                </div>
                            </div>
                            <div class="warp-class2">
                                <div class="warp-class2-text">
                                    <div class="iconfont text-padding">门槛 <img src="../images/star.png"><img src="../images/star.png"><img src="../images/star.png"></div>
                                </div>
                                <div class="warp-class2-text">
                                    <div class="iconfont text-padding text-border-left">难易程度 <img src="../images/star.png"><img src="../images/star.png"><img src="../images/star.png"><img src="../images/star.png"><img src="../images/star.png"><img src="../images/star.png"></div>
                                </div>
                            </div>
                            <div class="warp-class2">
                                <div class="warp-class2-text">
                                    <div class="iconfont text-padding">成长周期 <span class="iconfont-color">${list[4].growthTime}</span>年</div>
                                </div>
                                <div class="warp-class2-text">
                                    <div class="iconfont text-padding text-border-left">稀缺程度 <span class="iconfont-color">${list[4].wanted}</span>家公司需要</div>
                                </div>
                            </div>
                            <div class="warp-class2">
                                <div class="leftWarp">
                                    薪资待遇
                                </div>
                                <div class="rightWarp">
                                    <div class="rightWarp-class">
                                        <div class="rightWarp-year">0-1年</div>
                                        <div class="rightWarp-wages">${list[4].phaseOneSalary}/月</div>
                                    </div>
                                    <div class="rightWarp-class">
                                        <div class="rightWarp-year">1-3年</div>
                                        <div class="rightWarp-wages">${list[4].phaseTwoSalary}/月</div>
                                    </div>
                                    <div class="rightWarp-class border-bottom">
                                        <div class="rightWarp-year">3-5年</div>
                                        <div class="rightWarp-wages">${list[4].phaseThreeSalary}/月</div>
                                    </div>
                                </div>
                            </div>
                            <div class="warp-class2">
                                <b class="text-b">有${iosCount}人正在学</b>
                            </div>
                            <div class="warp-class2">
                                <p class="text-p">提示:在你学习之前你应该已经掌握XXXXX、XXXXX、XX等语言基础</p>
                            </div>
                            <div class="flip-container">
                                <p class="flip-title">${list[4].career}工程师</p>
                                <p class="flip-text">${list[4].detail}</p>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-md-4 col-sm-6 col-xs-12 top-margin">
                            <div class="warp-border">
                                <div class="clearfix">
                                    <div class="icon-people"><img src="../images/guy.png"></div>
                                    <div class="text">
                                        <h4 class="">${list[5].career}移动开发工程师</h4>
                                        <p class="text-present">${list[5].introduce}</p>
                                    </div>
                                </div>
                                <div class="warp-class2">
                                    <div class="warp-class2-text">
                                        <div class="iconfont text-padding">门槛 <img src="../images/star.png"><img src="../images/star.png"></div>
                                    </div>
                                    <div class="warp-class2-text">
                                        <div class="iconfont text-padding text-border-left">难易程度 <img src="../images/star.png"><img src="../images/star.png"><img src="../images/star.png"><img src="../images/star.png"></div>
                                    </div>
                                </div>
                                <div class="warp-class2">
                                    <div class="warp-class2-text">
                                        <div class="iconfont text-padding">成长周期 <span class="iconfont-color">${list[5].growthTime}</span>年</div>
                                    </div>
                                    <div class="warp-class2-text">
                                        <div class="iconfont text-padding text-border-left">稀缺程度 <span class="iconfont-color">${list[5].wanted}</span>家公司需要</div>
                                    </div>
                                </div>
                                <div class="warp-class2">
                                    <div class="leftWarp">
                                        薪资待遇
                                    </div>
                                    <div class="rightWarp">
                                        <div class="rightWarp-class">
                                            <div class="rightWarp-year">0-1年</div>
                                            <div class="rightWarp-wages">${list[5].phaseOneSalary}/月</div>
                                        </div>
                                        <div class="rightWarp-class">
                                            <div class="rightWarp-year">1-3年</div>
                                            <div class="rightWarp-wages">${list[5].phaseTwoSalary}/月</div>
                                        </div>
                                        <div class="rightWarp-class border-bottom">
                                            <div class="rightWarp-year">3-5年</div>
                                            <div class="rightWarp-wages">${list[5].phaseThreeSalary}/月</div>
                                        </div>
                                    </div>
                                </div>
                                <div class="warp-class2">
                                    <b class="text-b">有${androidCount}人正在学</b>
                                </div>
                                <div class="warp-class2">
                                    <p class="text-p">提示:在你学习之前你应该已经掌握XXXXX、XXXXX、XX等语言基础</p>
                                </div>
                                <div class="flip-container">
                                    <p class="flip-title">${list[5].career}工程师</p>
                                    <p class="flip-text">${list[5].detail}</p>
                                </div>
                            </div>
                        </div>
                    </div>

                    <%--5.整站开发方向部分--%>
                    <div class="caption">
                        <h4>整站开发方向</h4>
                    </div>
                    <div class="row">
                        <div class="col-md-4 col-sm-6 col-xs-12 top-margin">
                            <div class="warp-border">
                                <div class="clearfix">
                                    <div class="icon-people"><img src="../images/guy.png"></div>
                                    <div class="text">
                                        <h4 class="">${list[6].career}整站开发工程师</h4>
                                        <p class="text-present">${list[6].introduce}</p>
                                    </div>
                                </div>
                                <div class="warp-class2">
                                    <div class="warp-class2-text">
                                        <div class="iconfont text-padding">门槛 <img src="../images/star.png"><img src="../images/star.png"><img src="../images/star.png"></div>
                                    </div>
                                    <div class="warp-class2-text">
                                        <div class="iconfont text-padding text-border-left">难易程度 <img src="../images/star.png"><img src="../images/star.png"><img src="../images/star.png"><img src="../images/star.png"><img src="../images/star.png"><img src="../images/star.png"></div>
                                    </div>
                                </div>
                                <div class="warp-class2">
                                    <div class="warp-class2-text">
                                        <div class="iconfont text-padding">成长周期 <span class="iconfont-color">${list[6].growthTime}</span>年</div>
                                    </div>
                                    <div class="warp-class2-text">
                                        <div class="iconfont text-padding text-border-left">稀缺程度 <span class="iconfont-color">${list[6].wanted}</span>家公司需要</div>
                                    </div>
                                </div>
                                <div class="warp-class2">
                                    <div class="leftWarp">
                                        薪资待遇
                                    </div>
                                    <div class="rightWarp">
                                        <div class="rightWarp-class">
                                            <div class="rightWarp-year">0-1年</div>
                                            <div class="rightWarp-wages">${list[6].phaseOneSalary}/月</div>
                                        </div>
                                        <div class="rightWarp-class">
                                            <div class="rightWarp-year">1-3年</div>
                                            <div class="rightWarp-wages">${list[6].phaseTwoSalary}/月</div>
                                        </div>
                                        <div class="rightWarp-class border-bottom">
                                            <div class="rightWarp-year">3-5年</div>
                                            <div class="rightWarp-wages">${list[6].phaseThreeSalary}/月</div>
                                        </div>
                                    </div>
                                </div>
                                <div class="warp-class2">
                                    <b class="text-b">有${cCount}人正在学</b>
                                </div>
                                <div class="warp-class2">
                                    <p class="text-p">提示:在你学习之前你应该已经掌握XXXXX、XXXXX、XX等语言基础</p>
                                </div>
                                <div class="flip-container">
                                    <p class="flip-title">${list[6].career}工程师</p>
                                    <p class="flip-text">${list[6].detail}</p>
                                </div>
                            </div>
                        </div>
                    </div>

                        <%--6.运营维护方向部分--%>
                        <div class="caption">
                            <h4>运营维护方向</h4>
                        </div>
                        <div class="row">
                            <div class="col-md-4 col-sm-6 col-xs-12 top-margin">
                                <div class="warp-border">
                                    <div class="clearfix">
                                        <div class="icon-people"><img src="../images/guy.png"></div>
                                        <div class="text">
                                            <h4 class="">${list[7].career}运营维护工程师</h4>
                                            <p class="text-present">${list[7].introduce}</p>
                                        </div>
                                    </div>
                                    <div class="warp-class2">
                                        <div class="warp-class2-text">
                                            <div class="iconfont text-padding">门槛 <img src="../images/star.png"><img src="../images/star.png"></div>
                                        </div>
                                        <div class="warp-class2-text">
                                            <div class="iconfont text-padding text-border-left">难易程度 <img src="../images/star.png"><img src="../images/star.png"><img src="../images/star.png"><img src="../images/star.png"></div>
                                        </div>
                                    </div>
                                    <div class="warp-class2">
                                        <div class="warp-class2-text">
                                            <div class="iconfont text-padding">成长周期 <span class="iconfont-color">${list[7].growthTime}</span>年</div>
                                        </div>
                                        <div class="warp-class2-text">
                                            <div class="iconfont text-padding text-border-left">稀缺程度 <span class="iconfont-color">${list[7].wanted}</span>家公司需要</div>
                                        </div>
                                    </div>
                                    <div class="warp-class2">
                                        <div class="leftWarp">
                                            薪资待遇
                                        </div>
                                        <div class="rightWarp">
                                            <div class="rightWarp-class">
                                                <div class="rightWarp-year">0-1年</div>
                                                <div class="rightWarp-wages">${list[7].phaseOneSalary}/月</div>
                                            </div>
                                            <div class="rightWarp-class">
                                                <div class="rightWarp-year">1-3年</div>
                                                <div class="rightWarp-wages">${list[7].phaseTwoSalary}/月</div>
                                            </div>
                                            <div class="rightWarp-class border-bottom">
                                                <div class="rightWarp-year">3-5年</div>
                                                <div class="rightWarp-wages">${list[7].phaseThreeSalary}/月</div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="warp-class2">
                                        <b class="text-b">有${pmCount}人正在学</b>
                                    </div>
                                    <div class="warp-class2">
                                        <p class="text-p">提示:在你学习之前你应该已经掌握XXXXX、XXXXX、XX等语言基础</p>
                                    </div>
                                    <div class="flip-container">
                                        <p class="flip-title">${list[7].career}工程师</p>
                                        <p class="flip-text">${list[7].detail}</p>
                                    </div>
                                </div>
                            </div>
                            </div>
</div>

</body>
</html>
