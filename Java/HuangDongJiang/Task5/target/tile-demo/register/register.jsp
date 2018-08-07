<%--
  Created by IntelliJ IDEA.
  User: CH0918
  Date: 2018/7/19
  Time: 20:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<title>Registration</title>
<head>
    <script>
        function volidate() {
            if(document.getElementById("name")==""){
                window.alert("姓名不能为空")
                document.getElementById("name").focus();
                return false;
            }else if(document.getElementById("password")==""){
                window.alert("密码不能为空")
                document.getElementById("password").focus();
                return false;
            }
            return true;
        }
    </script>
</head>
<body>
    <form method="post" action="${pageContext.request.contextPath}/registration" onsubmit="return volidate()" >
        姓名：<input type="text" id="name" name="name" placeholder="姓名"
                  style="width:190px;height: 26px;margin-left: 39px;"><br>
        密码：<input type="password" id="password" name="password" placeholder="密码"
                  style="width:190px;height: 26px;margin-left: 39px;"><br>
        <input type="submit" value="注册">
    </form>
</body>

</html>

