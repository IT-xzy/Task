<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isErrorPage="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <title>vote</title>
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="css/task8-3.css"/>
    <script src="https://cdn.bootcss.com/jquery/3.1.1/jquery.min.js"></script>
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

<main>
    <div class="slidebar">
    <div class="firstpage">首页>
        <span class="carrer">职业</span></div>
        <ol class="breadcrumb comb1">
            <li class="direction">方向:</li>
            <li><a >全部</a></li>
            <li><a >前端开发</a></li>
            <li><a >后端开发</a></li>
            <li><a >移动开发</a></li>
            <li><a >整站开发</a></li>
            <li><a >运营维护</a></li>
        </ol>
    </div>
    <div class="container">
    <div class="row row1">
        <div class="col-lg-12 headline">
            <p>前端开发方向</p>
        </div>
        <c:forEach items="${list1}" var="prof" varStatus="now" begin="0" end="2">
        <div class="col-lg-4 carrer1">

            <div class="headpic">
                <div class="item1"><img class="img-responsive" src="img/head22.png"></div>
                <div class="item2">
                    <h4>${prof.profName}</h4>
                    <p>${prof.profIntro}</p>
                </div>
            </div>
           <table class="table table-bordered table1">
            <tbody>
            <tr>
                <td class="grey">门槛
                    <c:forEach begin="1" end="${prof.profSill}">
                    <img src="img/star.png">
                    </c:forEach>
                </td>
                <td class="grey">难易程度
                    <c:forEach begin="1" end="${prof.profLevel}">
                    <img src="img/star.png">
                    </c:forEach>
                </td>
            </tr>
            <tr>
                <td class="grey">成长周期<span class="red">${prof.profCycle}</span></td>
                <td class="grey">稀缺程度<span class="red">${prof.profNeed}</span>家公司需要</td>
            </tr>
             <tr>
                 <th rowspan="3" class="salary">薪资待遇</th>
                 <td class="money"><span>0-1年</span><span>${prof.profTime1}</span></td>
             </tr>
            <tr>
                <td class="money3"><span>1-3年</span><span>${prof.profTime3}</span></td>
            </tr>
            <tr>
                <td class="money2"><span>3-5年</span><span>${prof.profTime5}</span></td>
            </tr>
            <tr>
                <th colspan="2">有<span class="red1">${prof.sum}</span>人在学</th>
            </tr>
            <tr>
                <th colspan="2" class="youneed"><p>提示:在你学习之前你应该已经掌握<a>${prof.profLanguage}</a>等语言基础</p></th>
            </tr>
            </tbody>
            </table>

            <div class="transparent">
                <p>${prof.profName}</p>
                <p>${prof.profIntro}</p>
            </div>

        </div>
        </c:forEach>

        <div class="col-lg-12 headline">
            后端开发方向
        </div>
        <c:forEach items="${list2}" var="prof" varStatus="now" begin="0" end="2">
            <div class="col-lg-4 carrer1">

                <div class="headpic">
                    <div class="item1"><img class="img-responsive" src="img/head22.png"></div>
                    <div class="item2">
                        <h4>${prof.profName}</h4>
                        <p>${prof.profIntro}</p>
                    </div>
                </div>
                <table class="table table-bordered table1">
                    <tbody>
                    <tr>
                        <td class="grey">门槛
                            <c:forEach begin="1" end="${prof.profSill}">
                                <img src="img/star.png">
                            </c:forEach>
                        </td>
                        <td class="grey">难易程度
                            <c:forEach begin="1" end="${prof.profLevel}">
                                <img src="img/star.png">
                            </c:forEach>
                        </td>
                    </tr>
                    <tr>
                        <td class="grey">成长周期<a class="red">${prof.profCycle}</a></td>
                        <td class="grey">稀缺程度<p class="red">${prof.profNeed}</p>家公司需要</td>
                    </tr>
                    <tr>
                        <th rowspan="3" class="salary">薪资待遇</th>
                        <td class="money"><span>0-1年</span><span>${prof.profTime1}</span></td>
                    </tr>
                    <tr>
                        <td class="money3"><span>1-3年</span><span>${prof.profTime3}</span></td>
                    </tr>
                    <tr>
                        <td class="money2"><span>3-5年</span><span>${prof.profTime5}</span></td>
                    </tr>
                    <tr>
                        <th colspan="2">有<span class="red1">${prof.sum}</span>人在学</th>
                    </tr>
                    <tr>
                        <th colspan="2" class="youneed"><p>提示:在你学习之前你应该已经掌握<a>${prof.profLanguage}</a>等语言基础</p></th>
                    </tr>
                    </tbody>
                </table>

                <div class="transparent">
                    <p>${prof.profName}</p>
                    <p>${prof.profIntro}</p>
                </div>

            </div>
        </c:forEach>
    </div>

    </div>
</main>

</body>
</html>