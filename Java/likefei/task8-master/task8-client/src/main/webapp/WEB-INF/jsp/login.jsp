<%--
  Created by IntelliJ IDEA.
  User: TF
  Date: 2018/5/3
  Time: 9:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <form id ="form">
        用户名:      <input id="userid" name="name" type="text"> </br>
        密码:        <input id="password" name="password" type="password"> <br>
        再次输入密码:<input id ="password2" type="password"> </br>
        验证码：     <input id="signcode"name= "signcode"type="text"  > </br>  <img border=0  src="<%=request.getContextPath()%>/signcode" id="imageMask" onclick="Reload()" style="cursor: pointer"><br/>
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
            url: 'http://120.131.8.132/commonlogin',
            type: 'POST',
            data: $('#form').serialize(),
            dataType: 'json',
            success:function (JsonResult) {
                if (!JsonResult.code == 0){
                    alert(JsonResult.message);
                }
                else {
                    var str = JsonResult.data;
                    var obj =jQuery.parseJSON( str );
                    var id =obj.id;
                    alert("欢迎"+obj.name+"登陆");
                    window.location.href="/home?id="+id;
                }
            }
        })
    }
</script>
</body>
</html>
