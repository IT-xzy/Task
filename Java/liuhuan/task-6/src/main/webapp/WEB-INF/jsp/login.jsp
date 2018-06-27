<%--
  Created by IntelliJ IDEA.
  User: zhou
  Date: 2018/5/1
  Time: 16:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>系统登陆</title>
</head>
<body>
tomcat_2<br/>
SessionID:<%session.setAttribute("liuhuan.ml","liuhuan.ml");%><%=session.getId() %><br/>
Createdon:<%=session.getCreationTime() %>

<form style="text-align: center" action="${pageContext.request.contextPath }/validate.action" method="post">
    用户账号:<input type="text" name="username"/><br/>
    用户密码:<input type="password" name="password"/><br/>
    <input type="submit" value="登录"/>
</form>
</body>
</html>
