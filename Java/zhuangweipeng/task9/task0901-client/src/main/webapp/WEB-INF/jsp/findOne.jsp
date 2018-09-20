<%--&lt;%&ndash;--%>
  <%--Created by IntelliJ IDEA.--%>
  <%--User: Administrator--%>
  <%--Date: 2018/8/20--%>
  <%--Time: 3:50--%>
  <%--To change this template use File | Settings | File Templates.--%>
<%--&ndash;%&gt;--%>

<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<%--%>
    <%--String path = request.getContextPath();--%>
    <%--String basePath = request.getScheme() + "://"--%>
            <%--+ request.getServerName() + ":" + request.getServerPort()--%>
            <%--+ path + "/";--%>
<%--%>--%>
<%--<html>--%>
<%--<head>--%>
    <%--<title>查询单个论文</title>--%>
    <%--<meta name="viewport" content="width=device-width, initial-scale=1.0">--%>
    <%--<!-- 引入 Bootstrap -->--%>
    <%--<link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">--%>
<%--</head>--%>
<%--<body>--%>
<%--<div class="container">--%>
    <%--<div class="row clearfix">--%>
        <%--<div class="col-md-12 column">--%>
            <%--<div class="page-header">--%>
                <%--<h1>--%>
                    <%--基于SSM框架的管理系统：简单实现增、删、改、查。--%>
                <%--</h1>--%>
            <%--</div>--%>
        <%--</div>--%>
    <%--</div>--%>

    <%--<div class="row clearfix">--%>
        <%--<div class="col-md-12 column">--%>
            <%--<div class="page-header">--%>
                <%--<h1>--%>
                    <%--<small>查询单个论文</small>--%>
                <%--</h1>--%>
            <%--</div>--%>
        <%--</div>--%>
    <%--</div>--%>
    <form>
        <h1>查询结果</h1>
        ID号：${paper.paperId}<br>
        论文名称：${paper.paperName}<br>
        论文数量：${paper.paperNum}<br>
        论文详情：${paper.paperDetail}<br>
    </form>

<%--</div>--%>