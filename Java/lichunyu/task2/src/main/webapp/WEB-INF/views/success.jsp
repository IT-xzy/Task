<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: lichu
  Date: 2018-5-9
  Time: 17:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>success page</title>
</head>
<body style="text-align:center">
<h3>欢迎师兄-${requestScope.user.username}-来此一览</h3>
<p>
    <%--name：${requestScope.user.username}<br />--%>
    <%--password：${requestScope.user.password}<br />--%>
    <%--大侠芳龄：${requestScope.user.age}<br />--%>

</p>
<p>
    <%--获取参数的另一种方法JSP Session--%>
    <%--<%--%>
        <%--String name = request.getParameter("username");--%>
        <%--if((name!=null))--%>
        <%--{--%>
            <%--session.setAttribute("username",name);--%>
        <%--}--%>
    <%--%>--%>
    <%--JSP Session获取姓名： :<%=session.getAttribute("username")%>--%>
</p>
<br/>

<form action="supplierPage" >
    <button  type="submit">跳转到所有数据页面</button>
</form>
<%--<a href="suppliers">分页显示所有供应商信息</a>--%>
<br/><br/>

<a href="javascript:history.go(-1);">返回</a>
</body>
</html>
