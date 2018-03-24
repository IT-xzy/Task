<%--
  Created by IntelliJ IDEA.
  User: yiqia
  Date: 2018/1/18 0018
  Time: 12:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="db.*"%>
<html>
<head>
    <title>更新用户记录</title>
</head>
<body>
<%
    //通过DAO工厂获得DAO实现类实例
    UserDAO userDAO = DAOFactory.getDAOProxy();
    //设置需要更新的用户
    User user = new User();
    user.setUserid(10);
    user.setUsername("dao");
    user.setPassword("123456");
    //执行更新操作
    userDAO.update(user);
%>
</body>
</html>