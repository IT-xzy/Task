<%@ page contentType="text/html;charset=UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <title></title>
</head>
<body>
<a href="${pageContext.request.contextPath}/add.jsp"><input type="submit" value="增加"></a>
<form action="${pageContext.request.contextPath}/admins/id" method="get">
    <input type="number" name="id">
    <input type="submit" value="查询">
</form>
<table border='1' cellspacing='0' width='40%'>
    <tr>
        <th>ID</th>
        <th>账号</th>
        <th>密码</th>
        <th>名字</th>
        <th>电话</th>
        <th>邮箱</th>
        <th>注册时间</th>
        <th>
            <form action="${pageContext.request.contextPath}/admins" method="post">
                <input type="hidden" name="_method" value="DELETE">
                <input type="submit" name="delete" value="删除全部">
            </form>
        </th>
    </tr>
    <c:forEach items="${admins}" var="admin">
        <tr>
            <th>${admin.adminId}</th>
            <th>${admin.adminCode}</th>
            <th>${admin.password}</th>
            <th>${admin.name}</th>
            <th>${admin.telephone}</th>
            <th>${admin.email}</th>
            <th>${admin.enrolldate}</th>
            <th>
                <form action="${pageContext.request.contextPath}/admins/${admin.adminId}" method="post">
                    <input type="hidden" name="_method" value="DELETE">
                    <input type="submit" name="delete" value="DELETE">
                </form>
            </th>
        </tr>
    </c:forEach>
    <form action="${pageContext.request.contextPath}/admin" method="post">
        <th><input type="number" name="adminId"/></th>
        <th><input type="text" name="adminCode"/></th>
        <th><input type="password" name="password"/></th>
        <th><input type="text" name="name"/></th>
        <th><input type="text" name="telephone"/></th>
        <th><input type="text" name="email"/></th>
        <th><input type="text" name="enrolldate"/></th>
        <th>
            <input type="hidden" name="_method" value="PUT">
            <input type="submit" value="更新"/>
        </th>
    </form>
</table>
</body>
</html>










