<%@ page contentType="text/html;charset=UTF-8" language="java"
         pageEncoding="UTF-8" import="java.util.*" %>

<%@ include file="../includes/includes.jsp" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>技能树首页</title>
    <link rel="icon" href="${pageContext.request.contextPath}/img/cock.ico" type="image/x-icon">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link href="https://cdn.bootcss.com/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
    <%--<link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">--%>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/base.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/head-foot.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/main-1.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/main-2.css">
    <script src="https://cdn.bootcss.com/jquery/2.0.0/jquery.min.js"></script>
    <script src="https://cdn.bootcss.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>

    <script src="${pageContext.request.contextPath}/js/json2.js"></script>
    <%--<script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>--%>
    <%--<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>--%>
    <script type="text/javascript">
        /*将post method 改变为delete*/
        $(function(){
            $(".delete").click(function(){
                var href=$(this).attr("href");
                $("#form_delete").attr("action",href).submit();
                return false;
            })
        })
    </script>

</head>

<body>
    <tiles:insertAttribute name="header" />
    <tiles:insertAttribute name="body"/>
    <%--<tiles:insertAttribute name="main" />--%>
    <%--<tiles:insertAttribute name="profession" />--%>
    <%--<tiles:insertAttribute name="recommend" />--%>
    <tiles:insertAttribute name="footer" />
</body>
</html>