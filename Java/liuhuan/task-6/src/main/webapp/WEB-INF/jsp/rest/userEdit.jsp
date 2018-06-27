<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%-- 解决 JSPs only permit GET, POST or HEAD. Jasper also permits OPTIONS --%>
<%@ page isErrorPage="true" %>
<html>
<head>
    <title>编辑用户信息</title>
</head>
<body>
<%-- 样式 --%>
<style>
    table,table td,table th{border:1px solid;border-collapse:collapse;}
    table td,input{width: 100%;text-align: center;padding-left: 2px}
</style>

<%-- 添加一个自定义tags, 将long类型的时间转为固定格式输出 --%>
<%@ taglib uri="/tags" prefix="date" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- 显示错误信息 有就提示  -->
<c:if test="${allErrors!=null}">
    <c:forEach items="${allErrors}" var="error">
        <font color="red">${error.defaultMessage}</font><br/>
    </c:forEach>
</c:if>
<%-- 获取id 取更新用户信息 --%>
<form action="${pageContext.request.contextPath }/u/update/${userCustom.id}" method="post">
    <%-- REST POST更新动作 --%>
    <input type="hidden" name="_method" value="POST"/>
    <fieldset>
        <legend>编辑用户</legend>
        <table width="100%" style="table-layout:fixed;word-break:break-all;background:#f2f2f2">
            <tr id="name">
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

            <tr>
                <td>${userCustom.id}</td>
                <td><input name="username" value="${userCustom.username}"></td>
                <td><input name="qq" type="number" value="${userCustom.qq}"></td>
                <td><input name="profession" value="${userCustom.profession}"></td>
                <td><input name="join_date" value="<date:date value ="${userCustom.join_date}"/>"</td>
                <td><input name="school" value="${userCustom.school}"></td>
                <td><input name="online_id" value="${userCustom.online_id}"></td>
                <td><input name="daily_url" value="${userCustom.daily_url}"></td>
                <td><input name="declaration" value="${userCustom.declaration}"></td>
                <td><input name="counselor" value="${userCustom.counselor}"></td>
                <td><input name="create_time" value="<date:date value ="${userCustom.create_time}"/>"></td>
                <td><input name="update_time" value="<date:date value ="${userCustom.update_time}"/>"></td>
                <td><input type="submit" value="提交"/></td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>
