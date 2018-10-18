<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/tags" prefix="date"%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1,minimum-scale=1.0,  maximum-scale=1">
<link rel="stylesheet" type="text/css" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
<title>职业</title>
<link type="text/css" rel="stylesheet" href="../../static/css/task9-3.css">

<div class="container">
    <div class="row">
        <div class="col-md-12">
            <div class="title">首页&gt<span>职业</span></div>
        </div>
    </div>
</div>

<div class="container">
    <div class="row">
        <div class="col-md-12">
            <div class="section1">
                <span class="total">方向&#58</span>
                <span class="branch">全部</span>
                <span class="branch">前端开发</span>
                <span class="branch">后端开发</span>
                <span class="branch">移动开发</span>
                <span class="branch">整站开发</span>
                <span class="branch">运营维护</span>
            </div>
        </div>
    </div>
</div>

<div class="container">
    <div class="row">
        <div class="col-md-12">
            <div class="subtitle">前端开发方向</div>
        </div>
    </div>
</div>


<div class="container">
    <div class="row">
        <div class="col-md-4 col-sm-6">
            <c:forEach items="${professionList}" var="profession">
            <c:if test="${profession.id == 154}">
            <div class="block">
                <div class="row1">
                    <div>
                        <img src="${profession.icon}">
                    </div>
                    <div>
                        <p><span>${profession.proName}</span></p>
                        <p>${profession.careerDirection}<br/>
                            创建时间：<span><date:date value="${profession.createAt}" pattern="yyyy/MM/dd HH:mm:ss"/></span><br/>
                            更新时间：<span><date:date value="${profession.updateAt}" pattern="yyyy/MM/dd HH:mm:ss"/></span>
                            <%--创建时间：<span>${profession.create_at}</span><br/>--%>
                            <%--更新时间：<span>${profession.update_at}</span>--%>
                        </p>
                    </div>
                </div>
                <div class="row2">
                    <p class="right-border">门槛
                    <c:forEach begin="1" end="${profession.proThreshold}" step="1">
                    <img src="../../static/img/19.jpg">
                    </c:forEach>
                    </p>
                    <p>难易程度
                    <c:forEach begin="1" end="${profession.proDifficulty}" step="1">
                   <img src="../../static/img/19.jpg">
                    </c:forEach>
                    </p>
                </div>
                <div class="row3">
                    <p class="right-border">成长周期 <span>${profession.growthCycle}</span></p>
                    <p>稀缺程度 <span>${profession.proCompany}</span>家公司需要</p>
                </div>
                <div class="row4">
                    <div class="left">薪资待遇</div>
                    <div class="right">
                        <div>
                            <span class="left-side">0-1年</span>
                            <span class="right-side">${profession.proSalaryMin}</span>
                        </div>
                        <div>
                            <span class="left-side">1-3年</span>
                            <span class="right-side">${profession.proSalaryNormal}</span>
                        </div>
                        <div>
                            <span class="left-side">3-5年</span>
                            <span class="right-side">${profession.proSalaryMax}</span>
                        </div>
                    </div>
                </div>
                <div class="row5">有<span>${profession.studyNumber}</span>人正在学</div>
                <div class="row6">${profession.hint}</div>
                <div class="extro-info3">
                    <p class="extro-top">Web前端工程师</p>
                    <p class="extro-bottom">${profession.proIntroduction}</p>
                </div>
            </div>
            </c:if>
            </c:forEach>
        </div>

        <div class="col-md-4 col-sm-6">
            <c:forEach items="${professionList}" var="profession">
                <c:if test="${profession.id == 784}">
                    <div class="block">
                        <div class="row1">
                            <div>
                                <img src="${profession.icon}">
                            </div>
                            <div>
                                <p><span>${profession.proName}</span></p>
                                <p>${profession.careerDirection}
                                    <br/>
                                    创建时间：<span><date:date value="${profession.createAt}" pattern="yyyy/MM/dd HH:mm:ss"/></span><br/>
                                    更新时间：<span><date:date value="${profession.updateAt}" pattern="yyyy/MM/dd HH:mm:ss"/></span></p>
                            </div>
                        </div>
                        <div class="row2">
                            <p class="right-border">门槛
                                <c:forEach begin="1" end="${profession.proThreshold}" step="1">
                                <img src="../../static/img/19.jpg">
                            </c:forEach>
                            </p>
                            <p>难易程度
                                <c:forEach begin="1" end="${profession.proDifficulty}" step="1">
                                <img src="../../static/img/19.jpg">
                                </c:forEach>
                            </p>
                        </div>
                        <div class="row3">
                            <p class="right-border">成长周期 <span>${profession.growthCycle}</span></p>
                            <p>稀缺程度 <span>${profession.proCompany}</span>家公司需要</p>
                        </div>
                        <div class="row4">
                            <div class="left">薪资待遇</div>
                            <div class="right">
                                <div>
                                    <span class="left-side">0-1年</span>
                                    <span class="right-side">${profession.proSalaryMin}</span>
                                </div>
                                <div>
                                    <span class="left-side">1-3年</span>
                                    <span class="right-side">${profession.proSalaryNormal}</span>
                                </div>
                                <div>
                                    <span class="left-side">3-5年</span>
                                    <span class="right-side">${profession.proSalaryMax}</span>
                                </div>
                            </div>
                        </div>
                        <div class="row5">有<span>${profession.studyNumber}</span>人正在学</div>
                        <div class="row6">${profession.hint}</div>
                        <div class="extro-info3">
                            <p class="extro-top">Web前端工程师</p>
                            <p class="extro-bottom">${profession.proIntroduction}</p>
                        </div>
                    </div>
                </c:if>
            </c:forEach>
        </div>

        <div class="col-md-4 col-sm-6">
            <c:forEach items="${professionList}" var="profession">
                <c:if test="${profession.id == 455}">
                    <div class="block">
                        <div class="row1">
                            <div>
                                <img src="${profession.icon}">
                            </div>
                            <div>
                                <p><span>${profession.proName}</span></p>
                                <p>${profession.careerDirection}
                                    <br/>
                                    创建时间：<span><date:date value="${profession.createAt}" pattern="yyyy/MM/dd HH:mm:ss"/></span><br/>
                                    更新时间：<span><date:date value="${profession.updateAt}" pattern="yyyy/MM/dd HH:mm:ss"/></span></p>
                            </div>
                        </div>
                        <div class="row2">
                            <p class="right-border">门槛
                                <c:forEach begin="1" end="${profession.proThreshold}" step="1">
                                <img src="../../static/img/19.jpg">
                            </c:forEach>
                            </p>
                            <p>难易程度
                                <c:forEach begin="1" end="${profession.proDifficulty}" step="1">
                                <img src="../../static/img/19.jpg">
                                </c:forEach>
                            </p>
                        </div>
                        <div class="row3">
                            <p class="right-border">成长周期 <span>${profession.growthCycle}</span></p>
                            <p>稀缺程度 <span>${profession.proCompany}</span>家公司需要</p>
                        </div>
                        <div class="row4">
                            <div class="left">薪资待遇</div>
                            <div class="right">
                                <div>
                                    <span class="left-side">0-1年</span>
                                    <span class="right-side">${profession.proSalaryMin}</span>
                                </div>
                                <div>
                                    <span class="left-side">1-3年</span>
                                    <span class="right-side">${profession.proSalaryNormal}</span>
                                </div>
                                <div>
                                    <span class="left-side">3-5年</span>
                                    <span class="right-side">${profession.proSalaryMax}</span>
                                </div>
                            </div>
                        </div>
                        <div class="row5">有<span>${profession.studyNumber}</span>人正在学</div>
                        <div class="row6">${profession.hint}</div>
                        <div class="extro-info3">
                            <p class="extro-top">Web前端工程师</p>
                            <p class="extro-bottom">${profession.proIntroduction}</p>
                        </div>
                    </div>
                </c:if>
            </c:forEach>
        </div>
    </div>
