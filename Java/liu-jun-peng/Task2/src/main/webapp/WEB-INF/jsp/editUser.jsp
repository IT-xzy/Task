<%--
  Created by IntelliJ IDEA.
  User: liujunpeng
  Date: 2018/5/23
  Time: 上午11:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">

    <title>编辑用户</title>

    <%--<script type="text/javascript">--%>
        <%--function updateUser(){--%>
            <%--var form = document.forms[0];--%>
            <%--form.action = "<%=basePath%>demo/updateUser";--%>
            <%--form.method="PUT";--%>
            <%--form.submit();--%>
        <%--}--%>
    <%--</script>--%>
    <%--<h6><a href="<%=basePath%>demo/getUser">查找用户</a></h6>--%>
</head>

<body>
<h1>更改用户</h1>
<form id="itemForm" action="<%=basePath%>demo/updateUser" method="post">
    <input type="hidden" name="_method" value="put">
    <input type="hidden" name="id" value="${user.id }"/>
    修改信息:
    <table width="100%" border=1>
        <tr>
            <td>姓名</td>
            <td><input type="text" name="name" value="${user.name }"/></td>
        </tr>
        <tr>
            <td>QQ</td>
            <td>
                <input type="text" name="QQ" value="${user.QQ }"/>
            </td>
        </tr>
        <tr>
            <td>入学时间</td>
            <td>
                <input type="text" name="rxtime" value="${user.rxtime}"/>
            </td>
        </tr>

        <tr>
            <td>创建时间</td>
            <td>
            <input type="text" name="create_at" value="${user.create_at}"/>
            </td>
        </tr>
        <tr>
            <td>修改时间</td>
            <td>
            <input type="text" name="update_at" value="${user.update_at}"/>
            </td>
        </tr>
        <tr>
            <td colspan="2" align="center"><input id="up" type="submit" value="提交"/>
            </td>
        </tr>
    <%--姓名：<input type="text" name="name" value="${user.name }"/>--%>
    <%--QQ：<input type="text" name="QQ" value="${user.QQ }"/>--%>
    <%--<input type="button" value="更改" onclick="updateUser()"/>--%>
</table>
</form>
</body>

</html>