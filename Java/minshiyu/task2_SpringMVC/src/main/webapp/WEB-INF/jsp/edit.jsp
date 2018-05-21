<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<html>
<head>
    <title>添加学生</title>
</head>
<body>
<form method="POST" action="${pageContext.request.contextPath}/student/edit">
    <table border="1" cellpadding="10" cellspacing="0" class="table1">
        <tr>
            <th>学员ID</th>
            <th>姓名</th>
            <th>性别</th>
            <th>年龄</th>
            <th>QQ</th>
            <th>修真类型</th>
            <th>加入时间</th>
            <th>学校</th>
            <th>线上学号</th>
            <th>日报链接</th>
            <th>立愿</th>
            <th>辅导师兄</th>
        </tr>
        <tr>
            <th>${id}</th>
            <th><label>
                <input type="text" name="name" value="">
            </label></th>
            <th><label>
                <input type="text" name="gender" value="">
            </label></th>
            <th><label>
                <input type="text" name="age" value="">
            </label></th>
            <th><label>
                <input type="text" name="qq" value="">
            </label></th>
            <th><label>
                <input type="text" name="occupation" value="">
            </label></th>
            <th><label>
                <input type="text" name="joinDate" value="">
            </label></th>
            <th><label>
                <input type="text" name="school" value="">
            </label></th>
            <th><label>
                <input type="text" name="number" value="">
            </label></th>
            <th><label>
                <input type="text" name="dailyUrl" value="">
            </label></th>
            <th><label>
                <input type="text" name="declaration" value="">
            </label></th>
            <th><label>
                <input type="text" name="consoler" value="">
            </label></th>
        </tr>
        <tr>
            <th>
                <form action="/student/${id}" method="POST">
                    <input type="hidden" name ="_method" value="PUT">
                    <input type="submit" name="提交"></form>
            </th>
        </tr>
    </table>
</form>
<form action="${pageContext.request.contextPath}/student/list" method="GET">
    <input type="submit" value="返回主页">
</form>

</body>
</html>