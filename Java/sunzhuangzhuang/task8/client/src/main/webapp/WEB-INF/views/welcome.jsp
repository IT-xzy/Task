<%@ page import="utils.CookieUtil" %>
<%@ page import="utils.Token" %><%--
  Created by IntelliJ IDEA.
  User: root
  Date: 2018/7/15
  Time: 19:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%!
    private String userName;
%>
<%
    Cookie cookie = CookieUtil.getCookie("login",request);
    userName = Token.parseJWT(cookie.getValue()).getId();
%>
<div align="center">
<form action="/student" method="post">
              <input name="username" value="<%=userName%>" type="hidden"><br/>
    真实姓名：<input name="name" placeholder="请输入真实姓名" maxlength="15"> <br/><br/>
    选择职业：<select name="occupation"><br/><br/>
                  <option>--请选择--</option>
                  <option value="java">java</option>
                  <option value="web">web</option>
                  <option value="pm">pm</option>
              </select>
    <input type="hidden" name="telephone" value="${telephone}"><br/><br/>
    邮箱地址：<input placeholder="请输入邮箱" name="email" maxlength="20"><br/><br/>
    身份验证：<input name="code" placeholder="请输入验证码" maxlength="6"><br/><br/>
    <input type="submit" value="加入内门">
</form>
</div>
</body>
</html>
