<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<html>
<head>
    <title>添加学生</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/student/newOne" method="POST">
    <table border="1" cellpadding="10" cellspacing="0" class="table1">
        <tr>
            <th>姓名</th>
            <th><input type="text" name="name" value=""/></th>
        </tr>
        <tr>
            <th>性别</th>
            <th><input type="text" name="QQ" value=""/></th>
        </tr>
        <tr>
            <th>年龄</th>
            <th><input type="text" name="type" value=""/></th>
        </tr>
        <tr>
            <th>QQ</th>
            <th><input type="text" name="admissionTime" value=""/></th>
        </tr>
        <tr>
            <th>修真类型</th>
            <th><input type="text" name="school" value=""/></th>
        </tr>
        <tr>
            <th>加入日期</th>
            <th><input type="text" name="num" value=""/></th>
        </tr>
        <tr>
            <th>学校</th>
            <th><input type="text" name="daily" value=""/></th>
        </tr>
        <tr>
            <th>学号</th>
            <th><input type="text" name="declaration" value=""/></th>
        </tr>
        <tr>
            <th>日报链接</th>
            <th><input type="text" name="elder" value=""/></th>
        </tr>
        <tr>
            <th>宣言</th>
            <th><input type="text" name="knewFrom" value=""/></th>
        </tr>
        <tr>
            <th>辅导师兄</th>
            <th><input type="text" name="knewFrom" value=""/></th>
        </tr>
        <tr>
            <th>
                <form method="get" action="${pageContext.request.contextPath}/student/update">
                    <input type="submit" name="提交">
                </form>
            </th>
        </tr>
    </table>
    <form action="${pageContext.request.contextPath}/student/list" method="GET">
        <input type="submit" value="返回主页">
    </form>
</form>
</body>
</html>