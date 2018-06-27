<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" >
    <title>验证码</title>
    <h2>验证码</h2>
    <img border=0  src="<%=request.getContextPath()%>/logintest" id="imageMask" onclick="myReload()" style="cursor: pointer"><br/>
    <input type="text" id="signcode"/>
    <button value="提交" onclick="check()"  style="height: 20px;width: 60px"/>提交
</head>

<body>
    <script type="text/javascript" src="<%=request.getContextPath()%>/Static/js/jquery-3.2.1.min.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/Static/js/bootstrap.min.js"></script>
    <script type="text/javascript">
        console.log(document.getElementById("imageMask").src)
    //用于刷新验证码
    function myReload() {
        document.getElementById("imageMask").src = document.getElementById("imageMask").src + "?nocache=" + new Date().getTime();
    }
    function check() {
        var vcode = $('#signcode').val();
        console.log("vcode==>"+vcode)
        $.ajax({
            contentType : 'application/json',
            url: 'http://localhost:8080/check',
            type: 'GET',
            data: {"signcode": vcode,},
            dataType:"json",
            xhrFields: {
                withCredentials: true
            },
            success: function (JsonResult) {
                console.log(JsonResult)
                if(JsonResult.code==200){
                    window.location.href="success.html";
                }
            }
        })
    }
</script>
</body>
</html>