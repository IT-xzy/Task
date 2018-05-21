<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/10/5
  Time: 13:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="${ctx}/login">未登录，请登陆后查看</a>
<script>
    function jumpurl(){
        location='http://www.summerwaves.cn/login';
    }
    setTimeout('jumpurl()',3000);
</script>
</body>
</html>
