<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<% String appPath = request.getContextPath(); %>
<html>
<body>
<h2>Hello World!</h2>
</body>

<%--<form action="/find">--%>
    <%--<input type="text" name="id">--%>
    <%--<input type="submit">--%>
<%--</form>--%>

<%--<body>--%>
<%--<a href="list">分页查看</a>--%>
<br /><br /><br /><br />
<a href="/students" methods="get">查看所有</a>
</body>

<form method="post" action="/students">
    姓名： <input name="stuName" type="text">
    课程： <input name="course" type="text">
    <input type="submit" value="增加">
</form>

</html>
