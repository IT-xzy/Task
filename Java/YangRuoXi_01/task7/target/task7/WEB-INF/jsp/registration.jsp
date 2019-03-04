<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/11/28
  Time: 9:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%--<script>--%>
    <%--function  funb(event) {--%>
        <%--event.preventDefault();--%>
    <%--}--%>
<%--</script>--%>
</head>
<body>


<form action="${pageContext.request.contextPath}/registration" method="post">
    name : <input type="text" name="loginName"><br>
    password : <input type="password" name="pwd"><br>
        <br>
    <div style="position: absolute;top: 8rem;">
        <input type="submit" value="注册" ><input type="reset" value="重置">
    </div>
</form>

<form action="${pageContext.request.contextPath}/sendPhoneCode" method="post"  style="position: absolute;top: 4rem;">
    iphone : <input type="text" name="phone"><br>
    验证码 : <input type="text" name="phoneCode" >
    <input type="button" value="发送验证码" onclick="loadXMLDoc()" >
</form>

</body>
</html>
<script type="text/javascript">
    function loadXMLDoc() {
        var phone = $(".phone").val();
        var xhr = new XMLHttpRequest();
        xhr.open("POST", "/sendPhoneCode", true);
        xhr.setRequestHeader("content-type", "application/x-www-form-urlencoded");
        xhr.send("phone=" + phone);
    }
</script>