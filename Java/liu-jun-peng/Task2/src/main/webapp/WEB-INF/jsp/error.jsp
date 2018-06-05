<%--
  Created by IntelliJ IDEA.
  User: liujunpeng
  Date: 2018/5/29
  Time: 下午6:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<html>
<head>
    <title>你什么也没改!</title>
</head>
<body>
<tr>${error}</tr>
<h3>
    <a href="<%=basePath%>demo/getAllUser">添加失败,点击返回主页面</a>
</h3>
</body>
</html>
