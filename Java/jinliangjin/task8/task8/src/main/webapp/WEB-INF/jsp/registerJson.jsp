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
    <br/>
    <c:if test="${errors != null && errors.size() >0}">
        <c:forEach items="${errors}" var="item">
            ${item.defaultMessage}
        </c:forEach>
    </c:if>
    <c:if test="${!empty message}">
        ${message}
    </c:if>
    <form action="${pageContext.request.contextPath}/it/registerJson/json" method="get" >
        <br/>
        <br/>
        <table border="0">
            <tr>
                <td align="right">账号：</td>
                <td><input type="text" name="name" /></td>
            </tr>
            <tr>
                <td align="right">密码：</td>
                <td><input type="text" name="password" /></td>
            </tr>
            <tr>
                <td align="center">Email：</td>
                <td><input type="text" name="email" /></td>
            </tr>
            <tr>
                <td colspan="2" align="center"><input type="submit" value="注册" /></td>
            </tr>
        </table>
    </form>

    <br/>
    <a href="${pageContext.request.contextPath}/it/login">返回登录</a>
    <br/><br/>
</div>
</body>
</html>