<%--
  Created by IntelliJ IDEA.
  User: liujunpeng
  Date: 2018/6/9
  Time: 上午10:16
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <title></title>
</head>
<body>

登入成功!
<br>
您好!${user.username}
<br>
<a href="${pageContext.request.contextPath}/homepage">点击跳转首页</a>
<a href="${pageContext.request.contextPath}/tologin">点击跳转登录页面</a>
</body>
</html>