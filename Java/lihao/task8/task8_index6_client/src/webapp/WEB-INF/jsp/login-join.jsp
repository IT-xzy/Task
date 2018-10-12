<%@ page contentType="text/html;charset=UTF-8" language="java"
         pageEncoding="UTF-8" import="java.util.*" isELIgnored="false" %>

<%@ include file="../includes/includes.jsp" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>登录吧小火鸡</title>
    <link rel="icon" href="${pageContext.request.contextPath}/img/cock.ico" type="image/x-icon">

    <%--<link href="https://cdn.bootcss.com/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">--%>
    <%--<link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">--%>
    <%--<link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css">--%>
    <%--<script src="https://cdn.bootcss.com/jquery/2.0.0/jquery.min.js"></script>--%>
    <%--<script src="https://cdn.bootcss.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>--%>
    <%--<script src="${pageContext.request.contextPath}/js/json2.js"></script>--%>
    <%--<script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>--%>
    <%--<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>--%>

</head>
<body>

<%--<tiles:insertAttribute name="login" />--%>
<%--<tiles:insertAttribute name="join" />--%>

    <tiles:insertAttribute name="body" />

<%--<script src="${pageContext.request.contextPath}/js/backLogin.js"></script>--%>
</body>
</html>