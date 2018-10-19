<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/6/21
  Time: 8:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="/tags" prefix="zhh"%>

<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/default.css">
    <link rel="stylesheet" href="/css/job.css">
</head>
<body>
<main>
    <div class="container">
        <h4>
            <a href="/home"><strong>首页</strong></a>
            &gt;
            <a href="/job"><strong>职业</strong></a>
        </h4>
        <nav>
            <span>方向：</span>
            <a class="nav-focus" href="#"> 全部 </a>
            <a href="#fe"> 前端开发 </a>
            <a href="#be"> 后端开发 </a>
            <a href="#mobile"> 移动开发 </a>
            <a href="#site"> 整站开发 </a>
            <a href="#op"> 运营维护 </a>
        </nav>
        <h4 id="fe"><strong>前端开发方向</strong></h4>
        <div class="row">
            <c:forEach var="i" begin="0" end="7" step="1">
                <c:if test="${subject[i].id==1}">
            <div class="col-sm-6 col-md-4">
                <section class="dev">
                    <section>
                        <header>
                            <img src="/img/dev-icon.png" alt="dev-icon">
                            <%--获取数据第一种形式--%>
                            <h4><strong>${subject[i].name}</strong></h4>
                            <%--第二种--%>
                            <p>${subject.get(i).summary}</p>
                        </header>
                        <table class="table table-bordered">
                            <tbody>
                            <tr>
                                <td>
                                    <span>门槛</span>
                                    <c:forEach begin="1" end="${subject[i].threshold}">
                                    <img src="/img/star.png" alt="star">
                                    </c:forEach>
                                </td>
                                <td>
                                    <span>难易程度</span>
                                    <c:forEach begin="1" end="${subject[i].diffcultyLevel}">
                                    <img src="/img/star.png" alt="star">
                                    </c:forEach>
                                </td>
                            </tr>
                            <tr>
                                <td><span>成长周期</span><span class="color-red">${subject[i].growthCycle}</span><span>年</span></td>
                                <td><span>稀缺程度</span><span class="color-red">${subject[i].rareness}</span><span>家公司需要</span></td>
                            </tr>
                            <tr>
                                <td rowspan="3">薪资待遇</td>
                                <td><span>0-1年</span><span class="fl-right">${subject[i].salaryFirst}</span></td>
                            </tr>
                            <tr>
                                <td><span>1-3年</span><span class="fl-right">${subject[0].salarySecond}</span></td>
                            </tr>
                            <tr>
                                <td><span>3-5年</span><span class="fl-right">${subject[i].salaryThird}</span></td>
                            </tr>
                            <tr><td colspan="2"><strong>有 <span class="color-red">${subject[i].number}</span>人正在学</strong></td></tr>
                            <tr><td colspan="2">提示:在你学习之前你应该已经掌握${subject[i].information}等语言基础</td></tr>
                            </tbody>
                        </table>
                    </section>
                    <div class="dev-hov">
                        <h4>iOS工程师</h4>
                        <p>
                            iOS是由苹果公司开发的移动操作统，iOS与苹果的Mac OS X操作系统一样，也是以Darwin为基础的，因此同样属于类Unix的商业操作系统。
                            国内iOS开发起步相对较晚，人才培养机制更是远远跟不上市场发展速度。有限的iOS开发人才成了国内企业必争的资源。
                            国内iOS开发起步相对较晚，人才培养机制更是远远跟不上市场发展速度。有限的iOS开发人才成了国内企业必争的资源。
                        </p>
                    </div>
                </section>
            </div>
                </c:if>
            </c:forEach>
        </div>
        <h4 id="be"><strong>后端开发方向</strong></h4>
        <div class="row">

<c:forEach var="i" begin="0" end="7" step="1">
    <c:if test="${subject[i].id==2}">
        <div class="col-sm-6 col-md-4">
            <section class="dev">
                <section>
                    <header>
                        <img src="/img/dev-icon.png" alt="dev-icon">
                            <%--获取数据第一种形式--%>
                        <h4><strong>${subject[i].name}</strong></h4>
                            <%--第二种--%>
                        <p>${subject.get(i).summary}</p>
                    </header>
                    <table class="table table-bordered">
                        <tbody>
                        <tr>
                            <td>
                                <span>门槛</span>
                                <c:forEach begin="1" end="${subject[i].threshold}">
                                    <img src="/img/star.png" alt="star">
                                </c:forEach>
                            </td>
                            <td>
                                <span>难易程度</span>
                                <c:forEach begin="1" end="${subject[i].diffcultyLevel}">
                                    <img src="/img/star.png" alt="star">
                                </c:forEach>
                            </td>
                        </tr>
                        <tr>
                            <td><span>成长周期</span><span class="color-red">${subject[i].growthCycle}</span><span>年</span></td>
                            <td><span>稀缺程度</span><span class="color-red">${subject[i].rareness}</span><span>家公司需要</span></td>
                        </tr>
                        <tr>
                            <td rowspan="3">薪资待遇</td>
                            <td><span>0-1年</span><span class="fl-right">${subject[i].salaryFirst}</span></td>
                        </tr>
                        <tr>
                            <td><span>1-3年</span><span class="fl-right">${subject[0].salarySecond}</span></td>
                        </tr>
                        <tr>
                            <td><span>3-5年</span><span class="fl-right">${subject[i].salaryThird}</span></td>
                        </tr>
                        <tr><td colspan="2"><strong>有 <span class="color-red">${subject[i].number}</span>人正在学</strong></td></tr>
                        <tr><td colspan="2">提示:在你学习之前你应该已经掌握${subject[i].information}等语言基础</td></tr>
                        </tbody>
                    </table>
                </section>
                <div class="dev-hov">
                    <h4>iOS工程师</h4>
                    <p>
                        iOS是由苹果公司开发的移动操作统，iOS与苹果的Mac OS X操作系统一样，也是以Darwin为基础的，因此同样属于类Unix的商业操作系统。
                        国内iOS开发起步相对较晚，人才培养机制更是远远跟不上市场发展速度。有限的iOS开发人才成了国内企业必争的资源。
                        国内iOS开发起步相对较晚，人才培养机制更是远远跟不上市场发展速度。有限的iOS开发人才成了国内企业必争的资源。
                    </p>
                </div>
            </section>
        </div>
    </c:if>
