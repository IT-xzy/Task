<%@ taglib prefix="color" uri="http://www.springframework.org/tags/form" %>
<%@ include file="../include/include.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div style="margin: 5rem;">
    <div>
        <img src="${pageContext.request.contextPath}/imges/login-ad_03.png">
    </div>
    <div style="position: absolute;right: 19rem;top: 25rem;">
        <div style="font-size: 3rem;color: red;">信息：注册账号${json.get("msg")}</div>
        <form action="/Tiles/signup" method="post">
            <div>
                <input style="margin-top: 2rem;height: 3rem;width: 31rem;" name="name" type="text" placeholder="请输入用户名">
            </div>
            <div>
                <input style="margin-top: 2rem;height: 3rem;width: 31rem;" name="phone" type="text" placeholder="请输入手机号"
                       class="phone">
            </div>
            <div>
                <input style="margin-top: 2rem;height: 3rem;width: 31rem;" name="pwd" type="password"
                       placeholder="请输入登录密码">
            </div>
            <div>
                <input style="margin-top: 2rem;height: 3rem;width: 31rem;" name="code" type="text"
                       placeholder="验证码"><input type="button" value="发送验证码" onClick="loadXMLDoc()">
            </div>
            <div>
                <input style="color: white;background-color: blue;margin-top: 1rem;margin-left: 5rem;padding: 5px;height: 3rem;width: 6rem;"
                       type="submit" value="注册">
            </div>
        </form>
        <div>
            <a href="/Tiles/loginPage">去登录</a>
            <a href="/Tiles/signEmailPage">邮箱注册</a>
        </div>
    </div>

</div>
<script src="https://cdn.bootcss.com/jquery/3.3.1/jquery.js"></script>
<script type="text/javascript">
    function loadXMLDoc() {
        var phone = $(".phone").val();
        var xhr = new XMLHttpRequest();
        xhr.open("POST", "/Tiles/signupPhone", true);
        xhr.setRequestHeader("content-type", "application/x-www-form-urlencoded");
        xhr.send("phone=" + phone);
    }
</script>
