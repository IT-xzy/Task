<%--
  Created by IntelliJ IDEA.
  User: FGH
  Date: 2018/6/3
  Time: 13:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="/tags" prefix="date" %>
<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>
<!DOCTYPE html>
<html>
<head>
    <title>编辑用户</title>
</head>
<body>
<h2>编辑用户</h2>
<form action="${pageContext.request.contextPath}/users/user" name="userForm"  method="post">
    <fieldset>
        <legend>用户详细</legend>
        <input type="hidden" name="_method" value="PUT">
        <input type="hidden" name="id" value="${userby.id}"  /></br>
        <p>用户姓名：<input type="text" name="username" value="${userby.username}"  /></p>
        <p>用户QQ：  <input type="text" name="QQ"  value="${userby.QQ}"  /></p>
        <p>修真类型：<input type="text" name="type"  value="${userby.type}" /></p>
        <p>入学时间：<input type="text" name="joinTime"  value="<date:date value ="${userby.joinTime}" />" /></p>
        <p>毕业院校：<input type="text" name="school" value="${userby.school}"  /></p>
        <p>网上学号：<input type="text" name="onlineId" value="${userby.onlineId}"  /></p>
        <p>日报链接：<input type="text" name="daily" value="${userby.daily}"  /></p>
        <p>入门宣言：<input type="text" name="description" value="${userby.description}"  /></p>
        <p>辅导师兄：<input type="text" name="counsellor" value="${userby.counsellor}"  /></p>
        <p>知道途径：<input type="text" name="way" value="${userby.way}"  /></p>
        <p>创建时间：<input type="text" name="create_at" value="<date:date value ="${userby.create_at} "/>" /></p>
        <p>更新时间：<input type="text" name="update_at" value="<date:date value ="${userby.update_at} "/>" /></p>
        <p>创建人员：<input type="text" name="create_by" value="${userby.create_by}"  /></p>
        <p>更新人员：<input type="text" name="update_by" value="${userby.update_by}"  /></p>
    </fieldset>
    <input type="submit" value="编辑" />
    <h3><a href="${pageContext.request.contextPath}/users">返回列表</a></h3>
</form>
</body>
</html>
