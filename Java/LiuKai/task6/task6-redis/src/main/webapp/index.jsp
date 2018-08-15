<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<% String appPath = request.getContextPath(); %>
<html>
<body>
<h2>Hello World!</h2>
<br /><br />
<a href="/homepage" >任务四首页</a>
<br /><br />
<%--<a href="/students" methods="get">分页查看和时间转换</a>--%>
<br /><br />



<h2>登陆</h2>
<form id="zc" action="/signIn" method="post">
    <label for="stuName">姓名：</label>
    <input type="text" required id="stuName" name="stuName"><br>
    <label for="password">密码：</label>
    <input type="password" required id="password" name="password"><br>
    <input type="submit" value="登录">

    <%--<input type="button" value="注册" onclick="location.href='/zyf/zc'">--%>
</form>
</body>
</html>
