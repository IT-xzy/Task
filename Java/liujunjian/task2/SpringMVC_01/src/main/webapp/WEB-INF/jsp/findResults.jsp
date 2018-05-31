<%@page contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<html>
<head>
    <title>Spring MVC表单处理</title>
</head>
<body>
<h2>您需要的咸鱼在这：</h2>
<table frame="box" rules="all">
    <tr>
        <td>序号</td>
        <td>姓名</td>
        <td>学号</td>
        <td>创建时间</td>
        <td>修改时间</td>
    </tr>
    <c:if test="${list!= null || fn:length(list) != 0}">
        <c:forEach items="${list}" var="user" begin="0" end="${fn:length(list) }">
            <tr>
                <td>${user.id}</td>
                <td>${user.name}</td>
                <td>${user.number}</td>
                <jsp:useBean id="create_at" class="java.util.Date"/>
                <jsp:setProperty name="create_at" property="time" value="${user.create_at}"/>
                <td><fmt:formatDate value="${create_at}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                <jsp:useBean id="update_at" class="java.util.Date"/>
                <jsp:setProperty name="update_at" property="time" value="${user.update_at}"/>
                <td><fmt:formatDate value="${update_at}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                <form method="PUT" action="${pageContext.request.contextPath}/user/edit">
                    <td><input type="hidden" name="id" value="${user.id}"></td>
                    <td><input type="submit" value="修改"></td>
                </form>
                <form method="DELETE" action="${pageContext.request.contextPath}/user/delete">
                    <td><input type="hidden" name="id" value="${user.id}"></td>
                    <td><input type="submit" value="删除"></td>
                </form>
            </tr>
        </c:forEach>
    </c:if>
</table>
</body>
</html>