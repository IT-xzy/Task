<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<div id="login_frame" align="center">
    <br><br><br><br><br><br><br><br><br>
    <form method="post" action="${pageContext.request.contextPath}/signup">


        <p><label class="label_input">用户名</label><label>
            <input type="text" name="name"
                   class="text_field"/>
        </label></p>

        <p><label class="label_input">email</label><label>
            <input type="email" name="email"
                   class="text_field"/>
        </label></p>

        <p><label class="label_input">手机号码</label><label>
            <input type="text" name="phoneNumber"
                   class="text_field"/>
        </label></p>

        <p><label class="label_input">密码</label><label>
            <input type="password" name="password"
                   class="text_field"/>
        </label></p>


        <div id="login_control">
            <button type="submit" id="btn_login">注册</button>
        </div>
    </form>

</div>