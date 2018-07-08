<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<html>
<head>
    <link rel="stylesheet" href="/task8/css/profession.css">
    <title>运营维护</title>
</head>
<body>
<div class="occupation">
    <div class="container">
        <a href="${pageContext.request.contextPath}/it/logout">退出登录</a>
        <div class="row"><span class="bg-color-black">
            <a href="${pageContext.request.contextPath}/it/home">首页</a>职业&gt;</span></div>
        <div class="row">
            <span class="bg-color-gray">方向:
                <a href="${pageContext.request.contextPath}/it/profession" style="margin-left:15px">全部</a>
                <a href="${pageContext.request.contextPath}/it/profession/fe">前端开发</a>
                <a href="${pageContext.request.contextPath}/it/profession/be">后端开发</a>
                <a href="${pageContext.request.contextPath}/it/profession/mobile">移动开发</a>
                <a href="${pageContext.request.contextPath}/it/profession/fs">整站开发</a>
                &nbsp;运营维护&nbsp;&nbsp;</span>
        </div>
    </div>
</div>
<main>
    <div class="container">
        <div class="row nav-strong">
            <strong>运维方向</strong>
            <c:forEach items="${professions_op}" var="item">
                <div class="col-xs-12 col-sm-6 col-md-4">
                    <div class="warp">
                        <table border="1" class="text">
                            <tr>
                                <th>
                                    <img src="/task8/images/img022.png" alt=""
                                         class="avast">
                                </th>
                                <td>
                                    <strong>${item.profession}</strong>
                                    <p>${item.description}</p>
                                </td>
                            </tr>
                            <tr>
                                <c:if test="${!empty item.entryBarrier && item.entryBarrier > 0}">
                                    <c:if test="${item.entryBarrier == 1}">
                                        <td>门槛<img src="/task8/images/star.png" alt=""></td>
                                    </c:if>
                                    <c:if test="${item.entryBarrier == 2}">
                                        <td>门槛<img src="/task8/images/star.png" alt="">
                                            <img src="/task8/images/star.png" alt=""></td>
                                    </c:if>
                                    <c:if test="${item.entryBarrier == 3}">
                                        <td>门槛<img src="/task8/images/star.png" alt="">
                                            <img src="/task8/images/star.png" alt="">
                                            <img src="/task8/images/star.png" alt=""></td>
                                    </c:if>
                                    <c:if test="${item.entryBarrier == 4}">
                                        <td>门槛<img src="/task8/images/star.png" alt="">
                                            <img src="/task8/images/star.png" alt="">
                                            <img src="/task8/images/star.png" alt="">
                                            <img src="/task8/images/star.png" alt=""></td>
                                    </c:if>
                                    <c:if test="${item.entryBarrier > 4}">
                                        <td>门槛<img src="/task8/images/star.png" alt="">
                                            <img src="/task8/images/star.png" alt="">
                                            <img src="/task8/images/star.png" alt="">
                                            <img src="/task8/images/star.png" alt="">
                                            <img src="/task8/images/star.png" alt=""></td>
                                    </c:if>
                                </c:if>
                                <c:if test="${!empty item.difficulty && item.difficulty > 0}">
                                    <c:if test="${item.difficulty == 1}">
                                        <td>难易程度<img src="/task8/images/star.png" alt="">
                                        </td>
                                    </c:if>
                                    <c:if test="${item.difficulty == 2}">
                                        <td>难易程度<img src="/task8/images/star.png" alt="">
                                            <img src="/task8/images/star.png" alt=""></td>
                                    </c:if>
                                    <c:if test="${item.difficulty == 3}">
                                        <td>难易程度<img src="/task8/images/star.png" alt="">
                                            <img src="/task8/images/star.png" alt="">
                                            <img src="/task8/images/star.png" alt=""></td>
                                    </c:if>
                                    <c:if test="${item.difficulty == 4}">
                                        <td>难易程度<img src="/task8/images/star.png" alt="">
                                            <img src="/task8/images/star.png" alt="">
                                            <img src="/task8/images/star.png" alt="">
                                            <img src="/task8/images/star.png" alt=""></td>
                                    </c:if>
                                    <c:if test="${item.difficulty > 4}">
                                        <td>难易程度<img src="/task8/images/star.png" alt="">
                                            <img src="/task8/images/star.png" alt="">
                                            <img src="/task8/images/star.png" alt="">
                                            <img src="/task8/images/star.png" alt="">
                                            <img src="/task8/images/star.png" alt=""></td>
                                    </c:if>
                                </c:if>

                            </tr>
                            <tr>
                                <td>成长周期 <em>${item.growthCycle}</em>年</td>
                                <td>稀缺程度 <em>${item.companies}</em>家公司需要</td>
                            </tr>
                            <tr>
                                <td>薪资待遇</td>
                                <td>
                                    <c:if test="${item.salaryZero!=null}">
                                        <div>0-1年<span>${item.salaryZero}k/月</span></div>
                                    </c:if>
                                    <c:if test="${item.salaryOne!=null}">
                                        <div>1-3年<span>${item.salaryOne}k/月</span></div>
                                    </c:if>
                                    <c:if test="${item.salaryThree!=null}">
                                        <div>3-5年<span>${item.salaryThree}k/月</span></div>
                                    </c:if>
                                </td>
                            </tr>
                            <tr>
                                <td colspan="2">有<em>${item.count}</em>人正在学</td>
                            </tr>
                            <tr>
                                <td colspan="2">提示:${item.attention}</td>
                            </tr>
                        </table>
                        <div class="zezhao"><strong>${item.profession}</strong>${item.introduction}</div>
                    </div>
                </div>
            </c:forEach>
        </div> <!-- main-row -->
    </div> <!-- container -->
</main>
</body>
</html>
