<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isErrorPage="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <title>无标题文档</title>
    <meta content="width=device-width, initial-scale=1.0" name="viewport" charset="UTF-8">
    <link rel="stylesheet" href="http://apps.bdimg.com/libs/bootstrap/3.3.4/css/bootstrap.min.css">
    <script src="http://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
    <script src="http://apps.bdimg.com/libs/bootstrap/3.3.4/js/bootstrap.min.js"></script>
    <link href="css/t11.css" rel="stylesheet" type="text/css">
    <link href="css/base.css" rel="stylesheet" type="text/css">
</head>

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

    <div class="row padding-bottom">
        <c:forEach items="${list1}" var="prof" varStatus="now" begin="0" end="2">
            <div class="col-md-4 col-sm-6 col-xs-12 top-margin">
                <div class="warp-border">
                    <div class="clearfix">
                        <div class="icon-people"><img src="imges/687.png"></div>
                        <div class="text">
                            <h4 class="">${prof.profName}</h4>
                            <p class="text-present">${prof.profIntro}</p>
                        </div>
                    </div>

                    <div class="warp-class2">
                        <div class="warp-class2-text">
                            <div class="iconfont text-padding">门槛
                                <c:forEach begin="1" end="${prof.profSill}">
                                    <img src="imges/star.png">
                                </c:forEach>
                            </div>
                        </div>
                        <div class="warp-class2-text">
                            <div class="iconfont text-padding text-border-left">难易程度
                                <c:forEach begin="1" end="${prof.profLevel}">
                                    <img src="imges/star.png">
                                </c:forEach>
                            </div>
                        </div>
                    </div>
                    <div class="warp-class2">
                        <div class="warp-class2-text">
                            <div class="iconfont text-padding">成长周期 <span
                                    class="iconfont-color">${prof.profCycle}</span></div>
                        </div>
                        <div class="warp-class2-text">
                            <div class="iconfont text-padding text-border-left">稀缺程度 <span
                                    class="iconfont-color">${prof.profNeed}</span>家公司需要
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
                                <div class="rightWarp-wages">${prof.profTime1}</div>
                            </div>
                            <div class="rightWarp-class">
                                <div class="rightWarp-year">0-1年</div>
                                <div class="rightWarp-wages">${prof.profTime3}</div>
                            </div>
                            <div class="rightWarp-class border-bottom">
                                <div class="rightWarp-year">0-1年</div>
                                <div class="rightWarp-wages">${prof.profTime5}</div>
                            </div>
                        </div>
                    </div>

                    <div class="warp-class2">
                        <b class="text-b">有<a>${prof.sum}</a>人正在学</b>
                    </div>
                    <div class="warp-class2">
                        <p class="text-p">提示:在你学习之前你应该已经掌握<a>${prof.profLanguage}</a>等语言基础</p>
                    </div>

                    <div class="flip-container">
                        <p class="flip-title">${prof.profName}</p>
                        <p class="flip-text">${prof.profIntro}</p>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>

    <div class="caption">
        <h4>后端开发方向</h4>
    </div>

    <div class="row padding-bottom">
        <c:forEach items="${list2}" var="prof" varStatus="now" begin="0" end="2">
            <div class="col-md-4 col-sm-6 col-xs-12 top-margin">
                <div class="warp-border">
                    <div class="clearfix">
                        <div class="icon-people"><img src="imges/687.png"></div>
                        <div class="text">
                            <h4 class="">${prof.profName}</h4>
                            <p class="text-present">${prof.profIntro}</p>
                        </div>
                    </div>

                    <div class="warp-class2">
                        <div class="warp-class2-text">
                            <div class="iconfont text-padding">门槛
                                <c:forEach begin="1" end="${prof.profSill}">
                                    <img src="imges/star.png">
                                </c:forEach>
                            </div>
                        </div>
                        <div class="warp-class2-text">
                            <div class="iconfont text-padding text-border-left">难易程度
                                <c:forEach begin="1" end="${prof.profLevel}">
                                    <img src="imges/star.png">
                                </c:forEach>
                            </div>
                        </div>
                    </div>
                    <div class="warp-class2">
                        <div class="warp-class2-text">
                            <div class="iconfont text-padding">成长周期 <span
                                    class="iconfont-color">${prof.profCycle}</span></div>
                        </div>
                        <div class="warp-class2-text">
                            <div class="iconfont text-padding text-border-left">稀缺程度 <span
                                    class="iconfont-color">${prof.profNeed}</span>家公司需要
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
                                <div class="rightWarp-wages">${prof.profTime1}</div>
                            </div>
                            <div class="rightWarp-class">
                                <div class="rightWarp-year">0-1年</div>
                                <div class="rightWarp-wages">${prof.profTime3}</div>
                            </div>
                            <div class="rightWarp-class border-bottom">
                                <div class="rightWarp-year">0-1年</div>
                                <div class="rightWarp-wages">${prof.profTime5}</div>
                            </div>
                        </div>
                    </div>

                    <div class="warp-class2">
                        <b class="text-b">有<a>${prof.sum}</a>人正在学</b>
                    </div>
                    <div class="warp-class2">
                        <p class="text-p">提示:在你学习之前你应该已经掌握<a>${prof.profLanguage}</a>等语言基础</p>
                    </div>

                    <div class="flip-container">
                        <p class="flip-title">${prof.profName}</p>
                        <p class="flip-text">${prof.profIntro}</p>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>

</div>

</html>