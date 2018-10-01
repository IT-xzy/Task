<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="title" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="date" uri="/tags" %>
<link rel="stylesheet" href="${pageContext.request.contextPath}/stat/sass/task14-2.css"/>
<main>
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <div class="place">
                    <span>
                        <a href="/home" class="home">首页</a>
                        >
                        <a href="#" class="occupation">职业</a>
                    </span>
                </div>
            </div>
        </div>
    </div>
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <div class="classify">
                    <div class="remind">
                        方向:
                    </div>
                    <div class="category">
                        <a href="#" class="all">全部</a>
                        <a href="#" class="job">前端开发</a>
                        <a href="#" class="job">后端开发</a>
                        <a href="#" class="job">移动开发</a>
                        <a href="#" class="job">整站开发</a>
                        <a href="#" class="job">运营维护</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <div class="job-sort">
                    前端开发方向
                </div>
            </div>
        </div>
    </div>
    <div class="container">
        <div class="row">
            <c:forEach items="${pros}" var="profession">
                <c:if test="${profession.direction == '前端' }">
                    <div class="col-md-4 col-sm-6">
                        <div class="animation">
                            <p class="profession">${profession.proName}</p>
                            <p class="duty">${profession.proPresentation}</p>
                        </div>
                        <div class="personage">
                            <div class="intro">
                                <img src="${pageContext.request.contextPath}/stat/images/${profession.proPhoto}" class="portrait">
                                <div class="obligation">
                                    <p class="position">${profession.proName}</p>
                                    <p>${profession.proPresentation}</p>

                                </div>
                            </div>
                            <div class="job-view">
                                <div class="sill">
                                    门槛
                                    <c:forEach var="i" begin="1" end="${profession.difficulty}" step="1">
                                        <img src="${pageContext.request.contextPath}/stat/images/23-task8.png" class="rank">
                                    </c:forEach>
                                </div>
                                <div class="difficulty">
                                    难易程度
                                    <c:forEach var="i" begin="1" end="${profession.level}" step="1">
                                        <img src="${pageContext.request.contextPath}/stat/images/23-task8.png" class="rank">
                                    </c:forEach>
                                </div>
                            </div>
                            <div class="job-view">
                                <div class="sill">
                                    成长周期
                                    <p class="cycle">${profession.cycle}</p>

                                </div>
                                <div class="difficulty">
                                    稀缺程度
                                    <p class="cycle">${profession.scarcity}</p>
                                    家公司需要
                                </div>
                            </div>
                            <div class="job-view">
                                <div class="wage">
                                    薪资待遇
                                </div>
                                <div class="salary">
                                    <c:forEach var="i" begin="1" end="3" step="1">
                                        <div class="compensation">
                                            <p class="pay">${i}-${i+1}年</p>
                                            <p class="pay">${profession.emolument_min * (i+1)}k-${profession.emolument_max * (i+1)}k/月</p>
                                        </div>
                                    </c:forEach>
                                </div>
                            </div>
                            <div class="online">
                                有
                                <p class="pupil">286</p>
                                人正在学
                            </div>
                            <p class="end">${profession.remind}</p>
                            <p>修改时间:<date:date value ="${profession.update_at} "/></p>
                            <p>
                                修改时间fmt:
                                <%--通过过jsp:userBean标签引入java.util.Date日期类:--%>
                                <jsp:useBean id="dateValue" class="java.util.Date"/>
                                <%--使用jsp:setProperty标签将时间戳设置到Date的time属性中--%>
                                <jsp:setProperty name="dateValue" property="time" value="${profession.update_at}"/>
                                <%--使用fmt标签转换long格式为设置好的date格式--%>
                                <fmt:formatDate value="${dateValue}" pattern="yyyy-MM-dd HH:mm:ss"/>
                            </p>
                        </div>
                    </div>
                </c:if>
            </c:forEach>
        </div>
    </div>
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <div class="work-sort">
                    后端开发方向
                </div>
            </div>
        </div>
    </div>
    <div class="container">
        <div class="row">
            <c:forEach items="${pros}" var="profession">
                <c:if test="${profession.direction == '后端' }">
            <div class="col-md-4 col-sm-6">
                <div class="animation">
                    <p class="profession">${profession.proName}</p>
                    <p class="duty">${profession.proPresentation}</p>
                </div>
                <div class="personage">
                    <div class="intro">
                        <img src="${pageContext.request.contextPath}/stat/images/${profession.proPhoto}" class="portrait">
                        <div class="obligation">
                            <p class="position">${profession.proName}</p>
                            <p>${profession.proPresentation}</p>
                        </div>
                    </div>
                    <div class="job-view">
                        <div class="sill">
                            门槛
                            <c:forEach var="i" begin="1" end="${profession.difficulty}" step="1">
                            <img src="${pageContext.request.contextPath}/stat/images/23-task8.png" class="rank">
                            </c:forEach>
                        </div>
                        <div class="difficulty">
                            难易程度
                            <c:forEach var="i" begin="1" end="${profession.level}" step="1">
                            <img src="${pageContext.request.contextPath}/stat/images/23-task8.png" class="rank">
                            </c:forEach>
                        </div>
                    </div>
                    <div class="job-view">
                        <div class="sill">
                            成长周期
                            <p class="cycle">${profession.cycle}</p>
                            年
                        </div>
                        <div class="difficulty">
                            稀缺程度
                            <p class="cycle">${profession.scarcity}</p>
                            家公司需要
                        </div>
                    </div>
                    <div class="job-view">
                        <div class="wage">
                            薪资待遇
                        </div>
                        <div class="salary">
                            <c:forEach var="i" begin="1" end="3" step="1">
                            <div class="compensation">
                                <p class="pay">${i}-${i+1}年</p>
                                <p class="pay">${profession.emolument_min * i}k-${profession.emolument_max * i}k/月</p>
                            </div>
                            </c:forEach>
                            <%--<div class="compensation">--%>
                                <%--<p class="pay">1-3年</p>--%>
                                <%--<p class="pay">10k-20k/月</p>--%>
                            <%--</div>--%>
                            <%--<div class="years">--%>
                                <%--<p class="pay">0-1年</p>--%>
                                <%--<p class="pay">20k-50k/月</p>--%>
                            <%--</div>--%>
                        </div>
                    </div>
                    <div class="online">
                        有
                        <p class="pupil">286</p>
                        人正在学
                    </div>
                    <p class="end">${profession.remind}</p>
                    <p>修改时间:<date:date value ="${profession.update_at} "/></p>
                    <p>
                        修改时间fmt:

                            <%--通过过jsp:userBean标签引入java.util.Date日期类:--%>
                        <jsp:useBean id="dateValue2" class="java.util.Date"/>
                            <%--使用jsp:setProperty标签将时间戳设置到Date的time属性中--%>
                        <jsp:setProperty name="dateValue2" property="time" value="${profession.update_at}"/>
                            <%--使用fmt标签转换long格式为设置好的date格式--%>
                        <fmt:formatDate value="${dateValue2}" pattern="yyyy-MM-dd HH:mm:ss"/>
                    </p>
                </div>
            </div>
                </c:if>
            </c:forEach>
        </div>
    </div>
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <div class="work-sort">
                    运维方向
                </div>
            </div>
        </div>
    </div>
    <div class="container">
        <div class="row">
            <c:forEach items="${pros}" var="profession">
                <c:if test="${profession.direction == '运维' }">
                    <div class="col-md-4 col-sm-6">
                        <div class="animation">
                            <p class="profession">${profession.proName}</p>
                            <p class="duty">${profession.proPresentation}</p>
                        </div>
                        <div class="personage">
                            <div class="intro">
                                <img src="${pageContext.request.contextPath}/stat/images/${profession.proPhoto}" class="portrait">
                                <div class="obligation">
                                    <p class="position">${profession.proName}</p>
                                    <p>${profession.proPresentation}</p>
                                </div>
                            </div>
                            <div class="job-view">
                                <div class="sill">
                                    门槛
                                    <c:forEach var="i" begin="1" end="${profession.difficulty}" step="1">
                                        <img src="${pageContext.request.contextPath}/stat/images/23-task8.png" class="rank">
                                    </c:forEach>
                                </div>
                                <div class="difficulty">
                                    难易程度
                                    <c:forEach var="i" begin="1" end="${profession.level}" step="1">
                                        <img src="${pageContext.request.contextPath}/stat/images/23-task8.png" class="rank">
                                    </c:forEach>
                                </div>
                            </div>
                            <div class="job-view">
                                <div class="sill">
                                    成长周期
                                    <p class="cycle">${profession.cycle}</p>
                                    年
                                </div>
                                <div class="difficulty">
                                    稀缺程度
                                    <p class="cycle">${profession.scarcity}</p>
                                    家公司需要
                                </div>
                            </div>
                            <div class="job-view">
                                <div class="wage">
                                    薪资待遇
                                </div>
                                <div class="salary">
                                    <c:forEach var="i" begin="1" end="3" step="1">
                                        <div class="compensation">
                                            <p class="pay">${i}-${i+1}年</p>
                                            <p class="pay">${profession.emolument_min * i}k-${profession.emolument_max * i}k/月</p>
                                        </div>
                                    </c:forEach>
                                        <%--<div class="compensation">--%>
                                        <%--<p class="pay">1-3年</p>--%>
                                        <%--<p class="pay">10k-20k/月</p>--%>
                                        <%--</div>--%>
                                        <%--<div class="years">--%>
                                        <%--<p class="pay">0-1年</p>--%>
                                        <%--<p class="pay">20k-50k/月</p>--%>
                                        <%--</div>--%>
                                </div>
                            </div>
                            <div class="online">
                                有
                                <p class="pupil">286</p>
                                人正在学
                            </div>
                            <p class="end">${profession.remind}</p>
                            <p>修改时间:<date:date value ="${profession.update_at} "/></p>
                            <p>
                                修改时间fmt:
                                    <%--通过过jsp:userBean标签引入java.util.Date日期类:--%>
                                <jsp:useBean id="dateValue3" class="java.util.Date"/>
                                    <%--使用jsp:setProperty标签将时间戳设置到Date的time属性中--%>
                                <jsp:setProperty name="dateValue3" property="time" value="${profession.update_at}"/>
                                    <%--使用fmt标签转换long格式为设置好的date格式--%>
                                <fmt:formatDate value="${dateValue3}" pattern="yyyy-MM-dd HH:mm:ss"/>
                            </p>
                        </div>
                    </div>
                </c:if>
            </c:forEach>
        </div>
    </div>

</main>

