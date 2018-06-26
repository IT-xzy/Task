<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/4/5
  Time: 0:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<div class="nav">
    <a href="${pageContext.request.contextPath}/welcome ">首页</a>
    <span>/合作企业</span>
</div>
<div class="zhiye">
    <span>方向:</span>
    <span class="active"><a href="#">全部</a></span>
    <span><a href="#">前端开发</a></span>
    <span><a href="#">后端开发</a></span>
    <span><a href="#">移动开发</a></span>
    <span><a href="#">整站开发</a></span>
    <span><a href="#">运营维护</a></span>
</div>
<div class="title">前端开发方向</div>

<div class="container face">
    <div class="row1">
        <c:forEach items="${joblist1}" var="s" >
            <div class="col-xs-12 col-md-4 man">
                <div class="row1 ">
                    <div class="col-md-5 img"></div>
                    <div class="col-md-7 jie">
                        <p>${s.jobname}</p>
                        <span>${s.description}</span>
                    </div>

                </div>

                <div class="row1">
                    <div class="col-md-6 left1">门榄</div>
                    <div class="col-md-6 right1">难易程度</div>
                </div>
                <div class="row1">
                    <div class="col-md-6 left2">
                        <span>成长周期</span>
                        <h>1-3</h>
                        <span>年</span>
                    </div>
                    <div class="col-md-6 right2">
                        <span>稀缺程度</span>
                        <h>${s.number_of_company}</h>
                        <span>家公司需要</span>
                    </div>
                </div>
                <div class="row1">
                    <div class="col-md-5 left3">薪资待遇</div>
                    <div class="col-md-7 right3">
                        <div class="row1">
                            <div class="col-xs-12 text">

                                <span>${s.salary1}</span>
                            </div>
                        </div>
                        <div class="row1">
                            <div class="col-xs-12 text">
                                <span>1${s.salary2}</span>
                            </div>
                        </div>
                        <div class="row1">
                            <div class="col-xs-12 text">
                                <span>${s.salary3}</span>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row1">
                    <div class="col-md-12 foot1">有<h>286</h>人正在学</div>
                </div>
                <div class="row1">
                    <div class="col-md-12 foot2">${s.hint}</div>
                </div>
            </div>
        </c:forEach>
    </div>
</div>
<div class="title">后端开发方向</div>
<div class="container face">
    <div class="row1">
        <c:forEach items="${joblist1}" var="s" >
            <div class="col-xs-12 col-md-4 man">

                <div class="row1 ">

                    <div class="col-md-5 img"></div>
                    <div class="col-md-7 jie">
                        <p>${s.jobname}</p>
                        <span>${s.description}</span>
                    </div>
                </div>
                <div class="row1">
                    <div class="col-md-6 left1">门榄</div>
                    <div class="col-md-6 right1">难易程度</div>
                </div>
                <div class="row1">
                    <div class="col-md-6 left2">
                        <span>成长周期</span>
                        <h>1-3</h>
                        <span>年</span>
                    </div>
                    <div class="col-md-6 right2">
                        <span>稀缺程度</span>
                        <h>${s.number_of_company}</h>
                        <span>家公司需要</span>
                    </div>
                </div>
                <div class="row1">
                    <div class="col-md-5 left3">薪资待遇</div>
                    <div class="col-md-7 right3">
                        <div class="row1">
                            <div class="col-xs-12 text">
                                <span>${s.salary1}</span>
                            </div>
                        </div>
                        <div class="row1">
                            <div class="col-xs-12 text">
                                <span>1${s.salary2}</span>
                            </div>
                        </div>
                        <div class="row1">
                            <div class="col-xs-12 text">
                                <span>${s.salary3}</span>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row1">
                    <div class="col-md-12 foot1">有<h>286</h>人正在学</div>
                </div>
                <div class="row1">
                    <div class="col-md-12 foot2">${s.hint}</div>
                </div>
            </div>
        </c:forEach>
    </div>
</div>
<div class="title">运维开发方向</div>
<div class="container face">
    <div class="row1">
        <c:forEach items="${joblist1}" var="s" >
            <div class="col-xs-12 col-md-4 man">
                <div class="row1 ">
                    <div class="col-md-5 img"></div>
                    <div class="col-md-7 jie">
                        <p>${s.jobname}</p>
                        <span>${s.description}</span>
                    </div>

                </div>

                <div class="row1">
                    <div class="col-md-6 left1">门榄</div>
                    <div class="col-md-6 right1">难易程度</div>
                </div>
                <div class="row1">
                    <div class="col-md-6 left2">
                        <span>成长周期</span>
                        <h>1-3</h>
                        <span>年</span>
                    </div>
                    <div class="col-md-6 right2">
                        <span>稀缺程度</span>
                        <h>${s.number_of_company}</h>
                        <span>家公司需要</span>
                    </div>
                </div>
                <div class="row1">
                    <div class="col-md-5 left3">薪资待遇</div>
                    <div class="col-md-7 right3">
                        <div class="row1">
                            <div class="col-xs-12 text">
                                <span>${s.salary1}</span>
                            </div>
                        </div>
                        <div class="row1">
                            <div class="col-xs-12 text">
                                <span>1${s.salary2}</span>
                            </div>
                        </div>
                        <div class="row1">
                            <div class="col-xs-12 text">
                                <span>${s.salary3}</span>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row1">
                    <div class="col-md-12 foot1">有<h>286</h>人正在学</div>
                </div>
                <div class="row1">
                    <div class="col-md-12 foot2">${s.hint}</div>
                </div>
            </div>
        </c:forEach>
    </div>
</div>
</body>
</html>
