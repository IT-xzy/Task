<%--
  Created by IntelliJ IDEA.
  User: yiqia
  Date: 2018/1/18 0018
  Time: 13:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="db.*"%>
<%@ page import="java.util.*"%>
<html>
<head>
    <title>查询所有记录</title>
</head>
<body>
<%
    //通过DAO工厂获得DAO实现类实例
    UserDAO userDAO = DAOFactory.getDAOProxy();
    //查询所有用户
    List<User> all = userDAO.queryAll();
    Iterator<User> iter = all.iterator();
    //遍历输出所有用户信息
    while(iter.hasNext()) {
        User user = iter.next();
        out.println("用户名:" + user.getUsername());
        out.println(",密码:" + user.getPassword() + "<br>");
    }
%>
</body>
</html>
