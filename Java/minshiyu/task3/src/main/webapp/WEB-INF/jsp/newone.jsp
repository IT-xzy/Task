<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<html>
<head>
    <title>添加学生</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/student/newone" method="POST">
    <table border="1" cellpadding="10" cellspacing="0" class="table1">
        <tr>
            <th>姓名</th>
            <th><input type="text" name="name" value=""/></th>
        </tr>
        <tr>
            <th>性别</th>
            <th><input type="text" name="gender" value=""/></th>
        </tr>
        <tr>
            <th>年龄</th>
            <th><input type="text" name="age" value=""/></th>
        </tr>
        <tr>
            <th>QQ</th>
            <th><input type="text" name="qq" value=""/></th>
        </tr>
        <tr>
            <th>修真类型</th>
            <th><input type="text" name="occupation" value=""/></th>
        </tr>
        <tr>
            <th>加入日期</th>
            <th><input type="text" name="joinDate" value=""/></th>
        </tr>
        <tr>
            <th>学校</th>
            <th><input type="text" name="school" value=""/></th>
        </tr>
        <tr>
            <th>学号</th>
            <th><input type="text" name="number" value=""/></th>
        </tr>
        <tr>
            <th>日报链接</th>
            <th><input type="text" name="dailyUrl" value=""/></th>
        </tr>
        <tr>
            <th>宣言</th>
            <th><input type="text" name="declaration" value=""/></th>
        </tr>
        <tr>
            <th>辅导师兄</th>
            <th><input type="text" name="consoler" value=""/></th>
        </tr>
        <tr>
            <th>
                    <input type="submit" name="提交">
            </th>
        </tr>
    </table>
</form>
    <form action="${pageContext.request.contextPath}/student/list" method="GET">
        <input type="submit" value="返回主页"></form>

</body>
</html>