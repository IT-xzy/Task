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
<h2>您拥有以下这些咸鱼：</h2>
<form method="GET" action="${pageContext.request.contextPath}/user/find">
    <table>
        <tr>综合查询窗口:</tr>
        <tr>
            <td>可根据序号、姓名、学号查询<input type="text" name="condition" size="8"/></td>
            <td><input type="submit" value="查询"></td>
        </tr>
    </table>
</form>
<form method="POST" action="${pageContext.request.contextPath}/user/add">
    <table>
        <tr>添加用户窗口:</tr>
        <tr>
            <td>姓名:<input type="text" name="name" size="12"/></td>
            <td>学号:<input type="text" name="number" size="12"/></td>
            <td><input type="submit" value="添加"></td>
        </tr>
    </table>
</form>

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
                <%--<td>${user.create_at}</td>--%>
                <%--<td>${user.update_at}</td>--%>
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
                    <td><input type="hidden" name="page" value="${page.currentPage}"></td>
                    <td><input type="submit" value="删除"></td>
                </form>
            </tr>
        </c:forEach>
    </c:if>
</table>
<table>
    <tr items="${page}">
        <form method="GET" action="${pageContext.request.contextPath}/user/page">
            <td><input type="hidden" name="page" value="1"></td>
            <td><input type="submit" value="首页"></td>
        </form>
        <form method="GET" action="${pageContext.request.contextPath}/user/page">
            <td><input type="hidden" name="page" value="${page.prefPage}"></td>
            <td><input type="submit" value="上一页"></td>
        </form>
        <td>当前：第${page.currentPage}页<--></td>
        <td>共：${page.totalPages}页</td>
        <form method="GET" action="${pageContext.request.contextPath}/user/page">
            <td><input type="hidden" name="page" value="${page.nextPage}"></td>
            <td><input type="submit" value="下一页"></td>
        </form>
        <form method="GET" action="${pageContext.request.contextPath}/user/page">
            <td><input type="hidden" name="page" value="${page.totalPages}"></td>
            <td><input type="submit" value="尾页"></td>
        </form>
    </tr>
</table>
<form method="GET" action="${pageContext.request.contextPath}/user/page">
    <table>
        <tr>
            <td>跳转到第:<input type="text" name="page" size="5"/>页</td>
            <td><input type="submit" value="确定"></td>
        </tr>
    </table>
</form>
</body>
</html>