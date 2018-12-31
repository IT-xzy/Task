<%@ taglib prefix="color" uri="http://www.springframework.org/tags/form" %>
<%@ include file="../include/include.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div style="margin: 5rem;">
    <div>
        <img src="${pageContext.request.contextPath}/imges/login-ad_03.png">
    </div>
    <div style="position: absolute;right: 19rem;top: 25rem;">
        <div style="font-size: 3rem;color: red;">信息：注册账号${json.get("msg")}</div>
        <form action="/Tiles/signupEmail" method="post">
            <div>
                <input style="margin-top: 2rem;height: 3rem;width: 31rem;" name="name" type="text" placeholder="请输入用户名">
            </div>
            <div>
                <input style="margin-top: 2rem;height: 3rem;width: 31rem;" name="email" type="text" placeholder="请输入邮箱">
            </div>
            <div>
                <input style="margin-top: 2rem;height: 3rem;width: 31rem;" name="pwd" type="password"
                       placeholder="请输入登录密码">
            </div>
            <div>
                <input style="color: white;background-color: blue;margin-top: 1rem;margin-left: 5rem;padding: 5px;height: 3rem;width: 6rem;"
                       type="submit" value="注册">
            </div>
        </form>
        <div>
            <a href="/Tiles/loginPage">去登录</a>
            <a href="/Tiles/signupPage">手机注册</a>
        </div>
    </div>
</div>
