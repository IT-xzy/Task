<%--
  Created by IntelliJ IDEA.
  User: zhou
  Date: 2018/4/28
  Time: 21:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>用户综合列表</title>
</head>
<body>
<%-- 添加一个自定义tags, 将long类型的时间转为固定格式输出 --%>
<%@ taglib uri="/tags" prefix="date" %>

<style>
    table,table td,table th{border:1px solid;border-collapse:collapse;text-align: center;}
    input{width: 95%;text-align: center}
    /*#name,#name2{width: 95%;text-align: center;padding-left: 2px}*/
</style>

<%-- 版本切换 --%>
<div style="text-align: center"><input type="button" value="切换REST版本" onClick="location.href='${pageContext.request.contextPath }/rest/list/'" /></div>
<hr>
<%-- 登陆模块 --%>
当前用户:${username }|
<c:if test="${username!=null }">
    <a href="${pageContext.request.contextPath }/logout.action">退出</a>
    <hr>
</c:if>


<!-- 显示错误信息 有就提示  -->
<c:if test="${allErrors!=null}">
    <c:forEach items="${allErrors}" var="error">
        <font color="red">${error.defaultMessage}</font><br/>
    </c:forEach>
</c:if>

<%-- 查询模块 --%>
<form name="usersFrom" action="${pageContext.request.contextPath}/userList.action" method="post">
    <fieldset>
        <legend>查询条件</legend>
        <table width="100%" style="table-layout:fixed;word-break:break-all;background:#f2f2f2">
            <tr id="name">
                <td>id(>=)</td>
                <td>用户名称</td>
                <td>QQ</td>
                <td>修真类型</td>
                <td>入学时间(>=)</td>
                <td>毕业院校</td>
                <td>线上id(>=)</td>
                <td>日报连接</td>
                <td>立愿</td>
                <td>辅导师兄</td>
                <td>创建时间(>=)</td>
                <td>更新时间(>=)</td>
                <td>操作</td>
            </tr>
            <tr>
                <td><input name="userCustom.id" type="number" value="${findUserCustom.id}"/></td>
                <td><input name="userCustom.username" value="${findUserCustom.username}"></td>
                <td><input name="userCustom.qq" type="number" value="${findUserCustom.qq}"></td>
                <td><input name="userCustom.profession" value="${findUserCustom.profession}"></td>
                <td><input name="userCustom.join_date" value='<date:date value="${findUserCustom.join_date}"/>'></td>
                <td><input name="userCustom.school" value="${findUserCustom.school}"></td>
                <td><input name="userCustom.online_id" value="${findUserCustom.online_id}"></td>
                <td><input name="userCustom.daily_url" value="${findUserCustom.daily_url}"></td>
                <td><input name="userCustom.declaration" value="${findUserCustom.declaration}"></td>
                <td><input name="userCustom.counselor" value="${findUserCustom.counselor}"></td>
                <td><input name="userCustom.create_time" value='<date:date value="${findUserCustom.create_time}"/>'></td>
                <td><input name="userCustom.update_time" value='<date:date value="${findUserCustom.update_time}"/>'></td>
                <td><input type="submit" value="查询"/></td>
            </tr>
        </table>
</fieldset>
</form>

<%-- 添加模块 --%>
<form name="usersFrom" action="${pageContext.request.contextPath}/userAdd.action" method="post">
    <fieldset>
        <legend>添加用户</legend>
        <table width="100%" style="table-layout:fixed;word-break:break-all;background:#f2f2f2">
            <tr id="name2">
                <td>用户名称</td>
                <td>QQ</td>
                <td>修真类型</td>
                <td>入学时间</td>
                <td>毕业院校</td>
                <td>线上id</td>
                <td>日报连接</td>
                <td>立愿</td>
                <td>辅导师兄</td>
                <td>创建时间</td>
                <td>更新时间</td>
                <td>操作</td>
            </tr>
            <tr>
                <td><input name="username" value="${userEcho.username}"></td>
                <td><input name="qq" type="number" value="${userEcho.qq}"></td>
                <td><input name="profession" value="${userEcho.profession}"></td>
                <td><input name="join_date" value='<date:date value="${userEcho.join_date}"/>'></td>
                <td><input name="school" value="${userEcho.school}"></td>
                <td><input name="online_id" value="${userEcho.online_id}"></td>
                <td><input name="daily_url" value="${userEcho.daily_url}"></td>
                <td><input name="declaration" value="${userEcho.declaration}"></td>
                <td><input name="counselor" value="${userEcho.counselor}"></td>
                <td><input name="create_time" value='<date:date value="${userEcho.create_time}"/>'></td>
                <td><input name="update_time" value='<date:date value="${userEcho.update_time}"/>'></td>
                <td><input type="submit" value="添加"/></td>
            </tr>
        </table>
    </fieldset>
</form>

<%-- 显示模块 --%>
<fieldset>
    <legend>用户列表</legend>
    <table width="100%" border=1>
        <tr>
            <td>id</td>
            <td>用户名称</td>
            <td>QQ</td>
            <td>修真类型</td>
            <td>入学时间</td>
            <td>毕业院校</td>
            <td>线上id</td>
            <td>日报连接</td>
            <td>立愿</td>
            <td>辅导师兄</td>
            <td>创建时间</td>
            <td>更新时间</td>
            <td>操作</td>
        </tr>
        <%-- 调用modelAndView传过来的map,再找其中id为userList的--%>
        <c:forEach items="${userList}" var="users">
            <tr>
                <td>${users.id}</td>
                <td>${users.username }</td>
                <td>${users.qq }</td>
                <td>${users.profession }</td>
                <td><date:date value="${users.join_date} "/></td>
                <td>${users.school }</td>
                <td>${users.online_id }</td>
                <td>${users.daily_url }</td>
                <td>${users.declaration}</td>
                <td>${users.counselor}</td>
                <td><date:date value="${users.create_time} "/></td>
                <td><date:date value="${users.create_time} "/></td>
                <td>
                    <a href="${pageContext.request.contextPath }/userEdit.action?id=${users.id}">修改</a>
                    <a href="${pageContext.request.contextPath }/userDelete.action?id=${users.id}">删除</a>
                </td>
                <%--<td><input type="checkbox" name="items_id" value="${users.id}"></td>--%>
            </tr>
        </c:forEach>
    </table>
</fieldset>
</body>
</html>