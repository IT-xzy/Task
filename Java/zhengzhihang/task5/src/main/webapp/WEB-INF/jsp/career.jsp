<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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




    <div class="caption">
        <h4>前端开发方向</h4>
    </div>

    <div class="row">

        <%--@elvariable id="ocTS" type="java.util.List"--%>
        <c:forEach items="${ocTS}"  var="o" varStatus="oc" >
        <div class="col-md-4 col-sm-6 col-xs-12 top-margin">

            <div class="warp-border">
                <div class="clearfix">
                    <div class="icon-people"><img src="imges/${o.pic}"></div>
                    <div class="text">
                        <h4 class="">${o.career}</h4>
                        <p class="text-present">${o.career}，${o.introduction}</p>
                    </div>
                </div>

                <div class="warp-class2">
                    <div class="warp-class2-text">
                        <div class="iconfont text-padding">门槛
                            <c:forEach var="threshold" begin="1" end="${o.threshold}">
                                <img src="imges/xx.png">
                            </c:forEach>
                        </div>
                    </div>
                    <div class="warp-class2-text">
                        <div class="iconfont text-padding text-border-left">难易程度
                            <c:forEach var="threshold" begin="1" end="${o.complexity}">
                                <img src="imges/xx.png">
                            </c:forEach>
                        </div>
                    </div>
                </div>
                <div class="warp-class2">
                    <div class="warp-class2-text">
                        <div class="iconfont text-padding">成长周期 <span class="iconfont-color">${o.growthCycle}</span></div>
                    </div>
                    <div class="warp-class2-text">
                        <div class="iconfont text-padding text-border-left">稀缺程度 <span class="iconfont-color">${o.requirement}</span>家公司需要</div>
                    </div>
                </div>

                <div class="warp-class2">
                    <div class="leftWarp">
                        薪资待遇
                    </div>
                    <div class="rightWarp">
                        <div class="rightWarp-class">
                            <div class="rightWarp-year">Early_Salary</div>
                            <div class="rightWarp-wages">${o.eSalary}/月</div>
                        </div>
                        <div class="rightWarp-class">
                            <div class="rightWarp-year">Mete_Salary</div>
                            <div class="rightWarp-wages">${o.mSalary}/月</div>
                        </div>
                        <div class="rightWarp-class border-bottom">
                            <div class="rightWarp-year">Late_Salary</div>
                            <div class="rightWarp-wages">${o.lSalary}/月</div>
                        </div>
                    </div>
                </div>

                <div class="warp-class2">
                    <b class="text-b">有${o.courseSum}正在学</b>
                </div>
                <div class="warp-class2">
                    <p class="text-p">提示:在你学习之前你应该已经掌握${o.skillRelated}</p>
                </div>

                <div class="flip-container">
                    <p class="flip-title">iOS工程师</p>
                    <p class="flip-text">iOS是由苹果公司开发的移动操作统，iOS与苹果的Mac OS X操作系统一样， 也是以Darwin为基础的，因此同样属于类Unix的商业操作系统。国内iOS开发起步相对较晚， 人才培养机制更是远远跟不上市场发展速度。有限的iOS开发人才成了国内企业必争的资源。 国内iOS开发起步相对较晚，人才培养机制更是远远跟不上市场发展速度。 有限的iOS开发人才成了国内企业必争的资源。</p>
                </div>
            </div>

        </div>
        </c:forEach>
    </div>
</div>