</div>

<div class="container">
    <div class="row">
        <div class="col-md-12">
            <div class="subtitle">后端开发方向</div>
        </div>
    </div>
</div>

<div class="container">
    <div class="row">
        <div class="col-md-4 col-sm-6">
            <c:forEach items="${professionList}" var="profession">
                <c:if test="${profession.id == 122}">
                    <div class="block">
                        <div class="row1">
                            <div>
                                <img src="${profession.icon}">
                            </div>
                            <div>
                                <p><span>${profession.proName}</span></p>
                                <p>${profession.careerDirection}
                                    <br/>
                                    创建时间：<span><date:date value="${profession.createAt}" pattern="yyyy/MM/dd HH:mm:ss"/></span><br/>
                                    更新时间：<span><date:date value="${profession.updateAt}" pattern="yyyy/MM/dd HH:mm:ss"/></span>
                                </p>
                            </div>
                        </div>
                        <div class="row2">
                            <p class="right-border">门槛
                                <c:forEach begin="1" end="${profession.proThreshold}" step="1">
                                <img src="../../static/img/19.jpg">
                            </c:forEach>
                            </p>
                            <p>难易程度
                                <c:forEach begin="1" end="${profession.proDifficulty}" step="1">
                                <img src="../../static/img/19.jpg">
                                </c:forEach>
                            </p>
                        </div>
                        <div class="row3">
                            <p class="right-border">成长周期 <span>${profession.growthCycle}</span></p>
                            <p>稀缺程度 <span>${profession.proCompany}</span>家公司需要</p>
                        </div>
                        <div class="row4">
                            <div class="left">薪资待遇</div>
                            <div class="right">
                                <div>
                                    <span class="left-side">0-1年</span>
                                    <span class="right-side">${profession.proSalaryMin}</span>
                                </div>
                                <div>
                                    <span class="left-side">1-3年</span>
                                    <span class="right-side">${profession.proSalaryNormal}</span>
                                </div>
                                <div>
                                    <span class="left-side">3-5年</span>
                                    <span class="right-side">${profession.proSalaryMax}</span>
                                </div>
                            </div>
                        </div>
                        <div class="row5">有<span>${profession.studyNumber}</span>人正在学</div>
                        <div class="row6">${profession.hint}</div>
                        <div class="extro-info3">
                            <p class="extro-top">ios后端工程师</p>
                            <p class="extro-bottom">${profession.proIntroduction}</p>
                        </div>
                    </div>
                </c:if>
            </c:forEach>
        </div>

        <div class="col-md-4 col-sm-6">
            <c:forEach items="${professionList}" var="profession">
                <c:if test="${profession.id == 653}">
                    <div class="block">
                        <div class="row1">
                            <div>
                                <img src="${profession.icon}">
                            </div>
                            <div>
                                <p><span>${profession.proName}</span></p>
                                <p>${profession.careerDirection}
                                    <br/>
                                    创建时间：<span><date:date value="${profession.createAt}" pattern="yyyy/MM/dd HH:mm:ss"/></span><br/>
                                    更新时间：<span><date:date value="${profession.updateAt}" pattern="yyyy/MM/dd HH:mm:ss"/></span>
                                </p>
                            </div>
                        </div>
                        <div class="row2">
                            <p class="right-border">门槛
                                <c:forEach begin="1" end="${profession.proThreshold}" step="1">
                                <img src="../../static/img/19.jpg">
                            </c:forEach>
                            </p>
                            <p>难易程度
                                <c:forEach begin="1" end="${profession.proDifficulty}" step="1">
                                <img src="../../static/img/19.jpg">
                                </c:forEach>
                            </p>
                        </div>
                        <div class="row3">
                            <p class="right-border">成长周期 <span>${profession.growthCycle}</span></p>
                            <p>稀缺程度 <span>${profession.proCompany}</span>家公司需要</p>
                        </div>
                        <div class="row4">
                            <div class="left">薪资待遇</div>
                            <div class="right">
                                <div>
                                    <span class="left-side">0-1年</span>
                                    <span class="right-side">${profession.proSalaryMin}</span>
                                </div>
                                <div>
                                    <span class="left-side">1-3年</span>
                                    <span class="right-side">${profession.proSalaryNormal}</span>
                                </div>
                                <div>
                                    <span class="left-side">3-5年</span>
                                    <span class="right-side">${profession.proSalaryMax}</span>
                                </div>
                            </div>
                        </div>
                        <div class="row5">有<span>${profession.studyNumber}</span>人正在学</div>
                        <div class="row6">${profession.hint}</div>
                        <div class="extro-info3">
                            <p class="extro-top">java后端工程师</p>
                            <p class="extro-bottom">${profession.proIntroduction}</p>
                        </div>
                    </div>
                </c:if>
            </c:forEach>
        </div>
    </div>
