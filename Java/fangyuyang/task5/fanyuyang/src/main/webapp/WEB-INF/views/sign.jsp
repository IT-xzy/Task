<%@ page contentType="text/html;charset=UTF-8" language="java"  pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>添加职业</title>
</head>
<body>

<h1>添加职业</h1>
<form action="" name="careerForm" >

    名字：<input type="text" name="name"><br>
    密码：<input type="text" name="passwordString"><br>
    头像：<input type="text" name="picture"><br>
    职业：<input type="text" name="career"><br>
    <input type="button" value="添加使用者"
           onclick="addUser()">


</form>
<script type="text/javascript">


    function addUser() {
        var form = document.forms[0];
        form.action = "${pageContext.request.contextPath}/doSign";
        form.method = "post";

        form.submit();
    }
</script>

</body>
</html>