<%--
  Created by IntelliJ IDEA.
  User: qyh
  Date: 2018/10/28
  Time: 21:59
  To change this template use File | Settings | File Templates.
--%>
<%@page import="com.jnshu.entity.People"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title></title>
</head>
<body>
当前在线人数:${number}
<%
    ArrayList<People> userlist = (ArrayList<People>) request.getServletContext().getAttribute("userlist");
    if (userlist != null) {
        for (int i = 0; i < userlist.size(); i++) {

            People user = userlist.get(i);
%>
sessionID：<%=user.getSessionID()%>
<br>
IP:<%=user.getIp()%>
<br>
FirstName:<%=user.getFirstTime()%>
<hr>
<%}}%>
</body>
</html>

