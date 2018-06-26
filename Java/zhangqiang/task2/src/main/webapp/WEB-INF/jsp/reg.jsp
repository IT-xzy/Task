<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/5/7
  Time: 13:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<html>
<head>
    <title>注册</title>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <style>
        .regfrom{
            margin: 20px;
        }
    </style>
</head>
<body>
<a class="btn btn-default" href="/index.jsp" >返回主页</a>
<br/>
<form id="regfrom" class="form-inline regfrom" action="/urg/user/reg" method="post">
    <input type="hidden" name="_method" value="post">
    <input type="text" class="form-control" name="name" id="name" placeholder="注册姓名"/>
    <input type="password" class="form-control" name="pwd" id="pwd" placeholder="输入密码"/>
    <input type="submit" class="btn btn-primary" value="提交">
</form>
</body>
</html>
