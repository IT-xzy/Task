<%@ page contentType="text/html;charset=UTF-8" language="java"
         pageEncoding="UTF-8" import="java.util.*" %>
<%@ include file="WEB-INF/includes/includes.jsp" %>


<html>
<head>
    <link href="https://cdn.bootcss.com/bootstrap/4.1.1/css/bootstrap.css" rel="stylesheet">
    <%--<link href="css/bootstrap.min.css" rel="stylesheet">--%>
    <script src="${pageContext.request.contextPath}/js/json2.js"></script>
    <script src="https://cdn.bootcss.com/jquery/3.3.1/jquery.min.js"></script>

    <%--<script src="js/jquery.min.js"></script>--%>
    <script src="https://cdn.bootcss.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
    <%--<script src="js/bootstrap.min.js"></script>--%>

</head>
<body>
<div style=" background: url(img/shenNaiChuanZhiLang.jpg) no-repeat;
            height: 100%;width: 100%;overflow: hidden; background-size: cover;">

    <div style="text-align: center; margin-top: 251px;">
        <a href="${pageContext.request.contextPath}/index" >
            <input type="button" value="点击进入官网页面"
                   style="font-family: 楷体; font-size: 30px; border: none;
                           cursor: pointer; width: 270px; background: #e9cda800;
                           position: fixed; top: 40px; right: 60px;">
        </a>

        <a href="${pageContext.request.contextPath}/login">
            <input type="button" value="点击登录"
                   style="font-family: 楷体; font-size: 30px; border: none;
                           cursor: pointer; width: 200px; background: #e9cda800;
                           position: absolute; top: 90px; right: 155px;">
        </a>
        <a href="${pageContext.request.contextPath}/join">
            <input type="button" value="点击注册"
                   style="font-family: 楷体; font-size: 30px; border: none;
                           cursor: pointer; width: 200px; background: #e9cda800;
                           position: absolute; top: 140px; right: 155px;">
        </a>

    </div>
</div>


</div>


</body>
</html>
