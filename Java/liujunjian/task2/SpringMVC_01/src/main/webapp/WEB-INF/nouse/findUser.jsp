<%@ page contentType="text/html; charset=UTF-8" pageEncoding="utf-8" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
    <title>Spring MVC表单处理</title>
</head>
<body>

<h2>根据序号查询：</h2>
<form method="GET" action="/user/id">
    <table>
        <tr>
            <td>序号：</td>
            <td><input type="text" name="id" size="20"/></td>
            <td><input type="submit" value="提交"/></td>
        </tr>
    </table>
</form>
<h2>根据姓名查询：</h2>
<form method="GET" action="/user/name">
    <table>
        <tr>
            <td>姓名：</td>
            <td><input type="text" name="name" size="20"/></td>
            <td><input type="submit" value="提交"/></td>
        </tr>
    </table>
</form>
<h2>根据学号查询：</h2>
<form method="GET" action="/user/number">
    <table>
        <tr>
            <td>学号：</td>
            <td><input type="text" name="number" size="20"/></td>
            <td><input type="submit" value="提交"/></td>
        </tr>
    </table>
</form>
</body>
</html>