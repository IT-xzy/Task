<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="utf-8"%>
<% String path=request.getContextPath();
    String basePath=request.getScheme()+":/"+request.getServerName()+":"+request.getServerPort()+path+"/";%>
<html>
<head>
    <tittle><b>首页</b></tittle>
    <style type="text/css">
        a{
            text-decoration: antiquewhite;
            color: yellowgreen;
            font-size: 14px;
        }
        h3{
            width: 180px;
            height:38px;
            margin: 100px auto;
            background: azure;
        }
    </style>
</head>
<body>
<h2>Hello World!</h2>
<a href="/student">进入学生管理界面</a>
</body>
</html>
