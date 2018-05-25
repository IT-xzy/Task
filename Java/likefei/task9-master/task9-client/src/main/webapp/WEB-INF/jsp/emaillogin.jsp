<%--
  Created by IntelliJ IDEA.
  User: TF
  Date: 2018/5/8
  Time: 8:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <form id="form">
        邮箱：<input id="email" name="email" type="text"> </br>
        密码：<input id="password" name="password" type="password"> </br>
        密码：<input id="password1" name="password1" type="password"> </br>
        邮箱验证码：<input id="emailcode"  name="emailcode"  type="text"> </br>
        图形验证码：<input id="signcode"name= "signcode"type="text"  > </br>  <img border=0  src="<%=request.getContextPath()%>/signcode" id="imageMask" onclick="Reload()" style="cursor: pointer"><br/>
        <input type="button" id="getphonecode1" value="获取验证码" onclick="getemailcode(this)"/>
        <input type="button" id="login1" value="登陆" onclick="login()"/>&nbsp;<input type="reset" value="重置">
    </form>
</head>
<body>
<script type="text/javascript" src="<%=request.getContextPath()%>/Static/js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/Static/js/bootstrap.min.js"></script>
<script type="text/javascript">
    //刷新验证码
    function Reload() {
        document.getElementById("imageMask").src = document.getElementById("imageMask").src+"?nocache="+new Date().getTime();
    }
    var countdown=60;
    function login() {
        $.ajax({
            contentType: 'application/x-www-form-urlencoded',
            url: 'http://120.131.8.132:80/emaillogin',
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
