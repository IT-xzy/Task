<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<tiles:insertDefinition name="TemplateTwo">

    <tiles:putAttribute name="bodytwo">


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
                <c:forEach items="${zhiye}" var="d">
                <div class="col-md-4 col-sm-6 col-xs-12 top-margin">

                    <div class="warp-border">
                        <div class="clearfix">
                            <div class="icon-people"><img src="${d.URL}"></div>
                            <div class="text">
                                <h4 class="">${d.name}</h4>
                                <p class="text-present">${d.introduction}</p>
                            </div>
                        </div>

                        <div class="warp-class2">
                            <div class="warp-class2-text">
                                <div class="iconfont text-padding">门槛 <img src="${pageContext.request.contextPath}/imagesTwo/xx.png"></div>
                            </div>
                            <div class="warp-class2-text">
                                <div class="iconfont text-padding text-border-left">难易程度 <img src="${pageContext.request.contextPath}/imagesTwo/xx.png"><img
                                        src="${pageContext.request.contextPath}/imagesTwo/xx.png"></div>
                            </div>
                        </div>
                        <div class="warp-class2">
                            <div class="warp-class2-text">
                                <div class="iconfont text-padding">成长周期 <span class="iconfont-color">1-3</span>年</div>
                            </div>
                            <div class="warp-class2-text">
                                <div class="iconfont text-padding text-border-left">稀缺程度 <span class="iconfont-color">${d.companyCount}</span>家公司需要
                                </div>
                            </div>
                        </div>

                        <div class="warp-class2">
                            <div class="leftWarp">
                                薪资待遇
                            </div>
                            <div class="rightWarp">
                                <div class="rightWarp-class">
                                    <div class="rightWarp-year">0-1年</div>
                                    <div class="rightWarp-wages">5k-10k/月</div>
                                </div>
                                <div class="rightWarp-class">
                                    <div class="rightWarp-year">2-3年</div>
                                    <div class="rightWarp-wages">10k-20k/月</div>
                                </div>
                                <div class="rightWarp-class border-bottom">
                                    <div class="rightWarp-year">3-5年</div>
                                    <div class="rightWarp-wages">30k-45k/月</div>
                                </div>
                            </div>
                        </div>

                        <div class="warp-class2">
                            <b class="text-b">有${name}人正在学</b>
                        </div>
                        <div class="warp-class2">
                            <p class="text-p">提示:在你学习之前你应该已经掌握XXXXX、XXXXX、XX等语言基础</p>
                        </div>

                        <div class="flip-container">
                            <p class="flip-title">${d.title}</p>
                            <p class="flip-text">${d.xiangqing}</p>
                        </div>
                    </div>

                </div>
        </c:forEach>
        </div>
        </div>

    </tiles:putAttribute>
</tiles:insertDefinition>