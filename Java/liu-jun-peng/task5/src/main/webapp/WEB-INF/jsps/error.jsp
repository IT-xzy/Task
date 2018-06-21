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
登入失败!
${message}
<br>
<a href="${pageContext.request.contextPath}/tologin">返回</a>
</body>
</html>
