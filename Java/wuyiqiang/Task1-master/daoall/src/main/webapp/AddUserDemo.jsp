<%--
  Created by IntelliJ IDEA.
  User: yiqia
  Date: 2018/1/18 0018
  Time: 11:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="db.*"%>
<html>
<head>
    <title>添加用户记录</title>
</head>
<body>
第一个网页
<%
    //通过DAO工厂获得DAO实现类实例
    UserDAO userDAO = DAOFactory.getUserDAOInstance();
    //设置需要添加的用户
    User user = new User();
    user.setUsername("dao");
    user.setPassword("4564");
    userDAO.insert(user);
%>
</body>
</html>
