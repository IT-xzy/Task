<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>修真院线上任务二</title>
</head>
<body>
<%--<div style="width:500px;margin:0px auto;text-align:center">
    <img src="http://img18.3lian.com/d/file/201707/06/cac1071e2bc04ba4d79a0a00cea79e76.jpg"/><br/>
    欢迎！<br/>
    页面将在三秒钟后自动跳转....<br/>
    如果浏览器不支持自动跳转，可点击下方按钮进入主页！<br/>
    <a href="/task4/home">进入主页</a>
</div>
<%
    response.setHeader("refresh","3,URL=/task4/home");
%>--%>

<%
    // 重定向到新地址
    String site = new String("/task4/home");
    response.setStatus(response.SC_MOVED_TEMPORARILY);
    response.setHeader("Location", site);
%>
</body>
</html>
