<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!--第三部分开始-->
<div class="main-c row">
    <h3 class="text-center main-tab">优秀学员展示</h3>
    <ul class="list-unstyled text-center">
        <c:forEach items="${goodShow}" var="position">
            <li class="col-xs-12 col-sm-6 col-md-6 col-lg-3">
                <div>
                    <img src="${pageContext.request.contextPath}/static/images/${position.image}.png">
                    <span>${position.position}:${position.name}</span>
                    <p class="text-left">${position.intro}</p>
                </div>
            </li>
        </c:forEach>
    </ul>
</div>