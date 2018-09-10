<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/body.css">
    <title>葡萄藤</title>
</head>
<body class="login-layout">
<div class="center">
    <h1>
        <i class="ace-icon fa fa-leaf green"></i>
        <span class="white" id="id-text2">用户注册</span>
    </h1>
    <h4 class="blue" id="id-company-text">&copy; 葡萄藤</h4>
</div>
<div>
<c:if test="${!empty errors}">
    <c:forEach items="${errors}" var="li">
        ${li.defaultMessage}
    </c:forEach>
</c:if><br>
    <c:if test="${!empty message}">
        ${message}
    </c:if>
</div>


<div class="widget-body" style="width:500px;margin-left: 33%;">
    <div class="widget-main">
        <h4 class="header blue lighter bigger">
            <i class="ace-icon fa fa-coffee green"></i>
            请输入您的信息
        </h4>
        <div class="space-6"></div>
        <form action="${pageContext.request.contextPath }/jnshu/toRegister" method="post">
            <fieldset>
                <label class="block clearfix">
                                <span class="block input-icon input-icon-right">
                                    用户名<input type="text" name="name" class="form-control"/>
                                </span><br><br>
                </label>
                <label class="block clearfix">
                                <span class="block input-icon input-icon-right">
                                    密码<input type="password" name="password" class="form-control"/>
                                </span><br><br>
                </label>
                <label class="block clearfix">
                                <span class="block input-icon input-icon-right">
                                    email<input type="text" name="email" class="form-control"/>
                                </span><br>
                </label>

                <div class="space"></div>
                <div class="clearfix" style="text-align: center;">
                    <input type="submit" value="提交" style="width:100px;">
                </div>
                <div class="space-4"></div>
            </fieldset>
        </form>
    </div>
</div>
</body>
</html>
