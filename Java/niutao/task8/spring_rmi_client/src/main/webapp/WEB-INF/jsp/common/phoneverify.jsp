<%--
  Created by IntelliJ IDEA.
  User: Blue
  Date: 2018/1/31
  Time: 15:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>验证</title>
</head>
<body>
    <div>
    <form action="/phoneverify" method="post">
        <table>
            <tr><td>手机号</td><td><input type="text" name="phoneNumber" /></td><td>${shoujihao}</td></tr>
            <tr><td>验证码</td><td><input type="text" name="inputCode"  onkeyup="check()"></td><td>${yanzhengma}</td></tr>
            <tr><img src="/authcode" id="authImg"/><a href="#" onClick="window.location.reload()">看不清</a><br></tr>
            <tr><input type="submit" value="下一步"></tr>
        </table>


    </form>
    </div>
</body>

<%--<script>--%>
    <%--var xmlhttp;--%>
    <%--var url = null;--%>
    <%--function check(){--%>
        <%--var code = document.getElementById("code").value;--%>
        <%--url = "/authcodeajax?inputCode="+code;--%>
        <%--xmlhttp =new XMLHttpRequest();--%>
        <%--xmlhttp.onreadystatechange=checkResult; //响应函数--%>
        <%--xmlhttp.open("GET",url,true);   //设置访问的页面--%>
        <%--xmlhttp.send(null);  //执行访问--%>
    <%--}--%>
    <%--function checkResult(){--%>
        <%--if (xmlhttp.readyState==4 && xmlhttp.status==200)--%>
            <%--document.getElementById("checkResult").innerHTML=xmlhttp.responseText;--%>
    <%--}--%>
<%--</script>--%>
</html>
