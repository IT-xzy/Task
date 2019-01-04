<%@ include file="../include/include.jsp"%>
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
        <c:forEach items="${frontList}" var="back">
            <div class="col-md-4 col-sm-6 col-xs-12 top-margin">

                <div class="warp-border">
                    <div class="clearfix">
                        <div class="icon-people"><img src="${pageContext.request.contextPath}${back.img}"></div>
                        <div class="text">
                            <h4 class="">${back.name}</h4>
                            <p class="text-present">${back.introduce}</p>
                        </div>
                    </div>
                    <div class="warp-class2">
                        <div class="warp-class2-text">
                            <div class="iconfont text-padding">
                                门槛
                                <c:forEach begin="1" end="${back.condition}">
                                    <img src="${pageContext.request.contextPath}/imges/xx.png">
                                </c:forEach>
                            </div>
                        </div>
                        <div class="warp-class2-text">
                            <div class="iconfont text-padding text-border-left">
                                难易程度
                                <c:forEach begin="1" end="${back.difficult}">
                                    <img src="${pageContext.request.contextPath}/imges/xx.png">
                                </c:forEach>
                            </div>
                        </div>
                    </div>
                    <div class="warp-class2">
                        <div class="warp-class2-text">
                            <div class="iconfont text-padding">
                                成长周期
                                <span class="iconfont-color">
                                        ${back.priodFrom}-${back.priodTo}
                                </span>
                                年
                            </div>
                        </div>
                        <div class="warp-class2-text">
                            <div class="iconfont text-padding text-border-left">
                                稀缺程度
                                <span class="iconfont-color">${back.want}</span>
                                家公司需要
                            </div>
                        </div>
                    </div>

                    <div class="warp-class2">
                        <div class="leftWarp">
                            薪资待遇
                        </div>
                        <div class="rightWarp">
                            <div class="rightWarp-class">
                                <div class="rightWarp-year">1-2年</div>
                                <div class="rightWarp-wages">
                                        ${back.salaryOne}k-${back.salaryTwo}k
                                    /月
                                </div>
                            </div>
                            <div class="rightWarp-class">
                                <div class="rightWarp-year">2-3年</div>
                                <div class="rightWarp-wages">
                                        ${back.salaryTwo}k-${back.salaryThree}k
                                    /月
                                </div>
                            </div>
                            <div class="rightWarp-class border-bottom">
                                <div class="rightWarp-year">3-5年</div>
                                <div class="rightWarp-wages">
                                        ${back.salaryThree}k-${back.salaryFour}k
                                    /月
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="warp-class2">
                        <b class="text-b">有${back.studying}人正在学      更新时间：<ms:Date value="${back.updateAt}"/></b>
                    </div>
                    <div class="warp-class2">
                        <p class="text-p">提示:${back.prompt}</p>
                    </div>

                    <div class="flip-container">
                        <p class="flip-title">iOS工程师</p>
                        <p class="flip-text">iOS是由苹果公司开发的移动操作统，iOS与苹果的Mac OS X操作系统一样， 也是以Darwin为基础的，因此同样属于类Unix的商业操作系统。国内iOS开发起步相对较晚， 人才培养机制更是远远跟不上市场发展速度。有限的iOS开发人才成了国内企业必争的资源。 国内iOS开发起步相对较晚，人才培养机制更是远远跟不上市场发展速度。 有限的iOS开发人才成了国内企业必争的资源。</p>
                    </div>
                </div>

            </div>
        </c:forEach>
    </div>

    <div class="caption">
        <h4>后端开发方向</h4>
    </div>

    <div class="row">
        <c:forEach items="${backList}" var="back">
            <div class="col-md-4 col-sm-6 col-xs-12 top-margin">

                <div class="warp-border">
                    <div class="clearfix">
                        <div class="icon-people"><img src="${pageContext.request.contextPath}${back.img}"></div>
                        <div class="text">
                            <h4 class="">${back.name}</h4>
                            <p class="text-present">${back.introduce}</p>
                        </div>
                    </div>
                    <div class="warp-class2">
                        <div class="warp-class2-text">
                            <div class="iconfont text-padding">
                                门槛
                                <c:forEach begin="1" end="${back.condition}">
                                    <img src="${pageContext.request.contextPath}/imges/xx.png">
                                </c:forEach>
                            </div>
                        </div>
                        <div class="warp-class2-text">
                            <div class="iconfont text-padding text-border-left">
                                难易程度
                                <c:forEach begin="1" end="${back.difficult}">
                                    <img src="${pageContext.request.contextPath}/imges/xx.png">
                                </c:forEach>
                            </div>
                        </div>
                    </div>
                    <div class="warp-class2">
                        <div class="warp-class2-text">
                            <div class="iconfont text-padding">
                                成长周期
                                <span class="iconfont-color">
                                        ${back.priodFrom}-${back.priodTo}
                                </span>
                                年
                            </div>
                        </div>
                        <div class="warp-class2-text">
                            <div class="iconfont text-padding text-border-left">
                                稀缺程度
                                <span class="iconfont-color">${back.want}</span>
                                家公司需要
                            </div>
                        </div>
                    </div>

                    <div class="warp-class2">
                        <div class="leftWarp">
                            薪资待遇
                        </div>
                        <div class="rightWarp">
                            <div class="rightWarp-class">
                                <div class="rightWarp-year">1-2年</div>
                                <div class="rightWarp-wages">
                                    ${back.salaryOne}k-${back.salaryTwo}k
                                    /月
                                </div>
                            </div>
                            <div class="rightWarp-class">
                                <div class="rightWarp-year">2-3年</div>
                                <div class="rightWarp-wages">
                                    ${back.salaryTwo}k-${back.salaryThree}k
                                    /月
                                </div>
                            </div>
                            <div class="rightWarp-class border-bottom">
                                <div class="rightWarp-year">3-5年</div>
                                <div class="rightWarp-wages">
                                    ${back.salaryThree}k-${back.salaryFour}k
                                    /月
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="warp-class2">
                        <b class="text-b">有${back.studying}人正在学      更新时间：<ms:Date value="${back.updateAt}"/></b>
                    </div>
                    <div class="warp-class2">
                        <p class="text-p">提示:${back.prompt}</p>
                    </div>

                    <div class="flip-container">
                        <p class="flip-title">iOS工程师</p>
                        <p class="flip-text">iOS是由苹果公司开发的移动操作统，iOS与苹果的Mac OS X操作系统一样， 也是以Darwin为基础的，因此同样属于类Unix的商业操作系统。国内iOS开发起步相对较晚， 人才培养机制更是远远跟不上市场发展速度。有限的iOS开发人才成了国内企业必争的资源。 国内iOS开发起步相对较晚，人才培养机制更是远远跟不上市场发展速度。 有限的iOS开发人才成了国内企业必争的资源。</p>
                    </div>
                </div>

            </div>
        </c:forEach>
    </div>

    <div class="caption">
        <h4>运维方向</h4>
    </div>

    <div class="row">
        <c:forEach items="${operaList}" var="back">
            <div class="col-md-4 col-sm-6 col-xs-12 top-margin">

                <div class="warp-border">
                    <div class="clearfix">
                        <div class="icon-people"><img src="${pageContext.request.contextPath}${back.img}"></div>
                        <div class="text">
                            <h4 class="">${back.name}</h4>
                            <p class="text-present">${back.introduce}</p>
                        </div>
                    </div>
                    <div class="warp-class2">
                        <div class="warp-class2-text">
                            <div class="iconfont text-padding">
                                门槛
                                <c:forEach begin="1" end="${back.condition}">
                                    <img src="${pageContext.request.contextPath}/imges/xx.png">
                                </c:forEach>
                            </div>
                        </div>
                        <div class="warp-class2-text">
                            <div class="iconfont text-padding text-border-left">
                                难易程度
                                <c:forEach begin="1" end="${back.difficult}">
                                    <img src="${pageContext.request.contextPath}/imges/xx.png">
                                </c:forEach>
                            </div>
                        </div>
                    </div>
                    <div class="warp-class2">
                        <div class="warp-class2-text">
                            <div class="iconfont text-padding">
                                成长周期
                                <span class="iconfont-color">
                                        ${back.priodFrom}-${back.priodTo}
                                </span>
                                年
                            </div>
                        </div>
                        <div class="warp-class2-text">
                            <div class="iconfont text-padding text-border-left">
                                稀缺程度
                                <span class="iconfont-color">${back.want}</span>
                                家公司需要
                            </div>
                        </div>
                    </div>

                    <div class="warp-class2">
                        <div class="leftWarp">
                            薪资待遇
                        </div>
                        <div class="rightWarp">
                            <div class="rightWarp-class">
                                <div class="rightWarp-year">1-2年</div>
                                <div class="rightWarp-wages">
                                        ${back.salaryOne}k-${back.salaryTwo}k
                                    /月
                                </div>
                            </div>
                            <div class="rightWarp-class">
                                <div class="rightWarp-year">2-3年</div>
                                <div class="rightWarp-wages">
                                        ${back.salaryTwo}k-${back.salaryThree}k
                                    /月
                                </div>
                            </div>
                            <div class="rightWarp-class border-bottom">
                                <div class="rightWarp-year">3-5年</div>
                                <div class="rightWarp-wages">
                                        ${back.salaryThree}k-${back.salaryFour}k
                                    /月
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="warp-class2">
                        <b class="text-b">有${back.studying}人正在学      更新时间：<ms:Date value="${back.updateAt}"/></b>
                    </div>
                    <div class="warp-class2">
                        <p class="text-p">提示:${back.prompt}</p>
                    </div>

                    <div class="flip-container">
                        <p class="flip-title">iOS工程师</p>
                        <p class="flip-text">iOS是由苹果公司开发的移动操作统，iOS与苹果的Mac OS X操作系统一样， 也是以Darwin为基础的，因此同样属于类Unix的商业操作系统。国内iOS开发起步相对较晚， 人才培养机制更是远远跟不上市场发展速度。有限的iOS开发人才成了国内企业必争的资源。 国内iOS开发起步相对较晚，人才培养机制更是远远跟不上市场发展速度。 有限的iOS开发人才成了国内企业必争的资源。</p>
                    </div>
                </div>

            </div>
        </c:forEach>
    </div>

    <div class="caption">
        <h4>用户体验</h4>
    </div>

    <div class="row">
        <c:forEach items="${userList}" var="back">
            <div class="col-md-4 col-sm-6 col-xs-12 top-margin">

                <div class="warp-border">
                    <div class="clearfix">
                        <div class="icon-people"><img src="${pageContext.request.contextPath}${back.img}"></div>
                        <div class="text">
                            <h4 class="">${back.name}</h4>
                            <p class="text-present">${back.introduce}</p>
                        </div>
                    </div>
                    <div class="warp-class2">
                        <div class="warp-class2-text">
                            <div class="iconfont text-padding">
                                门槛
                                <c:forEach begin="1" end="${back.condition}">
                                    <img src="${pageContext.request.contextPath}/imges/xx.png">
                                </c:forEach>
                            </div>
                        </div>
                        <div class="warp-class2-text">
                            <div class="iconfont text-padding text-border-left">
                                难易程度
                                <c:forEach begin="1" end="${back.difficult}">
                                    <img src="${pageContext.request.contextPath}/imges/xx.png">
                                </c:forEach>
                            </div>
                        </div>
                    </div>
                    <div class="warp-class2">
                        <div class="warp-class2-text">
                            <div class="iconfont text-padding">
                                成长周期
                                <span class="iconfont-color">
                                        ${back.priodFrom}-${back.priodTo}
                                </span>
                                年
                            </div>
                        </div>
                        <div class="warp-class2-text">
                            <div class="iconfont text-padding text-border-left">
                                稀缺程度
                                <span class="iconfont-color">${back.want}</span>
                                家公司需要
                            </div>
                        </div>
                    </div>

                    <div class="warp-class2">
                        <div class="leftWarp">
                            薪资待遇
                        </div>
                        <div class="rightWarp">
                            <div class="rightWarp-class">
                                <div class="rightWarp-year">1-2年</div>
                                <div class="rightWarp-wages">
                                        ${back.salaryOne}k-${back.salaryTwo}k
                                    /月
                                </div>
                            </div>
                            <div class="rightWarp-class">
                                <div class="rightWarp-year">2-3年</div>
                                <div class="rightWarp-wages">
                                        ${back.salaryTwo}k-${back.salaryThree}k
                                    /月
                                </div>
                            </div>
                            <div class="rightWarp-class border-bottom">
                                <div class="rightWarp-year">3-5年</div>
                                <div class="rightWarp-wages">
                                        ${back.salaryThree}k-${back.salaryFour}k
                                    /月
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="warp-class2">
                        <b class="text-b">有${back.studying}人正在学      更新时间：<ms:Date value="${back.updateAt}"/></b>
                    </div>
                    <div class="warp-class2">
                        <p class="text-p">提示:${back.prompt}</p>
                    </div>

                    <div class="flip-container">
                        <p class="flip-title">iOS工程师</p>
                        <p class="flip-text">iOS是由苹果公司开发的移动操作统，iOS与苹果的Mac OS X操作系统一样， 也是以Darwin为基础的，因此同样属于类Unix的商业操作系统。国内iOS开发起步相对较晚， 人才培养机制更是远远跟不上市场发展速度。有限的iOS开发人才成了国内企业必争的资源。 国内iOS开发起步相对较晚，人才培养机制更是远远跟不上市场发展速度。 有限的iOS开发人才成了国内企业必争的资源。</p>
                    </div>
                </div>

            </div>
        </c:forEach>
    </div>

    <div style="height: 100px"></div>
</div>