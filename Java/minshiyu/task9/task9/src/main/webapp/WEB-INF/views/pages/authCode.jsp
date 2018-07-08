<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>


<div id="login_frame" align="center">
    <br><br><br><br><br><br><br>

    <form action="${pageContext.request.contextPath}/signup" method="get">
        <p><label class="label_input">手机号码</label><label>
            <input type="text" name="phoneNumber"
                   class="text_field" required="required" />
        </label></p><br>

        <div id="login_control">
            <button type="submit" id="btn_login">获取验证码</button>
        </div>
    </form>

</div>