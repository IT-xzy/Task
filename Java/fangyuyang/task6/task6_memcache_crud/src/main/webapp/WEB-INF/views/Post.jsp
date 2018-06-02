<%@ page contentType="text/html;charset=UTF-8" language="java"  pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>添加学生</title>
</head>
<body>

<h1>添加学生</h1>
<form action="" name="studentForm" >

    QQ：<input type="text" name="qq"><br>
    姓名：<input type="text" name="name"><br>
    修真类型：<input type="text" name="course"><br>
    预计入学时间：<input type="text" name="update_at"><br>
    开始学时间：<input type="text" name="create_at"><br>
    毕业院校：<input type="text" name="school"><br>
    线上学号：<input type="text" name="number"><br>
    日报链接：<input type="text" name="url"><br>
    立愿：<input type="text" name="target"><br>
    审核师兄：<input type="text" name="old_brother"><br>
    从何处知：<input type="text" name="from_where"><br>
    <input type="button" value="添加学生"
           onclick="addUser()">



</form>
<script type="text/javascript">
    function addUser() {
        var form = document.forms[0];
        form.action = "${pageContext.request.contextPath}/student";
        form.method = "post";
        form.submit();
    }
</script>

</body>
</html>