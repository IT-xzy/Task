<%--
  Created by IntelliJ IDEA.
  User: TF
  Date: 2018/5/4
  Time: 15:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang = "en">
<head>
    <div id="form-div">
        <form id ="form">
            用户名:      <input id="userid" name="name" type="text"> </br>
            密码:        <input id="password" name="password" type="password"> <br>
            再次输入密码:<input id ="password2" type="text"> </br>
            邮箱         <input id="email" name="email" type="text"> </br>
            验证码：     <input id="emailcode"  name="emailcode"  type="text"> </br>
            <input type="button" id="getphonecode1" value="获取验证码" onclick="getemailcode(this)"/>
            <input type="button" id="register1" value="注册" onclick="register()"/>&nbsp;<input type="reset" value="重置">
        </form>
    </div>
</head>
<body>
<script type="text/javascript" src="<%=request.getContextPath()%>/Static/js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/Static/js/bootstrap.min.js"></script>
<script type="text/javascript">
    var countdown=60;
    function register() {
        $.ajax({
            contentType: 'application/x-www-form-urlencoded',
            url: 'http://120.131.8.132:80/emailregister',
            type: 'POST',
            data: $('#form').serialize(),
            dataType: 'json',
            success:function (JsonResult) {
                if (!JsonResult.code == 0){
                    alert(JsonResult.message);
                }
                else {
                    alert("注册成功");
                }
            }
        })
    }
    function getemailcode(obj) {
        var j = document.getElementById("email").value;
        $.ajax({
            contentType: 'application/json',
            url: 'http://120.131.8.132:80/emailcode',
            type: 'GET',
            data: {"email":j},
            dataType: 'json',
            success: function (JsonResult) {
                if (!JsonResult.code == 0) {
                    alert(JsonResult.message);
                }
            }
        })
        count(obj);
    }
    function count(obj) {
        if (countdown == 0) {
            obj.removeAttribute("disabled");
            obj.value = "获取验证码"
            countdown = 60;
            return;
        }
        else {
            obj.setAttribute("disabled", true);
            obj.value = "重新发送(" + countdown + ")";
            countdown--;
        }
        setTimeout(function () {
                count(obj)
            }
            ,1000)
    }
</script>
</body>
</html>