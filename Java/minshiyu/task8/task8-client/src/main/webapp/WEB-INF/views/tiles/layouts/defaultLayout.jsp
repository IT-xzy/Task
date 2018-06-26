<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>技能树首页</title>
    <link rel="stylesheet/less" type="text/css" href="${pageContext.request.contextPath }/static/less/task15.less" charset="UTF-8">
    <%--<link rel="stylesheet/less" type="text/css" href="<c:url value="/static/less/task15.less"/>" charset="UTF-8">--%>
    <script src="${pageContext.request.contextPath}/static/less.js-2.5.3/dist/less.min.js" type="text/javascript"></script>
    <%--<script src="https://cdn.bootcss.com/less.js/3.0.1/less.min.js"></script>--%>
    <%--<script src="http://cdn.static.runoob.com/libs/jquery/1.10.2/jquery.min.js">--%>
    <%--</script>--%>
    <meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=no">
</head>

<body>
<header id="header">
    <tiles:insertAttribute name="header"/>
</header>

<section id="site-content">
    <tiles:insertAttribute name="body"/>
</section>

<footer id="footer">
    <tiles:insertAttribute name="footer"/>
</footer>
</body>
</html>