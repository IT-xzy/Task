<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="java.util.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" name="viewport" content="width=device-width"
          initial-scale=1 maximum-scale=1 minimum-scale=1 user-scalable=no>
    <title>task8-three</title>
    <link rel="stylesheet" href="/view/jnshu/css/three.css">
    <script src="/view/jnshu/js/jquery-3.2.1.min.js"></script>
    <link href="/view/jnshu/css/bootstrap.min.css"
          rel="stylesheet">
    <script src="/view/jnshu/js/bootstrap.min.js"></script>
</head>
<body>

<div class="header-end">
    <a href="/a/home" class="end-left">首页</a>>
    <p class="end-right">职业</p>
</div>

<!--main-->
<main>

    <ul class="main-top">
        <p>方向：</p>
        <li class="path">
            <a href="#">全部</a>
        </li>
        <li class="path">
            <a href="#help-1">前端开发</a>
        </li>
        <li class="path">
            <a href="#help-2">后端开发</a>
        </li>
        <li class="path">
            <a href="#help-3">移动开发</a>
        </li>
        <li class="path">
            <a href="#help-4">整站开发</a>
        </li>
        <li class="path">
            <a href="#help-5">运营维护</a>
        </li>
    </ul>
    <p class="form-title"><a name="help-1"></a>前端开发方向</p>
    <div class="content">
        <div class="form">
            <div class="hover">
                <div class="hover1">iOS工程师</div>
                <div class="hover2">iOS是由苹果公司开发的移动操作系统，iOS与苹果的MacOSX操作系统一样，也是以Darwin为基础的，因此同样属于类Unix 的商业操作系统。国内iOS开发起步相对较晚，人才培养机制更是远远跟不上市场发展速度，有限的iOS开发人才成了国内企业必争的资源。国内iOS开发起步相对较晚，人才培养机制更是远远跟不上市场发展速度，有限的iOS开发人才成了国内企业必争的资源。
                </div>
            </div>
            <div class="header">
                <img src="/view/jnshu/img/three/toux.png">
                <div>
                    <h4>Web前端开发师</h4>
                    Web前端开发工程师，主要职责是利用(X)HTML /CSS /JavaScript /flash等
                    各种Web技术进行产品的开发。
                </div>
            </div>
            <div class="list">
                <div class="list-top">
                    <div class="list-top-1">
                        <div class="list-top-1-left">
                            门槛
                            <img src="/view/jnshu/img/three/xx.png" width="10" height="10">
                        </div>
                        <div class="list-top-1-right">
                            难易程度
                            <img src="/view/jnshu/img/three/xx.png" width="10" height="10">
                            <img src="/view/jnshu/img/three/xx.png" width="10" height="10">
                        </div>
                    </div>
                    <div class="list-top-2">
                        <div class="list-top-2-left">
                            成长周期
                            <p>1-3
                                <b>年</b>
                            </p>
                        </div>
                        <div class="list-top-2-right">
                            稀缺程度
                            <p>3450
                                <b>家公司需要</b>
                            </p>
                        </div>
                    </div>
                </div>
                <div class="list-center">
                    <div class="list-center-left">薪资待遇</div>
                    <div class="list-center-right">
                        <div class="list-center-right-text">
                            <p>0-1年</p>
                            <p>5k-8k/月</p>
                        </div>
                        <div class="list-center-right-text">
                            <p>1-3年</p>
                            <p>8k-15k/月</p>
                        </div>
                        <div class="list-center-right-end">
                            <p>3-5年</p>
                            <p>15k-30k/月</p>
                        </div>
                    </div>
                </div>
                <div class="list-end">
                    <p>有<b>2</b>人正在学</p>
                </div>
            </div>
            <div class="footer">
                提示：在你学习之前你应该已经掌握了一定C语言基础
            </div>
        </div>
        <div class="none-margin"></div>
        <div class="none"></div>
    </div>
    <p class="form-title"><a name="help-2"></a>后端开发方向</p>
    <div class="content">
        <div class="form">
            <div class="hover">
                <div class="hover1">Java工程师</div>
                <div class="hover2">Java是一种可以撰写跨平台应用软件的面向对象的程序设计语言。Java 技术具有卓越的通用性、高效性、平台移植性和安全性，广泛应用于PC、数据中心、游戏控制台、科学超级计算机、移动电话和互联网，同时拥有全球最大的开发者专业社群。
                </div>
            </div>
            <div class="header">
                <img src="/view/jnshu/img/three/toux.png">
                <div>
                    <h4>Java后端开发工程师</h4>
                    Java后端开发工程师，主要职责是完成软件的设计、开发、测试、修改bug等工作，包括业务需求的沟通，功能模块详细设计，业务功能实现与单元测试，系统维护。
                </div>
            </div>
            <div class="list">
                <div class="list-top">
                    <div class="list-top-1">
                        <div class="list-top-1-left">
                            门槛
                            <img src="/view/jnshu/img/three/xx.png" width="10" height="10">
                            <img src="/view/jnshu/img/three/xx.png" width="10" height="10">
                            <img src="/view/jnshu/img/three/xx.png" width="10" height="10">
                        </div>
                        <div class="list-top-1-right">
                            难易程度
                            <img src="/view/jnshu/img/three/xx.png" width="10" height="10">
                            <img src="/view/jnshu/img/three/xx.png" width="10" height="10">
                            <img src="/view/jnshu/img/three/xx.png" width="10" height="10">
                            <img src="/view/jnshu/img/three/xx.png" width="10" height="10">
                        </div>
                    </div>
                    <div class="list-top-2">
                        <div class="list-top-2-left">
                            成长周期
                            <p>1-3
                                <b>年</b>
                            </p>
                        </div>
                        <div class="list-top-2-right">
                            稀缺程度
                            <p>15876
                                <b>家公司需要</b>
                            </p>
                        </div>
                    </div>
                </div>
                <div class="list-center">
                    <div class="list-center-left">薪资待遇</div>
                    <div class="list-center-right">
                        <div class="list-center-right-text">
                            <p>0-1年</p>
                            <p>5k-10k/月</p>
                        </div>
                        <div class="list-center-right-text">
                            <p>1-3年</p>
                            <p>10k-20k/月</p>
                        </div>
                        <div class="list-center-right-end">
                            <p>3-5年</p>
                            <p>20k-50k/月</p>
                        </div>
                    </div>
                </div>
                <div class="list-end">
                    <p>有<b>12</b>人正在学</p>
                </div>
            </div>
            <div class="footer">
                提示：在你学习之前你应该已经掌握了sql语句、JavaSE等语言基础
            </div>
        </div>
        <div class="none-margin"></div>
        <div class="none"></div>
    </div>
    <p class="form-title"><a name="help-5"></a>运维方向</p>
    <div class="content">
        <div class="none-margin"></div>
        <div class="none-margin"></div>
        <div class="none"></div>
    </div>
    <p class="form-title"><a name="help-5"></a>运维方向</p>
    <div class="content">
        <div class="none-margin"></div>
        <div class="none-margin"></div>
        <div class="none"></div>
    </div>
</main>

</body>
</html>
