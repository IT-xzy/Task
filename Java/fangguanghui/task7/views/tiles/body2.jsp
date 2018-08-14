<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="date" uri="/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<div class="container">
    <div class="nav-title">首页&gt;职业</div>
    <div class="nav-bar">
        <span class="">方向：</span>
        <a class="nav-bar-a a-selected" href="">全部</a>
        <a class="nav-bar-a" href="">前端开发</a>
        <a class="nav-bar-a" href="">后端开发</a>
        <a class="nav-bar-a" href="">移动开发</a>
        <a class="nav-bar-a" href="">整站开发</a>
        <a class="nav-bar-a" href="">运营维护</a>
    </div>



<%----%>
   <div class="caption">
        <h4>前端开发方向</h4>
    </div>

    <div class="row">
        <c:forEach items="${pro}" var="pro">
        <div class="col-md-4 col-sm-6 col-xs-12 top-margin">
            <div class="warp-border">
                <div class="clearfix">
                    <div class="icon-people"><img src="${pageContext.request.contextPath}/static/imges/687.png"></div>
                    <div class="text">
                        <h4 class="">${pro.proName}</h4>
                        <p class="text-present">${pro.introduce}</p>
                    </div>
                </div>

                <div class="warp-class2">
                    <div class="warp-class2-text">
                        <div class="iconfont text-padding">门槛
                        <c:forEach begin="1" end="${pro.sill}" >
                            <img src="${pageContext.request.contextPath}/static/imges/xx.png">
                            </c:forEach>
                        </div>

                    </div>
                    <div class="warp-class2-text">
                        <div class="iconfont text-padding text-border-left">难易程度
                            <c:forEach begin="0" end="${pro.complexity}" >
                                <img src="${pageContext.request.contextPath}/static/imges/xx.png">
                                </c:forEach>
                            </div>

                    </div>
                </div>
                <div class="warp-class2">
                    <div class="warp-class2-text">
                        <div class="iconfont text-padding">成长周期 <span class="iconfont-color">${pro.growth}</span>年</div>
                    </div>
                    <div class="warp-class2-text">
                        <div class="iconfont text-padding text-border-left">稀缺程度 <span class="iconfont-color">${pro.demand}</span>家公司需要</div>
                    </div>
                </div>

                <div class="warp-class2">
                    <div class="leftWarp">
                        薪资待遇
                    </div>
                    <div class="rightWarp">
                        <c:forEach var="i" begin="1" end="3" step="1">
                        <div class="rightWarp-class">

                            <div class="rightWarp-year">${i}-${i+1}年</div>

                            <div class="rightWarp-wages">${pro.wage_min*(i+1)}K-${pro.wage_max*(i+1)}K/月</div>
                        </div>
                            </c:forEach>

                    </div>
                </div>

                <div class="warp-class2">
                    <b class="text-b">有${pro.proCount}人正在学</b>
                </div>
                <div class="warp-class2">
                    <p class="text-p">${pro.hint}</p>

                </div>
                <p>修改日期：<date:date value ="${pro.update_at}"/></p>
                <% out.print("<font color='red'>你好，world2！</font>"); %>
                <div class="flip-container">
                    <p class="flip-title">${pro.proName}</p>
                    <p class="flip-text">${pro.introduce}</p>
                </div>
            </div>
        </div>
        </c:forEach>
    </div>
</div>




