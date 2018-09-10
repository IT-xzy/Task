<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/body.css">
    <title>葡萄藤</title>
</head>
<body>
<c:if test="${!empty error}" >
    <c:forEach items="${error}" var="li">
        ${li.defaultMessage}
    </c:forEach>
</c:if>
<br>
<c:if test="${!empty message}">
    ${message}
</c:if>
<div align="center">
    <h4>亲爱的,请登录再访问</h4>
</div><br><br>
<div align="center">
<form action="${pageContext.request.contextPath}/jnshu/toLogin" method="post">
    <table>
        <tr>
            <td>用户名:</td>
            <td><input id="name" name="name" type="text"></td>
        </tr>
        <tr>
            <td>密码:</td>
            <td><input id="password" name="password" type="password"></td>
        </tr>
        <tr>
            <td><input type="submit" value="登录"></td>
        </tr>
    </table>
    <p><<input type="checkbox" name="rememberMe" value="rememberMe">记住我</p>
</form>
<br>
<a href="${pageContext.request.contextPath }/jnshu/register">新注册</a>

</div>
</body>
</html>