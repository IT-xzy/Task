
<%@ page contentType="text/html;charset=UTF-8" %>
<div id="myCarousel" class="carousel slide">
    <ol class="carousel-indicators">
        <li class="active" data-slide-to="0" data-target="#myCarousel"></li>
        <li data-slide-to="1" data-target="#myCarousel"></li>
        <li data-slide-to="2" data-target="#myCarousel"></li>
        <li data-slide-to="3" data-target="#myCarousel"></li>
    </ol>
    <div class="carousel-inner">
        <div class="item active">
            <img alt="First slide" src="${pageContext.request.contextPath}/static/image/547567.jpg">
        </div>
        <div class="item">
            <img alt="Second slide" src="${pageContext.request.contextPath}/static/image/547567.jpg">
        </div>
        <div class="item">
            <img alt="Third slide" src="${pageContext.request.contextPath}/static/image/547567.jpg">
        </div>
        <div class="item">
            <img alt="Third slide" src="${pageContext.request.contextPath}/static/image/547567.jpg">
        </div>
        <a data-slide="prev" href="#myCarousel" class="carousel-control left">
            <i class="icon-left"><img src="${pageContext.request.contextPath}/static/image/54354.png"></i>
        </a>
        <a data-slide="next" href="#myCarousel" class="carousel-control right">
            <i class="icon-right"><img src="${pageContext.request.contextPath}/static/image/4525424.png"></i>
        </a>
    </div>
</div>