</c:forEach>
        </div>
        <h4 id="mobile"><strong>移动开发方向</strong></h4>
        <div class="row">
            <c:forEach var="i" begin="0" end="7" step="1">
                <c:if test="${subject[i].id==3}">
                    <div class="col-sm-6 col-md-4">
                        <section class="dev">
                            <section>
                                <header>
                                    <img src="/img/dev-icon.png" alt="dev-icon">
                                        <%--获取数据第一种形式--%>
                                    <h4><strong>${subject[i].name}</strong></h4>
                                        <%--第二种--%>
                                    <p>${subject.get(i).summary}</p>
                                </header>
                                <table class="table table-bordered">
                                    <tbody>
                                    <tr>
                                        <td>
                                            <span>门槛</span>
                                            <c:forEach begin="1" end="${subject[i].threshold}">
                                                <img src="/img/star.png" alt="star">
                                            </c:forEach>
                                        </td>
                                        <td>
                                            <span>难易程度</span>
                                            <c:forEach begin="1" end="${subject[i].diffcultyLevel}">
                                                <img src="/img/star.png" alt="star">
                                            </c:forEach>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td><span>成长周期</span><span class="color-red">${subject[i].growthCycle}</span><span>年</span></td>
                                        <td><span>稀缺程度</span><span class="color-red">${subject[i].rareness}</span><span>家公司需要</span></td>
                                    </tr>
                                    <tr>
                                        <td rowspan="3">薪资待遇</td>
                                        <td><span>0-1年</span><span class="fl-right">${subject[i].salaryFirst}</span></td>
                                    </tr>
                                    <tr>
                                        <td><span>1-3年</span><span class="fl-right">${subject[0].salarySecond}</span></td>
                                    </tr>
                                    <tr>
                                        <td><span>3-5年</span><span class="fl-right">${subject[i].salaryThird}</span></td>
                                    </tr>
                                    <tr><td colspan="2"><strong>有 <span class="color-red">${subject[i].number}</span>人正在学</strong></td></tr>
                                    <tr><td colspan="2">提示:在你学习之前你应该已经掌握${subject[i].information}等语言基础</td></tr>
                                    </tbody>
                                </table>
                            </section>
                            <div class="dev-hov">
                                <h4>iOS工程师</h4>
                                <p>
                                    iOS是由苹果公司开发的移动操作统，iOS与苹果的Mac OS X操作系统一样，也是以Darwin为基础的，因此同样属于类Unix的商业操作系统。
                                    国内iOS开发起步相对较晚，人才培养机制更是远远跟不上市场发展速度。有限的iOS开发人才成了国内企业必争的资源。
                                    国内iOS开发起步相对较晚，人才培养机制更是远远跟不上市场发展速度。有限的iOS开发人才成了国内企业必争的资源。
                                </p>
                            </div>
                        </section>
                    </div>
                </c:if>
            </c:forEach>
        </div>
        <h4 id="site"><strong>整站开发方向</strong></h4>
        <div class="row">
            <c:forEach var="i" begin="0" end="7" step="1">
                <c:if test="${subject[i].id==4}">
                    <div class="col-sm-6 col-md-4">
                        <section class="dev">
                            <section>
                                <header>
                                    <img src="/img/dev-icon.png" alt="dev-icon">
                                        <%--获取数据第一种形式--%>
                                    <h4><strong>${subject[i].name}</strong></h4>
                                        <%--第二种--%>
                                    <p>${subject.get(i).summary}</p>
                                </header>
                                <table class="table table-bordered">
                                    <tbody>
                                    <tr>
                                        <td>
                                            <span>门槛</span>
                                            <c:forEach begin="1" end="${subject[i].threshold}">
                                                <img src="/img/star.png" alt="star">
                                            </c:forEach>
                                        </td>
                                        <td>
                                            <span>难易程度</span>
                                            <c:forEach begin="1" end="${subject[i].diffcultyLevel}">
                                                <img src="/img/star.png" alt="star">
                                            </c:forEach>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td><span>成长周期</span><span class="color-red">${subject[i].growthCycle}</span><span>年</span></td>
                                        <td><span>稀缺程度</span><span class="color-red">${subject[i].rareness}</span><span>家公司需要</span></td>
                                    </tr>
                                    <tr>
                                        <td rowspan="3">薪资待遇</td>
                                        <td><span>0-1年</span><span class="fl-right">${subject[i].salaryFirst}</span></td>
                                    </tr>
                                    <tr>
                                        <td><span>1-3年</span><span class="fl-right">${subject[0].salarySecond}</span></td>
                                    </tr>
                                    <tr>
                                        <td><span>3-5年</span><span class="fl-right">${subject[i].salaryThird}</span></td>
                                    </tr>
                                    <tr><td colspan="2"><strong>有 <span class="color-red">${subject[i].number}</span>人正在学</strong></td></tr>
                                    <tr><td colspan="2">提示:在你学习之前你应该已经掌握${subject[i].information}等语言基础</td></tr>
                                    </tbody>
                                </table>
                            </section>
                            <div class="dev-hov">
                                <h4>iOS工程师</h4>
                                <p>
                                    iOS是由苹果公司开发的移动操作统，iOS与苹果的Mac OS X操作系统一样，也是以Darwin为基础的，因此同样属于类Unix的商业操作系统。
                                    国内iOS开发起步相对较晚，人才培养机制更是远远跟不上市场发展速度。有限的iOS开发人才成了国内企业必争的资源。
                                    国内iOS开发起步相对较晚，人才培养机制更是远远跟不上市场发展速度。有限的iOS开发人才成了国内企业必争的资源。
                                </p>
                            </div>
                        </section>
                    </div>
                </c:if>
            </c:forEach>
        </div>
        <h4 id="op"><strong>运营维护方向</strong></h4>
        <div class="row">
            <c:forEach var="i" begin="0" end="7" step="1">
                <c:if test="${subject[i].id==5}">
                    <div class="col-sm-6 col-md-4">
                        <section class="dev">
                            <section>
                                <header>
                                    <img src="/img/dev-icon.png" alt="dev-icon">
                                        <%--获取数据第一种形式--%>
                                    <h4><strong>${subject[i].name}</strong></h4>
                                        <%--第二种--%>
                                    <p>${subject.get(i).summary}</p>
                                </header>
                                <table class="table table-bordered">
                                    <tbody>
                                    <tr>
                                        <td>
                                            <span>门槛</span>
                                            <c:forEach begin="1" end="${subject[i].threshold}">
                                                <img src="/img/star.png" alt="star">
                                            </c:forEach>
                                        </td>
                                        <td>
                                            <span>难易程度</span>
                                            <c:forEach begin="1" end="${subject[i].diffcultyLevel}">
                                                <img src="/img/star.png" alt="star">
                                            </c:forEach>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td><span>成长周期</span><span class="color-red">${subject[i].growthCycle}</span><span>年</span></td>
                                        <td><span>稀缺程度</span><span class="color-red">${subject[i].rareness}</span><span>家公司需要</span></td>
                                    </tr>
                                    <tr>
                                        <td rowspan="3">薪资待遇</td>
                                        <td><span>0-1年</span><span class="fl-right">${subject[i].salaryFirst}</span></td>
                                    </tr>
                                    <tr>
                                        <td><span>1-3年</span><span class="fl-right">${subject[0].salarySecond}</span></td>
                                    </tr>
                                    <tr>
                                        <td><span>3-5年</span><span class="fl-right">${subject[i].salaryThird}</span></td>
                                    </tr>
                                    <tr><td colspan="2"><strong>有 <span class="color-red">${subject[i].number}</span>人正在学</strong></td></tr>
                                    <tr><td colspan="2">提示:在你学习之前你应该已经掌握${subject[i].information}等语言基础</td></tr>
                                    </tbody>
                                </table>
                            </section>
                            <div class="dev-hov">
                                <h4>iOS工程师</h4>
                                <p>
                                    iOS是由苹果公司开发的移动操作统，iOS与苹果的Mac OS X操作系统一样，也是以Darwin为基础的，因此同样属于类Unix的商业操作系统。
                                    国内iOS开发起步相对较晚，人才培养机制更是远远跟不上市场发展速度。有限的iOS开发人才成了国内企业必争的资源。
                                    国内iOS开发起步相对较晚，人才培养机制更是远远跟不上市场发展速度。有限的iOS开发人才成了国内企业必争的资源。
                                </p>
                            </div>
                        </section>
                    </div>
                </c:if>
            </c:forEach>
        </div>
    </div>
</main>
<!-- jQuery (Bootstrap 的 JavaScript 插件需要引入 jQuery) -->
<script src="js/jquery-1.12.4.min.js"></script>
<!-- 包括所有已编译的插件 -->
<script src="js/bootstrap.min.js"></script>
</body>
</html>