</div>

<div class="container">
    <div class="row">
        <div class="col-md-12">
            <div class="subtitle">运维方向</div>
        </div>
    </div>
</div>

<div class="container">
    <div class="row">
        <div class="col-md-4 col-sm-6">
            <c:forEach items="${professionList}" var="profession">
                <c:if test="${profession.id == 487}">
                    <div class="block">
                        <div class="row1">
                            <div>
                                <img src="${profession.icon}">
                            </div>
                            <div>
                                <p><span>${profession.proName}</span></p>
                                <p>${profession.careerDirection}
                                    <br/>
                                    创建时间：<span><date:date value="${profession.createAt}" pattern="yyyy/MM/dd HH:mm:ss"/></span><br/>
                                    更新时间：<span><date:date value="${profession.updateAt}" pattern="yyyy/MM/dd HH:mm:ss"/></span>
                                </p>
                            </div>
                        </div>
                        <div class="row2">
                            <p class="right-border">门槛
                                <c:forEach begin="1" end="${profession.proThreshold}" step="1">
                                    <img src="../../static/img/19.jpg">
                                </c:forEach>
                            </p>
                            <p>难易程度
                                <c:forEach begin="1" end="${profession.proDifficulty}" step="1">
                                    <img src="../../static/img/19.jpg">
                                </c:forEach>
                            </p>
                        </div>
                        <div class="row3">
                            <p class="right-border">成长周期 <span>${profession.growthCycle}</span></p>
                            <p>稀缺程度 <span>${profession.proCompany}</span>家公司需要</p>
                        </div>
                        <div class="row4">
                            <div class="left">薪资待遇</div>
                            <div class="right">
                                <div>
                                    <span class="left-side">0-1年</span>
                                    <span class="right-side">${profession.proSalaryMin}</span>
                                </div>
                                <div>
                                    <span class="left-side">1-3年</span>
                                    <span class="right-side">${profession.proSalaryNormal}</span>
                                </div>
                                <div>
                                    <span class="left-side">3-5年</span>
                                    <span class="right-side">${profession.proSalaryMax}</span>
                                </div>
                            </div>
                        </div>
                        <div class="row5">有<span>${profession.studyNumber}</span>人正在学</div>
                        <div class="row6">${profession.hint}</div>
                        <div class="extro-info3">
                            <p class="extro-top">运维大师</p>
                            <p class="extro-bottom">${profession.proIntroduction}</p>
                        </div>
                    </div>
                </c:if>
            </c:forEach>
        </div>
    </div>
