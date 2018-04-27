<%--
  Created by IntelliJ IDEA.
  User: TF
  Date: 2018/4/18
  Time: 20:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <img border=0  src="<%=request.getContextPath()%>/logintest" id="imageMask" onclick="myReload()" style="cursor: pointer"><br/>
    <input type="text" id="signcode"/> </br>
    <button value="提交" onclick="check()"  style="height: 20px;width: 60px"/>提交
</head>
<body>
<script type="text/javascript" src="<%=request.getContextPath()%>/Static/js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/Static/js/bootstrap.min.js"></script>
<script type="text/javascript">
    function check(){
        var vcode = $('#signcode').val();
        var b = {"name":"test11","password":"test12","signcode":vcode};
    $.ajax({
            contentType : 'application/json',
            url: 'http://localhost:8080/login',
            type:'POST',
            data: JSON.stringify({"name":"123456","password":"654321","signcode":vcode}),
            dataType:'json',
            xhrFields:{
                withCredentials:true
            },
            success:function(JsonResult){
                console.log(JsonResult.code)
                if (JsonResult.code==200){
                    window.location.href="success.html"
                }
            }
        }
    )
    }
</script>
</body>
</html>
