<%@ page contentType="text/html;charset=UTF-8" language="java" errorPage="WEB-INF/jsp/error.jsp" %>

<html>
<head>
    <title>修真院线上任务二</title>
</head>
<body>
<div style="width:500px;margin:0px auto;text-align:center">
    欢迎！<br/>
    页面将在三秒钟后自动跳转....<br/>
    如果浏览器不支持自动跳转，可点击下方按钮进入主页！<br/>
    <a href="/task2/student/list">进入主页</a>
</div>
<%
    // 重定向到新地址
    String site = new String("/task2/student/list");
    response.setStatus(response.SC_MOVED_TEMPORARILY);
    response.setHeader("Location", site);
%>
</body>
</html>
