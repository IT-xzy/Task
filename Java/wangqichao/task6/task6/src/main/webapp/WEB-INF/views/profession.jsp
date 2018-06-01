<%@ page language="java" contentType="text/html; charset=UTF-8"

         pageEncoding="UTF-8" import="java.util.*" isELIgnored="false"  %>
<%@ taglib uri="/tags" prefix="date"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>技能树首页</title>
    <link rel="stylesheet/less" type="text/css" href="../../less/task15.less">
    <script src="../../less.js-2.5.3/dist/less.min.js" type="text/javascript"></script>
    <meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=no">
</head>
<body>
<main>
    <div class="col-md-12 col-sm-12 col-lg-12 job-row3">
        首页＞<a class="company" href="#">职业</a>
    </div>
    <div class="col-md-12 col-lg-12">
        <div class="job-select">
            <div class="side">方向：</div>
            <a href="#" class="job-type">全部</a>
            <a href="#web" class="job-type">前端开发</a>
            <a href="#java" class="job-type">后端开发</a>
            <a href="#mobile" class="job-type">移动开发</a>
            <a href="#site-development" class="job-type">整站开发</a>
            <a href="#operation" class="job-type">运营维护</a>
        </div>
    </div>
    <!--前端-->
    <div class="row">
        <div class="col-md-12 col-lg-12">
            <a name="web"></a><div class="qianduan-top"><strong>前端开发方向</strong></div>
        </div>
    </div>
    <!--前端1-->
    <div class="row size">
        <div>
            <div class="col-md-4 col-sm-6 col-lg-4 div1">
                <div class="table-size">
                    <table border="1">
                        <div class="divhover">
                            <div class="ios">${requestScope.web.name}</div>
                            切图仔简介<date:date value ="${requestScope.web.createdAt} "/></div>
                        <tr>
                            <td colspan="2">
                                <div class="table-head">
                                    <div class="web-img"></div>
                                    <div><h4>${requestScope.web.name}</h4><p class="table-p">${requestScope.web.intro}</p></div>
                                </div>
                            </td>
                        </tr>
                        <tr>
                            <td style="width: 50%;"><div class="danteng"><div class="star-left">门槛</div>
                                <%--使用choose,when和otherwise标签实现星星数目的选择输出--%>
                                <c:choose>
                                    <c:when test="${requestScope.web.request==1}">
                                        <div class="star"></div>
                                    </c:when>
                                    <c:when test="${requestScope.web.request==2}">
                                        <div class="star"></div><div class="star"></div>
                                    </c:when>
                                    <c:when test="${requestScope.web.request==3}">
                                        <div class="star"></div><div class="star"></div><div class="star"></div>
                                    </c:when>
                                    <c:when test="${requestScope.web.request==4}">
                                        <div class="star"></div><div class="star"></div><div class="star"></div><br/><div class="star"></div>
                                    </c:when>
                                    <c:otherwise>
                                        <div class="star"></div><div class="star"></div><div class="star"></div><br/><div class="star"></div><div class="star"></div>
                                    </c:otherwise>
                                </c:choose>
                            </div></td>
                            <td><div class="danteng"><div>难易程度</div>
                                <c:choose>
                                    <c:when test="${requestScope.web.difficulty==1}">
                                        <div class="star"></div>
                                    </c:when>
                                    <c:when test="${requestScope.web.difficulty==2}">
                                        <div class="star"></div><div class="star"></div>
                                    </c:when>
                                    <c:when test="${requestScope.web.difficulty==3}">
                                        <div class="star"></div><div class="star"></div><div class="star"></div>
                                    </c:when>
                                    <c:when test="${requestScope.web.difficulty==4}">
                                        <div class="star"></div><div class="star"></div><div class="star"></div><br/><div class="star"></div>
                                    </c:when>
                                    <c:otherwise>
                                        <div class="star"></div><div class="star"></div><div class="star"></div><br/><div class="star"></div><div class="star"></div>
                                    </c:otherwise>
                                </c:choose>
                            </div></td>
                        </tr>
                        <tr>
                            <td>成长周期<red>${requestScope.web.growthPeriod}</red></td>
                            <td>稀缺程度 <red>${requestScope.web.rareness}</red>家公司需要</td>
                        </tr>
                    </table>
                    <table>
                        <tr>
                            <td rowspan="3">薪资待遇</td>
                            <td>0-1年<div class="pay">${requestScope.web.firstSalary}/月</div></td>
                        </tr>
                        <tr>
                            <td>1-3年<div class="pay">${requestScope.web.thirdSalary}/月</div></td>
                        </tr>
                        <tr>
                            <td>4年<div class="pay">${requestScope.web.fourthSalary}/月</div></td>
                        </tr>
                        <tr><td colspan="2">有<red>${requestScope.webCount}人</red>正在学</td></tr>
                        <tr><td colspan="2">提示：在你学习之前你应该已经掌握${requestScope.web.requestSkills}等语言基础</td></tr>
                    </table>
                </div>

            </div>
            <div class="col-md-4 col-sm-6 col-lg-4 div1">
                <div class="table-size">
                    <table border="1">
                        <div class="divhover">
                            <div class="ios">${requestScope.css.name}</div>
                            初级切图仔</div>
                        <tr>
                            <td colspan="2">
                                <div class="table-head">
                                    <div class="web-img"></div>
                                    <div><h4>${requestScope.css.name}</h4><p class="table-p">${requestScope.css.intro}</p></div>
                                </div>
                            </td>
                        </tr>
                        <tr>
                            <td style="width: 50%;"><div class="danteng"><div class="star-left">门槛</div>
                                <%--使用choose,when和otherwise标签实现星星数目的选择输出--%>
                                <c:choose>
                                    <c:when test="${requestScope.css.request==1}">
                                        <div class="star"></div>
                                    </c:when>
                                    <c:when test="${requestScope.css.request==2}">
                                        <div class="star"></div><div class="star"></div>
                                    </c:when>
                                    <c:when test="${requestScope.css.request==3}">
                                        <div class="star"></div><div class="star"></div><div class="star"></div>
                                    </c:when>
                                    <c:when test="${requestScope.css.request==4}">
                                        <div class="star"></div><div class="star"></div><div class="star"></div><br/><div class="star"></div>
                                    </c:when>
                                    <c:otherwise>
                                        <div class="star"></div><div class="star"></div><div class="star"></div><br/><div class="star"></div><div class="star"></div>
                                    </c:otherwise>
                                </c:choose>
                            </div></td>
                            <td><div class="danteng"><div>难易程度</div>
                                <c:choose>
                                    <c:when test="${requestScope.css.difficulty==1}">
                                        <div class="star"></div>
                                    </c:when>
                                    <c:when test="${requestScope.css.difficulty==2}">
                                        <div class="star"></div><div class="star"></div>
                                    </c:when>
                                    <c:when test="${requestScope.css.difficulty==3}">
                                        <div class="star"></div><div class="star"></div><div class="star"></div>
                                    </c:when>
                                    <c:when test="${requestScope.css.difficulty==4}">
                                        <div class="star"></div><div class="star"></div><div class="star"></div><br/><div class="star"></div>
                                    </c:when>
                                    <c:otherwise>
                                        <div class="star"></div><div class="star"></div><div class="star"></div><br/><div class="star"></div><div class="star"></div>
                                    </c:otherwise>
                                </c:choose>
                            </div></td>
                        </tr>
                        <tr>
                            <td>成长周期<red>${requestScope.css.growthPeriod}</red></td>
                            <td>稀缺程度 <red>${requestScope.css.rareness}</red>家公司需要</td>
                        </tr>
                    </table>

                    <table>
                        <tr>
                            <td rowspan="3">薪资待遇</td>
                            <td>0-1年<div class="pay">${requestScope.css.firstSalary}/月</div></td>
                        </tr>
                        <tr>
                            <td>1-3年<div class="pay">${requestScope.css.thirdSalary}/月</div></td>
                        </tr>
                        <tr>
                            <td>4年<div class="pay">${requestScope.css.fourthSalary}/月</div></td>
                        </tr>
                        <tr><td colspan="2">有<red>${requestScope.cssCount}人</red>正在学</td></tr>
                        <tr><td colspan="2">提示：在你学习之前你应该已经掌握${requestScope.css.requestSkills}等语言基础</td></tr>
                    </table>
                </div>
            </div>
            <div class="col-md-4 col-sm-6 col-lg-4 div1">
                <div class="table-size">
                    <table border="1">
                        <div class="divhover">
                            <div class="ios">${requestScope.js.name}</div>
                            高级切图仔</div>
                        <tr>
                            <td colspan="2">
                                <div class="table-head">
                                    <div class="web-img"></div>
                                    <div><h4>${requestScope.js.name}</h4><p class="table-p">${requestScope.js.intro}</p></div>
                                </div>
                            </td>
                        </tr>
                        <tr>
                            <td style="width: 50%;"><div class="danteng"><div class="star-left">门槛</div>
                                <%--使用choose,when和otherwise标签实现星星数目的选择输出--%>
                                <c:choose>
                                    <c:when test="${requestScope.js.request==1}">
                                        <div class="star"></div>
                                    </c:when>
                                    <c:when test="${requestScope.js.request==2}">
                                        <div class="star"></div><div class="star"></div>
                                    </c:when>
                                    <c:when test="${requestScope.js.request==3}">
                                        <div class="star"></div><div class="star"></div><div class="star"></div>
                                    </c:when>
                                    <c:when test="${requestScope.js.request==4}">
                                        <div class="star"></div><div class="star"></div><div class="star"></div><br/><div class="star"></div>
                                    </c:when>
                                    <c:otherwise>
                                        <div class="star"></div><div class="star"></div><div class="star"></div><br/><div class="star"></div><div class="star"></div>
                                    </c:otherwise>
                                </c:choose>
                            </div></td>
                            <td><div class="danteng"><div>难易程度</div>
                                <c:choose>
                                    <c:when test="${requestScope.js.difficulty==1}">
                                        <div class="star"></div>
                                    </c:when>
                                    <c:when test="${requestScope.js.difficulty==2}">
                                        <div class="star"></div><div class="star"></div>
                                    </c:when>
                                    <c:when test="${requestScope.js.difficulty==3}">
                                        <div class="star"></div><div class="star"></div><div class="star"></div>
                                    </c:when>
                                    <c:when test="${requestScope.js.difficulty==4}">
                                        <div class="star"></div><div class="star"></div><div class="star"></div><br/><div class="star"></div>
                                    </c:when>
                                    <c:otherwise>
                                        <div class="star"></div><div class="star"></div><div class="star"></div><br/><div class="star"></div><div class="star"></div>
                                    </c:otherwise>
                                </c:choose>
                            </div></td>
                        </tr>
                        <tr>
                            <td>成长周期<red>${requestScope.js.growthPeriod}</red></td>
                            <td>稀缺程度 <red>${requestScope.js.rareness}</red>家公司需要</td>
                        </tr>
                    </table>

                    <table>
                        <tr>
                            <td rowspan="3">薪资待遇</td>
                            <td>0-1年<div class="pay">${requestScope.js.firstSalary}/月</div></td>
                        </tr>
                        <tr>
                            <td>1-3年<div class="pay">${requestScope.js.thirdSalary}/月</div></td>
                        </tr>
                        <tr>
                            <td>4年<div class="pay">${requestScope.js.fourthSalary}/月</div></td>
                        </tr>
                        <tr><td colspan="2">有<red>${requestScope.jsCount}人</red>正在学</td></tr>
                        <tr><td colspan="2">提示：在你学习之前你应该已经掌握${requestScope.js.requestSkills}等语言基础</td></tr>
                    </table>
                </div>

            </div>
        </div>
    </div>
    <!--后端-->
    <div class="row">
        <div class="col-md-12 col-lg-12">
            <a name="java"></a> <div class="qianduan-top"><strong>后端开发方向</strong></div>
        </div>
    </div>
    <!--后端1-->
    <div class="row size">
        <div>
            <div class="col-md-4 col-sm-6 col-lg-4 div1">
                <div class="table-size">
                    <table border="1">
                        <div class="divhover">
                            <div class="ios">${requestScope.java.name}</div>
                            大后期发育型英雄</div>
                        <tr>
                            <td colspan="2">
                                <div class="table-head">
                                    <div class="web-img"></div>
                                    <div><h4>${requestScope.java.name}</h4><p class="table-p">${requestScope.java.intro}</p></div>
                                </div>
                            </td>
                        </tr>
                        <tr>
                            <td style="width: 50%;"><div class="danteng"><div class="star-left">门槛</div>
                                <%--使用choose,when和otherwise标签实现星星数目的选择输出--%>
                                <c:choose>
                                    <c:when test="${requestScope.java.request==1}">
                                        <div class="star"></div>
                                    </c:when>
                                    <c:when test="${requestScope.java.request==2}">
                                        <div class="star"></div><div class="star"></div>
                                    </c:when>
                                    <c:when test="${requestScope.java.request==3}">
                                        <div class="star"></div><div class="star"></div><div class="star"></div>
                                    </c:when>
                                    <c:when test="${requestScope.java.request==4}">
                                        <div class="star"></div><div class="star"></div><div class="star"></div><br/><div class="star"></div>
                                    </c:when>
                                    <c:otherwise>
                                        <div class="star"></div><div class="star"></div><div class="star"></div><br/><div class="star"></div><div class="star"></div>
                                    </c:otherwise>
                                </c:choose>
                            </div></td>
                            <td><div class="danteng"><div>难易程度</div>
                                <c:choose>
                                    <c:when test="${requestScope.java.difficulty==1}">
                                        <div class="star"></div>
                                    </c:when>
                                    <c:when test="${requestScope.java.difficulty==2}">
                                        <div class="star"></div><div class="star"></div>
                                    </c:when>
                                    <c:when test="${requestScope.java.difficulty==3}">
                                        <div class="star"></div><div class="star"></div><div class="star"></div>
                                    </c:when>
                                    <c:when test="${requestScope.java.difficulty==4}">
                                        <div class="star"></div><div class="star"></div><div class="star"></div><br/><div class="star"></div>
                                    </c:when>
                                    <c:otherwise>
                                        <div class="star"></div><div class="star"></div><div class="star"></div><br/><div class="star"></div><div class="star"></div>
                                    </c:otherwise>
                                </c:choose>
                            </div></td>
                        </tr>
                        <tr>
                            <td>成长周期<red>${requestScope.java.growthPeriod}</red></td>
                            <td>稀缺程度 <red>${requestScope.java.rareness}</red>家公司需要</td>
                        </tr>
                    </table>

                    <table>
                        <tr>
                            <td rowspan="3">薪资待遇</td>
                            <td>0-1年<div class="pay">${requestScope.java.firstSalary}/月</div></td>
                        </tr>
                        <tr>
                            <td>1-3年<div class="pay">${requestScope.java.thirdSalary}/月</div></td>
                        </tr>
                        <tr>
                            <td>4年<div class="pay">${requestScope.java.fourthSalary}/月</div></td>
                        </tr>
                        <tr><td colspan="2">有<red>${requestScope.javaCount}人</red>正在学</td></tr>
                        <tr><td colspan="2">提示：在你学习之前你应该已经掌握${requestScope.java.requestSkills}等语言基础</td></tr>
                    </table>
                </div>

            </div>
            <div class="col-md-4 col-sm-6 col-lg-4 div1">
                <div class="table-size">
                    <table border="1">
                        <div class="divhover">
                            <div class="ios">${requestScope.python.name}</div>
                            后期发育型英雄</div>
                        <tr>
                            <td colspan="2">
                                <div class="table-head">
                                    <div class="web-img"></div>
                                    <div><h4>${requestScope.python.name}</h4><p class="table-p">${requestScope.python.intro}</p></div>
                                </div>
                            </td>
                        </tr>
                        <tr>
                            <td style="width: 50%;"><div class="danteng"><div class="star-left">门槛</div>
                                <%--使用choose,when和otherwise标签实现星星数目的选择输出--%>
                                <c:choose>
                                    <c:when test="${requestScope.python.request==1}">
                                        <div class="star"></div>
                                    </c:when>
                                    <c:when test="${requestScope.python.request==2}">
                                        <div class="star"></div><div class="star"></div>
                                    </c:when>
                                    <c:when test="${requestScope.python.request==3}">
                                        <div class="star"></div><div class="star"></div><div class="star"></div>
                                    </c:when>
                                    <c:when test="${requestScope.python.request==4}">
                                        <div class="star"></div><div class="star"></div><div class="star"></div><br/><div class="star"></div>
                                    </c:when>
                                    <c:otherwise>
                                        <div class="star"></div><div class="star"></div><div class="star"></div><br/><div class="star"></div><div class="star"></div>
                                    </c:otherwise>
                                </c:choose>
                            </div></td>
                            <td><div class="danteng"><div>难易程度</div>
                                <c:choose>
                                    <c:when test="${requestScope.python.difficulty==1}">
                                        <div class="star"></div>
                                    </c:when>
                                    <c:when test="${requestScope.python.difficulty==2}">
                                        <div class="star"></div><div class="star"></div>
                                    </c:when>
                                    <c:when test="${requestScope.python.difficulty==3}">
                                        <div class="star"></div><div class="star"></div><div class="star"></div>
                                    </c:when>
                                    <c:when test="${requestScope.python.difficulty==4}">
                                        <div class="star"></div><div class="star"></div><div class="star"></div><br/><div class="star"></div>
                                    </c:when>
                                    <c:otherwise>
                                        <div class="star"></div><div class="star"></div><div class="star"></div><br/><div class="star"></div><div class="star"></div>
                                    </c:otherwise>
                                </c:choose>
                            </div></td>
                        </tr>
                        <tr>
                        <td>成长周期<red>${requestScope.python.growthPeriod}</red></td>
                        <td>稀缺程度 <red>${requestScope.python.rareness}</red>家公司需要</td>
                    </tr>
                    </table>

                    <table>
                        <tr>
                            <td rowspan="3">薪资待遇</td>
                            <td>0-1年<div class="pay">${requestScope.python.firstSalary}/月</div></td>
                        </tr>
                        <tr>
                            <td>1-3年<div class="pay">${requestScope.python.thirdSalary}/月</div></td>
                        </tr>
                        <tr>
                            <td>4年<div class="pay">${requestScope.python.fourthSalary}/月</div></td>
                        </tr>
                        <tr><td colspan="2">有<red>${requestScope.pythonCount}人</red>正在学</td></tr>
                        <tr><td colspan="2">提示：在你学习之前你应该已经掌握${requestScope.python.requestSkills}等语言基础</td></tr>
                    </table>
                </div>
            </div>
            <div class="col-md-4 col-sm-6 col-lg-4 div1">
                <div class="table-size">
                    <table border="1">
                        <div class="divhover">
                            <div class="ios">${requestScope.pm.name}</div>
                            爱吹才会赢</div>
                        <tr>
                            <td colspan="2">
                                <div class="table-head">
                                    <div class="web-img"></div>
                                    <div><h4>${requestScope.pm.name}</h4><p class="table-p">${requestScope.pm.intro}</p></div>
                                </div>
                            </td>
                        </tr>
                        <tr>
                            <td style="width: 50%;"><div class="danteng"><div class="star-left">门槛</div>
                                <%--使用choose,when和otherwise标签实现星星数目的选择输出--%>
                                <c:choose>
                                    <c:when test="${requestScope.pm.request==1}">
                                        <div class="star"></div>
                                    </c:when>
                                    <c:when test="${requestScope.pm.request==2}">
                                        <div class="star"></div><div class="star"></div>
                                    </c:when>
                                    <c:when test="${requestScope.pm.request==3}">
                                        <div class="star"></div><div class="star"></div><div class="star"></div>
                                    </c:when>
                                    <c:when test="${requestScope.pm.request==4}">
                                        <div class="star"></div><div class="star"></div><div class="star"></div><br/><div class="star"></div>
                                    </c:when>
                                    <c:otherwise>
                                        <div class="star"></div><div class="star"></div><div class="star"></div><br/><div class="star"></div><div class="star"></div>
                                    </c:otherwise>
                                </c:choose>
                            </div></td>
                            <td><div class="danteng"><div>难易程度</div>
                                <c:choose>
                                    <c:when test="${requestScope.pm.difficulty==1}">
                                        <div class="star"></div>
                                    </c:when>
                                    <c:when test="${requestScope.pm.difficulty==2}">
                                        <div class="star"></div><div class="star"></div>
                                    </c:when>
                                    <c:when test="${requestScope.pm.difficulty==3}">
                                        <div class="star"></div><div class="star"></div><div class="star"></div>
                                    </c:when>
                                    <c:when test="${requestScope.pm.difficulty==4}">
                                        <div class="star"></div><div class="star"></div><div class="star"></div><br/><div class="star"></div>
                                    </c:when>
                                    <c:otherwise>
                                        <div class="star"></div><div class="star"></div><div class="star"></div><br/><div class="star"></div><div class="star"></div>
                                    </c:otherwise>
                                </c:choose>
                            </div></td>
                        </tr>
                        <tr>
                            <td>成长周期<red>${requestScope.pm.growthPeriod}</red></td>
                            <td>稀缺程度 <red>${requestScope.pm.rareness}</red>家公司需要</td>
                        </tr>
                    </table>
                    <table>
                        <tr>
                            <td rowspan="3">薪资待遇</td>
                            <td>0-1年<div class="pay">${requestScope.pm.firstSalary}/月</div></td>
                        </tr>
                        <tr>
                            <td>1-3年<div class="pay">${requestScope.pm.thirdSalary}/月</div></td>
                        </tr>
                        <tr>
                            <td>4年<div class="pay">${requestScope.pm.fourthSalary}/月</div></td>
                        </tr>
                        <tr><td colspan="2">有<red>${requestScope.pmCount}人</red>正在学</td></tr>
                        <tr><td colspan="2">提示：在你学习之前你应该已经掌握${requestScope.pm.requestSkills}等语言基础</td></tr>
                    </table>
                </div>

            </div>
        </div>
    </div>
    <div class="row size">
        <div>
            <div class="col-md-4 col-sm-6 col-lg-4 div1">
                <div class="table-size">
                    <table border="1">
                        <div class="divhover">
                            <div class="ios">${requestScope.ui.name}</div>
                            程序员版设计师</div>
                        <tr>
                            <td colspan="2">
                                <div class="table-head">
                                    <div class="web-img"></div>
                                    <div><h4>${requestScope.ui.name}</h4><p class="table-p">${requestScope.ui.intro}</p></div>
                                </div>
                            </td>
                        </tr>
                        <tr>
                            <td style="width: 50%;"><div class="danteng"><div class="star-left">门槛</div>
                                <%--使用choose,when和otherwise标签实现星星数目的选择输出--%>
                                <c:choose>
                                    <c:when test="${requestScope.ui.request==1}">
                                        <div class="star"></div>
                                    </c:when>
                                    <c:when test="${requestScope.ui.request==2}">
                                        <div class="star"></div><div class="star"></div>
                                    </c:when>
                                    <c:when test="${requestScope.ui.request==3}">
                                        <div class="star"></div><div class="star"></div><div class="star"></div>
                                    </c:when>
                                    <c:when test="${requestScope.ui.request==4}">
                                        <div class="star"></div><div class="star"></div><div class="star"></div><br/><div class="star"></div>
                                    </c:when>
                                    <c:otherwise>
                                        <div class="star"></div><div class="star"></div><div class="star"></div><br/><div class="star"></div><div class="star"></div>
                                    </c:otherwise>
                                </c:choose>
                            </div></td>
                            <td><div class="danteng"><div>难易程度</div>
                                <c:choose>
                                    <c:when test="${requestScope.ui.difficulty==1}">
                                        <div class="star"></div>
                                    </c:when>
                                    <c:when test="${requestScope.ui.difficulty==2}">
                                        <div class="star"></div><div class="star"></div>
                                    </c:when>
                                    <c:when test="${requestScope.ui.difficulty==3}">
                                        <div class="star"></div><div class="star"></div><div class="star"></div>
                                    </c:when>
                                    <c:when test="${requestScope.ui.difficulty==4}">
                                        <div class="star"></div><div class="star"></div><div class="star"></div><br/><div class="star"></div>
                                    </c:when>
                                    <c:otherwise>
                                        <div class="star"></div><div class="star"></div><div class="star"></div><br/><div class="star"></div><div class="star"></div>
                                    </c:otherwise>
                                </c:choose>
                            </div></td>
                        </tr>
                        <tr>
                            <td>成长周期<red>${requestScope.ui.growthPeriod}</red></td>
                            <td>稀缺程度 <red>${requestScope.ui.rareness}</red>家公司需要</td>
                        </tr>
                    </table>
                    <table>
                        <tr>
                            <td rowspan="3">薪资待遇</td>
                            <td>0-1年<div class="pay">${requestScope.ui.firstSalary}/月</div></td>
                        </tr>
                        <tr>
                            <td>1-3年<div class="pay">${requestScope.ui.thirdSalary}/月</div></td>
                        </tr>
                        <tr>
                            <td>4年<div class="pay">${requestScope.ui.fourthSalary}/月</div></td>
                        </tr>
                        <tr><td colspan="2">有<red>${requestScope.uiCount}人</red>正在学</td></tr>
                        <tr><td colspan="2">提示：在你学习之前你应该已经掌握${requestScope.ui.requestSkills}等语言基础</td></tr>
                    </table>
                </div>

            </div>
            <div class="col-md-4 col-sm-6 col-lg-4 div1">
                <div class="table-size">
                    <table border="1">
                        <div class="divhover">
                            <div class="ios">${requestScope.qa.name}</div>
                            运维，负责网站维护测试</div>
                        <tr>
                            <td colspan="2">
                                <div class="table-head">
                                    <div class="web-img"></div>
                                    <div><h4>${requestScope.qa.name}</h4><p class="table-p">${requestScope.qa.intro}</p></div>
                                </div>
                            </td>
                        </tr>
                        <tr>
                            <td style="width: 50%;"><div class="danteng"><div class="star-left">门槛</div>
                                <%--使用choose,when和otherwise标签实现星星数目的选择输出--%>
                                <c:choose>
                                    <c:when test="${requestScope.qa.request==1}">
                                        <div class="star"></div>
                                    </c:when>
                                    <c:when test="${requestScope.qa.request==2}">
                                        <div class="star"></div><div class="star"></div>
                                    </c:when>
                                    <c:when test="${requestScope.qa.request==3}">
                                        <div class="star"></div><div class="star"></div><div class="star"></div>
                                    </c:when>
                                    <c:when test="${requestScope.qa.request==4}">
                                        <div class="star"></div><div class="star"></div><div class="star"></div><br/><div class="star"></div>
                                    </c:when>
                                    <c:otherwise>
                                        <div class="star"></div><div class="star"></div><div class="star"></div><br/><div class="star"></div><div class="star"></div>
                                    </c:otherwise>
                                </c:choose>
                            </div></td>
                            <td><div class="danteng"><div>难易程度</div>
                                <c:choose>
                                    <c:when test="${requestScope.qa.difficulty==1}">
                                        <div class="star"></div>
                                    </c:when>
                                    <c:when test="${requestScope.qa.difficulty==2}">
                                        <div class="star"></div><div class="star"></div>
                                    </c:when>
                                    <c:when test="${requestScope.qa.difficulty==3}">
                                        <div class="star"></div><div class="star"></div><div class="star"></div>
                                    </c:when>
                                    <c:when test="${requestScope.qa.difficulty==4}">
                                        <div class="star"></div><div class="star"></div><div class="star"></div><br/><div class="star"></div>
                                    </c:when>
                                    <c:otherwise>
                                        <div class="star"></div><div class="star"></div><div class="star"></div><br/><div class="star"></div><div class="star"></div>
                                    </c:otherwise>
                                </c:choose>
                            </div></td>
                        </tr>
                        <tr>
                            <td>成长周期<red>${requestScope.qa.growthPeriod}</red></td>
                            <td>稀缺程度 <red>${requestScope.qa.rareness}</red>家公司需要</td>
                        </tr>
                    </table>
                    <table>
                        <tr>
                            <td rowspan="3">薪资待遇</td>
                            <td>0-1年<div class="pay">${requestScope.qa.firstSalary}/月</div></td>
                        </tr>
                        <tr>
                            <td>1-3年<div class="pay">${requestScope.qa.thirdSalary}/月</div></td>
                        </tr>
                        <tr>
                            <td>4年<div class="pay">${requestScope.qa.fourthSalary}/月</div></td>
                        </tr>
                        <tr><td colspan="2">有<red>${requestScope.qaCount}人</red>正在学</td></tr>
                        <tr><td colspan="2">提示：在你学习之前你应该已经掌握${requestScope.qa.requestSkills}等语言基础</td></tr>
                    </table>
                </div>
            </div>
        </div>
    </div>
    <!--运维-->
    <div class="row">
        <div class="col-md-12 col-lg-12">
            <a name="mobile"></a><div class="qianduan-top"><strong>移动开发</strong></div>
        </div>
    </div>
    <!--运维1-->
    <div class="row size">
        <div class="col-md-4 col-sm-6 col-lg-4 div1">
            <div class="table-size">
                <table border="1">
                    <div class="divhover">
                        <div class="ios">${requestScope.ios.name}</div>
                        ios是由苹果公司开发的移动操作系统，ios与苹果的Mac OS X操作系统一样，也是以Darwin为基础的，因此同样属于类Unix的商业操作系统。国内ios开发起步相对较晚，人才培养机制更是远远跟不上市场发展速度。有限的ios开发人才成了国内企业必争的资源。国内ios开发起步相对较晚，人才培养机制更是远远跟不上市场发展速度。有限的ios开发人才成了国内企业必争的资源。</div>
                    <tr>
                        <td colspan="2">
                            <div class="table-head">
                                <div class="web-img"></div>
                                <div><h4>${requestScope.ios.name}</h4><p class="table-p">${requestScope.ios.intro}</p></div>
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td style="width: 50%;"><div class="danteng"><div class="star-left">门槛</div>
                            <%--使用choose,when和otherwise标签实现星星数目的选择输出--%>
                            <c:choose>
                                <c:when test="${requestScope.ios.request==1}">
                                    <div class="star"></div>
                                </c:when>
                                <c:when test="${requestScope.ios.request==2}">
                                    <div class="star"></div><div class="star"></div>
                                </c:when>
                                <c:when test="${requestScope.ios.request==3}">
                                    <div class="star"></div><div class="star"></div><div class="star"></div>
                                </c:when>
                                <c:when test="${requestScope.ios.request==4}">
                                    <div class="star"></div><div class="star"></div><div class="star"></div><br/><div class="star"></div>
                                </c:when>
                                <c:otherwise>
                                    <div class="star"></div><div class="star"></div><div class="star"></div><br/><div class="star"></div><div class="star"></div>
                                </c:otherwise>
                            </c:choose>
                        </div></td>
                        <td><div class="danteng"><div>难易程度</div>
                            <c:choose>
                                <c:when test="${requestScope.ios.difficulty==1}">
                                    <div class="star"></div>
                                </c:when>
                                <c:when test="${requestScope.ios.difficulty==2}">
                                    <div class="star"></div><div class="star"></div>
                                </c:when>
                                <c:when test="${requestScope.ios.difficulty==3}">
                                    <div class="star"></div><div class="star"></div><div class="star"></div>
                                </c:when>
                                <c:when test="${requestScope.ios.difficulty==4}">
                                    <div class="star"></div><div class="star"></div><div class="star"></div><br/><div class="star"></div>
                                </c:when>
                                <c:otherwise>
                                    <div class="star"></div><div class="star"></div><div class="star"></div><br/><div class="star"></div><div class="star"></div>
                                </c:otherwise>
                            </c:choose>
                        </div></td>
                    </tr>
                    <tr>
                        <td>成长周期<red>${requestScope.ios.growthPeriod}</red></td>
                        <td>稀缺程度 <red>${requestScope.ios.rareness}</red>家公司需要</td>
                    </tr>
                </table>
                <table>
                    <tr>
                        <td rowspan="3">薪资待遇</td>
                        <td>0-1年<div class="pay">${requestScope.ios.firstSalary}/月</div></td>
                    </tr>
                    <tr>
                        <td>1-3年<div class="pay">${requestScope.ios.thirdSalary}/月</div></td>
                    </tr>
                    <tr>
                        <td>4年<div class="pay">${requestScope.ios.fourthSalary}/月</div></td>
                    </tr>
                    <tr><td colspan="2">有<red>${requestScope.iosCount}人</red>正在学</td></tr>
                    <tr><td colspan="2">提示：在你学习之前你应该已经掌握${requestScope.ios.requestSkills}等语言基础</td></tr>
                </table>
            </div>

        </div>
        <div class="col-md-4 col-sm-6 col-lg-4 div1">
            <div class="table-size">
                <table border="1">
                    <div class="divhover">
                        <div class="ios">${requestScope.android.name}</div>
                        微软指定，手机的明天</div>
                    <tr>
                        <td colspan="2">
                            <div class="table-head">
                                <div class="web-img"></div>
                                <div><h4>${requestScope.android.name}</h4><p class="table-p">${requestScope.android.intro}</p></div>
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td style="width: 50%;"><div class="danteng"><div class="star-left">门槛</div>
                            <%--使用choose,when和otherwise标签实现星星数目的选择输出--%>
                            <c:choose>
                                <c:when test="${requestScope.android.request==1}">
                                    <div class="star"></div>
                                </c:when>
                                <c:when test="${requestScope.android.request==2}">
                                    <div class="star"></div><div class="star"></div>
                                </c:when>
                                <c:when test="${requestScope.android.request==3}">
                                    <div class="star"></div><div class="star"></div><div class="star"></div>
                                </c:when>
                                <c:when test="${requestScope.android.request==4}">
                                    <div class="star"></div><div class="star"></div><div class="star"></div><br/><div class="star"></div>
                                </c:when>
                                <c:otherwise>
                                    <div class="star"></div><div class="star"></div><div class="star"></div><br/><div class="star"></div><div class="star"></div>
                                </c:otherwise>
                            </c:choose>
                        </div></td>
                        <td><div class="danteng"><div>难易程度</div>
                            <c:choose>
                                <c:when test="${requestScope.android.difficulty==1}">
                                    <div class="star"></div>
                                </c:when>
                                <c:when test="${requestScope.android.difficulty==2}">
                                    <div class="star"></div><div class="star"></div>
                                </c:when>
                                <c:when test="${requestScope.android.difficulty==3}">
                                    <div class="star"></div><div class="star"></div><div class="star"></div>
                                </c:when>
                                <c:when test="${requestScope.android.difficulty==4}">
                                    <div class="star"></div><div class="star"></div><div class="star"></div><br/><div class="star"></div>
                                </c:when>
                                <c:otherwise>
                                    <div class="star"></div><div class="star"></div><div class="star"></div><br/><div class="star"></div><div class="star"></div>
                                </c:otherwise>
                            </c:choose>
                        </div></td>
                    </tr>
                    <tr>
                        <td>成长周期<red>${requestScope.android.growthPeriod}</red></td>
                        <td>稀缺程度 <red>${requestScope.android.rareness}</red>家公司需要</td>
                    </tr>
                </table>
                <table>
                    <tr>
                        <td rowspan="3">薪资待遇</td>
                        <td>0-1年<div class="pay">${requestScope.android.firstSalary}/月</div></td>
                    </tr>
                    <tr>
                        <td>1-3年<div class="pay">${requestScope.android.firstSalary}/月</div></td>
                    </tr>
                    <tr>
                        <td>4年<div class="pay">${requestScope.android.thirdSalary}/月</div></td>
                    </tr>
                    <tr><td colspan="2">有<red>${requestScope.androidCount}人</red>正在学</td></tr>
                    <tr><td colspan="2">提示：在你学习之前你应该已经掌握${requestScope.android.requestSkills}等语言基础</td></tr>
                </table>
            </div>

        </div>
        <div class="col-md-4 col-sm-6 col-lg-4 div1">
            <div class="table-size">
                <table border="1">
                    <div class="divhover">
                        <div class="ios">ios工程师</div>
                        ios是由苹果公司开发的移动操作系统，ios与苹果的Mac OS X操作系统一样，也是以Darwin为基础的，因此同样属于类Unix的商业操作系统。国内ios开发起步相对较晚，人才培养机制更是远远跟不上市场发展速度。有限的ios开发人才成了国内企业必争的资源。国内ios开发起步相对较晚，人才培养机制更是远远跟不上市场发展速度。有限的ios开发人才成了国内企业必争的资源。</div>
                    <tr>
                        <td colspan="2">
                            <div class="table-head">
                                <div class="web-img"></div>
                                <div><h4>Web前端工程师</h4><p class="table-p">Web前端开发工程师，主要职责是利用(X)html/css/javascript/flash等各种Web技术进行产品的开发。</p></div>
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td style="width: 50%;"><div class="danteng"><div class="star-left">门槛</div>
                            <%--使用choose,when和otherwise标签实现星星数目的选择输出--%>
                            <c:choose>
                                <c:when test="${requestScope.ios.request==1}">
                                    <div class="star"></div>
                                </c:when>
                                <c:when test="${requestScope.ios.request==2}">
                                    <div class="star"></div><div class="star"></div>
                                </c:when>
                                <c:when test="${requestScope.ios.request==3}">
                                    <div class="star"></div><div class="star"></div><div class="star"></div>
                                </c:when>
                                <c:when test="${requestScope.ios.request==4}">
                                    <div class="star"></div><div class="star"></div><div class="star"></div><br/><div class="star"></div>
                                </c:when>
                                <c:otherwise>
                                    <div class="star"></div><div class="star"></div><div class="star"></div><br/><div class="star"></div><div class="star"></div>
                                </c:otherwise>
                            </c:choose>
                        </div></td>
                        <td><div class="danteng"><div>难易程度</div>
                            <c:choose>
                                <c:when test="${requestScope.ios.difficulty==1}">
                                    <div class="star"></div>
                                </c:when>
                                <c:when test="${requestScope.ios.difficulty==2}">
                                    <div class="star"></div><div class="star"></div>
                                </c:when>
                                <c:when test="${requestScope.ios.difficulty==3}">
                                    <div class="star"></div><div class="star"></div><div class="star"></div>
                                </c:when>
                                <c:when test="${requestScope.ios.difficulty==4}">
                                    <div class="star"></div><div class="star"></div><div class="star"></div><br/><div class="star"></div>
                                </c:when>
                                <c:otherwise>
                                    <div class="star"></div><div class="star"></div><div class="star"></div><br/><div class="star"></div><div class="star"></div>
                                </c:otherwise>
                            </c:choose>
                        </div></td>
                    </tr>
                    <tr>
                        <td>成长周期<red>${requestScope.ios.growthPeriod}</red></td>
                        <td>稀缺程度 <red>${requestScope.ios.rareness}</red>家公司需要</td>
                    </tr>
                </table>
                <table>
                    <tr>
                        <td rowspan="3">薪资待遇</td>
                        <td>0-1年<div class="pay">5k-10k/月</div></td>
                    </tr>
                    <tr>
                        <td>1-3年<div class="pay">10k-20k/月</div></td>
                    </tr>
                    <tr>
                        <td>4年<div class="pay">20k-25k/月</div></td>
                    </tr>
                    <tr><td colspan="2">有<red>286人</red>正在学</td></tr>
                    <tr><td colspan="2">提示：在你学习之前你应该已经掌握XXXX、xxxx、xxxx等语言基础</td></tr>
                </table>
            </div>

        </div>
    </div>
    <!--运维-->
    <div class="row">
        <div class="col-md-12 col-lg-12">
            <a name="site-development"></a> <div class="qianduan-top"><strong>整站开发</strong></div>
        </div>
    </div>
    <!--运维1-->
    <div class="row size">
        <div class="col-md-4 col-sm-6 col-lg-4 div1">
            <div class="table-size">
                <table border="1">
                    <div class="divhover">
                        <div class="ios">ios工程师</div>
                        ios是由苹果公司开发的移动操作系统，ios与苹果的Mac OS X操作系统一样，也是以Darwin为基础的，因此同样属于类Unix的商业操作系统。国内ios开发起步相对较晚，人才培养机制更是远远跟不上市场发展速度。有限的ios开发人才成了国内企业必争的资源。国内ios开发起步相对较晚，人才培养机制更是远远跟不上市场发展速度。有限的ios开发人才成了国内企业必争的资源。</div>
                    <tr>
                        <td colspan="2">
                            <div class="table-head">
                                <div class="web-img"></div>
                                <div><h4>Web前端工程师</h4><p class="table-p">Web前端开发工程师，主要职责是利用(X)html/css/javascript/flash等各种Web技术进行产品的开发。</p></div>
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td style="width: 50%;"><div class="danteng"><div class="star-left">门槛</div>
                            <%--使用choose,when和otherwise标签实现星星数目的选择输出--%>
                            <c:choose>
                                <c:when test="${requestScope.ios.request==1}">
                                    <div class="star"></div>
                                </c:when>
                                <c:when test="${requestScope.ios.request==2}">
                                    <div class="star"></div><div class="star"></div>
                                </c:when>
                                <c:when test="${requestScope.ios.request==3}">
                                    <div class="star"></div><div class="star"></div><div class="star"></div>
                                </c:when>
                                <c:when test="${requestScope.ios.request==4}">
                                    <div class="star"></div><div class="star"></div><div class="star"></div><br/><div class="star"></div>
                                </c:when>
                                <c:otherwise>
                                    <div class="star"></div><div class="star"></div><div class="star"></div><br/><div class="star"></div><div class="star"></div>
                                </c:otherwise>
                            </c:choose>
                        </div></td>
                        <td><div class="danteng"><div>难易程度</div>
                            <c:choose>
                                <c:when test="${requestScope.ios.difficulty==1}">
                                    <div class="star"></div>
                                </c:when>
                                <c:when test="${requestScope.ios.difficulty==2}">
                                    <div class="star"></div><div class="star"></div>
                                </c:when>
                                <c:when test="${requestScope.ios.difficulty==3}">
                                    <div class="star"></div><div class="star"></div><div class="star"></div>
                                </c:when>
                                <c:when test="${requestScope.ios.difficulty==4}">
                                    <div class="star"></div><div class="star"></div><div class="star"></div><br/><div class="star"></div>
                                </c:when>
                                <c:otherwise>
                                    <div class="star"></div><div class="star"></div><div class="star"></div><br/><div class="star"></div><div class="star"></div>
                                </c:otherwise>
                            </c:choose>
                        </div></td>
                    </tr>
                    <tr>
                        <td>成长周期<red>${requestScope.ios.growthPeriod}</red></td>
                        <td>稀缺程度 <red>${requestScope.ios.rareness}</red>家公司需要</td>
                    </tr>
                </table>
                <table>
                    <tr>
                        <td rowspan="3">薪资待遇</td>
                        <td>0-1年<div class="pay">5k-10k/月</div></td>
                    </tr>
                    <tr>
                        <td>1-3年<div class="pay">10k-20k/月</div></td>
                    </tr>
                    <tr>
                        <td>4年<div class="pay">20k-25k/月</div></td>
                    </tr>
                    <tr><td colspan="2">有<red>286人</red>正在学</td></tr>
                    <tr><td colspan="2">提示：在你学习之前你应该已经掌握XXXX、xxxx、xxxx等语言基础</td></tr>
                </table>
            </div>

        </div>
    </div>
</main>
</body>
</html>
