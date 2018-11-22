<%--
  Created by IntelliJ IDEA.
  User: qyh
  Date: 2018/10/30
  Time: 23:04
  To change this template use File | Settings | File Templates.
--%>
<%--//set.jsp
//为了使程序简单，我们采用手动设置session
//在实际的项目中，当用户登录之后自动设置session--%>
<%@ page contentType="text/html;charset=UTF-8"
         language="java" isErrorPage="true" isELIgnored="false" pageEncoding="UTF-8" %>
<html>
<head>
    <title></title>
</head>
<body>
<% pageContext.getSession().setAttribute("state","0");%>
</body>
</html>
