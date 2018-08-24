<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<title>Registration</title>
<head>
    <meta charset="UTF-8">
    <script>
        function volidate() {
            if (document.getElementById("name").value ==""||document.getElementById("name").value ==" ") {
                alert("姓名不能为空或者空格")
                document.getElementById("name").focus();
                return false;
            } else if (document.getElementById("password").value ==""||document.getElementById("password").value ==" ") {
                alert("密码不能为空或者空格")
                document.getElementById("password").focus();
                return false;
            }
            return true;
        }
    </script>
</head>
<body>
<h1>用户注册</h1><br/>
<form method="post" action="${pageContext.request.contextPath}/registration" onsubmit="return volidate()">
    用户名：<input type="text" id="name" name="name" placeholder="用户名"
               style="width: 190px;height: 26px;margin-left: 39px;"/><br/>
    密码：<input type="password" id="password" name="password" placeholder="密码"
              style="width: 190px;height: 26px;margin-top: 8px;margin-left: 54px"/><br/>
    <input type="submit" value="注册">
</form>
<a href="${pageContext.request.contextPath }/login/login.jsp">返回登录界面</a><br/>
</body>

</html>

