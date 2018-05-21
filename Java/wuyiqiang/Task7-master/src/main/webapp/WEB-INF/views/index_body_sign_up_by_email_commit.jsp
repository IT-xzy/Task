<%--
  Created by IntelliJ IDEA.
  User: yiqia
  Date: 2018/3/26 0026
  Time: 9:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="container">
<h1>手机注册</h1>

<form action="authority/sign_up_by_phone/checking" name="phoneVerification" method="post">
    <input name="phone" type="tel" readonly="readonly" value="${phoneVerification.phone}"><br/>
    <input name="verificationCodeClient" type="text" placeholder="请输入验证码"><br/><br/>
    <button type="submit" id="login-button">注册</button>
</form>
    <br/>
    <br/>
    <br/>
    <br/>
</div>

