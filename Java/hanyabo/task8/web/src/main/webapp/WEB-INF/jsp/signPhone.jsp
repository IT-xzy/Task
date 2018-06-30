<%@ page language="java" contentType="text/html; charset=utf-8"
pageEncoding="utf-8"%>


<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>


<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>手机号注册</title>
    <script>
        function doValidate() {

            var phoneNumReg = /^(1\d{10})$/;
            if(!phoneNumReg.test(document.forma.phone.value)) {
                alert('请填写正确手机号码!!');
                document.forma.phone.focus();
                return false;
            }

            if(document.forma.password.value != document.forma.passwordTwo.value){
                alert('两次密码不一致!!');
                document.forma.password.focus();
                return false;
            }
            return true;
        }

        function send(){

            if(document.forma.password.value != document.forma.passwordTwo.value){
                alert('两次密码不一致!!');
                document.forma.password.focus();
                return false;
            }

            // alert("发送验证码1");
            var un= document.getElementById("username");
            // alert("发送验证码"+phone);
            var number0= un.value;
            var ps= document.getElementById("password");
            // alert("发送验证码"+phone);
            var number1= ps.value;
            var ph= document.getElementById("phone");
            // alert("发送验证码"+phone);
            var number2= ph.value;

            // alert("发送验证码"+number);
            window.location.href="<%=path%>/user/sms.action?un="+number0+"&ps="+number1+"&ph="+number2;
            // alert("发送验证码");
            return true;
        }


    </script>

</head>
<body>

<c:if test="${param.errCode == 1}">
邮箱被占用<br/>
</c:if>
<c:if test="${param.errCode == 2}">
用户名被占用<br/>
</c:if>
<c:if test="${param.errCode == 3}">
手机号被占用<br/>
</c:if>
<c:if test="${param.errCode == 5}">
验证码不正确<br/>
</c:if>

<a href="/user/email">我要使用邮箱注册</a>


<form action="/user/insert" method="post" name="forma" onsubmit="return doValidate()">
    <input type="hidden" name="_method" value="PUT">

    用户名：<input type="text" name="username" id="username" value="${username}"/><br/>
    密码：<input type="text" name="password" id="password" value="${password}"/><br/>
    再次确认密码：<input type="text" name="passwordTwo" value="${password}"/><br/>

    手机号码：<input type="text" name="phone" id="phone" value="${phone}"/><br/>
    验证码：<input type="text" name="checkCode"/>
    <input type="button" value="发送验证码" onclick="send()"/>
    ${flag}${flag1}
    <%--<input type="button" value="发送验证码">--%>
    <br/>
    <input type="submit" value="注册">
</form>
</body>
</html>