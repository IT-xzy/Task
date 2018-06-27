<%@ page language="java" contentType="text/html; charset=UTF-8"

         pageEncoding="UTF-8" import="java.util.*" isELIgnored="false"  %>
<%@ taglib uri="/tags" prefix="date"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--<!DOCTYPE html>--%>
<html>
<head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>技能树首页</title>
    <link rel="stylesheet/less" type="text/css" href="../../less/task15.less">
    <script src="../../less.js-2.5.3/dist/less.min.js" type="text/javascript"></script>
    <meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=no">
</head>
<body>
<div class="header">
    <!--1联系方式-->
    <div class="header-1">
        <div class="col-md-6  col-lg-4">
            <div class="top1">客服热线：010-594-78634</div>
        </div>
        <div class="col-md-6 col-lg-4">
            <div class="topright">
                <button class="button1" type="button"></button>
                <button class="button2" type="button"></button>
                <button class="button3" type="button"></button>
                <h2>用户名：${cookie.username.value}</h2>
                <button type="button"><a href="${pageContext.request.contextPath}/u/showInfo">查看个人信息</a></button>
                </form>
            </div>
        </div>
    </div>
    <!--title-->
    <div class=" row2">
        <div class="col-md-6 col-lg-4 col-lg-offset-2">

        </div>
        <div class="col-md-6 col-lg-4">
            <button type="button" class="page2-button"></button>
            <div class="newbutton">
                <button class="row2-button1 row2-button1:hover" type="button"><a href="${pageContext.request.contextPath}/homepage" style="color:#fff !important;text-decoration: none;">首页</a></button>
                <button class="row2-button2 row2-button2:hover" type="button"><a href="${pageContext.request.contextPath}/u/profession" style="color:#fff !important;text-decoration: none;">职业</a></button>
                <button class="row2-button3 row2-button3:hover" type="button"><a href="${pageContext.request.contextPath}/recommend" style="color:#fff !important;text-decoration: none;">推荐</a></button>
                <button class="row2-button4 row2-button4:hover" type="button"><a href="${pageContext.request.contextPath}/u/gojoin" style="color:#fff !important;text-decoration: none;">加入</a></button>
                <button class="row2-button3 row2-button3:hover" type="button"><a href="${pageContext.request.contextPath}/login.jsp" style="color:#fff !important;text-decoration: none;">登陆</a></button>
                <button class="row2-button3 row2-button3:hover" type="button"><a href="${pageContext.request.contextPath}/signout" style="color:#fff !important;text-decoration: none;">登出</a></button>

            </div>
        </div>
    </div>
</div>
</body>
</html>
