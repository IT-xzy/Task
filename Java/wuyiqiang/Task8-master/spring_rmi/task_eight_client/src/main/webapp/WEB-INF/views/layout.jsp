<%--
  Created by IntelliJ IDEA.
  User: yiqia
  Date: 2018/2/25 0025
  Time: 20:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="tilesx" uri="http://tiles.apache.org/tags-tiles-extras" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--<% String path = request.getContextPath(); %>--%>
<%--<c:set var="ctx" value="${pageContext.request.contextPath}" ></c:set>--%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <base href="<%=basePath%>">
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title><tiles:getAsString name="title"></tiles:getAsString></title>
    <link href="/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
    <script src="/js/jquery.min.js"></script>
    <script src="/js/bootstrap.min.js"></script>
    <tilesx:useAttribute name="cssPathList" ignore="true"></tilesx:useAttribute>
    <c:forEach items="${cssPathList}" var="cssPath">
        <link  href="${cssPath}" rel="stylesheet"/>
    </c:forEach>
</head>
<body>
    <tiles:insertAttribute name="header"></tiles:insertAttribute>
    <tiles:insertAttribute name="body"></tiles:insertAttribute>
    <tiles:insertAttribute name="footer"></tiles:insertAttribute>
</body>
</html>
