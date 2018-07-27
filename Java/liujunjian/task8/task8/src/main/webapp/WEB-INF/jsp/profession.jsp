<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="../css/profession.css">
    <title>Title</title>
</head>
<body>
<div class="occupation">
    <div class="container">
        <div class="row"><span class="bg-color-black"><a href="${pageContext.request.contextPath}/homePage">首页</a>&gt;职业</span></div>
        <div class="row">
            <span class="bg-color-gray">方向:<a href="#first" style="margin-left:15px">全部</a><a href="#first">前端开发</a><a
                    href="#second">后端开发</a><a href="#third">用户体验</a><a href="#forth">运营维护</a></span>
        </div>
    </div>
</div>
<main>
    <div class="container">
        <div class="row nav-strong">
            <a name="first"><strong>前端开发方向</strong></a>
            <div class="col-xs-12 col-sm-6 col-md-4">
                <div class="warp">
                    <table border="1" class="text">
                        <tr>
                            <th><img src="../images/img022.png" alt="" class="avast"></th>
                            <td>
                                <strong>${css.profession}</strong>
                                <p>${css.introduction}</p>
                            </td>
                        </tr>
                        <tr>
                            <td>门槛${css.threshold}</td>
                            <td>难易程度${css.difficulty}</td>
                        </tr>
                        <tr>
                            <td>成长周期 <em>${css.growth_cycle}</em>年</td>
                            <td>稀缺程度 <em>${css.company_number}</em>家公司需要</td>
                        </tr>
                        <tr>
                            <td>薪资待遇</td>
                            <td>
                                ${css.salary}
                            </td>
                        </tr>
                        <tr>
                            <td colspan="2">有<em>${css.stu_number}</em>人正在学</td>
                        </tr>
                        <tr>
                            <td colspan="2">基础需求:${css.basics}</td>
                        </tr>
                    </table>
                    <div class="zezhao"><strong>iOS工程师</strong>iOS是由苹果公司开发的移动操作统，iOS与苹果的Mac OS
                        X操作系统一样，也是以Darwin为基础的，因此同样属于类Unix的商业操作系统。国内iOS开发起步相对较晚，人才培养机制更是远远跟不上市场发展速度。有限的iOS开发人才成了国内企业必争的资源。国内
                        iOS开发起步相对较晚，人才培养机制更是远远跟不上市场发展速度。有限的iOS开发人才成了国内企业必争的资源。
                    </div>
                </div>
            </div>
            <div class="col-xs-12 col-sm-6 col-md-4">
                <div class="warp">
                    <table border="1" class="text">
                        <tr>
                            <th><img src="../images/img022.png" alt="" class="avast"></th>
                            <td>
                                <strong>${js.profession}</strong>
                                <p>${js.introduction}</p>
                            </td>
                        </tr>
                        <tr>
                            <td>门槛${js.threshold}</td>
                            <td>难易程度${js.difficulty}</td>
                        </tr>
                        <tr>
                            <td>成长周期 <em>${js.growth_cycle}</em>年</td>
                            <td>稀缺程度 <em>${js.company_number}</em>家公司需要</td>
                        </tr>
                        <tr>
                            <td>薪资待遇</td>
                            <td>
                                ${js.salary}
                            </td>
                        </tr>
                        <tr>
                            <td colspan="2">有<em>${js.stu_number}</em>人正在学</td>
                        </tr>
                        <tr>
                            <td colspan="2">基础需求:${js.basics}</td>
                        </tr>
                    </table>
                    <div class="zezhao"><strong>iOS工程师</strong>iOS是由苹果公司开发的移动操作统，iOS与苹果的Mac OS
                        X操作系统一样，也是以Darwin为基础的，因此同样属于类Unix的商业操作系统。国内iOS开发起步相对较晚，人才培养机制更是远远跟不上市场发展速度。有限的iOS开发人才成了国内企业必争的资源。国内
                        iOS开发起步相对较晚，人才培养机制更是远远跟不上市场发展速度。有限的iOS开发人才成了国内企业必争的资源。
                    </div>
                </div>
            </div>
            <div class="col-xs-12 col-sm-6 col-md-4">
                <div class="warp">
                    <table border="1" class="text">
                        <tr>
                            <th><img src="../images/img022.png" alt="" class="avast"></th>
                            <td>
                                <strong>${Android.profession}</strong>
                                <p>${Android.introduction}</p>
                            </td>
                        </tr>
                        <tr>
                            <td>门槛${Android.threshold}</td>
                            <td>难易程度${Android.difficulty}</td>
                        </tr>
                        <tr>
                            <td>成长周期 <em>${Android.growth_cycle}</em>年</td>
                            <td>稀缺程度 <em>${Android.company_number}</em>家公司需要</td>
                        </tr>
                        <tr>
                            <td>薪资待遇</td>
                            <td>
                                ${Android.salary}
                            </td>
                        </tr>
                        <tr>
                            <td colspan="2">有<em>${Android.stu_number}</em>人正在学</td>
                        </tr>
                        <tr>
                            <td colspan="2">基础需求:${Android.basics}</td>
                        </tr>
                    </table>
                    <div class="zezhao"><strong>iOS工程师</strong>iOS是由苹果公司开发的移动操作统，iOS与苹果的Mac OS
                        X操作系统一样，也是以Darwin为基础的，因此同样属于类Unix的商业操作系统。国内iOS开发起步相对较晚，人才培养机制更是远远跟不上市场发展速度。有限的iOS开发人才成了国内企业必争的资源。国内
                        iOS开发起步相对较晚，人才培养机制更是远远跟不上市场发展速度。有限的iOS开发人才成了国内企业必争的资源。
                    </div>
                </div>
            </div>
            <div class="col-xs-12 col-sm-6 col-md-4">
                <div class="warp">
                    <table border="1" class="text">
                        <tr>
                            <th><img src="../images/img022.png" alt="" class="avast"></th>
                            <td>
                                <strong>${ios.profession}</strong>
                                <p>${ios.introduction}</p>
                            </td>
                        </tr>
                        <tr>
                            <td>门槛${ios.threshold}</td>
                            <td>难易程度${ios.difficulty}</td>
                        </tr>
                        <tr>
                            <td>成长周期 <em>${ios.growth_cycle}</em>年</td>
                            <td>稀缺程度 <em>${ios.company_number}</em>家公司需要</td>
                        </tr>
                        <tr>
                            <td>薪资待遇</td>
                            <td>
                                ${ios.salary}
                            </td>
                        </tr>
                        <tr>
                            <td colspan="2">有<em>${ios.stu_number}</em>人正在学</td>
                        </tr>
                        <tr>
                            <td colspan="2">基础需求:${ios.basics}</td>
                        </tr>
                    </table>
                    <div class="zezhao"><strong>iOS工程师</strong>iOS是由苹果公司开发的移动操作统，iOS与苹果的Mac OS
                        X操作系统一样，也是以Darwin为基础的，因此同样属于类Unix的商业操作系统。国内iOS开发起步相对较晚，人才培养机制更是远远跟不上市场发展速度。有限的iOS开发人才成了国内企业必争的资源。国内
                        iOS开发起步相对较晚，人才培养机制更是远远跟不上市场发展速度。有限的iOS开发人才成了国内企业必争的资源。
                    </div>
                </div>
            </div>
        </div> <!-- main-row -->
    </div> <!-- container -->
    <div class="container">
        <div class="row nav-strong">
            <a name="second"><strong>后端开发方向</strong></a>
            <div class="col-xs-12 col-sm-6 col-md-4">
                <div class="warp">
                    <table border="1" class="text">
                        <tr>
                            <th><img src="../images/img022.png" alt="" class="avast"></th>
                            <td>
                                <strong>${java.profession}</strong>
                                <p>${java.introduction}</p>
                            </td>
                        </tr>
                        <tr>
                            <td>门槛${java.threshold}</td>
                            <td>难易程度${java.difficulty}</td>
                        </tr>
                        <tr>
                            <td>成长周期 <em>${java.growth_cycle}</em>年</td>
                            <td>稀缺程度 <em>${java.company_number}</em>家公司需要</td>
                        </tr>
                        <tr>
                            <td>薪资待遇</td>
                            <td>
                                ${java.salary}
                            </td>
                        </tr>
                        <tr>
                            <td colspan="2">有<em>${java.stu_number}</em>人正在学</td>
                        </tr>
                        <tr>
                            <td colspan="2">基础需求:${java.basics}</td>
                        </tr>
                    </table>
                    <div class="zezhao"><strong>iOS工程师</strong>iOS是由苹果公司开发的移动操作统，iOS与苹果的Mac OS
                        X操作系统一样，也是以Darwin为基础的，因此同样属于类Unix的商业操作系统。国内iOS开发起步相对较晚，人才培养机制更是远远跟不上市场发展速度。有限的iOS开发人才成了国内企业必争的资源。国内
                        iOS开发起步相对较晚，人才培养机制更是远远跟不上市场发展速度。有限的iOS开发人才成了国内企业必争的资源。
                    </div>
                </div>
            </div>
            <div class="col-xs-12 col-sm-6 col-md-4">
                <div class="warp">
                    <table border="1" class="text">
                        <tr>
                            <th><img src="../images/img022.png" alt="" class="avast"></th>
                            <td>
                                <strong>${python.profession}</strong>
                                <p>${python.introduction}</p>
                            </td>
                        </tr>
                        <tr>
                            <td>门槛${python.threshold}</td>
                            <td>难易程度${python.difficulty}</td>
                        </tr>
                        <tr>
                            <td>成长周期 <em>${python.growth_cycle}</em>年</td>
                            <td>稀缺程度 <em>${python.company_number}</em>家公司需要</td>
                        </tr>
                        <tr>
                            <td>薪资待遇</td>
                            <td>
                                ${python.salary}
                            </td>
                        </tr>
                        <tr>
                            <td colspan="2">有<em>${python.stu_number}</em>人正在学</td>
                        </tr>
                        <tr>
                            <td colspan="2">基础需求:${python.basics}</td>
                        </tr>
                    </table>
                    <div class="zezhao"><strong>iOS工程师</strong>iOS是由苹果公司开发的移动操作统，iOS与苹果的Mac OS
                        X操作系统一样，也是以Darwin为基础的，因此同样属于类Unix的商业操作系统。国内iOS开发起步相对较晚，人才培养机制更是远远跟不上市场发展速度。有限的iOS开发人才成了国内企业必争的资源。国内
                        iOS开发起步相对较晚，人才培养机制更是远远跟不上市场发展速度。有限的iOS开发人才成了国内企业必争的资源。
                    </div>
                </div>
            </div>
        </div> <!-- main-row -->
    </div> <!-- container -->
    <div class="container">
        <div class="row nav-strong">
            <a name="third"><strong>用户体验</strong></a>
            <div class="col-xs-12 col-sm-6 col-md-4">
                <div class="warp">
                    <table border="1" class="text">
                        <tr>
                            <th><img src="../images/img022.png" alt="" class="avast"></th>
                            <td>
                                <strong>${pm.profession}</strong>
                                <p>${pm.introduction}</p>
                            </td>
                        </tr>
                        <tr>
                            <td>门槛${pm.threshold}</td>
                            <td>难易程度${pm.difficulty}</td>
                        </tr>
                        <tr>
                            <td>成长周期 <em>${pm.growth_cycle}</em>年</td>
                            <td>稀缺程度 <em>${pm.company_number}</em>家公司需要</td>
                        </tr>
                        <tr>
                            <td>薪资待遇</td>
                            <td>
                                ${pm.salary}
                            </td>
                        </tr>
                        <tr>
                            <td colspan="2">有<em>${pm.stu_number}</em>人正在学</td>
                        </tr>
                        <tr>
                            <td colspan="2">基础需求:${pm.basics}</td>
                        </tr>
                    </table>
                    <div class="zezhao"><strong>iOS工程师</strong>iOS是由苹果公司开发的移动操作统，iOS与苹果的Mac OS
                        X操作系统一样，也是以Darwin为基础的，因此同样属于类Unix的商业操作系统。国内iOS开发起步相对较晚，人才培养机制更是远远跟不上市场发展速度。有限的iOS开发人才成了国内企业必争的资源。国内
                        iOS开发起步相对较晚，人才培养机制更是远远跟不上市场发展速度。有限的iOS开发人才成了国内企业必争的资源。
                    </div>
                </div>
            </div>
            <div class="col-xs-12 col-sm-6 col-md-4">
                <div class="warp">
                    <table border="1" class="text">
                        <tr>
                            <th><img src="../images/img022.png" alt="" class="avast"></th>
                            <td>
                                <strong>${ui.profession}</strong>
                                <p>${ui.introduction}</p>
                            </td>
                        </tr>
                        <tr>
                            <td>门槛${ui.threshold}</td>
                            <td>难易程度${ui.difficulty}</td>
                        </tr>
                        <tr>
                            <td>成长周期 <em>${ui.growth_cycle}</em>年</td>
                            <td>稀缺程度 <em>${ui.company_number}</em>家公司需要</td>
                        </tr>
                        <tr>
                            <td>薪资待遇</td>
                            <td>
                                ${ui.salary}
                            </td>
                        </tr>
                        <tr>
                            <td colspan="2">有<em>${ui.stu_number}</em>人正在学</td>
                        </tr>
                        <tr>
                            <td colspan="2">基础需求:${ui.basics}</td>
                        </tr>
                    </table>
                    <div class="zezhao"><strong>iOS工程师</strong>iOS是由苹果公司开发的移动操作统，iOS与苹果的Mac OS
                        X操作系统一样，也是以Darwin为基础的，因此同样属于类Unix的商业操作系统。国内iOS开发起步相对较晚，人才培养机制更是远远跟不上市场发展速度。有限的iOS开发人才成了国内企业必争的资源。国内
                        iOS开发起步相对较晚，人才培养机制更是远远跟不上市场发展速度。有限的iOS开发人才成了国内企业必争的资源。
                    </div>
                </div>
            </div>
            <div class="col-xs-12 col-sm-6 col-md-4">
                <div class="warp">
                    <table border="1" class="text">
                        <tr>
                            <th><img src="../images/img022.png" alt="" class="avast"></th>
                            <td>
                                <strong>${qa.profession}</strong>
                                <p>${qa.introduction}</p>
                            </td>
                        </tr>
                        <tr>
                            <td>门槛${qa.threshold}</td>
                            <td>难易程度${qa.difficulty}</td>
                        </tr>
                        <tr>
                            <td>成长周期 <em>${qa.growth_cycle}</em>年</td>
                            <td>稀缺程度 <em>${qa.company_number}</em>家公司需要</td>
                        </tr>
                        <tr>
                            <td>薪资待遇</td>
                            <td>
                                ${qa.salary}
                            </td>
                        </tr>
                        <tr>
                            <td colspan="2">有<em>${qa.stu_number}</em>人正在学</td>
                        </tr>
                        <tr>
                            <td colspan="2">基础需求:${qa.basics}</td>
                        </tr>
                    </table>
                    <div class="zezhao"><strong>iOS工程师</strong>iOS是由苹果公司开发的移动操作统，iOS与苹果的Mac OS
                        X操作系统一样，也是以Darwin为基础的，因此同样属于类Unix的商业操作系统。国内iOS开发起步相对较晚，人才培养机制更是远远跟不上市场发展速度。有限的iOS开发人才成了国内企业必争的资源。国内
                        iOS开发起步相对较晚，人才培养机制更是远远跟不上市场发展速度。有限的iOS开发人才成了国内企业必争的资源。
                    </div>
                </div>
            </div>
        </div> <!-- main-row -->
    </div> <!-- container -->
    <div class="container">
        <div class="row nav-strong">
            <a name="forth"><strong>运维方向</strong></a>
            <div class="col-xs-12 col-sm-6 col-md-4">
                <div class="warp">
                    <table border="1" class="text">
                        <tr>
                            <th><img src="../images/img022.png" alt="" class="avast"></th>
                            <td>
                                <strong>${operator.profession}</strong>
                                <p>${operator.introduction}</p>
                            </td>
                        </tr>
                        <tr>
                            <td>门槛${operator.threshold}</td>
                            <td>难易程度${operator.difficulty}</td>
                        </tr>
                        <tr>
                            <td>成长周期 <em>${operator.growth_cycle}</em>年</td>
                            <td>稀缺程度 <em>${operator.company_number}</em>家公司需要</td>
                        </tr>
                        <tr>
                            <td>薪资待遇</td>
                            <td>
                                ${operator.salary}
                            </td>
                        </tr>
                        <tr>
                            <td colspan="2">有<em>${operator.stu_number}</em>人正在学</td>
                        </tr>
                        <tr>
                            <td colspan="2">基础需求:${operator.basics}</td>
                        </tr>
                    </table>
                    <div class="zezhao"><strong>iOS工程师</strong>iOS是由苹果公司开发的移动操作统，iOS与苹果的Mac OS
                        X操作系统一样，也是以Darwin为基础的，因此同样属于类Unix的商业操作系统。国内iOS开发起步相对较晚，人才培养机制更是远远跟不上市场发展速度。有限的iOS开发人才成了国内企业必争的资源。国内
                        iOS开发起步相对较晚，人才培养机制更是远远跟不上市场发展速度。有限的iOS开发人才成了国内企业必争的资源。
                    </div>
                </div>
            </div>
        </div> <!-- main-row -->
    </div> <!-- container -->
</main>
</body>
</html>
