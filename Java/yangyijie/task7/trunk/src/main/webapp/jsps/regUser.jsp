<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: yyj
  Date: 2018/1/6
  Time: 16:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册成功</title>
</head>
<body>
<%int i =1;
    while (i<8){
%>
<c:if test="${intro!=null}"><font color="#5f9ea0" size="<%=i%>">
        注册失败,${intro},即将返回主页
</font><br/></c:if>
<c:if test="${intro == null}">
    <font color="#ff1493" size="<%=i%>">
        注册成功,即将返回主页
    </font><br/>
</c:if>
<%i++;%>
<%}%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    response.setHeader("refresh","2,"+basePath+"l/login");%>
</body>
</html>
