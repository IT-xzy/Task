<%@ page contentType="text/html;charset=UTF-8" language="java"  pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>编辑学生</title>

</head>
<body>

<h1>编辑学生</h1>

<form action="${pageContext.request.contextPath}/student" name="studentForm" method="post">
    <input type="hidden" name="_method" value="PUT"/>
            <input type="hidden" name="id" value="${student.id }" />
        QQ：<input type="text"  name="qq" value="${student.qq}"/>
        姓名：<input type="text"  name="name" value="${student.name}"/>
        修真类型：<input type="text" name="course" value="${student.course}"/>
        预计入学时间：<input type="text" name="update_at" value="${student.update_at}"/>
        开始学时间：<input type="text" name="create_at" value="${student.create_at}"/>
        毕业院校：<input type="text" name="school" value="${student.school}"/>
        线上学号：<input type="text" name="number" value="${student.number}"/>
        日报链接：<input type="text" name="url" value="${student.url}"/>
        立愿：<input type="text" name="target" value="${student.target}"/>
        审核师兄：<input type="text" name="old_brother" value="${student.old_brother}"/>
        从何处知：<input type="text" name="from_where" value="${student.from_where}"/>
        <input type="submit" value="提交">
</form>

</body>

</html>