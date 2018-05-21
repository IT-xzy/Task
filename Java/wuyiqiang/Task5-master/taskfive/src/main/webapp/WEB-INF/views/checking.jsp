<%--
  Created by IntelliJ IDEA.
  User: yiqia
  Date: 2018/3/2 0002
  Time: 14:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--<%--%>
    <%--String path = request.getContextPath();--%>
    <%--String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";--%>
<%--%>--%>
<html>
<head>
    <%--<base href="<%=basePath%>">--%>
    <title>checking</title>
</head>
<body>
<c:if test="${true==check}">
    <script>
        alert("登陆成功");
        window.location.href = "/school/index";
    </script>
</c:if>
<c:if test="${false==check}">
    <script>
        alert("登陆失败");
        window.location.href = "/school/sign_in"
    </script>
</c:if>
</body>
</html>
