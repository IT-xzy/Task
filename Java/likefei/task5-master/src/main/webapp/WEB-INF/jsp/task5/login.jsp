<%--
  Created by IntelliJ IDEA.
  User: TF
  Date: 2018/4/10
  Time: 8:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<script language="JavaScript">--%>
    <%--function isValidate(form){--%>
        <%--//得到用户输入的用户名和密码--%>
        <%--username=form.name.value;--%>
        <%--userpassword=form.password.value;--%>
        <%--//接下来先验证用户名--%>
        <%--//如果用户名的长度小于六--%>
        <%--if(username.length<6){--%>
            <%--alert("用户名的长度小于六。");--%>
            <%--form.name.focus();--%>
            <%--return false;--%>
        <%--}--%>

        <%--//如果用户名的长度大于8--%>
        <%--if(username.length>8){--%>
            <%--alert("用户名的长度大于八。");--%>
            <%--form.name.focus();--%>
            <%--return false;--%>
        <%--}--%>

        <%--//接下来验证口令--%>
        <%--//如果密码的长度小于六--%>
        <%--if(userpassword.length<6){--%>
            <%--alert("密码的长度小于六。");--%>
            <%--form.password.focus();--%>
            <%--return false;--%>
        <%--}--%>

        <%--//如果密码的长度大于8--%>
        <%--if(userpassword.length>8){--%>
            <%--alert("密码的长度大于八。");--%>
            <%--form.password.focus();--%>
            <%--return false;--%>
        <%--}--%>

        <%--//密码与用户名不能相等--%>
        <%--if(userpassword==username){--%>
            <%--alert("密码与用户名不能相等");--%>
            <%--form.password.focus;--%>
            <%--return false;--%>
        <%--}--%>
    <%--}--%>
<%--</script>--%>
<html lang = "en">
<head>
    <%--ajax请求--%>
    <meta charset="UTF-8">
    <title>登陆界面</title>
        <h2 align="center">登录界面</h2>
        <h2>验证码</h2>
        <img border=0  src="<%=request.getContextPath()%>/logintest" id="imageMask" onclick="myReload()" style="cursor: pointer"><br/>
        <div id="form-div">
            <form id ="form1" action="/login" type="post">
                <lable for="name">用户名</lable>:<input type="text" name="name" id="name"> </br>
                <label for="password">密码:</label> <input type="text"  name="password" id="password"> </br></br>
                <label for="signcode">验证码:</label><input type="text" name= "signcode" id="signcode"> </br></br>
                <p><input type="button" value="登录" onclick="check()">&nbsp;<input type="reset" value="重置"></p>
            </form>
        </div>
</head>

<body>
<script type="text/javascript" src="<%=request.getContextPath()%>/Static/js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/Static/js/bootstrap.min.js"></script>
<script type="text/javascript">
    //刷新验证码
    function myReload() {
        document.getElementById("imageMask").src = document.getElementById("imageMask").src+"?nocache="+new Date().getTime();
    }
    function check() {
        var params = $("#form1").serializeArray();
        var j = {};
        for (var item in params) {
            j[params[item].name] = params[item].value;
        }
        $.ajax({
            contentType:'application/json',
            url: 'http://localhost:8080/login',
            type:'POST',
            data: JSON.stringify(j),
            dataType:'json',
            xhrFields:{
                withCredentials:true
            },
            success:function(JsonResult){
                if (JsonResult.code==200){
                    window.location.href="http://localhost:8080/home"
                }
                else   alert(JsonResult.message);
            }
            }
        )
    }
</script>
<%-- onsubmit="return isValidate(form1)"--%>
<%--form表单提交--%>
<%--<form name=form1 action="/login" method="post">--%>
    <%--<table align="center">--%>
        <%--<tr>--%>
            <%--<td>用户ID：</td>--%>
            <%--<td><input type="text" name="name" value="${user.name}"></td>--%>
        <%--</tr>--%>
        <%--<tr>--%>
            <%--<td>密码：</td>--%>
            <%--<td><input type="text" name="password" value="${user.password}" ></td>--%>
        <%--</tr>--%>
        <%--<tr>--%>
            <%--<td><input type="reset" value="重置"></td>--%>
            <%--<td><input type="submit" value="登陆"></td>--%>
        <%--</tr>--%>
    <%--</table>--%>
<%--</form>--%>
</body>
</html>
