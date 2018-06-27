<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="ev" uri="/WEB-INF/timeTransferTag.tld"%>

<div id="login_frame" align="center">
    <br><br><br><br><br><br><br><br><br>
    <form method="post" action="${pageContext.request.contextPath}/login">


        <p><label class="label_input">用户名</label><label>
            <input type="text" name="account"
                   class="text_field"/>
        </label></p><br>

        <p><label class="label_input">密码</label><label>
            <input type="password" name="password"
                   class="text_field"/>
        </label></p><br>
        <a  href="${pageContext.request.contextPath}/forgetpassword">忘记密码？</a>
        <div id="login_control">
            <button type="submit" id="btn_login">登陆</button>
        </div>
    </form>


</div>

