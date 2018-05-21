<%@ page import="java.awt.*" %><%--
  Created by IntelliJ IDEA.
  User: yyj
  Date: 2017/12/27
  Time: 21:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--<%int i =1;--%>
    <%--while (i<8){--%>
    <%--%>--%>
    <%--<font color="#9932cc" size="<%=i%>">--%>
        <%--即将进入主页!--%>
    <%--</font><br/>--%>
<%--<%i++;%>--%>
<%--<%}%>--%>
<%String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    response.setHeader("refresh","0,"+basePath+"l/login");%>
</body>
</html>
