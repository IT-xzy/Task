<%--
  Created by IntelliJ IDEA.
  User: TF
  Date: 2018/5/8
  Time: 8:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang = "en">
<head>
    <form id ="form" name="form">
   手机号： <input id="phonenumber" name="phonenumber" type="text"> </br>
   验证码: <input id="phonecode"  name="phonecode"  type="text"> </br> <input type="button" id="getphonecode1" value="获取验证码" onclick="getphonecode(this)"/>
    <input type="button" id="login1" value="登陆" onclick="login()"/>&nbsp;<input type="reset" value="重置">
    </form>
</head>
<body>
<script type="text/javascript" src="<%=request.getContextPath()%>/Static/js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/Static/js/bootstrap.min.js"></script>
<script type="text/javascript">
    var countdown=60;
    function login() {
        $.ajax({
            contentType: 'application/x-www-form-urlencoded',
            url: 'http://120.131.8.132/phonelogin',
            type: 'POST',
            data: $('#form').serialize(),
            dataType: 'json',
            success:function (JsonResult) {
                if (!JsonResult.code == 0){
                    alert(JsonResult.message);
                }
                else {
                    alert("登陆成功");
                }
            }
        })
    }
    function getphonecode(obj) {
        var j = document.getElementById("phonenumber").value;
        $.ajax({
            contentType: 'application/json',
            url: 'http://120.131.8.132/phonecode',
            type: 'GET',
            data: {"phonenumber":j},
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
