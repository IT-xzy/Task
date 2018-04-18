<%--
  Created by IntelliJ IDEA.
  User: Y
  Date: 18/4/15
  Time: 14:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <link href="/css/t11.css" rel="stylesheet" type="text/css">
</head>
<body>

    <div class="row text-center">
        <div class="nav-title">首页&gt;职业</div>
        <div class="nav-bar">
            <div class="nav-bar">
                <span class="">方向：</span>
                <a class="nav-bar-a a-selected" href="">全部</a>
                <a class="nav-bar-a" href="">前端开发</a>
                <a class="nav-bar-a" href="">后端开发</a>
                <a class="nav-bar-a" href="">移动开发</a>
                <a class="nav-bar-a" href="">整站开发</a>
                <a class="nav-bar-a" href="">运营维护</a>
            </div>
        </div>
    </div>

    <div class="main container">

<!----> <div class="caption">
            <h4>前端开发方向</h4>
        </div>

        <c:forEach var="item" end="5"  items="${professionList}">
        <div class="carousel slide">
            <div class="col-md-4 col-sm-6 col-xs-12 top-margin">
                <div class="warp-border">
                    <div class="clearfix">
                        <div class="icon-people"><img src="${item.img_path}"></div>
                        <div class="text">
                            <h4 class="">${item.type}</h4>
                            <p class="text-present">${item.introduce}</p>
                        </div>
                    </div>

                    <div class="warp-class2">
                        <div class="warp-class2-text">
                            <div class="iconfont text-padding">门槛 <c:forEach begin="1" end="${item.threshold}"><img src="/imges2/xx.png"></c:forEach> </div>
                        </div>
                        <div class="warp-class2-text">
                            <div class="iconfont text-padding text-border-left">难易程度 <c:forEach begin="1" end="${item.level}"><img src="/imges2/xx.png"></c:forEach></div>
                        </div>
                    </div>
                    <div class="warp-class2">
                        <div class="warp-class2-text">
                            <div class="iconfont text-padding">成长周期 <span class="iconfont-color">${item.period}</span>年</div>
                        </div>
                        <div class="warp-class2-text">
                            <div class="iconfont text-padding text-border-left">稀缺程度 <span class="iconfont-color">${item.required}</span>家公司需要</div>
                        </div>
                    </div>

                    <div class="warp-class2">
                        <div class="leftWarp">
                            薪资待遇
                        </div>
                        <div class="rightWarp">
                            <div class="rightWarp-class">
                                <div class="rightWarp-year">0-1年</div>
                                <div class="rightWarp-wages">${item.salary1}</div>
                            </div>
                            <div class="rightWarp-class">
                                <div class="rightWarp-year">1-3年</div>
                                <div class="rightWarp-wages">${item.salary2}</div>
                            </div>
                            <div class="rightWarp-class border-bottom">
                                <div class="rightWarp-year">3-5年</div>
                                <div class="rightWarp-wages">${item.salary3}</div>
                            </div>
                        </div>
                    </div>

                    <div class="warp-class2">
                        <b class="text-b">有${item.learning}人正在学</b>
                    </div>
                    <div class="warp-class2">
                        <p class="text-p">提示:在你学习之前你应该已经掌握${item.language1}、${item.language2}、${item.language3}</p>
                    </div>

                    <div class="flip-container">
                        <p class="flip-title">iOS工程师</p>
                        <p class="flip-text">iOS是由苹果公司开发的移动操作统，iOS与苹果的Mac OS X操作系统一样， 也是以Darwin为基础的，因此同样属于类Unix的商业操作系统。国内iOS开发起步相对较晚， 人才培养机制更是远远跟不上市场发展速度。有限的iOS开发人才成了国内企业必争的资源。 国内iOS开发起步相对较晚，人才培养机制更是远远跟不上市场发展速度。 有限的iOS开发人才成了国内企业必争的资源。</p>
                    </div>
                </div>
            </div>
        </div>
        </c:forEach>

 <!----><div class="caption">
            <h4>后端开发方向</h4>
        </div>

        <c:forEach var="item" begin="6"  items="${professionList}">
            <div class="carousel slide">
                <div class="col-md-4 col-sm-6 col-xs-12 top-margin">
                    <div class="warp-border">
                        <div class="clearfix">
                            <div class="icon-people"><img src="${item.img_path}"></div>
                            <div class="text">
                                <h4 class="">${item.type}</h4>
                                <p class="text-present">${item.introduce}</p>
                            </div>
                        </div>

                        <div class="warp-class2">
                            <div class="warp-class2-text">
                                <div class="iconfont text-padding">门槛 <c:forEach begin="1" end="${item.threshold}"><img src="/imges2/xx.png"></c:forEach> </div>
                            </div>
                            <div class="warp-class2-text">
                                <div class="iconfont text-padding text-border-left">难易程度 <c:forEach begin="1" end="${item.level}"><img src="/imges2/xx.png"></c:forEach></div>
                            </div>
                        </div>
                        <div class="warp-class2">
                            <div class="warp-class2-text">
                                <div class="iconfont text-padding">成长周期 <span class="iconfont-color">${item.period}</span>年</div>
                            </div>
                            <div class="warp-class2-text">
                                <div class="iconfont text-padding text-border-left">稀缺程度 <span class="iconfont-color">${item.required}</span>家公司需要</div>
                            </div>
                        </div>

                        <div class="warp-class2">
                            <div class="leftWarp">
                                薪资待遇
                            </div>
                            <div class="rightWarp">
                                <div class="rightWarp-class">
                                    <div class="rightWarp-year">0-1年</div>
                                    <div class="rightWarp-wages">${item.salary1}</div>
                                </div>
                                <div class="rightWarp-class">
                                    <div class="rightWarp-year">1-3年</div>
                                    <div class="rightWarp-wages">${item.salary2}</div>
                                </div>
                                <div class="rightWarp-class border-bottom">
                                    <div class="rightWarp-year">3-5年</div>
                                    <div class="rightWarp-wages">${item.salary3}</div>
                                </div>
                            </div>
                        </div>

                        <div class="warp-class2">
                            <b class="text-b">有${item.learning}人正在学</b>
                        </div>
                        <div class="warp-class2">
                            <p class="text-p">提示:在你学习之前你应该已经掌握${item.language1}、${item.language2}、${item.language3}</p>
                        </div>

                        <div class="flip-container">
                            <p class="flip-title">iOS工程师</p>
                            <p class="flip-text">iOS是由苹果公司开发的移动操作统，iOS与苹果的Mac OS X操作系统一样， 也是以Darwin为基础的，因此同样属于类Unix的商业操作系统。国内iOS开发起步相对较晚， 人才培养机制更是远远跟不上市场发展速度。有限的iOS开发人才成了国内企业必争的资源。 国内iOS开发起步相对较晚，人才培养机制更是远远跟不上市场发展速度。 有限的iOS开发人才成了国内企业必争的资源。</p>
                        </div>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
</body>
</html>
