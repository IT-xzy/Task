<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles-extras" prefix="tilesx" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>

<head>

    <meta charset="utf-8">
    <title>无标题文档</title>
    <meta content="width=device-width, initial-scale=1.0" name="viewport" charset="UTF-8">
    <link rel="stylesheet" href="http://apps.bdimg.com/libs/bootstrap/3.3.4/css/bootstrap.min.css">
    <script src="http://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
    <script src="http://apps.bdimg.com/libs/bootstrap/3.3.4/js/bootstrap.min.js"></script>
    <link href="t11/t11.css" rel="stylesheet" type="text/css">
    <link href="t10/Untitled-1base.css" rel="stylesheet" type="text/css">

</head>

<div class="container">

    <div class="nav-title">首页&gt;职业</div>
    <div class="nav-bar">
        <span class="">方向：</span>
        <a class="nav-bar-a a-selected black" href="">全部</a>
        <a class="nav-bar-a black" href="">前端开发</a>
        <a class="nav-bar-a black" href="">后端开发</a>
        <a class="nav-bar-a black" href="">移动开发</a>
        <a class="nav-bar-a black" href="">整站开发</a>
        <a class="nav-bar-a black" href="">运营维护</a>
    </div>


    <div class="caption">
        <h4>前端开发方向</h4>
    </div>


    <c:forEach items="${professions}" var="p" varStatus="id">

        <%--${p.updateTime}--%>
        <%--<div>--%>
            <%--<c:out value="${p.updateTime}" ></c:out>--%>
            <%--<jsp:useBean id="dateValue" class="java.util.Date"/> <!-- 通过jsp:userBean标签引入java.util.Date日期类 -->--%>
            <%--<jsp:setProperty name="dateValue" property="time" value="${p.updateTime}"/> <!-- 使用jsp:setProperty标签将时间戳设置到Date的time属性中 -->--%>
            <%--<fmt:formatDate value="${dateValue}" pattern="yyyy-MM-dd HH:mm:ss"/> <!-- 转换格式 -->--%>
        <%--</div>--%>

        <%--分割字符串--%>
<c:set var="sss" value="${p.salary}"></c:set>
        <c:set var="sss1" value="${fn:split(sss, ',')}"></c:set>



        <div class="col-md-4 col-sm-6 col-xs-12 top-margin">

            <div class="warp-border">
                <div class="clearfix">
                    <div class="icon-people"><img src="${p.img}"></div>
                    <div class="text">
                        <h4 class="">${p.professionName}</h4>
                        <p class="text-present">${p.professionDescription}</p>
                    </div>
                </div>

                <div class="warp-class2">
                    <div class="warp-class2-text">
                        <div class="iconfont text-padding">门槛  <c:forEach   begin="1" end="${p.threshold}" ><img src="t11/imges/xx.png"></c:forEach></div>
                    </div>
                    <div class="warp-class2-text">
                        <div class="iconfont text-padding text-border-left">难易程度  <c:forEach begin="1" end="${p.difficultyLevel}" ><img src="t11/imges/xx.png"></c:forEach></div>
                    </div>
                </div>
                <div class="warp-class2">
                    <div class="warp-class2-text">
                        <div class="iconfont text-padding">成长周期 <span class="iconfont-color">${p.growthCycle}</span>年</div>
                    </div>
                    <div class="warp-class2-text">
                        <div class="iconfont text-padding text-border-left">稀缺程度 <span class="iconfont-color">${p.need}</span>家公司需要</div>
                    </div>
                </div>

                <div class="warp-class2">
                    <div class="leftWarp">
                        薪资待遇
                    </div>
                    <div class="rightWarp">
                        <div class="rightWarp-class">
                            <div class="rightWarp-year">0-5年</div>
                            <div class="rightWarp-wages"><c:forEach items="${sss1}" var="s" begin="0" end="0">${ s } <br /></c:forEach></div>

                        </div>
                        <div class="rightWarp-class">
                            <div class="rightWarp-year">5-10年</div>
                            <div class="rightWarp-wages"><c:forEach items="${sss1}" var="s" begin="1" end="1">${ s } <br /></c:forEach></div>
                        </div>
                        <div class="rightWarp-class border-bottom">
                            <div class="rightWarp-year">10-15年</div>
                            <div class="rightWarp-wages"><c:forEach items="${sss1}" var="s" begin="2" end="2">${ s } <br /></c:forEach></div>
                        </div>
                    </div>
                </div>

                <div class="warp-class2">
                    <b class="text-b">有${p.learning}人正在学</b>
                </div>
                <div class="warp-class2">
                    <p class="text-p">${p.hint}</p>
                </div>

                <div class="flip-container">
                    <p class="flip-title">${p.professionName}</p>
                    <p class="flip-text">${p.professionDetail}</p>
                </div>
            </div>

        </div>

    </c:forEach>

</div>

</div>