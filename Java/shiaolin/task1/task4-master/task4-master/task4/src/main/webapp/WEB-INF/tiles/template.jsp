<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <tiles:insertAttribute name="head"/>
</head>
<body onafterprint>
<a class="backIndex" href="${pageContext.request.contextPath}tiles/index.jsp">回首页</a>
<header>
    <tiles:insertAttribute name="header"/>
    <tiles:insertAttribute name="headerContext" />
</header>
<main>
    <tiles:insertAttribute name="main"/>
</main>
<footer>
    <tiles:insertAttribute name="footer"/>
</footer>
    <script src="${pageContext.request.contextPath}js/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}js/bootstrap.min.js"></script>
</body>
</html>