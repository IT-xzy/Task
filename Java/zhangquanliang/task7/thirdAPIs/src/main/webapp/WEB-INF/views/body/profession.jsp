<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="title" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@ taglib uri="/tags" prefix="date"%>

<link rel="stylesheet" href="/static/css/css8.1.css">

<main>
    <div class="container">
        <div class="row occupation">
            <p>
                <a href="/home">首页</a>&gt;
                <span> 职业</span>
            </p>
        </div>

        <div class="row learning">
            <p>方向：</p>
            <span>全部</span>
            <span>前端开发</span>
            <span>后端开发</span>
            <span>移动开发</span>
            <span>整站开发</span>
            <span>运营维护</span>
        </div>

        <div class="row front-end-det-dir">
            <p>前端开发方向</p>
        </div>

        <div class="row">

            <c:forEach items="${pros}" var="profession">
            <c:if test="${profession.type == '前端' }">
            <div class=" col-xs-12 col-md-6 col-lg-4 now">
                <div class="wrapper">
                    <div class="box gird-one">
                        <img src="/static/img/${profession.img}" height="139" width="139"/>
                    </div>
                    <div class="box gird-two">
                        <p class="ios-box">${profession.name}</p>
                        <p>${profession.description}
                        </p>
                    </div>
                    <div class="box gird-three">
                        门槛&nbsp;&nbsp;&nbsp;
                        <c:forEach var="i" begin="1" end="${profession.difficulty}" step="1">
                            <img src="/static/img/xx8.png" height="15" width="16"/>
                        </c:forEach>
                    </div>
                    <div class="box gird-four">
                        难易程度&nbsp;&nbsp;&nbsp;&nbsp;
                        <c:forEach var="i" begin="1" end="${profession.threshold}" step="1">
                            <img src="/static/img/xx8.png" height="15" width="16"/>
                        </c:forEach>
                    </div>
                    <div class="box gird-five">
                        成长周期&nbsp;&nbsp;&nbsp;&nbsp;<span class="number-n">${profession.cycle}</span>
                    </div>
                    <div class="box gird-six">
                        稀缺程度&nbsp;&nbsp;&nbsp;&nbsp;<span class="number-n">${profession.company}</span><span class="time">家公司需要</span>
                    </div>
                    <div class="box gird-seven">
                    </div>
                    <div class="box gird-eight">
                        <p class="time"> 0-1年 <span class="digit">${profession.payOne}/月</span></p>
                    </div>
                    <div class="box gird-nine">
                        薪资待遇
                    </div>
                    <div class="box gird-ten">
                        <p class="time">1-3年 <span class="digit">${profession.payTwo}/月</span></p>
                    </div>
                    <div class="box gird-eleven">
                        <p class="time">3年以上<span  class="digit">${profession.payThree}/月</span></p>
                    </div>
                    <div class="box gird-twelve">
                    </div>
                    <div class="box gird-thirteen">
                        <p class="ios-box">有<span class="number-n">${profession.onlineCount}</span>人在学</p>
                    </div>
                    <div class="box gird-fourteen">
                        <p class="ios-box">创建时间：<date:date value ="${profession.createAt} "/>
                            更新时间：
                                <%--通过过jsp:userBean标签引入java.util.Date日期类:--%>
                            <jsp:useBean id="dateValue" class="java.util.Date"/>
                                <%--使用jsp:setProperty标签将时间戳设置到Date的time属性中--%>
                            <jsp:setProperty name="dateValue" property="time" value="${profession.updateAt}"/>
                                <%--使用fmt标签转换long格式为设置好的date格式--%>
                            <fmt:formatDate value="${dateValue}" pattern="yyyy-MM-dd HH:mm"/> </p>
                    </div>
                    <div class="box gird-fifteen">
                        提示:${profession.base}
                    </div>
                    <div class="engineer">
                        <p>${profession.name}</p>
                        <p>${profession.base}</p>
                    </div>

                </div>
            </div>
            </c:if>
            </c:forEach>
        </div>

        <div class="row front-end-det-dir">
            <p>后端开发方向</p>
        </div>

        <div class="row">

            <c:forEach items="${pros}" var="profession">
                <c:if test="${profession.type == '后端' }">
                    <div class=" col-xs-12 col-md-6 col-lg-4 now">
                        <div class="wrapper">
                            <div class="box gird-one">
                                <img src="/static/img/${profession.img}" height="139" width="139"/>
                            </div>
                            <div class="box gird-two">
                                <p class="ios-box">${profession.name}</p>
                                <p>${profession.description}
                                </p>
                            </div>
                            <div class="box gird-three">
                                门槛&nbsp;
                                <c:forEach var="i" begin="1" end="${profession.difficulty}" step="1">
                                    <img src="/static/img/xx8.png" height="15" width="16"/>
                                </c:forEach>
                            </div>
                            <div class="box gird-four">
                                难易程度&nbsp;
                                <c:forEach var="i" begin="1" end="${profession.threshold}" step="1">
                                    <img src="/static/img/xx8.png" height="15" width="16"/>
                                </c:forEach>
                            </div>
                            <div class="box gird-five">
                                成长周期&nbsp;&nbsp;&nbsp;&nbsp;<span class="number-n">${profession.cycle}</span>
                            </div>
                            <div class="box gird-six">
                                稀缺程度&nbsp;&nbsp;&nbsp;&nbsp;<span class="number-n">${profession.company}</span><span class="time">家公司需要</span>
                            </div>
                            <div class="box gird-seven">
                            </div>
                            <div class="box gird-eight">
                                <p class="time"> 0-1年 <span class="digit">${profession.payOne}/月</span></p>
                            </div>
                            <div class="box gird-nine">
                                薪资待遇
                            </div>
                            <div class="box gird-ten">
                                <p class="time">1-3年 <span class="digit">${profession.payTwo}/月</span></p>
                            </div>
                            <div class="box gird-eleven">
                                <p class="time">3年以上<span  class="digit">${profession.payThree}/月</span></p>
                            </div>
                            <div class="box gird-twelve">
                            </div>
                            <div class="box gird-thirteen">
                                <p class="ios-box">有<span class="number-n">${profession.onlineCount}</span>人在学</p>
                            </div>
                            <div class="box gird-fourteen">
                                <p class="ios-box">创建时间：<date:date value ="${profession.createAt} "/>
                                    更新时间：<date:date value ="${profession.updateAt} "/></p>
                            </div>
                            <div class="box gird-fifteen">
                                提示:${profession.base}
                            </div>

                            <div class="engineer">
                                <p>${profession.name}</p>
                                <p>${profession.base}</p>
                            </div>
                        </div>
                    </div>
                </c:if>
            </c:forEach>
        </div>

        <div class="row front-end-det-dir">
            <p>运维方向</p>
        </div>

        <div class="row">

            <c:forEach items="${pros}" var="profession">
                <c:if test="${profession.type == '运维' }">
                    <div class=" col-xs-12 col-md-6 col-lg-4 now">
                        <div class="wrapper">
                            <div class="box gird-one">
                                <img src="/static/img/${profession.img}" height="139" width="139"/>
                            </div>
                            <div class="box gird-two">
                                <p class="ios-box">${profession.name}</p>
                                <p>${profession.description}
                                </p>
                            </div>
                            <div class="box gird-three">
                                门槛&nbsp;&nbsp;&nbsp;&nbsp;
                                <c:forEach var="i" begin="1" end="${profession.difficulty}" step="1">
                                    <img src="/static/img/xx8.png" height="15" width="16"/>
                                </c:forEach>
                            </div>
                            <div class="box gird-four">
                                难易程度&nbsp;&nbsp;&nbsp;&nbsp;
                                <c:forEach var="i" begin="1" end="${profession.threshold}" step="1">
                                    <img src="/static/img/xx8.png" height="15" width="16"/>
                                </c:forEach>
                            </div>
                            <div class="box gird-five">
                                成长周期&nbsp;&nbsp;&nbsp;&nbsp;<span class="number-n">${profession.cycle}</span>
                            </div>
                            <div class="box gird-six">
                                稀缺程度&nbsp;&nbsp;&nbsp;&nbsp;<span class="number-n">${profession.company}</span><span class="time">家公司需要</span>
                            </div>
                            <div class="box gird-seven">
                            </div>
                            <div class="box gird-eight">
                                <p class="time"> 0-1年 <span class="digit">${profession.payOne}/月</span></p>
                            </div>
                            <div class="box gird-nine">
                                薪资待遇
                            </div>
                            <div class="box gird-ten">
                                <p class="time">1-3年 <span class="digit">${profession.payTwo}/月</span></p>
                            </div>
                            <div class="box gird-eleven">
                                <p class="time">3年以上<span  class="digit">${profession.payThree}/月</span></p>
                            </div>
                            <div class="box gird-twelve">
                            </div>
                            <div class="box gird-thirteen">
                                <p class="ios-box">有<span class="number-n">${profession.onlineCount}</span>人在学</p>
                            </div>
                            <div class="box gird-fourteen">
                                <p class="ios-box">创建时间：<date:date value ="${profession.createAt} "/>
                                更新时间：<date:date value ="${profession.updateAt} "/></p>
                            </div>
                            <div class="box gird-fifteen">
                                提示:${profession.base}
                            </div>
                            <div class="engineer">
                                <p>${profession.name}</p>
                                <p>${profession.base}</p>
                            </div>
                        </div>
                    </div>
                </c:if>
            </c:forEach>

        </div>

        <div class="row front-end-det-dir">
            <p>运营方向</p>
        </div>

        <div class="row">

            <c:forEach items="${pros}" var="profession">
                <c:if test="${profession.type == '运营' }">
                    <div class=" col-xs-12 col-md-6 col-lg-4 now">
                        <div class="wrapper">
                            <div class="box gird-one">
                                <img src="/static/img/${profession.img}" height="139" width="139"/>
                            </div>
                            <div class="box gird-two">
                                <p class="ios-box">${profession.name}</p>
                                <p>${profession.description}
                                </p>
                            </div>
                            <div class="box gird-three">
                                门槛&nbsp;&nbsp;&nbsp;&nbsp;
                                <c:forEach var="i" begin="1" end="${profession.difficulty}" step="1">
                                    <img src="/static/img/xx8.png" height="15" width="16"/>
                                </c:forEach>
                            </div>
                            <div class="box gird-four">
                                难易程度&nbsp;&nbsp;&nbsp;&nbsp;
                                <c:forEach var="i" begin="1" end="${profession.threshold}" step="1">
                                    <img src="/static/img/xx8.png" height="15" width="16"/>
                                </c:forEach>
                            </div>
                            <div class="box gird-five">
                                成长周期&nbsp;&nbsp;&nbsp;&nbsp;<span class="number-n">${profession.cycle}</span>
                            </div>
                            <div class="box gird-six">
                                稀缺程度&nbsp;&nbsp;&nbsp;&nbsp;<span class="number-n">${profession.company}</span><span class="time">家公司需要</span>
                            </div>
                            <div class="box gird-seven">
                            </div>
                            <div class="box gird-eight">
                                <p class="time"> 0-1年 <span class="digit">${profession.payOne}/月</span></p>
                            </div>
                            <div class="box gird-nine">
                                薪资待遇
                            </div>
                            <div class="box gird-ten">
                                <p class="time">1-3年 <span class="digit">${profession.payTwo}/月</span></p>
                            </div>
                            <div class="box gird-eleven">
                                <p class="time">3年以上<span  class="digit">${profession.payThree}/月</span></p>
                            </div>
                            <div class="box gird-twelve">
                            </div>
                            <div class="box gird-thirteen">
                                <p class="ios-box">有<span class="number-n">${profession.onlineCount}</span>人在学</p>
                            </div>
                            <div class="box gird-fourteen">
                                <p class="ios-box">创建时间：<date:date value ="${profession.createAt} "/>
                                更新时间：<date:date value ="${profession.updateAt} "/></p>
                            </div>
                            <div class="box gird-fifteen">
                                提示:${profession.base}
                            </div>

                            <div class="engineer">
                                <p>${profession.name}</p>
                                <p>${profession.base}</p>
                            </div>

                        </div>
                    </div>
                </c:if>
            </c:forEach>

        </div>


    </div>
</main>