<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="java.util.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<body>

<!--顶部栏-->
<div class="top">
    <p>客服电话:010-594-78634</p>
    <c:if test="${sessionScope.name == null}">
        <a href="/a/login">登录|注册</a>
    </c:if>
    <c:if test="${sessionScope.name != null}">
        <c:out value="欢迎你，${sessionScope.name}"/>
        <a href="/a/logout">切换账号</a>
    </c:if>
    <div class="top-logo">
        <div class="wexin"></div>
        <div class="qq"></div>
        <div class="sina"></div>
    </div>
</div>

<!--header-two-->
<div class="header-two">
    <img src="/view/jnshu/img/two/logo.png" height="40">
    <div class="option">
        <a href="/a/home" class="option-1">首页</a>
        <a href="/a/three" class="option-1">职业</a>
        <a href="/a/two" class="option-1">推荐</a>
        <a href="/a/u/myMessage" class="option-1">我的</a>
    </div>
</div>

</body>
</html>
