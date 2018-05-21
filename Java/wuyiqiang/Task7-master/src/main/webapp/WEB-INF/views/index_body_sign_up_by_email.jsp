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

<form action="authority/sign_up_by_phone/send_verification_code" name="phoneVerification" method="post">
    <input name="phone" type="tel" placeholder="请输入手机号码"><br/>
    <input name="password" type="text" placeholder="请输入密码"><br/><br/>
    <input name="passwordAgain" type="password" placeholder="请再次输入密码"><br/><br/>
    <%--<input name="verificationCode" type="text" placeholder="请输入验证码">--%>
    <button type="submit" id="sendVerificationCode-button">发送手机验证码</button><br/><br/>
    <%--<button type="submit" id="login-button">注册</button>--%>
</form>
    <br/>
    <br/>
    <br/>
    <br/>
</div>

