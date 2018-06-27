<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<html>
<head>
    <title>ID查询</title>
</head>
<body>
<form method="POST" action="/student/${studentById.id}"><!--指向的是路径名称-->
    <table border="1" cellpadding="10" cellspacing="0" class="table1">
        <tr>
            <th>姓名</th>
            <th><input type="text" name="name" value="${studentById.name}"/></th>
        </tr>
        <tr>
            <th>性别</th>
            <th><input type="text" name="gender" value="${studentById.gender}"/></th>
        </tr>
        <tr>
            <th>年龄</th>
            <th><input type="text" name="age" value="${studentById.age}"/></th>
        </tr>
        <tr>
            <th>QQ</th>
            <th><input type="text" name="qq" value="${studentById.qq}"/></th>
        </tr>
        <tr>
            <th>修真类型</th>
            <th><input type="text" name="occupation" value="${studentById.occupation}"/></th>
        </tr>
        <tr>
            <th>加入日期</th>
            <th><input type="text" name="joinDate" value="${studentById.joinDate}"/></th>
        </tr>
        <tr>
            <th>学校</th>
            <th><input type="text" name="school" value="${studentById.school}"/></th>
        </tr>
        <tr>
            <th>学号</th>
            <th><input type="text" name="number" value="${studentById.number}"/></th>
        </tr>
        <tr>
            <th>日报链接</th>
            <th><input type="text" name="dailyUrl" value="${studentById.dailyUrl}"/></th>
        </tr>
        <tr>
            <th>宣言</th>
            <th><input type="text" name="declaration" value="${studentById.declaration}"/></th>
        </tr>
        <tr>
            <th>辅导师兄</th>
            <th><input type="text" name="consoler" value="${studentById.consoler}"/></th>
        </tr>
    </table>
    <input type="hidden" value="PUT" name="_method">
    <input type="submit" value="确定修改"/></form>
<form action="${pageContext.request.contextPath}/student/list" method="GET">
    <input type="submit" value="返回主页">
</form>
</body>
</html>