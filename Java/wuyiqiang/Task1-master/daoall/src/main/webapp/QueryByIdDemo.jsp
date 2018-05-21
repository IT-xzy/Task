<%--
  Created by IntelliJ IDEA.
  User: yiqia
  Date: 2018/1/18 0018
  Time: 13:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="db.*"%>
<html>
<head>
    <title>按ID查询记录</title>
</head>
<body>
<%
    //通过DAO工厂获得DAO实现类实例  
    UserDAO userDAO = DAOFactory.getUserDAOInstance();
    //指定按ID查询  
    User user = userDAO.queryById(2);
    out.println("用户名：" + user.getUsername() + "<br>");
    out.println("密码：" + user.getPassword());
%>
</body>
</html> 