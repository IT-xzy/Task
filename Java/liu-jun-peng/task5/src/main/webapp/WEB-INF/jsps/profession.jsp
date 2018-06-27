<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="css/profession.css">
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
            <strong>前端开发方向</strong>
<c:if test="${!empty proList }">
<c:forEach items="${proList}" var="item" begin="0" end="1">
            <div class="col-xs-12 col-sm-6 col-md-4">
                <div class="warp">
                    <table border="1" class="text">
                        <tr>
                            <th><img src="images/img022.png" alt="" class="avast"></th>
                            <td>
                                <strong>${item.vpt}</strong>
                                <p>${item.obligation}</p>
                            </td>
                        </tr>
                        <tr>
                          <c:if test="${item.sill == 1}">
                            <td>门槛<img src="images/star.png" alt=""></td>
                          </c:if>
    <c:if test="${item.complexity == 1}">
                            <td>难易程度<img src="images/star.png" alt=""><img src="images/star.png" alt=""></td>
                            </c:if>
                        </tr>
                        <tr>
    
                            <td>成长周期 <em>${item.growth}</em>年</td>
                            <td>稀缺程度 <em>${item.rareness}</em>家公司需要</td>
                        </tr>
                        <tr>
                            <td>薪资待遇</td>
                            <td>

                                <div>0-1年<span>${item.money}W/月</span></div>
                                <div>1-3年<span>${item.money}W/月</span></div>
                                <div>3-5年<span>${item.money}W/月</span></div>
                            </td>
                        </tr>
                        <tr>
                            <td colspan="2">有<em>${item.online}</em>人正在学</td>
                        </tr>
                        <tr>
                            <td colspan="2">提示:${item.tip}</td>
                        </tr>
                        </c:forEach>
                        </c:if>
                    </table>
                    <div class="zezhao"><strong>iOS工程师</strong>iOS是由苹果公司开发的移动操作统，iOS与苹果的Mac OS X操作系统一样，也是以Darwin为基础的，因此同样属于类Unix的商业操作系统。国内iOS开发起步相对较晚，人才培养机制更是远远跟不上市场发展速度。有限的iOS开发人才成了国内企业必争的资源。国内  iOS开发起步相对较晚，人才培养机制更是远远跟不上市场发展速度。有限的iOS开发人才成了国内企业必争的资源。</div>
                </div>
            </div>
            <div class="col-xs-12 col-sm-6 col-md-4">
                <div class="warp">
                    <table border="1" class="text">
                        <tr>
                            <th><img src="images/img022.png" alt="" class="avast"></th>
                            <td>
                                <strong>Web前端工程师</strong>
                                <p>Web前端开发工程师，主要职责是利用（X）HTML/CSS/JavaScript/flash等各种Web技术进行产品的开发。</p>
                            </td>
                        </tr>
                        <tr>
                            <td>门槛<img src="images/star.png" alt=""></td>
                            <td>难易程度<img src="images/star.png" alt=""><img src="images/star.png" alt=""></td>
                        </tr>
                        <tr>
                            <td>成长周期 <em>1-3</em>年</td>
                            <td>稀缺程度 <em>345</em>家公司需要</td>
                        </tr>
                        <tr>
                            <td>薪资待遇</td>
                            <td>
                                <div>0-1年<span>5k-10k/月</span></div>
                                <div>1-3年<span>10k-20k/月</span></div>
                                <div>3-5年<span>20k-50k/月</span></div>
                            </td>
                        </tr>
                        <tr>
                            <td colspan="2">有<em>286</em>人正在学</td>
                        </tr>
                        <tr>
                            <td colspan="2">提示:在你学习之前你应该已经掌握XXXXX、XXXXX、XX等语言基础</td>
                        </tr>
                    </table>
                    <div class="zezhao"><strong>iOS工程师</strong>iOS是由苹果公司开发的移动操作统，iOS与苹果的Mac OS X操作系统一样，也是以Darwin为基础的，因此同样属于类Unix的商业操作系统。国内iOS开发起步相对较晚，人才培养机制更是远远跟不上市场发展速度。有限的iOS开发人才成了国内企业必争的资源。国内  iOS开发起步相对较晚，人才培养机制更是远远跟不上市场发展速度。有限的iOS开发人才成了国内企业必争的资源。</div>
                </div>
            </div>
            <div class="col-xs-12 col-sm-6 col-md-4">
                <div class="warp">
                    <table border="1" class="text">
                        <tr>
                            <th><img src="images/img022.png" alt="" class="avast"></th>
                            <td>
                                <strong>Web前端工程师</strong>
                                <p>Web前端开发工程师，主要职责是利用（X）HTML/CSS/JavaScript/flash等各种Web技术进行产品的开发。</p>
                            </td>
                        </tr>
                        <tr>
                            <td>门槛<img src="images/star.png" alt=""></td>
                            <td>难易程度<img src="images/star.png" alt=""><img src="../images/star.png" alt=""></td>
                        </tr>
                        <tr>
                            <td>成长周期 <em>1-3</em>年</td>
                            <td>稀缺程度 <em>345</em>家公司需要</td>
                        </tr>
                        <tr>
                            <td>薪资待遇</td>
                            <td>
                                <div>0-1年<span>5k-10k/月</span></div>
                                <div>1-3年<span>10k-20k/月</span></div>
                                <div>3-5年<span>20k-50k/月</span></div>
                            </td>
                        </tr>
                        <tr>
                            <td colspan="2">有<em>286</em>人正在学</td>
                        </tr>
                        <tr>
                            <td colspan="2">提示:在你学习之前你应该已经掌握XXXXX、XXXXX、XX等语言基础</td>
                        </tr>
                    </table>
                    <div class="zezhao"><strong>iOS工程师</strong>iOS是由苹果公司开发的移动操作统，iOS与苹果的Mac OS X操作系统一样，也是以Darwin为基础的，因此同样属于类Unix的商业操作系统。国内iOS开发起步相对较晚，人才培养机制更是远远跟不上市场发展速度。有限的iOS开发人才成了国内企业必争的资源。国内  iOS开发起步相对较晚，人才培养机制更是远远跟不上市场发展速度。有限的iOS开发人才成了国内企业必争的资源。</div>
                </div>
            </div>
        </div> <!-- main-row -->
    </div> <!-- container -->
    <div class="container">
        <div class="row nav-strong">
            <strong>后端开发方向</strong>
            <div class="col-xs-12 col-sm-6 col-md-4">
                <div class="warp">
                    <table border="1" class="text">
                        <tr>
                            <th><img src="../images/img022.png" alt="" class="avast"></th>
                            <td>
                                <strong>Web前端工程师</strong>
                                <p>Web前端开发工程师，主要职责是利用（X）HTML/CSS/JavaScript/flash等各种Web技术进行产品的开发。</p>
                            </td>
                        </tr>
                        <tr>
                            <td>门槛<img src="../images/star.png" alt=""></td>
                            <td>难易程度<img src="../images/star.png" alt=""><img src="../images/star.png" alt=""></td>
                        </tr>
                        <tr>
                            <td>成长周期 <em>1-3</em>年</td>
                            <td>稀缺程度 <em>345</em>家公司需要</td>
                        </tr>
                        <tr>
                            <td>薪资待遇</td>
                            <td>
                                <div>0-1年<span>5k-10k/月</span></div>
                                <div>1-3年<span>10k-20k/月</span></div>
                                <div>3-5年<span>20k-50k/月</span></div>
                            </td>
                        </tr>
                        <tr>
                            <td colspan="2">有<em>286</em>人正在学</td>
                        </tr>
                        <tr>
                            <td colspan="2">提示:在你学习之前你应该已经掌握XXXXX、XXXXX、XX等语言基础</td>
                        </tr>
                    </table>
                    <div class="zezhao"><strong>iOS工程师</strong>iOS是由苹果公司开发的移动操作统，iOS与苹果的Mac OS X操作系统一样，也是以Darwin为基础的，因此同样属于类Unix的商业操作系统。国内iOS开发起步相对较晚，人才培养机制更是远远跟不上市场发展速度。有限的iOS开发人才成了国内企业必争的资源。国内  iOS开发起步相对较晚，人才培养机制更是远远跟不上市场发展速度。有限的iOS开发人才成了国内企业必争的资源。</div>
                </div>
            </div>
            <div class="col-xs-12 col-sm-6 col-md-4">
                <div class="warp">
                    <table border="1" class="text">
                        <tr>
                            <th><img src="../images/img022.png" alt="" class="avast"></th>
                            <td>
                                <strong>Web前端工程师</strong>
                                <p>Web前端开发工程师，主要职责是利用（X）HTML/CSS/JavaScript/flash等各种Web技术进行产品的开发。</p>
                            </td>
                        </tr>
                        <tr>
                            <td>门槛<img src="../images/star.png" alt=""></td>
                            <td>难易程度<img src="../images/star.png" alt=""><img src="../images/star.png" alt=""></td>
                        </tr>
                        <tr>
                            <td>成长周期 <em>1-3</em>年</td>
                            <td>稀缺程度 <em>345</em>家公司需要</td>
                        </tr>
                        <tr>
                            <td>薪资待遇</td>
                            <td>
                                <div>0-1年<span>5k-10k/月</span></div>
                                <div>1-3年<span>10k-20k/月</span></div>
                                <div>3-5年<span>20k-50k/月</span></div>
                            </td>
                        </tr>
                        <tr>
                            <td colspan="2">有<em>286</em>人正在学</td>
                        </tr>
                        <tr>
                            <td colspan="2">提示:在你学习之前你应该已经掌握XXXXX、XXXXX、XX等语言基础</td>
                        </tr>
                    </table>
                    <div class="zezhao"><strong>iOS工程师</strong>iOS是由苹果公司开发的移动操作统，iOS与苹果的Mac OS X操作系统一样，也是以Darwin为基础的，因此同样属于类Unix的商业操作系统。国内iOS开发起步相对较晚，人才培养机制更是远远跟不上市场发展速度。有限的iOS开发人才成了国内企业必争的资源。国内  iOS开发起步相对较晚，人才培养机制更是远远跟不上市场发展速度。有限的iOS开发人才成了国内企业必争的资源。</div>
                </div>
            </div>
            <div class="col-xs-12 col-sm-6 col-md-4">
                <div class="warp">
                    <table border="1" class="text">
                        <tr>
                            <th><img src="../img/img022.png" alt="" class="avast"></th>
                            <td>
                                <strong>Web前端工程师</strong>
                                <p>Web前端开发工程师，主要职责是利用（X）HTML/CSS/JavaScript/flash等各种Web技术进行产品的开发。</p>
                            </td>
                        </tr>
                        <tr>
                            <td>门槛<img src="../img/star.png" alt=""></td>
                            <td>难易程度<img src="../img/star.png" alt=""><img src="../img/star.png" alt=""></td>
                        </tr>
                        <tr>
                            <td>成长周期 <em>1-3</em>年</td>
                            <td>稀缺程度 <em>345</em>家公司需要</td>
                        </tr>
                        <tr>
                            <td>薪资待遇</td>
                            <td>
                                <div>0-1年<span>5k-10k/月</span></div>
                                <div>1-3年<span>10k-20k/月</span></div>
                                <div>3-5年<span>20k-50k/月</span></div>
                            </td>
                        </tr>
                        <tr>
                            <td colspan="2">有<em>286</em>人正在学</td>
                        </tr>
                        <tr>
                            <td colspan="2">提示:在你学习之前你应该已经掌握XXXXX、XXXXX、XX等语言基础</td>
                        </tr>
                    </table>
                    <div class="zezhao"><strong>iOS工程师</strong>iOS是由苹果公司开发的移动操作统，iOS与苹果的Mac OS X操作系统一样，也是以Darwin为基础的，因此同样属于类Unix的商业操作系统。国内iOS开发起步相对较晚，人才培养机制更是远远跟不上市场发展速度。有限的iOS开发人才成了国内企业必争的资源。国内  iOS开发起步相对较晚，人才培养机制更是远远跟不上市场发展速度。有限的iOS开发人才成了国内企业必争的资源。</div>
                </div>
            </div>
            <div class="col-xs-12 col-sm-6 col-md-4">
                <div class="warp">
                    <table border="1" class="text">
                        <tr>
                            <th><img src="../img/img022.png" alt="" class="avast"></th>
                            <td>
                                <strong>Web前端工程师</strong>
                                <p>Web前端开发工程师，主要职责是利用（X）HTML/CSS/JavaScript/flash等各种Web技术进行产品的开发。</p>
                            </td>
                        </tr>
                        <tr>
                            <td>门槛<img src="../img/star.png" alt=""></td>
                            <td>难易程度<img src="../img/star.png" alt=""><img src="../img/star.png" alt=""></td>
                        </tr>
                        <tr>
                            <td>成长周期 <em>1-3</em>年</td>
                            <td>稀缺程度 <em>345</em>家公司需要</td>
                        </tr>
                        <tr>
                            <td>薪资待遇</td>
                            <td>
                                <div>0-1年<span>5k-10k/月</span></div>
                                <div>1-3年<span>10k-20k/月</span></div>
                                <div>3-5年<span>20k-50k/月</span></div>
                            </td>
                        </tr>
                        <tr>
                            <td colspan="2">有<em>286</em>人正在学</td>
                        </tr>
                        <tr>
                            <td colspan="2">提示:在你学习之前你应该已经掌握XXXXX、XXXXX、XX等语言基础</td>
                        </tr>
                    </table>
                    <div class="zezhao"><strong>iOS工程师</strong>iOS是由苹果公司开发的移动操作统，iOS与苹果的Mac OS X操作系统一样，也是以Darwin为基础的，因此同样属于类Unix的商业操作系统。国内iOS开发起步相对较晚，人才培养机制更是远远跟不上市场发展速度。有限的iOS开发人才成了国内企业必争的资源。国内  iOS开发起步相对较晚，人才培养机制更是远远跟不上市场发展速度。有限的iOS开发人才成了国内企业必争的资源。</div>
                </div>
            </div>
            <div class="col-xs-12 col-sm-6 col-md-4">
                <div class="warp">
                    <table border="1" class="text">
                        <tr>
                            <th><img src="../img/img022.png" alt="" class="avast"></th>
                            <td>
                                <strong>Web前端工程师</strong>
                                <p>Web前端开发工程师，主要职责是利用（X）HTML/CSS/JavaScript/flash等各种Web技术进行产品的开发。</p>
                            </td>
                        </tr>
                        <tr>
                            <td>门槛<img src="../img/star.png" alt=""></td>
                            <td>难易程度<img src="../img/star.png" alt=""><img src="../img/star.png" alt=""></td>
                        </tr>
                        <tr>
                            <td>成长周期 <em>1-3</em>年</td>
                            <td>稀缺程度 <em>345</em>家公司需要</td>
                        </tr>
                        <tr>
                            <td>薪资待遇</td>
                            <td>
                                <div>0-1年<span>5k-10k/月</span></div>
                                <div>1-3年<span>10k-20k/月</span></div>
                                <div>3-5年<span>20k-50k/月</span></div>
                            </td>
                        </tr>
                        <tr>
                            <td colspan="2">有<em>286</em>人正在学</td>
                        </tr>
                        <tr>
                            <td colspan="2">提示:在你学习之前你应该已经掌握XXXXX、XXXXX、XX等语言基础</td>
                        </tr>
                    </table>
                    <div class="zezhao"><strong>iOS工程师</strong>iOS是由苹果公司开发的移动操作统，iOS与苹果的Mac OS X操作系统一样，也是以Darwin为基础的，因此同样属于类Unix的商业操作系统。国内iOS开发起步相对较晚，人才培养机制更是远远跟不上市场发展速度。有限的iOS开发人才成了国内企业必争的资源。国内  iOS开发起步相对较晚，人才培养机制更是远远跟不上市场发展速度。有限的iOS开发人才成了国内企业必争的资源。</div>
                </div>
            </div>
        </div> <!-- main-row -->
    </div> <!-- container -->
    <div class="container">
        <div class="row nav-strong">
            <strong>运维方向</strong>
            <div class="col-xs-12 col-sm-6 col-md-4">
                <div class="warp">
                    <table border="1" class="text">
                        <tr>
                            <th><img src="../img/img022.png" alt="" class="avast"></th>
                            <td>
                                <strong>Web前端工程师</strong>
                                <p>Web前端开发工程师，主要职责是利用（X）HTML/CSS/JavaScript/flash等各种Web技术进行产品的开发。</p>
                            </td>
                        </tr>
                        <tr>
                            <td>门槛<img src="../img/star.png" alt=""></td>
                            <td>难易程度<img src="../img/star.png" alt=""><img src="../img/star.png" alt=""></td>
                        </tr>
                        <tr>
                            <td>成长周期 <em>1-3</em>年</td>
                            <td>稀缺程度 <em>345</em>家公司需要</td>
                        </tr>
                        <tr>
                            <td>薪资待遇</td>
                            <td>
                                <div>0-1年<span>5k-10k/月</span></div>
                                <div>1-3年<span>10k-20k/月</span></div>
                                <div>3-5年<span>20k-50k/月</span></div>
                            </td>
                        </tr>
                        <tr>
                            <td colspan="2">有<em>286</em>人正在学</td>
                        </tr>
                        <tr>
                            <td colspan="2">提示:在你学习之前你应该已经掌握XXXXX、XXXXX、XX等语言基础</td>
                        </tr>
                    </table>
                    <div class="zezhao"><strong>iOS工程师</strong>iOS是由苹果公司开发的移动操作统，iOS与苹果的Mac OS X操作系统一样，也是以Darwin为基础的，因此同样属于类Unix的商业操作系统。国内iOS开发起步相对较晚，人才培养机制更是远远跟不上市场发展速度。有限的iOS开发人才成了国内企业必争的资源。国内  iOS开发起步相对较晚，人才培养机制更是远远跟不上市场发展速度。有限的iOS开发人才成了国内企业必争的资源。</div>
                </div>
            </div>
            <div class="col-xs-12 col-sm-6 col-md-4">
                <div class="warp">
                    <table border="1" class="text">
                        <tr>
                            <th><img src="../img/img022.png" alt="" class="avast"></th>
                            <td>
                                <strong>Web前端工程师</strong>
                                <p>Web前端开发工程师，主要职责是利用（X）HTML/CSS/JavaScript/flash等各种Web技术进行产品的开发。</p>
                            </td>
                        </tr>
                        <tr>
                            <td>门槛<img src="../img/star.png" alt=""></td>
                            <td>难易程度<img src="../img/star.png" alt=""><img src="../img/star.png" alt=""></td>
                        </tr>
                        <tr>
                            <td>成长周期 <em>1-3</em>年</td>
                            <td>稀缺程度 <em>345</em>家公司需要</td>
                        </tr>
                        <tr>
                            <td>薪资待遇</td>
                            <td>
                                <div>0-1年<span>5k-10k/月</span></div>
                                <div>1-3年<span>10k-20k/月</span></div>
                                <div>3-5年<span>20k-50k/月</span></div>
                            </td>
                        </tr>
                        <tr>
                            <td colspan="2">有<em>286</em>人正在学</td>
                        </tr>
                        <tr>
                            <td colspan="2">提示:在你学习之前你应该已经掌握XXXXX、XXXXX、XX等语言基础</td>
                        </tr>
                    </table>
                    <div class="zezhao"><strong>iOS工程师</strong>iOS是由苹果公司开发的移动操作统，iOS与苹果的Mac OS X操作系统一样，也是以Darwin为基础的，因此同样属于类Unix的商业操作系统。国内iOS开发起步相对较晚，人才培养机制更是远远跟不上市场发展速度。有限的iOS开发人才成了国内企业必争的资源。国内  iOS开发起步相对较晚，人才培养机制更是远远跟不上市场发展速度。有限的iOS开发人才成了国内企业必争的资源。</div>
                </div>
            </div>
            <div class="col-xs-12 col-sm-6 col-md-4">
                <div class="warp">
                    <table border="1" class="text">
                        <tr>
                            <th><img src="../img/img022.png" alt="" class="avast"></th>
                            <td>
                                <strong>Web前端工程师</strong>
                                <p>Web前端开发工程师，主要职责是利用（X）HTML/CSS/JavaScript/flash等各种Web技术进行产品的开发。</p>
                            </td>
                        </tr>
                        <tr>
                            <td>门槛<img src="../img/star.png" alt=""></td>
                            <td>难易程度<img src="../img/star.png" alt=""><img src="../img/star.png" alt=""></td>
                        </tr>
                        <tr>
                            <td>成长周期 <em>1-3</em>年</td>
                            <td>稀缺程度 <em>345</em>家公司需要</td>
                        </tr>
                        <tr>
                            <td>薪资待遇</td>
                            <td>
                                <div>0-1年<span>5k-10k/月</span></div>
                                <div>1-3年<span>10k-20k/月</span></div>
                                <div>3-5年<span>20k-50k/月</span></div>
                            </td>
                        </tr>
                        <tr>
                            <td colspan="2">有<em>286</em>人正在学</td>
                        </tr>
                        <tr>
                            <td colspan="2">提示:在你学习之前你应该已经掌握XXXXX、XXXXX、XX等语言基础</td>
                        </tr>
                    </table>
                    <div class="zezhao"><strong>iOS工程师</strong>iOS是由苹果公司开发的移动操作统，iOS与苹果的Mac OS X操作系统一样，也是以Darwin为基础的，因此同样属于类Unix的商业操作系统。国内iOS开发起步相对较晚，人才培养机制更是远远跟不上市场发展速度。有限的iOS开发人才成了国内企业必争的资源。国内  iOS开发起步相对较晚，人才培养机制更是远远跟不上市场发展速度。有限的iOS开发人才成了国内企业必争的资源。</div>
                </div>
            </div>
        </div> <!-- main-row -->
    </div> <!-- container -->
    <div class="container">
        <div class="row nav-strong">
            <strong>产品方向</strong>
            <div class="col-xs-12 col-sm-6 col-md-4">
                <div class="warp">
                    <table border="1" class="text">
                        <tr>
                            <th><img src="../img/img022.png" alt="" class="avast"></th>
                            <td>
                                <strong>Web前端工程师</strong>
                                <p>Web前端开发工程师，主要职责是利用（X）HTML/CSS/JavaScript/flash等各种Web技术进行产品的开发。</p>
                            </td>
                        </tr>
                        <tr>
                            <td>门槛<img src="img/star.png" alt=""></td>
                            <td>难易程度<img src="img/star.png" alt=""><img src="img/star.png" alt=""></td>
                        </tr>
                        <tr>
                            <td>成长周期 <em>1-3</em>年</td>
                            <td>稀缺程度 <em>345</em>家公司需要</td>
                        </tr>
                        <tr>
                            <td>薪资待遇</td>
                            <td>
                                <div>0-1年<span>5k-10k/月</span></div>
                                <div>1-3年<span>10k-20k/月</span></div>
                                <div>3-5年<span>20k-50k/月</span></div>
                            </td>
                        </tr>
                        <tr>
                            <td colspan="2">有<em>286</em>人正在学</td>
                        </tr>
                        <tr>
                            <td colspan="2">提示:在你学习之前你应该已经掌握XXXXX、XXXXX、XX等语言基础</td>
                        </tr>
                    </table>
                    <div class="zezhao"><strong>iOS工程师</strong>iOS是由苹果公司开发的移动操作统，iOS与苹果的Mac OS X操作系统一样，也是以Darwin为基础的，因此同样属于类Unix的商业操作系统。国内iOS开发起步相对较晚，人才培养机制更是远远跟不上市场发展速度。有限的iOS开发人才成了国内企业必争的资源。国内  iOS开发起步相对较晚，人才培养机制更是远远跟不上市场发展速度。有限的iOS开发人才成了国内企业必争的资源。</div>
                </div>
            </div>
        </div> <!-- main-row -->
    </div> <!-- container -->
</main>
</body>
</html>
