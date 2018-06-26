<%--
  Created by IntelliJ IDEA.
  User: TF
  Date: 2018/5/3
  Time: 9:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang = "en">
<head>
    <div id="form-div">
    <form id ="form" name="form1" enctype="multipart/form-data">
    用户名:      <input id="userid" name="name" type="text"> </br>
    密码:        <input id="password" name="password" type="password"> </br>
    再次输入密码:<input id ="password2" type="password"> </br>
    手机号：     <input id="phonenumber" name="phonenumber" type="text"> </br>
        验证码：     <input id="phonecode"  name="phonecode"  type="text"> </br>
        头像上传：   <input id="photo" name="photo" type="file"> </br>
    <input type="button" id="getphonecode1" value="获取验证码" onclick="getphonecode(this)"/>
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
        var form = document.getElementById("form");
        var fd = new FormData(form);
        $.ajax({
            url: 'http://120.131.8.132/phoneregister',
            type: 'POST',
            data: fd,
            processData: false,
            contentType : false,
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

