<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 8/8/2017
  Time: 上午 9:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" import="java.util.*" language="java" %>

<%@ taglib uri="/WEB-INF/tld/datetag.tld" prefix="date"%>

<html>


<head>
    <meta charset="utf-8">
    <title>首页</title>
</head>
<body>
    <tiles:insertDefinition name="task4-head" />
    <tiles:insertDefinition name="task4-left" />

    <%--<link href="/statics/css/task10/left.css" rel="stylesheet" type="text/css">--%>


    <%--<div class="quick-siderbar ng-scope" ng-if="$state.is('skill.home')">--%>
        <%--<div class="quick-logo">--%>
            <%--<div class="quick-bar quick-bar-left">--%>
                <%--<span></span>--%>
                <%--<i></i>--%>
            <%--</div>--%>
            <%--<div class="quick-bar quick-bar-right">--%>
                <%--<span></span>--%>
                <%--<i></i>--%>
            <%--</div>--%>
        <%--</div>--%>
        <%--<div class="quick-entry">--%>
            <%--<ul>--%>
                <%--<!-- ngRepeat: li in vm.contentSidebar --><li ng-repeat="li in vm.contentSidebar" class="ng-scope"><i class="fa fa-university" ng-class="li.author"></i><a href="/daily/11199" class="ng-binding">北京报名</a>--%>
                <%--<><!-- end ngRepeat: li in vm.contentSidebar --><li ng-repeat="li in vm.contentSidebar" class="ng-scope"><i class="fa fa-university" ng-class="li.author"></i><a href="/daily/11204" class="ng-binding">武汉报名</a>--%>
                <%--<><!-- end ngRepeat: li in vm.contentSidebar --><li ng-repeat="li in vm.contentSidebar" class="ng-scope"><i class="fa fa-university" ng-class="li.author"></i><a href="/daily/11203" class="ng-binding">成都报名</a>--%>
                <%--<><!-- end ngRepeat: li in vm.contentSidebar --><li ng-repeat="li in vm.contentSidebar" class="ng-scope"><i class="fa fa-university" ng-class="li.author"></i><a href="/daily/11200" class="ng-binding">郑州报名</a>--%>
                <%--<><!-- end ngRepeat: li in vm.contentSidebar --><li ng-repeat="li in vm.contentSidebar" class="ng-scope"><i class="fa fa-university" ng-class="li.author"></i><a href="/daily/16651" class="ng-binding">深圳报名</a>--%>
                <%--<><!-- end ngRepeat: li in vm.contentSidebar --><li ng-repeat="li in vm.contentSidebar" class="ng-scope"><i class="fa fa-university" ng-class="li.author"></i><a href="/daily/26096" class="ng-binding">上海报名</a>--%>
                <%--<><!-- end ngRepeat: li in vm.contentSidebar --><li ng-repeat="li in vm.contentSidebar" class="ng-scope"><i class="fa fa-diamond" ng-class="li.author"></i><a href="/daily/13669" class="ng-binding">活动集锦</a>--%>
                <%--<><!-- end ngRepeat: li in vm.contentSidebar --><li ng-repeat="li in vm.contentSidebar" class="ng-scope"><i class="fa fa-bullhorn" ng-class="li.author"></i><a href="/daily/11081" class="ng-binding">在线辅导</a>--%>
                <%--<><!-- end ngRepeat: li in vm.contentSidebar --><li ng-repeat="li in vm.contentSidebar" class="ng-scope"><i class="fa fa-windows" ng-class="li.author"></i><a href="/daily/9644" class="ng-binding">电脑租贷</a>--%>
                <%--<><!-- end ngRepeat: li in vm.contentSidebar -->--%>
            <%--</ul>--%>
        <%--</div>--%>
        <%--<div class="left-bar-btn">--%>
            <%--<img src="../images/right-bar_07.png">--%>
            <%--<span>技能树</span>--%>
            <%--<img src="../images/right-bar_15.png">--%>
        <%--</div>--%>

    <%--</div>--%>



    <tiles:insertDefinition name="task4-footer" />
</body>

<date:date  name="入学时间" value ="${122332123}"  />
</html>
