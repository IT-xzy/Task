<!DOCTYPE html>
<html lang="en">
<%@ page contentType="text/html;charset=UTF-8" language="java" isErrorPage="true" isELIgnored="false"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0;">
    <meta name="format-detection" content="telephone=no">
    <title>职位</title>
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="/task4/css/base.css">
    <link rel="stylesheet" href="/task4/css/task-93.css">
    <script src="https://cdn.bootcss.com/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>

<body>
    <!-- 头部 -->
    <header>
        <div class="top w">
            <div class="num">客服热线：010-594-78634</div>
            <div class="logos">
                <img src="/task4/images/wx.png" alt="">
                <img src="/task4/images/qq.png" alt="">
                <img src="/task4/images/xl.jpg" alt="">
            </div>
        </div>
        <div class="top1">
            登陆&nbsp<span>|</span>&nbsp注册
        </div>
        <nav>
            <ul class=" nav1 w">
                <img src="/task4/images/logo.png" alt="">
                <li><a href="task-91.">首页</a></li>
                <li><a href="task-93">职业</a></li>
                <li><a href="task-92">推荐</a></li>
                <li><a href="">关于</a></li>
            </ul>
            <div class="dropdown">
                <img class="ji" src="/task4/images/logo.png" alt="">
                <button class="btn dropdown-toggle clearfix" type="button" id="dropdownMenu1" data-toggle="dropdown"
                    aria-haspopup="true" aria-expanded="true">
                    <span>
                        <img src="/task4/images/btn1.png" alt="">
                    </span>
                </button>
                <ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
                    <li><a href="task-91">首页</a></li>
                    <li><a href="task-93">职业</a></li>
                    <li><a href="task-92">推荐</a></li>
                    <li><a href="#">关于</a></li>
                </ul>
            </div>
        </nav>
    </header>

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
                    <div class="people col-md-4 col-sm-12 col-xs-12">
                        <c:forEach items="${professionList}" var="profession">
                        <div class="first">
                            <img src=/task4${profession.img} alt="">
                            <div class="txt">
                                <p>${profession.job}</p>
                                <span>${profession.introduce}</span>
                            </div>
                        </div>
                        <div class="sec">
                            <div class="menk">门槛
                                <c:forEach begin="0" end="${profession.door}" step ="1">
                                <img src="/task4/images/star.png" alt="">
                                </c:forEach>
                            </div>
                            <div class="nan">难易程度
                                <c:forEach begin="0" end="${profession.difficulty}" step ="1">
                                <img src="/task4/images/star.png" alt="">
                                </c:forEach>
                            </div>
                        </div>
                        <div class="sec">
                            <div class="menk">成长周期：
                                <span><i>${profession.growth}</i>年</span>
                            </div>
                            <div class="nan">稀缺程度：
                                <span><i>${profession.needDegree}</i>公司需要</span>
                            </div>
                        </div>
                        <div class="third">
                            <div class="l">薪资待遇</div>
                            <ul class="r">
                                <li class="line">${profession.years}年<span>${profession.salary}k</span></li>
                                <li class="line">${profession.years}年<span>${profession.salary}k</span></li>
                                <li>${profession.years}年<span>${profession.salary}k</span></li>
                            </ul>
                        </div>
                        <div class="four">
                            有<i>${count}</i>人正在学习
                        </div>
                        <div class="five">
                            提示:在你学习之前你应该已经掌握XXXXX、XXXXX、XX等语言基础
                        </div>
                        <div class="mask">
                            <p>ios工程师</p>
                            <span>iOS是由苹果公司开发的移动操作统，iOS与苹果的Mac OS X操作系统一样，也是以Darwin为基础的，因此同样属于类Unix的商业操作系统。国内iOS开
                                发起步相对较晚，人才培养机制更是远
                                远跟不上市场发展速度。有限的iOS开发人才成了国内企业必争的资源。国内
                                iOS开发起步相对较晚，人才培养机制更是远远跟不上市场发展速度。有限的iOS开发人才成了国内企业必争的资源。</span>
                        </div>
                        </c:forEach>
                    </div>
                </div>
                <div class="head col-md-12 col-sm-12 col-xs-12">后端开发方向</div>
                <div class="content">
                    <div class="people col-md-4 col-sm-12 col-xs-12">
                        <div class="first">
                            <img src="/task4/images/tx1.jpg" alt="">
                            <div class="txt">
                                <p>后端工程师</p>
                                <span>Web前端开发工程师，主要职责是 利用（X）HTML/CSS/JavaScript/ flash等各种Web技术进行产品的开发。
                                </span>
                            </div>
                        </div>
                        <div class="sec">
                            <div class="menk">门槛
                                <img src="/task4/images/star.png" alt="">
                            </div>
                            <div class="nan">难易程度
                                <img src="/task4/images/star.png" alt="">
                                <img src="/task4/images/star.png" alt="">
                            </div>
                        </div>
                        <div class="sec">
                            <div class="menk">成长周期：
                                <span><i>1-3</i>年</span>
                            </div>
                            <div class="nan">稀缺程度：
                                <span><i>345</i>公司需要</span>
                            </div>
                        </div>
                        <div class="third">
                            <div class="l">薪资待遇</div>
                            <ul class="r">
                                <li class="line">0-1年<span>5k-10k</span></li>
                                <li class="line">1-3年<span>10k-20k</span></li>
                                <li>3-5年<span>20k-30k</span></li>
                            </ul>
                        </div>
                        <div class="four">
                            有<i>235</i>人正在学习
                        </div>
                        <div class="five">
                            提示:在你学习之前你应该已经掌握XXXXX、XXXXX、XX等语言基础
                        </div>
                        <div class="mask">
                            <p>ios工程师</p>
                            <span>iOS是由苹果公司开发的移动操作统，iOS与苹果的Mac OS X操作系统一样，也是以Darwin为基础的，因此同样属于类Unix的商业操作系统。国内iOS开
                                发起步相对较晚，人才培养机制更是远
                                远跟不上市场发展速度。有限的iOS开发人才成了国内企业必争的资源。国内
                                iOS开发起步相对较晚，人才培养机制更是远远跟不上市场发展速度。有限的iOS开发人才成了国内企业必争的资源。</span>
                        </div>
                    </div>
                </div>
                <div class="head col-md-12 col-sm-12 col-xs-12">运维方向</div>
                <div class="content">
                    <div class="people col-md-4 col-sm-12 col-xs-12">
                        <div class="first">
                            <img src="/task4/images/tx1.jpg" alt="">
                            <div class="txt">
                                <p>运维工程师</p>
                                <span>Web前端开发工程师，主要职责是 利用（X）HTML/CSS/JavaScript/ flash等各种Web技术进行产品的开发。
                                </span>
                            </div>
                        </div>
                        <div class="sec">
                            <div class="menk">门槛
                                <img src="/task4/images/star.png" alt="">
                            </div>
                            <div class="nan">难易程度
                                <img src="/task4/images/star.png" alt="">
                                <img src="/task4/images/star.png" alt="">
                            </div>
                        </div>
                        <div class="sec">
                            <div class="menk">成长周期：
                                <span><i>1-3</i>年</span>
                            </div>
                            <div class="nan">稀缺程度：
                                <span><i>345</i>公司需要</span>
                            </div>
                        </div>
                        <div class="third">
                            <div class="l">薪资待遇</div>
                            <ul class="r">
                                <li class="line">0-1年<span>5k-10k</span></li>
                                <li class="line">1-3年<span>10k-20k</span></li>
                                <li>3-5年<span>20k-30k</span></li>
                            </ul>
                        </div>
                        <div class="four">
                            有<i>${count}</i>人正在学习
                        </div>
                        <div class="five">
                            提示:在你学习之前你应该已经掌握XXXXX、XXXXX、XX等语言基础
                        </div>
                        <div class="mask">
                            <p>ios工程师</p>
                            <span>iOS是由苹果公司开发的移动操作统，iOS与苹果的Mac OS X操作系统一样，也是以Darwin为基础的，因此同样属于类Unix的商业操作系统。国内iOS开
                                发起步相对较晚，人才培养机制更是远
                                远跟不上市场发展速度。有限的iOS开发人才成了国内企业必争的资源。国内
                                iOS开发起步相对较晚，人才培养机制更是远远跟不上市场发展速度。有限的iOS开发人才成了国内企业必争的资源。</span>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- 脚部 -->
    <footer>
        <div class="box">
            <div class="top w">
                <div class="container">
                    <div class="row">
                        <div class="first col-xs-12 col-md-4">
                            <div class="up">技能树&nbsp——&nbsp改变你我</div>
                            <div class="down">
                                <a href="">关于我们</a>&nbsp|&nbsp
                                <a href="">联系我们</a>&nbsp|&nbsp
                                <a href="">合作企业</a>
                            </div>
                        </div>
                        <div class="second col-xs-12 col-md-5">
                            <div class="up">旗下网站</div>
                            <div class="down">
                                <p>
                                    <a href="">草船云孵化器</a>&#12288
                                    <a href="">最强IT特训营</a>
                                </p>
                                <p>
                                    <a href="">葡萄藤轻游戏</a>&#12288
                                    <a href="">桌游游戏</a>
                                </p>
                            </div>
                        </div>
                        <div class="third col-xs-12 col-md-3">
                            <p>微信公众号</p>
                            <img src="/task4/images/qcode.jpg" alt="">
                        </div>
                    </div>
                </div>

            </div>
        </div>
        <div class="">
            <div class="bottom w">
                Copyright © 2015技能树 www.jnshu.com All Rights Reserved <span>|</span>京ICP备
            </div>
        </div>
    </footer>
</body>

</html>