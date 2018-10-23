<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@page contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="t" %>
<!DOCTYPE html>
<html lang="en">


<body>
<!-- 头部 -->
<header>
    <div class="top w">
        <div class="num">客服热线：010-594-78634</div>
        <div class="logos">
            <img src="images/wx.png" alt="">
            <img src="images/qq.png" alt="">
            <img src="images/xl.jpg" alt="">
        </div>
    </div>
    <div class="top1">
        登陆&nbsp<span>|</span>&nbsp注册
    </div>
    <nav>
        <ul class=" nav1 w">
            <img src="images/logo.png" alt="">
            <li><a href="/home">首页</a></li>
            <li><a href="/profession">职业</a></li>
            <li><a href="/partner">推荐</a></li>
            <li><a href="">关于</a></li>
        </ul>
        <div class="dropdown">
            <img  class="ji" src="images/logo.png" alt="">
            <button class="btn dropdown-toggle clearfix" type="button" id="dropdownMenu1" data-toggle="dropdown"
                    aria-haspopup="true" aria-expanded="true">
                    <span>
                        <img src="images/btn1.png" alt="">
                    </span>
            </button>
            <ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
                <li><a href="/home">首页</a></li>
                <li><a href="task-93.jsp">职业</a></li>
                <li><a href="task-92.jsp">推荐</a></li>
                <li><a href="#">关于</a></li>
            </ul>
        </div>
    </nav>
</header>
</body>
</html>