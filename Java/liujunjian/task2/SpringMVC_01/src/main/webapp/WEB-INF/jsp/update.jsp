<%@ page contentType="text/html; charset=UTF-8" pageEncoding="utf-8" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
    <title>Spring MVC 表单处理</title>
</head>
<body>

<h2>修改用户信息：</h2>
<form method="PUT" action="${pageContext.request.contextPath}/user/update">
    <table>
        <tr>
            <td></td>
            <td>姓名</td>
            <td>学号</td>
        </tr>
        <tr items="${user}">
            <td><input type="hidden" name="id" size="20" value="${user.id}"/></td>
            <td><input type="text" name="name" size="20" value="${user.name}"/></td>
            <td><input type="text" name="number" size="20" value="${user.number}"/></td>
            <td><input type="submit" value="提交"/></td>
        </tr>
    </table>
</form>
</body>
</html>