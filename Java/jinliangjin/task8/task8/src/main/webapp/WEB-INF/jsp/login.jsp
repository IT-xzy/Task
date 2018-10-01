<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<html>
<head>
    <link rel="stylesheet" href="/task8/css/body.css">
    <title>葡萄藤</title>
</head>
<body>

<div align="center">
    <br/>
    <c:if test="${errors != null && errors.size() >0}">
        <c:forEach items="${errors}" var="item">
            ${item.defaultMessage}<br/>
        </c:forEach>
    </c:if>
    <c:if test="${!empty message}">
        ${message}
    </c:if>
    <br/>
    <form action="${pageContext.request.contextPath}/it/login/result" method="post">
        <table border="0" align="center">
            <tr>
                <td align="center">账号：</td>
                <td align="center"><input type="text" name="name"/></td>
            </tr>
            <tr>
                <td align="center">密码：</td>
                <td align="center"><input type="text" name="password"/></td>
            </tr>
            <tr>
                <td colspan="2" align="center"><input type="submit" value="登录"/></td>
            </tr>
        </table>
        <p><input name="rememberMe" type="checkbox" value="rememberMe">记住我</p>
    </form>
    <br/>
    <a href="${pageContext.request.contextPath}/it/register">注册</a>
    <br/><br/>
</div>
</body>
</html>