<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<header>
    <title>注册邮件发送</title>
</header>

<body>
<div id="main" style="margin:0 auto;width:500px;">
    <p>用户注册</p>

    <form id="reg" action="${pageContext.request.contextPath}/user/register" method="post">
        <P>
            用户名: <input type="text" name="username" id="username">
        </P>
        <p>
            E-mail：<input type="text" class="input" name="email" id="email">
        </p>
        <p>
            密 码：<input type="password" class="input" name="pwd" id="pwd">
        </p>
        <p>
            <input type="submit" class="btn" value="提交注册" >
        </p>
    </form>
</div>

</body>
</html>