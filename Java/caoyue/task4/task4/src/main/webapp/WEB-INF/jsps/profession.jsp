<%--
  Created by IntelliJ IDEA.
  User: caoyue
  Date: 2018/4/23
  Time: 下午7:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib uri="/tags" prefix="date"%>
<html>
<%--<date:date value ="${item.createdTime} "/>--%>
<head>
    <link rel="stylesheet" href="../css/profession.css">
    <title>Title</title>
</head>
<body>
<div class="occupation">
    <div class="container">
        <div class="row"><span class="bg-color-black">首页&gt;<a href="">职业</a></span></div>
        <div class="row">
            <span class="bg-color-gray">方向:<a href="" style="margin-left:15px">全部</a><a href="">前端开发</a><a href="">后端开发</a><a href="">移动开发</a><a href="">整站开发</a><a href="">运营维护</a></span>
        </div>
    </div>
</div>
<main>
    <div class="container">
        <div class="row nav-strong">
            <strong>前端开发方向</strong>
            <c:forEach items="${fronts}" var="student" >
                <div class="col-xs-12 col-sm-6 col-md-4">
                <div class="warp">
                <table border="1" class="text">
                <tr>
                <th><img src="${student.picture}" alt="" class="avast"></th>
                <td>
                <strong>${student.type}</strong>
                <p>${student.introduce}</p>
                </td>
                </tr>
                <tr>
                <td>门槛<img src="images/star.png" alt=""></td>
                <td>难易程度<img src="images/star.png" alt=""><img src="images/star.png" alt=""></td>
                </tr>
                <tr>
                <td>成长周期 <em>${student.cycle}</em>年</td>
                <td>稀缺程度 <em>${student.need}</em>家公司需要</td>
                </tr>
                <tr>
                <td>薪资待遇</td>
                <td>
                <div>0-1年<span>${student.wagef}/月</span></div>
                <div>1-3年<span>${student.wages}/月</span></div>
                <div>3-5年<span>${student.waget}/月</span></div>
                </td>
                </tr>
                <tr>
                <td colspan="2">有<em>${student.study}</em>人正在学</td>
                </tr>
                <tr>
                <td colspan="2">提示:${student.reminder}</td>
                </tr>
                </table>
                <div class="zezhao"><strong>${student.proname}</strong>
                        ${student.prointroduce}</div>
                </div>
                </div>
            </c:forEach>
        </div> <!-- main-row -->
    </div> <!-- container -->
    <div class="container">
        <div class="row nav-strong">
            <strong>后端开发方向</strong>
            <c:forEach items="${afters}" var="student" >
                <div class="col-xs-12 col-sm-6 col-md-4">
                    <div class="warp">
                        <table border="1" class="text">
                            <tr>
                                <th><img src="${student.picture}" alt="" class="avast"></th>
                                <td>
                                    <strong>${student.type}</strong>
                                    <p>${student.introduce}</p>
                                </td>
                            </tr>
                            <tr>
                                <td>门槛<img src="images/star.png" alt=""></td>
                                <td>难易程度<img src="images/star.png" alt=""><img src="images/star.png" alt=""></td>
                            </tr>
                            <tr>
                                <td>成长周期 <em>${student.cycle}</em>年</td>
                                <td>稀缺程度 <em>${student.need}</em>家公司需要</td>
                            </tr>
                            <tr>
                                <td>薪资待遇</td>
                                <td>
                                    <div>0-1年<span>${student.wagef}/月</span></div>
                                    <div>1-3年<span>${student.wages}/月</span></div>
                                    <div>3-5年<span>${student.waget}/月</span></div>
                                </td>
                            </tr>
                            <tr>
                                <td colspan="2">有<em>${student.study}</em>人正在学</td>
                            </tr>
                            <tr>
                                <td colspan="2">提示:${student.reminder}</td>
                            </tr>
                        </table>
                        <div class="zezhao"><strong>${student.proname}</strong>
                        ${student.prointroduce}</div>
                    </div>
                </div>
            </c:forEach>
        </div> <!-- main-row -->
    </div> <!-- container -->
    <div class="container">
        <div class="row nav-strong">
            <strong>运维方向</strong>
            <c:forEach items="${ops}" var="student" >
                <div class="col-xs-12 col-sm-6 col-md-4">
                    <div class="warp">
                        <table border="1" class="text">
                            <tr>
                                <th><img src="${student.picture}" alt="" class="avast"></th>
                                <td>
                                    <strong>${student.type}</strong>
                                    <p>${student.introduce}</p>
                                </td>
                            </tr>
                            <tr>
                                <td>门槛<img src="images/star.png" alt=""></td>
                                <td>难易程度<img src="images/star.png" alt=""><img src="images/star.png" alt=""></td>
                            </tr>
                            <tr>
                                <td>成长周期 <em>${student.cycle}</em>年</td>
                                <td>稀缺程度 <em>${student.need}</em>家公司需要</td>
                            </tr>
                            <tr>
                                <td>薪资待遇</td>
                                <td>
                                    <div>0-1年<span>${student.wagef}/月</span></div>
                                    <div>1-3年<span>${student.wages}/月</span></div>
                                    <div>3-5年<span>${student.waget}/月</span></div>
                                </td>
                            </tr>
                            <tr>
                                <td colspan="2">有<em>${student.study}</em>人正在学</td>
                            </tr>
                            <tr>
                                <td colspan="2">提示:${student.reminder}</td>
                            </tr>
                        </table>
                        <div class="zezhao"><strong>${student.proname}</strong>
                        ${student.prointroduce}</div>
                    </div>
                </div>
            </c:forEach>
        </div> <!-- main-row -->
    </div> <!-- container -->
    <div class="container">
        <div class="row nav-strong">
            <strong>产品方向</strong>
            <c:forEach items="${pms}" var="student" >
                <div class="col-xs-12 col-sm-6 col-md-4">
                    <div class="warp">
                        <table border="1" class="text">
                            <tr>
                                <th><img src="${student.picture}" alt="" class="avast"></th>
                                <td>
                                    <strong>${student.type}</strong>
                                    <p>${student.introduce}</p>
                                </td>
                            </tr>
                            <tr>
                                <td>门槛<img src="images/star.png" alt=""></td>
                                <td>难易程度<img src="images/star.png" alt=""><img src="images/star.png" alt=""></td>
                            </tr>
                            <tr>
                                <td>成长周期 <em>${student.cycle}</em>年</td>
                                <td>稀缺程度 <em>${student.need}</em>家公司需要</td>
                            </tr>
                            <tr>
                                <td>薪资待遇</td>
                                <td>
                                    <div>0-1年<span>${student.wagef}/月</span></div>
                                    <div>1-3年<span>${student.wages}/月</span></div>
                                    <div>3-5年<span>${student.waget}/月</span></div>
                                </td>
                            </tr>
                            <tr>
                                <td colspan="2">有<em>${student.study}</em>人正在学</td>
                            </tr>
                            <tr>
                                <td colspan="2">提示:${student.reminder}</td>
                            </tr>
                        </table>
                        <div class="zezhao"><strong>${student.proname}</strong>
                        ${student.prointroduce}</div>
                    </div>
                </div>
            </c:forEach>
        </div> <!-- main-row -->
    </div> <!-- container -->
</main>
</body>
</html>
