<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<html>
<head>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/profession.css">
    <title>Title</title>
</head>
<body>
<div class="occupation">
    <div class="container">
        <div class="row"><span class="bg-color-black">
            <a href="${pageContext.request.contextPath}/jnshu/main">首页</a>职业&gt;</span></div>
        <div class="direction">
            <span style="color: #999;font-size: 1.4rem;">方向：
            <a>全部</a>
            <a href="#front-end">前端开发</a>
            <a href="#back-end">后端开发</a>
            <a href="#move-end">移动开发</a>
            <a href="#operate">运营维护</a>
            <a href="#all-end">整站开发</a></span>
        </div>
    </div>
</div>


<main>
    <div class="container">
        <div class="row nav-strong">
            <div class="sub-title" id="front-end">前端开发方向</div>
            <c:if test="${!empty 前端}">
            <c:forEach items="${前端}" var="a">
            <div class="col-xs-12 col-sm-6 col-md-4">
                <div class="warp">
                    <table border="1" class="text">
                        <tr>
                            <th><img src="${pageContext.request.contextPath}/images/img022.png" alt="" class="avast">
                            </th>

                            <td>
                                <strong>${a.vpt}</strong>
                                <p>${a.obligation}</p>
                            </td>
                        </tr>
                        <tr>
                            <td>${a.sill}<img src="${pageContext.request.contextPath}/images/star.png" alt=""></td>
                            <td>${a.complexity}<img src="${pageContext.request.contextPath}/images/star.png" alt=""><img
                                    src="${pageContext.request.contextPath}/images/star.png" alt=""></td>
                        </tr>
                        <tr>
                            <td>${a.growth} </td>
                            <td>${a.rareness}家公司需要</td>
                        </tr>
                        <tr>
                            <td>${a.monney}/月</td>
                        </tr>
                        <tr>
                            <td colspan="2">有${a.online}人正在学</td>
                        </tr>
                        <tr>
                            <td colspan="2">提示:${a.tip}</td>
                        </tr>

                    </table>
                    <div class="zezhao"><strong>${a.vpt}</strong>
                            ${a.obligation}
                    </div>
                </div>
                </c:forEach>
                </c:if>
            </div>
        </div> <!-- main-row -->
    </div> <!-- container -->


    <div class="container">
        <div class="row nav-strong">
            <div class="sub-title" id="back-end">后端开发方向</div>
            <c:if test="${!empty 后端}"></c:if>
            <c:forEach items="${后端}" var="a">
            <div class="col-xs-12 col-sm-6 col-md-4">
                <div class="warp">
                    <table border="1" class="text">
                        <tr>
                            <th><img src="${pageContext.request.contextPath}/images/img022.png" alt="" class="avast">
                            </th>

                            <td>
                                <strong>${a.vpt}</strong>
                                <p>${a.obligation}</p>
                            </td>
                        </tr>
                        <tr>
                            <td>${a.sill}<img src="${pageContext.request.contextPath}/images/star.png" alt=""></td>
                            <td>${a.complexity}<img src="${pageContext.request.contextPath}/images/star.png" alt=""><img
                                    src="${pageContext.request.contextPath}/images/star.png" alt=""></td>
                        </tr>
                        <tr>
                            <td>${a.growth} </td>
                            <td>${a.rareness}家公司需要</td>
                        </tr>
                        <tr>
                            <td>${a.monney}/月</td>
                        </tr>
                        <tr>
                            <td colspan="2">有${a.online}人正在学</td>
                        </tr>
                        <tr>
                            <td colspan="2">${a.tip}</td>
                        </tr>

                    </table>
                    <div class="zezhao"><strong>${a.vpt}</strong>
                            ${a.obligation}
                    </div>
                </div>
                </c:forEach>
            </div>
        </div> <!-- main-row -->
    </div> <!-- container -->

    <div class="container">
        <div class="row nav-strong">
            <div class="sub-title" id="move-end">移动端开发方向</div>
            <c:if test="${!empty 移动端}"></c:if>
            <c:forEach items="${移动端}" var="a">
            <div class="col-xs-12 col-sm-6 col-md-4">
                <div class="warp">
                    <table border="1" class="text">
                        <tr>
                            <th><img src="${pageContext.request.contextPath}/images/img022.png" alt="" class="avast">
                            </th>

                            <td>
                                <strong>${a.vpt}</strong>
                                <p>${a.obligation}</p>
                            </td>
                        </tr>
                        <tr>
                            <td>${a.sill}<img src="${pageContext.request.contextPath}/images/star.png" alt=""></td>
                            <td>${a.complexity}<img src="${pageContext.request.contextPath}/images/star.png" alt=""><img
                                    src="${pageContext.request.contextPath}/images/star.png" alt=""></td>
                        </tr>
                        <tr>
                            <td>${a.growth} </td>
                            <td>${a.rareness}家公司需要</td>
                        </tr>
                        <tr>
                            <td>${a.monney}/月</td>
                        </tr>
                        <tr>
                            <td colspan="2">有${a.online}人正在学</td>
                        </tr>
                        <tr>
                            <td colspan="2">${a.tip}</td>
                        </tr>

                    </table>
                    <div class="zezhao"><strong>${a.vpt}</strong>
                            ${a.obligation}
                    </div>
                </div>
                </c:forEach>
            </div>
        </div> <!-- main-row -->
    </div> <!-- container -->

    <div class="container">
        <div class="row nav-strong">
            <div class="sub-title" id="operate">运维开发方向</div>
            <c:if test="${!empty 运维}"></c:if>
            <c:forEach items="${运维}" var="a">
            <div class="col-xs-12 col-sm-6 col-md-4">
                <div class="warp">
                    <table border="1" class="text">
                        <tr>
                            <th><img src="${pageContext.request.contextPath}/images/img022.png" alt="" class="avast">
                            </th>

                            <td>
                                <strong>${a.vpt}</strong>
                                <p>${a.obligation}</p>
                            </td>
                        </tr>
                        <tr>
                            <td>${a.sill}<img src="${pageContext.request.contextPath}/images/star.png" alt=""></td>
                            <td>${a.complexity}<img src="${pageContext.request.contextPath}/images/star.png" alt=""><img
                                    src="${pageContext.request.contextPath}/images/star.png" alt=""></td>
                        </tr>
                        <tr>
                            <td>${a.growth} </td>
                            <td>${a.rareness}家公司需要</td>
                        </tr>
                        <tr>
                            <td>${a.monney}/月</td>
                        </tr>
                        <tr>
                            <td colspan="2">有${a.online}人正在学</td>
                        </tr>
                        <tr>
                            <td colspan="2">${a.tip}</td>
                        </tr>

                    </table>
                    <div class="zezhao"><strong>${a.vpt}</strong>
                            ${a.obligation}
                    </div>
                </div>
                </c:forEach>
            </div>
        </div> <!-- main-row -->
    </div> <!-- container -->

    <div class="container">
        <div class="row nav-strong">
            <div class="sub-title" id="all-end">全站开发方向</div>
            <c:if test="${!empty 全站}"></c:if>
            <c:forEach items="${全站}" var="a">
            <div class="col-xs-12 col-sm-6 col-md-4">
                <div class="warp">
                    <table border="1" class="text">
                        <tr>
                            <th><img src="${pageContext.request.contextPath}/images/img022.png" alt="" class="avast">
                            </th>

                            <td>
                                <strong>${a.vpt}</strong>
                                <p>${a.obligation}</p>
                            </td>
                        </tr>
                        <tr>
                            <td>${a.sill}<img src="${pageContext.request.contextPath}/images/star.png" alt=""></td>
                            <td>${a.complexity}<img src="${pageContext.request.contextPath}/images/star.png" alt=""><img
                                    src="${pageContext.request.contextPath}/images/star.png" alt=""></td>
                        </tr>
                        <tr>
                            <td>${a.growth} </td>
                            <td>${a.rareness}家公司需要</td>
                        </tr>
                        <tr>
                            <td>${a.monney}/月</td>
                        </tr>
                        <tr>
                            <td colspan="2">有${a.online}人正在学</td>
                        </tr>
                        <tr>
                            <td colspan="2">${a.tip}</td>
                        </tr>

                    </table>
                    <div class="zezhao"><strong>${a.vpt}</strong>
                            ${a.obligation}
                    </div>
                </div>
                </c:forEach>
            </div>
        </div> <!-- main-row -->
    </div> <!-- container -->


</main>
</body>
</html>
