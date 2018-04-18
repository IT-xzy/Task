<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>当前用户</title>
</head>
<body>
<form action="${ctx}/student/register" method="get">
    <input type="submit" value="添加学员">
</form>
<table border="1">
    <th>学员名</th>
    <th>操作</th>
    <c:forEach items="${list}" var="students">
    <tr>
        <td>${students.uname}</td>
        <td>
            <form action="${ctx}/student/${students.id}" method="get">
                <input type="submit" value="详细信息">
            </form>
            <form action="${ctx}/student/${students.id}" method="post">
                <input type="hidden" name="_method" value="DELETE">
                <input type="submit" value="删除">
            </form>
        </td>
        </c:forEach>
</table>

</body>
</html>