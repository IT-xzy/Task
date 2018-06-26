<%@ page import="com.fangyuyang.subsidiary.validateCode.ValidateCode" %>
<%@ page import="java.io.File" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<body>
<h1>添加职业</h1>
<form action="${pageContext.request.contextPath}/beforeDoSign"  method="post">

    密码：<input type="text" name="passwordString"><br>
    QQ：<input type="text" name="qq"><br>
    姓名：<input type="text" name="name"><br>
    邮箱：<input type="text" name="email"><br>
    修真类型：<input type="text" name="course"><br>
    毕业院校：<input type="text" name="school"><br>
    手机：<input type="text" name="mobile"><br>
    立愿：<input type="text" name="target"><br>
    审核师兄：<input type="text" name="oldBrother"><br>
    从何处知：<input type="text" name="fromWhere"><br>
    输入图形验证码：<input type="text" name="validateCode"><br>
   <h1><img  width="100" height="60" src= "${validatePicture}"/></h1>


    <form action="" method="post">
        <input type="submit" value="注册">
    </form>
</form>

<script type="text/javascript">


</script>

</body>
