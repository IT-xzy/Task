<%@ page contentType="text/html; charset=UTF-8" pageEncoding="utf-8" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
    <title>Spring MVC表单处理</title>
</head>
<body>

<h2>添加用户：</h2>
<form method="POST" action="/user/add">
    <table>
        <tr>
            <td>姓名</td>
            <td>学号</td>
        </tr>
        <tr>
            <td><input type="text" name="name" size="20"/></td>
            <td><input type="text" name="number" size="20"/></td>
            <td><input type="submit" value="提交"/></td>
        </tr>
    </table>
</form>
</body>
</html>