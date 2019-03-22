<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/11/27
  Time: 14:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册页面</title>
</head>
<body>

<form action="${pageContext.request.contextPath}/login" method="post">
    name : <input  type="text" name="loginName"/><br>

    password : <input  type="password" name="pwd"/><br>
    <input type="submit" value="登陆"/>
    <input type="reset" value="取消">
    <%--<a  href="/doLogin"  >登陆</a>--%>
    <%--<a type="reset" href="/login">重置</a>--%>
</form>

<script>
    function doLogin() {
        var name = $("#name").val();
        if(name == ""){
            alert("用户名不能为空!");
            return false;
        }
        var pwd = $("#pwd").val();
        if(pwd == ""){
            alert("用户密码不能为空!");
            return false;
        }
        alert(ok);
        $.ajax()
    }
</script>





    <%--<table>--%>
        <%--<tr>--%>
            <%--<td>姓名</td>--%>
            <%--<td><form:input path="loginName"/> </td>--%>
            <%--<td><form:errors path="loginName" cssStyle="color: red"/> </td>--%>
        <%--</tr>--%>
        <%--<tr>--%>
            <%--<td>密码</td>--%>
            <%--<td><form:input path="loginPwd"/></td>--%>
            <%--<td><form:errors path="loginPwd" cssStyle="color: red"/> </td>--%>
        <%--</tr>--%>
        <%--<tr>--%>
            <%--<a href="/login" name="login"/>--%>
            <%--<input type="submit" value="登陆"/>--%>
        <%--</tr>--%>
        <%--<tr>--%>
            <%--<a href="/registration" name="registration"/>--%>
            <%--<input type="submit" value="注册"/>--%>
        <%--</tr>--%>
    <%--</table>--%>



</body>
</html>
