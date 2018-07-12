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
    <img src="${url}" width="100" height="100">
    <c:if test="${!empty message}">
        ${message}
    </c:if>

    <form action="${pageContext.request.contextPath}/it/u/photo/result" method="post" enctype="multipart/form-data">
        <br/>
        <br/>
        <input type="hidden" name="name" value="${name}">
        <table border="0">
            <tr>
                <td align="center">选择头像</td>
                <td><input type="file" name="file" /></td>
            </tr>
            <tr>
                <td colspan="2" align="center"><input type="submit" value="上传" /></td>
            </tr>
        </table>
    </form>

    <br/>
    <a href="${pageContext.request.contextPath}/it/u/recommend">放弃修改</a>
    <br/><br/>
</div>
</body>
</html>