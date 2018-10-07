<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isErrorPage="true"
        isELIgnored="false" %>
<%@taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>
<%@taglib uri="/tags" prefix="date" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en" xmlns="http://www.w3.org/1999/html">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <title>vote</title>
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="css/task8.css"/>
    <link rel="stylesheet" type="text/css" href="css/task8-2.css"/>
    <script src="https://cdn.bootcss.com/jquery/3.1.1/jquery.min.js"></script>
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    　
    <base href="${pageContext.request.contextPath}/">

</head>
<header>
    <div class="container">
        <div class="row">
            <div class="col-xs-12 col-md-12 col-lg-12 followus">
                <span>客服热线:010-59478634</span>
                <span class="pull-right">
                <%--<a class="wechat" href="#"></a>--%>
                <%--<a class="qq" href="#"></a>--%>
                <%--<a class="sina" href="#"></a>--%>
                  <c:choose>
                      <c:when test="${sessionScope.name != null }">
                          <a href="u/showPeople1?name=${sessionScope.name}" style="width:70px">${sessionScope.name }</a>
                          <a href="logOut">注销</a>
                      </c:when>
                      <c:otherwise>
                          <a href=loginPage>登录</a>
                          <a href="registerPage" style="width:70px">手机注册</a>
                          <a href="registerPageEmail" style="width:70px">邮箱注册</a>
                      </c:otherwise>
                  </c:choose>
        </span>
            </div>
        </div>
    </div>
    <div class="login">
        <span class="login1">
            <c:choose>
                <c:when test="${sessionScope.name != null }">
                    <a href="u/showPeople1?name=${sessionScope.name}" style="width:70px">${sessionScope.name }</a>
                    <a href="logOut">注销</a>
                </c:when>
                <c:otherwise>
                    <a href=loginPage>登录</a>
                    <a href="registerPage" style="width:70px">手机注册</a>
                    <a href="registerPageEmail" style="width:70px">邮箱注册</a>
                </c:otherwise>
            </c:choose>
        </span>

    </div>
    <div class="btl">
        <div class="container navigation">
            <div class="row">
                <div class="col-xs-12 col-md-12 col-lg-12">
                    <a href="u/company">关于</a>
                    <a href="">推荐</a>
                    <a href="u/profession">职业</a>
                    <a href="people">首页</a>
                </div>

            </div>
        </div>
    </div>
    <div class="dp">
        <div class="dp-cell">
            <ul class="nav nav-pills">
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#"><img src="img/holder.png"></a>
                    <ul class="scc dropdown-menu">
                        <li><a href="u/company">关于</a></li>
                        <li><a href="">推荐</a></li>
                        <li><a href="u/profession">职业</a></li>
                        <li><a href="people">首页</a></li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>

</header>

</html>