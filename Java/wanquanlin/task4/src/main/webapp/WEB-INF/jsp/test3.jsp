<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/4/3
  Time: 23:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>task8-3</title>
    <script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link rel="stylesheet"type="text/css" href="css/test3.css">

</head>
<body>
<nav>
    <div class="kefu">客服热线：010-594-78634</div>
    <div class="pic">
        <a href class="wechat"></a>
        <a href class="qq"></a>
        <a href class="weibo"></a>
    </div>
</nav>
<div class="header">
    <div class="jnshu"></div>
    <div class="right">
        <a href="/welcome">首页</a>
        <a href="/profession">职业</a>
        <a href="#">购买</a>
        <a href="#">关于</a>
    </div>
</div>
<div class="nav">
    <a href="/welcome ">首页</a>
    <span>/合作企业</span>
</div>
    <div class="zhiye">
        <span>方向:</span>
        <span class="active"><a href="#">全部</a></span>
        <span><a href="#">前端开发</a></span>
        <span><a href="#">后端开发</a></span>
        <span><a href="#">移动开发</a></span>
        <span><a href="#">整站开发</a></span>
        <span><a href="#">运营维护</a></span>
    </div>
    <div class="title">前端开发方向</div>

    <div class="container face">
        <div class="row">
            <c:forEach items="${joblist1}" var="s" >
                <div class="col-xs-12 col-md-4 man">

                    <div class="row ">

                        <div class="col-md-5 img"></div>
                        <div class="col-md-7 jie">
                            <p>${s.jobname}</p>
                            <span>${s.description}</span>
                        </div>

                    </div>

                    <div class="row">
                        <div class="col-md-6 left1">门榄</div>
                        <div class="col-md-6 right1">难易程度</div>
                    </div>
                    <div class="row">
                        <div class="col-md-6 left2">
                            <span>成长周期</span>
                            <h>1-3</h>
                            <span>年</span>
                        </div>
                        <div class="col-md-6 right2">
                            <span>稀缺程度</span>
                            <h>${s.number_of_company}</h>
                            <span>家公司需要</span>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-5 left3">薪资待遇</div>
                        <div class="col-md-7 right3">
                            <div class="row">
                                <div class="col-xs-12 text">

                                    <span>${s.salary1}</span>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-xs-12 text">
                                    <span>1${s.salary2}</span>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-xs-12 text">
                                    <span>${s.salary3}</span>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-12 foot1">有<h>286</h>人正在学</div>
                    </div>
                    <div class="row">
                        <div class="col-md-12 foot2">${s.hint}</div>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>

    <div class="title">后端开发方向</div>
    <div class="container face">
        <div class="row">
            <c:forEach items="${joblist1}" var="s" >
                <div class="col-xs-12 col-md-4 man">

                    <div class="row ">

                        <div class="col-md-5 img"></div>
                        <div class="col-md-7 jie">
                            <p>${s.jobname}</p>
                            <span>${s.description}</span>
                        </div>

                    </div>

                    <div class="row">
                        <div class="col-md-6 left1">门榄</div>
                        <div class="col-md-6 right1">难易程度</div>
                    </div>
                    <div class="row">
                        <div class="col-md-6 left2">
                            <span>成长周期</span>
                            <h>1-3</h>
                            <span>年</span>
                        </div>
                        <div class="col-md-6 right2">
                            <span>稀缺程度</span>
                            <h>${s.number_of_company}</h>
                            <span>家公司需要</span>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-5 left3">薪资待遇</div>
                        <div class="col-md-7 right3">
                            <div class="row">
                                <div class="col-xs-12 text">

                                    <span>${s.salary1}</span>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-xs-12 text">
                                    <span>1${s.salary2}</span>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-xs-12 text">
                                    <span>${s.salary3}</span>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-12 foot1">有<h>286</h>人正在学</div>
                    </div>
                    <div class="row">
                        <div class="col-md-12 foot2">${s.hint}</div>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>
    <div class="title">运维开发方向</div>
    <div class="container face">
        <div class="row">
            <c:forEach items="${joblist1}" var="s" >
                <div class="col-xs-12 col-md-4 man">

                    <div class="row ">

                        <div class="col-md-5 img"></div>
                        <div class="col-md-7 jie">
                            <p>${s.jobname}</p>
                            <span>${s.description}</span>
                        </div>

                    </div>

                    <div class="row">
                        <div class="col-md-6 left1">门榄</div>
                        <div class="col-md-6 right1">难易程度</div>
                    </div>
                    <div class="row">
                        <div class="col-md-6 left2">
                            <span>成长周期</span>
                            <h>1-3</h>
                            <span>年</span>
                        </div>
                        <div class="col-md-6 right2">
                            <span>稀缺程度</span>
                            <h>${s.number_of_company}</h>
                            <span>家公司需要</span>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-5 left3">薪资待遇</div>
                        <div class="col-md-7 right3">
                            <div class="row">
                                <div class="col-xs-12 text">

                                    <span>${s.salary1}</span>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-xs-12 text">
                                    <span>1${s.salary2}</span>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-xs-12 text">
                                    <span>${s.salary3}</span>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-12 foot1">有<h>286</h>人正在学</div>
                    </div>
                    <div class="row">
                        <div class="col-md-12 foot2">${s.hint}</div>
                    </div>
                </div>
            </c:forEach>
        </div>
</div>
<footer>
    <div class="one">
        <div class="one1">技能树-改变你我</div>
        <div class="one2">旗下网站</div>
        <div class="one3">微信公众平台</div>
    </div>
    <div class="two">
        <div class="two1">
            <a href="#">关于我们|</a>
            <a href="#">联系我们|</a>
            <a href="#">合作企业|</a>
        </div>
        <div class="two2">
            <a href="#">草船云孵化器|</a>
            <a href="#">最强IT特训营|</a><br>
            <a href="#">葡萄藤轻游戏|</a>
            <a href="#">桌游精灵|</a>
        </div>
        <div class="two3"></div>
    </div>
    <div class="three">Copyright © 2015技能树 www.jnshu.com All Rights Reserved | <京ICP备13005800号></京ICP备13005800号></div>
</footer>
</body>
</html>