</div>

<div class="container">
    <div class="row">
        <div class="col-md-12">
            <div class="subtitle">UI方向</div>
        </div>
    </div>
</div>

<div class="container">
    <div class="row">
        <div class="col-md-4 col-sm-6">
            <c:forEach items="${professionList}" var="profession">
                <c:if test="${profession.id == 56}">
                    <div class="block">
                        <div class="row1">
                            <div>
                                <img src="${profession.icon}">
                            </div>
                            <div>
                                <p><span>${profession.proName}</span></p>
                                <p>${profession.careerDirection}
                                    <br/>
                                    创建时间：<span><date:date value="${profession.createAt}" pattern="yyyy/MM/dd HH:mm:ss"/></span><br/>
                                    更新时间：<span><date:date value="${profession.updateAt}" pattern="yyyy/MM/dd HH:mm:ss"/></span>
                                </p>
                            </div>
                        </div>
                        <div class="row2">
                            <p class="right-border">门槛
                                <c:forEach begin="1" end="${profession.proThreshold}" step="1">
                                    <img src="../../static/img/19.jpg">
                                </c:forEach>
                            </p>
                            <p>难易程度
                                <c:forEach begin="1" end="${profession.proDifficulty}" step="1">
                                    <img src="../../static/img/19.jpg">
                                </c:forEach>
                            </p>
                        </div>
                        <div class="row3">
                            <p class="right-border">成长周期 <span>${profession.growthCycle}</span></p>
                            <p>稀缺程度 <span>${profession.proCompany}</span>家公司需要</p>
                        </div>
                        <div class="row4">
                            <div class="left">薪资待遇</div>
                            <div class="right">
                                <div>
                                    <span class="left-side">0-1年</span>
                                    <span class="right-side">${profession.proSalaryMin}</span>
                                </div>
                                <div>
                                    <span class="left-side">1-3年</span>
                                    <span class="right-side">${profession.proSalaryNormal}</span>
                                </div>
                                <div>
                                    <span class="left-side">3-5年</span>
                                    <span class="right-side">${profession.proSalaryMax}</span>
                                </div>
                            </div>
                        </div>
                        <div class="row5">有<span>${profession.studyNumber}</span>人正在学</div>
                        <div class="row6">${profession.hint}</div>
                        <div class="extro-info3">
                            <p class="extro-top">ui妹妹</p>
                            <p class="extro-bottom">${profession.proIntroduction}</p>
                        </div>
                    </div>
                </c:if>
            </c:forEach>
        </div>
    </div>
</div>
<div>
    <div class="col-md-4 col-sm-6">
        <div class="col-md-4 col-sm-6"></div>
        <div class="col-md-4 col-sm-6"></div>
    </div>
</div>
