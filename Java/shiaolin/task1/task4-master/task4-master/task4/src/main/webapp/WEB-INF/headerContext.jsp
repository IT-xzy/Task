<%@page   contentType="text/html;   charset=UTF-8"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

<div id="myCarousel" class="carousel slide">
    <ol class="carousel-indicators">
        <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
        <li data-target="#myCarousel" data-slide-to="1"></li>
        <li data-target="#myCarousel" data-slide-to="2"></li>
    </ol>
    <div class="carousel-inner">
        <div class="item active">
            <img src="${pageContext.request.contextPath}/static/images/background_2.jpg" alt="First slide">
        </div>
        <div class="item">
            <img src="${pageContext.request.contextPath}/static/images/background_3.jpg" alt="First slide">
        </div>
        <div class="item">
            <img src="${pageContext.request.contextPath}/static/images/background_5.jpg" alt="First slide">
        </div>
    </div>
    <a class="carousel-control left" href="#myCarousel" data-slide="prev">&lsaquo;</a>
    <a class="carousel-control right" href="#myCarousel" data-slide="next">&rsaquo;</a>
</div>