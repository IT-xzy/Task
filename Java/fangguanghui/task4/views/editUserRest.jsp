<%--
  Created by IntelliJ IDEA.
  User: FGH
  Date: 2018/6/8
  Time: 16:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%><%@ taglib prefix="date" uri=""%>--%>
<%@ taglib uri="/tags" prefix="date" %>
<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>
<!DOCTYPE html>
<html>
<head>
    <base href="<%=basePath%>">
    <title>编辑用户</title>
    <script type="text/javascript">
        function updateUser(){
            var form = document.forms[0];
            form.method="post";
        }
    </script>
</head>
<body>
<h2>编辑用户</h2>
<form action="<%=basePath%>users/UserRest/{id}" name="userForm" method="post" >
    <fieldset>
        <legend>用户详细</legend>
        <json:object>
            <json:property name="id" value="${userby.id}"/>
            <json:property name="username" value="${userby.username}"/>
            <json:property name="QQ" value="${userby.QQ}"/>
            <json:property name="type" value="${userby.type}"/>
            <json:property name="joinTime" value="${userby.joinTime}"/>/>
            <json:property name="school" value="${userby.school}"/>
            <json:property name="onlineId" value="${userby.onlineId}"/>
            <json:property name="daily" value="${userby.daily}"/>
            <json:property name="description" value="${userby.description}"/>
            <json:property name="counsellor" value="${userby.counsellor}"/>
            <json:property name="create_at" value="${userby.create_at}"/>
            <json:property name="update_at" value="${userby.update_at}"/>
            <json:property name="create_by" value="${userby.create_by}"/>
            <json:property name="update_by" value="${userby.update_by}"/>
        </json:object>
    </fieldset>
    <input type="submit" value="编辑" onclick="updateUser()"/>
</form>
</body>
</html>