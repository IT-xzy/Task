<%@ page contentType="text/html;charset=UTF-8" language="java" isErrorPage="true" isELIgnored="false"
         pageEncoding="UTF-8" %>
<%@ page import="com.jnshu.myutils.CountUtils" %>
<html>
<body>
<h2>Hello World!</h2>
当前在线人数是：<%=CountUtils.getLoginCount()%>
</body>
</html>
