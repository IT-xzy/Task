<%--
  Created by IntelliJ IDEA.
  User: liujunpeng
  Date: 2018/5/25
  Time: 下午9:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<html>
<head>
    <title>成功界面</title>
</head>
<a href="<%=basePath%>demo/getAllUser">进入用户管理页</a>
<body>

</body>
</html>
